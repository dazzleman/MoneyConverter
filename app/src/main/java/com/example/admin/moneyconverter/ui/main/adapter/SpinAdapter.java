package com.example.admin.moneyconverter.ui.main.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.moneyconverter.R;
import com.example.admin.moneyconverter.model.Valute;

import java.util.List;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class SpinAdapter extends BaseAdapter {

    private List<Valute> model;

    public SpinAdapter( @NonNull List<Valute> model) {
        this.model = model;
    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Valute getItem(int i) {
        return model.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_view_layout, parent, false);
        }

        TextView charCode = row.findViewById(R.id.spin_char_code);
        charCode.setText(model.get(position).getCharCode());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(parent.getContext()).inflate(R.layout.spinner_drop_down_view_layout, parent, false);
        }

        TextView charCode = row.findViewById(R.id.spin_char_code);
        TextView name = row.findViewById(R.id.spin_name);
        charCode.setText(model.get(position).getCharCode());
        name.setText(model.get(position).getName());
        return row;
    }
}
