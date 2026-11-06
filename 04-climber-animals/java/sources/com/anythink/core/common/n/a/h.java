package com.anythink.core.common.n.a;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    public final String a;
    public final boolean b;
    public final int c;
    public final boolean d;

    private h(String str, boolean z, boolean z2) {
        this(str, z, z2, (byte) 0);
    }

    private h(String str, boolean z, boolean z2, byte b) {
        this.a = str;
        this.b = z;
        this.d = z2;
        this.c = 0;
    }

    private h(String str, boolean z) {
        this(str, z, false, (byte) 0);
    }

    public h(String str) {
        this(str, false, false, (byte) 0);
    }
}
