package com.example.admin.moneyconverter.ui.common;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

    protected V view = null;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
