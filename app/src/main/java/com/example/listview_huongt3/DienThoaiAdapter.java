package com.example.listview_huongt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DienThoaiAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DienThoai> dienThoaiList;

    public DienThoaiAdapter(Context context, int layout, List<DienThoai> dienThoaiList) {

        this.context = context;
        this.layout = layout;
        this.dienThoaiList = dienThoaiList;
    }

    @Override

    public int getCount() {
        return dienThoaiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view =inflater.inflate(layout,null);
        // anh xa view
        TextView txtTen=(TextView) view.findViewById(R.id.textviewTen);
        TextView txtMoTa=(TextView) view.findViewById(R.id.textviewMoTa);
        ImageView imgHinh=(ImageView) view.findViewById(R.id.imageviewHinh);
        //gan gia tri
        DienThoai dienThoai=dienThoaiList.get(i);
        txtTen.setText(dienThoai.getTen());
        txtMoTa.setText(dienThoai.getMoTa());
        imgHinh.setImageResource(dienThoai.getHinh());


        return view;
    }
}
