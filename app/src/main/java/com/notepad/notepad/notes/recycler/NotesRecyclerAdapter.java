package com.notepad.notepad.notes.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notepad.notepad.R;
import com.notepad.notepad.notes.NotesListPresenter;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private NotesListPresenter presenter;
    private Context context;

    public NotesRecyclerAdapter(NotesListPresenter presenter, Context context){
        this.context = context;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_notes, parent, false);

        return new NotesViewHolder(presenter, view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        presenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesRowsCount();
    }
}
