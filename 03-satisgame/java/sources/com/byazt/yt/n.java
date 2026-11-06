package com.byazt.yt;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.byazt.pp.w;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1955, 19})
public class n<T> {
    public float cp;
    public float cy;
    public float d;
    public PointF fs;
    public float k;
    public final Interpolator l;
    public final T n;
    public int oa;
    public final Interpolator q;
    public T qg;
    public PointF rv;
    public final Interpolator s;
    public int sz;
    public final w tj;
    public final float w;
    public Float x;

    public n(w wVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.cp = -3987645.8f;
        this.d = -3987645.8f;
        this.oa = 784923401;
        this.sz = 784923401;
        this.k = Float.MIN_VALUE;
        this.cy = Float.MIN_VALUE;
        this.fs = null;
        this.rv = null;
        this.tj = wVar;
        this.n = t;
        this.qg = t2;
        this.s = interpolator;
        this.q = null;
        this.l = null;
        this.w = f;
        this.x = f2;
    }

    public n(w wVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.cp = -3987645.8f;
        this.d = -3987645.8f;
        this.oa = 784923401;
        this.sz = 784923401;
        this.k = Float.MIN_VALUE;
        this.cy = Float.MIN_VALUE;
        this.fs = null;
        this.rv = null;
        this.tj = wVar;
        this.n = t;
        this.qg = t2;
        this.s = null;
        this.q = interpolator;
        this.l = interpolator2;
        this.w = f;
        this.x = f2;
    }

    public n(w wVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.cp = -3987645.8f;
        this.d = -3987645.8f;
        this.oa = 784923401;
        this.sz = 784923401;
        this.k = Float.MIN_VALUE;
        this.cy = Float.MIN_VALUE;
        this.fs = null;
        this.rv = null;
        this.tj = wVar;
        this.n = t;
        this.qg = t2;
        this.s = interpolator;
        this.q = interpolator2;
        this.l = interpolator3;
        this.w = f;
        this.x = f2;
    }

    public n(T t) {
        this.cp = -3987645.8f;
        this.d = -3987645.8f;
        this.oa = 784923401;
        this.sz = 784923401;
        this.k = Float.MIN_VALUE;
        this.cy = Float.MIN_VALUE;
        this.fs = null;
        this.rv = null;
        this.tj = null;
        this.n = t;
        this.qg = t;
        this.s = null;
        this.q = null;
        this.l = null;
        this.w = Float.MIN_VALUE;
        this.x = Float.valueOf(Float.MAX_VALUE);
    }

    private n(T t, T t2) {
        this.cp = -3987645.8f;
        this.d = -3987645.8f;
        this.oa = 784923401;
        this.sz = 784923401;
        this.k = Float.MIN_VALUE;
        this.cy = Float.MIN_VALUE;
        this.fs = null;
        this.rv = null;
        this.tj = null;
        this.n = t;
        this.qg = t2;
        this.s = null;
        this.q = null;
        this.l = null;
        this.w = Float.MIN_VALUE;
        this.x = Float.valueOf(Float.MAX_VALUE);
    }

    public n<T> n(T t, T t2) {
        return new n<>(t, t2);
    }

    public float s() {
        w wVar = this.tj;
        if (wVar == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.w - wVar.w()) / this.tj.cd();
        }
        return this.k;
    }

    public float q() {
        if (this.tj == null) {
            return 1.0f;
        }
        if (this.cy == Float.MIN_VALUE) {
            if (this.x == null) {
                this.cy = 1.0f;
            } else {
                this.cy = s() + ((this.x.floatValue() - this.w) / this.tj.cd());
            }
        }
        return this.cy;
    }

    public boolean l() {
        return this.s == null && this.q == null && this.l == null;
    }

    public boolean n(float f) {
        return f >= s() && f < q();
    }

    public float w() {
        if (this.cp == -3987645.8f) {
            this.cp = ((Float) this.n).floatValue();
        }
        return this.cp;
    }

    public float x() {
        if (this.d == -3987645.8f) {
            this.d = ((Float) this.qg).floatValue();
        }
        return this.d;
    }

    public int fs() {
        if (this.oa == 784923401) {
            this.oa = ((Integer) this.n).intValue();
        }
        return this.oa;
    }

    public int rv() {
        if (this.sz == 784923401) {
            this.sz = ((Integer) this.qg).intValue();
        }
        return this.sz;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.n + ", endValue=" + this.qg + ", startFrame=" + this.w + ", endFrame=" + this.x + ", interpolator=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}
