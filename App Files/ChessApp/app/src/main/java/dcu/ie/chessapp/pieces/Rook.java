package dcu.ie.chessapp.pieces;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Rook implements ChessPiece {


    int id;
    int type;
    Point currentPosition;
    public Rook(int id)
    {
        if(id < 200)
            type = 1;
        else
            type = 2;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Rook " + id;
    }

    @Override
    public Point returnCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void updateCurrentPosition(Point p) {
        currentPosition = p;
    }

    public ArrayList<Point> calculateMoves()
    {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        for(int i = 0; i <8; i++)
        {
            possibleMoves.add(new Point(currentPosition.x,i));
            possibleMoves.add(new Point(i,currentPosition.y));
        }

        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 5;
    }

    @Override
    public int returnType() {
        return type;
    }
}
