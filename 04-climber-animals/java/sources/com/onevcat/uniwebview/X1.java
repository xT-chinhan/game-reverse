package com.onevcat.uniwebview;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class X1 {
    public static Y1 a(String str, int i, String str2) {
        HashMap map;
        if (str != null) {
            map = new HashMap();
            map.put("failingURL", str);
        } else {
            map = null;
        }
        String strValueOf = String.valueOf(i);
        if (str2 == null) {
            str2 = "";
        }
        return new Y1("", strValueOf, str2, map);
    }
}
