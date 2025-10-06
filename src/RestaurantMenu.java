
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author 6241246
 */
public class RestaurantMenu extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void start(Stage stage){
        GridPane root = new GridPane();
        
        Label lBeverage = new Label("Beverage:");
        root.add(lBeverage, 0, 0);
        Label lAppetizer = new Label("Appetizer:");
        root.add(lAppetizer, 0, 1);
        Label lMainCourse = new Label("Main Course:");
        root.add(lMainCourse, 0, 2);
        Label lDessert = new Label("Desser:");
        root.add(lDessert, 0, 3);
        
        
        ComboBox<String> beverageBox = new ComboBox<>();
        beverageBox.getItems().addAll("Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice");
        root.add(beverageBox, 1, 0);
        
        ComboBox<String> appetizerBox = new ComboBox<>();
        appetizerBox.getItems().addAll();
        root.add(appetizerBox, 1, 1);
        
        ComboBox<String> mainCourseBox = new ComboBox<>();
        root.add(mainCourseBox, 1, 2);
        
        ComboBox<String> dessertBox = new ComboBox<>();
        root.add(dessertBox, 1, 3);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Restaurant Billing App");
        stage.show();
    }
    
}
