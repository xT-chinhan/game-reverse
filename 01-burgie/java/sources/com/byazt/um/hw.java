package com.byazt.um;

import android.graphics.Rect;
import android.view.View;
import com.byazt.hr.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1296, 13})
public abstract class hw extends RecyclerView.g {
    public int hn;
    public pr hw;
    public boolean pr = false;

    public abstract void hw(RecyclerView recyclerView, int i);

    public abstract void pr();

    public abstract void pr(int i, int i2);

    public abstract void pr(int i, View view);

    public hw(pr prVar) {
        this.hw = prVar;
    }

    @Override // com.byazt.hr.RecyclerView.g
    public void pr(RecyclerView recyclerView, int i) {
        super.pr(recyclerView, i);
        com.byazt.hr.c cVar = (com.byazt.hr.c) recyclerView.getLayoutManager();
        if (i == 0) {
            int iW = cVar.w();
            if (!pr(cVar.hw(iW), 50)) {
                iW--;
            }
            int iMax = Math.max(0, Math.max(iW, this.hn));
            for (int iMin = Math.min(this.hn, iW); iMin <= iMax; iMin++) {
                pr(iMin, cVar.hw(iMin));
            }
            this.hn = iW;
            int iGz = cVar.gz();
            this.hw.pr(recyclerView);
            if ((iW == iGz - 1 && this.pr) || iGz == 1) {
                pr();
            }
        }
        hw(recyclerView, i);
    }

    private int pr(View view) {
        Rect rect = new Rect();
        if (view.getLocalVisibleRect(rect) && view.getMeasuredHeight() > 0) {
            return (rect.height() * 100) / view.getMeasuredHeight();
        }
        return -1;
    }

    private boolean pr(View view, int i) {
        if (view == null || !view.getLocalVisibleRect(new Rect()) || view.getVisibility() != 0 || pr(view) < i) {
            return false;
        }
        return true;
    }

    @Override // com.byazt.hr.RecyclerView.g
    public void pr(RecyclerView recyclerView, int i, int i2) {
        super.pr(recyclerView, i, i2);
        if (i2 == 0) {
            com.byazt.hr.c cVar = (com.byazt.hr.c) recyclerView.getLayoutManager();
            this.hn = cVar.vk();
            int iW = cVar.w();
            if (!pr(cVar.hw(iW), 50)) {
                iW--;
            }
            int iMax = Math.max(0, Math.max(iW, this.hn));
            for (int i3 = this.hn; i3 <= iMax; i3++) {
                pr(i3, cVar.hw(i3));
            }
        }
        this.pr = i2 > 0;
        this.hw.pr();
        pr(i, i2);
    }
}
