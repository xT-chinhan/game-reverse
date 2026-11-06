package com.mcto.sspsdk.ssp.taskpage;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.mcto.sspsdk.internal.he;
import com.mcto.sspsdk.internal.oj;
import com.mcto.sspsdk.internal.qj;
import com.mcto.sspsdk.internal.rj;
import com.mcto.sspsdk.internal.tc;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends RecyclerView.Adapter {
    public RecyclerView a;
    public final boolean b = true;
    public int c = -1;
    public int d = -1;
    public final ArrayList e = new ArrayList();
    public TaskAdItemView f;

    public h(he heVar) {
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0066  */
    public static void a(h hVar) {
        boolean z;
        RecyclerView recyclerView = hVar.a;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) hVar.a.getLayoutManager();
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int iMax = Math.max(hVar.d, iFindLastVisibleItemPosition);
        for (int iMin = Math.min(hVar.c, iFindFirstVisibleItemPosition); iMin <= iMax; iMin++) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = hVar.a.findViewHolderForAdapterPosition(iMin);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                boolean z2 = false;
                if (view == null || !view.isShown()) {
                    z = false;
                } else {
                    Rect rect = new Rect();
                    if (view.getGlobalVisibleRect(rect) && (!hVar.b || (rect.width() == view.getWidth() && rect.height() == view.getHeight()))) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (hVar.c <= iMin && iMin <= hVar.d) {
                    z2 = true;
                }
                if (z != z2) {
                    ((rj) viewHolderFindViewHolderForAdapterPosition).a.a(z);
                }
            }
        }
        hVar.c = iFindFirstVisibleItemPosition;
        hVar.d = iFindLastVisibleItemPosition;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.e.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return ((oj) this.e.get(i)).a.n() ? 1 : 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.a = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new tc(this));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        rj rjVar = (rj) viewHolder;
        oj ojVar = (oj) this.e.get(i);
        ojVar.a();
        rjVar.a.a(ojVar);
        rjVar.a.a(new qj(this));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new rj(new TaskAdItemView(viewGroup.getContext()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.a = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        rj rjVar = (rj) viewHolder;
        if (list.isEmpty()) {
            oj ojVar = (oj) this.e.get(i);
            ojVar.a();
            rjVar.a.a(ojVar);
            rjVar.a.a(new qj(this));
            return;
        }
        oj ojVar2 = (oj) this.e.get(i);
        ojVar2.a();
        rjVar.a.a(ojVar2.c);
    }
}
