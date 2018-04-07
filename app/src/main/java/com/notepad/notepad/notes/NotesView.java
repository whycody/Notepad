package com.notepad.notepad.notes;

import android.view.View;

public interface NotesView {

    void setOnClickNewActivity(View.OnClickListener onClickListener);

    void notifyNoteDeleted(int position);

}
