package com.example.admin.moneyconverter.utils;

import android.util.Log;

import com.example.admin.moneyconverter.model.ValCurs;

import org.simpleframework.xml.core.Persister;

import java.io.Reader;
import java.io.StringReader;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class ParseUtils {

    public static ValCurs parseXML(String xml) {
        Reader reader = new StringReader(xml.replace(",", "."));
        Persister serializer = new Persister();
        try {
            return serializer.read(ValCurs.class, reader, false);
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }
        return null;
    }
}
