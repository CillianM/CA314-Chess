package Board;

import Pieces.*;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Created by Cillian Mc Neill on 19/09/2016.
 */
public class ChessBoard {


    BoardSquare [][] playingBoard;
    private ChessPiece [] WhitePieces;
    private ChessPiece [] BlackPieces;

    public ChessBoard()
    {
        playingBoard = new BoardSquare[8][8];
        constructBoard();
    }

    public ArrayList<Point> legalMoves(ArrayList<Point> moves)
    {
        //TODO take in possible moves and return the possible moves that can be donepy
        for(int i = 0; i < moves.size(); i++)
        {
            Point pt = moves.get(i);
            if(pt.x > 7 || pt.x < 0 || pt.y > 7 || pt.y < 0)
                moves.remove(i);
        }
        return new ArrayList<Point>();
    }

    public void test()
    {
        for(int y = 0; y < 8; y ++)
        {
            for(int x = 0; x < 8; x++)
            {
                System.out.print(x+","+y+":" + playingBoard[x][y].toString() + "  ");
            }
            System.out.println("");
        }
    }

    private void constructBoard()
    {
        constructPieces();
        int blackPieceCounter = 15;
        int whitePieceCounter = 0;
        for(int y = 0; y < 8; y++)
        {
            for(int x = 0; x < 8; x++)
            {
                if(y < 2)
                {
                    playingBoard[x][y] = new BoardSquare(x,y,BlackPieces[blackPieceCounter]);
                    blackPieceCounter--;
                }
                else if(y > 5)
                {
                    playingBoard[x][y] = new BoardSquare(x,y,WhitePieces[whitePieceCounter]);
                    whitePieceCounter++;
                }
                else
                {
                    playingBoard[x][y] = new BoardSquare(x,y);
                }
            }
        }
    }


    private void constructPieces()
    {
        //TODO Construct rows 0,1 for white and 6,7 for black along with nulls for blanks

        WhitePieces = new ChessPiece[16];
        BlackPieces = new ChessPiece[16];

        //add pawns to both
        for(int i =0; i < 8; i++)
        {
            WhitePieces[i] = new Pawn(100+i);
            BlackPieces[i] = new Pawn(200+i);
        }
        //Now fill remainder with appropriate pieces
        for(int i = 8; i < 16; i++)
        {
            if(i == 8 || i == 15)
            {
                WhitePieces[i] = new Rook(100+i);
                BlackPieces[i] = new Rook(200+i);
            }

            if(i == 9 || i == 14)
            {
                WhitePieces[i] = new Knight(100+i);
                BlackPieces[i] = new Knight(200+i);
            }

            if(i == 10 || i == 13)
            {
                WhitePieces[i] = new Bishop(100+i);
                BlackPieces[i] = new Bishop(200+i);
            }

            if(i == 11)
            {
                WhitePieces[i] = new Queen(100+i);
                BlackPieces[i] = new Queen(200+i);
            }

            if(i == 12)
            {
                WhitePieces[i] = new King(100+i);
                BlackPieces[i] = new King(200+i);
            }
        }
    }
}
