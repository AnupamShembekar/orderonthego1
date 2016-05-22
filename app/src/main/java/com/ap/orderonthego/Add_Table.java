package com.ap.orderonthego;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Akshay on 20-May-16.
 */
public class Add_Table extends Activity implements View.OnClickListener{
    EditText et1,et2,et3;
    Button b;
    SQLiteDatabase sd;
    Main_courseDB mb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_table);

        et1=(EditText)findViewById(R.id.tableat);
        et2=(EditText)findViewById(R.id.colat);
        et3=(EditText)findViewById(R.id.colat1);

        b=(Button)findViewById(R.id.addtab);

        b.setOnClickListener(this);

        mb=new Main_courseDB(this);

    }

    @Override
    public void onClick(View v) {
        mb.dynamicAdd(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());

            mb.xyz(et1.getText().toString());

        startActivity(new Intent(this,Add_Item.class));

    }


}
