package com.anythink.core.common.b;

import android.content.Context;
import com.anythink.core.common.d.s;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import com.varbto.utils.api.MediationUtilsManager;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final int a = 2;
    public static final int b = 7;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    private static final String j = "AnrDynamicManager";
    private static volatile f k = null;
    private static final int m = 2;
    private static final int n = 1;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 4;
    private static final int s = 2;
    private static final int t = 0;
    private static final int u = 1;
    private a x;
    private volatile int[] y;
    private ConcurrentHashMap<String, Integer> v = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, d> w = new ConcurrentHashMap<>();
    private volatile boolean l = false;

    public static f a() {
        if (k == null) {
            synchronized (f.class) {
                if (k == null) {
                    k = new f();
                }
            }
        }
        return k;
    }

    private f() {
    }

    public static boolean b() {
        com.anythink.core.e.b bVarU = u();
        return bVarU != null && bVarU.ba() == 1;
    }

    public static int c() {
        com.anythink.core.e.b bVarU = u();
        if (bVarU == null) {
            return 2;
        }
        return bVarU.ba();
    }

    private static int l() {
        com.anythink.core.e.b bVarU = u();
        if (bVarU == null) {
            return 2;
        }
        return bVarU.bb();
    }

    private static b m() {
        com.anythink.core.e.b bVarU = u();
        if (bVarU == null) {
            return null;
        }
        return bVarU.bc();
    }

    private static List<a> n() {
        com.anythink.core.e.b bVarU = u();
        if (bVarU == null) {
            return null;
        }
        return bVarU.bd();
    }

    private static h o() {
        a aVarD = d();
        if (aVarD != null) {
            return aVarD.c();
        }
        return null;
    }

    private static int p() {
        a aVarD = d();
        if (aVarD != null) {
            return aVarD.b();
        }
        return 1;
    }

    public static a d() {
        List<a> listN;
        a aVarA;
        if (!b() || (listN = n()) == null || listN.isEmpty()) {
            return null;
        }
        s sVarB = s.b();
        int iAb = sVarB.ab();
        b bVarM = m();
        boolean z = bVarM != null && iAb > bVarM.b();
        int iL = l();
        int iAd = sVarB.ad();
        boolean zAe = sVarB.ae();
        if (z && iL == 3) {
            return b(listN);
        }
        if (z && iL == 2) {
            return a(listN);
        }
        if (zAe) {
            aVarA = a(listN);
        } else {
            aVarA = a(listN, iAd);
        }
        if (aVarA == null) {
            return null;
        }
        return aVarA;
    }

    private static a a(List<a> list, int i2) {
        for (a aVar : list) {
            int[] iArrA = aVar.a();
            if (iArrA != null && iArrA.length >= 2 && i2 >= iArrA[0] && i2 <= iArrA[1]) {
                return aVar;
            }
        }
        return null;
    }

    private static a a(List<a> list) {
        int i2;
        a aVar = null;
        int i3 = Integer.MAX_VALUE;
        for (a aVar2 : list) {
            int[] iArrA = aVar2.a();
            if (iArrA != null && iArrA.length >= 2 && ((i2 = iArrA[0]) > 0 || iArrA[1] > 0)) {
                if (i2 < i3) {
                    aVar = aVar2;
                    i3 = i2;
                }
            }
        }
        return aVar;
    }

    private static a b(List<a> list) {
        for (a aVar : list) {
            int[] iArrA = aVar.a();
            if (iArrA != null && iArrA.length >= 2 && iArrA[0] == 0 && iArrA[1] == 0) {
                return aVar;
            }
        }
        return null;
    }

    private static int q() {
        b bVarM = m();
        if (bVarM == null) {
            return 7;
        }
        return bVarM.a();
    }

    private static int r() {
        b bVarM = m();
        if (bVarM == null) {
            return 2;
        }
        return bVarM.b();
    }

    public final boolean e() {
        return this.l;
    }

    public final void f() {
        if (!b()) {
            this.l = false;
            try {
                s sVarB = s.b();
                Context contextG = sVarB != null ? sVarB.g() : null;
                if (contextG != null) {
                    MediationUtilsManager.getInstance(contextG).stopMonitoring();
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        int iAb = s.b().ab();
        b bVarM = m();
        if (bVarM == null) {
            this.l = false;
            return;
        }
        if (iAb <= bVarM.b()) {
            this.l = false;
            return;
        }
        int iL = l();
        if (iL == 1) {
            this.l = false;
            return;
        }
        if (iL == 2) {
            this.l = false;
            return;
        }
        if (iL == 3) {
            this.l = false;
        } else if (iL == 4) {
            this.l = true;
        } else {
            this.l = false;
        }
    }

    private void s() {
        this.l = false;
    }

    private void t() {
        this.l = false;
    }

    public static int g() {
        return s.b().ab();
    }

    public static int h() {
        return s.b().ac();
    }

    public static int i() {
        return s.b().ad();
    }

    public final a j() {
        h hVarC;
        this.x = null;
        a aVarD = d();
        if (aVarD != null) {
            this.x = aVarD;
            if (aVarD != null && (hVarC = aVarD.c()) != null) {
                int[] iArrA = aVarD.a();
                int[] iArr = this.y;
                boolean z = false;
                if (iArr != null && iArrA != null && iArr.length >= 2 && iArrA.length >= 2 && iArr[0] == iArrA[0] && iArr[1] == iArrA[1]) {
                    z = true;
                }
                if (!z && (hVarC.a() != null || hVarC.b() != null || hVarC.c() != null || hVarC.d() != null || hVarC.e() != null || hVarC.f() != null)) {
                    this.y = iArrA;
                    com.anythink.core.common.u.b.c.a().a(hVarC);
                }
            }
        }
        return this.x;
    }

    private static boolean a(int[] iArr, int[] iArr2) {
        return iArr != null && iArr2 != null && iArr.length >= 2 && iArr2.length >= 2 && iArr[0] == iArr2[0] && iArr[1] == iArr2[1];
    }

    public final void k() {
        this.y = null;
    }

    private void a(a aVar) {
        h hVarC;
        if (aVar == null || (hVarC = aVar.c()) == null) {
            return;
        }
        int[] iArrA = aVar.a();
        int[] iArr = this.y;
        boolean z = false;
        if (iArr != null && iArrA != null && iArr.length >= 2 && iArrA.length >= 2 && iArr[0] == iArrA[0] && iArr[1] == iArrA[1]) {
            z = true;
        }
        if (z) {
            return;
        }
        if (hVarC.a() == null && hVarC.b() == null && hVarC.c() == null && hVarC.d() == null && hVarC.e() == null && hVarC.f() == null) {
            return;
        }
        this.y = iArrA;
        com.anythink.core.common.u.b.c.a().a(hVarC);
    }

    private int b(String str) {
        Integer num = this.v.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final d a(String str) {
        return this.w.get(str);
    }

    public final int a(String str, l lVar) {
        this.w.remove(str);
        if (this.l) {
            this.v.put(str, 3);
            return 3;
        }
        d dVarB = b(lVar);
        if (dVarB != null) {
            this.w.put(str, dVarB);
        }
        return this.v.getOrDefault(str, 0).intValue();
    }

    public final c a(l lVar) {
        d dVarB = b(lVar);
        if (dVarB != null) {
            return dVarB.b();
        }
        return null;
    }

    public final d b(l lVar) {
        d dVarB;
        if (lVar == null) {
            return null;
        }
        String strI = lVar.i();
        boolean z = false;
        this.v.put(strI, 0);
        if (!b()) {
            return null;
        }
        List<d> listBd = lVar != null ? lVar.bd() : null;
        if (listBd == null || listBd.isEmpty()) {
            return null;
        }
        s sVarB = s.b();
        int iAb = sVarB.ab();
        b bVarM = m();
        if (bVarM != null && iAb > bVarM.b()) {
            z = true;
        }
        int iL = l();
        int iAd = sVarB.ad();
        boolean zAe = sVarB.ae();
        if (z && iL == 3) {
            this.v.put(strI, 2);
            return d(listBd);
        }
        if (z && iL == 2) {
            this.v.put(strI, 1);
            return c(listBd);
        }
        if (zAe) {
            dVarB = c(listBd);
        } else {
            dVarB = b(listBd, iAd);
        }
        if (dVarB == null) {
            return null;
        }
        this.v.put(strI, Integer.valueOf(zAe ? 4 : 5));
        return dVarB;
    }

    private static d b(List<d> list, int i2) {
        int i3;
        for (d dVar : list) {
            int[] iArrA = dVar.a();
            if (iArrA != null && iArrA.length >= 2 && ((i3 = iArrA[0]) != 0 || iArrA[1] != 0)) {
                if (i2 >= i3 && i2 <= iArrA[1]) {
                    return dVar;
                }
            }
        }
        return null;
    }

    private static d c(List<d> list) {
        int i2;
        d dVar = null;
        int i3 = Integer.MAX_VALUE;
        for (d dVar2 : list) {
            int[] iArrA = dVar2.a();
            if (iArrA != null && iArrA.length >= 2 && ((i2 = iArrA[0]) > 0 || iArrA[1] > 0)) {
                if (i2 < i3) {
                    dVar = dVar2;
                    i3 = i2;
                }
            }
        }
        return dVar;
    }

    private static d d(List<d> list) {
        for (d dVar : list) {
            int[] iArrA = dVar.a();
            if (iArrA != null && iArrA.length >= 2 && iArrA[0] == 0 && iArrA[1] == 0) {
                return dVar;
            }
        }
        return null;
    }

    private static l c(String str) {
        s sVarB = s.b();
        if (sVarB.g() == null) {
            return null;
        }
        return n.a(sVarB.g()).a(str);
    }

    private static com.anythink.core.e.b u() {
        s sVarB = s.b();
        if (sVarB.g() == null) {
            return null;
        }
        return com.anythink.core.e.d.a(sVarB.g()).b(sVarB.p());
    }

    private static void v() {
        try {
            s sVarB = s.b();
            Context contextG = sVarB != null ? sVarB.g() : null;
            if (contextG != null) {
                MediationUtilsManager.getInstance(contextG).stopMonitoring();
            }
        } catch (Throwable unused) {
        }
    }
}
