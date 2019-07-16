package com.aabiskar.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class DataCard extends AppCompatActivity  {
    FloatingActionButton closeBtn;
    public DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_card);

        closeBtn = findViewById(R.id.closeFabBtn);


        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);



//        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarViewDataCard)
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

}
