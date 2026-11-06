package com.anythink.basead;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.webkit.WebView;
import com.anythink.basead.j.f;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.ac;
import com.anythink.core.common.v.g;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c e;
    long a;
    private Context f;
    private volatile boolean h;
    private com.anythink.basead.b.a.b i;
    private com.anythink.basead.b.a.c j;
    private WeakReference<Activity> k;
    private volatile Boolean l;
    private volatile Boolean m;
    private volatile boolean n;
    private final String d = getClass().getSimpleName();
    public boolean b = false;
    public boolean c = false;
    private boolean g = false;

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    private c() {
    }

    public final synchronized void a(Context context) {
        if (this.g) {
            return;
        }
        this.g = true;
        this.f = context.getApplicationContext();
        if (context instanceof Activity) {
            a((Activity) context);
        } else {
            a(t.b().N());
        }
        this.h = t.b().W();
        this.n = false;
        ((Application) this.f).registerActivityLifecycleCallbacks(new com.anythink.basead.b.a());
        i();
    }

    public final void b() {
        if (f.a().b()) {
            ac.a().b(this.f);
            ac.a().d(this.f);
            if (ac.a().b(this.f) || ac.a().d(this.f)) {
                t.b();
                t.a(new Runnable() { // from class: com.anythink.basead.c.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ac.a().c(c.this.f);
                        ac.a().e(c.this.f);
                    }
                });
            }
        }
        g.a().b(this.f);
        if (g.a().b(this.f)) {
            t.b();
            t.a(new Runnable() { // from class: com.anythink.basead.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    g.a().c(c.this.f);
                }
            });
        }
    }

    public final void a(boolean z) {
        if (!this.n) {
            this.n = true;
        }
        this.h = z;
        if (z) {
            com.anythink.basead.b.a.b bVar = this.i;
            if (bVar != null) {
                bVar.a(this.a);
                this.i = null;
                return;
            }
            return;
        }
        this.a = System.currentTimeMillis();
    }

    public final void a(com.anythink.basead.b.a.b bVar) {
        this.i = bVar;
    }

    public final void c() {
        boolean z = !this.b && this.c;
        com.anythink.basead.b.a.c cVar = this.j;
        if (cVar != null) {
            cVar.a(z);
            this.j = null;
        }
        this.c = false;
        this.b = false;
    }

    public final void a(com.anythink.basead.b.a.c cVar) {
        this.j = cVar;
        this.b = false;
    }

    public final Activity d() {
        WeakReference<Activity> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void a(Activity activity) {
        if (activity != null) {
            this.k = new WeakReference<>(activity);
        }
    }

    public final boolean e() {
        return this.h;
    }

    public final Context f() {
        return this.f;
    }

    private void i() {
        if (this.l != null) {
            return;
        }
        if (this.m == null) {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
            if (!bVarB.R()) {
                this.m = Boolean.valueOf(bVarB.aR() == 1);
            }
        }
        if (this.m == null || !this.m.booleanValue()) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.c.3
            @Override // java.lang.Runnable
            public final void run() {
                WebView webView;
                String unused = c.this.d;
                try {
                    webView = new WebView(c.this.f);
                } catch (Throwable unused2) {
                    webView = null;
                }
                if (webView != null) {
                    try {
                        webView.destroy();
                    } catch (Throwable unused3) {
                    }
                    c.this.l = Boolean.TRUE;
                } else {
                    c.this.l = Boolean.FALSE;
                }
                String unused4 = c.this.d;
                new StringBuilder("webViewAvailable result:").append(c.this.l);
            }
        });
    }

    public final boolean g() {
        if (this.m != null && !this.m.booleanValue()) {
            return true;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (bVarB.R()) {
            return true;
        }
        this.m = Boolean.valueOf(bVarB.aR() == 1);
        if (!this.m.booleanValue()) {
            return true;
        }
        i();
        if (this.l != null) {
            return this.l.booleanValue();
        }
        return true;
    }

    public final boolean h() {
        return this.n;
    }
}
