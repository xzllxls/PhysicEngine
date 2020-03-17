package RunTime;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class UI extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Text text = new Text(10, 40, "Hello");

        Scene scene = new Scene(new Group(text), AppConf.width, AppConf.height);

        primaryStage.setTitle(AppConf.title);
        primaryStage.setScene(scene);
        primaryStage.show();
        App.appQuit();
    }

}
