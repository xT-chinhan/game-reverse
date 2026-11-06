package com.byazt.ki;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1163, 20})
public final class hn {
    public final Map<String, Object> c;
    public final double hn;
    public final String hw;
    public final String pr;
    public final Map<String, Object> x;

    public hn(String str, String str2, double d, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> mapUnmodifiableMap;
        Map<String, Object> mapUnmodifiableMap2;
        this.pr = str;
        this.hw = str2;
        this.hn = d;
        if (map == null) {
            mapUnmodifiableMap = Collections.emptyMap();
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        this.x = mapUnmodifiableMap;
        if (map2 == null) {
            mapUnmodifiableMap2 = Collections.emptyMap();
        } else {
            mapUnmodifiableMap2 = Collections.unmodifiableMap(new LinkedHashMap(map2));
        }
        this.c = mapUnmodifiableMap2;
    }

    public String getType() {
        return this.pr;
    }

    public Map<String, Object> getContext() {
        return this.c;
    }

    public String toString() {
        return "TriggerEvent{type='" + this.pr + "', name='" + this.hw + "', timestamp=" + this.hn + ", payload=" + this.x + ", context=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
