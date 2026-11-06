package com.byazt.yx;

import android.view.View;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 8})
public class s {
    public boolean cd;
    public float cp;
    public int cy;
    public int d;
    public int fs;
    public boolean hd;
    public int k;
    public int l;
    public int oa;
    public int rv;
    public float tj;
    public int w;
    public int x;
    public int n = Integer.MAX_VALUE;
    public int qg = Integer.MAX_VALUE;
    public int s = Integer.MIN_VALUE;
    public int q = Integer.MIN_VALUE;
    public List<Integer> sz = new ArrayList();

    public int n() {
        return this.x;
    }

    public int qg() {
        return this.fs - this.rv;
    }

    public void n(View view, int i, int i2, int i3, int i4) {
        qg qgVar = (qg) view.getLayoutParams();
        this.n = Math.min(this.n, (view.getLeft() - qgVar.oa()) - i);
        this.qg = Math.min(this.qg, (view.getTop() - qgVar.sz()) - i2);
        this.s = Math.max(this.s, view.getRight() + qgVar.k() + i3);
        this.q = Math.max(this.q, view.getBottom() + qgVar.cy() + i4);
    }
}
