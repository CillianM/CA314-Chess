import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Rook implements ChessPiece {


    public Rook() {}

    public ArrayList<Point> calculateMoves(Point position)
    {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        for(int i = 0; i <8; i++)
        {
            possibleMoves.add(new Point(position.x,i));
            possibleMoves.add(new Point(i,position.y));
        }

        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 5;
    }
}
