package dcu.ie.chessapp.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import dcu.ie.chessapp.R;

public class PieceAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public PieceAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return squareIDs.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(squareIDs[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] squareIDs = {
            R.drawable.b_rook, R.drawable.b_knight,R.drawable.b_bishop, R.drawable.b_queen, R.drawable.b_king, R.drawable.b_bishop,R.drawable.b_knight, R.drawable.b_rook,
            R.drawable.b_pawn,R.drawable.b_pawn, R.drawable.b_pawn, R.drawable.b_pawn, R.drawable.b_pawn,R.drawable.b_pawn, R.drawable.b_pawn, R.drawable.b_pawn,
            R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing,
            R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,
            R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing,
            R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,R.drawable.nothing, R.drawable.nothing, R.drawable.nothing,
            R.drawable.w_pawn, R.drawable.w_pawn,R.drawable.w_pawn, R.drawable.w_pawn, R.drawable.w_pawn, R.drawable.w_pawn,R.drawable.w_pawn, R.drawable.w_pawn,
            R.drawable.w_rook,R.drawable.w_knight, R.drawable.w_bishop, R.drawable.w_queen, R.drawable.w_king,R.drawable.w_bishop, R.drawable.w_knight, R.drawable.w_rook,
    };
}
