package com.notepad.notepad.notes.notes.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.NotesActivity;
import com.notepad.notepad.notes.data.NoteDao;

public class AddNoteActivity extends AppCompatActivity implements AddNoteView{

    private Button addNoteBtn;
    private EditText addTitleView, addNoteTextView;
    private Toolbar addNoteToolbar;

    private AddNotePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        addNoteBtn = findViewById(R.id.addNoteBtn);
        addNoteToolbar = findViewById(R.id.addNoteToolbar);
        addTitleView = findViewById(R.id.addTitleView);
        addNoteTextView = findViewById(R.id.addNoteTextView);

        presenter = new AddNotePresenterImpl(new NoteDao(this), this, new AddNoteInteractorImpl());

        setSupportActionBar(addNoteToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNoteBtn.setTextColor(getResources().getColorStateList(R.color.text_white_black));

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateCredentials(addTitleView.getText().toString(), addNoteTextView.getText().toString());
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onTitleError() {
        Toast.makeText(this, getResources().getString(R.string.set_title), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoteTextError() {
        Toast.makeText(this, getResources().getString(R.string.set_note_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, NotesActivity.class));
        Toast.makeText(this, getResources().getString(R.string.note_added), Toast.LENGTH_SHORT).show();
    }
}
