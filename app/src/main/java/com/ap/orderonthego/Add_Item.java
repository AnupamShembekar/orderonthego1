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

/**
 * Created by Akshay on 30-Apr-16.
 */
public class Add_Item extends Activity implements View.OnClickListener {
    Main_courseDB mdb;
    String[] pro;

    Spinner categories,quantity;
    int quant;

    Button submit,save,cancel;
    String cat;
    EditText items,price;
    LinearLayout l1,l2;
    LinearLayout.LayoutParams mParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    private int i, count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminadditem);
        mdb=new Main_courseDB(this);


        pro = mdb.showcategories();

        //linearlayout id for dynamic edittexts and buttons
        l1=(LinearLayout)findViewById(R.id.edlayout);
        l2=(LinearLayout)findViewById(R.id.ilayout);

        //Spinner for categories
        ArrayAdapter<String> item1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pro);
        item1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        categories=(Spinner)findViewById(R.id.spinner1);
        categories.setAdapter(item1);
        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat=categories.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        //spinner for number of items to be added
        ArrayAdapter<Integer> item2=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,new Integer[]{1,2,3,4});
        item2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        quantity=(Spinner)findViewById(R.id.spinner2);
        quantity.setAdapter(item2);
        quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quant=(int)quantity.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit=(Button)findViewById(R.id.btnSubmit);
        submit.setOnClickListener(this);
    }



    @Override
    public void onClick(View v)throws ArrayIndexOutOfBoundsException
    {
        switch (v.getId()) {
            case R.id.btnSubmit:
                if (count > 0) {
                    startActivity(new Intent(this, Add_Item.class));
                    count--;
                } else {

                    for (i = 0; i < quant; i++) {
                        createED();
                    }

                    //dynamic save and cancel buttons
                    save = new Button(this);
                    cancel = new Button(this);
                    save.setLayoutParams(mParams);
                    save.setText("Save");
                    save.setId(300 + 1);
                    save.setOnClickListener(this);
                    cancel.setLayoutParams(mParams);
                    cancel.setText("Cancel");
                    cancel.setId(300 + 2);
                    cancel.setOnClickListener(this);

                    l2.addView(save);
                    l2.addView(cancel);
                    l2.setLayoutParams(mParams);

                }
                count++;
                break;
            case 300 + 1:
                //code for data insertion in database from dynamic edittexts
                switch (cat) {
                    case "Starters":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < quant; i++) {
                            items = (EditText) findViewById(100 + i);
                            price = (EditText) findViewById(200 + i);
                         //  mdb.sinsertDB(items.getText().toString(), price.getText().toString());
                            startActivity(new Intent(this, Add_Item.class));
                        }
                        break;
                    case "Main_Course":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < quant; i++) {
                            items = (EditText) findViewById(100 + i);
                            price = (EditText) findViewById(200 + i);
                          //  mdb.vinsertDB(items.getText().toString(), price.getText().toString());
                            startActivity(new Intent(this, Add_Item.class));
                        }
                        break;
                    case "Desserts":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < quant; i++) {
                            items = (EditText) findViewById(100 + i);
                            price = (EditText) findViewById(200 + i);
                         //  mdb.dinsertDB(items.getText().toString(), price.getText().toString());
                            startActivity(new Intent(this, Add_Item.class));
                        }
                        break;
                    case "others":
                        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                        for (i = 0; i < quant; i++) {
                            items = (EditText) findViewById(100 + i);
                            price = (EditText) findViewById(200 + i);
                           // mdb.oinsertDB(items.getText().toString(), price.getText().toString());
                            startActivity(new Intent(this, Add_Item.class));
                        }


                }

                    case 300 + 2:
                        Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, Add_Item.class));
                        break;


                }
        }

    //Creates Editext  as per the number of items entered
    public void createED()
    {
        List<EditText> edit=new ArrayList<>();
            items=new EditText(this);
            price=new EditText(this);
            edit.add(items);
            items.setId(100 + i);
            items.setHint("items");

            edit.add(price);
            price.setHint("price");
            price.setId(200+i);

            l2.setLayoutParams(mParams);
            l2.addView(items);
            l2.addView(price);
    }

}
