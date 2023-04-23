package com.example.taskreminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView taskRecyclerView;
    private TextView addTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTxtView = findViewById(R.id.addTxtView);

        TaskRecyclerViewAdapter adapter = new TaskRecyclerViewAdapter(this);
        taskRecyclerView = findViewById(R.id.taskRecyclerView);

        taskRecyclerView.setAdapter(adapter);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("AI assignment", "Complete remaining part of AI assignment", "21:20"));
        tasks.add(new Task("Python CAT", "Attempt Python Programming CAT", "22:20"));
        tasks.add(new Task("Simulation Assignment", "Complete remaining part of Simulation assignment", "23:20"));
        adapter.setTasks(tasks);

        Intent i = getIntent();
        String taskName = i.getStringExtra("Task Name");
        String taskDesc = i.getStringExtra("Task Description");
        String taskTime = i.getStringExtra("Task Time");
        tasks.add(new Task(taskName, taskDesc, taskTime));

        addTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateTaskActivity.class);
                startActivity(intent);
            }
        });
    }
}