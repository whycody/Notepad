package com.notepad.notepad.notes;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class
LinearVerticalSpacing extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public LinearVerticalSpacing(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {

        outRect.top = verticalSpaceHeight;
        outRect.left = verticalSpaceHeight;
        outRect.right = verticalSpaceHeight;

        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = verticalSpaceHeight;
        }
    }
}
