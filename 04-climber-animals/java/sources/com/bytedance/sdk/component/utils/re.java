package com.bytedance.sdk.component.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class re {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> f1365ms = new ConcurrentHashMap<>();

    public abstract boolean ms(int i);

    public void ms(int i, int i2, Runnable runnable) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.f1365ms.get(Integer.valueOf(i));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.f1365ms.put(Integer.valueOf(i), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i2), runnable);
    }

    public void ms(int i, int i2) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i <= 0 || i2 <= 0 || (concurrentHashMap = this.f1365ms.get(Integer.valueOf(i))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i2));
    }

    public void xr(int i) {
        this.f1365ms.remove(Integer.valueOf(i));
    }

    public void ah(int i) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> concurrentHashMapRemove = this.f1365ms.remove(Integer.valueOf(i));
        if (concurrentHashMapRemove != null) {
            for (Map.Entry<Integer, Runnable> entry : concurrentHashMapRemove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }
}
