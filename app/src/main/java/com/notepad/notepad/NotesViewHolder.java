package com.notepad.notepad;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NotesViewHolder extends RecyclerView.ViewHolder implements NotesRowView {

    private TextView miniatureText;

    public NotesViewHolder(View itemView) {
        super(itemView);
        miniatureText = itemView.findViewById(R.id.miniatureText);
    }

    @Override
    public void setTitle(String title) {
        miniatureText.setText(title);
    }
}
