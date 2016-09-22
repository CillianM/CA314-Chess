package Pieces;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class Knight implements ChessPiece {
    int id;
    int type;
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
    public ArrayList<Point> calculateMoves(Point position) {
        ArrayList<Point> possibleMoves = new ArrayList<>();


        possibleMoves.add(new Point(position.x+2, position.y+1));
        possibleMoves.add(new Point(position.x+2, position.y-1));
        possibleMoves.add(new Point(position.x-2, position.y-1));
        possibleMoves.add(new Point(position.x-2, position.y+1));


        possibleMoves.add(new Point(position.x-1, position.y+2));
        possibleMoves.add(new Point(position.x+1, position.y+2));
        possibleMoves.add(new Point(position.x+1, position.y-2));
        possibleMoves.add(new Point(position.x-1, position.y-2));


        return possibleMoves;
    }

    @Override
    public int returnPointValue() {
        return 0;
    }
}
