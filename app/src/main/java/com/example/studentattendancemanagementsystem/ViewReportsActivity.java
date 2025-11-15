package com.example.studentattendancemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewReportsActivity extends AppCompatActivity {

    ListView listViewReports;
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reports);

        tvHeader = findViewById(R.id.tvHeader);
        listViewReports = findViewById(R.id.listViewReports);

        tvHeader.setText("Attendance Summary");

        // 🧠 Mock data for now (replace with database later)
        ArrayList<String> reportList = new ArrayList<>();
        reportList.add("Math - 90% Present (9/10)");
        reportList.add("Science - 80% Present (8/10)");
        reportList.add("English - 100% Present (10/10)");
        reportList.add("Filipino - 70% Present (7/10)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                reportList
        );

        listViewReports.setAdapter(adapter);
    }
}
