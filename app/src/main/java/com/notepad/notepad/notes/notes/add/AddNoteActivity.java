package com.notepad.notepad.notes.notes.add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.data.NoteDao;

public class AddNoteActivity extends AppCompatActivity {

    private Button addNoteBtn;
    private EditText addTitleView, addNoteTextView;
    private Toolbar addNoteToolbar;

    private AddNotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        addNoteBtn = findViewById(R.id.addNoteBtn);
        addNoteToolbar = findViewById(R.id.addNoteToolbar);
        addTitleView = findViewById(R.id.addTitleView);
        addNoteTextView = findViewById(R.id.addNoteTextView);

        presenter = new AddNotePresenter(new NoteDao(this), this);

        setSupportActionBar(addNoteToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNoteBtn.setTextColor(getResources().getColorStateList(R.color.text_white_black));

        addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addNote(addTitleView.getText().toString(), addNoteTextView.getText().toString());
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
