package com.anythink.core.common.t.c;

import android.text.TextUtils;
import com.anythink.core.common.d;
import com.anythink.core.common.d.s;
import com.anythink.core.common.e;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.c;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.o;
import com.anythink.core.common.p;
import com.anythink.core.common.q;
import com.anythink.core.common.t;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.v;
import com.anythink.core.e.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static o a(int i, bx bxVar, by byVar, long j) {
        n nVar;
        String strAQ;
        l lVarA;
        List<String> listT;
        f fVarA;
        List<c> listA;
        ad adVarY;
        a(i, byVar, false);
        if (i == 4) {
            ad adVarY2 = byVar != null ? byVar.Y() : null;
            if (adVarY2 != null) {
                com.anythink.core.c.d.c.a(adVarY2, true, adVarY2.getSortPrice(), true, false, byVar);
            }
            if ((bxVar instanceof n) && (lVarA = com.anythink.core.e.n.a(s.b().g()).a((strAQ = (nVar = (n) bxVar).aQ()))) != null && (listT = lVarA.T()) != null && listT.size() != 0 && (fVarA = nVar.a()) != null && (listA = fVarA.e().a(strAQ)) != null) {
                for (c cVar : listA) {
                    if (cVar != null && cVar.c() == 0) {
                        n nVarI = cVar.i();
                        by unitGroupInfo = cVar.e().getUnitGroupInfo();
                        boolean zR = (!aj.b(unitGroupInfo) || unitGroupInfo.Y() == null) ? false : unitGroupInfo.Y().r();
                        if (listT.contains(String.valueOf(unitGroupInfo.n())) && !TextUtils.equals(nVar.y(), nVarI.y()) && (adVarY = unitGroupInfo.Y()) != null) {
                            com.anythink.core.c.d.c.a(adVarY, false, com.anythink.core.common.u.o.a(byVar), nVar.K() == 1, zR, unitGroupInfo);
                        }
                    }
                }
            }
        }
        if (i == 4) {
            if (bxVar instanceof n) {
                if (byVar != null) {
                    n nVar2 = (n) bxVar;
                    com.anythink.core.d.a.a().a(nVar2, byVar);
                    if (byVar.X() && byVar.aK() > 0.0d) {
                        nVar2.e(byVar.aK());
                    }
                }
                n nVar3 = (n) bxVar;
                if (nVar3.j() == 2) {
                    v.a().a(bxVar.aQ(), nVar3.b());
                }
                d.a().a(bxVar.aQ(), bxVar.aR(), nVar3.N());
            }
            com.anythink.core.d.b.a().a(bxVar, byVar);
        }
        if (i == 6 && (bxVar instanceof n)) {
            d.a().b(bxVar.aQ(), bxVar.aR(), ((n) bxVar).N());
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        o oVar = new o();
        oVar.a = i;
        oVar.b = bxVar;
        oVar.c = j > 0 ? j : System.currentTimeMillis();
        q.a(s.b().g()).a(i, oVar, bVarB);
        if (4 == i && (bxVar instanceof n)) {
            p.a();
            p.a((n) bxVar);
        }
        return oVar;
    }

    public static void a(int i, by byVar, boolean z) {
        if (byVar != null) {
            int iN = byVar.n();
            if (z) {
                if (iN == 79 || (iN == 50 && byVar.bo() == 1)) {
                    a(i, byVar);
                    return;
                }
                return;
            }
            if (iN == 79) {
                return;
            }
            if (iN == 50 && byVar.bo() == 1) {
                return;
            }
            a(i, byVar);
        }
    }

    private static void a(int i, by byVar) {
        if (i == 13) {
            ad adVarY = byVar != null ? byVar.Y() : null;
            if (adVarY != null) {
                com.anythink.core.c.d.c.a(adVarY, byVar, 1);
            }
        }
    }

    private static void a(int i, bx bxVar, by byVar) {
        n nVar;
        String strAQ;
        l lVarA;
        List<String> listT;
        f fVarA;
        List<c> listA;
        ad adVarY;
        if (i == 4) {
            ad adVarY2 = byVar != null ? byVar.Y() : null;
            if (adVarY2 != null) {
                com.anythink.core.c.d.c.a(adVarY2, true, adVarY2.getSortPrice(), true, false, byVar);
            }
            if (!(bxVar instanceof n) || (lVarA = com.anythink.core.e.n.a(s.b().g()).a((strAQ = (nVar = (n) bxVar).aQ()))) == null || (listT = lVarA.T()) == null || listT.size() == 0 || (fVarA = nVar.a()) == null || (listA = fVarA.e().a(strAQ)) == null) {
                return;
            }
            for (c cVar : listA) {
                if (cVar != null && cVar.c() == 0) {
                    n nVarI = cVar.i();
                    by unitGroupInfo = cVar.e().getUnitGroupInfo();
                    boolean zR = (!aj.b(unitGroupInfo) || unitGroupInfo.Y() == null) ? false : unitGroupInfo.Y().r();
                    if (listT.contains(String.valueOf(unitGroupInfo.n())) && !TextUtils.equals(nVar.y(), nVarI.y()) && (adVarY = unitGroupInfo.Y()) != null) {
                        com.anythink.core.c.d.c.a(adVarY, false, com.anythink.core.common.u.o.a(byVar), nVar.K() == 1, zR, unitGroupInfo);
                    }
                }
            }
        }
    }

    private static void b(int i, bx bxVar) {
        if (4 == i && (bxVar instanceof n)) {
            p.a();
            p.a((n) bxVar);
        }
    }

    public static void a(int i, bx bxVar) {
        boolean z = bxVar instanceof n;
        if (z) {
            if (i == 4) {
                n nVar = (n) bxVar;
                nVar.n();
                t.a().a(bxVar.aQ(), bxVar.aR(), nVar.N());
            } else if (i == 6) {
                ((n) bxVar).o();
            } else if (i == 10) {
                n nVar2 = (n) bxVar;
                e.a(bxVar.aG(), e.c, nVar2);
                if (z) {
                    com.anythink.core.common.t.f.b(nVar2);
                }
                com.anythink.core.common.t.f.b(nVar2, 1);
            } else if (i == 21) {
                s.b().S();
            }
            com.anythink.core.common.t.d.a().a(i, (n) bxVar);
        }
    }

    private static void a(n nVar, by byVar) {
        List<String> listT;
        f fVarA;
        List<c> listA;
        ad adVarY;
        String strAQ = nVar.aQ();
        l lVarA = com.anythink.core.e.n.a(s.b().g()).a(strAQ);
        if (lVarA == null || (listT = lVarA.T()) == null || listT.size() == 0 || (fVarA = nVar.a()) == null || (listA = fVarA.e().a(strAQ)) == null) {
            return;
        }
        for (c cVar : listA) {
            if (cVar != null && cVar.c() == 0) {
                n nVarI = cVar.i();
                by unitGroupInfo = cVar.e().getUnitGroupInfo();
                boolean zR = (!aj.b(unitGroupInfo) || unitGroupInfo.Y() == null) ? false : unitGroupInfo.Y().r();
                if (listT.contains(String.valueOf(unitGroupInfo.n())) && !TextUtils.equals(nVar.y(), nVarI.y()) && (adVarY = unitGroupInfo.Y()) != null) {
                    com.anythink.core.c.d.c.a(adVarY, false, com.anythink.core.common.u.o.a(byVar), nVar.K() == 1, zR, unitGroupInfo);
                }
            }
        }
    }

    private static void b(int i, bx bxVar, by byVar) {
        if (i == 4) {
            if (bxVar instanceof n) {
                if (byVar != null) {
                    n nVar = (n) bxVar;
                    com.anythink.core.d.a.a().a(nVar, byVar);
                    if (byVar.X() && byVar.aK() > 0.0d) {
                        nVar.e(byVar.aK());
                    }
                }
                n nVar2 = (n) bxVar;
                if (nVar2.j() == 2) {
                    v.a().a(bxVar.aQ(), nVar2.b());
                }
                d.a().a(bxVar.aQ(), bxVar.aR(), nVar2.N());
            }
            com.anythink.core.d.b.a().a(bxVar, byVar);
        }
    }

    private static void a(bx bxVar) {
        if (bxVar instanceof n) {
            com.anythink.core.common.t.f.b((n) bxVar);
        }
    }
}
