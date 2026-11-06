package com.smartdigimkt.w2;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static volatile c a;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }
}
