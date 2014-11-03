package com.simplebd.info;

import com.example.freshfridge.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class Fridge extends Activity {
	
	Button addItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fridge);
		
		addItem = new Button(this);
		
		addItem = (Button)findViewById(R.id.button2);
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fridge, menu);
		return true;
	}
	
	public void btnClick(View v)
	{
		switch(v.getId()){
		case R.id.button2:
			Intent i1 = new Intent(getApplicationContext(), AddItem.class);
			startActivity(i1);
			break;
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
