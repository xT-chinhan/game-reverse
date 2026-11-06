package com.anythink.core.common;

import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import com.anythink.core.common.h.as;
import com.anythink.core.common.h.ca;
import com.anythink.core.common.h.ce;
import com.anythink.core.common.u.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    String a;
    String b;
    f c;
    private List<com.anythink.core.common.d.a> f;
    private final String d = getClass().getSimpleName();
    private final Object e = new Object();
    private final com.anythink.core.common.d.a g = new com.anythink.core.common.d.a() { // from class: com.anythink.core.common.n.1
        @Override // com.anythink.core.common.d.a
        public final void onAdLoaded() {
            synchronized (n.this.e) {
                if (n.this.f != null) {
                    Iterator it = n.this.f.iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.d.a aVar = (com.anythink.core.common.d.a) it.next();
                        if (aVar != null) {
                            aa.a(n.this.a, String.valueOf(n.this.b), com.anythink.core.common.d.i.s.F, com.anythink.core.common.d.i.s.m, "[listener:" + aVar.toString() + "]");
                            aVar.onAdLoaded();
                            it.remove();
                        }
                    }
                }
            }
        }

        @Override // com.anythink.core.common.d.a
        public final void onAdLoadFail(AdError adError) {
            synchronized (n.this.e) {
                Iterator it = n.this.f.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.d.a aVar = (com.anythink.core.common.d.a) it.next();
                    if (aVar != null) {
                        aa.a(n.this.a, String.valueOf(n.this.b), com.anythink.core.common.d.i.s.F, com.anythink.core.common.d.i.s.n, "returned no eligible ads from any mediated networks. [listener:" + aVar.toString() + "]");
                        aVar.onAdLoadFail(adError);
                        it.remove();
                    }
                }
            }
        }
    };

    public final com.anythink.core.common.d.a a() {
        return this.g;
    }

    public n(f fVar) {
        this.c = fVar;
    }

    private void a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void a(com.anythink.core.common.d.a aVar) {
        synchronized (this.e) {
            if (this.f == null) {
                this.f = new ArrayList();
            }
            if (aVar == null) {
                return;
            }
            Iterator<com.anythink.core.common.d.a> it = this.f.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next() == aVar) {
                    z = true;
                }
            }
            if (!z) {
                this.f.add(aVar);
            }
        }
    }

    public final void b(com.anythink.core.common.d.a aVar) {
        synchronized (this.e) {
            List<com.anythink.core.common.d.a> list = this.f;
            if (list == null) {
                return;
            }
            list.remove(aVar);
        }
    }

    public final void a(int i, as asVar, ce ceVar, int i2) {
        boolean zO;
        com.anythink.core.e.l lVarE;
        f fVar;
        com.anythink.core.e.l lVarA;
        com.anythink.core.e.l lVarA2;
        f fVar2;
        if (ceVar != null && i2 != 10 && (lVarA2 = ceVar.a()) != null) {
            if (lVarA2.q() != 1) {
                f fVar3 = this.c;
                if (fVar3 != null) {
                    fVar3.a(new ca(System.currentTimeMillis(), ceVar.m()), lVarA2);
                }
            } else if (i == 1 && (fVar2 = this.c) != null) {
                fVar2.a(new ca(System.currentTimeMillis(), ceVar.m()), lVarA2);
            }
        }
        f fVar4 = this.c;
        if (fVar4 != null) {
            fVar4.j();
        }
        f fVar5 = this.c;
        boolean z = (i2 == 13 || (lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(this.a)) == null || fVar5 == null || ATAdxSetting.getInstance().isAdxNetworkMode(this.a) || lVarA.q() != 1 || fVar5.h() >= lVarA.r()) ? false : true;
        this.g.onAdLoaded();
        if (asVar.c != 9 && i != 3 && z && this.c != null) {
            as asVarC = asVar.c();
            asVarC.c = 9;
            asVarC.e = null;
            asVarC.d = null;
            this.c.a(com.anythink.core.common.d.s.b().g(), this.b, this.a, asVarC, (com.anythink.core.common.d.a) null);
        }
        if (i == 1 && asVar.e() && (fVar = this.c) != null && fVar.j != null) {
            fVar.j.c();
        }
        if (asVar != null && !asVar.d()) {
            if (ceVar == null) {
                zO = i == 3;
            } else {
                zO = ceVar.o();
            }
            if (zO) {
                com.anythink.core.e.n nVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g());
                lVarE = nVarA.e(this.a);
                if (lVarE == null) {
                    lVarE = nVarA.f(this.a);
                }
                zO = lVarE != null && lVarE.aZ();
            } else {
                lVarE = null;
            }
            if (zO) {
                int i3 = lVarE.aQ() ? 13 : 14;
                if (this.c != null) {
                    as asVarC2 = asVar.c();
                    asVarC2.c = i3;
                    asVarC2.e = null;
                    asVarC2.d = null;
                    this.c.a(asVar.a(), this.b, this.a, asVarC2, (com.anythink.core.common.d.a) null);
                }
            }
        }
        a(ceVar, asVar);
    }

    public final void a(int i, final as asVar, ce ceVar, AdError adError) {
        boolean zIsMgWin;
        f fVar;
        try {
            zIsMgWin = asVar.b().getPreLoadInfo().getMgComparedResult().isMgWin();
        } catch (Throwable unused) {
            zIsMgWin = false;
        }
        if (ceVar != null && i == 2 && ceVar.b() && !zIsMgWin) {
            if (this.c != null && !t.a().a(this.a)) {
                com.anythink.core.common.d.s.b();
                com.anythink.core.common.d.s.b(new Runnable() { // from class: com.anythink.core.common.n.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        as asVarC = asVar.c();
                        asVarC.c = 8;
                        asVarC.e = null;
                        asVarC.d = null;
                        n.this.c.a(com.anythink.core.common.d.s.b().g(), n.this.b, n.this.a, asVarC, (com.anythink.core.common.d.a) null);
                    }
                }, ceVar.c());
            }
        } else {
            if (i != 3 && (fVar = this.c) != null) {
                fVar.k();
            }
            this.g.onAdLoadFail(adError);
        }
        if (this.c != null && asVar.e()) {
            this.c.a(adError);
        }
        if (i != 2 && ATSDK.isNetworkLogDebug()) {
            Log.e("anythink", "ad load failed: " + this.a + ", " + adError.printStackTrace());
        }
        a(ceVar, asVar);
    }

    private static void a(ce ceVar, as asVar) {
        com.anythink.core.e.b bVarB;
        com.anythink.core.common.q.g gVarG;
        if (ceVar == null || (bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p())) == null || (gVarG = bVarB.g()) == null || !v.a().a(ceVar.a())) {
            return;
        }
        v.a().a(gVarG, ceVar.a(), asVar);
    }

    private boolean a(f fVar, int i) {
        com.anythink.core.e.l lVarA;
        return (i == 13 || (lVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g()).a(this.a)) == null || fVar == null || ATAdxSetting.getInstance().isAdxNetworkMode(this.a) || lVarA.q() != 1 || fVar.h() >= lVarA.r()) ? false : true;
    }

    private void a(int i, as asVar, ce ceVar) {
        boolean zO;
        com.anythink.core.e.l lVarE;
        if (asVar == null || asVar.d()) {
            return;
        }
        if (ceVar == null) {
            zO = i == 3;
        } else {
            zO = ceVar.o();
        }
        if (zO) {
            com.anythink.core.e.n nVarA = com.anythink.core.e.n.a(com.anythink.core.common.d.s.b().g());
            lVarE = nVarA.e(this.a);
            if (lVarE == null) {
                lVarE = nVarA.f(this.a);
            }
            zO = lVarE != null && lVarE.aZ();
        } else {
            lVarE = null;
        }
        if (zO) {
            int i2 = lVarE.aQ() ? 13 : 14;
            if (this.c != null) {
                as asVarC = asVar.c();
                asVarC.c = i2;
                asVarC.e = null;
                asVarC.d = null;
                this.c.a(asVar.a(), this.b, this.a, asVarC, (com.anythink.core.common.d.a) null);
            }
        }
    }
}
