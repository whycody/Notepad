package com.notepad.notepad.notes.notes.add;

public interface AddNoteInteractor {

    interface OnNoteAddedListener{

        void noTitleError();

        void noNoteTextError();

        void onSuccess(String title, String noteText);

    }

    void addNote(String title, String noteText, OnNoteAddedListener noteAddedListener);

}
