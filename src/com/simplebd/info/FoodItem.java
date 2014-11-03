package com.simplebd.info;

public class FoodItem {
	//private variables
	int _id;
	String _name;
	String _type;
	String _quantity;
	String _date_purchased;
	String _expiration_date;
	
	
	//Empty Constructor
	public FoodItem()
	{
	}
	
	//constructor
	public FoodItem(int id, String name, String type, String quantity, String date_purchased, String expiration_date)
	{
		this._id = id;
		this._type = type;
		this._quantity = quantity;
		this._date_purchased = date_purchased;
		this._expiration_date = expiration_date;
	}
	
	//constructor
	public FoodItem(String name, String type, String quantity, String date_purchased, String expiration_date)
	{
		this._type = type;
		this._quantity = quantity;
		this._date_purchased = date_purchased;
		this._expiration_date = expiration_date;
	}
	
	
	//getting ID
	public int getID()
	{
		return this._id;
	}
	
	//getting name
	public String getName()
	{
		return this._name;
	}
	
	//getting type
	public String getType()
	{
		return this._type;
	}
	
	//getting quantity
	public String getQuantity()
	{
		return this._quantity;
	}
	
	
	//getting date purchased
	public String getDatePurchased()
	{
		return this._date_purchased;
	}
	
	//getting expiration date
	public String getExpirationDate()
	{
		return this._expiration_date;
	}
	
	
	//setting id
	public void setID(int id)
	{
		this._id = id;
	}
	
	//setting name
	public void setName(String name)
	{
		this._name = name;
	}
	
	//setting type
	public void setType(String type)
	{
		this._type = type;
	}
	//setting quantity
	public void setQuantity(String quantity)
	{
		this._quantity = quantity;
	}
	
	//setting date purchased
	public void setDatePurchased(String datePurchased)
	{
		this._date_purchased = datePurchased;
	}
	
	//setting expiration date
	public void setExpirationDate(String expirationDate)
	{
		this._expiration_date = expirationDate;
	}
	

}
