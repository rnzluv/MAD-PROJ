package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;


public class AddStudentActivity extends AppCompatActivity {


    EditText etStudentID, etStudentName, etStudentPassword, etStudentEmail, etStudentBirthday, etStudentAddress, etStudentSection;
    Button btnAddStudent;


    // Example storage for added students (temporary)
    public static ArrayList<Student> studentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        etStudentID = findViewById(R.id.etStudentID);
        etStudentName = findViewById(R.id.etStudentName);
        etStudentPassword = findViewById(R.id.etStudentPassword);
        etStudentEmail = findViewById(R.id.etStudentEmail);
        etStudentBirthday = findViewById(R.id.etStudentBirthday);
        etStudentAddress = findViewById(R.id.etStudentAddress);
        etStudentSection = findViewById(R.id.etStudentSection);
        btnAddStudent = findViewById(R.id.btnAddStudent);


        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etStudentID.getText().toString().trim();
                String name = etStudentName.getText().toString().trim();
                String password = etStudentPassword.getText().toString().trim();
                String email = etStudentEmail.getText().toString().trim();
                String birthday = etStudentBirthday.getText().toString().trim();
                String address = etStudentAddress.getText().toString().trim();
                String section = etStudentSection.getText().toString().trim();


                if (id.isEmpty() || name.isEmpty() || password.isEmpty() ||
                        email.isEmpty() || birthday.isEmpty() || address.isEmpty() || section.isEmpty()) {
                    Toast.makeText(AddStudentActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }


                // Add new student to list
                Student newStudent = new Student(id, name, password, email, birthday, address, section);
                studentList.add(newStudent);


                Toast.makeText(AddStudentActivity.this, "Student added successfully!", Toast.LENGTH_SHORT).show();


                // Clear fields
                etStudentID.setText("");
                etStudentName.setText("");
                etStudentPassword.setText("");
                etStudentEmail.setText("");
                etStudentBirthday.setText("");
                etStudentAddress.setText("");
                etStudentSection.setText("");
            }
        });
    }


    // Updated Student class
    public static class Student {
        String id, name, password, email, birthday, address, section;


        public Student(String id, String name, String password, String email, String birthday, String address, String section) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.email = email;
            this.birthday = birthday;
            this.address = address;
            this.section = section;
        }
    }
}


