package com.simplebd.info;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION =1;
	
	static final String DATABASE_NAME ="myGroceries";
	static final String TABLE_CONTACTS = "Groceries";
	static final String KEY_ID = "id";
	static final String KEY_NAME = "name";
	static final String KEY_TYPE = "category";
	static final String KEY_QUANTITY = "quantity";
	static final String KEY_PURCHASED_DATE = "purchase_date";
	static final String KEY_EXPIRATION_DATE = "expiration_date";
	
	static final String viewFoods ="ViewFoods";
	
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	
	//Create Database Table
	public void onCreate(SQLiteDatabase db){
		
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME
				+ " TEXT, " + KEY_TYPE + " TEXT," + KEY_QUANTITY + " TEXT, " + KEY_PURCHASED_DATE + " TEXT, " + KEY_EXPIRATION_DATE + 
				" TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}
	
	//Upgrading Database
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		//Drop older table if exists
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
		
		//Create table again
		onCreate(db);
		
	}
	
	
	//Add food item
	public void addItem (FoodItem item)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, item.getName());
		values.put(KEY_TYPE, item.getType());
		values.put(KEY_QUANTITY, item.getQuantity());
		values.put(KEY_PURCHASED_DATE, item.getDatePurchased());
		values.put(KEY_EXPIRATION_DATE, item.getExpirationDate()); //Retrieve values of food item
		
		db.insert(TABLE_CONTACTS, null, values);   				   //Insert values into db
		db.close();												   //Close db
		
	}
	
	//Getting one item
	public FoodItem getItem(int id)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID, KEY_NAME, KEY_TYPE, KEY_QUANTITY, KEY_PURCHASED_DATE, 
				KEY_EXPIRATION_DATE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		
		FoodItem item = new FoodItem(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5)); 
				;
		
		return item;
		
	}
	
	//Getting all items
	public List<FoodItem> getAllItems()
	{
		List<FoodItem> foodItemList = new ArrayList<FoodItem>();		//Create list items
		
		String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;		//Select all items in db
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		
		//loop through all rows and add to list
		if (cursor.moveToFirst()){
			do {
				FoodItem item = new FoodItem();
				item.setID(Integer.parseInt(cursor.getString(0)));
				item.setName(cursor.getString(1));
				item.setType(cursor.getString(2));
				item.setQuantity(cursor.getString(3));
				item.setDatePurchased(cursor.getString(4));
				item.setExpirationDate(cursor.getString(5));
				foodItemList.add(item);
			}while (cursor.moveToNext());
		}
		
		return foodItemList; 										//Return list of items
		
	}
	
	
	//Getting item count
	public int getItemCount()
	{
		String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		
		return cursor.getCount();									//Return item count
	}
	
	//Update item
	public int updateItem(FoodItem item)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, item.getName());
		values.put(KEY_TYPE, item.getType());
		values.put(KEY_QUANTITY, item.getQuantity());
		values.put(KEY_PURCHASED_DATE, item.getDatePurchased());
		values.put(KEY_EXPIRATION_DATE, item.getExpirationDate());
		
		//Updating row
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?", new String[] { String.valueOf(item.getID()) }); 
		
		
	}
	
	//Delete item
	public void deleteItem(FoodItem item)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?", new String[] { String.valueOf(item.getID())}); 
		db.close();
	}
	
	
}
