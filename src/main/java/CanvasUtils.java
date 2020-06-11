import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CanvasUtils {

    public static Canvas buildSquare(Paint color){
        Canvas square = new Canvas(Config.SQUARE_SIZE, Config.SQUARE_SIZE);
        GraphicsContext gc = square.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0,0,Config.SQUARE_SIZE, Config.SQUARE_SIZE);
        return square;
    }

}
