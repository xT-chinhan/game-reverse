package com.anythink.core.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bo;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n {
    public static final String a = "n";
    private static volatile n b;
    private Context c;
    private final p e;
    private final s d = new s();
    private final o f = new o(this);

    public interface b {
        void a();

        void a(AdError adError);

        void a(l lVar);

        void b();

        void b(l lVar);
    }

    private n(Context context) {
        this.c = context;
        this.e = new p(this.c);
    }

    public static n a(Context context) {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n(context);
                }
            }
        }
        return b;
    }

    public final void a(String str, l lVar, JSONObject jSONObject, int i) {
        this.e.a(com.anythink.core.common.d.s.b().p(), str, lVar, jSONObject, i);
    }

    public final l a(String str) {
        return a(str, true);
    }

    private l a(String str, boolean z) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str, z);
    }

    public final l c(String str) {
        return a(str, false);
    }

    public final l d(String str) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str);
    }

    private l c(String str, int i) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str, i, true);
    }

    public final l e(String str) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str, 2);
    }

    public final l f(String str) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str, 0);
    }

    public final l g(String str) {
        String strP = com.anythink.core.common.d.s.b().p();
        if (this.e.a(com.anythink.core.common.d.s.b().p(), str, 0) != null) {
            this.e.b(strP, str, 1);
            return null;
        }
        l lVarA = this.e.a(strP, str, 1);
        if (lVarA == null) {
            lVarA = this.d.b(str);
        }
        if (lVarA != null) {
            a(str, lVarA, null, 1);
        }
        return lVarA;
    }

    public final void h(String str) {
        this.e.c(com.anythink.core.common.d.s.b().p(), str);
    }

    public final boolean i(String str) {
        return this.e.b(com.anythink.core.common.d.s.b().p(), str);
    }

    public final void j(String str) {
        this.d.a(str);
    }

    public final void b(String str, int i) {
        this.e.a(str, i);
    }

    public final void a(final l lVar, String str, String str2, final String str3, Map<String, Object> map, b bVar, int i, boolean z, ATAdRequest aTAdRequest, boolean z2, String str4) {
        long jAr;
        int i2;
        com.anythink.core.common.u.b.d dVar;
        final bo boVar;
        final a aVar = new a(str3, bVar);
        String strAi = lVar != null ? lVar.ai() : "";
        Map<String, Object> mapD = com.anythink.core.common.d.s.b().d(str3);
        bo boVar2 = new bo(str, str2, str3, strAi, mapD, map, com.anythink.core.common.t.a().c(str3), aTAdRequest);
        boVar2.a(z2);
        boVar2.a(i);
        if (lVar == null) {
            boVar2.a("1");
            this.f.a(this.c, boVar2, new m(this, boVar2, aVar, null));
            return;
        }
        if (lVar.br()) {
            lVar.b(4);
            aVar.a(lVar);
            return;
        }
        lVar.b(3);
        boVar2.a(lVar.bh());
        if (z) {
            if (!TextUtils.isEmpty(str4)) {
                boVar2.a(str4);
            }
            this.f.a(this.c, boVar2, new m(this, boVar2, aVar, lVar));
            return;
        }
        boolean zBm = lVar.bm();
        if (lVar.aO()) {
            aVar.a(lVar);
            boVar2.a((Map<String, String>) null);
            boVar2.a("1");
            this.f.a(this.c, boVar2, new m(this, boVar2, aVar, lVar));
            return;
        }
        if (!zBm && lVar.aQ()) {
            aVar.a(lVar);
            aVar.b = null;
        }
        l lVarF = f(str3);
        if (lVarF == null) {
            boVar2.a((Map<String, String>) null);
            boVar2.a("1");
            this.f.a(this.c, boVar2, new m(this, boVar2, aVar, lVar));
            return;
        }
        boVar2.a(lVarF.bh());
        boolean z3 = !mapD.equals(lVarF.af());
        boolean zBi = lVarF.bi();
        boolean zB = com.anythink.core.common.r.a().b(this.c, str3);
        if (!(z3 || lVarF.bl() || zB || zBm || zBi)) {
            aVar.a(lVar);
            return;
        }
        if (zBm) {
            boVar2.a(com.anythink.core.common.d.i.ad.d);
        } else if (z3) {
            boVar2.a("3");
        } else if (zB) {
            boVar2.a(com.anythink.core.common.d.i.ad.i);
        } else if (lVarF.bl()) {
            boVar2.a("2");
        } else if (zBi) {
            boVar2.a(com.anythink.core.common.d.i.ad.n);
        }
        lVarF.e(0);
        final boolean[] zArr = new boolean[1];
        if (zBm) {
            jAr = lVarF.bK();
            i2 = 3;
        } else if (z3) {
            jAr = lVarF.bx();
            i2 = 2;
        } else {
            jAr = lVarF.ar();
            i2 = 1;
        }
        com.anythink.core.common.s.a aVarA = com.anythink.core.common.s.c.a();
        if (jAr == 0) {
            zArr[0] = true;
            aVar.a(lVar);
            dVar = null;
            boVar = boVar2;
        } else {
            boVar = boVar2;
            final int i3 = i2;
            dVar = new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dq, new Runnable() { // from class: com.anythink.core.e.n.1
                @Override // java.lang.Runnable
                public final void run() {
                    zArr[0] = true;
                    lVar.b(1);
                    aVar.a(lVar);
                    com.anythink.core.common.t.f.a("placement", "", "strategy timeout", "", str3, "", "", (ATAdRequest) null, boVar.k(), i3);
                }
            });
            aVarA.a(dVar, jAr);
        }
        com.anythink.core.d.b.a().b(str3);
        this.f.a(this.c, boVar, new m(this, boVar, aVar, lVar, aVarA, dVar, zArr));
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        l lVarA;
        JSONObject jSONObjectAN;
        if (jSONObject != null) {
            if (jSONObject2 == null && TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (jSONObject2 != null) {
                    jSONObject.put(l.a.aa, jSONObject2);
                } else {
                    if (TextUtils.isEmpty(str) || (lVarA = a(str, true)) == null || (jSONObjectAN = lVarA.aN()) == null) {
                        return;
                    }
                    jSONObject.put(l.a.aa, jSONObjectAN);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(int i, Object obj, final bo boVar, b bVar, boolean[] zArr, l lVar) {
        if (!(obj instanceof JSONObject) || boVar == null) {
            if (bVar != null) {
                if (lVar == null) {
                    bVar.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement LoadParams error."));
                    return;
                } else {
                    bVar.a(lVar);
                    return;
                }
            }
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            jSONObject.put(l.a.ac, System.currentTimeMillis());
            jSONObject.put("strategy_domain_type_key", i == 1 ? 1 : 0);
            l lVarA = a(boVar.d(), jSONObject.optInt(l.a.av, 0));
            if (lVarA != null) {
                lVarA.a(jSONObject, boVar.d());
            }
        } catch (Throwable th) {
            Log.e(a, "parse place strategy error:" + th.getMessage());
        }
        final l lVarA2 = l.a(boVar.d(), jSONObject);
        final String strD = boVar.d();
        if (lVarA2 != null) {
            lVarA2.b(boVar.o() ? 5 : 2);
            if (lVarA2.as() != 1) {
                jSONObject = null;
            }
            a(strD, lVarA2, jSONObject, lVarA2.aW());
            if (boVar.h() == 3 && lVarA2.aQ()) {
                boVar.a(2);
                boVar.a((Map<String, String>) null);
                boVar.a(com.anythink.core.common.d.i.ad.e);
                this.f.a(this.c, boVar);
            } else if (lVarA2.aR()) {
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bZ, new Runnable() { // from class: com.anythink.core.e.n.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (lVarA2.ag() == 1) {
                            com.anythink.core.common.r.a().a(n.this.c, strD, lVarA2.bf());
                        }
                        if (!lVarA2.aP()) {
                            n.this.e.b(boVar.b(), strD, 2);
                            return;
                        }
                        boVar.a(1);
                        l lVarE = n.this.e(strD);
                        if (lVarE != null) {
                            boVar.a(lVarE.bh());
                        } else {
                            boVar.a((Map<String, String>) null);
                        }
                        boVar.a(com.anythink.core.common.d.i.ad.f);
                        n.this.f.a(n.this.c, boVar);
                    }
                }));
            }
        }
        if (zArr != null && zArr.length > 0 && zArr[0]) {
            if (bVar == null || lVarA2 == null) {
                return;
            }
            bVar.b(lVarA2);
            return;
        }
        if (bVar != null) {
            if (lVarA2 != null) {
                bVar.a(lVarA2);
            } else {
                bVar.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement Service error."));
            }
        }
    }

    private static class a implements b {
        private final String a;
        private b b;
        private volatile boolean c = false;

        public a(String str, b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // com.anythink.core.e.n.b
        public final void a() {
            b bVar = this.b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.anythink.core.e.n.b
        public final void b() {
            b bVar = this.b;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // com.anythink.core.e.n.b
        public final void a(l lVar) {
            if (this.b == null || this.c) {
                return;
            }
            n.a(com.anythink.core.common.d.s.b().g()).b(this.a, lVar.aW());
            this.c = true;
            this.b.a(lVar);
        }

        @Override // com.anythink.core.e.n.b
        public final void a(AdError adError) {
            if (this.b == null || this.c) {
                return;
            }
            this.c = true;
            this.b.a(adError);
        }

        @Override // com.anythink.core.e.n.b
        public final void b(l lVar) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(lVar);
            }
        }
    }

    public final void a(String str, String str2, l lVar) {
        if (lVar == null) {
            return;
        }
        this.e.b(str, str2, lVar.aW());
    }

    public final int k(String str) {
        return this.e.d(com.anythink.core.common.d.s.b().p(), str);
    }

    public final l b(String str) {
        return a(str, true);
    }

    public final l a(String str, int i) {
        return this.e.a(com.anythink.core.common.d.s.b().p(), str, i, true);
    }
}
