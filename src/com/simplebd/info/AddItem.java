package com.simplebd.info;

import com.example.freshfridge.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Build;

public class AddItem extends Activity {
	
	EditText name;
	Spinner type;
	EditText quantity;
	EditText datePurchased;
	EditText expirationDate;
	
	Button addItem;
	
	DatabaseHelper db = new DatabaseHelper(this);
	FoodItem item; 
	int spinnerPosition; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_item);
		
		name = new EditText(this);
		type = new Spinner(this);
		quantity = new EditText(this);
		datePurchased = new EditText(this);
		expirationDate = new EditText(this);
		
		addItem = new Button(this);
		
		name = (EditText)findViewById(R.id.editText1);
		type = (Spinner)findViewById(R.id.spinner01);
		quantity = (EditText)findViewById(R.id.editText3);
		datePurchased = (EditText)findViewById(R.id.editText4);
		expirationDate = (EditText)findViewById(R.id.editText5);
		
		addItem = (Button)findViewById(R.id.button1); 
		
		type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
				Object item = parent.getItemAtPosition(pos);
				spinnerPosition =pos;
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
		
		
		
	}
	
	public void btnClick(View v)
	{
		
		Log.d("Insert: ", "Inserting .. ");
		item = new FoodItem(name.getText().toString(), type.getItemAtPosition(spinnerPosition).toString(), 
				quantity.getText().toString(), datePurchased.getText().toString(), expirationDate.getText().toString());
		
		Log.i("Info: ", String.valueOf(item)); 
		
		db.addItem(item); 
		Intent i = new Intent(this, Fridge.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
			
	}


	View.OnClickListener myhandler = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			btnClick(v);
		}
	};
		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_item, menu);
		return true;
	}

	

}
