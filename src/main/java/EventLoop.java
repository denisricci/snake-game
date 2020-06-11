import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class EventLoop {

    private Scenario scenario;
    private KeyCode currentDirection;
    private Snake snake;

    public EventLoop(Scenario scenario, Snake snake) {
        this.scenario = scenario;
        this.snake = snake;
        this.scenario.setKeyPressed(e->{
            KeyCode keyPressed = e.getCode();

            if(keyPressed.equals(KeyCode.RIGHT)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.LEFT)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.UP)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.DOWN)){
                currentDirection = keyPressed;
            }
        });

        starLoop();
    }

    private void starLoop(){
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(200), e -> {
            Integer positionX = snake.getPositionX();
            Integer positionY = snake.getPositionY();

            if(KeyCode.RIGHT.equals(currentDirection)){
                positionX = positionX + Config.SQUARE_SIZE;
            }

            if(KeyCode.LEFT.equals(currentDirection)){
                positionX = positionX - Config.SQUARE_SIZE;
            }

            if(KeyCode.UP.equals(currentDirection)){
                positionY = positionY - Config.SQUARE_SIZE;
            }

            if(KeyCode.DOWN.equals(currentDirection)){
                positionY = positionY + Config.SQUARE_SIZE;
            }

            this.snake.setPosition(positionX, positionY);

        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
    }

}
