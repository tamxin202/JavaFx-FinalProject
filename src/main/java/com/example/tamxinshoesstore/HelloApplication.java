package com.example.tamxinshoesstore;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    VBox productRoot = new VBox();
    TextField tfName = new TextField();

    TextField tfQuantity = new TextField();

    TextField tfPrice = new TextField();

    TextField tfType = new TextField();

    TextField tfImg = new TextField();

    @Override
    public void start(Stage stage) throws IOException {
        DBConnection dbConnection = new DBConnection();
        VBox root = new VBox();
        HBox hInsertProduct = new HBox();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(root);


        Button btnAdd = new Button("Add");
        tfName.setPromptText("Name");
        tfQuantity.setPromptText("Quantity");
        tfPrice.setPromptText("Price");
        tfType.setPromptText("Type");
        tfImg.setPromptText("Link Image");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dbConnection.insertProduct(new Products(tfName.getText(), Integer.parseInt(tfQuantity.getText()), Float.parseFloat(tfPrice.getText()), tfType.getText(), tfImg.getText()));
                tfName.clear();
                tfImg.clear();
                tfPrice.clear();
                tfQuantity.clear();
                tfType.clear();
                getThenDisplayProducts(productRoot, dbConnection);
            }
        });
        Button btnEdit = new Button("Update");
        btnEdit.setOnAction(event -> {
            dbConnection.updateProduct(new Products(tfName.getText(), Integer.parseInt(tfQuantity.getText()), Float.parseFloat(tfPrice.getText()), tfType.getText(),
                    tfImg.getText(),Integer.parseInt(tfName.getId())));
            tfName.clear();
            tfImg.clear();
            tfPrice.clear();
            tfQuantity.clear();
            tfType.clear();
            getThenDisplayProducts(productRoot, dbConnection);
        });
        hInsertProduct.getChildren().addAll(tfName, tfQuantity, tfPrice, tfType, tfImg, btnAdd,btnEdit);
        root.getChildren().addAll(hInsertProduct, productRoot);
        getThenDisplayProducts(productRoot, dbConnection);
        Scene scene = new Scene(scrollPane, 900, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    void displayProducts(DBConnection dbConnection, VBox root, List<Products> products) {
        root.getChildren().clear();
        for (int i = 0; i < products.size(); i++) {
            final int finialI = i;

            HBox productsBox = new HBox();
            Label lbId = new Label("" + products.get(i).id);
            Label lbName = new Label(products.get(i).name);
            Label lbType = new Label(products.get(i).type);
            Label lbQuan = new Label("" + products.get(i).quantity);

            Image image = new Image(products.get(i).image);
            ImageView imageView = new ImageView(image);
            //Setting the position of the image
            imageView.setX(50);
            imageView.setY(25);
            //setting the fit height and width of the image view
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            //Setting the preserve ratio of the image view
            imageView.setPreserveRatio(true);


            Label lbImg = new Label(products.get(i).image);
            Label lbPrice = new Label("" + products.get(i).price);
            //Delete
            Button btnDelete = new Button("Delete");
            btnDelete.setOnAction(actionEvent -> {
                System.out.println("Click delete " + products.get(finialI).id);
                dbConnection.deleteProduct(products.get(finialI).id);
                getThenDisplayProducts(root, dbConnection);
            });

            // Update
            Button btnUpdate = new Button("Update");
            btnUpdate.setOnAction(actionEvent -> {
                tfName.setText(String.valueOf((products.get(finialI).name)));
                tfName.setId("" + products.get(finialI).id);
                tfQuantity.setText(String.valueOf((products.get(finialI).quantity)));
                tfPrice.setText(String.valueOf((products.get(finialI).price)));
                tfType.setText(String.valueOf((products.get(finialI).type)));
                tfImg.setText(String.valueOf((products.get(finialI).image)));

            });
            productsBox.setSpacing(50);
            productsBox.getChildren().addAll(lbId, lbName, lbQuan, lbPrice, lbType, imageView, btnDelete, btnUpdate);
            root.getChildren().add(productsBox);
        }
    }

    private void getThenDisplayProducts(VBox root, DBConnection dbConnection) {
        List<Products> products = dbConnection.getProducts();
        displayProducts(dbConnection, root, products);
    }

    public static void main(String[] args) {
        launch();
    }
}