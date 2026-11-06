package com.anythink.basead.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.f.b.d;
import com.anythink.basead.f.c.c;
import com.anythink.core.api.AdError;
import com.anythink.core.common.a.e;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bg;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.x;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.b.b;
import com.anythink.core.common.v.z;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a d;
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    ConcurrentHashMap<String, c> b = new ConcurrentHashMap<>(2);
    private Context c;

    /* JADX INFO: renamed from: com.anythink.basead.f.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0040a {
        void a(d dVar);

        void a(r rVar);

        void a(r rVar, f fVar);

        void a(r rVar, d dVar);
    }

    private a(Context context) {
        this.c = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    public final void a(final x xVar, final InterfaceC0040a interfaceC0040a) {
        if (this.a.contains(xVar.b + xVar.a) && this.a.get(xVar.b + xVar.a).booleanValue()) {
            interfaceC0040a.a((r) null, g.a(g.g, g.w));
        } else {
            this.a.put(xVar.b + xVar.a, Boolean.TRUE);
            b.a().b(new Runnable() { // from class: com.anythink.basead.f.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(a.this, xVar, interfaceC0040a);
                }
            });
        }
    }

    private void b(x xVar, InterfaceC0040a interfaceC0040a) {
        r rVarA;
        try {
            rVarA = a(xVar);
            try {
                rVarA.d(xVar.n);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            rVarA = null;
        }
        if (rVarA == null) {
            new com.anythink.basead.i.a(xVar).a(0, (q) new AnonymousClass2(xVar, interfaceC0040a));
        } else {
            a(rVarA, xVar, interfaceC0040a, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.a.a$2, reason: invalid class name */
    final class AnonymousClass2 implements q {
        final /* synthetic */ x a;
        final /* synthetic */ InterfaceC0040a b;

        @Override // com.anythink.core.common.m.q
        public final void onLoadStart(int i) {
        }

        AnonymousClass2(x xVar, InterfaceC0040a interfaceC0040a) {
            this.a = xVar;
            this.b = interfaceC0040a;
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadFinish(int i, Object obj) {
            r rVarA;
            try {
                rVarA = e.a(this.a.a, (JSONObject) obj, this.a.f, false);
            } catch (Exception unused) {
                rVarA = null;
            }
            if (rVarA != null) {
                rVarA.d(this.a.n);
                a.this.a(rVarA, this.a);
                com.anythink.core.common.a.a.a().a(a.this.c, this.a.c, this.a.a, obj.toString());
                InterfaceC0040a interfaceC0040a = this.b;
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(rVarA);
                }
                a.this.b(rVarA, this.a, this.b);
                return;
            }
            InterfaceC0040a interfaceC0040a2 = this.b;
            if (interfaceC0040a2 != null) {
                interfaceC0040a2.a((r) null, g.a(g.i, obj != null ? obj.toString() : "No Ad Return."));
            }
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0040a interfaceC0040a = this.b;
            if (interfaceC0040a != null) {
                interfaceC0040a.a((r) null, g.a(g.i, str));
            }
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadCanceled(int i) {
            InterfaceC0040a interfaceC0040a = this.b;
            if (interfaceC0040a != null) {
                interfaceC0040a.a((r) null, g.a(g.i, "Cancel Request."));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, x xVar, InterfaceC0040a interfaceC0040a, boolean z) {
        if (interfaceC0040a != null) {
            interfaceC0040a.a(rVar);
        }
        if (z) {
            if (com.anythink.basead.f.c.a.a() && com.anythink.basead.f.c.a.b().a(rVar, xVar)) {
                b(rVar, xVar, interfaceC0040a);
                return;
            }
            return;
        }
        b(rVar, xVar, interfaceC0040a);
    }

    public final void a(final bj bjVar, final x xVar, final InterfaceC0040a interfaceC0040a) {
        b.a().b(new Runnable() { // from class: com.anythink.basead.f.a.a.3
            @Override // java.lang.Runnable
            public final void run() {
                bj bjVar2 = bjVar;
                if (bjVar2 == null || !(bjVar2 instanceof r)) {
                    return;
                }
                if (!TextUtils.isEmpty(((r) bjVar2).d())) {
                    if (com.anythink.basead.f.c.a.a()) {
                        com.anythink.basead.f.c.a.b().a((r) bjVar);
                        a.this.a((r) bjVar, xVar, interfaceC0040a, true);
                        return;
                    }
                    return;
                }
                if (bjVar.m() != 2 || bjVar.ag()) {
                    return;
                }
                String strD = com.anythink.core.common.a.a.a().d(a.this.c, xVar.a);
                if (TextUtils.isEmpty(strD)) {
                    return;
                }
                new com.anythink.basead.l.d(a.this.c, (r) bjVar, xVar).a(new com.anythink.basead.l.d.a() { // from class: com.anythink.basead.f.a.a.3.1
                    @Override // com.anythink.basead.l.d.a
                    public final void a(String str, String str2) {
                    }

                    @Override // com.anythink.basead.l.d.a
                    public final void a(r rVar) {
                        if (interfaceC0040a != null) {
                            interfaceC0040a.a(rVar, (d) null);
                        }
                    }
                }, strD);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final r rVar, final x xVar, final InterfaceC0040a interfaceC0040a) {
        if (TextUtils.isEmpty(rVar.d()) && rVar.m() == 2) {
            new com.anythink.basead.l.d(this.c, rVar, xVar).a(new com.anythink.basead.l.d.a() { // from class: com.anythink.basead.f.a.a.4
                @Override // com.anythink.basead.l.d.a
                public final void a(r rVar2) {
                    a.this.a(rVar2, xVar, interfaceC0040a);
                }

                @Override // com.anythink.basead.l.d.a
                public final void a(String str, String str2) {
                    interfaceC0040a.a(rVar, g.a(g.q, "[" + str + "," + str2 + "]"));
                }
            });
        } else {
            a(rVar, xVar, interfaceC0040a);
        }
    }

    protected final void a(final r rVar, final x xVar, final InterfaceC0040a interfaceC0040a) {
        com.anythink.basead.f.f.a.a(xVar, rVar);
        if (!TextUtils.isEmpty(rVar.d())) {
            if (com.anythink.basead.f.c.a.a()) {
                com.anythink.basead.f.c.a.b().a(rVar, xVar, new com.anythink.basead.f.c.e() { // from class: com.anythink.basead.f.a.a.5
                    @Override // com.anythink.basead.f.c.e
                    public final void a(c cVar) {
                        InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                        if (interfaceC0040a2 != null) {
                            interfaceC0040a2.a(cVar);
                        }
                    }

                    @Override // com.anythink.basead.f.c.e
                    public final void b(c cVar) {
                        a.this.a.put(xVar.b + xVar.a, Boolean.FALSE);
                        InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                        if (interfaceC0040a2 != null) {
                            interfaceC0040a2.a(rVar, cVar);
                        }
                    }

                    @Override // com.anythink.basead.f.c.e
                    public final void a(f fVar) {
                        a.this.a.put(xVar.b + xVar.a, Boolean.FALSE);
                        InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                        if (interfaceC0040a2 != null) {
                            interfaceC0040a2.a(rVar, fVar);
                        }
                    }
                });
                return;
            } else {
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(rVar, g.a(g.r, g.W));
                    return;
                }
                return;
            }
        }
        if (TextUtils.equals(rVar.aC(), com.anythink.basead.f.d.b.a)) {
            if (com.anythink.basead.f.d.b.a() != null) {
                com.anythink.basead.f.d.b.a().a(rVar, xVar, interfaceC0040a);
                return;
            } else {
                if (interfaceC0040a != null) {
                    interfaceC0040a.a(rVar, g.a(g.s, g.X));
                    return;
                }
                return;
            }
        }
        com.anythink.basead.b.f.a();
        com.anythink.basead.b.f.a(xVar.b, rVar, xVar, new com.anythink.basead.b.c.c.b() { // from class: com.anythink.basead.f.a.a.6
            @Override // com.anythink.basead.b.c.c.b
            public final void a() {
                a.this.a.put(xVar.b + xVar.a, Boolean.FALSE);
                InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                if (interfaceC0040a2 != null) {
                    interfaceC0040a2.a(rVar, (d) null);
                }
            }

            @Override // com.anythink.basead.b.c.c.b
            public final void a(f fVar) {
                a.this.a.put(xVar.b + xVar.a, Boolean.FALSE);
                InterfaceC0040a interfaceC0040a2 = interfaceC0040a;
                if (interfaceC0040a2 != null) {
                    interfaceC0040a2.a(rVar, fVar);
                }
            }
        });
    }

    public final r a(x xVar) {
        bg bgVarA = com.anythink.core.common.a.a.a().a(this.c, xVar.a);
        r rVarA = null;
        if (bgVarA != null && !TextUtils.isEmpty(bgVarA.a())) {
            try {
                rVarA = e.a(xVar.a, new JSONObject(bgVarA.a()), xVar.f, false);
                rVarA.d(bgVarA.b());
            } catch (Throwable unused) {
            }
            if (rVarA != null) {
                a(rVarA, xVar);
            }
        }
        return rVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, x xVar) {
        if (rVar == null || xVar == null) {
            return;
        }
        rVar.h(xVar.d);
        rVar.P(xVar.s);
        rVar.Q(xVar.t);
        s sVarC = t.b().c();
        if (sVarC != null && sVarC.a()) {
            sVarC.fillDataFetchStatus(this.c, rVar, xVar);
        } else {
            rVar.m(0);
        }
        com.anythink.basead.f.f.b.a(rVar);
        if (xVar.f == 67) {
            com.anythink.core.common.f.c.a(this.c).a(rVar.v(), rVar.ay());
            com.anythink.core.common.f.b.a(this.c).a(rVar.w(), rVar.ay());
        }
        z.a();
        com.anythink.basead.b.e.a.a();
    }

    static /* synthetic */ void a(a aVar, x xVar, InterfaceC0040a interfaceC0040a) {
        r rVarA;
        try {
            rVarA = aVar.a(xVar);
            try {
                rVarA.d(xVar.n);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            rVarA = null;
        }
        if (rVarA == null) {
            new com.anythink.basead.i.a(xVar).a(0, (q) aVar.new AnonymousClass2(xVar, interfaceC0040a));
        } else {
            aVar.a(rVarA, xVar, interfaceC0040a, false);
        }
    }
}
