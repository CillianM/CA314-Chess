package Board;

import Pieces.ChessPiece;

import java.awt.*;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class BoardSquare {

    Point position;
    ChessPiece currentPiece;

    public BoardSquare(int x,int y)
    {
        position = new Point(x,y);
        currentPiece = null;
    }

    @Override
    public String toString() {
        if(piecePresent())
            return "("+position.x+","+position.y+") "+ currentPiece.toString();
        else
            return "("+position.x+","+position.y+") NULL";
    }

    public BoardSquare(int x, int y, ChessPiece piece)
    {
        position = new Point(x,y);
        currentPiece = piece;
    }

    public boolean piecePresent()
    {
        if(currentPiece != null)
            return true;

        return false;
    }

    public void pieceMoved()
    {
        currentPiece = null;
    }

    public void piecePlaced(ChessPiece piece)
    {
        currentPiece = piece;
    }


}
