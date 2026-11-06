package com.byazt.mn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public enum s implements l {
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

    public final String cd;
    public final int um;
    public static final Map<String, s> cy = new HashMap(128);
    public static final Set<s> hd = new HashSet();

    static {
        for (s sVar : values()) {
            cy.put(sVar.n(), sVar);
            hd.add(sVar);
        }
    }

    s(String str, int i) {
        this.cd = str;
        this.um = i;
    }

    public static s n(String str) {
        return cy.get(str);
    }

    public static boolean n(l lVar) {
        return lVar instanceof s;
    }

    public String n() {
        return this.cd;
    }

    public int qg() {
        return this.um;
    }
}
