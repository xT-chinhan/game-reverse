package com.bytedance.sdk.openadsdk.core.ugeno.component.xr;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr extends RecyclerView.u {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3491ms = false;
    private ms xr;

    public abstract void ms();

    public abstract void ms(int i, int i2);

    public abstract void ms(int i, View view);

    public abstract void xr(RecyclerView recyclerView, int i);

    public xr(ms msVar) {
        this.xr = msVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void ms(RecyclerView recyclerView, int i) {
        super.ms(recyclerView, i);
        com.bytedance.sdk.component.widget.recycler.ka kaVar = (com.bytedance.sdk.component.widget.recycler.ka) recyclerView.getLayoutManager();
        if (i == 0) {
            int iHi = kaVar.hi();
            if (!ms(kaVar.xr(iHi), 50)) {
                iHi--;
            }
            int iMax = Math.max(0, Math.max(iHi, this.ah));
            for (int iMin = Math.min(this.ah, iHi); iMin <= iMax; iMin++) {
                ms(iMin, kaVar.xr(iMin));
            }
            this.ah = iHi;
            int iCv = kaVar.cv();
            this.xr.ms(recyclerView);
            if ((iHi == iCv - 1 && this.f3491ms) || iCv == 1) {
                ms();
            }
        }
        xr(recyclerView, i);
    }

    private int ms(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean ms(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && ms(view) >= i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.u
    public void ms(RecyclerView recyclerView, int i, int i2) {
        super.ms(recyclerView, i, i2);
        if (i2 == 0) {
            com.bytedance.sdk.component.widget.recycler.ka kaVar = (com.bytedance.sdk.component.widget.recycler.ka) recyclerView.getLayoutManager();
            this.ah = kaVar.ch();
            int iHi = kaVar.hi();
            if (!ms(kaVar.xr(iHi), 50)) {
                iHi--;
            }
            int iMax = Math.max(0, Math.max(iHi, this.ah));
            for (int i3 = this.ah; i3 <= iMax; i3++) {
                ms(i3, kaVar.xr(i3));
            }
        }
        this.f3491ms = i2 > 0;
        this.xr.ms();
        ms(i, i2);
    }
}
