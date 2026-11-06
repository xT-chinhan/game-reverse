package com.anythink.core.common.h;

import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class bo {
    public int a;
    public String b;
    public int c;
    public int d;
    public long e;
    public String f;
    public String g;
    public ConcurrentHashMap<String, a> h;

    public final String toString() {
        return "PlacementImpressionInfo{format=" + this.a + ", placementId='" + this.b + "', dayShowCount=" + this.c + ", hourShowCount=" + this.d + ", showTime=" + this.e + ", hourTimeFormat='" + this.f + "', dateTimeFormat='" + this.g + "'}";
    }

    public static class a {
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
        public long f;

        public final String toString() {
            return "AdSourceImpressionInfo{unitId='" + this.a + "', hourTimeFormat='" + this.b + "', dateTimeFormat='" + this.c + "', dayShowCount=" + this.d + ", hourShowCount=" + this.e + ", showTime=" + this.f + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public final a a(String str) {
        ConcurrentHashMap<String, a> concurrentHashMap = this.h;
        if (concurrentHashMap != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    private synchronized void a(String str, a aVar) {
        if (this.h == null) {
            this.h = new ConcurrentHashMap<>(3);
        }
        this.h.put(str, aVar);
    }
}
