package com.tapsdk.tapad.internal.i;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public static final String c = "SimpleCache";
    private static volatile Context d;
    private final Map<String, String> a = new ConcurrentHashMap();
    private com.tapsdk.tapad.internal.u.a b;

    public b(Context context) {
        if (context == null) {
            return;
        }
        d = context.getApplicationContext();
        if (!com.tapsdk.tapad.internal.u.a.b()) {
            com.tapsdk.tapad.internal.u.a.a(d);
        }
        this.b = com.tapsdk.tapad.internal.u.a.b(c);
    }

    @Override // com.tapsdk.tapad.internal.i.a
    public synchronized void a(String str) {
        this.a.remove(str);
        com.tapsdk.tapad.internal.u.a aVar = this.b;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    @Override // com.tapsdk.tapad.internal.i.a
    public synchronized void a(String str, String str2) {
        if (this.b == null) {
            return;
        }
        this.a.put(str, str2);
        this.b.b(str, str2);
    }

    @Override // com.tapsdk.tapad.internal.i.a
    public String b(String str) {
        if (this.b == null) {
            return "";
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        String strA = this.b.a(str, "");
        this.a.put(str, strA);
        return strA;
    }

    @Override // com.tapsdk.tapad.internal.i.a
    public void clear() {
        this.a.clear();
        com.tapsdk.tapad.internal.u.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
