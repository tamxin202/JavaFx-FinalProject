package com.example.tamxinshoesstore;

public class Products {
    int id;
    public String name;
    public int quantity;
    public float price;

    public Products(String name, int quantity, float price, String type, String image, int id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.image=image;
        this.id=id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String type;
    public String image;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products(int id, String name, int quantity, float price, String type, String image) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price= price;
        this.type = type;
        this.image=image;
    }
    public Products (String name, int quantity, float price, String type, String image) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.image=image;
    }

}
