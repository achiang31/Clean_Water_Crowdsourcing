package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        primaryStage.setTitle("Clean Water Application");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();

    }

    /**
     * Method to run the Water Application
     * @param args Argument array passed in when calling main method
     */
    public static void main(String[] args) {
        launch(args);
    }
}



//org.hibernate:hibernate-core:5.2.4.Final
//that line should go in the gradle file, if we have one; it makes Hibernate a dependency of this project
