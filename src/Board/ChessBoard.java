package Board;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class ChessBoard {


    BoardSquare [] playingBoard;

    public ChessBoard()
    {
        playingBoard = new BoardSquare[64];
    }

    public ArrayList<Point> legalMoves(ArrayList<Point> moves)
    {
        //TODO take in possible moves and return the possible moves that can be done
        return new ArrayList<Point>();
    }


    public void constructBoard()
    {
        //TODO Construct rows 0,1 for white and 6,7 for black along with nulls for blanks
    }
}
