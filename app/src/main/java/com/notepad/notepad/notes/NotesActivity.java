package com.notepad.notepad.notes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.data.NoteDao;
import com.notepad.notepad.notes.recycler.NotesRecyclerAdapter;

public class NotesActivity extends AppCompatActivity implements NotesView {

    private NoteDao noteDao;
    private NotesListPresenter presenter;
    private NotesRecyclerAdapter adapter;

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private FloatingActionButton floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        toolbar = findViewById(R.id.toolbar);
        floatingBtn = findViewById(R.id.floatingBtn);
        recyclerView = findViewById(R.id.notesList);

        noteDao = new NoteDao(getBaseContext());
        presenter = new NotesListPresenter(noteDao.getAllNotes(), this, this);
        adapter = new NotesRecyclerAdapter(presenter, getBaseContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.addItemDecoration(new LinearVerticalSpacing(12));
        recyclerView.setAdapter(adapter);

        presenter.setupViews();

        setSupportActionBar(toolbar);
    }

    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        floatingBtn.setOnClickListener(onClickListener);
    }
}
