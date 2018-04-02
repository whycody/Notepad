package com.notepad.notepad.notes;

import com.notepad.notepad.notes.recycler.NotesRowView;

import java.util.ArrayList;
import java.util.List;

public class NotesListPresenter {

    private List<Note> notes = new ArrayList<>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public NotesListPresenter(){

    }

    public NotesListPresenter(List<Note> notes){

    }

    public void onBindRepositoryRowViewAtPosition(int position, NotesRowView rowView) {
       Note note = notes.get(position);
       rowView.setTitle(note.getTitle());
    }

    public int getRepositoriesRowsCount() {
        return notes.size();
    }

    public void onItemClickedAtPosition(int position) {

    }
}
