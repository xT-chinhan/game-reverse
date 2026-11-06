package com.anythink.core.c.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.v.af;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import com.umeng.analytics.pro.be;
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
    private final n c = n.a(t.b().g());
    private final e d;
    private final f e;
    private final ConcurrentHashMap<String, com.anythink.core.c.a.b> f;
    private final ConcurrentHashMap<String, Boolean> g;

    public d() {
        e eVarA = e.a();
        this.d = eVarA;
        this.e = new f(eVarA);
        this.f = new ConcurrentHashMap<>();
        this.g = new ConcurrentHashMap<>();
        this.a = new a(eVarA);
    }

    @Override // com.anythink.core.c.b.b
    public final void a(String str, String str2, int i, ATAdRequest aTAdRequest, bv bvVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ((bvVar == null || !bvVar.br()) && b(str, 10)) {
            com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
            if (bvVar != null) {
                aVar.b(bvVar.z());
                ad adVarR = bvVar.R();
                if (adVarR != null) {
                    cd cdVar = adVarR.v;
                    aVar.c(cdVar != null ? cdVar.f() : "");
                }
                aVar.a(bvVar.D());
                aVar.b(bvVar.g());
            }
            aVar.a(str2);
            aVar.d(t.b().r());
            aVar.a(System.currentTimeMillis());
            aVar.e(str);
            aVar.c(10);
            aVar.a(i);
            if (bvVar != null) {
                com.anythink.core.c.a.c cVar = this.a.a.get(str);
                new StringBuilder("insertOrUpdateLoadedUnitGroupInfo::placementId:").append(str).append("segmentId:").append(aVar.a()).append(":::").append(aVar);
                if (cVar != null) {
                    cVar.a(aVar);
                }
            }
            a(aVar, aTAdRequest);
        }
    }

    @Override // com.anythink.core.c.b.b
    public final void a(bu buVar, bv bvVar) {
        ATAdRequest aTAdRequestA;
        if (buVar == null || bvVar == null) {
            return;
        }
        if (bvVar == null || !bvVar.br()) {
            String strAI = buVar.aI();
            if (!TextUtils.isEmpty(strAI) && b(strAI, 4)) {
                try {
                    aTAdRequestA = ((com.anythink.core.common.h.n) buVar).a();
                } catch (Exception unused) {
                    aTAdRequestA = null;
                }
                com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
                if (buVar != null) {
                    aVar.a(buVar.aJ());
                    aVar.e(buVar.aI());
                    if (buVar instanceof com.anythink.core.common.h.n) {
                        aVar.a(((com.anythink.core.common.h.n) buVar).Z());
                    }
                }
                if (bvVar != null) {
                    aVar.b(bvVar.z());
                    ad adVarR = bvVar.R();
                    if (adVarR != null) {
                        cd cdVar = adVarR.v;
                        aVar.c(cdVar != null ? cdVar.f() : "");
                    }
                    aVar.a(bvVar.aC() > 0.0d ? bvVar.aC() : bvVar.D());
                    aVar.b(bvVar.g());
                }
                aVar.d(t.b().r());
                aVar.a(System.currentTimeMillis());
                aVar.c(4);
                a(aVar, aTAdRequestA);
            }
        }
    }

    @Override // com.anythink.core.c.b.b
    public final List<com.anythink.core.c.a.a> a(int i, String str, int i2) {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.a(i, str, i2);
        }
        return null;
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.c.a.b bVarC = c(str);
        if (bVarC.b()) {
            return a(str, i, bVarC.a());
        }
        return null;
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (i == 4) {
                JSONArray jSONArrayB = b(4, str, i2);
                if (jSONArrayB != null) {
                    jSONObject.put(be.c, jSONArrayB);
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
                    jSONObject.put(be.c, jSONArrayB4);
                }
                jSONObject.put("def_ecpm", String.valueOf(a(str, jSONArrayB4)));
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception e) {
            Object[] objArr = new Object[3];
            Integer.valueOf(i);
            e.getMessage();
            return null;
        }
    }

    @Override // com.anythink.core.c.b.b
    public final void b(String str) {
        a(str, c(str));
    }

    @Override // com.anythink.core.c.b.b
    public final com.anythink.core.c.a.d a(String str, int i, com.anythink.core.d.f fVar) {
        a aVar = this.a;
        com.anythink.core.c.a.c cVar = aVar.a.get(str);
        int i2 = fVar.a() == 1 ? i : -1;
        if (cVar == null || !cVar.b(fVar) || cVar.a(i2) == null) {
            cVar = new com.anythink.core.c.a.c();
            cVar.a(fVar);
            int iC = fVar.c();
            long jCurrentTimeMillis = System.currentTimeMillis() - (((long) (((fVar.b() * 24) * 60) * 60)) * 1000);
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

    private void a(com.anythink.core.c.a.a aVar, ATAdRequest aTAdRequest) {
        Object[] objArr = new Object[1];
        aVar.toString();
        String strJ = aVar.j();
        com.anythink.core.c.a.b bVarC = c(strJ);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(aVar);
        }
        if (aVar.k() == 4) {
            a(strJ, bVarC, aTAdRequest);
        }
    }

    private boolean b(String str, int i) {
        com.anythink.core.c.a.b bVarC = c(str);
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
        Object[] objArr = new Object[3];
        Boolean.valueOf(z);
        return i == 4 ? bVarC.c() : z;
    }

    private double a(String str, JSONArray jSONArray) {
        com.anythink.core.c.a.b bVarC = c(str);
        if (!bVarC.e()) {
            Object[] objArr = new Object[1];
            Double.valueOf(bVarC.g());
            return bVarC.g();
        }
        if (jSONArray == null) {
            return -1.0d;
        }
        try {
            if (jSONArray.length() <= 0) {
                return -1.0d;
            }
            double d = jSONArray.getJSONObject(0).getDouble("ecpm");
            Object[] objArr2 = new Object[1];
            Double.valueOf(d);
            return d;
        } catch (Exception e) {
            Object[] objArr3 = new Object[1];
            e.getMessage();
            return -1.0d;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    private void a(String str, com.anythink.core.c.a.b bVar, ATAdRequest aTAdRequest) {
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
        Object[] objArr = new Object[2];
        Double.valueOf(d);
        Double.valueOf(d2);
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
        List<com.anythink.core.c.a.a> listA = a(i, str, i2);
        if (listA == null || listA.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<com.anythink.core.c.a.a> it = listA.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().i());
        }
        return jSONArray;
    }

    private com.anythink.core.c.a.b c(String str) {
        l lVarB = this.c.b(str);
        com.anythink.core.c.a.b bVar = this.f.get(str);
        if (bVar == null) {
            bVar = new com.anythink.core.c.a.b();
            String strC = af.c(t.b().g(), u.b.b, str, "");
            Object[] objArr = new Object[2];
            if (!TextUtils.isEmpty(strC)) {
                try {
                    bVar.a(Double.parseDouble(strC));
                } catch (Exception e) {
                    Object[] objArr2 = new Object[2];
                    e.getMessage();
                }
            }
            this.f.put(str, bVar);
        }
        if (lVarB != null) {
            bVar.a(lVarB.aV());
            bVar.a(lVarB.aY());
            bVar.b(lVarB.aX());
            bVar.c(lVarB.bc());
            bVar.d(lVarB.j() != null ? 1 : 2);
        }
        return bVar;
    }

    private void d(final String str) {
        com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.c.b.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.f.remove(str);
                d.this.d.a(str);
            }
        }, 13);
    }

    private static com.anythink.core.c.a.a a(String str, String str2, int i, bv bvVar) {
        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
        if (bvVar != null) {
            aVar.b(bvVar.z());
            ad adVarR = bvVar.R();
            if (adVarR != null) {
                cd cdVar = adVarR.v;
                aVar.c(cdVar != null ? cdVar.f() : "");
            }
            aVar.a(bvVar.D());
            aVar.b(bvVar.g());
        }
        aVar.a(str);
        aVar.d(t.b().r());
        aVar.a(System.currentTimeMillis());
        aVar.e(str2);
        aVar.c(10);
        aVar.a(i);
        return aVar;
    }

    private static com.anythink.core.c.a.a b(bu buVar, bv bvVar) {
        com.anythink.core.c.a.a aVar = new com.anythink.core.c.a.a();
        if (buVar != null) {
            aVar.a(buVar.aJ());
            aVar.e(buVar.aI());
            if (buVar instanceof com.anythink.core.common.h.n) {
                aVar.a(((com.anythink.core.common.h.n) buVar).Z());
            }
        }
        if (bvVar != null) {
            aVar.b(bvVar.z());
            ad adVarR = bvVar.R();
            if (adVarR != null) {
                cd cdVar = adVarR.v;
                aVar.c(cdVar != null ? cdVar.f() : "");
            }
            aVar.a(bvVar.aC() > 0.0d ? bvVar.aC() : bvVar.D());
            aVar.b(bvVar.g());
        }
        aVar.d(t.b().r());
        aVar.a(System.currentTimeMillis());
        aVar.c(4);
        return aVar;
    }

    private double[] a(String str, com.anythink.core.c.a.b bVar) {
        if (bVar == null || bVar.e()) {
            return new double[]{-1.0d, -1.0d};
        }
        double dA = this.e.a(bVar.d(), str);
        double dG = bVar.g();
        Object[] objArr = new Object[2];
        Double.valueOf(dG);
        Double.valueOf(dA);
        if (dG != dA) {
            bVar.a(dA);
            this.f.put(str, bVar);
            af.b(t.b().g(), u.b.b, str, String.valueOf(dA));
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
        t tVarB = t.b();
        this.c.a(this.c.e(str), tVarB.p(), tVarB.q(), str, null, null, 2, true, aTAdRequest);
    }
}
