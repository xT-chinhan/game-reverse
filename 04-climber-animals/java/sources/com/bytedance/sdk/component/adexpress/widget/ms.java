package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Interpolator {
    protected PointF ah;
    protected PointF d;
    protected PointF ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected PointF f989ms;
    protected PointF xr;

    public ms(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.ah = new PointF();
        this.d = new PointF();
        this.ka = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.f989ms = pointF;
        this.xr = pointF2;
    }

    public ms(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return ms(xr(f));
    }

    protected float ms(float f) {
        this.ka.y = this.f989ms.y * 3.0f;
        this.d.y = ((this.xr.y - this.f989ms.y) * 3.0f) - this.ka.y;
        this.ah.y = (1.0f - this.ka.y) - this.d.y;
        return f * (this.ka.y + ((this.d.y + (this.ah.y * f)) * f));
    }

    protected float xr(float f) {
        float fAh = f;
        for (int i = 1; i < 14; i++) {
            float fD = d(fAh) - f;
            if (Math.abs(fD) < 0.001d) {
                break;
            }
            fAh -= fD / ah(fAh);
        }
        return fAh;
    }

    private float ah(float f) {
        return this.ka.x + (f * ((this.d.x * 2.0f) + (this.ah.x * 3.0f * f)));
    }

    private float d(float f) {
        this.ka.x = this.f989ms.x * 3.0f;
        this.d.x = ((this.xr.x - this.f989ms.x) * 3.0f) - this.ka.x;
        this.ah.x = (1.0f - this.ka.x) - this.d.x;
        return f * (this.ka.x + ((this.d.x + (this.ah.x * f)) * f));
    }
}
