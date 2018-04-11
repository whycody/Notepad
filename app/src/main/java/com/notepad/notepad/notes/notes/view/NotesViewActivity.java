package com.notepad.notepad.notes.notes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.notepad.notepad.R;

public class NotesViewActivity extends AppCompatActivity implements NotesView{

    private Toolbar notesViewToolbar;
    private EditText notesEditText;
    private NotesViewPresenter viewPresenter;
    private Button backOrSaveBtn;

    private String defaultNoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        notesEditText = findViewById(R.id.notesEditText);
        viewPresenter = new NotesViewPresenter(this, this);
        backOrSaveBtn = findViewById(R.id.backOrSaveBtn);

        notesViewToolbar = findViewById(R.id.notesViewToolbar);
        setSupportActionBar(notesViewToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backOrSaveBtn.setTextColor(getResources().getColorStateList(R.color.text_white_black));
        backOrSaveBtn.setOnClickListener(backOnClick);
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
            setButtonOnBack();
        }else
            setButtonOnSave();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setButtonOnBack() {
        backOrSaveBtn.setText(getResources().getString(R.string.back));
        backOrSaveBtn.setOnClickListener(backOnClick);
    }

    private void setButtonOnSave() {
        backOrSaveBtn.setText(getResources().getString(R.string.save));
        backOrSaveBtn.setOnClickListener(saveOnClick);
    }

    private View.OnClickListener backOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener saveOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            viewPresenter.editActualNote(notesEditText.getText().toString());
            finish();
        }
    };
}
