package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Canteen_Transaction extends AppCompatActivity {

    ListView listView;
    ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
    DatabaseReference databaseReference;
    String u_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen__transaction);

        databaseReference = FirebaseDatabase.getInstance().getReference("Transaction");
        u_id = getIntent().getStringExtra("c_login_id");
        listView = findViewById(R.id.transaction_listview);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Transaction transaction = data.getValue(Transaction.class);
                    if (u_id.equalsIgnoreCase(transaction.transaction_canteen_id)) {
                        arrayList.add(transaction);
                        TransactionAdapter transactionAdapter = new TransactionAdapter(Canteen_Transaction.this, R.layout.transaction_list_row, arrayList);
                        listView.setAdapter(transactionAdapter);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}