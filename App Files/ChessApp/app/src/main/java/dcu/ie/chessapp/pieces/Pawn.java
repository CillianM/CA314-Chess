package dcu.ie.chessapp.pieces;

import android.graphics.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Pawn implements ChessPiece {

    int moveCount = 0;
    int id;
    int type;
    Point currentPosition;
    public Pawn(int id)
    {
        if(id < 200)
            type = 1;
        else
            type = 2;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pawn " + id;
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

        //TODO add detection for piece in the two diagonals
        if(moveCount == 0)
        {
            if(type == 1) {
                possibleMoves.add(new Point(currentPosition.x, currentPosition.y + 2));
                moveCount++;
            }
            else
            {
                possibleMoves.add(new Point(currentPosition.x, currentPosition.y - 2));
                moveCount++;
            }
        }
        else
        {
            if(type == 1)
                possibleMoves.add(new Point(currentPosition.x,currentPosition.y+1));
            else
                possibleMoves.add(new Point(currentPosition.x,currentPosition.y-1));
        }



        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 1;
    }

    @Override
    public int returnType() {
        return type;
    }
}
