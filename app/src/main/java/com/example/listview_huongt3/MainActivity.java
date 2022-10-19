package com.example.listview_huongt3;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDienThoai;
    ArrayList<DienThoai> arrayDienThoai;
    DienThoaiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        adapter =new DienThoaiAdapter(this,R.layout.dong_dien_thoai,arrayDienThoai);
        lvDienThoai.setAdapter(adapter);
    }
    private void AnhXa(){
        lvDienThoai=(ListView) findViewById(R.id.listviewDienThoai);
        arrayDienThoai=new ArrayList<>();
        arrayDienThoai.add(new DienThoai("Iphone 8","Gia:9.000.000d",R.drawable.iphone8));
        arrayDienThoai.add(new DienThoai("Iphone 9","Gia:10.000.000d",R.drawable.iphone9));
        arrayDienThoai.add(new DienThoai("Iphone 11","Gia:12.000.000d",R.drawable.iphone11));
        arrayDienThoai.add(new DienThoai("Iphone 12","Gia:18.000.000d",R.drawable.iphone12));
        arrayDienThoai.add(new DienThoai("Iphone 13","Gia:25.000.000d",R.drawable.iphone13));
        arrayDienThoai.add(new DienThoai("Iphone 14","Gia:35.000.000d",R.drawable.iphone14));



    }

}
