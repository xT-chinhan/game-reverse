package com.bytedance.adsdk.xr.xr.d;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public enum ah implements ka {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final String qv;
    private final int y;
    private static final Map<String, ah> ao = new HashMap(128);
    private static final Set<ah> h = new HashSet();

    static {
        for (ah ahVar : values()) {
            ao.put(ahVar.ms(), ahVar);
            h.add(ahVar);
        }
    }

    ah(String str, int i) {
        this.qv = str;
        this.y = i;
    }

    public static ah ms(String str) {
        return ao.get(str);
    }

    public static boolean ms(ka kaVar) {
        return kaVar instanceof ah;
    }

    public String ms() {
        return this.qv;
    }

    public int xr() {
        return this.y;
    }
}
