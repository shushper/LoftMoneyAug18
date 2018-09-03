package com.shushper.loftmoneyaug18;

public class Item {

    public static final String TYPE_EXPENSE = "expense";
    public static final String TYPE_INCOME = "income";

    private int id;
    private String name;
    private int price;


    public Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
