package com.example.taskreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateTaskActivity extends AppCompatActivity {

    private EditText editTaskName, editTaskDesc, editTaskTime;
    private Button addTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        editTaskName = findViewById(R.id.editTaskName);
        editTaskDesc = findViewById(R.id.editTaskDesc);
        editTaskTime = findViewById(R.id.editTaskTime);
        addTaskBtn = findViewById(R.id.addTaskBtn);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTaskActivity.this, MainActivity.class);
                intent.putExtra("Task Name", editTaskName.getText().toString());
                intent.putExtra("Task Description", editTaskDesc.getText().toString());
                intent.putExtra("Task Time", editTaskTime.getText().toString());
                startActivity(intent);
            }
        });
    }
}