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

public class StudentAdapter extends ArrayAdapter {
    ArrayList<Student> arrayList = new ArrayList<Student>();
    Activity context;

    public StudentAdapter(@NonNull Activity context, int resource, ArrayList<Student> arrayList) {
        super(context, resource, arrayList);

        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.student_list_row, null);

        TextView stu_id_t, stu_uni_id_t, ss_bal;

        stu_id_t = (TextView) view.findViewById(R.id.stu_list_id);
        stu_uni_id_t = (TextView) view.findViewById(R.id.stu_list_uni_id);
        ss_bal = (TextView) view.findViewById(R.id.stu_list_cost);

        stu_id_t.setText(arrayList.get(position).getId());
        stu_uni_id_t.setText(arrayList.get(position).getStudent_id());
        ss_bal.setText(arrayList.get(position).getStudent_balance());

        return view;
    }
}
