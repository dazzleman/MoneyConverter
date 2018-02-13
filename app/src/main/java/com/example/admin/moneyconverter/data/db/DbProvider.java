package com.example.admin.moneyconverter.data.db;

import com.example.admin.moneyconverter.model.ValCurs;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public interface DbProvider {

    long saveResponseToDb(ValCurs model);
}
