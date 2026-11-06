package com.anythink.basead.f.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.d.j;
import com.anythink.basead.f.f.c;
import com.anythink.basead.i.d;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bi;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.m.q;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a c;
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    private Context b;

    /* JADX INFO: renamed from: com.anythink.basead.f.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0043a {
        void a();

        void a(bi biVar);

        void a(bi biVar, f fVar);
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public final void a(x xVar, String str, InterfaceC0043a interfaceC0043a) {
        int i;
        int i2;
        int i3;
        com.anythink.core.basead.b.a();
        String strA = com.anythink.core.basead.b.a(xVar);
        bi biVarA = null;
        if (this.a.contains(strA) && this.a.get(strA).booleanValue()) {
            interfaceC0043a.a(null, g.a(g.g, g.w));
            return;
        }
        this.a.put(strA, Boolean.TRUE);
        try {
            biVarA = a(xVar);
        } catch (Throwable unused) {
        }
        if (biVarA == null || biVarA.ax()) {
            if (TextUtils.isEmpty(xVar.o.B())) {
                i3 = 0;
                i2 = 0;
            } else {
                try {
                    String[] strArrSplit = xVar.o.B().split("x");
                    i = Integer.parseInt(strArrSplit[0]);
                    try {
                        i2 = Integer.parseInt(strArrSplit[1]);
                    } catch (Throwable unused2) {
                        i2 = 0;
                    }
                } catch (Throwable unused3) {
                    i = 0;
                }
                i3 = i;
            }
            new d(xVar, i3, i2, c.a().a(this.b, c.a(xVar.b, xVar.c)), str).a(0, (q) new AnonymousClass1(xVar, interfaceC0043a));
            return;
        }
        a(xVar, biVarA);
        interfaceC0043a.a();
        a(biVarA, xVar, interfaceC0043a);
    }

    private void b(x xVar, String str, InterfaceC0043a interfaceC0043a) {
        bi biVarA;
        int i;
        int i2;
        int i3;
        try {
            biVarA = a(xVar);
        } catch (Throwable unused) {
            biVarA = null;
        }
        if (biVarA == null || biVarA.ax()) {
            if (TextUtils.isEmpty(xVar.o.B())) {
                i3 = 0;
                i2 = 0;
            } else {
                try {
                    String[] strArrSplit = xVar.o.B().split("x");
                    i = Integer.parseInt(strArrSplit[0]);
                    try {
                        i2 = Integer.parseInt(strArrSplit[1]);
                    } catch (Throwable unused2) {
                        i2 = 0;
                    }
                } catch (Throwable unused3) {
                    i = 0;
                }
                i3 = i;
            }
            new d(xVar, i3, i2, c.a().a(this.b, c.a(xVar.b, xVar.c)), str).a(0, (q) new AnonymousClass1(xVar, interfaceC0043a));
            return;
        }
        a(xVar, biVarA);
        if (interfaceC0043a != null) {
            interfaceC0043a.a();
        }
        a(biVarA, xVar, interfaceC0043a);
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.e.a$1, reason: invalid class name */
    final class AnonymousClass1 implements q {
        final /* synthetic */ x a;
        final /* synthetic */ InterfaceC0043a b;

        @Override // com.anythink.core.common.m.q
        public final void onLoadStart(int i) {
        }

        AnonymousClass1(x xVar, InterfaceC0043a interfaceC0043a) {
            this.a = xVar;
            this.b = interfaceC0043a;
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadFinish(int i, Object obj) {
            JSONObject jSONObject;
            bi biVarA;
            try {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put(b.a, System.currentTimeMillis());
                    biVarA = b.a(this.a, jSONObject);
                } catch (Exception unused) {
                    biVarA = null;
                }
            } catch (Exception unused2) {
                jSONObject = null;
            }
            if (biVarA != null) {
                com.anythink.basead.f.f.b.a(biVarA);
                if (biVarA.e() == 1 && com.anythink.basead.b.b.a(a.this.b.getApplicationContext(), biVarA.I())) {
                    c.a().a(a.this.b, c.a(this.a.b, this.a.c), biVarA, this.a.o);
                    InterfaceC0043a interfaceC0043a = this.b;
                    if (interfaceC0043a != null) {
                        interfaceC0043a.a(null, g.a(g.i, "Application installed."));
                        return;
                    }
                    return;
                }
                if (biVarA.e() == 2 && !com.anythink.basead.b.b.a(a.this.b.getApplicationContext(), biVarA.I())) {
                    c.a().a(a.this.b, c.a(this.a.b, this.a.c), biVarA, this.a.o);
                    InterfaceC0043a interfaceC0043a2 = this.b;
                    if (interfaceC0043a2 != null) {
                        interfaceC0043a2.a(null, g.a(g.i, "Application not installed yet."));
                        return;
                    }
                    return;
                }
                com.anythink.basead.f.f.a.a(this.a, biVarA);
                com.anythink.basead.b.b.a(10, biVarA, new j(this.a, ""));
                com.anythink.core.basead.b.a();
                Context context = a.this.b;
                com.anythink.core.basead.b.a();
                com.anythink.core.basead.b.a(context, com.anythink.core.basead.b.a(this.a), jSONObject.toString());
                a.this.a(this.a, biVarA);
                InterfaceC0043a interfaceC0043a3 = this.b;
                if (interfaceC0043a3 != null) {
                    interfaceC0043a3.a();
                }
                a.this.a(biVarA, this.a, this.b);
                return;
            }
            InterfaceC0043a interfaceC0043a4 = this.b;
            if (interfaceC0043a4 != null) {
                interfaceC0043a4.a(null, g.a(g.i, obj != null ? obj.toString() : "No Ad Return."));
            }
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadError(int i, String str, AdError adError) {
            InterfaceC0043a interfaceC0043a = this.b;
            if (interfaceC0043a != null) {
                interfaceC0043a.a(null, g.a(g.i, str));
            }
        }

        @Override // com.anythink.core.common.m.q
        public final void onLoadCanceled(int i) {
            InterfaceC0043a interfaceC0043a = this.b;
            if (interfaceC0043a != null) {
                interfaceC0043a.a(null, g.a(g.i, "Cancel Request."));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, w wVar) {
        s sVarC = t.b().c();
        if (sVarC != null && sVarC.a()) {
            sVarC.fillDataFetchStatus(this.b, wVar, xVar);
        } else {
            wVar.m(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final bi biVar, final x xVar, final InterfaceC0043a interfaceC0043a) {
        com.anythink.basead.b.f.a();
        com.anythink.basead.b.f.a(xVar.b, biVar, xVar, new com.anythink.basead.b.c.c.b() { // from class: com.anythink.basead.f.e.a.2
            @Override // com.anythink.basead.b.c.c.b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(xVar), Boolean.FALSE);
                InterfaceC0043a interfaceC0043a2 = interfaceC0043a;
                if (interfaceC0043a2 != null) {
                    interfaceC0043a2.a(biVar);
                }
            }

            @Override // com.anythink.basead.b.c.c.b
            public final void a(f fVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(xVar), Boolean.FALSE);
                InterfaceC0043a interfaceC0043a2 = interfaceC0043a;
                if (interfaceC0043a2 != null) {
                    interfaceC0043a2.a(biVar, fVar);
                }
            }
        });
    }

    private bi a(x xVar) {
        com.anythink.core.basead.b.a();
        String strA = com.anythink.core.basead.b.a(xVar);
        com.anythink.core.basead.b.a();
        String strA2 = com.anythink.core.basead.b.a(this.b, strA);
        bi biVarA = null;
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        try {
            biVarA = b.a(xVar, new JSONObject(strA2));
        } catch (Throwable unused) {
        }
        if (biVarA != null) {
            com.anythink.basead.f.f.b.a(biVarA);
            com.anythink.basead.f.f.a.a(xVar, biVarA);
        }
        return biVarA;
    }
}
