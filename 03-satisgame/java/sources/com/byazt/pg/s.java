package com.byazt.pg;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 694, 8})
public final class s {
    public final Map<String, Object> l;
    public final String n;
    public final Map<String, Object> q;
    public final String qg;
    public final double s;

    public s(String str, String str2, double d, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> mapUnmodifiableMap;
        Map<String, Object> mapUnmodifiableMap2;
        this.n = str;
        this.qg = str2;
        this.s = d;
        if (map == null) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        this.q = mapUnmodifiableMap;
        if (map2 == null) {
            mapUnmodifiableMap2 = Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(new LinkedHashMap(map2));
        }
        this.l = mapUnmodifiableMap2;
    }

    public String getType() {
        return this.n;
    }

    public Map<String, Object> getContext() {
        return this.l;
    }

    public String toString() {
        return "TriggerEvent{type='" + this.n + "', name='" + this.qg + "', timestamp=" + this.s + ", payload=" + this.q + ", context=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }
}
