package com.smartdigimkt.z;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static volatile d b;
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }
}
