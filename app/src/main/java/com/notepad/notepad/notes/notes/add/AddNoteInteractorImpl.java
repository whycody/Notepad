package com.notepad.notepad.notes.notes.add;

import android.text.TextUtils;

public class AddNoteInteractorImpl implements AddNoteInteractor{

    @Override
    public void addNote(String title, String noteText, OnNoteAddedListener noteAddedListener) {
        if(TextUtils.isEmpty(title)){
            noteAddedListener.noTitleError();
        }else if(TextUtils.isEmpty(noteText)){
            noteAddedListener.noNoteTextError();
        }else{
            noteAddedListener.onSuccess(title, noteText);
        }
    }
}
