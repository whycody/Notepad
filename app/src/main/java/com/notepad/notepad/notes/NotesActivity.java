package com.notepad.notepad.notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.data.NoteDao;
import com.notepad.notepad.notes.recycler.NotesRecyclerAdapter;

public class NotesActivity extends AppCompatActivity {

    private NoteDao noteDao;
    private NotesListPresenter presenter = new NotesListPresenter();
    private NotesRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);

        noteDao = new NoteDao(getBaseContext());

        Note note = new Note();
        note.setTitle("Notatka");

        noteDao.insertNote(note);

        presenter.setNotes(noteDao.getAllNotes());
        adapter = new NotesRecyclerAdapter(presenter);

        recyclerView = findViewById(R.id.notesList);
        recyclerView.setAdapter(adapter);

        setSupportActionBar(toolbar);


    }
}
