package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlitecrud.adapter.GameAdapter;
import com.example.sqlitecrud.model.Game;
import com.example.sqlitecrud.sqlite.GameDao;

import java.util.List;
import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private GameAdapter gameAdapter;
    private ListView lvGame;
    private String Id;
    private List<Game>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DbHelper dbHelper=new DbHelper(this);
//        SQLiteDatabase database = dbHelper.getReadableDatabase();
//        database.close();
        findViewById(R.id.buttonInsert).setOnClickListener(this);
        findViewById(R.id.buttonEdit).setOnClickListener(this);
        findViewById(R.id.buttonDelete).setOnClickListener(this);

            lvGame=findViewById(R.id.lvGame);
            GameDao dao= new GameDao(this);
            list= dao.getAll();
            gameAdapter=new GameAdapter(this, list);
            lvGame.setAdapter(gameAdapter);
            lvGame.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Game gam = list.get(i);
                    Id=gam.getId();
                }
            });
    }

    @Override
    protected void onResume() {
        super.onResume();

        GameDao dao= new GameDao(this);
        List<Game> updatedList = dao.getAll();

        list.clear();
        for (Game item : updatedList) {
            list.add(item);
        }
        gameAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,AddOrEditGameActivity.class);
        switch (view.getId()){
            case R.id.buttonInsert:
                startActivity(intent);
                break;

            case R.id.buttonEdit:
                if(Id==null){
                    Toast.makeText(this, "Id must be selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                Bundle bundle=new Bundle();
                bundle.putString("id",Id);
                intent.putExtra("data",bundle);

                startActivity(intent);
                break;

            case R.id.buttonDelete:
                if(Id==null){
                    Toast.makeText(this, "ID must be selected", Toast.LENGTH_SHORT).show();
                    return;
                }

                GameDao dao= new GameDao(this);
                dao.delete(Id);
                Id=null;

                onResume();

                Toast.makeText(this, "Game was deleted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}