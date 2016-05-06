package com.ap.orderonthego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by anupa on 06/05/2016.
 */
public class AdminMain extends Activity implements View.OnClickListener{

    Button btn1, btn2, btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_item);

        btn1=(Button)findViewById(R.id.edititem1);
        btn2=(Button)findViewById(R.id.edititem2);
        btn3=(Button)findViewById(R.id.edititem3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {



        switch (v.getId()){
            case R.id.edititem1:

                Toast.makeText(this, "Going to add iten", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(this, Add_Item.class);
                startActivity(in);
                break;
            case R.id.edititem2:

                Toast.makeText(this, "Mobile number btn2", Toast.LENGTH_SHORT).show();
                //Intent in = new Intent(this, Add_Item.class);
                //startActivity(in);
                break;

            case R.id.edititem3:

                Toast.makeText(this, "Mobile number btn3", Toast.LENGTH_SHORT).show();
                //Intent in = new Intent(this, Add_Item.class);
                //startActivity(in);
                break;
        }
    }
}