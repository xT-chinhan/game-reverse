package com.anythink.core.common.a;

import android.content.Context;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.f.i;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ag;
import com.anythink.core.common.h.bi;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a b;
    ConcurrentHashMap<String, ag> a;
    private i c;

    private a() {
        if (s.b().g() != null) {
            this.c = i.a(com.anythink.core.common.f.d.a(s.b().g()));
        }
        this.a = new ConcurrentHashMap<>(3);
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final ad a(String str, String str2) {
        ag agVarB = this.a.get(str);
        if (agVarB == null) {
            agVarB = this.c.b(str);
            this.a.put(str, agVarB);
        }
        return agVarB.a(str2);
    }

    public final void a(final String str, final ad adVar) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.e, new Runnable() { // from class: com.anythink.core.common.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c == null) {
                    a.this.c = i.a(com.anythink.core.common.f.d.a(s.b().g()));
                }
                a.this.c.a(str, adVar);
            }
        }));
    }

    public final void a(final ad adVar) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.c, new Runnable() { // from class: com.anythink.core.common.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c == null) {
                    a.this.c = i.a(com.anythink.core.common.f.d.a(s.b().g()));
                }
                a.this.c.a(adVar);
            }
        }));
    }

    private void a(Context context, String str, String str2) {
        if (this.c == null) {
            this.c = i.a(com.anythink.core.common.f.d.a(context.getApplicationContext()));
        }
        this.c.a(str, str2);
    }

    private bi b(Context context, String str) {
        if (this.c == null) {
            this.c = i.a(com.anythink.core.common.f.d.a(context.getApplicationContext()));
        }
        return this.c.c(str);
    }

    public final void a(final Context context, final String str) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.d, new Runnable() { // from class: com.anythink.core.common.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c == null) {
                    a.this.c = i.a(com.anythink.core.common.f.d.a(context.getApplicationContext()));
                }
                a.this.c.a(str);
            }
        }));
        com.anythink.core.common.u.ad.a(context, t.b.h, str + t.a.D);
    }

    private static void c(Context context, String str) {
        com.anythink.core.common.u.ad.a(context, t.b.h, str + t.a.D, 1);
    }

    private static boolean d(Context context, String str) {
        return com.anythink.core.common.u.ad.b(context, t.b.h, new StringBuilder().append(str).append(t.a.D).toString(), 0) == 1;
    }

    private void b(Context context, String str, String str2) {
        if (this.c == null) {
            this.c = i.a(com.anythink.core.common.f.d.a(context.getApplicationContext()));
        }
        this.c.b(str, str2);
    }

    private String e(Context context, String str) {
        if (this.c == null) {
            this.c = i.a(com.anythink.core.common.f.d.a(context.getApplicationContext()));
        }
        return this.c.d(str);
    }
}
