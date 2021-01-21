package com.example.canteen_automation_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Add_Canteen_View extends AppCompatActivity {
    ListView listView;
    ArrayList<Canteen> arrayList = new ArrayList<Canteen>();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__canteen__view);

        databaseReference = FirebaseDatabase.getInstance().getReference("Canteen");
        listView = findViewById(R.id.canlist);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Canteen canteen = postSnapshot.getValue(Canteen.class);
                    arrayList.add(canteen);
                }
                CanteenAdapter canteenAdapter = new CanteenAdapter(Add_Canteen_View.this, R.layout.canteen_list_row, arrayList);
                listView.setAdapter(canteenAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Add_Canteen_View.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });

//        canteen.setCanteen_id("1");
//        canteen.setCanteen_name("Alpha");
//        canteen.setCanteen_handler("Ali Raza");
//        canteen.setCanteen_phone("032234223");
//        canteen.setCanteen_work("12");
//        canteen.setCanteen_address("Umt Road Lahore");
//        arrayList.add(canteen);
//
//        canteen.setCanteen_id("2");
//        canteen.setCanteen_name("Alpha");
//        canteen.setCanteen_handler("Ali Raza");
//        canteen.setCanteen_phone("032234223");
//        canteen.setCanteen_work("12");
//        canteen.setCanteen_address("Umt Road Lahore");
//        arrayList.add(canteen);


    }

}