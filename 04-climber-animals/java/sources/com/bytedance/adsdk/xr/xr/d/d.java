package com.bytedance.adsdk.xr.xr.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum d implements ka {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, d> c;
    private final String ab;

    static {
        HashMap map = new HashMap(128);
        c = map;
        for (d dVar : map.values()) {
            c.put(dVar.ms(), dVar);
        }
    }

    d(String str) {
        this.ab = str;
    }

    public static boolean ms(ka kaVar) {
        return kaVar instanceof d;
    }

    public String ms() {
        return this.ab;
    }
}
