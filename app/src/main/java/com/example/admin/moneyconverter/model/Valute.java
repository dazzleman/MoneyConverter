package com.example.admin.moneyconverter.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

@Root(name="Valute")
public class Valute
{
    private String Name;
    private double Value;
    private int Nominal;
    private String CharCode;
    private int NumCode;

    @Element(name="Name")
    public String getName ()
    {
        return Name;
    }

    @Element(name="Name")
    public void setName (String Name)
    {
        this.Name = Name;
    }

    @Element(name="Value")
    public double getValue ()
    {
        return Value;
    }

    @Element(name="Value")
    public void setValue (double Value)
    {
        this.Value = Value;
    }

    @Element(name="Nominal")
    public int getNominal ()
    {
        return Nominal;
    }

    @Element(name="Nominal")
    public void setNominal (int Nominal)
    {
        this.Nominal = Nominal;
    }

    @Element(name="CharCode")
    public String getCharCode ()
    {
        return CharCode;
    }

    @Element(name="CharCode")
    public void setCharCode (String CharCode)
    {
        this.CharCode = CharCode;
    }

    @Element(name="NumCode")
    public int getNumCode ()
    {
        return NumCode;
    }

    @Element(name="NumCode")
    public void setNumCode (int NumCode)
    {
        this.NumCode = NumCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Name = "+Name+", Value = "+Value+", Nominal = "+Nominal+", CharCode = "+CharCode+", NumCode = "+NumCode+"]";
    }
}
