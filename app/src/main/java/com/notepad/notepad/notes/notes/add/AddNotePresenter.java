package com.notepad.notepad.notes.notes.add;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.notepad.notepad.notes.Note;
import com.notepad.notepad.notes.NotesActivity;
import com.notepad.notepad.notes.data.NoteDao;

public class AddNotePresenter {

    private NoteDao noteDao;
    private Context context;

    public AddNotePresenter(NoteDao noteDao, Context context){
        this.noteDao = noteDao;
        this.context = context;
    }

    public void addNote(String title, String noteText){
        noteDao.insertNote(new Note(title, noteText));
        context.startActivity(new Intent(context, NotesActivity.class));
        Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show();
    }
}
