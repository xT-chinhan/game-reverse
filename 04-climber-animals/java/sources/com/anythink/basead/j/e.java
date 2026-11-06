package com.anythink.basead.j;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.ac;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    w a;
    x b;
    b c;
    a d;
    d e;
    float f;
    float g;
    private boolean m;
    private WeakReference<View> n;
    private List<WeakReference<View>> o;
    private final String j = "e";
    private boolean k = false;
    private boolean l = false;
    boolean h = false;
    boolean i = false;

    static /* synthetic */ boolean e(e eVar) {
        eVar.l = true;
        return true;
    }

    public e(w wVar, x xVar) {
        this.a = wVar;
        this.b = xVar;
        ac.a();
        boolean zB = ac.b();
        this.m = zB;
        if (zB) {
            return;
        }
        t.b().F();
    }

    private static boolean c() {
        return f.a().b();
    }

    public final void a(final int i, final View view) {
        if (this.k || !this.m || !f.a().b() || this.h || this.i || TextUtils.isEmpty(this.a.au())) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.j.e.1
            @Override // java.lang.Runnable
            public final void run() {
                View view2;
                if (e.this.h || e.this.i) {
                    return;
                }
                Context contextG = t.b().g();
                if (contextG == null) {
                    contextG = com.anythink.basead.c.a().f();
                }
                if (contextG == null && (view2 = view) != null && (contextG = view2.getContext()) != null) {
                    contextG = contextG.getApplicationContext();
                }
                String unused = e.this.j;
                int i2 = i;
                boolean z = true;
                try {
                    if (i2 == 112) {
                        if (e.this.c != null) {
                            e.this.i = true;
                            e.this.c = null;
                            return;
                        }
                        return;
                    }
                    if (i2 == 114) {
                        if (e.this.l) {
                            return;
                        }
                        e.e(e.this);
                        if (e.this.a()) {
                            return;
                        }
                        if (TextUtils.isEmpty(e.this.a.E())) {
                            z = false;
                        }
                        if (e.this.c != null && e.this.d == null) {
                            e eVar = e.this;
                            eVar.d = eVar.c.f();
                        }
                        if (e.this.d == null) {
                            String str = e.this.b != null ? e.this.b.d : "";
                            iAo = e.this.a != null ? e.this.a.ao() : 0;
                            String unused2 = e.this.j;
                            com.anythink.core.common.u.e.b("Omsdk Exception", "create omsdkAdEvent fail:is empty,requestId:" + str + ",offerResourceType:" + iAo, t.b().r());
                        }
                        if (z && e.this.c != null && e.this.e == null) {
                            e eVar2 = e.this;
                            eVar2.e = eVar2.c.g();
                            return;
                        }
                        return;
                    }
                    if (i2 != 201) {
                        return;
                    }
                    if (view == null) {
                        e.a(e.this, "2", "omsdkMeasureView is empty");
                        e.this.h = true;
                        return;
                    }
                    if (e.this.a()) {
                        if ((view instanceof WebView) && contextG != null) {
                            if (!TextUtils.isEmpty(e.this.a.o())) {
                                e.this.c = f.a().d();
                            }
                        } else {
                            e.a(e.this, "2", "omsdkMeasureView is not webview");
                        }
                    } else {
                        TextUtils.isEmpty(e.this.a.E());
                        e.this.c = f.a().c();
                    }
                    if (e.this.c != null) {
                        if (e.this.n != null) {
                            e.this.n.get();
                        }
                        if (e.this.o == null || e.this.o.isEmpty()) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int iAo = 0; iAo < e.this.o.size(); iAo++) {
                            View view3 = (View) ((WeakReference) e.this.o.get(iAo)).get();
                            if (view3 != null) {
                                arrayList.add(view3);
                            }
                        }
                        return;
                    }
                    e.this.h = true;
                } catch (Throwable th) {
                    if (t.b().F()) {
                        th.printStackTrace();
                    }
                    String unused3 = e.this.j;
                    th.getMessage();
                    com.anythink.core.common.u.e.b("Omsdk Exception", "handle:" + i + " with throwable:" + th.getMessage(), t.b().r());
                }
            }
        });
    }

    private void a(String str, String str2) {
        String str3;
        if (a()) {
            str3 = "1";
        } else {
            str3 = !TextUtils.isEmpty(this.a.E()) ? "3" : "2";
        }
        com.anythink.core.common.u.e.a(this.b, this.a, f.a().e(), str3, false, str, str2);
    }

    public final boolean a() {
        return !com.anythink.basead.b.e.a(this.a, this.b) && this.a.n();
    }

    public final void a(boolean z) {
        if (z) {
            this.g = 0.0f;
        } else {
            this.g = 1.0f;
        }
    }

    public final void a(long j) {
        this.f = j;
    }

    public final void a(View view) {
        if (view != null) {
            this.n = new WeakReference<>(view);
        }
    }

    public final void b(View view) {
        if (view != null) {
            if (this.o == null) {
                this.o = new ArrayList();
            }
            this.o.add(new WeakReference<>(view));
        }
    }

    public final void b() {
        this.k = true;
    }

    static /* synthetic */ void a(e eVar, String str, String str2) {
        String str3;
        if (eVar.a()) {
            str3 = "1";
        } else {
            str3 = !TextUtils.isEmpty(eVar.a.E()) ? "3" : "2";
        }
        com.anythink.core.common.u.e.a(eVar.b, eVar.a, f.a().e(), str3, false, str, str2);
    }
}
