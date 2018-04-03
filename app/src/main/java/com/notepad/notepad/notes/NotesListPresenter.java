package com.notepad.notepad.notes;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.notepad.notepad.notes.notes.view.NotesViewActivity;
import com.notepad.notepad.notes.recycler.NotesRecyclerAdapter;
import com.notepad.notepad.notes.recycler.NotesRowView;
import com.notepad.notepad.notes.recycler.NotesViewHolder;

import java.util.ArrayList;
import java.util.List;

public class NotesListPresenter {

    private List<Note> notes = new ArrayList<>();
    private Context context;
    private OnItemClickListener listener;

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public interface OnItemClickListener{
        void onItemClick(int position, Context context);
    }

    public NotesListPresenter(List<Note> notes, Context context){
        this.notes = notes;
        this.context = context;
    }

    public void onBindRepositoryRowViewAtPosition(final int position, NotesViewHolder rowView) {
       Note note = notes.get(position);
       rowView.setTitle(note.getTitle());
       rowView.setNoteText(note.getNoteText());
       rowView.noteCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onItemClick(position, context);
           }
       });
    }

    public int getRepositoriesRowsCount() {
        return notes.size();
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public List<Note> getNotes() {
        return notes;
    }


}
