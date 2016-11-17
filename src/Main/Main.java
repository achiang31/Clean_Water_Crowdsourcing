package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * main function to run the application
 */
@SuppressWarnings("ChainedMethodCall")
public class Main extends Application {

    @SuppressWarnings("MagicNumber")
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/welcome.fxml"));
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
