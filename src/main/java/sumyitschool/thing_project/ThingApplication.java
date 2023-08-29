    package sumyitschool.thing_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sumyitschool.thing_project.controller.ThingController;
import sumyitschool.thing_project.model.ThingIO;

import java.io.File;
import java.io.IOException;

public class ThingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ThingApplication.class.getResource("thing-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        ThingIO thingIO = new ThingIO();
        thingIO.readThing(new File("src/main/resources/sumyitschool/thing_project/thing.txt"));
        ThingController thingController = fxmlLoader.getController();
        thingController.serThingsTable(thingIO.getThing());
        stage.setTitle("Thing Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}