package com.ap.orderonthego;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Akshay on 10-May-16.
 */
public class Delete extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    Button b1;
    Spinner s1,s2;
    Main_courseDB db;
    String pro[]= new String[100];
    String alltabs[]=new String[100];

    String l,l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletitem);

        b1 = (Button) findViewById(R.id.btnSubmit);

        s1 = (Spinner) findViewById(R.id.spinner11);
        b1.setOnClickListener(this);

        db= new Main_courseDB(this);

        pro = db.showcategories();


        ArrayAdapter<String> item1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, pro);
        item1.setDropDownViewResource(android.R.layout.simple_spinner_item);

        s1.setAdapter(item1);
        s1.setOnItemSelectedListener(this);
    }
    @Override
    public void onClick(View v) {

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        l = s1.getItemAtPosition(position).toString();


        switch (l)
        {
            case "Veg_Starters":
                alltabs=db.showVStarters();
                break;
            case "vmain_course":
                alltabs=db.showVmainc();
                break;


        }


        ArrayAdapter<String> item2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,alltabs);
        item2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        s2 = (Spinner) findViewById(R.id.spinner12);
        s2.setAdapter(item2);
        s2.setOnItemSelectedListener(this);
        l1=s2.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
