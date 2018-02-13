package com.example.admin.moneyconverter;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.example.admin.moneyconverter.data.db.DbProvider;
import com.example.admin.moneyconverter.data.db.DbProviderImpl;
import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.model.Valute;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class DbProviderInstrumentedTest {

    private DbProvider provider;
    private ValCurs model;

    @Before
    public void setUp() {
        DbProviderImpl.initInstance(InstrumentationRegistry.getTargetContext());
        provider = DbProviderImpl.getInstance();

        model = new ValCurs();
        model.setName("TestName");
        model.setDate("13.02.2018");
        Valute val = new Valute();
        val.setName("Testname");
        val.setNominal(1);
        val.setValue(45.3520);
        val.setCharCode("USD");
        val.setNumCode(1);
        model.setValute(new ArrayList<>(Arrays.asList(val)));
    }

    @Test
    public void testPreConditions() {
        assertNotNull(provider);
    }

    @Test
    public void saveToDb() throws Exception {
        long id = provider.saveResponseToDb(model);
        assertThat(id, is(not(-1)));
    }
}
