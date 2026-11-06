package com.bytedance.sdk.component.x.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.ab;
import com.bytedance.sdk.component.x.ms.c;
import com.bytedance.sdk.component.x.ms.ka;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ConcurrentHashMap<String, xr> f1558ms = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.x.ms.ah> xr = new ArrayList();
    private static ConcurrentHashMap<String, ka> ah = new ConcurrentHashMap<>();

    public static ab ms(com.bytedance.sdk.component.x.ms.ms msVar) {
        if (msVar == null || TextUtils.isEmpty(msVar.ka()) || msVar.getContext() == null) {
            sl.d("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, xr> concurrentHashMap = f1558ms;
        xr xrVar = concurrentHashMap.get(msVar.ka());
        if (xrVar == null) {
            xrVar = new xr(msVar);
        } else {
            xrVar.xr(msVar);
        }
        concurrentHashMap.put(msVar.ka(), xrVar);
        return xrVar;
    }

    public static void ms(c cVar, String str) {
        ah(str).ms(cVar);
    }

    public static void ms(boolean z, String str) {
        ah(str).ms(z);
    }

    public static List<com.bytedance.sdk.component.x.ms.ah> ms() {
        return xr;
    }

    public static void ms(com.bytedance.sdk.component.x.ms.ah ahVar) {
        if (ahVar != null) {
            xr.add(ahVar);
        }
    }

    public static boolean ms(String str) {
        xr xrVar = f1558ms.get(str);
        return xrVar == null || xrVar.ah() == null || xrVar.d() == null || xrVar.ka() == null;
    }

    public static void xr(String str) {
        ms(false, str);
        ah(str).ms();
    }

    public static ab ah(String str) {
        ConcurrentHashMap<String, xr> concurrentHashMap = f1558ms;
        xr xrVar = concurrentHashMap.get(str);
        if (xrVar != null) {
            return xrVar;
        }
        xr xrVar2 = new xr();
        concurrentHashMap.put(str, xrVar2);
        return xrVar2;
    }

    public static void ms(String str, String str2) {
        ah(str).ms(str2);
    }

    public static void ms(String str, String str2, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        ah(str).ms(str2, list, z, map, jSONObject);
    }

    public static void ms(com.bytedance.sdk.component.x.ms.xr xrVar, String str) {
        ah(str).ms(xrVar);
    }

    public static void d(String str) {
        ah(str).xr();
    }

    public static ka ka(String str) {
        ka kaVarAh = ah.get(str);
        if (kaVarAh == null && (kaVarAh = ah(str).ah()) != null) {
            ah.put(str, kaVarAh);
        }
        return kaVarAh;
    }
}
