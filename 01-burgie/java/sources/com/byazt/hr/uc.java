package com.byazt.hr;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 5})
public class uc extends RecyclerView.qa {
    public PointF hn;
    public final float uc;
    public final LinearInterpolator pr = new LinearInterpolator();
    public final DecelerateInterpolator hw = new DecelerateInterpolator();
    public int x = 0;
    public int c = 0;

    public uc(Context context) {
        this.uc = pr(context.getResources().getDisplayMetrics());
    }

    @Override // com.byazt.hr.RecyclerView.qa
    public void pr(View view, RecyclerView.a aVar, RecyclerView.qa.pr prVar) {
        int iHw = hw(view, hw());
        int iPr = pr(view, hn());
        int iPr2 = pr((int) Math.sqrt((iHw * iHw) + (iPr * iPr)));
        if (iPr2 > 0) {
            prVar.update(-iHw, -iPr, iPr2, this.hw);
        }
    }

    @Override // com.byazt.hr.RecyclerView.qa
    public void pr(int i, int i2, RecyclerView.a aVar, RecyclerView.qa.pr prVar) {
        if (aj() == 0) {
            c();
            return;
        }
        this.x = hw(this.x, i);
        int iHw = hw(this.c, i2);
        this.c = iHw;
        if (this.x == 0 && iHw == 0) {
            pr(prVar);
        }
    }

    @Override // com.byazt.hr.RecyclerView.qa
    public void pr() {
        this.c = 0;
        this.x = 0;
        this.hn = null;
    }

    public float pr(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int pr(int i) {
        return (int) Math.ceil(((double) hw(i)) / 0.3356d);
    }

    public int hw(int i) {
        return (int) Math.ceil(Math.abs(i) * this.uc);
    }

    public int hw() {
        PointF pointF = this.hn;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.hn.x > 0.0f ? 1 : -1;
    }

    public int hn() {
        PointF pointF = this.hn;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.hn.y > 0.0f ? 1 : -1;
    }

    public void pr(RecyclerView.qa.pr prVar) {
        PointF pointFX = x(zo());
        if (pointFX != null && (pointFX.x != 0.0f || pointFX.y != 0.0f)) {
            pr(pointFX);
            this.hn = pointFX;
            this.x = (int) (pointFX.x * 10000.0f);
            this.c = (int) (pointFX.y * 10000.0f);
            prVar.update((int) (this.x * 1.2f), (int) (this.c * 1.2f), (int) (hw(10000) * 1.2f), this.pr);
            return;
        }
        prVar.pr(zo());
        c();
    }

    private int hw(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public int pr(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                int i7 = i4 - i2;
                if (i7 < 0) {
                    return i7;
                }
                return 0;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int pr(View view, int i) {
        RecyclerView.aj ajVarX = x();
        if (ajVarX != null && ajVarX.x()) {
            RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
            return pr(ajVarX.zo(view) - vkVar.topMargin, ajVarX.vk(view) + vkVar.bottomMargin, ajVarX.z(), ajVarX.fo() - ajVarX.iu(), i);
        }
        return 0;
    }

    public int hw(View view, int i) {
        RecyclerView.aj ajVarX = x();
        if (ajVarX != null && ajVarX.hn()) {
            RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
            return pr(ajVarX.fw(view) - vkVar.leftMargin, ajVarX.aj(view) + vkVar.rightMargin, ajVarX.rc(), ajVarX.ny() - ajVarX.b(), i);
        }
        return 0;
    }
}
