package com.notepad.notepad.notes.notes.add;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.notepad.notepad.notes.Note;
import com.notepad.notepad.notes.NotesActivity;
import com.notepad.notepad.notes.data.NoteDao;

public class AddNotePresenterImpl implements AddNotePresenter, AddNoteInteractor.OnNoteAddedListener{

    private NoteDao noteDao;
    private AddNoteView addNoteView;
    private AddNoteInteractor addNoteInteractor;

    public AddNotePresenterImpl(NoteDao noteDao, AddNoteView addNoteView, AddNoteInteractor addNoteInteractor){
        this.noteDao = noteDao;
        this.addNoteView = addNoteView;
        this.addNoteInteractor = addNoteInteractor;
    }

    public void addNote(String title, String noteText){
        noteDao.insertNote(new Note(title, noteText));
    }

    @Override
    public void noTitleError() {
        addNoteView.onTitleError();
    }

    @Override
    public void noNoteTextError() {
        addNoteView.onNoteTextError();
    }

    @Override
    public void onSuccess(String title, String noteText) {
        addNote(title, noteText);
        addNoteView.onSuccess();
    }

    @Override
    public void validateCredentials(String title, String noteText) {
        addNoteInteractor.addNote(title, noteText, this);
    }
}
