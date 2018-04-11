package com.notepad.notepad.notes.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.NotesListPresenter;
import com.notepad.notepad.notes.data.NoteDao;
import com.notepad.notepad.notes.notes.view.NotesViewActivity;

public class NotesViewHolder extends RecyclerView.ViewHolder implements NotesRowView{

    private TextView title;
    public CardView noteCard;
    public ImageButton deleteNoteBtn;
    private NotesListPresenter presenter;
    private NoteDao noteDao;

    public NotesViewHolder(final NotesListPresenter presenter, View itemView) {
        super(itemView);
        this.presenter = presenter;
        title = itemView.findViewById(R.id.title);
        noteCard = itemView.findViewById(R.id.noteCard);
        deleteNoteBtn = itemView.findViewById(R.id.deleteNoteBtn);

        presenter.setOnClickNewActivity(new NotesListPresenter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                noteDao = new NoteDao(context);

                context.startActivity(new Intent(context, NotesViewActivity.class)
                .putExtra("noteTitle", noteDao.getNoteAtPosition(position).getTitle())
                .putExtra("noteText", noteDao.getNoteAtPosition(position).getNoteText())
                .putExtra("noteID", noteDao.getNoteAtPosition(position).getId()));
            }
        });

        presenter.setOnClickDelete(new NotesListPresenter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                noteDao = new NoteDao(context);

                noteDao.deleteNoteById(noteDao.getNoteAtPosition(position).getId());
                presenter.removeNote(position);
                presenter.notifyItemDeleted(position);
                Toast.makeText(context, presenter.getNotes().toString(), Toast.LENGTH_SHORT).show();




            }
        });
    }

    @Override
    public void setTitle(String title) {
        this.title.setText(title);
    }


}
