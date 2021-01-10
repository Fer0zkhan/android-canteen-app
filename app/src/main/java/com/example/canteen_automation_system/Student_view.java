package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Student_view extends AppCompatActivity {
    ListView listView;
    ArrayList stu_id_db = new ArrayList();
    ArrayList stu_uni_id_db = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);

        stu_id_db.add("1");
        stu_uni_id_db.add("F2017266419");

        stu_id_db.add("2");
        stu_uni_id_db.add("F2017266419");

        stu_id_db.add("3");
        stu_uni_id_db.add("F2017266419");

        listView = findViewById(R.id.stu_listview);
        StudentAdapter studentAdapter = new StudentAdapter(this, R.layout.student_list_row,stu_id_db,stu_uni_id_db);
        listView.setAdapter(studentAdapter);
    }
}