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

public class AddItemAdapter extends ArrayAdapter {
    ArrayList item_id_list = new ArrayList();
    ArrayList item_name_list = new ArrayList();
    ArrayList item_des_list = new ArrayList();
    ArrayList item_cost_list = new ArrayList();
    ArrayList item_time_list = new ArrayList();
    public AddItemAdapter(@NonNull Activity context, int resource,ArrayList item_id_list, ArrayList item_name_list, ArrayList item_des_list, ArrayList item_cost_list, ArrayList item_time_list) {
        super(context, resource, item_name_list);
        this.item_id_list = item_id_list;
        this.item_name_list = item_name_list;
        this.item_des_list = item_des_list;
        this.item_cost_list = item_cost_list;
        this.item_time_list = item_time_list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_list_row, null);

        TextView i_id, i_name, i_des, i_cost, i_time;

        i_id = (TextView)view.findViewById(R.id.item_list_id);
        i_name = (TextView)view.findViewById(R.id.item_list_name);
        i_des = (TextView)view.findViewById(R.id.item_list_des);
        i_cost = (TextView)view.findViewById(R.id.item_list_cost);
        i_time = (TextView)view.findViewById(R.id.item_list_time);

        i_id.setText(item_id_list.get(position).toString());
        i_name.setText(item_name_list.get(position).toString());
        i_des.setText(item_des_list.get(position).toString());
        i_cost.setText(item_cost_list.get(position).toString());
        i_time.setText(item_time_list.get(position).toString());

        return view;
    }
}
