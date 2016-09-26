package dcu.ie.chessapp.pieces;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */



public interface ChessPiece {

    public ArrayList<Point> calculateMoves();

    public int returnPointValue();

    public int returnType();

    public Point returnCurrentPosition();

    public void updateCurrentPosition(Point p);

}
