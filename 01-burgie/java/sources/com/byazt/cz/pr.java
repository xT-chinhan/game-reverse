package com.byazt.cz;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.byazt.dx.uc;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 213, 37})
public class pr<T> {
    public PointF aj;
    public final Interpolator c;
    public Float fw;
    public int g;
    public final Interpolator hn;
    public float ho;
    public T hw;
    public float k;
    public int m;
    public float nt;
    public final T pr;
    public final float uc;
    public final uc vk;
    public float w;
    public final Interpolator x;
    public PointF zo;

    public pr(uc ucVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.w = -3987645.8f;
        this.k = -3987645.8f;
        this.m = 784923401;
        this.g = 784923401;
        this.ho = Float.MIN_VALUE;
        this.nt = Float.MIN_VALUE;
        this.zo = null;
        this.aj = null;
        this.vk = ucVar;
        this.pr = t;
        this.hw = t2;
        this.hn = interpolator;
        this.x = null;
        this.c = null;
        this.uc = f;
        this.fw = f2;
    }

    public pr(uc ucVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.w = -3987645.8f;
        this.k = -3987645.8f;
        this.m = 784923401;
        this.g = 784923401;
        this.ho = Float.MIN_VALUE;
        this.nt = Float.MIN_VALUE;
        this.zo = null;
        this.aj = null;
        this.vk = ucVar;
        this.pr = t;
        this.hw = t2;
        this.hn = null;
        this.x = interpolator;
        this.c = interpolator2;
        this.uc = f;
        this.fw = f2;
    }

    public pr(uc ucVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.w = -3987645.8f;
        this.k = -3987645.8f;
        this.m = 784923401;
        this.g = 784923401;
        this.ho = Float.MIN_VALUE;
        this.nt = Float.MIN_VALUE;
        this.zo = null;
        this.aj = null;
        this.vk = ucVar;
        this.pr = t;
        this.hw = t2;
        this.hn = interpolator;
        this.x = interpolator2;
        this.c = interpolator3;
        this.uc = f;
        this.fw = f2;
    }

    public pr(T t) {
        this.w = -3987645.8f;
        this.k = -3987645.8f;
        this.m = 784923401;
        this.g = 784923401;
        this.ho = Float.MIN_VALUE;
        this.nt = Float.MIN_VALUE;
        this.zo = null;
        this.aj = null;
        this.vk = null;
        this.pr = t;
        this.hw = t;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.uc = Float.MIN_VALUE;
        this.fw = Float.valueOf(Float.MAX_VALUE);
    }

    private pr(T t, T t2) {
        this.w = -3987645.8f;
        this.k = -3987645.8f;
        this.m = 784923401;
        this.g = 784923401;
        this.ho = Float.MIN_VALUE;
        this.nt = Float.MIN_VALUE;
        this.zo = null;
        this.aj = null;
        this.vk = null;
        this.pr = t;
        this.hw = t2;
        this.hn = null;
        this.x = null;
        this.c = null;
        this.uc = Float.MIN_VALUE;
        this.fw = Float.valueOf(Float.MAX_VALUE);
    }

    public pr<T> pr(T t, T t2) {
        return new pr<>(t, t2);
    }

    public float hn() {
        uc ucVar = this.vk;
        if (ucVar == null) {
            return 0.0f;
        }
        if (this.ho == Float.MIN_VALUE) {
            this.ho = (this.uc - ucVar.uc()) / this.vk.lb();
        }
        return this.ho;
    }

    public float x() {
        if (this.vk == null) {
            return 1.0f;
        }
        if (this.nt == Float.MIN_VALUE) {
            if (this.fw == null) {
                this.nt = 1.0f;
            } else {
                this.nt = hn() + ((this.fw.floatValue() - this.uc) / this.vk.lb());
            }
        }
        return this.nt;
    }

    public boolean c() {
        return this.hn == null && this.x == null && this.c == null;
    }

    public boolean pr(float f) {
        return f >= hn() && f < x();
    }

    public float uc() {
        if (this.w == -3987645.8f) {
            this.w = ((Float) this.pr).floatValue();
        }
        return this.w;
    }

    public float fw() {
        if (this.k == -3987645.8f) {
            this.k = ((Float) this.hw).floatValue();
        }
        return this.k;
    }

    public int zo() {
        if (this.m == 784923401) {
            this.m = ((Integer) this.pr).intValue();
        }
        return this.m;
    }

    public int aj() {
        if (this.g == 784923401) {
            this.g = ((Integer) this.hw).intValue();
        }
        return this.g;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.pr + ", endValue=" + this.hw + ", startFrame=" + this.uc + ", endFrame=" + this.fw + ", interpolator=" + this.hn + AbstractJsonLexerKt.END_OBJ;
    }
}
