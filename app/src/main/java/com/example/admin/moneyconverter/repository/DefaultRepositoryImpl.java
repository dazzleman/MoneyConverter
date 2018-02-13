package com.example.admin.moneyconverter.repository;

import com.example.admin.moneyconverter.data.db.DbProvider;
import com.example.admin.moneyconverter.data.network.NetworkProvider;
import com.example.admin.moneyconverter.model.ValCurs;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class DefaultRepositoryImpl implements DefaultRepository {

    private DbProvider dbProvider;
    private NetworkProvider networkProvider;

    public DefaultRepositoryImpl(DbProvider dbProvider, NetworkProvider networkProvider) {
        this.dbProvider = dbProvider;
        this.networkProvider = networkProvider;
    }

    @Override
    public void saveResponseToDb(ValCurs model) {
        dbProvider.saveResponseToDb(model);
    }

    @Override
    public ValCurs getXmlFromNetwork() {
        return networkProvider.getXmlFromNetwork();
    }
}
