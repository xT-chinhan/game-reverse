package com.anythink.basead.d;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public long k;
    public long l;
    public float[] m;
    public a o;
    public int j = -1;
    public int n = 0;

    /* JADX INFO: renamed from: com.anythink.basead.d.a$a, reason: collision with other inner class name */
    public static class C0015a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
    }

    public static class b {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("AdClickRecord{clickDownX=").append(this.a).append(", clickDownY=").append(this.b).append(", clickUpX=").append(this.c).append(", clickUpY=").append(this.d).append(", clickRelateDownX=").append(this.e).append(", clickRelateDownY=").append(this.f).append(", clickRelateUpX=").append(this.g).append(", clickRelateUpY=").append(this.h).append(", isDeeplinkClick=").append(this.i).append(", downloadType=").append(this.j).append(", clickDownTimeMs=").append(this.k).append(", clickUpTimeMs=").append(this.l).append(", trackingClickType=").append(this.n).append(", shakeMaxAccValues=").append(this.m).append(", innerAdClickRecord=[");
        a aVar = this.o;
        return sbAppend.append(aVar == null ? AbstractJsonLexerKt.NULL : aVar.toString()).append("]}").toString();
    }

    private boolean a() {
        return this.a > 0 || this.b > 0 || this.c > 0 || this.d > 0;
    }
}
