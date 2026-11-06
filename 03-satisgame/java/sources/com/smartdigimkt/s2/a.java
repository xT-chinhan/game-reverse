package com.smartdigimkt.s2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static volatile a a;

    public a() {
        new CopyOnWriteArrayList();
        new AtomicBoolean(false);
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }
}
