package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class ch {
    static int ms(RecyclerView.t tVar, x xVar, View view, View view2, RecyclerView.ny nyVar, boolean z, boolean z2) {
        if (nyVar.y() == 0 || tVar.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (tVar.d() - Math.max(nyVar.d(view), nyVar.d(view2))) - 1) : Math.max(0, Math.min(nyVar.d(view), nyVar.d(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(xVar.xr(view2) - xVar.ms(view)) / (Math.abs(nyVar.d(view) - nyVar.d(view2)) + 1))) + (xVar.ah() - xVar.ms(view)));
        }
        return iMax;
    }

    static int ms(RecyclerView.t tVar, x xVar, View view, View view2, RecyclerView.ny nyVar, boolean z) {
        if (nyVar.y() == 0 || tVar.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(nyVar.d(view) - nyVar.d(view2)) + 1;
        }
        return Math.min(xVar.c(), xVar.xr(view2) - xVar.ms(view));
    }

    static int xr(RecyclerView.t tVar, x xVar, View view, View view2, RecyclerView.ny nyVar, boolean z) {
        if (nyVar.y() == 0 || tVar.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.d();
        }
        return (int) (((xVar.xr(view2) - xVar.ms(view)) / (Math.abs(nyVar.d(view) - nyVar.d(view2)) + 1)) * tVar.d());
    }
}
