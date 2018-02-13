package com.example.admin.moneyconverter.ui.main;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public interface MainPresenterFactory<T extends MainContract.Presenter> {
    T create();
}
