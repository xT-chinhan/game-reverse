package com.anythink.core.d.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cg;
import com.anythink.core.e.g;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements b {
    private static final String b = "PlacementStatisticRecord";
    a a;
    private final n c = n.a(s.b().g());
    private final e d;
    private final f e;
    private final ConcurrentHashMap<String, com.anythink.core.d.a.b> f;
    private final ConcurrentHashMap<String, Boolean> g;

    public d() {
        e eVarC = e.c();
        this.d = eVarC;
        this.e = new f(eVarC);
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.a = new a(eVarC);
    }

    @Override // com.anythink.core.d.b.b
    public final void a(String str, String str2, int i, ATAdRequest aTAdRequest, by byVar) {
        com.anythink.core.d.a.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((byVar == null || !byVar.bz()) && b(str, 10)) {
            com.anythink.core.d.a.a aVar = new com.anythink.core.d.a.a();
            if (byVar != null) {
                aVar.b(byVar.G());
                ad adVarY = byVar.Y();
                if (adVarY != null) {
                    cg cgVar = adVarY.v;
                    aVar.c(cgVar != null ? cgVar.f() : "");
                }
                aVar.a(byVar.K());
                aVar.b(byVar.n());
            }
            aVar.a(str2);
            aVar.d(s.b().r());
            aVar.a(System.currentTimeMillis());
            aVar.e(str);
            aVar.c(10);
            aVar.a(i);
            if (byVar != null && (cVar = this.a.a.get(str)) != null) {
                cVar.a(aVar);
            }
            a(aVar, aTAdRequest);
        }
    }

    @Override // com.anythink.core.d.b.b
    public final void a(bx bxVar, by byVar) {
        ATAdRequest aTAdRequestB;
        if (bxVar == null || byVar == null) {
            return;
        }
        if (byVar == null || !byVar.bz()) {
            String strAQ = bxVar.aQ();
            if (!TextUtils.isEmpty(strAQ) && b(strAQ, 4)) {
                try {
                    aTAdRequestB = ((com.anythink.core.common.h.n) bxVar).b();
                } catch (Exception unused) {
                    aTAdRequestB = null;
                }
                com.anythink.core.d.a.a aVar = new com.anythink.core.d.a.a();
                if (bxVar != null) {
                    aVar.a(bxVar.aR());
                    aVar.e(bxVar.aQ());
                    if (bxVar instanceof com.anythink.core.common.h.n) {
                        aVar.a(((com.anythink.core.common.h.n) bxVar).aa());
                    }
                }
                if (byVar != null) {
                    aVar.b(byVar.G());
                    ad adVarY = byVar.Y();
                    if (adVarY != null) {
                        cg cgVar = adVarY.v;
                        aVar.c(cgVar != null ? cgVar.f() : "");
                    }
                    aVar.a(byVar.aK() > 0.0d ? byVar.aK() : byVar.K());
                    aVar.b(byVar.n());
                }
                aVar.d(s.b().r());
                aVar.a(System.currentTimeMillis());
                aVar.c(4);
                a(aVar, aTAdRequestB);
            }
        }
    }

    @Override // com.anythink.core.d.b.b
    public final List<com.anythink.core.d.a.a> a(int i, String str, int i2) {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.a(i, str, i2);
        }
        return null;
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.d.a.b bVarC = c(str);
        if (bVarC.b()) {
            return a(str, i, bVarC.a());
        }
        return null;
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (i == 4) {
                JSONArray jSONArrayB = b(4, str, i2);
                if (jSONArrayB != null) {
                    jSONObject.put("imp", jSONArrayB);
                }
            } else if (i == 10) {
                JSONArray jSONArrayB2 = b(10, str, i2);
                if (jSONArrayB2 != null) {
                    jSONObject.put("fill", jSONArrayB2);
                }
            } else {
                JSONArray jSONArrayB3 = b(10, str, i2);
                if (jSONArrayB3 != null) {
                    jSONObject.put("fill", jSONArrayB3);
                }
                JSONArray jSONArrayB4 = b(4, str, i2);
                if (jSONArrayB4 != null) {
                    jSONObject.put("imp", jSONArrayB4);
                }
                jSONObject.put("def_ecpm", String.valueOf(a(str, jSONArrayB4)));
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
        }
    }

    @Override // com.anythink.core.d.b.b
    public final void b(String str) {
        a(str, c(str));
    }

    @Override // com.anythink.core.d.b.b
    public final com.anythink.core.d.a.d a(String str, int i, g gVar) {
        a aVar = this.a;
        com.anythink.core.d.a.c cVar = aVar.a.get(str);
        int i2 = gVar.a() == 1 ? i : -1;
        if (cVar == null || !cVar.b(gVar) || cVar.a(i2) == null) {
            cVar = new com.anythink.core.d.a.c();
            cVar.a(gVar);
            int iC = gVar.c();
            long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (((gVar.b() * 24) * 60) * 60)) * 1000);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(jCurrentTimeMillis);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            cVar.a(i2, aVar.b.a(str, i2, calendar.getTimeInMillis(), iC));
            aVar.a.put(str, cVar);
        } else {
            cVar.c(i);
        }
        return cVar.b(i2);
    }

    private void a(com.anythink.core.d.a.a aVar, ATAdRequest aTAdRequest) {
        String strJ = aVar.j();
        com.anythink.core.d.a.b bVarC = c(strJ);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(aVar);
        }
        if (aVar.k() == 4) {
            a(strJ, bVarC, aTAdRequest);
        }
    }

    private boolean b(String str, int i) {
        com.anythink.core.d.a.b bVarC = c(str);
        boolean z = bVarC.c() || bVarC.h();
        Boolean bool = this.g.get(str);
        if (bool != null) {
            boolean zEquals = Boolean.TRUE.equals(bool);
            if (!z && zEquals) {
                d(str);
            }
        } else if (!z) {
            d(str);
        }
        this.g.put(str, Boolean.valueOf(z));
        return i == 4 ? bVarC.c() : z;
    }

    private double a(String str, JSONArray jSONArray) {
        com.anythink.core.d.a.b bVarC = c(str);
        if (!bVarC.e()) {
            return bVarC.g();
        }
        if (jSONArray == null) {
            return -1.0d;
        }
        try {
            if (jSONArray.length() > 0) {
                return jSONArray.getJSONObject(0).getDouble("ecpm");
            }
            return -1.0d;
        } catch (Exception unused) {
            return -1.0d;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    private void a(String str, com.anythink.core.d.a.b bVar, ATAdRequest aTAdRequest) {
        double[][] dArrF;
        if (bVar == null || (dArrF = bVar.f()) == null) {
            return;
        }
        if (bVar.e()) {
            a(str, aTAdRequest);
            return;
        }
        double[] dArrA = a(str, bVar);
        boolean z = false;
        double d = dArrA[0];
        boolean z2 = true;
        double d2 = dArrA[1];
        if (d == d2) {
            return;
        }
        double[] dArrA2 = d > 0.0d ? a(dArrF, d) : null;
        double[] dArrA3 = d2 > 0.0d ? a(dArrF, d2) : null;
        if (dArrA2 == null) {
            if (dArrA3 != null) {
                z = true;
            }
            z2 = z;
        } else if (dArrA3 != null) {
            if (dArrA2[0] != dArrA3[0] || dArrA2[1] != dArrA3[1]) {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            a(str, aTAdRequest);
        }
    }

    private JSONArray b(int i, String str, int i2) {
        List<com.anythink.core.d.a.a> listA = a(i, str, i2);
        if (listA == null || listA.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.anythink.core.d.a.a> it = listA.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().i());
        }
        return jSONArray;
    }

    private com.anythink.core.d.a.b c(String str) {
        l lVarB = this.c.b(str);
        com.anythink.core.d.a.b bVar = this.f.get(str);
        if (bVar == null) {
            bVar = new com.anythink.core.d.a.b();
            String strC = com.anythink.core.common.u.ad.c(s.b().g(), t.b.c, str, "");
            if (!TextUtils.isEmpty(strC)) {
                try {
                    bVar.a(Double.parseDouble(strC));
                } catch (Exception unused) {
                }
            }
            this.f.put(str, bVar);
        }
        if (lVarB != null) {
            bVar.a(lVarB.aS());
            bVar.a(lVarB.aV());
            bVar.b(lVarB.aU());
            bVar.c(lVarB.aX());
            bVar.d(lVarB.j() != null ? 1 : 2);
        }
        return bVar;
    }

    private void d(final String str) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bX, new Runnable() { // from class: com.anythink.core.d.b.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f.remove(str);
                d.this.d.a(str);
            }
        }));
    }

    private static com.anythink.core.d.a.a a(String str, String str2, int i, by byVar) {
        com.anythink.core.d.a.a aVar = new com.anythink.core.d.a.a();
        if (byVar != null) {
            aVar.b(byVar.G());
            ad adVarY = byVar.Y();
            if (adVarY != null) {
                cg cgVar = adVarY.v;
                aVar.c(cgVar != null ? cgVar.f() : "");
            }
            aVar.a(byVar.K());
            aVar.b(byVar.n());
        }
        aVar.a(str);
        aVar.d(s.b().r());
        aVar.a(System.currentTimeMillis());
        aVar.e(str2);
        aVar.c(10);
        aVar.a(i);
        return aVar;
    }

    private static com.anythink.core.d.a.a b(bx bxVar, by byVar) {
        com.anythink.core.d.a.a aVar = new com.anythink.core.d.a.a();
        if (bxVar != null) {
            aVar.a(bxVar.aR());
            aVar.e(bxVar.aQ());
            if (bxVar instanceof com.anythink.core.common.h.n) {
                aVar.a(((com.anythink.core.common.h.n) bxVar).aa());
            }
        }
        if (byVar != null) {
            aVar.b(byVar.G());
            ad adVarY = byVar.Y();
            if (adVarY != null) {
                cg cgVar = adVarY.v;
                aVar.c(cgVar != null ? cgVar.f() : "");
            }
            aVar.a(byVar.aK() > 0.0d ? byVar.aK() : byVar.K());
            aVar.b(byVar.n());
        }
        aVar.d(s.b().r());
        aVar.a(System.currentTimeMillis());
        aVar.c(4);
        return aVar;
    }

    private double[] a(String str, com.anythink.core.d.a.b bVar) {
        if (bVar == null || bVar.e()) {
            return new double[]{-1.0d, -1.0d};
        }
        double dA = this.e.a(bVar.d(), str);
        double dG = bVar.g();
        if (dG != dA) {
            bVar.a(dA);
            this.f.put(str, bVar);
            com.anythink.core.common.u.ad.b(s.b().g(), t.b.c, str, String.valueOf(dA));
        }
        return new double[]{dA, dG};
    }

    private static double[] a(double[][] dArr, double d) {
        for (double[] dArr2 : dArr) {
            if (dArr2.length == 2) {
                double d2 = dArr2[0];
                double d3 = dArr2[1];
                if (d >= d2 && d <= d3) {
                    return dArr2;
                }
            }
        }
        return null;
    }

    private void a(String str, ATAdRequest aTAdRequest) {
        s sVarB = s.b();
        this.c.a(this.c.f(str), sVarB.p(), sVarB.q(), str, null, null, 2, true, aTAdRequest, true, i.ad.g);
    }
}
