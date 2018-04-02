package com.notepad.notepad;

import java.util.ArrayList;
import java.util.List;

public class NotesListPresenter {

    private List<Note> notes = new ArrayList<>();
    

    public void onBindRepositoryRowViewAtPosition(int position, NotesRowView rowView) {
       Note note = notes.get(position);
       rowView.setTitle(note.getMiniatureText());
    }

    public int getRepositoriesRowsCount() {
        return notes.size();
    }

}
