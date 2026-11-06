package com.efs.sdk.net.a;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static a c;
    private HashMap<String, b> a;
    private HashMap<String, c> b;

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

    public final b a(String str) {
        if (this.a == null) {
            b();
        }
        b bVar = this.a.get(str);
        if (bVar == null) {
            b bVar2 = new b();
            bVar2.a = str;
            bVar2.b = System.currentTimeMillis();
            this.a.put(str, bVar2);
            return bVar2;
        }
        return bVar;
    }

    public final void b(String str) {
        if (this.a != null && this.a.containsKey(str)) {
            this.a.remove(str);
        }
    }

    public final c c(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        c cVar = new c();
        cVar.A = str;
        cVar.C = System.currentTimeMillis();
        this.b.put(str, cVar);
        return cVar;
    }

    public final void d(String str) {
        if (this.b != null && this.b.containsKey(str)) {
            this.b.remove(str);
        }
    }
}
