package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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
    String id, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen__transaction);

        databaseReference = FirebaseDatabase.getInstance().getReference("Transaction");
        id = getIntent().getStringExtra("c_login_id");
        name = getIntent().getStringExtra("c_name");
        listView = findViewById(R.id.transaction_listview);

//        Toast.makeText(this, id + name, Toast.LENGTH_SHORT).show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    Transaction transaction = data.getValue(Transaction.class);
                    if (name.equalsIgnoreCase(transaction.getTransaction_canteen_name()) || id.equalsIgnoreCase(transaction.getTransaction_canteen_id())) {
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Canteen_Transaction.this, Canteen_Dashboard.class);
        intent.putExtra("Canteen_id", id);
        intent.putExtra("canteen_name", name);
        startActivity(intent);
        finish();
    }

}