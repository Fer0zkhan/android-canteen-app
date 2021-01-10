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

public class Order_listAdapter extends ArrayAdapter {
    ArrayList order_id = new ArrayList();
    ArrayList order_food_name = new ArrayList();
    ArrayList order_canteen_name = new ArrayList();
    ArrayList order_student_id = new ArrayList();

    public Order_listAdapter(@NonNull Activity context, int resource, ArrayList order_id,
                             ArrayList order_food_name,
                             ArrayList order_canteen_name,
                             ArrayList order_student_id) {
        super(context, resource, order_food_name);

        this.order_id = order_id;
        this.order_food_name = order_food_name;
        this.order_canteen_name = order_canteen_name;
        this.order_student_id = order_student_id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.order_list_row, null);

        TextView o_id, o_f_name, o_c_name, o_s_id, o_ready;

        o_id = (TextView) view.findViewById(R.id.order_list_id);
        o_f_name = (TextView) view.findViewById(R.id.order_list_food_name);
        o_c_name = (TextView) view.findViewById(R.id.order_list_canteen_name);
        o_s_id = (TextView) view.findViewById(R.id.order_list_student_id);

        o_id.setText(order_id.get(position).toString());
        o_f_name.setText(order_food_name.get(position).toString());
        o_c_name.setText(order_canteen_name.get(position).toString());
        o_s_id.setText(order_student_id.get(position).toString());

        return view;
    }
}
