package com.notepad.notepad.notes.notes.view;

import android.app.Activity;
import android.os.Bundle;

public class NotesViewDao {

    private Activity activity;
    private Bundle bundle;

    public NotesViewDao(Activity activity){
        this.activity =activity;
        bundle = activity.getIntent().getExtras();
    }

    public String getTitle(){
        return bundle.getString("title");
    }

    public String getNoteText(){
        return bundle.getString("noteText");
    }
}
