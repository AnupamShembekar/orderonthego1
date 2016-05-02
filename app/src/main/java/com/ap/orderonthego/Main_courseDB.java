package com.ap.orderonthego;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Main_courseDB extends SQLiteOpenHelper {
	
	public static String DATABASE_NAME="Menu";

    //  VEG-TABLE
	public static String VTABLE_NAME="vmain_course";
	public static String VMAIN_COURSE_NAME="vmain_course_name";
	public static String VAMOUNT="vprice";
	public static String VSR_NO="vserial";

    //DESSERT TABLE
	public static String DTABLE_NAME="desserts";
	public static String DESSERT_NAME="dessert_name";
	public static String DAMOUNT="dprice";
	public static String DSR_NO="dserial";
	
	//NON-VEG TABLE
	public static String NTABLE_NAME="nonveg_main_course";
	public static String NMAIN_COURSE_NAME="nmain_course_name";
	public static String NAMOUNT="nprice";
	public static String NSR_NO="nserial";

    //VEG-STARTER TABLE
    public static String STABLE_NAME="Veg_Starter";
    public static String SNAME="s_name";
    public static String SPRICE="s_price";
    public static String CODE="s_serial";

    //NONVEG-STARTER TABLE
    public static String NSTABLE_NAME="NonVeg_Starter";
    public static String NSNAME="ns_name";
    public static String NSPRICE="ns_price";
    public static String NCODE="ns_serial";

    //OTHER TABLE
    public static String OTABLE_NAME="Other";
    public static String ONAME="o_name";
    public static String OPRICE="o_price";
    public static String OCODE="o_serial";

    SQLiteDatabase sdb;
	SQLiteOpenHelper sh;


	public Main_courseDB(Context context) {
		super(context, DATABASE_NAME, null, 1);
		sdb=this.getWritableDatabase();
		Log.d("database", "created");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//db=this.getWritableDatabase();
		// CREATE VEG-TABLE
		db.execSQL("create table "+VTABLE_NAME+"("+VSR_NO+" integer primary key autoincrement,"+VMAIN_COURSE_NAME+" text,"+VAMOUNT+" integer)");
		Log.d("vegtable", "created");
		
		
		//CREATE NON-VEG TABLE
		db.execSQL("create table nonveg_main_course(nserial integer primary key autoincrement,nmain_course_name text,nprice integer)");
		Log.d("non-vegtable", "created");
		
		//CREATE DESSERT TABLE
		    db.execSQL("create table "+DTABLE_NAME+"("+DSR_NO+" integer primary key autoincrement,"+DESSERT_NAME+" text,"+DAMOUNT+" integer)");
			Log.d("desserttable", "created");


		//CREATE VEG-STARTER TABLE
		db.execSQL("create table " + STABLE_NAME + " (s_serial  INTEGER PRIMARY KEY AUTOINCREMENT,s_name TEXT,s_price INTEGER)");
		Log.d("database operations", "veg_startertable created");


        //CREATE NONVEG-STARTER TABLE
        db.execSQL("create table " + NSTABLE_NAME + " (ns_serial  INTEGER PRIMARY KEY AUTOINCREMENT,ns_name TEXT,ns_price INTEGER)");
        Log.d("database operations", "nonveg_startertable created");

        //CREATE OTHER TABLE
		db.execSQL("create table " + OTABLE_NAME + " (o_serial  INTEGER PRIMARY KEY AUTOINCREMENT,o_name TEXT,o_price INTEGER)");
		Log.d("database operations", "other_table created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		
	}
    //INSERT INTO VEG TABLE
	public void vinsertDB(String mainitem,String mainprice){
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

		cv.put(VMAIN_COURSE_NAME,mainitem);
		cv.put(VAMOUNT, mainprice);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("vinsertion", "done");

		/*cv.put(VMAIN_COURSE_NAME, "Palak Paneer");
		cv.put(VAMOUNT, 50);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Bhoona");
		cv.put(VAMOUNT, 100);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Makhanwala");
		cv.put(VAMOUNT, 90);
        sdb.insert(VTABLE_NAME, null, cv);
        Log.d("insertion", "done");

		cv.put(VMAIN_COURSE_NAME, "Veg Kolhapuri");
		cv.put(VAMOUNT, 110);*/

	}
    //INSERT INTO NON-VEG TABLE
	public void ninsertDB(String nonveg_main,String nonveg_main_price){
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

		cv.put(NMAIN_COURSE_NAME, nonveg_main);
		cv.put(NAMOUNT, nonveg_main_price);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

	/*	cv.put(NMAIN_COURSE_NAME, "Mutton Biryani");
		cv.put(NAMOUNT, 50);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Chicken Handi");
		cv.put(NAMOUNT, 100);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Fish fry");
		cv.put(NAMOUNT, 90);
        sdb.insert(NTABLE_NAME, null, cv);
        Log.d("Ninsertion", "done");

		cv.put(NMAIN_COURSE_NAME, "Egg Curry");
		cv.put(NAMOUNT, 110);*/

		
	}

    //INSERT INTO DESSERT TABLE
	public void dinsertDB(String dessertname,String dessertprice){
		
		sdb=this.getWritableDatabase();
		ContentValues cv=new ContentValues();

		cv.put(DESSERT_NAME, dessertname);
		cv.put(DAMOUNT, dessertprice);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		/*cv.put(DESSERT_NAME, "Vanilla Milk Shake");
		cv.put(DAMOUNT, 50);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Fruit Salad");
		cv.put(DAMOUNT, 70);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Matka Kulfi");
		cv.put(DAMOUNT, 30);
        sdb.insert(DTABLE_NAME, null, cv);
        Log.d("dinsertion", "done");

		cv.put(DESSERT_NAME, "Triple Sunday");
		cv.put(DAMOUNT, 120);*/

		
	}

    //INSERT INTO VEG-STARTER TABLE
    public void sinsertDB(String startername,String starterprice){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(SNAME, startername);
        cv.put(SPRICE, starterprice);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

       /* cv.put(SNAME, "Paneer Pakoda");
        cv.put(SPRICE, 50);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Veg-manchurian dry");
        cv.put(SPRICE, 70);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Tomato soup");
        cv.put(SPRICE, 30);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");

        cv.put(SNAME, "Veg-sandwich");
        cv.put(SPRICE, 20);
        sdb.insert(STABLE_NAME, null, cv);
        Log.d("sinsertion", "done");*/

    }

        //NON-VEG STARTER TABLE
    public void nsinsertDB(){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(NSNAME, "Chicken Lollypop");
        cv.put(NSPRICE, 50);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken Tawa");
        cv.put(NSPRICE, 70);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken nuggets");
        cv.put(NSPRICE, 70);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken Soup");
        cv.put(NSPRICE, 30);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

        cv.put(NSNAME, "Chicken Hariyali Kabab");
        cv.put(NSPRICE, 20);
        sdb.insert(NSTABLE_NAME, null, cv);
        Log.d("Nsinsertion", "done");

    }

    //INSERT INTO OTHERS TABLE
    public void oinsertDB(String othername,String otherprice){
        sdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ONAME, othername);
        cv.put(OPRICE, otherprice);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

      /*  cv.put(ONAME, "Jeera Rice");
        cv.put(OPRICE, 40);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Fried Rice");
        cv.put(OPRICE, 80);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Steam Rice");
        cv.put(OPRICE, 35);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");

        cv.put(ONAME, "Veg Biryani");
        cv.put(OPRICE, 90);
        sdb.insert(OTABLE_NAME, null, cv);
        Log.d("oinsertion", "done");*/

    }

    //SHOW TABLES
    public void showDB(){
		sdb=this.getReadableDatabase();
		Cursor c=sdb.rawQuery("Select * from vmain_course",new String[]{"vmain_course_name","vprice"});
		c.moveToFirst();
		c.getString(1);

	}

}
