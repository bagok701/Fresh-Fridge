package com.example.freshfridge;

//Type of food constructor
public class Product {
    String name;
    String category;
    int quantity;
    String date_bought;
    String exp_date;
    boolean box; //Is box checked
      
      
      Product(String name, String category, String date, String exp, boolean box) {
        this.name = name;
        this.category = category;
        date_bought = date;
        exp_date = exp;
        this.box = box;
      }
    }