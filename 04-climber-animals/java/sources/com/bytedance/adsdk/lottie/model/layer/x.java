package com.bytedance.adsdk.lottie.model.layer;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private final String ab;
    private final String ah;
    private final float ao;
    private final boolean b;
    private final long c;
    private final int ch;
    private final long d;
    private final com.bytedance.adsdk.lottie.model.ms.ch h;
    private final int hi;
    private final com.bytedance.adsdk.lottie.d.ch i;
    private final ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.model.xr.ah> f199ms;
    private final xr nw;
    private final com.bytedance.adsdk.lottie.model.ms.sl ny;
    private final com.bytedance.adsdk.lottie.model.ms.hi qv;
    private final com.bytedance.adsdk.lottie.model.xr.ms re;
    private final int sl;
    private final List<com.bytedance.adsdk.lottie.c.ms<Float>> t;
    private final float u;
    private final float ub;
    private final List<com.bytedance.adsdk.lottie.model.xr.x> x;
    private final com.bytedance.adsdk.lottie.c xr;
    private final com.bytedance.adsdk.lottie.model.ms.xr y;
    private final float zb;

    public enum ms {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum xr {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public x(List<com.bytedance.adsdk.lottie.model.xr.ah> list, com.bytedance.adsdk.lottie.c cVar, String str, long j, ms msVar, long j2, String str2, List<com.bytedance.adsdk.lottie.model.xr.x> list2, com.bytedance.adsdk.lottie.model.ms.sl slVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.lottie.model.ms.ch chVar, com.bytedance.adsdk.lottie.model.ms.hi hiVar, List<com.bytedance.adsdk.lottie.c.ms<Float>> list3, xr xrVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, boolean z, com.bytedance.adsdk.lottie.model.xr.ms msVar2, com.bytedance.adsdk.lottie.d.ch chVar2) {
        this.f199ms = list;
        this.xr = cVar;
        this.ah = str;
        this.d = j;
        this.ka = msVar;
        this.c = j2;
        this.ab = str2;
        this.x = list2;
        this.ny = slVar;
        this.ch = i;
        this.hi = i2;
        this.sl = i3;
        this.zb = f;
        this.u = f2;
        this.ub = f3;
        this.ao = f4;
        this.h = chVar;
        this.qv = hiVar;
        this.t = list3;
        this.nw = xrVar;
        this.y = xrVar2;
        this.b = z;
        this.re = msVar2;
        this.i = chVar2;
    }

    com.bytedance.adsdk.lottie.c ms() {
        return this.xr;
    }

    float xr() {
        return this.zb;
    }

    float ah() {
        return this.u / this.xr.qv();
    }

    List<com.bytedance.adsdk.lottie.c.ms<Float>> d() {
        return this.t;
    }

    public long ka() {
        return this.d;
    }

    public String c() {
        return this.ah;
    }

    public String ab() {
        return this.ab;
    }

    float x() {
        return this.ub;
    }

    float ny() {
        return this.ao;
    }

    List<com.bytedance.adsdk.lottie.model.xr.x> ch() {
        return this.x;
    }

    public ms hi() {
        return this.ka;
    }

    xr sl() {
        return this.nw;
    }

    long zb() {
        return this.c;
    }

    List<com.bytedance.adsdk.lottie.model.xr.ah> u() {
        return this.f199ms;
    }

    com.bytedance.adsdk.lottie.model.ms.sl ub() {
        return this.ny;
    }

    int ao() {
        return this.sl;
    }

    int h() {
        return this.hi;
    }

    int qv() {
        return this.ch;
    }

    com.bytedance.adsdk.lottie.model.ms.ch y() {
        return this.h;
    }

    com.bytedance.adsdk.lottie.model.ms.hi t() {
        return this.qv;
    }

    com.bytedance.adsdk.lottie.model.ms.xr nw() {
        return this.y;
    }

    public String toString() {
        return ms("");
    }

    public boolean b() {
        return this.b;
    }

    public com.bytedance.adsdk.lottie.model.xr.ms re() {
        return this.re;
    }

    public com.bytedance.adsdk.lottie.d.ch i() {
        return this.i;
    }

    public String ms(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(c()).append("\n");
        x xVarMs = this.xr.ms(zb());
        if (xVarMs != null) {
            sb.append("\t\tParents: ").append(xVarMs.c());
            x xVarMs2 = this.xr.ms(xVarMs.zb());
            while (xVarMs2 != null) {
                sb.append("->").append(xVarMs2.c());
                xVarMs2 = this.xr.ms(xVarMs2.zb());
            }
            sb.append(str).append("\n");
        }
        if (!ch().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(ch().size()).append("\n");
        }
        if (qv() != 0 && h() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(qv()), Integer.valueOf(h()), Integer.valueOf(ao())));
        }
        if (!this.f199ms.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.bytedance.adsdk.lottie.model.xr.ah> it = this.f199ms.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
