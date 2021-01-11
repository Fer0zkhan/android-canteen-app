package com.example.canteen_automation_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class StuDent_Transaction_history extends AppCompatActivity {
    ListView listView;
    ArrayList tran_id = new ArrayList();
    ArrayList tran_c_name = new ArrayList();
    ArrayList tran_f_name = new ArrayList();
    ArrayList tran_f_cost = new ArrayList();
    ArrayList tran_s_id = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_dent__transaction_history);

        tran_id.add("1");
        tran_c_name.add("Alpha Cafe");
        tran_f_name.add("Pizza Paratha");
        tran_f_cost.add("200");
        tran_s_id.add("f201837727");

        tran_id.add("1");
        tran_c_name.add("Alpha Cafe");
        tran_f_name.add("Pizza Paratha");
        tran_f_cost.add("200");
        tran_s_id.add("f201837727");

        listView = findViewById(R.id.stu_tran_his);
        TransactionAdapter transactionAdapter = new TransactionAdapter(this,R.layout.transaction_list_row,tran_id, tran_c_name,tran_f_name,tran_f_cost,tran_s_id);
        listView.setAdapter(transactionAdapter);
    }
}