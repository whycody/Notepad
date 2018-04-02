package com.notepad.notepad;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class NotesActivity extends AppCompatActivity {

    private NotesListPresenter presenter = new NotesListPresenter();
    private NotesRecyclerAdapter adapter = new NotesRecyclerAdapter(presenter);
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.notesList);
        recyclerView.setAdapter(adapter);
        
        setSupportActionBar(toolbar);


    }
}
