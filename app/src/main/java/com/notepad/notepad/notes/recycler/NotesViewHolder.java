package com.notepad.notepad.notes.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.notepad.notepad.R;

public class NotesViewHolder extends RecyclerView.ViewHolder implements NotesRowView {

    private TextView title;

    public NotesViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
