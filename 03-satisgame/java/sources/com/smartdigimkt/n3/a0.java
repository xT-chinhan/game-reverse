package com.smartdigimkt.n3;

import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static volatile a0 c;
    public final String a = "a0";
    public final AtomicInteger b = new AtomicInteger(0);

    public static a0 a() {
        if (c == null) {
            synchronized (a0.class) {
                if (c == null) {
                    c = new a0();
                }
            }
        }
        return c;
    }

    public final synchronized void b() {
        ArrayList<com.smartdigimkt.f3.d> arrayListD;
        int iOptInt;
        if (this.b.get() <= 0 && (arrayListD = com.smartdigimkt.z2.j.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).d()) != null && arrayListD.size() > 0) {
            this.b.set(arrayListD.size());
            this.b.get();
            for (com.smartdigimkt.f3.d dVar : arrayListD) {
                if (System.currentTimeMillis() - dVar.f >= com.anythink.core.e.i.f) {
                    this.b.decrementAndGet();
                    com.smartdigimkt.z2.j.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).a(dVar);
                } else {
                    try {
                        iOptInt = new JSONObject(dVar.g).optInt("business_type");
                    } catch (Throwable unused) {
                        iOptInt = 1000;
                    }
                    if (dVar.b == 3) {
                        new com.smartdigimkt.h4.b(dVar.e, iOptInt).a(new y(this, dVar));
                    } else {
                        new com.smartdigimkt.f4.p(dVar, iOptInt != 1001).a(0, (com.smartdigimkt.a4.b) new z(this, dVar));
                    }
                }
            }
        }
    }

    public final void a(int i, String str, String str2, String str3, String str4) {
        com.smartdigimkt.q3.f.a().a(new x(this, i, str, str2, str3, str4), 0L, 16);
    }
}
