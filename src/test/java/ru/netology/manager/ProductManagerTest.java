package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product one = new Book(1, "Азбука", 500, "Лев Толстой");
    Product two = new Book(2, "Живой труп", 600, "Лев Толстой");
    Product three = new Book(3, "Изучаем Java", 1_000, "Берт Бейтс и Кэти Сьерра");
    Product four = new Smartphone(4, "Mi", 30_000, "Xiaomi");
    Product fife = new Smartphone(5, "Samsung", 60_000, "Samsung");
    Product six = new Smartphone(6, "Mi Redmi", 120_000, "Xiaomi");
    Product seven = new Product(7, "Продукт общий", 100);

    @BeforeEach
    public void addProducts() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(fife);
        manager.add(six);
        manager.add(seven);
    }

    @Test
    public void addProductsAndGetIts() {

        Product[] expected = new Product[]{one, two, three, four, fife, six, seven};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchBySmartphoneFewName() {
        Product[] results = manager.searchBy("Mi");

        Product[] expected = new Product[]{four, six};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByNoExistingSmartphoneName() {
        Product[] results = manager.searchBy("Мобилка");

        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByExistingBookName() {
        Product[] results = manager.searchBy("Живой труп");

        Product[] expected = new Product[]{two};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByNoExistingBookName() {
        Product[] results = manager.searchBy("Журнал");

        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByPartOfName() {
        Product[] results = manager.searchBy("общий");

        Product[] expected = new Product[]{seven};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByAuthor() {
        Product[] results = manager.searchBy("Лев Толстой");

        Product[] expected = {one, two};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByManufacturer() {
        Product[] results = manager.searchBy("Xiaomi");

        Product[] expected = {four, six};
        Assertions.assertArrayEquals(expected, results);
    }
}
