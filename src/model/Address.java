/**********************************************************
 * File: Address.java
 * Purpose: Holds all the attributes and methods of the
 * 		    class Address.
 *********************************************************/	

package model;

public class Address
{
    private String street;
    private String number;
    private String city;
    private String state;
    private String country;
    private String complement;

    // Constructor of the Address' class
    public Address(String street,
                   String number,
                   String city,
                   String state,
                   String country,
                   String complement)
    {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complement = complement;
    }

    // Access and returns the property street
    public String getStreet()
    {
        return street;
    }

    // Sets a new value for the street property
    public void setStreet(String street)
    {
        this.street = street;
    }

    // Access and returns the property number
    public String getNumber()
    {
        return number;
    }

    // Sets a new value for the number property
    public void setNumber(String number)
    {
        this.number = number;
    }

    // Access and returns the property city
    public String getCity()
    {
        return city;
    }

    // Sets a new value for the city property
    public void setCity(String city)
    {
        this.city = city;
    }

    // Access and returns the property state
    public String getState()
    {
        return state;
    }

    // Sets a new value for the state property
    public void setState(String state)
    {
        this.state = state;
    }

    // Access and returns the property country
    public String getCountry()
    {
        return country;
    }

    // Sets a new value for the country property
    public void setCountry(String country)
    {
        this.country = country;
    }

    // Access and returns the property complement
    public String getComplement()
    {
        return complement;
    }

    // Sets a new value for the complement property
    public void setComplement(String complement)
    {
        this.complement = complement;
    }
}
