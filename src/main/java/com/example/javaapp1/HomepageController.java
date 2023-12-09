package com.example.javaapp1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController{

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BackgroundGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLoadGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("backgroundgame1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    @FXML
//    public void Deserialize() {
//        try{
//            ObjectInputStream f=new ObjectInputStream(new FileInputStream("C:\\Users\\ayush\\Desktop\\javaapp1\\src\\main\\java\\com\\example\\javaapp1\\ps.txt"));
//            PlayerStats pstemp=(PlayerStats) f.readObject();
//            ObjectOutputStream f1=new ObjectOutputStream(new FileOutputStream("C:\\Users\\ayush\\Desktop\\javaapp1\\src\\main\\java\\com\\example\\javaapp1\\ps.txt"));
//            f1.writeObject(pstemp);
//        }catch(EOFException e){
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void setExitButton(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're about to quit!");
        alert.setContentText("Do you really want to quit the game?");
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out");
            stage.close();
        }
    }
}










