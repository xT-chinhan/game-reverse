package com.bytedance.adsdk.ugeno.ka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, xr> f364ms = new HashMap();

    public static void ms(List<xr> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (xr xrVar : list) {
            if (xrVar != null) {
                f364ms.put(xrVar.ms(), xrVar);
            }
        }
    }

    public static xr ms(String str) {
        return f364ms.get(str);
    }
}
