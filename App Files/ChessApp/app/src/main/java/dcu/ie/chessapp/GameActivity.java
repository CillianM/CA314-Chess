package dcu.ie.chessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import dcu.ie.chessapp.adapter.BoardAdapter;
import dcu.ie.chessapp.adapter.PathAdapter;
import dcu.ie.chessapp.adapter.PieceAdapter;

public class GameActivity extends AppCompatActivity {

    int greenDot = R.drawable.green_dot;
    BoardAdapter boardAdapter;
    PieceAdapter pieceAdapter;
    PathAdapter pathAdapter;

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

        piecesGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {



                clearPath();
                int x = position % 8;

                int y = position / 8;
                Toast.makeText(getApplicationContext(), "("+x+","+y+")", Toast.LENGTH_SHORT).show();

                int newPosition = position + 8;
                if(newPosition < 63) {
                    pathAdapter.squareIDs[newPosition] = greenDot;
                    pathGrid.setAdapter(pathAdapter);
                }

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

}
