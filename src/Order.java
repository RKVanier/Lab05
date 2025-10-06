/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author 6241246
 */
public class Order extends Application{

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        HBox hb = new HBox(15);
        root.add(hb, 0, 0);
        hb.setAlignment(Pos.CENTER);
        
        Label lstyle = new Label("Select Bag Style:");
        ListView<String> lv = new ListView<>();
        lv.getItems().addAll("Full decorative", "Beaded", "Pirate Design", "Fringed", "Fringed", "Plain");
        lv.setPrefSize(200, 140);
        hb.getChildren().addAll(lstyle, lv);
        
        Label lquant = new Label("Select Quantity:");
        ComboBox<Integer> cb = new ComboBox<>();
        cb.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        hb.getChildren().addAll(lquant, cb);
        
        Label result = new Label();
        Button orderbtn = new Button("Place Order");
        Button clearbtn = new Button("Clear Selections");
        HBox hbbtn = new HBox(10, result, orderbtn, clearbtn);
        root.add(hbbtn, 1, 5);
        hbbtn.setAlignment(Pos.TOP_RIGHT);
        
        RadioButton radio1 = new RadioButton("Small");
        RadioButton radio2 = new RadioButton("Medium");
        RadioButton radio3 = new RadioButton("Large");
        ToggleGroup radioGroup =  new ToggleGroup();
        radio1.setToggleGroup(radioGroup);
        radio2.setToggleGroup(radioGroup);
        radio3.setToggleGroup(radioGroup);
        VBox vb = new VBox(10, radio1, radio2, radio3);
        hb.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER_LEFT);
        
        orderbtn.setOnAction(e -> {
            String style = lv.getSelectionModel().getSelectedItem();
            int quantity = cb.getValue();
            RadioButton a = (RadioButton) radioGroup.getSelectedToggle();
            result.setText("You ordered " + quantity + " " + a.getText() + " " + style + ".");
        
        });
        
        clearbtn.setOnAction(e -> {
            result.setText("");
            lv.getSelectionModel().clearSelection();
            cb.getSelectionModel().clearSelection();
            radioGroup.selectToggle(null);
        });
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Order App");
        stage.show();
    } 
}