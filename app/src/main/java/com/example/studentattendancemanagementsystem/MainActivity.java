package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Spinner spnRole;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        spnRole = findViewById(R.id.spnRole);
        btnLogin = findViewById(R.id.btnLogin);

        
        String[] roles = {"Select Role", "Admin", "Teacher", "Student"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnRole.setAdapter(adapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String role = spnRole.getSelectedItem().toString();

                if (username.isEmpty() || password.isEmpty() || role.equals("Select Role")) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (role.equals("Admin") && username.equals("admin") && password.equals("admin123")) {
                    startActivity(new Intent(MainActivity.this, AdminDashboard.class));
                } else if (role.equals("Teacher") && username.equals("teacher") && password.equals("teacher123")) {
                    startActivity(new Intent(MainActivity.this, TeacherDashboard.class));
                } else if (role.equals("Student") && username.equals("student") && password.equals("student123")) {
                    startActivity(new Intent(MainActivity.this, StudentDashboard.class));
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username, password, or role", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
