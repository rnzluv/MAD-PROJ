package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class TeacherDashboard extends AppCompatActivity {

    Spinner spnSubject;
    Button btnMarkAttendance, btnViewReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        spnSubject = findViewById(R.id.spnSubject);
        btnMarkAttendance = findViewById(R.id.btnMarkAttendance);
        btnViewReports = findViewById(R.id.btnViewReports);

        String[] subjects = {"Select Subject", "Math", "Science", "English"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSubject.setAdapter(adapter);

        btnMarkAttendance.setOnClickListener(v ->
                startActivity(new Intent(TeacherDashboard.this, MarkAttendance.class)));

        btnViewReports.setOnClickListener(v ->
                startActivity(new Intent(TeacherDashboard.this, ViewReportsActivity.class)));
    }
}
