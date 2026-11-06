package com.smartdigimkt.c0;

import android.text.TextUtils;
import com.smartdigimkt.f4.o;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z2.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static volatile g d;
    public Map a;
    public List b;
    public final List c = Collections.synchronizedList(new ArrayList(8));

    public static g a() {
        if (d == null) {
            synchronized (g.class) {
                if (d == null) {
                    d = new g();
                }
            }
        }
        return d;
    }

    public final synchronized void b() {
        try {
            if (this.a == null && this.b == null) {
                com.smartdigimkt.z2.l lVarC = m.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).c();
                this.a = lVarC.b;
                this.b = lVarC.a;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.a == null) {
            this.a = new ConcurrentHashMap();
        }
        if (this.b == null) {
            this.b = Collections.synchronizedList(new ArrayList());
        }
    }

    public final synchronized void a(com.smartdigimkt.h0.e eVar, boolean z) {
        if (System.currentTimeMillis() > eVar.f) {
            this.c.remove(eVar.a);
            if (z) {
                a(eVar);
            }
            return;
        }
        if (this.c.contains(eVar.a)) {
            return;
        }
        this.c.add(eVar.a);
        if (z) {
            int i = eVar.g + 1;
            eVar.g = i;
            if (i >= 5) {
                a(eVar);
            } else {
                b(eVar);
            }
        } else {
            int i2 = eVar.g + 1;
            eVar.g = i2;
            if (i2 >= 5) {
                this.c.remove(eVar.a);
                return;
            }
        }
        new o(eVar).a(0, (com.smartdigimkt.a4.b) new f(this, eVar, z));
    }

    public final synchronized void b(com.smartdigimkt.h0.e eVar) {
        if (TextUtils.isEmpty(eVar.a) && this.a != null && this.b != null) {
            eVar.e = System.currentTimeMillis();
            String strB = com.smartdigimkt.r4.i.b(eVar.d + eVar.e);
            eVar.a = strB;
            this.a.put(strB, eVar);
            this.b.add(eVar);
        }
        m.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).b(eVar);
        List list = this.b;
        if (list != null && list.size() > 500) {
            com.smartdigimkt.h0.e eVar2 = (com.smartdigimkt.h0.e) this.b.get(0);
            this.c.remove(eVar.a);
            a(eVar2);
        }
    }

    public final synchronized void a(com.smartdigimkt.h0.e eVar) {
        eVar.getClass();
        Map map = this.a;
        if (map != null) {
            map.remove(eVar.a);
        }
        List list = this.b;
        if (list != null) {
            list.remove(eVar);
        }
        m.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d())).a(eVar);
    }
}
