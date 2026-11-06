package com.anythink.core.common.m.b;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private final String a;
    private final Map<String, String> b;

    public h(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (map == null) {
            throw new NullPointerException("authParams == null");
        }
        this.a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.b = Collections.unmodifiableMap(linkedHashMap);
    }

    private h(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("scheme == null");
        }
        if (str2 == null) {
            throw new NullPointerException("realm == null");
        }
        this.a = str;
        this.b = Collections.singletonMap("realm", str2);
    }

    private h a(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset == null");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.b);
        linkedHashMap.put("charset", charset.name());
        return new h(this.a, linkedHashMap);
    }

    private String a() {
        return this.a;
    }

    private Map<String, String> b() {
        return this.b;
    }

    private String c() {
        return this.b.get("realm");
    }

    private Charset d() {
        String str = this.b.get("charset");
        if (str != null) {
            try {
                return Charset.forName(str);
            } catch (Exception unused) {
            }
        }
        return StandardCharsets.ISO_8859_1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.a.equals(this.a) && hVar.b.equals(this.b);
    }

    public final int hashCode() {
        return ((this.a.hashCode() + 899) * 31) + this.b.hashCode();
    }

    public final String toString() {
        return this.a + " authParams=" + this.b;
    }
}
