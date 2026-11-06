package com.anythink.core.common.v;

import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bs;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.ce;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.k;
import com.anythink.core.common.u.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final String a = com.anythink.core.common.q.g.a;
    final int b;
    int c;
    long d;
    cc p;
    bs q;
    i r;
    ac s;
    ac t;
    double u;
    ce v;
    private List<by> w;
    private Double x;
    volatile int l = 0;
    volatile int m = 0;
    volatile int n = 0;
    volatile int o = 0;
    List<by> e = Collections.synchronizedList(new ArrayList(5));
    List<by> f = Collections.synchronizedList(new ArrayList(5));
    List<by> g = Collections.synchronizedList(new ArrayList(2));
    List<f> h = Collections.synchronizedList(new ArrayList(2));
    List<by> k = Collections.synchronizedList(new ArrayList(2));
    List<by> i = Collections.synchronizedList(new ArrayList(2));
    List<by> j = Collections.synchronizedList(new ArrayList(2));

    public g(h hVar, j jVar) {
        this.c = 1;
        this.e.addAll(hVar.d);
        this.i.addAll(hVar.f);
        this.j.addAll(hVar.g);
        this.u = hVar.h;
        this.k.addAll(hVar.p);
        this.r = hVar.l;
        this.s = hVar.n;
        this.t = hVar.o;
        this.v = hVar.c;
        this.b = hVar.c.g();
        this.c = hVar.c.e();
        this.d = hVar.c.i();
        List<by> list = hVar.e;
        if (list != null) {
            this.g.addAll(list);
        }
        this.w = Collections.synchronizedList(new ArrayList(3));
        this.p = hVar.k;
        this.q = hVar.m;
        a(hVar, jVar);
    }

    private void a(h hVar, j jVar) {
        for (by byVar : hVar.d) {
            if (byVar.w()) {
                if (jVar != null) {
                    jVar.d = true;
                }
                e(byVar);
            }
        }
    }

    public final i a() {
        return this.r;
    }

    public final ac b() {
        return this.s;
    }

    private List<by> w() {
        return this.e;
    }

    public final int c() {
        return this.e.size();
    }

    private by x() {
        if (this.e.size() > 0) {
            return this.e.get(0);
        }
        return null;
    }

    private List<by> y() {
        return this.f;
    }

    public final void a(List<by> list) {
        this.f.addAll(list);
    }

    public final void a(by byVar) {
        this.f.add(byVar);
    }

    public final int d() {
        return this.f.size();
    }

    public final void b(by byVar) {
        this.f.remove(byVar);
    }

    public final void c(by byVar) {
        this.k.remove(byVar);
    }

    public final void b(List<by> list) {
        this.k.addAll(list);
    }

    private List<by> z() {
        return this.g;
    }

    public final int e() {
        return this.g.size();
    }

    public final by f() {
        return this.g.remove(0);
    }

    public final boolean g() {
        return this.g.size() == 0 && this.e.size() == 0;
    }

    public final void h() {
        this.g.clear();
    }

    public final void a(by byVar, int i) {
        synchronized (this.h) {
            Iterator<f> it = this.h.iterator();
            int i2 = 0;
            while (it.hasNext() && k.a(it.next().a, byVar) < 0) {
                i2++;
            }
            this.h.add(i2, new f(byVar, i));
        }
    }

    private by A() {
        by byVar;
        f fVar;
        synchronized (this.h) {
            byVar = (this.h.size() <= 0 || (fVar = this.h.get(0)) == null) ? null : fVar.a;
        }
        return byVar;
    }

    private int B() {
        return this.h.size();
    }

    public final List<f> i() {
        return this.h;
    }

    public final boolean j() {
        List<by> list = this.i;
        if (list == null && this.j == null) {
            return true;
        }
        return list.size() == 0 && this.j.size() == 0;
    }

    public final List<by> k() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.addAll(this.i);
        arrayList.addAll(this.j);
        this.i.clear();
        this.j.clear();
        return arrayList;
    }

    public final int l() {
        return this.l;
    }

    public final int m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final cc o() {
        return this.p;
    }

    public final bs p() {
        return this.q;
    }

    public final ac q() {
        return this.t;
    }

    private int C() {
        return this.v.f();
    }

    public final List<by> r() {
        List<by> arrayList;
        int i = this.c;
        if (i == 1 || i == 3) {
            arrayList = new ArrayList<>();
            int iMin = Math.min(this.v.f(), this.e.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                arrayList.add(this.e.get(i2));
            }
        } else {
            arrayList = i == 2 ? b(1) : null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.e.removeAll(arrayList);
        }
        return arrayList;
    }

    public static String c(List<by> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            str = str + new StringBuilder().append(list.get(i).n()).toString();
        }
        return str;
    }

    public final void a(int i, int i2) {
        this.l += i;
        if (i2 == 2) {
            this.n += i;
        } else {
            this.m += i;
        }
    }

    public final void a(int i) {
        if (this.c == 2 && i == 1) {
            this.o--;
        }
    }

    public final List<by> b(int i) {
        List<by> list;
        int iMin;
        if (i == 2) {
            list = this.g;
        } else {
            list = this.e;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            int i2 = 0;
            by byVar = list.get(0);
            if (i == 2) {
                arrayList.add(byVar);
            } else {
                by byVarA = a(true);
                int i3 = this.c;
                if (i3 != 1) {
                    if (i3 == 2) {
                        boolean z = k.a(byVar, byVarA) < 0;
                        if (this.o == 0 && z) {
                            double dA = o.a(byVar);
                            int size = list.size();
                            while (i2 < size) {
                                by byVar2 = list.get(i2);
                                if (o.a(byVar2) == dA) {
                                    arrayList.add(byVar2);
                                }
                                i2++;
                            }
                            this.o = arrayList.size();
                        }
                    } else if (i3 == 3 && this.m == 0 && (iMin = Math.min(this.v.f(), list.size())) > 0) {
                        while (i2 < iMin) {
                            by byVar3 = list.get(i2);
                            if (k.a(byVar3, byVarA) >= 0) {
                                break;
                            }
                            arrayList.add(byVar3);
                            i2++;
                        }
                    }
                } else {
                    int iMin2 = Math.min(this.v.f() - this.m, list.size());
                    if (iMin2 > 0) {
                        while (i2 < iMin2) {
                            by byVar4 = list.get(i2);
                            if (k.a(byVar4, byVarA) >= 0) {
                                break;
                            }
                            arrayList.add(byVar4);
                            i2++;
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
        return arrayList;
    }

    public final void d(by byVar) {
        i iVar = this.r;
        if (iVar != null) {
            iVar.a(byVar);
        }
    }

    public final void e(by byVar) {
        ad adVarY;
        if (byVar == null || !byVar.w() || (adVarY = byVar.Y()) == null) {
            return;
        }
        adVarY.a(this.s);
    }

    public final void f(by byVar) {
        ad adVarZ;
        if (byVar == null || !byVar.w() || (adVarZ = byVar.Z()) == null) {
            return;
        }
        adVarZ.a(this.s);
    }

    public static void a(by byVar, n nVar) {
        ad adVarZ;
        if (byVar == null || !byVar.w() || (adVarZ = byVar.Z()) == null) {
            return;
        }
        String errorMsg = adVarZ.getErrorMsg();
        if (TextUtils.isEmpty(errorMsg) || !errorMsg.contains("200000")) {
            return;
        }
        com.anythink.core.c.d.c.a(adVarZ, new ay(5, byVar, nVar), true, 31);
    }

    public static void b(by byVar, n nVar) {
        ad adVarZ;
        if (byVar != null) {
            try {
                if (!byVar.w() || (adVarZ = byVar.Z()) == null || nVar == null) {
                    return;
                }
                if (byVar.B() != -11) {
                    if (byVar.B() == -13) {
                        ay ayVar = new ay(9, byVar, nVar, adVarZ.getSortPrice());
                        a(ayVar, byVar);
                        com.anythink.core.c.d.c.a(adVarZ, ayVar, true, 33);
                        return;
                    }
                    return;
                }
                ay ayVar2 = new ay(6, byVar, nVar, adVarZ.getSortPrice());
                a(ayVar2, byVar);
                com.anythink.core.c.d.c.a(adVarZ, ayVar2, true, 23);
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(ad adVar, by byVar, n nVar) {
        ay ayVar = new ay(6, byVar, nVar, adVar.getSortPrice());
        a(ayVar, byVar);
        com.anythink.core.c.d.c.a(adVar, ayVar, true, 23);
    }

    private static void a(ay ayVar, by byVar) {
        if (byVar != null) {
            int iBE = byVar.bE();
            if (iBE == 1) {
                ayVar.d(byVar.az());
            } else if (iBE == 2) {
                ayVar.b(byVar.bG());
                ayVar.d(byVar.bF());
            }
        }
    }

    private static void b(ad adVar, by byVar, n nVar) {
        ay ayVar = new ay(9, byVar, nVar, adVar.getSortPrice());
        a(ayVar, byVar);
        com.anythink.core.c.d.c.a(adVar, ayVar, true, 33);
    }

    public final boolean g(by byVar) {
        ac acVar = this.s;
        boolean zA = false;
        if (acVar == null || byVar == null) {
            return false;
        }
        by byVarB = acVar.b();
        boolean zA2 = a(byVar, byVarB);
        if (zA2) {
            this.s.a(byVar);
        }
        if (byVar.w() && a(byVar, this.s.a())) {
            this.s.b(byVar);
        }
        if (byVarB != null) {
            if (zA2) {
                this.s.c(byVarB);
            } else {
                zA = a(byVar, this.s.c());
            }
        }
        if (zA) {
            this.s.c(byVar);
        }
        return zA2;
    }

    private static boolean a(by byVar, by byVar2) {
        if (byVar2 != null && k.a(byVar, byVar2) >= 0) {
            return k.a(byVar, byVar2) == 0 && byVar.aF() < byVar2.aF();
        }
        return true;
    }

    private double D() {
        return c(false);
    }

    private double c(boolean z) {
        synchronized (this.w) {
            int size = this.w.size();
            if (size == 0) {
                return 0.0d;
            }
            int i = this.b - 1;
            int i2 = size - 1;
            if (z && i2 < i) {
                return 0.0d;
            }
            return o.a(this.w.get(Math.min(i, i2)));
        }
    }

    private by E() {
        return a(false);
    }

    public final by a(boolean z) {
        synchronized (this.w) {
            int size = this.w.size();
            if (size == 0) {
                return null;
            }
            int i = this.b - 1;
            int i2 = size - 1;
            if (z && i2 < i) {
                return null;
            }
            by byVar = this.w.get(Math.min(i, i2));
            o.a(byVar);
            return byVar;
        }
    }

    private double F() {
        return c(true);
    }

    private by G() {
        return a(true);
    }

    public final void h(by byVar) {
        synchronized (this.w) {
            if (this.w.size() == 0) {
                this.w.add(byVar);
            } else {
                double dA = o.a(byVar);
                for (int i = 0; i < this.w.size(); i++) {
                    if (dA > o.a(this.w.get(i))) {
                        this.w.add(i, byVar);
                        break;
                    } else {
                        if (i == this.w.size() - 1) {
                            this.w.add(byVar);
                            break;
                        }
                    }
                }
            }
        }
    }

    public final void a(n nVar) {
        ArrayList arrayList = new ArrayList(5);
        synchronized (this.w) {
            a(arrayList, this.w);
        }
        synchronized (this.f) {
            a(arrayList, this.f);
        }
        Iterator<by> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), nVar, false, 21);
        }
    }

    private static void a(by byVar, n nVar, boolean z, int i) {
        ad adVarY = byVar.Y();
        if (adVarY != null) {
            com.anythink.core.c.d.c.a(adVarY, new ay(2, byVar, nVar), z, i);
        }
    }

    private void a(List<by> list, List<by> list2) {
        int iAA;
        int size = list2.size();
        int size2 = this.w.size();
        for (int i = 0; i < size; i++) {
            by byVar = list2.get(i);
            if (byVar.w() && (iAA = byVar.aA()) > 0 && iAA <= size2 && k.a(byVar, this.w.get(iAA - 1)) > 0) {
                list.add(byVar);
            }
        }
    }

    private boolean k(by byVar) {
        return a(byVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    public final boolean a(by byVar, boolean z) {
        double dA;
        boolean z2;
        if (byVar.bz()) {
            return true;
        }
        double dA2 = o.a(byVar);
        double dC = c(true);
        synchronized (this.f) {
            Iterator<by> it = this.f.iterator();
            do {
                if (!it.hasNext()) {
                    dA = 0.0d;
                    break;
                }
                by next = it.next();
                dA = o.a(next);
                if (z) {
                    if (!next.w() || dA <= o.a(byVar)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else if (dA > o.a(byVar)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } while (!z2);
        }
        return dA2 > Math.max(dC, dA);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0025  */
    /* JADX WARN: Code duplicated, block: B:23:0x002a  */
    /* JADX WARN: Code duplicated, block: B:27:? A[RETURN, SYNTHETIC] */
    public static boolean a(by byVar, j jVar) {
        boolean z = byVar.al() == 1;
        if (z) {
            int iY = byVar.y();
            if (iY == 1 || iY == 3) {
                if (jVar.f) {
                    return false;
                }
                jVar.f = true;
            } else if (iY != 6) {
                if (iY == 7) {
                    if (jVar.f) {
                        return false;
                    }
                    jVar.f = true;
                }
            } else {
                if (jVar.g) {
                    return false;
                }
                jVar.g = true;
            }
        }
        return z;
    }

    public static void a(com.anythink.core.common.f fVar, String str, String str2, by byVar, by byVar2) {
        cc.a aVar;
        cc.a aVar2 = null;
        if (byVar != null) {
            cc.a aVar3 = new cc.a(byVar, byVar.Y());
            aVar = null;
            aVar2 = aVar3;
        } else {
            aVar = byVar2 != null ? new cc.a(byVar2, byVar2.Y()) : null;
        }
        if (fVar == null || fVar.g() == null) {
            return;
        }
        fVar.g().a(str, str2, aVar2, aVar);
    }

    public final synchronized void b(by byVar, int i) {
        List<by> list;
        try {
            if (i == 2) {
                list = this.g;
            } else {
                list = this.e;
            }
            synchronized (list) {
                o.a(list, byVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean a(String str, by byVar, n nVar, com.anythink.core.common.f fVar) {
        boolean z = false;
        try {
            if (byVar.w()) {
                ad adVarY = byVar.Y();
                if (fVar != null && fVar.f() != null) {
                    fVar.f().a(str, adVarY);
                }
                if (byVar.au()) {
                    com.anythink.core.common.a.a.a().a(s.b().g(), adVarY.token);
                }
                if (adVarY != null && adVarY.a()) {
                    z = true;
                }
                if (z && adVarY != null) {
                    com.anythink.core.c.d.c.a(adVarY, new ay(1, byVar, nVar), true, 25);
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public final by b(boolean z) {
        by byVarB;
        if (!z || (byVarB = this.s.b()) == null || !byVarB.w() || byVarB.aD() == 1) {
            return null;
        }
        synchronized (this.f) {
            Iterator<by> it = this.f.iterator();
            while (it.hasNext()) {
                if (k.a(it.next(), byVarB) < 0) {
                    return null;
                }
            }
            synchronized (this.h) {
                Iterator<f> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    if (k.a(it2.next().a, byVarB) < 0) {
                        return null;
                    }
                }
                return byVarB;
            }
        }
    }

    public final void b(n nVar) {
        synchronized (this.e) {
            for (by byVar : this.e) {
                if (byVar != null && byVar.w()) {
                    c(byVar, nVar);
                }
            }
            this.e.clear();
        }
        synchronized (this.h) {
            for (f fVar : this.h) {
                if (fVar != null && fVar.a != null && fVar.a.w()) {
                    c(fVar.a, nVar);
                }
            }
            this.h.clear();
        }
        synchronized (this.g) {
            this.g.clear();
        }
    }

    public static void c(by byVar, n nVar) {
        if (byVar != null && byVar.w() && byVar.W() == 2) {
            a(byVar, nVar.ah(), true, 22);
        }
    }

    public static void d(by byVar, n nVar) {
        if (l(byVar)) {
            n nVarAh = nVar.ah();
            ad adVarY = byVar.Y();
            if (adVarY != null) {
                com.anythink.core.c.d.c.a(adVarY, new ay(5, byVar, nVarAh), true, 24);
            }
        }
    }

    public static void i(by byVar) {
        ad adVarY;
        if (!l(byVar) || byVar.aW() == 2 || (adVarY = byVar.Y()) == null) {
            return;
        }
        com.anythink.core.c.d.c.a(adVarY, byVar, 3);
    }

    private static boolean l(by byVar) {
        return byVar != null && byVar.bd();
    }

    public static double j(by byVar) {
        ad adVarY;
        double dA = o.a(byVar);
        return (byVar.av() && dA == 10000.0d && (adVarY = byVar.Y()) != null) ? adVarY.o : dA;
    }

    public final long a(boolean z, long j) {
        if (this.g.size() <= 0) {
            return -1L;
        }
        if (this.e.size() == 0 && z) {
            return 0L;
        }
        return j;
    }

    public final boolean s() {
        return this.e.size() == 0 && this.g.size() == 0 && this.h.size() == 0 && this.f.size() == 0;
    }

    public static by a(Map<String, e> map) {
        by byVar;
        Iterator<Map.Entry<String, e>> it = map.entrySet().iterator();
        by byVar2 = null;
        if (it != null) {
            while (it.hasNext()) {
                e value = it.next().getValue();
                if (value != null && !value.i && (byVar = value.c) != null && (byVar2 == null || k.a(byVar, byVar2) < 0)) {
                    byVar2 = byVar;
                }
            }
        }
        return byVar2;
    }

    public final boolean t() {
        return this.m < this.v.f();
    }

    public final ATRequestingInfo e(by byVar, n nVar) {
        List listSynchronizedList;
        List listSynchronizedList2;
        synchronized (this.f) {
            listSynchronizedList = null;
            for (by byVar2 : this.f) {
                if (k.a(byVar2, byVar) < 0) {
                    n nVarAh = nVar.ah();
                    ai.a(nVarAh, byVar2, 0, false);
                    com.anythink.core.common.d.k kVarA = com.anythink.core.common.d.k.a(nVarAh, (ATBaseAdAdapter) null, 2);
                    if (kVarA != null) {
                        if (listSynchronizedList == null) {
                            listSynchronizedList = Collections.synchronizedList(new ArrayList());
                        }
                        listSynchronizedList.add(kVarA);
                    }
                }
            }
        }
        if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
            Collections.sort(listSynchronizedList, new Comparator<ATAdInfo>() { // from class: com.anythink.core.common.v.g.1
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ATAdInfo aTAdInfo, ATAdInfo aTAdInfo2) {
                    ATAdInfo aTAdInfo3 = aTAdInfo;
                    ATAdInfo aTAdInfo4 = aTAdInfo2;
                    if (aTAdInfo3.getEcpm() > aTAdInfo4.getEcpm()) {
                        return -1;
                    }
                    return aTAdInfo3.getEcpm() < aTAdInfo4.getEcpm() ? 1 : 0;
                }

                private static int a(ATAdInfo aTAdInfo, ATAdInfo aTAdInfo2) {
                    if (aTAdInfo.getEcpm() > aTAdInfo2.getEcpm()) {
                        return -1;
                    }
                    return aTAdInfo.getEcpm() < aTAdInfo2.getEcpm() ? 1 : 0;
                }
            });
        }
        if (this.k.size() > 0) {
            synchronized (this.k) {
                listSynchronizedList2 = null;
                for (by byVar3 : this.k) {
                    n nVarAh2 = nVar.ah();
                    ai.a(nVarAh2, byVar3, 0, false);
                    ai.a(nVarAh2);
                    com.anythink.core.common.d.k kVarA2 = com.anythink.core.common.d.k.a(nVarAh2, (ATBaseAdAdapter) null);
                    if (kVarA2 != null) {
                        if (listSynchronizedList2 == null) {
                            listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
                        }
                        listSynchronizedList2.add(kVarA2);
                    }
                }
            }
        } else {
            listSynchronizedList2 = null;
        }
        if (listSynchronizedList == null && listSynchronizedList2 == null) {
            return null;
        }
        return new com.anythink.core.common.h.b(listSynchronizedList, listSynchronizedList2);
    }

    public final boolean a(boolean z, by byVar) {
        by byVar2;
        if (!z) {
            return false;
        }
        synchronized (this.f) {
            byVar2 = null;
            for (by byVar3 : this.f) {
                if (k.a(byVar3, byVar2) < 0) {
                    byVar2 = byVar3;
                }
            }
        }
        by byVarU = u();
        if (k.a(byVar2, byVarU) >= 0) {
            byVar2 = byVarU;
        }
        return k.a(byVar, byVar2) <= 0;
    }

    private double H() {
        return Math.max(o.a(x()), o.a(A()));
    }

    public final by u() {
        by byVarX = x();
        by byVarA = A();
        return k.a(byVarX, byVarA) < 0 ? byVarX : byVarA;
    }

    public final Map<String, Double> a(List<by> list, by byVar) {
        HashMap map = new HashMap();
        double d = this.u;
        double dA = o.a(byVar);
        if (dA > d) {
            d = dA;
        }
        if (list != null) {
            for (by byVar2 : list) {
                double dAz = byVar2.az();
                String strG = byVar2.G();
                if (dAz <= d) {
                    dAz = d;
                }
                map.put(strG, Double.valueOf(dAz));
            }
        }
        return map;
    }

    public final void a(Double d) {
        this.x = d;
    }

    public final Double v() {
        return this.x;
    }
}
