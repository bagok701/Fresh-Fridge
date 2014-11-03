package com.example.freshfridge;

import com.example.freshfridge.ListAdapter;
import com.example.freshfridge.Product;

import java.util.ArrayList;



import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.os.Build;

public class GroceryList extends Activity {
	ArrayList<Product> products = new ArrayList<Product>();
    ListAdapter boxAdapter;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocery_list);

		fillData();
        boxAdapter = new ListAdapter(this, products);

        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
      }

      //Input data here 
      void fillData() {
    	  products.add(new Product("Apples", "Fruit", "11/02/2014", "11/15/2014", false));
    	  products.add(new Product("Spinach", "Vegetable", "10/31/2014", "11/05/2014", false));
    	  products.add(new Product("Chicken", "Meat", "10/19/2014", "11/10/2014", false));
    	  products.add(new Product("Broccoli", "Vegetable", "10/29/2014", "11/12/2014", false));
    	  products.add(new Product("Milk", "Dairy", "11/02/2014", "11/18/2014", false));
    	  products.add(new Product("Eggs", "Poultry", "10/29/2014", "12/10/2014", false));
    	  products.add(new Product("Ham", "Meat", "12/02/2014", "12/14/2014", false));
      }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grocery_list, menu);
		return true;
	}

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
