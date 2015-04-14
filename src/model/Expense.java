/**********************************************************
 * File: Expense.java
 * Purpose: Hold all the attributes and methods of Expense
 *********************************************************/		
package model;

public class Expense
{
    protected String name;
    protected String description;
    protected double value;
    protected int day;
    protected int month;
    protected int year;
    
    /* Constructor to receive all the attributes as parameters and initialize the
     * object Expense*/
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

    // Method to return the content of attribute name
    public String getName()
    {
        return name;
    }

    // Method to set a content on variable name
    public void setName(String name)
    {
        this.name = name;
    }

    // Method to return the content of attribute description
    public String getDescription()
    {
        return description;
    }

    // Method to set a content on variable description
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Method to return the content of attribute value
    public double getValue()
    {
        return value;
    }

    // Method to set a content on variable value
    public void setValue(double value)
    {
        this.value = value;
    }

    // Method to return the content of attribute month
    public int getMonth()
    {
        return month;
    }

    // Method to set a content on variable month
    public void setMonth(int month)
    {
        this.month = month;
    }

    // Method to return the content of attribute year
    public int getYear()
    {
        return year;
    }

    // Method to set a content on variable year
    public void setYear(int year)
    {
        this.year = year;
    }

    // Method to return the content of attribute day
    public int getDay()
    {
        return day;
    }

    // Method to set a content on variable day
    public void setDay(int day)
    {
        this.day = day;
    }
    
}
