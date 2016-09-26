package dcu.ie.chessapp.pieces;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Bishop implements ChessPiece {

    int id;
    int type;
    Point currentPosition;
    public Bishop(int id)
    {
        if(id < 200)
            type = 1;
        else
            type = 2;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bishop " + id;
    }

    @Override
    public int returnPointValue() {

        return 3;
    }

    @Override
    public int returnType() {
        return type;
    }

    @Override
    public Point returnCurrentPosition() {
        return currentPosition;
    }

    @Override
    public void updateCurrentPosition(Point p) {
        currentPosition = p;
    }

    @Override
    public ArrayList<Point> calculateMoves() {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        int x = 1;
        int y = 1;

        while (x < 8 && y < 8)
        {
            possibleMoves.add(new Point(currentPosition.x+x,currentPosition.y+y));
            x++;y++;
        }

        x =1;
        y = 1;

        while (x > -1 && y > -1)
        {
            possibleMoves.add(new Point(currentPosition.x-x,currentPosition.y-y));
            x--;y--;
        }

        return possibleMoves;
    }
}
