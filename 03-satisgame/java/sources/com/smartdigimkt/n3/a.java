package com.smartdigimkt.n3;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static volatile a b;
    public final ConcurrentHashMap a = new ConcurrentHashMap(2);

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }
}
