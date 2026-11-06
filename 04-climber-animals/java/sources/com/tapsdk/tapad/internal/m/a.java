package com.tapsdk.tapad.internal.m;

import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class a<T> implements RecyclerView.OnChildAttachStateChangeListener {
    private final RecyclerView a;
    private final b<T> b;
    private final long c;

    private a() {
        this.a = null;
        this.b = null;
        this.c = 0L;
    }

    public a(RecyclerView recyclerView, b<T> bVar, long j) {
        this.a = recyclerView;
        this.b = bVar;
        this.c = j;
    }

    private void a(int i) {
        b<T> bVar = this.b;
        if (bVar != null) {
            bVar.removeMessages(i);
        }
    }

    private void a(int i, View view) {
        if (this.b == null) {
            return;
        }
        a(i);
        Message messageObtain = Message.obtain(this.b, i);
        messageObtain.what = i;
        messageObtain.obj = view;
        this.b.sendMessageDelayed(messageObtain, this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            a(recyclerView.getChildAdapterPosition(view), view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        RecyclerView recyclerView = this.a;
        if (recyclerView != null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                childAdapterPosition = this.a.getChildLayoutPosition(view);
            }
            a(childAdapterPosition);
        }
    }
}
