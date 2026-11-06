package com.byazt.yiq;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum pr implements c {
    TRUE,
    FALSE,
    NULL;

    public static final Map<String, pr> x = new HashMap(128);

    static {
        for (pr prVar : values()) {
            x.put(prVar.name().toLowerCase(), prVar);
        }
    }

    public static pr pr(String str) {
        return x.get(str.toLowerCase());
    }
}
