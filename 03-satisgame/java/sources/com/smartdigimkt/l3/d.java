package com.smartdigimkt.l3;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static volatile d b;
    public final ConcurrentHashMap a = new ConcurrentHashMap();

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public final void a(String str) {
        b bVar;
        if (TextUtils.isEmpty(str) || (bVar = (b) this.a.get(str)) == null) {
            return;
        }
        synchronized (bVar) {
            bVar.u = false;
            bVar.s = false;
            bVar.w = false;
            if (bVar.n == 1) {
                bVar.v = true;
            }
        }
    }
}
