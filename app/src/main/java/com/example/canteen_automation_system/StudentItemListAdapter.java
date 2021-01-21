package com.example.canteen_automation_system;

import android.app.Activity;
import android.content.Context;
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
        DatabaseReference databaseReference, studentDatabase;
        databaseReference = FirebaseDatabase.getInstance().getReference("Order");
        studentDatabase = FirebaseDatabase.getInstance().getReference("Student");


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
                studentDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren()) {
                            Student student = data.getValue(Student.class);
                            int student_cost = Integer.parseInt(student.student_balance);
                            int actual_cost = Integer.parseInt(arrayList.get(position).item_cost_list);
                            if (student_cost < actual_cost) {
                                Toast.makeText(context, "Your Balance is low to order!", Toast.LENGTH_SHORT).show();
                            } else {
                                String id = databaseReference.push().getKey();
                                Order order = new Order(id, arrayList.get(position).getItem_name_list(), arrayList.get(position).getItem_cost_list(), arrayList.get(position).getItem_can_name(), arrayList.get(position).canteen_id, stu_id, stu_u_id);
                                databaseReference.child(id).setValue(order);
                                int result_cost = student_cost - actual_cost;
                                studentDatabase.child(stu_u_id).child("student_balance").setValue(String.valueOf(result_cost));
                                Toast.makeText(context, "Place Order Successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        return view;
    }
}
