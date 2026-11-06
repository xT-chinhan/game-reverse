package com.bytedance.adsdk.lottie.c;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.lottie.c;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ms<T> {
    public Float ab;
    public final Interpolator ah;
    private float ao;
    public final float c;
    private final c ch;
    public final Interpolator d;
    private float hi;
    public final Interpolator ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final T f150ms;
    public PointF ny;
    private float sl;
    private int u;
    private float ub;
    public PointF x;
    public T xr;
    private int zb;

    public ms(c cVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.hi = -3987645.8f;
        this.sl = -3987645.8f;
        this.zb = 784923401;
        this.u = 784923401;
        this.ub = Float.MIN_VALUE;
        this.ao = Float.MIN_VALUE;
        this.x = null;
        this.ny = null;
        this.ch = cVar;
        this.f150ms = t;
        this.xr = t2;
        this.ah = interpolator;
        this.d = null;
        this.ka = null;
        this.c = f;
        this.ab = f2;
    }

    public ms(c cVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.hi = -3987645.8f;
        this.sl = -3987645.8f;
        this.zb = 784923401;
        this.u = 784923401;
        this.ub = Float.MIN_VALUE;
        this.ao = Float.MIN_VALUE;
        this.x = null;
        this.ny = null;
        this.ch = cVar;
        this.f150ms = t;
        this.xr = t2;
        this.ah = null;
        this.d = interpolator;
        this.ka = interpolator2;
        this.c = f;
        this.ab = f2;
    }

    protected ms(c cVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.hi = -3987645.8f;
        this.sl = -3987645.8f;
        this.zb = 784923401;
        this.u = 784923401;
        this.ub = Float.MIN_VALUE;
        this.ao = Float.MIN_VALUE;
        this.x = null;
        this.ny = null;
        this.ch = cVar;
        this.f150ms = t;
        this.xr = t2;
        this.ah = interpolator;
        this.d = interpolator2;
        this.ka = interpolator3;
        this.c = f;
        this.ab = f2;
    }

    public ms(T t) {
        this.hi = -3987645.8f;
        this.sl = -3987645.8f;
        this.zb = 784923401;
        this.u = 784923401;
        this.ub = Float.MIN_VALUE;
        this.ao = Float.MIN_VALUE;
        this.x = null;
        this.ny = null;
        this.ch = null;
        this.f150ms = t;
        this.xr = t;
        this.ah = null;
        this.d = null;
        this.ka = null;
        this.c = Float.MIN_VALUE;
        this.ab = Float.valueOf(Float.MAX_VALUE);
    }

    private ms(T t, T t2) {
        this.hi = -3987645.8f;
        this.sl = -3987645.8f;
        this.zb = 784923401;
        this.u = 784923401;
        this.ub = Float.MIN_VALUE;
        this.ao = Float.MIN_VALUE;
        this.x = null;
        this.ny = null;
        this.ch = null;
        this.f150ms = t;
        this.xr = t2;
        this.ah = null;
        this.d = null;
        this.ka = null;
        this.c = Float.MIN_VALUE;
        this.ab = Float.valueOf(Float.MAX_VALUE);
    }

    public ms<T> ms(T t, T t2) {
        return new ms<>(t, t2);
    }

    public float ah() {
        c cVar = this.ch;
        if (cVar == null) {
            return 0.0f;
        }
        if (this.ub == Float.MIN_VALUE) {
            this.ub = (this.c - cVar.c()) / this.ch.qv();
        }
        return this.ub;
    }

    public float d() {
        if (this.ch == null) {
            return 1.0f;
        }
        if (this.ao == Float.MIN_VALUE) {
            if (this.ab == null) {
                this.ao = 1.0f;
            } else {
                this.ao = ah() + ((this.ab.floatValue() - this.c) / this.ch.qv());
            }
        }
        return this.ao;
    }

    public boolean ka() {
        return this.ah == null && this.d == null && this.ka == null;
    }

    public boolean ms(float f) {
        return f >= ah() && f < d();
    }

    public float c() {
        if (this.hi == -3987645.8f) {
            this.hi = ((Float) this.f150ms).floatValue();
        }
        return this.hi;
    }

    public float ab() {
        if (this.sl == -3987645.8f) {
            this.sl = ((Float) this.xr).floatValue();
        }
        return this.sl;
    }

    public int x() {
        if (this.zb == 784923401) {
            this.zb = ((Integer) this.f150ms).intValue();
        }
        return this.zb;
    }

    public int ny() {
        if (this.u == 784923401) {
            this.u = ((Integer) this.xr).intValue();
        }
        return this.u;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f150ms + ", endValue=" + this.xr + ", startFrame=" + this.c + ", endFrame=" + this.ab + ", interpolator=" + this.ah + AbstractJsonLexerKt.END_OBJ;
    }
}
