package com.tapsdk.tapad.internal.download;

import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private Hashtable<Object, com.tapsdk.tapad.internal.a> a = new Hashtable<>();
    private Hashtable<Object, Boolean> b = new Hashtable<>();
    private final Object c = new Object();

    static class a {
        public static g a = new g();

        a() {
        }
    }

    public static g a() {
        return a.a;
    }

    public void a(com.tapsdk.tapad.internal.a aVar) {
        synchronized (this.c) {
            this.a.put(aVar.d(), aVar);
            this.b.put(aVar.d(), Boolean.TRUE);
        }
    }

    public void a(String str) {
        if (this.a.containsKey(str)) {
            com.tapsdk.tapad.internal.a aVar = this.a.get(str);
            if (aVar != null) {
                aVar.a();
            }
            this.b.put(str, Boolean.TRUE);
        }
    }

    public void b(com.tapsdk.tapad.internal.a aVar) {
        synchronized (this.c) {
            this.a.remove(aVar);
            this.b.put(aVar.d(), Boolean.FALSE);
        }
    }

    public boolean b(String str) {
        if (this.b.contains(str)) {
            return this.b.get(str).booleanValue();
        }
        TapADLogger.e("getTaskState: no task");
        return false;
    }

    public void c(String str) {
        com.tapsdk.tapad.internal.a aVar;
        if (!this.a.containsKey(str) || (aVar = this.a.get(str)) == null) {
            return;
        }
        aVar.j();
    }
}
