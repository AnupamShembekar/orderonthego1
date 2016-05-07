package com.ap.orderonthego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Akshay on 03-May-16.
 */
public class VegNonVegSelection extends Activity implements View.OnClickListener{
    ImageButton veg,nonveg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegnonvegbutton);
        veg=(ImageButton)findViewById(R.id.vegbtn);
        nonveg=(ImageButton)findViewById(R.id.nonvegbtn);
        veg.setOnClickListener(this);
        nonveg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.vegbtn:
                startActivity(new Intent(this,AdminPage.class));
                break;
            case R.id.nonvegbtn:
                startActivity(new Intent(this,AdminNonVegAdd.class));
                break;
        }

    }
}

