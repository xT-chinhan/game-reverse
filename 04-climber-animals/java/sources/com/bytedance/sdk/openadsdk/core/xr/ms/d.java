package com.bytedance.sdk.openadsdk.core.xr.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.c;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ny;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<Class, ms> f3766ms = new HashMap();

    public ah ms(lm lmVar, Context context, com.bytedance.sdk.openadsdk.core.xr.d dVar, boolean z) {
        ah ahVar = new ah(dVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms(lmVar, context);
        this.f3766ms.put(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ms.class, msVar);
        xr xrVar = new xr(lmVar, context);
        this.f3766ms.put(xr.class, xrVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr xrVarMs = ms(lmVar, context, z);
        this.f3766ms.put(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class, xrVarMs);
        ny nyVar = new ny(lmVar, context, dVar);
        this.f3766ms.put(ny.class, nyVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah ahVar2 = new com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah(lmVar, context, dVar);
        this.f3766ms.put(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah.class, ahVar2);
        c cVar = new c(lmVar, context, dVar);
        this.f3766ms.put(c.class, cVar);
        com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar2 = new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms(lmVar, context);
        this.f3766ms.put(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class, msVar2);
        com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah ahVar3 = new com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah(lmVar, context);
        this.f3766ms.put(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class, ahVar3);
        ka kaVar = new ka(lmVar, context, dVar);
        this.f3766ms.put(ka.class, kaVar);
        ahVar.ms(ahVar3);
        ahVar.ms(msVar);
        if (!com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            ahVar.ms(cVar);
            ahVar.ms(nyVar);
            if (z) {
                ab abVar = new ab(lmVar, context);
                this.f3766ms.put(ab.class, abVar);
                ahVar.ms(abVar);
            }
        }
        ahVar.ms(xrVar);
        if (!com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            ahVar.ms(ahVar2);
            ahVar.ms(kaVar);
        }
        ahVar.ms(xrVarMs);
        ahVar.ms(msVar2);
        return ahVar;
    }

    private com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr ms(lm lmVar, Context context, boolean z) {
        com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr xrVarMs;
        com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr nyVar;
        if (com.bytedance.sdk.openadsdk.core.ny.ms.d.ms.ms()) {
            nyVar = new com.bytedance.sdk.openadsdk.core.xr.ms.ms.ny();
            nyVar.ms(lmVar);
            nyVar.ms(context);
        } else {
            if (z) {
                xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms.ms.d.ms(lmVar, context);
            } else {
                xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms.ms.d.ms(lmVar, context, 3);
            }
            nyVar = xrVarMs;
        }
        return new com.bytedance.sdk.openadsdk.core.xr.ms.ms.ah(nyVar);
    }

    public <T extends ms> T ms(Class<T> cls) {
        T t = (T) this.f3766ms.get(cls);
        return t == null ? (T) xr(cls) : t;
    }

    private <T extends ms> T xr(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(lm.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }
}
