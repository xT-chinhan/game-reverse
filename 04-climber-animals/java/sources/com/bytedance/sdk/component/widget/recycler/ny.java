package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends sl {
    private x ah;
    private x xr;

    @Override // com.bytedance.sdk.component.widget.recycler.sl
    public int[] ms(RecyclerView.ny nyVar, View view) {
        int[] iArr = new int[2];
        if (nyVar.ah()) {
            iArr[0] = ms(nyVar, view, ka(nyVar));
        } else {
            iArr[0] = 0;
        }
        if (nyVar.d()) {
            iArr[1] = ms(nyVar, view, d(nyVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.sl
    public View ms(RecyclerView.ny nyVar) {
        if (nyVar.d()) {
            return ms(nyVar, d(nyVar));
        }
        if (nyVar.ah()) {
            return ms(nyVar, ka(nyVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.sl
    public int ms(RecyclerView.ny nyVar, int i, int i2) {
        View viewXr;
        int iD;
        PointF pointFAh;
        int iCv = nyVar.cv();
        if (iCv == 0) {
            return -1;
        }
        if (nyVar.d()) {
            viewXr = xr(nyVar, d(nyVar));
        } else {
            viewXr = nyVar.ah() ? xr(nyVar, ka(nyVar)) : null;
        }
        if (viewXr == null || (iD = nyVar.d(viewXr)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !nyVar.ah() ? i2 <= 0 : i <= 0;
        if ((nyVar instanceof RecyclerView.y.xr) && (pointFAh = ((RecyclerView.y.xr) nyVar).ah(iCv - 1)) != null && (pointFAh.x < 0.0f || pointFAh.y < 0.0f)) {
            z = true;
        }
        if (z) {
            return z2 ? iD - 1 : iD;
        }
        return z2 ? iD + 1 : iD;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.sl
    protected c xr(RecyclerView.ny nyVar) {
        if (nyVar instanceof RecyclerView.y.xr) {
            return new c(this.f1426ms.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.ny.1
                @Override // com.bytedance.sdk.component.widget.recycler.c, com.bytedance.sdk.component.widget.recycler.RecyclerView.y
                protected void ms(View view, RecyclerView.t tVar, RecyclerView.y.ms msVar) {
                    ny nyVar2 = ny.this;
                    int[] iArrMs = nyVar2.ms(nyVar2.f1426ms.getLayoutManager(), view);
                    int i = iArrMs[0];
                    int i2 = iArrMs[1];
                    int iMs = ms(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iMs > 0) {
                        msVar.update(i, i2, iMs, this.xr);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.c
                protected float ms(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.c
                protected int xr(int i) {
                    return Math.min(100, super.xr(i));
                }
            };
        }
        return null;
    }

    private int ms(RecyclerView.ny nyVar, View view, x xVar) {
        int iKa;
        int iMs = xVar.ms(view) + (xVar.ka(view) / 2);
        if (nyVar.ub()) {
            iKa = xVar.ah() + (xVar.c() / 2);
        } else {
            iKa = xVar.ka() / 2;
        }
        return iMs - iKa;
    }

    private View ms(RecyclerView.ny nyVar, x xVar) {
        int iKa;
        int iY = nyVar.y();
        View view = null;
        if (iY == 0) {
            return null;
        }
        if (nyVar.ub()) {
            iKa = xVar.ah() + (xVar.c() / 2);
        } else {
            iKa = xVar.ka() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iY; i2++) {
            View viewX = nyVar.x(i2);
            int iAbs = Math.abs((xVar.ms(viewX) + (xVar.ka(viewX) / 2)) - iKa);
            if (iAbs < i) {
                view = viewX;
                i = iAbs;
            }
        }
        return view;
    }

    private View xr(RecyclerView.ny nyVar, x xVar) {
        int iY = nyVar.y();
        View view = null;
        if (iY == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iY; i2++) {
            View viewX = nyVar.x(i2);
            int iMs = xVar.ms(viewX);
            if (iMs < i) {
                view = viewX;
                i = iMs;
            }
        }
        return view;
    }

    private x d(RecyclerView.ny nyVar) {
        x xVar = this.xr;
        if (xVar == null || xVar.f1430ms != nyVar) {
            this.xr = x.xr(nyVar);
        }
        return this.xr;
    }

    private x ka(RecyclerView.ny nyVar) {
        x xVar = this.ah;
        if (xVar == null || xVar.f1430ms != nyVar) {
            this.ah = x.ms(nyVar);
        }
        return this.ah;
    }
}
