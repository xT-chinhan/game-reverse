package com.anythink.core.common.n.a;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j<K, V> extends LinkedHashMap<K, V> {
    private int a;

    public j() {
        this((byte) 0);
    }

    private j(byte b) {
        super(256, 1.0f, true);
        this.a = 256;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.a;
    }
}
