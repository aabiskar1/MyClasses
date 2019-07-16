package com.aabiskar.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class FridayRecyclerActivity extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference sundayRef = db.collection("c1").document("days").collection("sunday");
    private CollectionReference mondayRef = db.collection("c1").document("days").collection("monday");
    private CollectionReference tuesdayRef = db.collection("c1").document("days").collection("tuesday");
    private CollectionReference wednesdayRef = db.collection("c1").document("days").collection("wednesday");
    private CollectionReference thursdayRef = db.collection("c1").document("days").collection("thursday");
    private CollectionReference fridayRef = db.collection("c1").document("days").collection("friday");

    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friday_recycler);
        setUpRecyclerView();

//        /* starts before 1 month from now */
//        Calendar startDate = Calendar.getInstance();
//        startDate.add(Calendar.MONTH, -1);
//
//        /* ends after 1 month from now */
//        Calendar endDate = Calendar.getInstance();
//        endDate.add(Calendar.MONTH, 1);
//
//
//        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarViewFriday)
//                .range(startDate, endDate)
//                .datesNumberOnScreen(5)
//                .build();
//
//        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
//            @Override
//            public void onDateSelected(Calendar date, int position) {
//                //do something
//            }
//        });

    }

    private void setUpRecyclerView(){
        Query query = fridayRef.orderBy("module_order", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<DataItems> options = new FirestoreRecyclerOptions.Builder<DataItems>()
                .setQuery(query,DataItems.class)
                .build();
        adapter = new DataAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_friday);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
