package com.anythink.core.common.m.a;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 3;
    public static final int h = 999;
    public static final m i = new m(a.NO_NETWORK);
    public static final m j = new m(a.WIFI);
    public final int k = 0;
    public final a l;

    private m(a aVar) {
        this.l = aVar;
    }

    public enum a {
        NO_NETWORK,
        WIFI,
        MOBILE;

        private static /* synthetic */ a[] a() {
            return new a[]{NO_NETWORK, WIFI, MOBILE};
        }
    }
}
