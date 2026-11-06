package com.bytedance.sdk.component.widget.recycler;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RecyclerView.y {
    protected PointF ah;
    private final float c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final LinearInterpolator f1409ms = new LinearInterpolator();
    protected final DecelerateInterpolator xr = new DecelerateInterpolator();
    protected int d = 0;
    protected int ka = 0;

    private int xr(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public c(Context context) {
        this.c = ms(context.getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    protected void ms(View view, RecyclerView.t tVar, RecyclerView.y.ms msVar) {
        int iXr = xr(view, xr());
        int iMs = ms(view, ah());
        int iMs2 = ms((int) Math.sqrt((iXr * iXr) + (iMs * iMs)));
        if (iMs2 > 0) {
            msVar.update(-iXr, -iMs, iMs2, this.xr);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    protected void ms(int i, int i2, RecyclerView.t tVar, RecyclerView.y.ms msVar) {
        if (ny() == 0) {
            ka();
            return;
        }
        this.d = xr(this.d, i);
        int iXr = xr(this.ka, i2);
        this.ka = iXr;
        if (this.d == 0 && iXr == 0) {
            ms(msVar);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    protected void ms() {
        this.ka = 0;
        this.d = 0;
        this.ah = null;
    }

    protected float ms(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    protected int ms(int i) {
        return (int) Math.ceil(((double) xr(i)) / 0.3356d);
    }

    protected int xr(int i) {
        return (int) Math.ceil(Math.abs(i) * this.c);
    }

    protected int xr() {
        PointF pointF = this.ah;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.ah.x > 0.0f ? 1 : -1;
    }

    protected int ah() {
        PointF pointF = this.ah;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.ah.y > 0.0f ? 1 : -1;
    }

    protected void ms(RecyclerView.y.ms msVar) {
        PointF pointFD = d(x());
        if (pointFD != null && (pointFD.x != 0.0f || pointFD.y != 0.0f)) {
            ms(pointFD);
            this.ah = pointFD;
            this.d = (int) (pointFD.x * 10000.0f);
            this.ka = (int) (pointFD.y * 10000.0f);
            msVar.update((int) (this.d * 1.2f), (int) (this.ka * 1.2f), (int) (xr(10000) * 1.2f), this.f1409ms);
            return;
        }
        msVar.ms(x());
        ka();
    }

    public int ms(int i, int i2, int i3, int i4, int i5) {
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

    public int ms(View view, int i) {
        RecyclerView.ny nyVarD = d();
        if (nyVarD == null || !nyVarD.d()) {
            return 0;
        }
        RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
        return ms(nyVarD.x(view) - chVar.topMargin, nyVarD.ch(view) + chVar.bottomMargin, nyVarD.w(), nyVarD.re() - nyVarD.op(), i);
    }

    public int xr(View view, int i) {
        RecyclerView.ny nyVarD = d();
        if (nyVarD == null || !nyVarD.ah()) {
            return 0;
        }
        RecyclerView.ch chVar = (RecyclerView.ch) view.getLayoutParams();
        return ms(nyVarD.ab(view) - chVar.leftMargin, nyVarD.ny(view) + chVar.rightMargin, nyVarD.i(), nyVarD.b() - nyVarD.yu(), i);
    }
}
