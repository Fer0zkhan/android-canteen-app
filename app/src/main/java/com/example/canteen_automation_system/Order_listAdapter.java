package com.example.canteen_automation_system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Order_listAdapter extends ArrayAdapter {
    ArrayList<Order> arrayList = new ArrayList<Order>();
    Activity content;

    public Order_listAdapter(@NonNull Activity context, int resource, ArrayList<Order> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.content = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.order_list_row, null);

        TextView o_id, o_f_name, o_c_name, o_s_id;
        Button o_ready;
        DatabaseReference databaseReference, orderDatabase;
        databaseReference = FirebaseDatabase.getInstance().getReference("Transaction");
        orderDatabase = FirebaseDatabase.getInstance().getReference("Order");

        o_id = (TextView) view.findViewById(R.id.order_list_id);
        o_f_name = (TextView) view.findViewById(R.id.order_list_food_name);
        o_c_name = (TextView) view.findViewById(R.id.order_list_canteen_name);
        o_s_id = (TextView) view.findViewById(R.id.order_list_student_id);
        o_ready = (Button) view.findViewById(R.id.order_ready_btn);

        o_id.setText(arrayList.get(position).getOrder_id());
        o_f_name.setText(arrayList.get(position).getOrder_food_name());
        o_c_name.setText(arrayList.get(position).getOrder_food_cost());
        o_s_id.setText(arrayList.get(position).getOrder_student_id());

        o_ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = databaseReference.push().getKey();
                Transaction transaction = new Transaction(id, arrayList.get(position).order_id, arrayList.get(position).order_canteen_id, arrayList.get(position).order_canteen_name, arrayList.get(position).order_food_name, arrayList.get(position).order_food_cost, arrayList.get(position).order_student_unique_id);
                databaseReference.child(id).setValue(transaction);
                orderDatabase.child(arrayList.get(position).order_id).removeValue();
                Intent intent = new Intent(getContext(), Canteen_Dashboard.class);
                intent.putExtra("Canteen_id", arrayList.get(position).order_canteen_id);
                intent.putExtra("canteen_name", arrayList.get(position).order_canteen_name);
                getContext().startActivity(intent);
                content.finish();
            }
        });

        return view;
    }
}
