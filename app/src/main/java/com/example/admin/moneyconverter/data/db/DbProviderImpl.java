package com.example.admin.moneyconverter.data.db;

import android.content.Context;

import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.model.Valute;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class DbProviderImpl implements DbProvider {

    private static DbProviderImpl instance;

    public static DbProviderImpl initInstance(Context context){
        if (instance == null) {
            instance = new DbProviderImpl(context);
        }
        return instance;
    }

    public static DbProviderImpl getInstance(){
        return instance;
    }

    private DbHelper dbHelper;

    private DbProviderImpl(Context context) {
        dbHelper = new DbHelper(context);
    }

    @Override
    public long saveResponseToDb(ValCurs model) {
        long id = dbHelper.addValCursToTable(model.getName(), model.getDate());
        if (id != -1) {
            for (Valute val: model.getValute()){
                dbHelper.addValuteToTable(val.getName(),val.getValue(), val.getNominal(), val.getCharCode(), val.getNumCode(), id);
            }
        }
        return id;
    }
}
