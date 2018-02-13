package com.example.admin.moneyconverter.ui.main;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin.moneyconverter.R;
import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.ui.main.adapter.SpinAdapter;

public class MainActivity extends AppCompatActivity implements MainContract.View, LoaderManager.LoaderCallbacks<MainContract.Presenter> {

    private static final int LOADER_ID = 102;
    private MainContract.Presenter presenter;

    private TextView titleDateHeader;
    private TextView editValueInput;
    private TextView editValueOutput;
    private Spinner spinnerInput;
    private Spinner spinnerOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLoaderManager().initLoader(LOADER_ID, null, this);

        titleDateHeader = findViewById(R.id.titleDate);
        editValueInput = findViewById(R.id.editValueInput);
        editValueOutput = findViewById(R.id.editValueOutput);
        spinnerInput = findViewById(R.id.spinInput);
        spinnerOutput = findViewById(R.id.spinOutput);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener((view) -> presenter.runCalculate(editValueInput.getText().toString()));
    }

    @Override
    public void loadUI(final ValCurs val) {
        runOnUiThread(() -> titleDateHeader.setText(getString(R.string.title_date,val.getDate())));
    }

    @Override
    public void setSpinnerAdapter(final SpinAdapter adapter) {
        runOnUiThread(() -> {
            initSpinnerInput(adapter);
            initSpinnerOutput(adapter);
        });
    }

    @Override
    public void setInputSelected(final int position) {
        runOnUiThread(() -> spinnerInput.setSelection(position));
    }

    @Override
    public void setOutputSelected(final int position) {
        runOnUiThread(() ->  spinnerOutput.setSelection(position));
    }

    @Override
    public void showResultCalculate(String result) {
        editValueOutput.setText(result);
    }

    private void initSpinnerInput(final SpinAdapter adapter){
        spinnerInput.setAdapter(adapter);
        spinnerInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.setInputValute(i);
                editValueOutput.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void initSpinnerOutput(final SpinAdapter adapter){
        spinnerOutput.setAdapter(adapter);
        spinnerOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.setOutputValute(i);
                editValueOutput.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public Loader<MainContract.Presenter> onCreateLoader(int id, Bundle args) {
        MainPresenterFactory<MainContract.Presenter> factory = new MainPresenterFactory<MainContract.Presenter>() {
            @Override
            public MainContract.Presenter create() {
                return new MainPresenter();
            }
        };
        return new MainPresenterLoader(getBaseContext(), factory);
    }

    @Override
    public void onLoadFinished(Loader<MainContract.Presenter> loader, MainContract.Presenter presenter) {
        this.presenter = presenter;
        this.presenter.attachView(this);
        this.presenter.init();
    }

    @Override
    public void onLoaderReset(Loader<MainContract.Presenter> loader) {
        presenter.detachView();
        presenter = null;
    }
}
