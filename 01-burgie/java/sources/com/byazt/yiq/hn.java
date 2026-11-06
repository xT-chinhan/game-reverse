package com.byazt.yiq;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public enum hn implements c {
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

    public final String lb;
    public final int qa;
    public static final Map<String, hn> nt = new HashMap(128);
    public static final Set<hn> yb = new HashSet();

    static {
        for (hn hnVar : values()) {
            nt.put(hnVar.pr(), hnVar);
            yb.add(hnVar);
        }
    }

    hn(String str, int i) {
        this.lb = str;
        this.qa = i;
    }

    public static hn pr(String str) {
        return nt.get(str);
    }

    public static boolean pr(c cVar) {
        return cVar instanceof hn;
    }

    public String pr() {
        return this.lb;
    }

    public int hw() {
        return this.qa;
    }
}
