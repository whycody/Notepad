package com.notepad.notepad.notes.notes.view;

import com.notepad.notepad.notes.data.NoteDao;

public class NotesViewPresenter {

    private NotesView notesView;
    private NoteDao noteDao;

    public NotesViewPresenter(NotesView notesView, NoteDao noteDao){
        this.notesView = notesView;
        this.noteDao = noteDao;
    }


}
