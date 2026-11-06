package com.mcto.sspsdk.internal;

import android.support.v7.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class tc extends RecyclerView.OnScrollListener {
    public final /* synthetic */ com.mcto.sspsdk.ssp.taskpage.h a;

    public tc(com.mcto.sspsdk.ssp.taskpage.h hVar) {
        this.a = hVar;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            com.mcto.sspsdk.ssp.taskpage.h.a(this.a);
        }
    }
}
