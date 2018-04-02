package com.notepad.notepad;

public class Note {

    private String miniatureText;

    public Note(){

    }

    public Note(String miniatureText) {
        this.miniatureText = miniatureText;
    }

    public String getMiniatureText() {
        return miniatureText;
    }

    public void setMiniatureText(String miniatureText) {
        this.miniatureText = miniatureText;
    }

}
