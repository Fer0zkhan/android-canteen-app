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
    ArrayList stu_id_tp = new ArrayList();
    ArrayList stu_uni_id = new ArrayList();
    public StudentAdapter(@NonNull Activity context, int resource, ArrayList stu_id, ArrayList stu_uni_id) {
        super(context, resource, stu_uni_id);

        this.stu_id_tp = stu_id;
        this.stu_uni_id = stu_uni_id;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.student_list_row, null);

        TextView stu_id_t, stu_uni_id_t;

        stu_id_t = (TextView)view.findViewById(R.id.stu_list_id);
        stu_uni_id_t = (TextView)view.findViewById(R.id.stu_list_uni_id);

        stu_id_t.setText(stu_id_tp.get(position).toString());
        stu_uni_id_t.setText(stu_uni_id.get(position).toString());

        return view;
    }
}
