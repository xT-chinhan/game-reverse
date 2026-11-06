package com.byazt.ama;

import androidx.core.view.PointerIconCompat;
import com.byazt.prf.RecyclerView;
import com.byazt.prf.sz;
import com.byazt.prf.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_TEXT, 26})
public abstract class qg extends RecyclerView.sz {
    public boolean n = false;

    public abstract void n();

    @Override // com.byazt.prf.RecyclerView.sz
    public void n(RecyclerView recyclerView, int i, int i2) {
        super.n(recyclerView, i, i2);
        this.n = i > 0 || i2 > 0;
    }

    @Override // com.byazt.prf.RecyclerView.sz
    public void n(RecyclerView recyclerView, int i) {
        RecyclerView.rv layoutManager;
        super.n(recyclerView, i);
        if (i == 0 && (layoutManager = recyclerView.getLayoutManager()) != null) {
            int iLh = layoutManager.lh();
            int iN = n(layoutManager);
            if (iLh > 0 && this.n && iN == iLh - 1) {
                n();
            }
        }
    }

    private int n(RecyclerView.rv rvVar) {
        int i = -1;
        if (rvVar instanceof sz) {
            for (int i2 : ((sz) rvVar).n((int[]) null)) {
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }
        if (rvVar instanceof w) {
            return ((w) rvVar).oa();
        }
        return -1;
    }
}
