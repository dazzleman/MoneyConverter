package com.example.admin.moneyconverter.repository;

import com.example.admin.moneyconverter.model.ValCurs;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public interface DefaultRepository {

    void saveResponseToDb(ValCurs model);
    ValCurs getXmlFromNetwork();
}
