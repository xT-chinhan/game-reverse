package com.byazt.jt;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 37})
public class pr implements Interpolator {
    public PointF c;
    public PointF hn;
    public PointF hw;
    public PointF pr;
    public PointF x;

    public pr(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.hn = new PointF();
        this.x = new PointF();
        this.c = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.pr = pointF;
        this.hw = pointF2;
    }

    public pr(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return pr(hw(f));
    }

    public float pr(float f) {
        this.c.y = this.pr.y * 3.0f;
        this.x.y = ((this.hw.y - this.pr.y) * 3.0f) - this.c.y;
        this.hn.y = (1.0f - this.c.y) - this.x.y;
        return f * (this.c.y + ((this.x.y + (this.hn.y * f)) * f));
    }

    public float hw(float f) {
        float fHn = f;
        for (int i = 1; i < 14; i++) {
            float fX = x(fHn) - f;
            if (Math.abs(fX) < 0.001d) {
                break;
            }
            fHn -= fX / hn(fHn);
        }
        return fHn;
    }

    private float hn(float f) {
        return this.c.x + (f * ((this.x.x * 2.0f) + (this.hn.x * 3.0f * f)));
    }

    private float x(float f) {
        this.c.x = this.pr.x * 3.0f;
        this.x.x = ((this.hw.x - this.pr.x) * 3.0f) - this.c.x;
        this.hn.x = (1.0f - this.c.x) - this.x.x;
        return f * (this.c.x + ((this.x.x + (this.hn.x * f)) * f));
    }
}
