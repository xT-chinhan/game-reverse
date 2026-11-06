package com.byazt.prf;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 21})
public class x extends RecyclerView.a {
    public PointF s;
    public final float w;
    public final LinearInterpolator n = new LinearInterpolator();
    public final DecelerateInterpolator qg = new DecelerateInterpolator();
    public int q = 0;
    public int l = 0;

    private int qg(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public x(Context context) {
        this.w = n(context.getResources().getDisplayMetrics());
    }

    @Override // com.byazt.prf.RecyclerView.a
    public void n(View view, RecyclerView.py pyVar, RecyclerView.a.n nVar) {
        int iQg = qg(view, qg());
        int iN = n(view, s());
        int iN2 = n((int) Math.sqrt((iQg * iQg) + (iN * iN)));
        if (iN2 > 0) {
            nVar.update(-iQg, -iN, iN2, this.qg);
        }
    }

    @Override // com.byazt.prf.RecyclerView.a
    public void n(int i, int i2, RecyclerView.py pyVar, RecyclerView.a.n nVar) {
        if (rv() == 0) {
            l();
            return;
        }
        this.q = qg(this.q, i);
        int iQg = qg(this.l, i2);
        this.l = iQg;
        if (this.q == 0 && iQg == 0) {
            n(nVar);
        }
    }

    @Override // com.byazt.prf.RecyclerView.a
    public void n() {
        this.l = 0;
        this.q = 0;
        this.s = null;
    }

    public float n(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int n(int i) {
        return (int) Math.ceil(((double) qg(i)) / 0.3356d);
    }

    public int qg(int i) {
        return (int) Math.ceil(Math.abs(i) * this.w);
    }

    public int qg() {
        PointF pointF = this.s;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.s.x > 0.0f ? 1 : -1;
    }

    public int s() {
        PointF pointF = this.s;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.s.y > 0.0f ? 1 : -1;
    }

    public void n(RecyclerView.a.n nVar) {
        PointF pointFQ = q(fs());
        if (pointFQ != null && (pointFQ.x != 0.0f || pointFQ.y != 0.0f)) {
            n(pointFQ);
            this.s = pointFQ;
            this.q = (int) (pointFQ.x * 10000.0f);
            this.l = (int) (pointFQ.y * 10000.0f);
            nVar.update((int) (this.q * 1.2f), (int) (this.l * 1.2f), (int) (qg(10000) * 1.2f), this.n);
            return;
        }
        nVar.n(fs());
        l();
    }

    public int n(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int n(View view, int i) {
        RecyclerView.rv rvVarQ = q();
        if (rvVarQ == null || !rvVarQ.l()) {
            return 0;
        }
        RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
        return n(rvVarQ.rv(view) - tjVar.topMargin, rvVarQ.cp(view) + tjVar.bottomMargin, rvVarQ.t(), rvVarQ.hu() - rvVarQ.bb(), i);
    }

    public int qg(View view, int i) {
        RecyclerView.rv rvVarQ = q();
        if (rvVarQ == null || !rvVarQ.q()) {
            return 0;
        }
        RecyclerView.tj tjVar = (RecyclerView.tj) view.getLayoutParams();
        return n(rvVarQ.fs(view) - tjVar.leftMargin, rvVarQ.tj(view) + tjVar.rightMargin, rvVarQ.h(), rvVarQ.m() - rvVarQ.ur(), i);
    }
}
