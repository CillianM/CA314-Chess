import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */



public interface ChessPiece {

    public ArrayList<Point> calculateMoves(Point position);

    public int returnPointValue();

}
