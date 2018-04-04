package com.notepad.notepad.notes;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.notepad.notepad.notes.notes.add.AddNoteActivity;
import com.notepad.notepad.notes.notes.view.NotesViewActivity;
import com.notepad.notepad.notes.recycler.NotesRecyclerAdapter;
import com.notepad.notepad.notes.recycler.NotesRowView;
import com.notepad.notepad.notes.recycler.NotesViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NotesListPresenter {

    private List<Note> notes;
    private Context context;
    private OnItemClickListener listener;
    private NotesView notesView;

    public interface OnItemClickListener{
        void onItemClick(int position, Context context);
    }

    public NotesListPresenter(List<Note> notes, NotesView notesView, Context context){
        this.notes = notes;
        this.context = context;
        this.notesView = notesView;
    }

    public void onBindRepositoryRowViewAtPosition(final int position, NotesViewHolder rowView) {
       Note note = notes.get(position);
       rowView.setTitle(note.getTitle());
       rowView.noteCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onItemClick(position, context);
           }
       });
    }

    public void setupViews(){
        notesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddNoteActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public int getRepositoriesRowsCount() {
        return notes.size();
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }


}
