package com.bytedance.sdk.openadsdk.core.xr.ms.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<Integer, xr> f3769ms = new HashMap();
    private static final Map<Integer, Class> xr;

    static {
        HashMap map = new HashMap();
        xr = map;
        map.put(-1, xr.class);
        map.put(4, ab.class);
        map.put(3, x.class);
        map.put(2, ms.class);
    }

    public static xr ms(lm lmVar, Context context) {
        return ms(lmVar, context, 0);
    }

    public static xr ms(lm lmVar, Context context, int i) {
        if (lmVar == null) {
            return xr(null, context);
        }
        Map<Integer, Class> map = xr;
        Class cls = map.get(Integer.valueOf(i));
        if (cls == null) {
            cls = map.get(Integer.valueOf(lmVar.jr()));
        }
        try {
            xr xrVar = (xr) cls.newInstance();
            xrVar.ms(lmVar);
            xrVar.ms(context);
            return xrVar;
        } catch (Throwable unused) {
            return xr(lmVar, context);
        }
    }

    private static xr xr(lm lmVar, Context context) {
        Map<Integer, xr> map = f3769ms;
        map.put(-1, new xr());
        map.put(4, new ab());
        map.put(3, new x());
        map.put(2, new ms());
        if (lmVar == null) {
            return new xr();
        }
        xr xrVar = map.get(Integer.valueOf(lmVar.jr()));
        if (xrVar == null) {
            return new xr();
        }
        xrVar.ms(lmVar);
        xrVar.ms(context);
        return xrVar;
    }
}
