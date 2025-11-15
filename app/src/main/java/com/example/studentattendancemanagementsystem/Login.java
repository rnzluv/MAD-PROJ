package com.example.studentattendancemanagementsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private RadioGroup rgRole;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        sharedPreferences = getSharedPreferences("AttendanceApp", MODE_PRIVATE);

        btnLogin.setOnClickListener(v -> performLogin());
    }

    private void initializeViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        rgRole = findViewById(R.id.rgRole);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void performLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int selectedRoleId = rgRole.getCheckedRadioButtonId();
        RadioButton selectedRole = findViewById(selectedRoleId);
        String role = selectedRole.getText().toString();

        // Simple validation (In production, use proper authentication)
        if (validateLogin(username, password, role)) {
            saveLoginSession(username, role);
            navigateToDashboard(role);
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateLogin(String username, String password, String role) {
        // Demo credentials
        if (role.equals("Admin") && username.equals("admin") && password.equals("admin123")) {
            return true;
        } else if (role.equals("Teacher") && username.equals("teacher") && password.equals("teacher123")) {
            return true;
        } else if (role.equals("Student") && username.equals("student") && password.equals("student123")) {
            return true;
        }
        return false;
    }

    private void saveLoginSession(String username, String role) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("role", role);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    private void navigateToDashboard(String role) {
        Intent intent;
        switch (role) {
            case "Admin":
                intent = new Intent(Login.this, AdminDashboard.class);
                break;
            case "Teacher":
                intent = new Intent(Login.this, TeacherDashboard.class);
                break;
            case "Student":
                intent = new Intent(Login.this, StudentDashboard.class);
                break;
            default:
                return;
        }
        startActivity(intent);
        finish();
    }
}