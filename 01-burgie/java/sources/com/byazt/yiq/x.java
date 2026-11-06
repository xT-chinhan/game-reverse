package com.byazt.yiq;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum x implements c {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    public static final Map<String, x> uc;
    public final String fw;

    static {
        HashMap map = new HashMap(128);
        uc = map;
        for (x xVar : map.values()) {
            uc.put(xVar.pr(), xVar);
        }
    }

    x(String str) {
        this.fw = str;
    }

    public static boolean pr(c cVar) {
        return cVar instanceof x;
    }

    public String pr() {
        return this.fw;
    }
}
