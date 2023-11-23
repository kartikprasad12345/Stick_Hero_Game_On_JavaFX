package com.example.javaapp1;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Group;
import java.io.FileInputStream;
import java.io.InputStream;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //aa
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Background.fxml"));
////        prefHeight="542.0" prefWidth="450.0"
//        Scene scene = new Scene(fxmlLoader.load(), 542, 451);
//        primaryStage.setTitle("Stick Hero");
//        Image icon=new Image("unnamed.png");
//        primaryStage.getIcons().add(icon);
//        primaryStage.setHeight(575);
//        primaryStage.setWidth(464);
//        primaryStage.setResizable(false);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//        StackPane root = new StackPane(); // TLC (Top Layer Container) a root container for all other components, which in your case is the Button
//        Button button = new Button("Go To Second Form"); // the button
//        Button btn1=new Button("Play");
//        final ImageView selim=new ImageView();
//        Image image1=new Image(HelloApplication.class.getResourceAsStream("C:\\Users\\Kartik prasad\\OneDrive\\Desktop\\unnamed.png"));
//        selim.setImage(image1);
//        root.getChildren().addAll(selim);
//        root.getChildren().add(btn1);
//        root.getChildren().add(button); // add the button to the root
//        Scene scene = new Scene(root, 500,500); // create the scene and set the root, width and height
//
//        primaryStage.setScene(scene); // set the scene
//        primaryStage.setTitle("First Form");
//        primaryStage.show();
//        btn1.setOnAction(e->{
//            //primaryStage.close(); // you can close the first stage from the beginning
//
//            // create the structure again for the second GUI
//            // Note that you CAN use the previous root and scene and just create a new Stage
//            //(of course you need to remove the button first from the root like this, root.getChildren().remove(0); at index 0)
//            StackPane root2 = new StackPane();
//            Label label = new Label("Playing here");
//            root2.getChildren().add(label);
//            Scene secondScene = new Scene(root2, 200,100);
//            Stage secondStage = new Stage();
//            secondStage.setScene(secondScene); // set the scene
//            secondStage.setTitle("Second Form");
//            secondStage.show();
////            primaryStage.close(); // close the first stage (Window)
//        });
//
//        // add action listener, I will use the lambda style (which is data and code at the same time, read more about it in Oracle documentation)
//        button.setOnAction(e->{
//            //primaryStage.close(); // you can close the first stage from the beginning
//
//            // create the structure again for the second GUI
//            // Note that you CAN use the previous root and scene and just create a new Stage
//            //(of course you need to remove the button first from the root like this, root.getChildren().remove(0); at index 0)
//            StackPane root2 = new StackPane();
//            Label label = new Label("Your are now in the second form");
//            root2.getChildren().add(label);
//            Scene secondScene = new Scene(root2, 200,100);
//            Stage secondStage = new Stage();
//            secondStage.setScene(secondScene); // set the scene
//            secondStage.setTitle("Second Form");
//            secondStage.show();
////            primaryStage.close(); // close the first stage (Window)
//        });
//        InputStream stream = new FileInputStream("C:\\Users\\Kartik prasad\\OneDrive\\Desktop\\unnamed.png");
//        Image image = new Image(stream);
//        //Creating the image view
//        ImageView imageView = new ImageView();
//        //Setting image to the image view
//        imageView.setImage(image);
//        //Setting the image view parameters
//        imageView.setX(10);
//        imageView.setY(10);
//        imageView.setFitWidth(500);
//        imageView.setPreserveRatio(true);
//        //Setting the Scene object
//        Group root = new Group(imageView);
//        Scene scene = new Scene(root, 595, 370);
//        primaryStage.setTitle("Displaying Image");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("BackgroundGame.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root, 300, 200);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("JavaFX Rectangle Example");
//        primaryStage.show();
        Scene scene = new Scene(fxmlLoader.load(), 542, 451);
        primaryStage.setTitle("Stick Hero");
        Image icon=new Image("unnamed.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setHeight(575);
        primaryStage.setWidth(464);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}