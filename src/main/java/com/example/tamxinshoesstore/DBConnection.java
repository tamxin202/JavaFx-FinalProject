package com.example.tamxinshoesstore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    public class DBConnection {
        private static final String URL = "jdbc:mysql://localhost/shoes_store";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";
        private static Connection connection;

        DBConnection() {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Connect successfully!!!");
            } catch(SQLException e){
                connection=null;
                System.out.println(e);
            }

        }
//        public List<Products> getProducts(){
//            ArrayList<Products> products = new ArrayList<>();
//            String sql = "SELECT * FROM product";
//            try {
//                ResultSet results = connection.prepareStatement(sql).executeQuery();
//                while (results.next()){
//                    Products products = new Products(
//                            results.getInt("id"),
//                            results.getNString("pr_name"),
//                            results.getInt("quantity"),
//                            results.getFloat("price"),
//                            results.getNString("type"),
//                            results.getNString("image")
//                    );
//                    products.add(products);
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//            return products;
//        }
public List<Products> getProducts(){
    ArrayList<Products> products = new ArrayList<>();
    try{
        ResultSet result = connection.prepareStatement("SELECT * FROM product").executeQuery();
        while (result.next()){
            int id =result.getInt("id");
            String name = result.getNString("pr_name");
            int quantity = result.getInt("quantity");
            float price = result.getFloat("price");
            String type = result.getNString("type");
            String image = result.getNString("image");
            System.out.println(id);
            System.out.println(name);
            System.out.println(quantity);
            System.out.println(price);
            System.out.println(type);
            System.out.println(image);

            products.add(new Products(id, name, quantity, price,type,image));

        }
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    return products;
}
        public void insertProduct(Products products) {
            String sql = "INSERT INTO product(pr_name,quantity,price,type,image) VALUES('" + products.name + "'," +
                    " " + products.quantity + ", " +products.price +",'" + products.type + "', '" + products.image + "')";
            System.out.println(sql);
            try {
                connection.prepareStatement(sql).executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public void deleteProduct(int id){
            String sql ="DELETE from product where id=" + id;
            System.out.println(sql);
            try {
                connection.prepareStatement(sql).executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
       public void updateProduct(Products products){
            String sql = "UPDATE product SET pr_name = '"+ products.name +"', quantity = '"+products.quantity+"', price = '"+products.price+"', type = '"+products.type+"', image = '" +products.image+"' WHERE id = "+ products.id;
            System.out.println(sql);
            try {
                connection.prepareStatement(sql).executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }


