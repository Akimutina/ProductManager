package ru.netology.manager;

public class Product {
    protected int id;
    protected String name;
    protected int price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean matches(String search) {
        return getName().contains(search);
    }

}

