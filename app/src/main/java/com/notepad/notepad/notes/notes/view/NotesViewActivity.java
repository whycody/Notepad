package com.notepad.notepad.notes.notes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.notepad.notepad.R;

public class NotesViewActivity extends AppCompatActivity implements NotesView{

    private Toolbar notesViewToolbar;
    private TextView titleView, notesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        titleView = findViewById(R.id.titleView);
        notesTextView = findViewById(R.id.notesTextView);


        notesViewToolbar = findViewById(R.id.notesViewToolbar);
        setSupportActionBar(notesViewToolbar);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setTitle(String title) {
        notesViewToolbar.setTitle(title);
        titleView.setText(title);
    }

    @Override
    public void setNoteText(String text) {
        notesTextView.setText(text);
    }
}
