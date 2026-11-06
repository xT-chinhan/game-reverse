package com.byazt.mu;

import android.graphics.Rect;
import android.view.View;
import com.byazt.prf.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1123, 26})
public abstract class qg extends RecyclerView.sz {
    public boolean n = false;
    public n qg;
    public int s;

    public abstract void n();

    public abstract void n(int i, int i2);

    public abstract void n(int i, View view);

    public abstract void qg(RecyclerView recyclerView, int i);

    public qg(n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.prf.RecyclerView.sz
    public void n(RecyclerView recyclerView, int i) {
        super.n(recyclerView, i);
        com.byazt.prf.w wVar = (com.byazt.prf.w) recyclerView.getLayoutManager();
        if (i == 0) {
            int iOa = wVar.oa();
            if (!n(wVar.s(iOa), 50)) {
                iOa--;
            }
            int iMax = Math.max(0, Math.max(iOa, this.s));
            for (int iMin = Math.min(this.s, iOa); iMin <= iMax; iMin++) {
                n(iMin, wVar.s(iMin));
            }
            this.s = iOa;
            int iLh = wVar.lh();
            this.qg.n(recyclerView);
            if ((iOa == iLh - 1 && this.n) || iLh == 1) {
                n();
            }
        }
        qg(recyclerView, i);
    }

    private int n(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean n(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && n(view) >= i;
    }

    @Override // com.byazt.prf.RecyclerView.sz
    public void n(RecyclerView recyclerView, int i, int i2) {
        super.n(recyclerView, i, i2);
        if (i2 == 0) {
            com.byazt.prf.w wVar = (com.byazt.prf.w) recyclerView.getLayoutManager();
            this.s = wVar.d();
            int iOa = wVar.oa();
            if (!n(wVar.s(iOa), 50)) {
                iOa--;
            }
            int iMax = Math.max(0, Math.max(iOa, this.s));
            for (int i3 = this.s; i3 <= iMax; i3++) {
                n(i3, wVar.s(i3));
            }
        }
        this.n = i2 > 0;
        this.qg.n();
        n(i, i2);
    }
}
