import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Snake snake = new Snake();
        Scenario scenario = new Scenario(primaryStage, snake);
        EventLoop eventLoop = new EventLoop(scenario, snake);
    }
}
