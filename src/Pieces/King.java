package Pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class King implements ChessPiece
{

    int id;
    public King(int id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        return "King " + id;
    }

    @Override
    public ArrayList<Point> calculateMoves(Point position) {
        ArrayList<Point> possibleMoves = new ArrayList<>();

        //Ups and downs
        possibleMoves.add(new Point(position.x, position.y+1));
        possibleMoves.add(new Point(position.x+1, position.y));
        possibleMoves.add(new Point(position.x, position.y-1));
        possibleMoves.add(new Point(position.x-1, position.y));

        //diagonal
        possibleMoves.add(new Point(position.x+1, position.y+1));
        possibleMoves.add(new Point(position.x-1, position.y+1));
        possibleMoves.add(new Point(position.x+1, position.y-1));
        possibleMoves.add(new Point(position.x-1, position.y-1));

        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 10;
    }
}
