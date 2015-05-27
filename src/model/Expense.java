/**********************************************************
 * File: Expense.java
 * Purpose: Hold all the attributes and methods of Expense
 *********************************************************/		

package model;

public class Expense
{
    protected String name; // Describes the name of the expense
    protected String description; // Describes the description of the expense
    protected double value; // Describes the value of the expense
    protected int day; // Describes the day of the expense (only numbers; 1 <= day <= 31)
    protected int month; // Describes the month of the expense (only numbers; 1 <= day <= 12)
    protected int year; // Describes the year of the expense (only number; 2000 <= year <= 2015)
    
    // Constructor to receive all the attributes as parameters and initialize the object Expense
    public Expense(String name,
    			   String description,
    			   double value,
    			   int day,
    			   int month,
    			   int year)
    {
        this.name = name;
        this.description = description;
        this.value = value;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Access and returns the property name
    public String getName()
    {
        return name;
    }

    // Sets a new value for the name property
    public void setName(String name)
    {
        this.name = name;
    }

    // Access and returns the property description
    public String getDescription()
    {
        return description;
    }

    // Sets a new value for the description property
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Access and returns the property value
    public double getValue()
    {
        return value;
    }

    // Sets a new value for the value property
    public void setValue(double value)
    {
        this.value = value;
    }

    // Access and returns the property month
    public int getMonth()
    {
        return month;
    }

    // Sets a new value for the month property
    public void setMonth(int month)
    {
        this.month = month;
    }

    // Access and returns the property year
    public int getYear()
    {
        return year;
    }

    // Sets a new value for the year property
    public void setYear(int year)
    {
        this.year = year;
    }

    // Access and returns the property day
    public int getDay()
    {
        return day;
    }

    // Sets a new value for the day property
    public void setDay(int day)
    {
        this.day = day;
    }
}
