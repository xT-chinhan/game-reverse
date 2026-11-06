package com.bytedance.sdk.openadsdk.core.w;

import com.bytedance.sdk.openadsdk.core.jw.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3687ms;
    private Map<String, xr> xr = new HashMap();

    private ms() {
        ms(com.bytedance.sdk.openadsdk.core.w.ah.ms.ah());
        ms(com.bytedance.sdk.openadsdk.core.w.ms.ms.xr());
        ms(com.bytedance.sdk.openadsdk.core.w.d.ms.ah());
        ms(com.bytedance.sdk.openadsdk.core.w.ka.ms.xr());
    }

    public static ms ms() {
        if (f3687ms == null) {
            synchronized (ms.class) {
                if (f3687ms == null) {
                    f3687ms = new ms();
                }
            }
        }
        return f3687ms;
    }

    private void ms(xr xrVar) {
        this.xr.put(xrVar.ms(), xrVar);
    }

    public String ms(String str, String str2) {
        if (this.xr.containsKey(str)) {
            return this.xr.get(str).ms(str2);
        }
        return g.ms(str).xr(str2, "");
    }

    public void ms(String str, String str2, String str3) {
        if (this.xr.containsKey(str)) {
            this.xr.get(str).ms(str2, str3);
        } else {
            g.ms(str).ms(str2, str3);
        }
    }
}
