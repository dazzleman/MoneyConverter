package com.example.admin.moneyconverter.ui.main;

import com.example.admin.moneyconverter.data.db.DbProviderImpl;
import com.example.admin.moneyconverter.data.network.NetworkProviderImpl;
import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.repository.DefaultRepository;
import com.example.admin.moneyconverter.repository.DefaultRepositoryImpl;
import com.example.admin.moneyconverter.ui.common.BasePresenter;
import com.example.admin.moneyconverter.ui.main.adapter.SpinAdapter;
import com.example.admin.moneyconverter.utils.CalculateUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private DefaultRepository repository = new DefaultRepositoryImpl(DbProviderImpl.getInstance(), new NetworkProviderImpl());
    private Boolean isLoading = false;
    private int inputValuteSelectedPosition = 0;
    private int outputValuteSelectedPosition = 1;
    private SpinAdapter adapter;

    @Override
    public void init() {
        if (!isLoading) {
            downloadXML();
        }
    }

    private void downloadXML() {
        isLoading = true;
        executor.submit(() -> {
            ValCurs model = repository.getXmlFromNetwork();
            if (model != null) {
                setUI(model);
                if(!model.isCache()) writeModelToDB(model);
            }
            isLoading = false;
        });
    }

    private void setUI(ValCurs model) {
        adapter = new SpinAdapter(model.getValute());
        if (view != null) {
            view.setSpinnerAdapter(adapter);
            view.loadUI(model);
            view.setInputSelected(inputValuteSelectedPosition);
            view.setOutputSelected(outputValuteSelectedPosition);
        }
    }

    private void writeModelToDB(ValCurs val) {
        if (val != null) {
            repository.saveResponseToDb(val);
        }
    }

    @Override
    public void runCalculate(String value) {
        String result = CalculateUtils.calculate(value, adapter.getItem(inputValuteSelectedPosition), adapter.getItem(outputValuteSelectedPosition));
        if (result != null) view.showResultCalculate(result);
    }

    @Override
    public void setInputValute(int inputValuteSelectedPosition) {
        this.inputValuteSelectedPosition = inputValuteSelectedPosition;
    }

    @Override
    public void setOutputValute(int outputValuteSelectedPosition) {
        this.outputValuteSelectedPosition = outputValuteSelectedPosition;
    }

    @Override
    public void detachView() {
        super.detachView();
        executor.shutdown();
    }
}
