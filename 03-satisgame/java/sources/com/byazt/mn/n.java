package com.byazt.mn;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum n implements l {
    TRUE,
    FALSE,
    NULL;

    public static final Map<String, n> q = new HashMap(128);

    static {
        for (n nVar : values()) {
            q.put(nVar.name().toLowerCase(), nVar);
        }
    }

    public static n n(String str) {
        return q.get(str.toLowerCase());
    }
}
