package com.example.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrud.model.Game;
import com.example.sqlitecrud.sqlite.GameDao;

public class AddOrEditGameActivity extends AppCompatActivity
        implements View.OnClickListener {
    private EditText edtId,edtName,edtPrice;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_game);

        edtId=findViewById(R.id.edittextId);
        edtName=findViewById(R.id.edittextName);
        edtPrice=findViewById(R.id.edittextPrice);

        btnSave=findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(this);
        findViewById(R.id.buttonList).setOnClickListener(this);
        readGame();
    }

    private void readGame(){
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        if(bundle==null){
            return;
        }

        String id=bundle.getString("id");

        GameDao dao=new GameDao(this);
        Game gam=dao.getById(id);

        edtId.setText(gam.getId());
        edtName.setText(gam.getName());
        edtPrice.setText(""+ gam.getPrice());

        btnSave.setText("Update");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonSave:
                GameDao dao= new GameDao(this);
                Game gam=new Game();

                gam.setId(edtId.getText().toString());
                gam.setName(edtName.getText().toString());
                gam.setPrice(Float.parseFloat(edtPrice.getText().toString()));

                if (btnSave.getText().equals("Save")){
                    dao.insert(gam);
                }else{
                    dao.update(gam);
                }

                Toast.makeText(this, "New Game has been saved", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}