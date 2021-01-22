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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentItemListAdapter extends ArrayAdapter {
    ArrayList<Item> arrayList = new ArrayList<Item>();
    Activity context;
    String stu_id, stu_u_id;

    public StudentItemListAdapter(@NonNull Activity context, int resource, ArrayList<Item> arrayList, String stu_id, String stu_u_id) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.context = context;
        this.stu_id = stu_id;
        this.stu_u_id = stu_u_id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.student_item_list_row, null);

        TextView i_id, i_name, i_des, i_cost, i_time, i_can_name;
        Button btn;

        i_name = (TextView) view.findViewById(R.id.stu_item_name_l);
        i_des = (TextView) view.findViewById(R.id.stu_item_list_dis);
        i_cost = (TextView) view.findViewById(R.id.stu_item_cost_l);
        i_time = (TextView) view.findViewById(R.id.stu_item_time_l);
        i_can_name = (TextView) view.findViewById(R.id.stu_item_can_n_l);
        btn = (Button) view.findViewById(R.id.stu_item_list_btn);

        i_name.setText(arrayList.get(position).getItem_name_list());
        i_des.setText(arrayList.get(position).getItem_des_list());
        i_cost.setText(arrayList.get(position).getItem_cost_list());
        i_time.setText(arrayList.get(position).getItem_time_list());
        i_can_name.setText(arrayList.get(position).getItem_can_name());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Student_Order_Item_select.class);
                intent.putExtra("item_name", arrayList.get(position).item_name_list);
                intent.putExtra("item_cost", arrayList.get(position).item_cost_list);
                intent.putExtra("item_des", arrayList.get(position).item_des_list);
                intent.putExtra("item_time", arrayList.get(position).item_time_list);
                intent.putExtra("item_can_name", arrayList.get(position).item_can_name);
                intent.putExtra("item_can_id", arrayList.get(position).item_can_id);
                intent.putExtra("item_stu_id", stu_id);
                intent.putExtra("item_stu_u_id", stu_u_id);
                getContext().startActivity(intent);
                context.finish();
            }
        });

        return view;
    }
}
