package com.smartdigimkt.n3;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final AtomicBoolean a = new AtomicBoolean(true);

    public static void a(com.smartdigimkt.v4.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        try {
            com.smartdigimkt.q3.f.a().a(new h(aVar, z, a.getAndSet(false)), 0L, 8);
        } catch (Throwable unused) {
        }
    }
}
