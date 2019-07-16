package com.aabiskar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.tfb.fbtoast.FBToast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RelativeLayout sunday_card,monday_card,tuesday_card,wednesday_card,thursday_card,friday_card;

    private static final String TAG = "MainActivity";

    TextView sundayCounter,mondayCounter,tuesdayCounter,wednesdayCounter,thursdayCounter,fridayCounter;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference sundayRef = db.collection("c1").document("days").collection("sunday");
    private CollectionReference mondayRef = db.collection("c1").document("days").collection("monday");
    private CollectionReference tuesdayRef = db.collection("c1").document("days").collection("tuesday");
    private CollectionReference wednesdayRef = db.collection("c1").document("days").collection("wednesday");
    private CollectionReference thursdayRef = db.collection("c1").document("days").collection("thursday");
    private CollectionReference fridayRef = db.collection("c1").document("days").collection("friday");


    String sundayCount = "0";
    String mondayCount = "0";
    String tuesdayCount = "0";
    String wednesdayCount = "0";
    String thursdayCount = "0";
    String fridayCount = "0";


    FloatingActionButton memoFab;
    FloatingActionButton aboutmeFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sunday_card = findViewById(R.id.sunday_layout);
        monday_card = findViewById(R.id.monday_layout);
        tuesday_card = findViewById(R.id.tuesday_layout);
        wednesday_card = findViewById(R.id.wednesday_layout);
        thursday_card = findViewById(R.id.thursday_layout);
        friday_card = findViewById(R.id.friday_layout);
        memoFab = findViewById(R.id.fabitem_memo);
        aboutmeFab = findViewById(R.id.fabitem_aboutme);


        sundayCounter = findViewById(R.id.lbl_sunday_count);
        mondayCounter = findViewById(R.id.lbl_monday_count);
        tuesdayCounter = findViewById(R.id.lbl_tuesday_count);
        wednesdayCounter = findViewById(R.id.lbl_wednesday_count);
        thursdayCounter= findViewById(R.id.lbl_thursday_count);
        fridayCounter= findViewById(R.id.lbl_friday_count);




        getSundayClassCount();
        getMondayClassCount();
        getTuesdayClassCount();
        getWednesdayClassCount();
        getThursdayClassCount();
        getFridayClassCount();



        memoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Memo.class);
                startActivity(intent);
            }
        });

        aboutmeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(intent);
            }
        });

        sunday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SundayRecyclerActivity.class);
                startActivity(intent);
            }
        });

        monday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MondayRecyclerActivity.class);
                startActivity(intent);
            }
        });
        tuesday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TuesdayRecyclerActivity.class);
                startActivity(intent);
            }
        });
        wednesday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WednesdayRecyclerActivity.class);
                startActivity(intent);
            }
        });
        thursday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThursdayRecyclerActivity.class);
                startActivity(intent);
            }
        });
        friday_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FridayRecyclerActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getSundayClassCount() {
        sundayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                sundayCounter.setText(count + "");
                                sundayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }

                        if(sundayCount.equals("0")){
                            sunday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Sunday", Toast.LENGTH_SHORT);
                                }
                            });

                        }
                    }
                });
    }


    public void getMondayClassCount() {
        mondayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                mondayCounter.setText(count + "");
                                mondayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }

                        if(mondayCount.equals("0")){
                            monday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Monday", Toast.LENGTH_SHORT);
                                }
                            });

                        }
                    }
                });
    }


    public void getTuesdayClassCount() {
        tuesdayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                tuesdayCounter.setText(count + "");
                                tuesdayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }

                        if(tuesdayCount.equals("0")){
                            tuesday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Tuesday", Toast.LENGTH_SHORT);
                                }
                            });

                        }
                    }
                });
    }

    public void getWednesdayClassCount() {
        wednesdayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                wednesdayCounter.setText(count + "");
                                wednesdayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }


                        if(wednesdayCount.equals("0")){
                            wednesday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Wednesday", Toast.LENGTH_SHORT);
                                }
                            });

                        }

                    }
                });
    }

    public void getThursdayClassCount() {
        thursdayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                thursdayCounter.setText(count + "");
                                thursdayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }


                        if(thursdayCount.equals("0")){
                            thursday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Thursday", Toast.LENGTH_SHORT);
                                }
                            });

                        }

                    }
                });
    }

    public void getFridayClassCount() {
        fridayRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int count = 0;
                            for (DocumentSnapshot document : task.getResult()) {
                                count = count + 1;
                                fridayCounter.setText(count + "");
                                fridayCount = count+"";
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }


                        if(fridayCount.equals("0")){
                            friday_card.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    FBToast.warningToast(getApplicationContext(), "No Classes in Friday", Toast.LENGTH_SHORT);
                                }
                            });

                        }

                    }
                });
    }

}
