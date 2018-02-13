package com.example.admin.moneyconverter.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

@Root(name="ValCurs")
public class ValCurs
{
    private String date;
    private String name;
    private List<Valute> valute;
    private boolean isCache;

    @Attribute(name="Date")
    public String getDate ()
    {
        return date;
    }

    @Attribute(name="Date")
    public void setDate (String Date)
    {
        this.date = Date;
    }

    @Attribute(name="name")
    public String getName ()
    {
        return name;
    }

    @Attribute(name="name")
    public void setName (String name)
    {
        this.name = name;
    }

    @ElementList(inline=true, name="Valute")
    public List<Valute> getValute ()
    {
        return valute;
    }

    @ElementList(inline=true, name="Valute")
    public void setValute (List<Valute> valute)
    {
        this.valute = valute;
    }

    public boolean isCache() {
        return isCache;
    }

    public void setCache(boolean cache) {
        isCache = cache;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+ date +", name = "+name+", "+"]";
    }
}
