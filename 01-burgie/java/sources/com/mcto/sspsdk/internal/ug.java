package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ug {
    public static volatile ug c;
    public int a = -1;
    public long b = 0;

    public static ug a() {
        if (c != null) {
            return c;
        }
        synchronized (ug.class) {
            if (c == null) {
                c = new ug();
            }
        }
        return c;
    }
}
