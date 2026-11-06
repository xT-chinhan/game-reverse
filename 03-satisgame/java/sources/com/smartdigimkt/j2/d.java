package com.smartdigimkt.j2;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static volatile boolean b;
    public static volatile boolean d;
    public static final AtomicInteger a = new AtomicInteger(0);
    public static final AtomicInteger c = new AtomicInteger(0);

    public static void a() {
        c.updateAndGet(new c());
    }
}
