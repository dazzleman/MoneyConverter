package com.example.admin.moneyconverter.data.network;

import com.example.admin.moneyconverter.model.ValCurs;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public interface NetworkProvider {

    ValCurs getXmlFromNetwork();
    ValCurs getXmlFromCache();
}
