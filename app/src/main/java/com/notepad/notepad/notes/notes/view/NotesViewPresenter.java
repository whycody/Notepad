package com.notepad.notepad.notes.notes.view;

import android.app.Activity;
import android.content.Context;

import com.notepad.notepad.notes.data.NoteDao;

public class NotesViewPresenter {

    private NotesView notesView;
    private NotesViewDao notesViewDao;
    private Activity activity;

    public NotesViewPresenter(NotesView notesView, Activity activity){
        this.notesView = notesView;
        this.activity = activity;
        notesViewDao = new NotesViewDao(activity);
    }

    public void setupViews(){
        notesView.setTitle(notesViewDao.getTitle());
        notesView.setNoteText(notesViewDao.getNoteText());
    }


}
