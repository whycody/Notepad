package com.notepad.notepad.notes.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.NotesListPresenter;

public class NotesViewHolder extends RecyclerView.ViewHolder implements NotesRowView {

    private TextView title;

    public NotesViewHolder(final NotesListPresenter presenter, View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onItemClickedAtPosition(getAdapterPosition());

            }
        });
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
