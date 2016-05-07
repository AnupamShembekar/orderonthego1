package com.ap.orderonthego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AdminNonVegAdd extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    Main_courseDB mdb;

    Spinner nonvegcategories,nonvegquantity;
    int nonvegquant;

    Button submit,save,cancel;
    String nonvegcat;
    EditText nonvegitems,nonvegprice;
    LinearLayout l1,l2;
    LinearLayout.LayoutParams mParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    private int i, count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nonvegadditem);
        mdb=new Main_courseDB(this);

        //linearlayout id for dynamic edittexts and buttons
        l1=(LinearLayout)findViewById(R.id.nonvegedlayout);
        l2=(LinearLayout)findViewById(R.id.nonvegilayout);

        //Spinner for categories
        ArrayAdapter<String> item1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,new String[]{"Non-Veg Starters","Non-Veg Main_Course"});
        item1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        nonvegcategories=(Spinner)findViewById(R.id.nonvegspinner1);
        nonvegcategories.setAdapter(item1);
        nonvegcategories.setOnItemSelectedListener(this);

        //spinner for number of items to be added
        ArrayAdapter<Integer> item2=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,new Integer[]{1,2,3,4,5});
        item2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        nonvegquantity=(Spinner)findViewById(R.id.nonvegspinner2);
        nonvegquantity.setAdapter(item2);
        nonvegquantity.setOnItemSelectedListener(this);

        submit=(Button)findViewById(R.id.nonvegbtnSubmit);
        submit.setOnClickListener(this);
        //  l.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        nonvegcat=nonvegcategories.getItemAtPosition(position).toString();
        nonvegquant=(int)nonvegquantity.getItemAtPosition(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v)throws ArrayIndexOutOfBoundsException {

        Toast.makeText(this, nonvegquant, Toast.LENGTH_SHORT).show();


        switch (v.getId()) {
            case R.id.nonvegbtnSubmit:
                if (count > 0) {
                    startActivity(new Intent(this, AdminNonVegAdd.class));
                    count--;
                } else {

                    for (i = 0; i < nonvegquant; i++) {
                        createED();
                    }

                    //dynamic save and cancel buttons
                    save = new Button(this);
                    cancel = new Button(this);
                    save.setLayoutParams(mParams);
                    save.setText("Save");
                    save.setId(400 + 1);
                    save.setOnClickListener(this);
                    cancel.setLayoutParams(mParams);
                    cancel.setText("Cancel");
                    cancel.setId(400 + 2);
                    cancel.setOnClickListener(this);

                    l2.addView(save);
                    l2.addView(cancel);
                    l2.setLayoutParams(mParams);

                }
                count++;
                break;
            case 400 + 1:
                //code for data insertion in database from dynamic edittexts
                switch (nonvegcat) {
                    case "Non-Veg Starters":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < nonvegquant; i++) {
                            nonvegitems = (EditText) findViewById(500 + i);
                            nonvegprice = (EditText) findViewById(600 + i);
                            mdb.nsinsertDB(nonvegitems.getText().toString(), nonvegprice.getText().toString());
                            startActivity(new Intent(this, AdminNonVegAdd.class));
                        }
                        break;
                    case "Non-Veg Main_Course":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < nonvegquant; i++) {
                            nonvegitems = (EditText) findViewById(500 + i);
                            nonvegprice = (EditText) findViewById(600 + i);
                            mdb.ninsertDB(nonvegitems.getText().toString(), nonvegprice.getText().toString());
                            startActivity(new Intent(this, AdminNonVegAdd.class));
                        }
                        break;

                }

            case 400 + 2:
                Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, AdminNonVegAdd.class));
                break;


        }
    }

    //Creates Editext  as per the number of items entered
    public void createED()
    {
        List<EditText> edit=new ArrayList<>();


        nonvegitems=new EditText(this);
        nonvegprice=new EditText(this);
        edit.add(nonvegitems);
        nonvegitems.setId(500 + i);
        nonvegitems.setHint("items");

        edit.add(nonvegprice);
        nonvegprice.setHint("price");
        nonvegprice.setId(600+i);


        //  LinearLayout li=new LinearLayout(this);
        l2.setLayoutParams(mParams);
        l2.addView(nonvegitems);
        l2.addView(nonvegprice);

        //  l1.setLayoutParams(mParams);
        // this.setContentView(l2, mParams);

    }

}


