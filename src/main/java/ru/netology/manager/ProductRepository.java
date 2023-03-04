package ru.netology.manager;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            System.out.println("Продукт с заданным id не найден");
            return;
        }

        Product[] tmp = new Product[items.length - 1];
        int copyindex = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[copyindex] = product;
                copyindex++;
            }
            items = tmp;
        }
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] getItems() {
        return items;
    }

}
