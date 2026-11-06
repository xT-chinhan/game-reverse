package com.bytedance.sdk.component.hi.ab;

import com.bytedance.sdk.component.hi.d.d;
import com.bytedance.sdk.component.hi.ms.ms.ah;
import com.bytedance.sdk.component.hi.ms.xr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static volatile ms xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.hi.ms.ms.ms> f1233ms = new HashMap();

    private ms() {
    }

    public static ms ms() {
        if (xr != null) {
            return xr;
        }
        synchronized (ms.class) {
            if (xr != null) {
                return xr;
            }
            ms msVar = new ms();
            xr = msVar;
            return msVar;
        }
    }

    public void ms(String str, com.bytedance.sdk.component.hi.ms.ms.ms msVar) {
        this.f1233ms.put(str, msVar);
    }

    public void ms(String str, com.bytedance.sdk.component.hi.ms.ms msVar, com.bytedance.sdk.component.hi.d.ms msVar2) {
        com.bytedance.sdk.component.hi.ms.ms.ms msVarMs = this.f1233ms.get(str);
        if (msVarMs == null || msVar == null) {
            return;
        }
        Map<String, Object> mapMs = msVar.ms();
        d dVarKa = msVar.ka();
        if (dVarKa instanceof xr) {
            Map<String, Object> mapMs2 = com.bytedance.sdk.component.hi.ka.ms.ms().ms(String.valueOf(dVarKa.hashCode()));
            mapMs.putAll(mapMs2);
            mapMs2.clear();
            com.bytedance.sdk.component.hi.c.ms msVarMs2 = com.bytedance.sdk.component.hi.c.ms.ms();
            msVarMs = msVarMs2.ms(msVarMs);
            HashMap map = new HashMap();
            map.putAll(msVar.xr());
            map.putAll(mapMs);
            msVarMs2.ms(msVarMs, map);
        }
        if (msVarMs instanceof ah) {
            ((ah) msVarMs).ms(msVar.xr(), msVar.ms(), msVar);
        } else if (msVarMs instanceof com.bytedance.sdk.component.hi.ms.ms.xr) {
            ((com.bytedance.sdk.component.hi.ms.ms.xr) msVarMs).ms(msVar.xr(), msVar.ms(), msVar);
        }
    }
}
