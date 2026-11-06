package com.byazt.mn;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum q implements l {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    public static final Map<String, q> w;
    public final String x;

    static {
        HashMap map = new HashMap(128);
        w = map;
        for (q qVar : map.values()) {
            w.put(qVar.n(), qVar);
        }
    }

    q(String str) {
        this.x = str;
    }

    public static boolean n(l lVar) {
        return lVar instanceof q;
    }

    public String n() {
        return this.x;
    }
}
