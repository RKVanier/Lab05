//https://github.com/RKVanier/Lab05/tree/task2
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restaurantbill;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Rayan
 */
public class RestaurantBill extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
    @Override
    public void start(Stage stage){
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        
        Label lBeverage = new Label("Beverage:");
        root.add(lBeverage, 0, 0);
        Label lAppetizer = new Label("Appetizer:");
        root.add(lAppetizer, 0, 1);
        Label lMainCourse = new Label("Main Course:");
        root.add(lMainCourse, 0, 2);
        Label lDessert = new Label("Desser:");
        root.add(lDessert, 0, 3);
        
        
        ComboBox<String> beverageBox = new ComboBox<>();
        beverageBox.setPrefWidth(150);
        beverageBox.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        root.add(beverageBox, 1, 0);
        
        ComboBox<String> appetizerBox = new ComboBox<>();
        appetizerBox.setPrefWidth(150);
        appetizerBox.getItems().addAll("Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa");
        root.add(appetizerBox, 1, 1);
        
        ComboBox<String> mainCourseBox = new ComboBox<>();
        mainCourseBox.setPrefWidth(150);
        mainCourseBox.getItems().addAll("Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club", "Shrimp Scampi", "Pasta", "Fish and Chips");
        root.add(mainCourseBox, 1, 2);
        
        ComboBox<String> dessertBox = new ComboBox<>();
        dessertBox.setPrefWidth(150);
        dessertBox.getItems().addAll("Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp");
        root.add(dessertBox, 1, 3);
        
        Slider tipSlider = new Slider(0, 20, 0);
        tipSlider.setShowTickMarks(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setShowTickLabels(true);
        tipSlider.setSnapToTicks(true);
        root.add(tipSlider, 0, 4);
        
        Label result = new Label();
        Button calculatebtn = new Button("Calculate");
        Button clearbtn = new Button("Clear");
        HBox hbbtn = new HBox(10, calculatebtn, clearbtn);
        root.add(hbbtn, 2, 5);
        root.add(result, 1, 5);
        result.setAlignment(Pos.CENTER_LEFT);
        hbbtn.setAlignment(Pos.TOP_RIGHT);
        
        calculatebtn.setOnAction(e -> {
            double total = 0;
            double subtotal = 0;
            double tip = tipSlider.valueProperty().get() / 100;
            
            if(beverageBox.getSelectionModel().getSelectedItem() != null) {
                switch(beverageBox.getSelectionModel().getSelectedItem()) {
                    case "Coffee" : subtotal += 2.50; break;
                    case "Tea" : subtotal += 2.00; break;
                    case "Soft Drink" : subtotal += 1.75; break;
                    case "Water" : subtotal += 2.95; break;
                    case "Milk" : subtotal += 1.5; break;
                    case "Juice" : subtotal += 2.5; break;
                }
            }
            
            if(appetizerBox.getSelectionModel().getSelectedItem() != null) {
                switch(appetizerBox.getSelectionModel().getSelectedItem()) {
                    case "Soup" : subtotal += 4.50; break;
                    case "Salad" : subtotal += 3.75; break;
                    case "Spring Rolls" : subtotal += 5.25; break;
                    case "Garlic Bread" : subtotal += 3.00; break;
                    case "Chips and Salsa" : subtotal += 6.95; break;
                }
            }
            
            if(mainCourseBox.getSelectionModel().getSelectedItem() != null) {
                switch(mainCourseBox.getSelectionModel().getSelectedItem()) {
                    case "Steak" : subtotal += 15.00; break;
                    case "Grilled Chicken" : subtotal += 13.50; break;
                    case "Chicken Alfredo" : subtotal += 13.95; break;
                    case "Turkey Club" : subtotal += 11.90; break;
                    case "Shrimp Scampi" : subtotal += 18.99; break;
                    case "Pasta" : subtotal += 11.75; break;
                    case "Fish and Chips" : subtotal += 12.25; break;
                }
            }
            
            if(dessertBox.getSelectionModel().getSelectedItem() != null) {
                switch(dessertBox.getSelectionModel().getSelectedItem()) {
                    case "Apple Pie" : subtotal += 5.95; break;
                    case "Carrot Cake" : subtotal += 4.50; break;
                    case "Mud Pie" : subtotal += 4.75; break;
                    case "Pudding" : subtotal += 3.25; break;
                    case "Apple Crisp" : subtotal += 5.98; break;
                }
            }
            
            tip *= subtotal;
            total = (subtotal * 1.14975) + tip; 
            result.setText("Subtotal : " + String.format("%.2f",subtotal) + " Tip : " + String.format("%.2f",tip) + " Total : " + String.format("%.2f",total));
        });
        
        clearbtn.setOnAction(e -> {
            result.setText("");
            beverageBox.getSelectionModel().clearSelection();
            appetizerBox.getSelectionModel().clearSelection();
            mainCourseBox.getSelectionModel().clearSelection();
            dessertBox.getSelectionModel().clearSelection();
            tipSlider.setValue(0);
        });
       
        Scene scene = new Scene(root);
        stage.setMinHeight(300);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.setTitle("Restaurant Billing App");
        stage.show();
    }  
}