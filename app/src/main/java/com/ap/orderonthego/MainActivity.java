package com.ap.orderonthego;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    String MobilePattern = "[0-9]{10}";
    EditText et;
    Button btn;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.et);
        btn = (Button)findViewById(R.id.btnSubmit);
        btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v)
    {
        if (et!=null && et.length()==10 ) {
            num = et.getText().toString();
            Toast.makeText(this, "Mobile number is valid", Toast.LENGTH_SHORT).show();
        }
        else
        {

            Toast.makeText(this, "Please enter Mobile number", Toast.LENGTH_SHORT).show();
        }





    }
}
