package com.notepad.notepad.notes.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class NoteRealm extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;

    public NoteRealm(){

    }

    public NoteRealm(int id, String title) {
        this.id = id;
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

    @Override
    public String toString() {
        return "NoteRealm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
