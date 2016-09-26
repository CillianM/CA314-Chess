package dcu.ie.chessapp.pieces;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Knight implements ChessPiece {
    int id;
    int type;
    Point currentPosition;
    public Knight(int id)
    {
        if(id < 200)
            type = 1;
        else
            type = 2;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Knight " + id;
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


        possibleMoves.add(new Point(currentPosition.x+2, currentPosition.y+1));
        possibleMoves.add(new Point(currentPosition.x+2, currentPosition.y-1));
        possibleMoves.add(new Point(currentPosition.x-2, currentPosition.y-1));
        possibleMoves.add(new Point(currentPosition.x-2, currentPosition.y+1));


        possibleMoves.add(new Point(currentPosition.x-1, currentPosition.y+2));
        possibleMoves.add(new Point(currentPosition.x+1, currentPosition.y+2));
        possibleMoves.add(new Point(currentPosition.x+1, currentPosition.y-2));
        possibleMoves.add(new Point(currentPosition.x-1, currentPosition.y-2));


        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 3;
    }

    @Override
    public int returnType() {
        return type;
    }
}
