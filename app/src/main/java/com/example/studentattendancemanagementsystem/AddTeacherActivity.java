package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddTeacherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        TextView textView = findViewById(R.id.tvAddTeacher);
        textView.setText("Add Teacher Page (Coming Soon)");
    }
}
