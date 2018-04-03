package com.notepad.notepad.notes.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.NotesListPresenter;
import com.notepad.notepad.notes.notes.view.NotesViewActivity;

import org.w3c.dom.Text;

public class NotesViewHolder extends RecyclerView.ViewHolder implements NotesRowView{

    private TextView title;
    private TextView noteText;
    public CardView noteCard;
    private NotesListPresenter presenter;

    public NotesViewHolder(final NotesListPresenter presenter, View itemView) {
        super(itemView);
        this.presenter = presenter;
        title = itemView.findViewById(R.id.title);
        noteText = itemView.findViewById(R.id.noteText);
        noteCard = itemView.findViewById(R.id.noteCard);
        presenter.setOnItemClickListener(new NotesListPresenter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                context.startActivity(new Intent(context, NotesViewActivity.class)
                .putExtra("title", title.getText().toString())
                .putExtra("noteText", noteText.getText().toString()));
            }
        });
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }

    @Override
    public void setNoteText(String noteText) {
        this.noteText.setText(noteText);
    }


}
