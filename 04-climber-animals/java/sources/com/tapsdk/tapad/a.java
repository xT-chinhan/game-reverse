package com.tapsdk.tapad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    final Map<String, com.tapsdk.tapad.internal.network.a> a;

    private static class b {
        private static final a a = new a();

        private b() {
        }
    }

    private a() {
        this.a = new HashMap();
    }

    public static a a() {
        return b.a;
    }

    public com.tapsdk.tapad.internal.network.a a(String str) {
        return this.a.get(str);
    }

    public void a(String str, com.tapsdk.tapad.internal.network.a aVar) {
        this.a.put(str, aVar);
    }
}
