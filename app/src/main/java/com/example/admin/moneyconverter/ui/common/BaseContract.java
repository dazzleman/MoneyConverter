package com.example.admin.moneyconverter.ui.common;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class BaseContract {

    public interface View {

    }

    public interface Presenter<V extends BaseContract.View> {

        void attachView(V view);
        void detachView();
    }
}
