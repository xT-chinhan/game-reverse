package com.smartdigimkt.z;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static volatile b0 b;
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public static b0 a() {
        if (b == null) {
            synchronized (b0.class) {
                if (b == null) {
                    b = new b0();
                }
            }
        }
        return b;
    }
}
