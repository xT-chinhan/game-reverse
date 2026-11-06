package com.bytedance.adsdk.xr.xr.d;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum ms implements ka {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, ms> d = new HashMap(128);

    static {
        for (ms msVar : values()) {
            d.put(msVar.name().toLowerCase(), msVar);
        }
    }

    public static ms ms(String str) {
        return d.get(str.toLowerCase());
    }
}
