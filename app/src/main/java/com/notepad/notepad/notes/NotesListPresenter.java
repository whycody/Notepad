package com.notepad.notepad.notes;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.notepad.notepad.notes.notes.add.AddNoteActivity;
import com.notepad.notepad.notes.recycler.NotesViewHolder;

import java.util.List;

public class NotesListPresenter {

    private List<Note> notes;
    private Context context;
    private OnItemClickListener onClickNewActivity;
    private OnItemClickListener onClickDelete;
    private NotesView notesView;

    public interface OnItemClickListener{
        void onItemClick(int position, Context context);
    }

    public NotesListPresenter(List<Note> notes, NotesView notesView, Context context){
        this.notes = notes;
        this.context = context;
        this.notesView = notesView;
    }

    public void onBindRepositoryRowViewAtPosition(final int position, NotesViewHolder rowView) {
       Note note = notes.get(position);
       rowView.setTitle(note.getTitle());
       rowView.noteCard.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onClickNewActivity.onItemClick(position, context);
           }
       });

       rowView.deleteNoteBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onClickDelete.onItemClick(position, context);
           }
       });
    }

    public void setupViews(){
        notesView.setOnClickNewActivity(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddNoteActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public int getRepositoriesRowsCount() {
        return notes.size();
    }

    public void notifyItemDeleted(int position){
        notesView.notifyNoteDeleted(position);
    }




    public void setOnClickNewActivity(OnItemClickListener onClickNewActivity){
        this.onClickNewActivity = onClickNewActivity;
    }

    public void setOnClickDelete(OnItemClickListener onClickDelete){
        this.onClickDelete = onClickDelete;
    }


    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void removeNote(int position){
        notes.remove(position);
    }

    public List<Note> getNotes() {
        return notes;
    }


}
