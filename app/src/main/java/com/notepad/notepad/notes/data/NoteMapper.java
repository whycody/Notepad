package com.notepad.notepad.notes.data;

import com.notepad.notepad.notes.Note;

public class NoteMapper {

    Note fromRealm(NoteRealm noteRealm){
        Note note = new Note();
        note.setId(noteRealm.getId());
        note.setTitle(noteRealm.getTitle());
        note.setNoteText(noteRealm.getNoteText());
        return note;
    }
}
