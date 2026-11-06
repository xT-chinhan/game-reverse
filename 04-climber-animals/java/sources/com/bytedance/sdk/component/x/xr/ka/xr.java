package com.bytedance.sdk.component.x.xr.ka;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr implements Comparable<xr>, Runnable {
    private String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1557ms = 5;
    private String xr = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public xr(String str) {
        this.ah = str;
    }

    public void ms(int i) {
        this.f1557ms = i;
    }

    public int ms() {
        return this.f1557ms;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public int compareTo(xr xrVar) {
        if (ms() < xrVar.ms()) {
            return 1;
        }
        return ms() >= xrVar.ms() ? -1 : 0;
    }
}
