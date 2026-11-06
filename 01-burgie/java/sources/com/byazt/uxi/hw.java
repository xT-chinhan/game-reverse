package com.byazt.uxi;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 13})
public class hw {
    public int aj;
    public int c;
    public float fw;
    public c g;
    public float hn;
    public String ho;
    public String hw;
    public PointF k;
    public PointF m;
    public String nt;
    public String pr;
    public float uc;
    public float vk;
    public boolean w;
    public pr x;
    public int zo;

    public enum pr {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public hw(String str, String str2, float f, pr prVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, c cVar, String str3, String str4) {
        pr(str, str2, f, prVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2, cVar, str3, str4);
    }

    public hw() {
        this.g = new c();
    }

    public void pr(String str, String str2, float f, pr prVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2, c cVar, String str3, String str4) {
        this.pr = str;
        this.hw = str2;
        this.hn = f;
        this.x = prVar;
        this.c = i;
        this.uc = f2;
        this.fw = f3;
        this.zo = i2;
        this.aj = i3;
        this.vk = f4;
        this.w = z;
        this.k = pointF;
        this.m = pointF2;
        this.g = cVar;
        this.ho = str3;
        this.nt = str4;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.pr.hashCode() * 31) + this.hw.hashCode()) * 31) + this.hn)) * 31) + this.x.ordinal()) * 31) + this.c;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.uc);
        return (((((((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.zo) * 31) + this.g.pr) * 31) + this.g.hw;
    }
}
