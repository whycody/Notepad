package com.notepad.notepad.notes.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NoteRealm extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String noteText;

    public NoteRealm(){

    }

    public NoteRealm(String title, String noteText) {
        this.noteText = noteText;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    @Override
    public String toString() {
        return "NoteRealm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
