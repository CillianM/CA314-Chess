package dcu.ie.chessapp;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import dcu.ie.chessapp.adapter.BoardAdapter;
import dcu.ie.chessapp.adapter.PathAdapter;
import dcu.ie.chessapp.adapter.PieceAdapter;
import dcu.ie.chessapp.pieces.*;

public class GameActivity extends AppCompatActivity {

    int greenDot = R.drawable.green_dot;
    int redDot = R.drawable.red_dot;
    BoardAdapter boardAdapter;
    PieceAdapter pieceAdapter;
    PathAdapter pathAdapter;
    ChessPiece [] pieces;

    GridView boardGrid;
    GridView pathGrid;
    GridView piecesGrid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        boardAdapter = new BoardAdapter(this);
        pieceAdapter = new PieceAdapter(this);
        pathAdapter = new PathAdapter(this);

        boardGrid = (GridView) findViewById(R.id.chessboard);
        boardGrid.setAdapter(boardAdapter);

        pathGrid = (GridView) findViewById(R.id.paths);
        pathGrid.setAdapter(pathAdapter);

        piecesGrid = (GridView) findViewById(R.id.pieces);
        piecesGrid.setAdapter(pieceAdapter);

        setupPieces();

        piecesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                clearPath();
                int x = position % 8;

                int y = position / 8;
                Toast.makeText(getApplicationContext(), "("+x+","+y+")", Toast.LENGTH_SHORT).show();

                if(pieces[position] != null)
                    drawLegalMoves(pieces[position]);

            }
        });
    }

    public void clearPath()
    {
        for(int i = 0; i < pathAdapter.squareIDs.length; i++)
        {
            pathAdapter.squareIDs[i] = R.drawable.nothing;
        }
        pathGrid.setAdapter(pathAdapter);
    }

    public void drawLegalMoves(ChessPiece piece)
    {
        //TODO Map white and black pieces going up and down board
        ArrayList<Point> moves = piece.calculateMoves();

        for(int i = 0; i < moves.size(); i++)
        {
            int x = moves.get(i).x;
            int y = moves.get(i).y;
            if(x > -1 && x <= 8 && y > -1 && y <= 8) {
                //translate 2D to 1D
                int index = y * 8 + x;

                //if a piece exists in that square
                if (pieces[index] != null) {
                    //check if it's opposite side
                    if (pieces[index].returnType() != piece.returnType()) {
                        pathAdapter.squareIDs[index] = redDot;
                    }
                } else if (x > -1 && x < 8 && y > -1 && y < 8) {
                    pathAdapter.squareIDs[index] = greenDot;
                }
            }
        }

        pathGrid.setAdapter(pathAdapter);
    }

    public boolean setupPieces()
    {
        int bIds = 100;
        int wIds = 200;

        pieces = new ChessPiece[64];

        for(int i = 0; i < pieceAdapter.squareIDs.length; i++)
        {
            int x = i % 8;
            int y = i / 8;
            if(pieceAdapter.squareIDs[i] == R.drawable.b_bishop)
            {
                pieces[i] = new Bishop(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.b_king)
            {
                pieces[i] = new King(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.b_knight)
            {
                pieces[i] = new Knight(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.b_pawn)
            {
                pieces[i] = new Pawn(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.b_queen)
            {
                pieces[i] = new Queen(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.b_rook)
            {
                pieces[i] = new Rook(bIds); bIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_bishop)
            {
                pieces[i] = new Bishop(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_king)
            {
                pieces[i] = new King(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_knight)
            {
                pieces[i] = new Knight(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_pawn)
            {
                pieces[i] = new Pawn(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_queen)
            {
                pieces[i] = new Queen(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else if(pieceAdapter.squareIDs[i] == R.drawable.w_rook)
            {
                pieces[i] = new Rook(wIds); wIds++;
                pieces[i].updateCurrentPosition(new Point(x,y));
            }
            else
            {
                pieces[i] = null;
            }
        }

        if(wIds + bIds == 330)
            return true;
        else
            return false;
    }

}
