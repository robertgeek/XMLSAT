package mx.com.robertgeek.ui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author robert
 */
public class Main extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        PanelPrincipal panePrincipal = new PanelPrincipal();

        stage.setTitle("Convertidor XML-CFDI a CSV");
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.centerOnScreen();

        ((Group) scene.getRoot()).getChildren().addAll(panePrincipal);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
