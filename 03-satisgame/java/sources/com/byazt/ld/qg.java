package com.byazt.ld;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 26})
public class qg {
    public boolean cp;
    public String cy;
    public PointF d;
    public int fs;
    public String k;
    public int l;
    public String n;
    public PointF oa;
    public n q;
    public String qg;
    public int rv;
    public float s;
    public l sz;
    public float tj;
    public float w;
    public float x;

    public enum n {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public qg(String str, String str2, float f, n nVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, l lVar, String str3, String str4) {
        n(str, str2, f, nVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2, lVar, str3, str4);
    }

    public qg() {
        this.sz = new l();
    }

    public void n(String str, String str2, float f, n nVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, l lVar, String str3, String str4) {
        this.n = str;
        this.qg = str2;
        this.s = f;
        this.q = nVar;
        this.l = i;
        this.w = f2;
        this.x = f3;
        this.fs = i2;
        this.rv = i3;
        this.tj = f4;
        this.cp = z;
        this.d = pointF;
        this.oa = pointF2;
        this.sz = lVar;
        this.k = str3;
        this.cy = str4;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.n.hashCode() * 31) + this.qg.hashCode()) * 31) + this.s)) * 31) + this.q.ordinal()) * 31) + this.l;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.w);
        return (((((((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.fs) * 31) + this.sz.n) * 31) + this.sz.qg;
    }
}
