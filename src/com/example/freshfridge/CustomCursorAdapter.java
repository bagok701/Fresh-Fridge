package com.example.freshfridge;

import android.content.*;
import android.database.*;
import android.support.v4.widget.CursorAdapter;
import android.view.*;
import android.widget.*;

public class CustomCursorAdapter extends CursorAdapter{

	@SuppressWarnings("deprecation")
	public CustomCursorAdapter(Context context, Cursor cursor) {
		super(context, cursor);
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(parent.getContext());
		View retView = inflater.inflate(R.layout., parent, false); 
		return retView;
	}

}
