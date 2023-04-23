package com.example.taskreminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTaskActivity extends AppCompatActivity {

    private EditText changeTaskName, changeTaskDesc, changeTaskTime;
    private Button editTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        changeTaskName = findViewById(R.id.changeTaskName);
        changeTaskDesc = findViewById(R.id.changeTaskDesc);
        changeTaskTime = findViewById(R.id.changeTaskTime);
        editTaskBtn = findViewById(R.id.editTaskBtn);

        Intent intent = getIntent();
        String taskName = intent.getStringExtra("Task Name");
        String taskDesc = intent.getStringExtra("Task Description");
        String taskTime = intent.getStringExtra("Task Time");

        changeTaskName.setText(taskName);
        changeTaskDesc.setText(taskDesc);
        changeTaskTime.setText(taskTime);

        editTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName_1 = changeTaskName.getText().toString();
                String taskDesc_1 = changeTaskDesc.getText().toString();
                String taskTime_1 = changeTaskTime.getText().toString();
                Toast.makeText(EditTaskActivity.this, taskName_1, Toast.LENGTH_SHORT).show();
                Toast.makeText(EditTaskActivity.this, taskDesc_1, Toast.LENGTH_SHORT).show();
                Toast.makeText(EditTaskActivity.this, taskTime_1, Toast.LENGTH_SHORT).show();
            }
        });
    }
}