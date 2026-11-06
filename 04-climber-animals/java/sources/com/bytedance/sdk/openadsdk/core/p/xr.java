package com.bytedance.sdk.openadsdk.core.p;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f3252ms = new ConcurrentHashMap<>();

    public void ms(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f3252ms.put(str, str2);
    }

    public String ms(String str) {
        return xr(str, "");
    }

    private String xr(String str, String str2) {
        return (str == null || !this.f3252ms.containsKey(str)) ? str2 : (String) this.f3252ms.get(str);
    }

    public void ms(String str, int i) {
        if (str != null) {
            this.f3252ms.put(str, Integer.valueOf(i));
        }
    }

    public int xr(String str) {
        return xr(str, 0);
    }

    private int xr(String str, int i) {
        return (str == null || !this.f3252ms.containsKey(str)) ? i : ((Integer) this.f3252ms.get(str)).intValue();
    }
}
