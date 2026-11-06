package com.bytedance.sdk.component.x.xr.ms;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    public abstract boolean ms(com.bytedance.sdk.component.x.ms.xr xrVar);

    public abstract boolean ms(String str);

    public abstract List<com.bytedance.sdk.component.x.ms.xr> xr(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list, String str);

    public abstract boolean xr(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar);

    public List<com.bytedance.sdk.component.x.ms.xr> ms(int i, com.bytedance.sdk.component.x.ms.xr xrVar, boolean z, List<String> list, String str) {
        if (com.bytedance.sdk.component.x.xr.ah.ms.ms(i)) {
            return xr(i, xrVar, z, list, str);
        }
        if (ms(xrVar)) {
            return xr(i, xrVar, z, list, str);
        }
        return null;
    }

    public boolean ms(int i, String str, com.bytedance.sdk.component.x.ms.xr xrVar) {
        if (com.bytedance.sdk.component.x.xr.ah.ms.ms(i)) {
            return ms(str);
        }
        if (ms(xrVar)) {
            return xr(i, str, xrVar);
        }
        return false;
    }
}
