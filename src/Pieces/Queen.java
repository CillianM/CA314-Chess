package Pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Queen implements ChessPiece{

    int id;
    int type;
    public Queen(int id)
    {
        if(id < 200)
            type = 1;
        else
            type = 2;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Queen " + id;
    }

    @Override
    public ArrayList<Point> calculateMoves(Point position) {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            possibleMoves.add(new Point(position.x, i));
            possibleMoves.add(new Point(i, position.y));
            possibleMoves.add(new Point(i,i));
            possibleMoves.add(new Point(i,7-i));
        }
        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 9;
    }
}
