package com.notepad.notepad.notes;

public class Note {
    private Integer id;
    private String title;
    private String noteText;

    public Note(){

    }

    public Note(String title, String noteText){
        this.title = title;
        this.noteText = noteText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    @Override
    public String toString() {
        return title;
    }
}