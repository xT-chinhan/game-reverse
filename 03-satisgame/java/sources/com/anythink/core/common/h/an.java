package com.anythink.core.common.h;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class an {
    private final String a;
    private Map<String, List<a>> b;
    private Map<String, Integer> c;

    public an(String str) {
        this.a = str;
    }

    private String c() {
        return this.a;
    }

    public final Map<String, List<a>> a() {
        return this.b;
    }

    public final void a(Map<String, List<a>> map) {
        this.b = map;
    }

    public final Map<String, Integer> b() {
        return this.c;
    }

    public final void b(Map<String, Integer> map) {
        this.c = map;
    }

    public static class a {
        private final String a;
        private final int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }
    }
}
