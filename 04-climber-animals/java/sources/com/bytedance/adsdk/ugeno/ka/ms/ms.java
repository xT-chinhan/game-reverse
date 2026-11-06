package com.bytedance.adsdk.ugeno.ka.ms;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile Map<String, ah> f373ms = new HashMap();

    public ah ms(String str) {
        if (this.f373ms.containsKey(str) && this.f373ms.get(str) != null) {
            return this.f373ms.get(str);
        }
        xr xrVar = new xr();
        this.f373ms.put(str, xrVar);
        return xrVar;
    }

    public void ms(String str, ah ahVar) {
        if (!this.f373ms.containsKey(str) || this.f373ms.get(str) == null) {
            this.f373ms.put(str, ahVar);
        }
    }
}
