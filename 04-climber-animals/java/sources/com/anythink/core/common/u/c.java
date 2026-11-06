package com.anythink.core.common.u;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.o;
import com.anythink.core.common.m;
import com.anythink.core.common.m.v;
import com.anythink.core.common.q;
import com.anythink.core.common.u;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.p;
import com.anythink.core.common.w;
import com.anythink.core.d.l;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class c extends m<o> {
    private static volatile c g;

    private c(Context context) {
        super(context);
    }

    public static c a(Context context) {
        if (g == null) {
            synchronized (c.class) {
                if (g == null) {
                    g = new c(context);
                }
            }
        }
        return g;
    }

    public final void a(int i, bu buVar) {
        a(i, buVar, null, -1L);
    }

    public final void a(int i, bu buVar, bv bvVar) {
        a(i, buVar, bvVar, -1L);
    }

    public final void a(final int i, final bu buVar, final bv bvVar, final long j) {
        if (buVar == null) {
            return;
        }
        synchronized (buVar) {
            a(i, bvVar, true);
            e(i, buVar);
        }
        if (this.e != null) {
            this.e.post(new Runnable() { // from class: com.anythink.core.common.u.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    o oVarA = c.a(c.this, i, buVar, bvVar, j);
                    if (oVarA == null) {
                        return;
                    }
                    c.super.a(oVarA, c.b(i, buVar));
                }
            });
        }
    }

    private static void a(int i, bv bvVar, boolean z) {
        if (bvVar != null) {
            int iG = bvVar.g();
            if (z) {
                if (iG == 79 || (iG == 50 && bvVar.bg() == 1)) {
                    a(i, bvVar);
                    return;
                }
                return;
            }
            if (iG == 79) {
                return;
            }
            if (iG == 50 && bvVar.bg() == 1) {
                return;
            }
            a(i, bvVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00c8  */
    private o b(int i, bu buVar, bv bvVar, long j) {
        List<String> listS;
        List<com.anythink.core.common.h.c> listA;
        ad adVarR;
        a(i, bvVar, false);
        if (i == 4) {
            ad adVarR2 = bvVar != null ? bvVar.R() : null;
            if (adVarR2 != null) {
                com.anythink.core.b.d.c.a(adVarR2, true, adVarR2.getSortPrice(), true, false);
            }
            if (buVar instanceof n) {
                n nVar = (n) buVar;
                String strAI = nVar.aI();
                l lVarA = com.anythink.core.d.n.a(this.d).a(strAI);
                if (lVarA != null && (listS = lVarA.S()) != null && listS.size() != 0 && (listA = com.anythink.core.common.a.a().a(strAI)) != null) {
                    for (com.anythink.core.common.h.c cVar : listA) {
                        if (cVar != null && cVar.c() == 0) {
                            n nVarI = cVar.i();
                            bv unitGroupInfo = cVar.e().getUnitGroupInfo();
                            boolean zS = (!ak.b(unitGroupInfo) || unitGroupInfo.R() == null) ? false : unitGroupInfo.R().s();
                            if (listS.contains(String.valueOf(unitGroupInfo.g())) && !TextUtils.equals(nVar.x(), nVarI.x()) && (adVarR = unitGroupInfo.R()) != null) {
                                com.anythink.core.b.d.c.a(adVarR, false, p.a(bvVar), nVar.J() == 1, zS);
                            }
                        }
                    }
                }
            }
        }
        if (i == 4) {
            if (buVar instanceof n) {
                if (bvVar != null) {
                    n nVar2 = (n) buVar;
                    com.anythink.core.c.a.a().a(nVar2, bvVar);
                    if (bvVar.Q() && bvVar.aC() > 0.0d) {
                        nVar2.e(bvVar.aC());
                    }
                }
                n nVar3 = (n) buVar;
                if (nVar3.i() == 2) {
                    w.a().a(buVar.aI(), nVar3.a());
                }
                com.anythink.core.common.d.a().a(buVar.aI(), buVar.aJ(), nVar3.M());
            }
            com.anythink.core.c.b.a().a(buVar, bvVar);
        }
        if (i == 6 && (buVar instanceof n)) {
            com.anythink.core.common.d.a().b(buVar.aI(), buVar.aJ(), ((n) buVar).M());
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        o oVar = new o();
        oVar.a = i;
        oVar.b = buVar;
        oVar.c = j > 0 ? j : System.currentTimeMillis();
        q.a(t.b().g()).a(i, oVar, bVarB);
        if (4 == i && (buVar instanceof n)) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((n) buVar);
        }
        if (a(i, buVar, bVarB)) {
            return null;
        }
        return oVar;
    }

    private static boolean c(int i, bu buVar) {
        if (!(buVar instanceof n)) {
            return false;
        }
        n nVar = (n) buVar;
        if (nVar.Y() == 67) {
            return true;
        }
        if (nVar.Y() == 0 || TextUtils.isEmpty(buVar.aK())) {
            return false;
        }
        if (!TextUtils.isEmpty(nVar.au()) || !TextUtils.isEmpty(nVar.av())) {
            return true;
        }
        Map<String, String> mapA = com.anythink.core.d.d.a(t.b().g()).b(t.b().p()).a(i);
        if (mapA != null) {
            if (mapA.containsKey("0")) {
                String str = mapA.get("0");
                return !TextUtils.isEmpty(str) && str.contains(buVar.aK());
            }
            if (mapA.containsKey(String.valueOf(nVar.Y()))) {
                String str2 = mapA.get(String.valueOf(nVar.Y()));
                if (!TextUtils.isEmpty(str2) && str2.contains(buVar.aK())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void a(int i, bv bvVar) {
        if (i == 13) {
            ad adVarR = bvVar != null ? bvVar.R() : null;
            if (adVarR != null) {
                com.anythink.core.b.d.c.a(adVarR, bvVar, 1);
            }
        }
    }

    private void b(int i, bu buVar, bv bvVar) {
        n nVar;
        String strAI;
        l lVarA;
        List<String> listS;
        List<com.anythink.core.common.h.c> listA;
        ad adVarR;
        if (i == 4) {
            ad adVarR2 = bvVar != null ? bvVar.R() : null;
            if (adVarR2 != null) {
                com.anythink.core.b.d.c.a(adVarR2, true, adVarR2.getSortPrice(), true, false);
            }
            if (!(buVar instanceof n) || (lVarA = com.anythink.core.d.n.a(this.d).a((strAI = (nVar = (n) buVar).aI()))) == null || (listS = lVarA.S()) == null || listS.size() == 0 || (listA = com.anythink.core.common.a.a().a(strAI)) == null) {
                return;
            }
            for (com.anythink.core.common.h.c cVar : listA) {
                if (cVar != null && cVar.c() == 0) {
                    n nVarI = cVar.i();
                    bv unitGroupInfo = cVar.e().getUnitGroupInfo();
                    boolean zS = (!ak.b(unitGroupInfo) || unitGroupInfo.R() == null) ? false : unitGroupInfo.R().s();
                    if (listS.contains(String.valueOf(unitGroupInfo.g())) && !TextUtils.equals(nVar.x(), nVarI.x()) && (adVarR = unitGroupInfo.R()) != null) {
                        com.anythink.core.b.d.c.a(adVarR, false, p.a(bvVar), nVar.J() == 1, zS);
                    }
                }
            }
        }
    }

    private static boolean a(int i, bu buVar, com.anythink.core.d.b bVar) {
        if (t.b().z()) {
            return true;
        }
        String strAy = bVar.ay();
        if (!TextUtils.isEmpty(strAy) && (buVar instanceof n)) {
            try {
                JSONArray jSONArray = new JSONArray(strAy);
                int length = jSONArray.length();
                String strValueOf = String.valueOf(((n) buVar).Y());
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.equals(strValueOf, jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        Map<String, String> mapAw = bVar.aw();
        if (mapAw != null && mapAw.containsKey(String.valueOf(i))) {
            String str = mapAw.get(String.valueOf(i));
            if (!TextUtils.isEmpty(str)) {
                String strAK = buVar.aK();
                if (TextUtils.isEmpty(strAK) || str.contains(strAK)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void d(int i, bu buVar) {
        if (4 == i && (buVar instanceof n)) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((n) buVar);
        }
    }

    private static void e(int i, bu buVar) {
        if (buVar instanceof n) {
            if (i == 4) {
                n nVar = (n) buVar;
                nVar.m();
                u.a().b(buVar.aI(), buVar.aJ(), nVar.M());
            } else if (i == 6) {
                ((n) buVar).n();
            } else if (i == 10) {
                n nVar2 = (n) buVar;
                com.anythink.core.common.e.a(buVar.ay(), com.anythink.core.common.e.c, nVar2);
                a(buVar);
                e.b(nVar2, 1);
            } else if (i == 21) {
                t.b().S();
            }
            b.a().a(i, (n) buVar);
        }
    }

    @Override // com.anythink.core.common.m
    protected final void a(List<o> list) {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (bVarB != null) {
            int iF = bVarB.F();
            if (iF == 1) {
                com.anythink.core.common.m.d.f fVar = new com.anythink.core.common.m.d.f(list);
                fVar.a(1, bVarB.E());
                fVar.a((com.anythink.core.common.m.d.d.a) null);
                return;
            } else {
                if (iF == 2) {
                    new v(this.d, bVarB.F(), list).a(0, (com.anythink.core.common.m.q) null);
                    com.anythink.core.common.m.d.f fVar2 = new com.anythink.core.common.m.d.f(list);
                    fVar2.a(2, bVarB.E());
                    fVar2.a((com.anythink.core.common.m.d.d.a) null);
                    return;
                }
                new v(this.d, bVarB.F(), list).a(0, (com.anythink.core.common.m.q) null);
                return;
            }
        }
        new v(this.d, 0, list).a(0, (com.anythink.core.common.m.q) null);
    }

    private void a(n nVar, bv bvVar) {
        List<String> listS;
        List<com.anythink.core.common.h.c> listA;
        ad adVarR;
        String strAI = nVar.aI();
        l lVarA = com.anythink.core.d.n.a(this.d).a(strAI);
        if (lVarA == null || (listS = lVarA.S()) == null || listS.size() == 0 || (listA = com.anythink.core.common.a.a().a(strAI)) == null) {
            return;
        }
        for (com.anythink.core.common.h.c cVar : listA) {
            if (cVar != null && cVar.c() == 0) {
                n nVarI = cVar.i();
                bv unitGroupInfo = cVar.e().getUnitGroupInfo();
                boolean zS = (!ak.b(unitGroupInfo) || unitGroupInfo.R() == null) ? false : unitGroupInfo.R().s();
                if (listS.contains(String.valueOf(unitGroupInfo.g())) && !TextUtils.equals(nVar.x(), nVarI.x()) && (adVarR = unitGroupInfo.R()) != null) {
                    com.anythink.core.b.d.c.a(adVarR, false, p.a(bvVar), nVar.J() == 1, zS);
                }
            }
        }
    }

    private static void c(int i, bu buVar, bv bvVar) {
        if (i == 4) {
            if (buVar instanceof n) {
                if (bvVar != null) {
                    n nVar = (n) buVar;
                    com.anythink.core.c.a.a().a(nVar, bvVar);
                    if (bvVar.Q() && bvVar.aC() > 0.0d) {
                        nVar.e(bvVar.aC());
                    }
                }
                n nVar2 = (n) buVar;
                if (nVar2.i() == 2) {
                    w.a().a(buVar.aI(), nVar2.a());
                }
                com.anythink.core.common.d.a().a(buVar.aI(), buVar.aJ(), nVar2.M());
            }
            com.anythink.core.c.b.a().a(buVar, bvVar);
        }
    }

    private static void a(bu buVar) {
        if (buVar instanceof n) {
            e.b((n) buVar);
        }
    }

    static /* synthetic */ o a(c cVar, int i, bu buVar, bv bvVar, long j) {
        n nVar;
        String strAI;
        l lVarA;
        List<String> listS;
        List<com.anythink.core.common.h.c> listA;
        ad adVarR;
        a(i, bvVar, false);
        if (i == 4) {
            ad adVarR2 = bvVar != null ? bvVar.R() : null;
            if (adVarR2 != null) {
                com.anythink.core.b.d.c.a(adVarR2, true, adVarR2.getSortPrice(), true, false);
            }
            if ((buVar instanceof n) && (lVarA = com.anythink.core.d.n.a(cVar.d).a((strAI = (nVar = (n) buVar).aI()))) != null && (listS = lVarA.S()) != null && listS.size() != 0 && (listA = com.anythink.core.common.a.a().a(strAI)) != null) {
                for (com.anythink.core.common.h.c cVar2 : listA) {
                    if (cVar2 != null && cVar2.c() == 0) {
                        n nVarI = cVar2.i();
                        bv unitGroupInfo = cVar2.e().getUnitGroupInfo();
                        boolean zS = (!ak.b(unitGroupInfo) || unitGroupInfo.R() == null) ? false : unitGroupInfo.R().s();
                        if (listS.contains(String.valueOf(unitGroupInfo.g())) && !TextUtils.equals(nVar.x(), nVarI.x()) && (adVarR = unitGroupInfo.R()) != null) {
                            com.anythink.core.b.d.c.a(adVarR, false, p.a(bvVar), nVar.J() == 1, zS);
                        }
                    }
                }
            }
        }
        if (i == 4) {
            if (buVar instanceof n) {
                if (bvVar != null) {
                    n nVar2 = (n) buVar;
                    com.anythink.core.c.a.a().a(nVar2, bvVar);
                    if (bvVar.Q() && bvVar.aC() > 0.0d) {
                        nVar2.e(bvVar.aC());
                    }
                }
                n nVar3 = (n) buVar;
                if (nVar3.i() == 2) {
                    w.a().a(buVar.aI(), nVar3.a());
                }
                com.anythink.core.common.d.a().a(buVar.aI(), buVar.aJ(), nVar3.M());
            }
            com.anythink.core.c.b.a().a(buVar, bvVar);
        }
        if (i == 6 && (buVar instanceof n)) {
            com.anythink.core.common.d.a().b(buVar.aI(), buVar.aJ(), ((n) buVar).M());
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        o oVar = new o();
        oVar.a = i;
        oVar.b = buVar;
        oVar.c = j > 0 ? j : System.currentTimeMillis();
        q.a(t.b().g()).a(i, oVar, bVarB);
        if (4 == i && (buVar instanceof n)) {
            com.anythink.core.common.p.a();
            com.anythink.core.common.p.a((n) buVar);
        }
        if (a(i, buVar, bVarB)) {
            return null;
        }
        return oVar;
    }

    static /* synthetic */ boolean b(int i, bu buVar) {
        if (buVar instanceof n) {
            n nVar = (n) buVar;
            if (nVar.Y() == 67) {
                return true;
            }
            if (nVar.Y() != 0 && !TextUtils.isEmpty(buVar.aK())) {
                if (!TextUtils.isEmpty(nVar.au()) || !TextUtils.isEmpty(nVar.av())) {
                    return true;
                }
                Map<String, String> mapA = com.anythink.core.d.d.a(t.b().g()).b(t.b().p()).a(i);
                if (mapA != null) {
                    if (mapA.containsKey("0")) {
                        String str = mapA.get("0");
                        return !TextUtils.isEmpty(str) && str.contains(buVar.aK());
                    }
                    if (mapA.containsKey(String.valueOf(nVar.Y()))) {
                        String str2 = mapA.get(String.valueOf(nVar.Y()));
                        return !TextUtils.isEmpty(str2) && str2.contains(buVar.aK());
                    }
                }
            }
        }
        return false;
    }
}
