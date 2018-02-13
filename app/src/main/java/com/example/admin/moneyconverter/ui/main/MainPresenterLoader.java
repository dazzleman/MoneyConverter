package com.example.admin.moneyconverter.ui.main;

import android.content.Context;
import android.content.Loader;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class MainPresenterLoader extends Loader<MainContract.Presenter> {

    private final MainPresenterFactory factory;
    private MainContract.Presenter presenter;

    public MainPresenterLoader(Context context, MainPresenterFactory factory) {
        super(context);
        this.factory = factory;
    }

    @Override
    protected void onStartLoading() {
        if (presenter != null) {
            deliverResult(presenter);
            return;
        }
        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        presenter = factory.create();
        deliverResult(presenter);
    }

    @Override
    protected void onReset() {
        presenter = null;
    }

}
