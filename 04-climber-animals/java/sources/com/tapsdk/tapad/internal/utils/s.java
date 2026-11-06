package com.tapsdk.tapad.internal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class s {
    public static List<String> a(List<String> list) {
        return a(list, 0);
    }

    public static List<String> a(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String strB = list.get(i2);
            if (com.tapsdk.tapad.internal.network.c.a.c(strB)) {
                HashMap map = new HashMap();
                map.put("tap_trigger_src", Integer.valueOf(i));
                strB = com.tapsdk.tapad.internal.network.c.a.b(strB, map);
            }
            arrayList.add(strB);
        }
        return arrayList;
    }
}
