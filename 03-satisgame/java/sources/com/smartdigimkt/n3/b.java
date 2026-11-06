package com.smartdigimkt.n3;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static volatile b c;
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public final com.smartdigimkt.b3.k a(String str) {
        com.smartdigimkt.b3.k kVar = (com.smartdigimkt.b3.k) this.b.get(str);
        if (kVar == null) {
            synchronized (this.b) {
                if (kVar == null) {
                    kVar = new com.smartdigimkt.b3.k();
                    this.b.put(str, kVar);
                }
            }
        }
        return kVar;
    }

    public final void a(long j, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j <= 0) {
            return;
        }
        com.smartdigimkt.b3.k kVar = TextUtils.isEmpty(str) ? null : (com.smartdigimkt.b3.k) this.b.get(str);
        if (kVar == null) {
            return;
        }
        com.smartdigimkt.b3.j jVar = new com.smartdigimkt.b3.j();
        jVar.a = str2;
        jVar.b = j;
        kVar.l.add(jVar);
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.smartdigimkt.b3.k kVar = TextUtils.isEmpty(str) ? null : (com.smartdigimkt.b3.k) this.b.get(str);
        if (kVar == null) {
            return;
        }
        com.smartdigimkt.b3.j jVar = new com.smartdigimkt.b3.j();
        jVar.a = str2;
        jVar.b = 0L;
        jVar.c = 0L;
        jVar.d = 0L;
        kVar.l.add(jVar);
    }
}
