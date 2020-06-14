import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Snake snake = new Snake();
        Food food = new Food();
        Scenario scenario = new Scenario(primaryStage, snake, food);
        EventLoop eventLoop = new EventLoop(scenario, snake, food);
    }
}
