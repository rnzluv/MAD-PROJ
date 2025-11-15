package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewAttendanceActivity extends AppCompatActivity {

    ListView listView;
    String[] Attendance = {"Math - Present", "Science - Absent", "English - Present"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_view_students);

       listView = findViewById(R.id.listViewAttendance);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Attendance);
        listView.setAdapter(adapter);
    }
}
