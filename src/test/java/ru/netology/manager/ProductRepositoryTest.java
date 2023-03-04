package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product one = new Book(1, "Азбука", 500, "Лев Толстой");
    Product two = new Book(2, "Живой труп", 600, "Лев Толстой");
    Product three = new Book(3, "Изучаем Java", 1_000, "Берт Бейтс и Кэти Сьерра");
    Product four = new Smartphone(4, "Mi", 30_000, "Xiaomi");
    Product fife = new Smartphone(5, "Samsung", 60_000, "Samsung");
    Product six = new Smartphone(6, "Mi Redmi", 120_000, "Xiaomi");
    Product seven = new Product(7, "Продукт", 100);

    @BeforeEach
    public void addProducts() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(fife);
        repo.save(six);
        repo.save(seven);
    }

    @Test
    public void addProductsAndFindAll() {

        Product[] expected = new Product[]{one, two, three, four, fife, six, seven};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findById() {

        Product expected = two;
        Product actual = repo.findById(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByUnCorrectId() {

        Product actual = repo.findById(14);

        Assertions.assertEquals(null, actual);
    }

    @Test
    public void removeByExistingId() {

        repo.removeById(4);

        Product[] expected = {one, two, three, fife, six, seven};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNonExistingId() {

        repo.removeById(14);

        Product[] expected = {one, two, three, four, fife, six, seven};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProduct() {

        repo.removeById(four.getId());

        Product[] expected = {one, two, three, fife, six, seven};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
}
