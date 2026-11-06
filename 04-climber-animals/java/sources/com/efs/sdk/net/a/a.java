package com.efs.sdk.net.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static a c;
    private HashMap<String, c> a;
    private HashMap<String, d> b;

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private a() {
        b();
    }

    private void b() {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        this.a.clear();
    }

    public final c a(String str) {
        if (this.a == null) {
            b();
        }
        c cVar = this.a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.a = str;
        cVar2.b = System.currentTimeMillis();
        this.a.put(str, cVar2);
        return cVar2;
    }

    public final void b(String str) {
        HashMap<String, c> map = this.a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.a.remove(str);
    }

    public final d c(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        d dVar = new d();
        dVar.A = str;
        dVar.D = System.currentTimeMillis();
        this.b.put(str, dVar);
        return dVar;
    }

    public final void d(String str) {
        HashMap<String, d> map = this.b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.b.remove(str);
    }
}
