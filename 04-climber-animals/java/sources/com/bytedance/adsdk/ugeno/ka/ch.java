package com.bytedance.adsdk.ugeno.ka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Map<String, ab> f363ms = new HashMap();

    public static void ms(List<ab> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ab abVar : list) {
            if (abVar != null) {
                f363ms.put(abVar.ms(), abVar);
            }
        }
    }

    public static ab ms(String str) {
        return f363ms.get(str);
    }
}
