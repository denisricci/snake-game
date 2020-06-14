import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Food {

    private Canvas food;

    public Food() {
        createFood();
        setRandomPosition();
    }

    private void createFood(){
        this.food = CanvasUtils.buildSquare(Color.YELLOW);
    }

    public void setRandomPosition(){
        this.food.setTranslateX(randomNumber(0, Config.WIDTH - Config.SQUARE_SIZE));
        this.food.setTranslateY(randomNumber(0, Config.HEIGHT - Config.SQUARE_SIZE));
    }

    private Integer randomNumber(Integer min, Integer max){
        int value = (int)(Math.random() * ((max - min) + 1)) + min;
        return value - (value % Config.SQUARE_SIZE);
    }

    public Canvas getFood() {
        return food;
    }

    public Integer getPositionX(){
        return (int)this.food.getTranslateX();
    }

    public Integer getPositionY(){
        return (int)this.food.getTranslateY();
    }
}
