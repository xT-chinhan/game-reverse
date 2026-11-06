package com.byazt.ama;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.byazt.prf.RecyclerView;
import com.byazt.prf.sz;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 5})
public class q extends RecyclerView.fs {
    public final int n;
    public final int q;
    public final int qg;
    public final int s;

    public q(int i, int i2, int i3, int i4) {
        this.s = Math.max(1, i);
        this.q = i2;
        this.n = Math.max(0, i3);
        this.qg = Math.max(0, i4);
    }

    @Override // com.byazt.prf.RecyclerView.fs
    public void n(Rect rect, View view, RecyclerView recyclerView, RecyclerView.py pyVar) {
        int iW = recyclerView.w(view);
        int iN = n(view, iW);
        int i = this.n;
        int i2 = this.s;
        int i3 = (iN * i) / i2;
        int i4 = i - (((iN + 1) * i) / i2);
        boolean z = iW >= i2;
        if (this.q == 0) {
            rect.top = i3;
            rect.bottom = i4;
            if (z) {
                rect.left = this.qg;
                return;
            }
            return;
        }
        rect.left = i3;
        rect.right = i4;
        if (z) {
            rect.top = this.qg;
        }
    }

    private int n(View view, int i) {
        RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
        if (tjVar instanceof sz.qg) {
            return ((sz.qg) tjVar).qg();
        }
        return i % this.s;
    }
}
