package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.bm;
import com.anythink.core.common.v.af;
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

    public final void a() {
        af.a(this.c, com.anythink.core.common.d.u.b.j);
    }

    public final void a(String str, l lVar, JSONObject jSONObject, int i) {
        this.e.a(com.anythink.core.common.d.t.b().p(), str, lVar, jSONObject, i);
    }

    public final l a(String str) {
        return this.e.c(com.anythink.core.common.d.t.b().p(), str);
    }

    public final l b(String str) {
        return a(str);
    }

    public final l c(String str) {
        return this.e.a(com.anythink.core.common.d.t.b().p(), str);
    }

    public final l a(String str, int i) {
        return this.e.a(com.anythink.core.common.d.t.b().p(), str, i);
    }

    public final l d(String str) {
        return this.e.a(com.anythink.core.common.d.t.b().p(), str, 2);
    }

    public final l e(String str) {
        return this.e.a(com.anythink.core.common.d.t.b().p(), str, 0);
    }

    public final l f(String str) {
        String strP = com.anythink.core.common.d.t.b().p();
        if (this.e.a(com.anythink.core.common.d.t.b().p(), str, 0) != null) {
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

    public final void g(String str) {
        this.e.d(com.anythink.core.common.d.t.b().p(), str);
    }

    public final boolean h(String str) {
        return this.e.b(com.anythink.core.common.d.t.b().p(), str);
    }

    public final void i(String str) {
        this.d.a(str);
    }

    public final void b(String str, int i) {
        this.e.a(str, i);
    }

    public final void a(final l lVar, final String str, final String str2, final String str3, final Map<String, Object> map, final b bVar, final int i, final boolean z, final ATAdRequest aTAdRequest) {
        com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.d.n.1
            final /* synthetic */ boolean h = true;

            @Override // java.lang.Runnable
            public final void run() {
                long jAs;
                com.anythink.core.common.t.b bVar2;
                final a aVar = new a(str3, bVar);
                l lVar2 = lVar;
                String strAj = lVar2 != null ? lVar2.aj() : "";
                Map<String, Object> mapD = com.anythink.core.common.d.t.b().d(str3);
                bm bmVar = new bm(str, str2, str3, strAj, mapD, map, com.anythink.core.common.u.a().g(str3), aTAdRequest);
                bmVar.a(this.h);
                bmVar.a(i);
                String str4 = n.a;
                StringBuilder sbAppend = new StringBuilder("requestStrategy() >>> placeId: ").append(str3).append(" fistReqPlaceStrategyFlag: ").append(i).append(" oldStrategyType: ");
                l lVar3 = lVar;
                sbAppend.append(lVar3 != null ? Integer.valueOf(lVar3.bb()) : null);
                l lVar4 = lVar;
                if (lVar4 == null) {
                    n.this.f.a(n.this.c, bmVar, new m(n.this, bmVar, aVar, null));
                    return;
                }
                if (lVar4.br()) {
                    lVar.b(4);
                    aVar.a(lVar);
                    return;
                }
                lVar.b(3);
                bmVar.a(lVar.ba());
                if (z) {
                    n.this.f.a(n.this.c, bmVar, new m(n.this, bmVar, aVar, lVar));
                    return;
                }
                if (lVar.aR()) {
                    aVar.a(lVar);
                    bmVar.a((Map<String, String>) null);
                    n.this.f.a(n.this.c, bmVar, new m(n.this, bmVar, aVar, lVar));
                    return;
                }
                if (lVar.aT()) {
                    aVar.a(lVar);
                    aVar.b = null;
                }
                l lVarE = n.this.e(str3);
                if (lVarE == null) {
                    String str5 = n.a;
                    bmVar.a((Map<String, String>) null);
                    n.this.f.a(n.this.c, bmVar, new m(n.this, bmVar, aVar, lVar));
                    return;
                }
                bmVar.a(lVarE.ba());
                boolean z2 = !mapD.equals(lVarE.ag());
                if (!(z2 || lVarE.bk() || com.anythink.core.common.r.a().b(n.this.c, str3) || lVarE.bl())) {
                    aVar.a(lVar);
                    return;
                }
                final boolean[] zArr = new boolean[1];
                if (z2) {
                    jAs = lVarE.bx();
                } else {
                    jAs = lVarE.as();
                }
                String str6 = n.a;
                com.anythink.core.common.t.a aVarA = com.anythink.core.common.t.d.a();
                if (jAs == 0) {
                    zArr[0] = true;
                    aVar.a(lVar);
                    bVar2 = null;
                } else {
                    com.anythink.core.common.t.b bVar3 = new com.anythink.core.common.t.b() { // from class: com.anythink.core.d.n.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str7 = n.a;
                            zArr[0] = true;
                            lVar.b(1);
                            aVar.a(lVar);
                        }
                    };
                    aVarA.a(bVar3, jAs, false);
                    bVar2 = bVar3;
                }
                com.anythink.core.c.b.a().b(str3);
                n.this.f.a(n.this.c, bmVar, new m(n.this, bmVar, aVar, lVar, aVarA, bVar2, zArr));
            }
        }, 2);
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        l lVarA;
        JSONObject jSONObjectAQ;
        if (jSONObject != null) {
            if (jSONObject2 == null && TextUtils.isEmpty(str)) {
                return;
            }
            try {
                if (jSONObject2 != null) {
                    jSONObject.put(l.a.aa, jSONObject2);
                } else {
                    if (TextUtils.isEmpty(str) || (lVarA = a(str)) == null || (jSONObjectAQ = lVarA.aQ()) == null) {
                        return;
                    }
                    jSONObject.put(l.a.aa, jSONObjectAQ);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(Object obj, final bm bmVar, b bVar, boolean[] zArr, l lVar) {
        if (!(obj instanceof JSONObject) || bmVar == null) {
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
            l lVarA = a(bmVar.d(), jSONObject.optInt(l.a.av, 0));
            if (lVarA != null) {
                lVarA.a(jSONObject, bmVar.d());
            }
        } catch (Throwable th) {
            Log.e(a, "parse place strategy error:" + th.getMessage());
        }
        final l lVarA2 = l.a(bmVar.d(), jSONObject);
        final String strD = bmVar.d();
        if (lVarA2 != null) {
            lVarA2.b(bmVar.o() ? 5 : 2);
            if (lVarA2.at() != 1) {
                jSONObject = null;
            }
            a(strD, lVarA2, jSONObject, lVarA2.bb());
            int iH = bmVar.h();
            lVarA2.bb();
            if (iH == 3 && lVarA2.aT()) {
                bmVar.a(2);
                bmVar.a((Map<String, String>) null);
                this.f.a(this.c, bmVar);
            } else if (lVarA2.aU()) {
                com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.d.n.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (lVarA2.ah() == 1) {
                            com.anythink.core.common.r.a().a(n.this.c, strD, bmVar.j());
                        }
                        if (!lVarA2.aS()) {
                            n.this.e.b(bmVar.b(), strD, 2);
                            return;
                        }
                        bmVar.a(1);
                        l lVarD = n.this.d(strD);
                        if (lVarD != null) {
                            bmVar.a(lVarD.ba());
                        } else {
                            bmVar.a((Map<String, String>) null);
                        }
                        n.this.f.a(n.this.c, bmVar);
                    }
                });
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

        @Override // com.anythink.core.d.n.b
        public final void a() {
            b bVar = this.b;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.anythink.core.d.n.b
        public final void b() {
            b bVar = this.b;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // com.anythink.core.d.n.b
        public final void a(l lVar) {
            if (this.b == null || this.c) {
                return;
            }
            int iBb = lVar.bb();
            n.a(com.anythink.core.common.d.t.b().g()).b(this.a, iBb);
            String str = n.a;
            Object[] objArr = new Object[2];
            Integer.valueOf(iBb);
            this.c = true;
            this.b.a(lVar);
        }

        @Override // com.anythink.core.d.n.b
        public final void a(AdError adError) {
            if (this.b == null || this.c) {
                return;
            }
            this.c = true;
            this.b.a(adError);
        }

        @Override // com.anythink.core.d.n.b
        public final void b(l lVar) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(lVar);
            }
        }
    }

    public static boolean a(l lVar) {
        if (lVar == null) {
            return false;
        }
        int iBb = lVar.bb();
        if (iBb != 0) {
            if (iBb == 1) {
                Object[] objArr = new Object[2];
                lVar.i();
                Integer.valueOf(iBb);
                return true;
            }
            if (iBb != 2) {
                Object[] objArr2 = new Object[2];
                lVar.i();
                Integer.valueOf(iBb);
                return true;
            }
        }
        if (lVar.bl()) {
            Object[] objArr3 = new Object[2];
            lVar.i();
            Integer.valueOf(iBb);
            return false;
        }
        Object[] objArr4 = new Object[2];
        lVar.i();
        Integer.valueOf(iBb);
        return true;
    }

    public final void a(String str, String str2, l lVar) {
        if (lVar == null) {
            return;
        }
        this.e.b(str, str2, lVar.bb());
    }

    public final int j(String str) {
        return this.e.e(com.anythink.core.common.d.t.b().p(), str);
    }
}
