package com.example.freshfridge;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.*;

public class MainScreen extends Activity { 
	
	ImageButton fridgeBtn;
	ImageButton groceryBtn;
	ImageButton expirationBtn;
	ImageButton recipesBtn;
	ImageButton foodTipsBtn;
	ImageButton settingsBtn;
	ImageButton exitBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		fridgeBtn = new ImageButton(this);
		groceryBtn = new ImageButton(this);
		expirationBtn = new ImageButton(this);
		recipesBtn = new ImageButton(this);
		foodTipsBtn = new ImageButton(this);
		settingsBtn = new ImageButton(this);
		exitBtn = new ImageButton(this);
		
		fridgeBtn = (ImageButton)findViewById(R.id.imageButton1);
		groceryBtn = (ImageButton)findViewById(R.id.imageButton2);
		expirationBtn = (ImageButton)findViewById(R.id.imageButton3);
		recipesBtn = (ImageButton)findViewById(R.id.imageButton4);
		foodTipsBtn = (ImageButton)findViewById(R.id.imageButton5);
		settingsBtn = (ImageButton)findViewById(R.id.imageButton6);
		exitBtn = (ImageButton)findViewById(R.id.imageButton7);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
		return true;
	}
	
	public void btnClick(View v)
	{
		switch(v.getId()){
		case R.id.imageButton1:
			Intent i1 = new Intent(getApplicationContext(), Fridge.class);
			startActivity(i1);
			break;
		case R.id.imageButton2:
			Intent i2 = new Intent(getApplicationContext(), GroceryList.class);
			startActivity(i2);
			break;
		case R.id.imageButton3:
			Intent i3 = new Intent(getApplicationContext(), ExpirationDates.class);
			startActivity(i3);
			break;
		case R.id.imageButton4:
			Intent i4 = new Intent(getApplicationContext(), Recipes.class);
			startActivity(i4);
			break;
		case R.id.imageButton5:
			Intent i5 = new Intent(getApplicationContext(), FoodTips.class);
			startActivity(i5);
			break;
		case R.id.imageButton6:
			Intent i6 = new Intent(getApplicationContext(), Settings.class);
			startActivity(i6);
			break;
		case R.id.imageButton7:
			System.exit(1);
		default:
			break;
		}
		
			
	}


	View.OnClickListener myhandler = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			btnClick(v);
		}
	};
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
