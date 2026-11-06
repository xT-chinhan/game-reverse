package com.mcto.sspsdk.internal;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import com.mcto.sspsdk.ssp.taskpage.QyTaskPageActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class wh extends RecyclerView.ItemDecoration {
    public final int a;

    public wh(QyTaskPageActivity qyTaskPageActivity) {
        this.a = (int) TypedValue.applyDimension(1, 10, qyTaskPageActivity.getResources().getDisplayMetrics());
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).getOrientation() == 1) {
                if (childAdapterPosition != 0) {
                    rect.top = this.a;
                }
            } else if (childAdapterPosition != 0) {
                rect.left = this.a;
            }
        }
    }
}
