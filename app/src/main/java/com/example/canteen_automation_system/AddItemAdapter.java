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
    //    ArrayList item_id_list = new ArrayList();
//    ArrayList item_name_list = new ArrayList();
//    ArrayList item_des_list = new ArrayList();
//    ArrayList item_cost_list = new ArrayList();
//    ArrayList item_time_list = new ArrayList();
    ArrayList<Item> arrayList = new ArrayList<Item>();

    public AddItemAdapter(@NonNull Activity context, int resource, ArrayList<Item> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_list_row, null);

        TextView i_id, i_name, i_des, i_cost, i_time;

        i_id = (TextView) view.findViewById(R.id.item_list_id);
        i_name = (TextView) view.findViewById(R.id.item_list_name);
        i_des = (TextView) view.findViewById(R.id.item_list_des);
        i_cost = (TextView) view.findViewById(R.id.item_list_cost);
        i_time = (TextView) view.findViewById(R.id.item_list_time);

        i_id.setText(arrayList.get(position).getItem_id_list());
        i_name.setText(arrayList.get(position).getItem_name_list());
        i_des.setText(arrayList.get(position).getItem_des_list());
        i_cost.setText(arrayList.get(position).getItem_cost_list());
        i_time.setText(arrayList.get(position).getItem_time_list());

        return view;
    }
}
