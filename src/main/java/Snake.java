import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class Snake {

    private Canvas head;

    public Snake(){
        createSnake();
    }

    private void createSnake(){
        this.head = CanvasUtils.buildSquare(Color.BLUE);
        this.head.setTranslateX(Config.WIDTH/2 - Config.SQUARE_SIZE);
        this.head.setTranslateY(Config.HEIGHT/2 - Config.SQUARE_SIZE);
    }

    public Canvas getHead() {
        return head;
    }

    public Integer getPositionX(){
        return (int)this.head.getTranslateX();
    }

    public Integer getPositionY(){
        return (int)this.head.getTranslateY();
    }

    public void setPosition(Integer x, Integer y){
        this.head.setTranslateX(x);
        this.head.setTranslateY(y);

    }


}
