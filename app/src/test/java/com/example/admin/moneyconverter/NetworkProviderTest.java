package com.example.admin.moneyconverter;

import com.example.admin.moneyconverter.data.network.NetworkProvider;
import com.example.admin.moneyconverter.data.network.NetworkProviderImpl;
import com.example.admin.moneyconverter.model.ValCurs;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Nikolay Vlaskin on 13.02.2018.
 */

public class NetworkProviderTest {

    private NetworkProvider provider;

    @Before
    public void setUp() throws Exception {
        provider = new NetworkProviderImpl();
    }

    @Test
    public void getXmlFromNetwork() throws Exception {
        assertEquals(true, checkExistData(provider.getXmlFromNetwork()));
    }

    @Test
    public void getXmlFromCache() throws Exception {
        assertEquals(true, checkExistData(provider.getXmlFromCache()));
    }

    private boolean checkExistData(ValCurs model){
        if (model != null) {
            System.out.println(model.getDate());
            System.out.println(model.getValute().get(0).getName());
            System.out.println(model.getValute().get(0).getValue());
            if (model.isCache()) System.out.println("From cache");
            return true;
        } else return false;
    }
}
