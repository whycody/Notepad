package com.notepad.notepad.notes.notes.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.notepad.notepad.notes.data.NoteDao;

public class NotesViewPresenter {

    private NotesView notesView;
    private NotesViewDao notesViewDao;
    private NoteDao noteDao;
    private Activity activity;

    public NotesViewPresenter(NotesView notesView, Activity activity){
        this.notesView = notesView;
        this.activity = activity;
        this.noteDao = new NoteDao(activity);
        notesViewDao = new NotesViewDao(activity);
    }

    public void setupViews(){
        notesView.setTitle(notesViewDao.getTitle());
        notesView.setNoteText(notesViewDao.getNoteText());
    }

    public void editActualNote(String text){
        noteDao.getNoteById(notesViewDao.getNoteId()).setNoteText(text);
    }


}
