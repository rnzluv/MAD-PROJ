package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MarkAttendance extends AppCompatActivity {

    RecyclerView rvStudentList;
    Button btnSubmitAttendance;
    StudentAdapter adapter;
    ArrayList<StudentModel> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance); // ✅ from your layout folder

        rvStudentList = findViewById(R.id.rvStudentList);
        btnSubmitAttendance = findViewById(R.id.btnSubmitAttendance);

        studentList = new ArrayList<>();
        studentList.add(new StudentModel("2023001", "John Doe"));
        studentList.add(new StudentModel("2023002", "Jane Smith"));
        studentList.add(new StudentModel("2023003", "Mark Reyes"));

        adapter = new StudentAdapter(studentList);
        rvStudentList.setLayoutManager(new LinearLayoutManager(this));
        rvStudentList.setAdapter(adapter);

        btnSubmitAttendance.setOnClickListener(v ->
                Toast.makeText(this, "Attendance submitted successfully!", Toast.LENGTH_SHORT).show());
    }
}
