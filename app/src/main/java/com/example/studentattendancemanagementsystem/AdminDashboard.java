package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    Button btnAddTeacher, btnAddStudent, btnViewReports, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Initialize buttons
        btnAddTeacher = findViewById(R.id.btnAddTeacher);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnViewReports = findViewById(R.id.btnViewReports);
        btnLogout = findViewById(R.id.btnLogout);

        // Go to Add Teacher screen (create later if needed)
        btnAddTeacher.setOnClickListener(v ->
                startActivity(new Intent(AdminDashboard.this, AddTeacherActivity.class)));

        // Go to Add Student screen (create later if needed)
        btnAddStudent.setOnClickListener(v ->
                startActivity(new Intent(AdminDashboard.this, AddStudentActivity.class)));

        // View attendance reports
        btnViewReports.setOnClickListener(v ->
                startActivity(new Intent(AdminDashboard.this, ViewReportsActivity.class)));

        // Logout back to main screen
        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboard.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
