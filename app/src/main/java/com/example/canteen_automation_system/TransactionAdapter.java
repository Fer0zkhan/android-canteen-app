package com.example.canteen_automation_system;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter {
    ArrayList tran_id = new ArrayList();
    ArrayList tran_c_name = new ArrayList();
    ArrayList tran_f_name = new ArrayList();
    ArrayList tran_f_cost = new ArrayList();
    ArrayList tran_s_id = new ArrayList();
    public TransactionAdapter(@NonNull Activity context, int resource,ArrayList tran_id ,
    ArrayList tran_c_name,
    ArrayList tran_f_name,
    ArrayList tran_f_cost ,
    ArrayList tran_s_id) {
        super(context, resource, tran_c_name);

        this.tran_id = tran_id;
        this.tran_c_name = tran_c_name;
        this.tran_f_name = tran_f_name;
        this.tran_f_cost = tran_f_cost;
        this.tran_s_id = tran_s_id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.transaction_list_row, null);

        TextView t_id, t_c_name, t_f_name, t_s_id, t_f_c;

        t_id = (TextView) view.findViewById(R.id.tran_id);
        t_c_name = (TextView) view.findViewById(R.id.tran_c_name);
        t_f_name = (TextView) view.findViewById(R.id.tran_f_name);
        t_f_c = (TextView) view.findViewById(R.id.tran_food_cost);
        t_s_id = (TextView) view.findViewById(R.id.tran_s_id);

        t_id.setText(tran_id.get(position).toString());
        t_c_name.setText(tran_c_name.get(position).toString());
        t_f_name.setText(tran_f_name.get(position).toString());
        t_f_c.setText(tran_f_cost.get(position).toString());
        t_s_id.setText(tran_s_id.get(position).toString());

        return view;
    }
}
