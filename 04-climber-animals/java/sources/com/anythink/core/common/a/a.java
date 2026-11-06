package com.anythink.core.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.af;
import com.anythink.core.common.h.bg;
import com.anythink.core.common.h.r;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a b;
    ConcurrentHashMap<String, af> a;
    private com.anythink.core.common.e.o c;

    private a() {
        if (t.b().g() != null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(t.b().g()));
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
        af afVarB = this.a.get(str);
        if (afVarB == null) {
            afVarB = this.c.b(str);
            this.a.put(str, afVarB);
        }
        return afVarB.a(str2);
    }

    public final void a(String str, ad adVar) {
        if (this.c == null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(t.b().g()));
        }
        if (!TextUtils.isEmpty(adVar.i)) {
            try {
                JSONObject jSONObject = new JSONObject(adVar.i);
                r rVarA = e.a(adVar.token, jSONObject, adVar.d, true);
                if (rVarA == null) {
                    adVar.i = "";
                } else {
                    adVar.i = jSONObject.toString();
                    rVarA.d(adVar.f);
                    if (adVar.d == 67) {
                        com.anythink.core.common.f.c.a(t.b().g()).a(rVarA.v(), rVarA.ay());
                        com.anythink.core.common.f.b.a(t.b().g()).a(rVarA.w(), rVarA.ay());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        this.c.a(str, adVar);
    }

    private static void b(ad adVar) {
        if (TextUtils.isEmpty(adVar.i)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(adVar.i);
            r rVarA = e.a(adVar.token, jSONObject, adVar.d, true);
            if (rVarA == null) {
                adVar.i = "";
                return;
            }
            adVar.i = jSONObject.toString();
            rVarA.d(adVar.f);
            if (adVar.d == 67) {
                com.anythink.core.common.f.c.a(t.b().g()).a(rVarA.v(), rVarA.ay());
                com.anythink.core.common.f.b.a(t.b().g()).a(rVarA.w(), rVarA.ay());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(final ad adVar) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c == null) {
                    a.this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(t.b().g()));
                }
                a.this.c.a(adVar);
            }
        }, 2);
    }

    public final void a(Context context, String str, String str2, String str3) {
        if (this.c == null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(context.getApplicationContext()));
        }
        this.c.a(str, str2, str3);
    }

    public final bg a(Context context, String str) {
        if (this.c == null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(context.getApplicationContext()));
        }
        return this.c.c(str);
    }

    public final void b(final Context context, final String str) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.c == null) {
                    a.this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(context.getApplicationContext()));
                }
                a.this.c.a(str);
            }
        }, 2);
        com.anythink.core.common.v.af.a(context, u.b.h, str + u.a.A);
    }

    public static void c(Context context, String str) {
        com.anythink.core.common.v.af.a(context, u.b.h, str + u.a.A, 1);
    }

    private static boolean e(Context context, String str) {
        return com.anythink.core.common.v.af.b(context, u.b.h, new StringBuilder().append(str).append(u.a.A).toString(), 0) == 1;
    }

    public final void a(Context context, String str, String str2) {
        if (this.c == null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(context.getApplicationContext()));
        }
        this.c.a(str, str2);
    }

    public final String d(Context context, String str) {
        if (this.c == null) {
            this.c = com.anythink.core.common.e.o.a(com.anythink.core.common.e.e.a(context.getApplicationContext()));
        }
        return this.c.d(str);
    }
}
