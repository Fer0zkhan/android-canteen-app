package com.example.canteen_automation_system;

import android.app.Activity;
import android.content.ClipboardManager;
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
    ArrayList<Canteen> arrayList = new ArrayList<Canteen>();
    Activity context;

    public CanteenAdapter(@NonNull Activity context, int resource, ArrayList<Canteen> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.canteen_list_row, null);

        TextView can_list_id, can_list_name, can_list_han, can_list_phone, can_list_work, can_list_address;


        can_list_id = (TextView) view.findViewById(R.id.can_id);
        can_list_name = (TextView) view.findViewById(R.id.can_list_name);
        can_list_han = (TextView) view.findViewById(R.id.can_list_handle);
        can_list_phone = (TextView) view.findViewById(R.id.can_num_list);
        can_list_work = (TextView) view.findViewById(R.id.can_list_worker);
        can_list_address = (TextView) view.findViewById(R.id.can_address_list);


        can_list_id.setText(arrayList.get(position).getCanteen_id());
        can_list_name.setText(arrayList.get(position).getCanteen_name());
        can_list_han.setText(arrayList.get(position).getCanteen_handler());
        can_list_phone.setText(arrayList.get(position).getCanteen_phone());
        can_list_work.setText(arrayList.get(position).getCanteen_work());
        can_list_address.setText(arrayList.get(position).getCanteen_address());

        return view;
    }
}
