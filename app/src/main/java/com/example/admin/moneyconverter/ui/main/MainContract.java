package com.example.admin.moneyconverter.ui.main;

import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.ui.common.BaseContract;
import com.example.admin.moneyconverter.ui.main.adapter.SpinAdapter;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public interface MainContract {

    interface View extends BaseContract.View {
        void loadUI(ValCurs val);
        void setSpinnerAdapter(SpinAdapter adapter);
        void showResultCalculate(String result);
        void setInputSelected(int position);
        void setOutputSelected(int position);
    }

    interface Presenter extends BaseContract.Presenter<MainContract.View> {
        void init();
        void runCalculate(String value);
        void setInputValute(int inputValuteSelectedPosition);
        void setOutputValute(int outputValuteSelectedPosition);
    }
}
