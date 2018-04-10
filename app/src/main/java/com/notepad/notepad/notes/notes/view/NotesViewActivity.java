package com.notepad.notepad.notes.notes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.notepad.notepad.R;

public class NotesViewActivity extends AppCompatActivity implements NotesView{

    private Toolbar notesViewToolbar;
    private EditText notesEditText;
    private NotesViewPresenter viewPresenter;

    private String defaultNoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        notesEditText = findViewById(R.id.notesEditText);
        viewPresenter = new NotesViewPresenter(this, this);

        notesViewToolbar = findViewById(R.id.notesViewToolbar);
        setSupportActionBar(notesViewToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPresenter.setupViews();

        notesEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                NotesViewActivity.this.onTextChanged(s.toString());
            }
        });
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setNoteText(String text) {
        notesEditText.setText(text);
        defaultNoteText = text;
    }

    @Override
    public void onTextChanged(String text) {
        if(text.equals(defaultNoteText)) {
            hideBottomSheetSave();
        }else
            showBottomSheetSave();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void hideBottomSheetSave() {
    }

    private void showBottomSheetSave() {
    }
}
