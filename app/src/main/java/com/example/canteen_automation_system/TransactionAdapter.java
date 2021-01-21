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
    ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
    Activity context;

    public TransactionAdapter(@NonNull Activity context, int resource, ArrayList<Transaction> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
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

        t_id.setText(arrayList.get(position).getId());
        t_c_name.setText(arrayList.get(position).getTransaction_canteen_name());
        t_f_name.setText(arrayList.get(position).getTransaction_food_name());
        t_f_c.setText(arrayList.get(position).getTransaction_cost());
        t_s_id.setText(arrayList.get(position).getTransaction_student_id());

        return view;
    }
}
