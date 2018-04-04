package com.notepad.notepad.notes.notes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.notepad.notepad.R;

public class NotesViewActivity extends AppCompatActivity implements NotesView{

    private Toolbar notesViewToolbar;
    private TextView notesTextView;
    private NotesViewPresenter viewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        notesTextView = findViewById(R.id.notesTextView);
        viewPresenter = new NotesViewPresenter(this, this);

        notesViewToolbar = findViewById(R.id.notesViewToolbar);
        setSupportActionBar(notesViewToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPresenter.setupViews();
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setNoteText(String text) {
        notesTextView.setText(text);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
