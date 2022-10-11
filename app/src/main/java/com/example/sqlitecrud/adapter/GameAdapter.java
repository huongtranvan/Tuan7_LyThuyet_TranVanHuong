package com.example.sqlitecrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.model.Game;

import java.util.List;

public class GameAdapter extends BaseAdapter {
    private Context context;
    private List<Game> list;

    public GameAdapter(Context context, List<Game> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.layout_game_item,null);
        }

        TextView tvName=view.findViewById(R.id.tvName);
        TextView tvPrice=view.findViewById(R.id.tvPrice);

        Game gam =list.get(i);
        tvName.setText(gam.getName());
        tvPrice.setText("" + gam.getPrice());

        return view;
    }
}
