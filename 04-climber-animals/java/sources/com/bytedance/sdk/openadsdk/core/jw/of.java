package com.bytedance.sdk.openadsdk.core.jw;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class of<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public of<String, Object> ms(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public of<String, Object> ms(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
