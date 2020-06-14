import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class EventLoop {

    private Scenario scenario;
    private KeyCode currentDirection;
    private Snake snake;
    private Timeline timeline;
    private Food food;

    public EventLoop(Scenario scenario, Snake snake, Food food) {
        this.scenario = scenario;
        this.snake = snake;
        this.food = food;
        this.scenario.setKeyPressed(e->{
            KeyCode keyPressed = e.getCode();

            if(keyPressed.equals(KeyCode.RIGHT) && !KeyCode.LEFT.equals(currentDirection)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.LEFT)&& !KeyCode.RIGHT.equals(currentDirection)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.UP) && !KeyCode.DOWN.equals(currentDirection)){
                currentDirection = keyPressed;
            }

            if(keyPressed.equals(KeyCode.DOWN)&& !KeyCode.UP.equals(currentDirection)){
                currentDirection = keyPressed;
            }
        });

        starLoop();
    }

    public void starLoop(){
        timeline = new Timeline();
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

            if (    positionX < 0 ||
                    positionY < 0 ||
                    positionX > Config.WIDTH - Config.SQUARE_SIZE ||
                    positionY > Config.HEIGHT - Config.SQUARE_SIZE ||
                    this.snake.checkColision(positionX, positionY)){

                gameOver();

            }else{

                if(positionX.equals(food.getPositionX()) && positionY.equals(food.getPositionY())){
                    this.food.setRandomPosition();
                    this.snake.eat(this.scenario);
                }

                this.snake.setPosition(positionX, positionY);
            }

        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
    }

    public void gameOver(){
        this.timeline.stop();
        this.currentDirection=null;
        this.snake.die();
        this.scenario.showGameOver(this);
    }

}
