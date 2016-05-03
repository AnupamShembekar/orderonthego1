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

public class MainActivity extends Activity {
    Main_courseDB md;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*md=new Main_courseDB(this);
//     	md.onCreate(db);
        md.sinsertDB();
        md.nsinsertDB();
        md.vinsertDB();
        md.ninsertDB();
        md.dinsertDB();
<<<<<<< Temporary merge branch 1
        md.oinsertDB();
        md.AadminDB();
=======
        md.oinsertDB();*/


    }


}
