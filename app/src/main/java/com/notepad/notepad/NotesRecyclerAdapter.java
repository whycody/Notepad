package com.notepad.notepad;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesViewHolder> {

    private final NotesListPresenter presenter;

    public NotesRecyclerAdapter(NotesListPresenter presenter){
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_notes, parent, false));
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
