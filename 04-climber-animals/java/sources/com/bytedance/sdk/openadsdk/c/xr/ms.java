package com.bytedance.sdk.openadsdk.c.xr;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private int xr = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public Map<Integer, Long> f1876ms = new ConcurrentHashMap();

    public void ms() {
        this.xr = 0;
        try {
            this.f1876ms.clear();
        } catch (Exception unused) {
        }
    }

    public boolean ms(int i) {
        return (this.xr & i) == i;
    }

    public Long xr(int i) {
        try {
            if (ms(i)) {
                return this.f1876ms.get(Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public void ah(int i) {
        if (ms(i)) {
            return;
        }
        this.xr |= i;
        try {
            this.f1876ms.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    public boolean d(int i) {
        return i == this.xr;
    }
}
