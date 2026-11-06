package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public float ab;
    public float ah;
    public float c;
    public float ch;
    public ms d;
    public boolean hi;
    public int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f214ms;
    public int ny;
    public PointF sl;
    public int x;
    public String xr;
    public PointF zb;

    public enum ms {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public xr(String str, String str2, float f, ms msVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        ms(str, str2, f, msVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public xr() {
    }

    public void ms(String str, String str2, float f, ms msVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.f214ms = str;
        this.xr = str2;
        this.ah = f;
        this.d = msVar;
        this.ka = i;
        this.c = f2;
        this.ab = f3;
        this.x = i2;
        this.ny = i3;
        this.ch = f4;
        this.hi = z;
        this.sl = pointF;
        this.zb = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f214ms.hashCode() * 31) + this.xr.hashCode()) * 31) + this.ah)) * 31) + this.d.ordinal()) * 31) + this.ka;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.c);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.x;
    }
}
