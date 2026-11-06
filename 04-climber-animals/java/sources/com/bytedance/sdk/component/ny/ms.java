package com.bytedance.sdk.component.ny;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.ny.ah.ab;
import com.bytedance.sdk.component.ny.ah.c;
import com.bytedance.sdk.component.ny.d.ah;
import com.bytedance.sdk.component.ny.xr.ka;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.xr.ms.ny;
import com.bytedance.sdk.component.xr.ms.sl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private int ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private sl f1288ms;
    private c xr;

    private ms(C0249ms c0249ms) {
        sl.ms msVarXr = new sl.ms().ms(c0249ms.f1289ms, TimeUnit.MILLISECONDS).ah(c0249ms.ah, TimeUnit.MILLISECONDS).xr(c0249ms.xr, TimeUnit.MILLISECONDS);
        if (c0249ms.d) {
            c cVar = new c();
            this.xr = cVar;
            msVarXr.ms(cVar);
        }
        if (c0249ms.ka != null && c0249ms.ka.size() > 0) {
            Iterator<ny> it = c0249ms.ka.iterator();
            while (it.hasNext()) {
                msVarXr.ms(it.next());
            }
        }
        if (c0249ms.ab != null) {
            msVarXr.ms(c0249ms.ab);
        }
        msVarXr.ms(c0249ms.c);
        if (c0249ms.x == null) {
            msVarXr.ms(new com.bytedance.sdk.component.xr.ms.ms.ms.xr());
        } else {
            msVarXr.ms(c0249ms.x);
        }
        this.f1288ms = msVarXr.ms();
    }

    public void ms(Context context, boolean z, com.bytedance.sdk.component.ny.ah.xr xrVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (xrVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iMs = xrVar.ms();
        this.ah = iMs;
        c cVar = this.xr;
        if (cVar != null) {
            cVar.ms(iMs);
        }
        ab.ms().ms(this.ah).ms(z);
        ab.ms().ms(this.ah).ms(xrVar);
        ab.ms().ms(this.ah).ms(context, h.ms(context));
    }

    public void ms(Context context, boolean z) {
        com.bytedance.sdk.component.ny.ah.ms.xr(true);
        if (ms(context) || (!h.ms(context) && z)) {
            ab.ms().ms(this.ah, context).d();
            ab.ms().ms(this.ah, context).ms();
        }
        if (h.ms(context)) {
            ab.ms().ms(this.ah, context).d();
            ab.ms().ms(this.ah, context).ms();
        }
    }

    public static void ms() {
        ah.ms(ah.ms.DEBUG);
    }

    public ka xr() {
        return new ka(this.f1288ms);
    }

    public com.bytedance.sdk.component.ny.xr.ah ah() {
        return new com.bytedance.sdk.component.ny.xr.ah(this.f1288ms);
    }

    public com.bytedance.sdk.component.ny.xr.xr d() {
        return new com.bytedance.sdk.component.ny.xr.xr(this.f1288ms);
    }

    private static boolean ms(Context context) {
        String strXr = h.xr(context);
        if (strXr != null) {
            return strXr.endsWith(":push") || strXr.endsWith(":pushservice");
        }
        return false;
    }

    public com.bytedance.sdk.component.ny.xr.ms ka() {
        return new com.bytedance.sdk.component.ny.xr.ms(this.f1288ms);
    }

    public sl c() {
        return this.f1288ms;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ny.ms$ms, reason: collision with other inner class name */
    public static final class C0249ms {
        private Bundle ab;
        private Set<String> c;
        private com.bytedance.sdk.component.xr.ms.ms.ms.ms x;
        boolean d = true;
        final List<ny> ka = new ArrayList();

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1289ms = 10000;
        int xr = 10000;
        int ah = 10000;

        public C0249ms ms(long j, TimeUnit timeUnit) {
            this.f1289ms = ms("timeout", j, timeUnit);
            return this;
        }

        public C0249ms xr(long j, TimeUnit timeUnit) {
            this.xr = ms("timeout", j, timeUnit);
            return this;
        }

        public C0249ms ah(long j, TimeUnit timeUnit) {
            this.ah = ms("timeout", j, timeUnit);
            return this;
        }

        public C0249ms ms(boolean z) {
            this.d = z;
            return this;
        }

        public C0249ms ms(ny nyVar) {
            this.ka.add(nyVar);
            return this;
        }

        public C0249ms ms(Set<String> set) {
            this.c = set;
            return this;
        }

        private static int ms(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public ms ms() {
            return new ms(this);
        }
    }
}
