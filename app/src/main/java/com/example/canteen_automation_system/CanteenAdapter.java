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

public class CanteenAdapter extends ArrayAdapter {
    ArrayList can_id = new ArrayList();
    ArrayList can_nae = new ArrayList();
    ArrayList can_phone = new ArrayList();
    ArrayList can_work = new ArrayList();
    ArrayList can_hand = new ArrayList();
    ArrayList can_address = new ArrayList();
    public CanteenAdapter(@NonNull Activity context, int resource, ArrayList can_id, ArrayList can_name, ArrayList can_han, ArrayList can_num, ArrayList can_work, ArrayList can_address) {
        super(context, resource, can_name);

        this.can_id = can_id;
        this.can_nae = can_name;
        this.can_hand = can_han;
        this.can_phone = can_num;
        this.can_work = can_work;
        this.can_address = can_address;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.canteen_list_row, null);

        TextView can_list_id, can_list_name, can_list_han, can_list_phone, can_list_work, can_list_address;

        can_list_id = (TextView)view.findViewById(R.id.can_id);
        can_list_name = (TextView)view.findViewById(R.id.can_list_name);
        can_list_han = (TextView)view.findViewById(R.id.can_list_handle);
        can_list_phone = (TextView)view.findViewById(R.id.can_num_list);
        can_list_work = (TextView)view.findViewById(R.id.can_list_worker);
        can_list_address = (TextView)view.findViewById(R.id.can_address_list);

        can_list_id.setText(can_id.get(position).toString());
        can_list_name.setText(can_nae.get(position).toString());
        can_list_han.setText(can_hand.get(position).toString());
        can_list_phone.setText(can_phone.get(position).toString());
        can_list_work.setText(can_work.get(position).toString());
        can_list_address.setText(can_address.get(position).toString());

        return view;
    }
}
