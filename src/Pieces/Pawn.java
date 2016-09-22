package Pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Pawn implements ChessPiece {

    int moveCount = 0;
    int id;
    public Pawn(int id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pawn " + id;
    }

    @Override
    public ArrayList<Point> calculateMoves(Point position) {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        //TODO add detection for piece in the two diagonals
        if(moveCount == 0)
        {
            possibleMoves.add(new Point(position.x,position.y+2));
            moveCount++;
        }
        else
        {
            possibleMoves.add(new Point(position.x,position.y+1));
        }



        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 1;
    }
}
