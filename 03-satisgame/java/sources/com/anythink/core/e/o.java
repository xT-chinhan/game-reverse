package com.anythink.core.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private static final String a = "o";
    private n b;

    public o(n nVar) {
        this.b = nVar;
    }

    public o() {
    }

    public final void a(Context context, final bo boVar) {
        if (boVar == null) {
            return;
        }
        a(context, boVar, new com.anythink.core.common.l.s() { // from class: com.anythink.core.e.o.1
            @Override // com.anythink.core.common.l.s
            public final void onLoadCanceled(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str, AdError adError) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                o.a(o.this, i, obj, boVar);
            }
        });
    }

    private void a(int i, Object obj, bo boVar) {
        l lVarA;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                jSONObject.put(l.a.ac, System.currentTimeMillis());
                jSONObject.put("strategy_domain_type_key", i == 1 ? 1 : 0);
                int iOptInt = jSONObject.optInt(l.a.av, 0);
                n nVar = this.b;
                if (nVar != null && (lVarA = nVar.a(boVar.d(), iOptInt)) != null) {
                    lVarA.a(jSONObject, boVar.d());
                }
            } catch (Throwable th) {
                Log.e(a, "parse place strategy error:" + th.getMessage());
            }
            l lVarA2 = l.a(boVar.d(), jSONObject);
            n nVar2 = this.b;
            if (nVar2 == null || lVarA2 == null) {
                return;
            }
            String strD = boVar.d();
            if (lVarA2.as() != 1) {
                jSONObject = null;
            }
            nVar2.a(strD, lVarA2, jSONObject, lVarA2.aW());
        }
    }

    public final void a(Context context, bo boVar, com.anythink.core.common.l.s sVar) {
        if (boVar == null) {
            return;
        }
        com.anythink.core.common.d.s.b().T();
        if (a()) {
            b(context, boVar, sVar);
        } else {
            a(context, boVar, sVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, bo boVar, com.anythink.core.common.l.s sVar, boolean z) {
        b bVarB = d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        byte b = 0;
        if (bVarB != null && !TextUtils.isEmpty(bVarB.as())) {
            new com.anythink.core.common.l.u(context, boVar).b(bVarB.as()).a(z).a(0, sVar);
            return;
        }
        com.anythink.core.common.i.a();
        final String strB = com.anythink.core.common.i.b(true);
        com.anythink.core.common.i.a();
        final String strB2 = com.anythink.core.common.i.b(false);
        long jAM = bVarB != null ? bVarB.aM() : 10000L;
        long jAO = bVarB != null ? bVarB.aO() : 10000L;
        final a aVar = new a(b);
        aVar.a = context;
        aVar.b = boVar;
        aVar.c = strB;
        aVar.d = strB2;
        aVar.g = jAM;
        aVar.h = jAO;
        aVar.j = z;
        if (!ATSDK.isCnSDK()) {
            final com.anythink.core.common.l.p pVar = new com.anythink.core.common.l.p(sVar);
            a(false, aVar, (com.anythink.core.common.l.s) pVar);
            com.anythink.core.common.g.c.a().a(new com.anythink.core.common.g.d() { // from class: com.anythink.core.e.o.2
                @Override // com.anythink.core.common.g.d
                public final void a(String str, String str2) {
                    pVar.b();
                    String strE = com.anythink.core.common.u.p.e(strB);
                    String strE2 = com.anythink.core.common.u.p.e(strB2);
                    boolean z2 = (TextUtils.isEmpty(str) || str.equals(strE)) ? false : true;
                    boolean z3 = (TextUtils.isEmpty(str2) || str2.equals(strE2)) ? false : true;
                    if (z2 || z3) {
                        com.anythink.core.common.g.c.a().a(str, str2, strB, z2, aVar.b.k());
                    }
                    com.anythink.core.common.g.c.a();
                    aVar.f = com.anythink.core.common.g.c.b(strB2, str2);
                    if (z2) {
                        com.anythink.core.common.g.c.a();
                        aVar.e = com.anythink.core.common.g.c.b(strB, str);
                        o.this.a(true, aVar, (com.anythink.core.common.l.s) pVar);
                        return;
                    }
                    pVar.a();
                }
            });
            return;
        }
        a(false, aVar, sVar);
    }

    private static boolean a() {
        if (ATSDK.isCnSDK()) {
            return false;
        }
        b bVarA = d.a();
        return bVarA == null || bVarA.aF();
    }

    private void b(final Context context, final bo boVar, final com.anythink.core.common.l.s sVar) {
        long jB;
        String strT = new com.anythink.core.common.l.u(context, boVar).t();
        if (TextUtils.isEmpty(strT)) {
            a(context, boVar, sVar, false);
            return;
        }
        final com.anythink.core.common.l.e.j jVar = new com.anythink.core.common.l.e.j();
        b bVarA = d.a();
        if (bVarA != null) {
            jB = bVarA.aH();
        } else {
            jB = b.b(0L);
        }
        long j = jB;
        new com.anythink.core.common.l.e.g(strT).a(new com.anythink.core.common.l.c() { // from class: com.anythink.core.e.o.3
            @Override // com.anythink.core.common.l.s
            public final void onLoadFinish(int i, Object obj) {
                if (obj instanceof JSONObject) {
                    if (jVar.a()) {
                        sVar.onLoadFinish(i, obj);
                    }
                } else if (jVar.a()) {
                    o.this.a(context, boVar, sVar, true);
                }
            }

            @Override // com.anythink.core.common.l.s
            public final void onLoadError(int i, String str, AdError adError) {
                if (jVar.a()) {
                    o.this.a(context, boVar, sVar, true);
                }
            }
        }, j);
        try {
            jVar.a(com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new Runnable() { // from class: com.anythink.core.e.o.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (jVar.a()) {
                        o.this.a(context, boVar, sVar, true);
                    }
                }
            }), j));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final a aVar, final com.anythink.core.common.l.s sVar) {
        final String strK = aVar.b.k();
        final String strA = aVar.a(z);
        final String strB = aVar.b(z);
        new com.anythink.core.e.a.a(z, sVar) { // from class: com.anythink.core.e.o.5
            @Override // com.anythink.core.e.a.a
            protected final void a(int i, com.anythink.core.common.l.p pVar) {
                boolean z2 = i == 0;
                String str = z2 ? strA : strB;
                new com.anythink.core.common.l.u(aVar.a, aVar.b).b(str).b(z).a(aVar.j).a(i, (com.anythink.core.common.l.s) pVar);
                com.anythink.core.common.t.f.a(strK, z2 ? 1 : 2, str, 1, i(), j(), z, aVar.b.d());
            }

            @Override // com.anythink.core.e.a.a
            protected final boolean c() {
                if (TextUtils.equals(strB, aVar.i)) {
                    return false;
                }
                aVar.i = strB;
                return true;
            }

            @Override // com.anythink.core.e.a.a
            protected final long d() {
                return aVar.g;
            }

            @Override // com.anythink.core.e.a.a
            protected final long e() {
                return aVar.h;
            }

            @Override // com.anythink.core.e.a.a
            protected final void f() {
                com.anythink.core.common.t.f.a(strK, 0, "", 4, i(), j(), z, aVar.b.d());
                if (sVar != null) {
                    String str = "request timeout for main(backup) strategy (" + aVar.g + "/" + aVar.h + ")";
                    sVar.onLoadError(0, str, ErrorCode.getErrorCode(ErrorCode.exception, "", str));
                }
            }

            @Override // com.anythink.core.e.a.a
            protected final void b(int i, Object obj) {
                o.a(o.this, i, obj, aVar.b);
            }

            @Override // com.anythink.core.e.a.a
            protected final void a(boolean z2, int i) {
                boolean z3 = i == 0;
                com.anythink.core.common.t.f.a(strK, z3 ? 1 : 2, z3 ? strA : strB, z2 ? 2 : 3, i(), j(), z, aVar.b.d());
            }
        }.g();
    }

    private static class a {
        Context a;
        bo b;
        String c;
        String d;
        String e;
        String f;
        long g;
        long h;
        String i;
        boolean j;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final String a(boolean z) {
            if (z) {
                return this.e;
            }
            return this.c;
        }

        public final String b(boolean z) {
            if (z) {
                return this.f;
            }
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            return this.d;
        }
    }

    static /* synthetic */ void a(o oVar, int i, Object obj, bo boVar) {
        l lVarA;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            try {
                jSONObject.put(l.a.ac, System.currentTimeMillis());
                jSONObject.put("strategy_domain_type_key", i == 1 ? 1 : 0);
                int iOptInt = jSONObject.optInt(l.a.av, 0);
                n nVar = oVar.b;
                if (nVar != null && (lVarA = nVar.a(boVar.d(), iOptInt)) != null) {
                    lVarA.a(jSONObject, boVar.d());
                }
            } catch (Throwable th) {
                Log.e(a, "parse place strategy error:" + th.getMessage());
            }
            l lVarA2 = l.a(boVar.d(), jSONObject);
            n nVar2 = oVar.b;
            if (nVar2 == null || lVarA2 == null) {
                return;
            }
            String strD = boVar.d();
            if (lVarA2.as() != 1) {
                jSONObject = null;
            }
            nVar2.a(strD, lVarA2, jSONObject, lVarA2.aW());
        }
    }
}
