package com.smartdigimkt.t2;

import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static volatile z g;
    public final com.smartdigimkt.z2.r b;
    public final HashMap c;
    public long e;
    public final String a = "z";
    public volatile boolean d = false;
    public long f = 0;

    public z() {
        this.e = 209715200L;
        com.smartdigimkt.z2.d dVarA = com.smartdigimkt.z2.d.a(SDKContext.getInstance().d());
        if (com.smartdigimkt.z2.r.b == null) {
            synchronized (com.smartdigimkt.z2.q.class) {
                if (com.smartdigimkt.z2.r.b == null) {
                    com.smartdigimkt.z2.r.b = new com.smartdigimkt.z2.r(dVarA);
                }
            }
        }
        this.b = com.smartdigimkt.z2.r.b;
        this.c = new HashMap();
        com.smartdigimkt.i3.n.a().getClass();
        this.e = com.smartdigimkt.i3.n.a(4);
    }

    public static z a() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    public final synchronized int a(String str) {
        if (this.c.containsKey(str) && this.c.get(str) != null) {
            return ((Integer) this.c.get(str)).intValue();
        }
        v vVarA = this.b.a(str);
        if (vVarA == null || vVarA.c <= 0) {
            return 0;
        }
        File file = new File(vVarA.b);
        long j = vVarA.d;
        boolean z = j > 0 && file.length() > j;
        if (file.exists() && !z && file.length() >= vVarA.e) {
            this.c.put(str, Integer.valueOf(vVarA.c));
            this.b.c(str);
            return vVarA.c;
        }
        com.smartdigimkt.q3.f.a().a(new x(this, vVarA), 0L, 2);
        return 0;
    }
}
