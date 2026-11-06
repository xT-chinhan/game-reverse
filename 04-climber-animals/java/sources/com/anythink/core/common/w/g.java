package com.anythink.core.common.w;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.n;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.l;
import com.anythink.core.common.v.p;
import com.anythink.core.common.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final String a = com.anythink.basead.f.g.i;
    final int b;
    int c;
    int d;
    long e;
    bz q;
    bq r;
    i s;
    ac t;
    ac u;
    double v;
    private List<bv> w;
    volatile int m = 0;
    volatile int n = 0;
    volatile int o = 0;
    volatile int p = 0;
    List<bv> f = Collections.synchronizedList(new ArrayList(5));
    List<bv> g = Collections.synchronizedList(new ArrayList(5));
    List<bv> h = Collections.synchronizedList(new ArrayList(2));
    List<f> i = Collections.synchronizedList(new ArrayList(2));
    List<bv> l = Collections.synchronizedList(new ArrayList(2));
    List<bv> j = Collections.synchronizedList(new ArrayList(2));
    List<bv> k = Collections.synchronizedList(new ArrayList(2));

    public g(h hVar) {
        this.c = 1;
        this.f.addAll(hVar.d);
        this.j.addAll(hVar.f);
        this.k.addAll(hVar.g);
        this.v = hVar.h;
        this.l.addAll(hVar.p);
        this.s = hVar.l;
        this.t = hVar.n;
        this.u = hVar.o;
        this.b = hVar.c.g();
        this.c = hVar.c.e();
        this.d = hVar.c.f();
        this.e = hVar.c.i();
        List<bv> list = hVar.e;
        if (list != null) {
            this.h.addAll(list);
        }
        this.w = Collections.synchronizedList(new ArrayList(3));
        this.q = hVar.k;
        this.r = hVar.m;
    }

    public final i a() {
        return this.s;
    }

    public final ac b() {
        return this.t;
    }

    private List<bv> w() {
        return this.f;
    }

    public final int c() {
        return this.f.size();
    }

    private bv x() {
        if (this.f.size() > 0) {
            return this.f.get(0);
        }
        return null;
    }

    private List<bv> y() {
        return this.g;
    }

    public final void a(List<bv> list) {
        this.g.addAll(list);
    }

    public final void a(bv bvVar) {
        this.g.add(bvVar);
    }

    public final int d() {
        return this.g.size();
    }

    public final void b(bv bvVar) {
        this.g.remove(bvVar);
    }

    public final void c(bv bvVar) {
        this.l.remove(bvVar);
    }

    public final void b(List<bv> list) {
        this.l.addAll(list);
    }

    private List<bv> z() {
        return this.h;
    }

    public final int e() {
        return this.h.size();
    }

    public final bv f() {
        return this.h.remove(0);
    }

    public final boolean g() {
        return this.h.size() == 0 && this.f.size() == 0;
    }

    public final void h() {
        this.h.clear();
    }

    public final void a(bv bvVar, int i) {
        synchronized (this.i) {
            Iterator<f> it = this.i.iterator();
            int i2 = 0;
            while (it.hasNext() && l.a(it.next().a, bvVar) < 0) {
                i2++;
            }
            this.i.add(i2, new f(bvVar, i));
        }
    }

    private bv A() {
        bv bvVar;
        f fVar;
        synchronized (this.i) {
            bvVar = (this.i.size() <= 0 || (fVar = this.i.get(0)) == null) ? null : fVar.a;
        }
        return bvVar;
    }

    public final int i() {
        return this.i.size();
    }

    public final List<f> j() {
        return this.i;
    }

    public final boolean k() {
        List<bv> list = this.j;
        if (list == null && this.k == null) {
            return true;
        }
        return list.size() == 0 && this.k.size() == 0;
    }

    public final List<bv> l() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.addAll(this.j);
        arrayList.addAll(this.k);
        this.j.clear();
        this.k.clear();
        return arrayList;
    }

    public final int m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final int o() {
        return this.o;
    }

    public final bz p() {
        return this.q;
    }

    public final bq q() {
        return this.r;
    }

    public final ac r() {
        return this.u;
    }

    public final List<bv> s() {
        List<bv> arrayList;
        int i = this.c;
        if (i == 1 || i == 3) {
            arrayList = new ArrayList<>();
            int iMin = Math.min(this.d, this.f.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                arrayList.add(this.f.get(i2));
            }
        } else {
            arrayList = i == 2 ? b(1) : null;
        }
        if (arrayList != null) {
            arrayList.size();
        }
        if (arrayList != null && arrayList.size() > 0) {
            this.f.removeAll(arrayList);
        }
        return arrayList;
    }

    public static String c(List<bv> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                str = str + ",";
            }
            str = str + new StringBuilder().append(list.get(i).g()).toString();
        }
        return str;
    }

    public final void a(int i, int i2) {
        this.m += i;
        if (i2 == 2) {
            this.o += i;
        } else {
            this.n += i;
        }
    }

    public final void a(int i) {
        if (this.c == 2 && i == 1) {
            this.p--;
        }
    }

    public final List<bv> b(int i) {
        List<bv> list;
        int iMin;
        if (i == 2) {
            list = this.h;
        } else {
            list = this.f;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            int i2 = 0;
            bv bvVar = list.get(0);
            if (i == 2) {
                arrayList.add(bvVar);
            } else {
                bv bvVarA = a(true);
                int i3 = this.c;
                if (i3 == 1) {
                    int i4 = this.d - this.n;
                    list.size();
                    int iMin2 = Math.min(i4, list.size());
                    if (iMin2 > 0) {
                        while (i2 < iMin2) {
                            bv bvVar2 = list.get(i2);
                            if (l.a(bvVar2, bvVarA) >= 0) {
                                break;
                            }
                            arrayList.add(bvVar2);
                            i2++;
                        }
                    }
                } else if (i3 == 2) {
                    boolean z = l.a(bvVar, bvVarA) < 0;
                    if (this.p == 0 && z) {
                        double dA = p.a(bvVar);
                        int size = list.size();
                        while (i2 < size) {
                            bv bvVar3 = list.get(i2);
                            if (p.a(bvVar3) == dA) {
                                arrayList.add(bvVar3);
                            }
                            i2++;
                        }
                        this.p = arrayList.size();
                    }
                } else if (i3 == 3 && this.n == 0 && (iMin = Math.min(this.d, list.size())) > 0) {
                    while (i2 < iMin) {
                        bv bvVar4 = list.get(i2);
                        if (l.a(bvVar4, bvVarA) >= 0) {
                            break;
                        }
                        arrayList.add(bvVar4);
                        i2++;
                    }
                    arrayList.size();
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
        return arrayList;
    }

    public final void d(bv bvVar) {
        i iVar = this.s;
        if (iVar != null) {
            iVar.a(bvVar);
        }
    }

    public final void e(bv bvVar) {
        ad adVarR;
        if (bvVar == null || !bvVar.o() || (adVarR = bvVar.R()) == null) {
            return;
        }
        adVarR.a(this.t);
    }

    public final void f(bv bvVar) {
        ad adVarS;
        if (bvVar == null || !bvVar.o() || (adVarS = bvVar.S()) == null) {
            return;
        }
        adVarS.a(this.t);
    }

    public static void a(bv bvVar, n nVar) {
        ad adVarS;
        if (bvVar == null || !bvVar.o() || (adVarS = bvVar.S()) == null) {
            return;
        }
        String errorMsg = adVarS.getErrorMsg();
        if (TextUtils.isEmpty(errorMsg) || !errorMsg.contains("200000")) {
            return;
        }
        com.anythink.core.b.d.c.a(adVarS, new aw(5, bvVar, nVar), true, 31);
    }

    public final boolean g(bv bvVar) {
        ac acVar = this.t;
        boolean z = false;
        if (acVar == null || bvVar == null) {
            return false;
        }
        bv bvVarA = acVar.a();
        boolean z2 = bvVarA == null || l.a(bvVar, bvVarA) < 0 || (l.a(bvVar, bvVarA) == 0 && bvVar.ax() < bvVarA.ax());
        if (z2) {
            this.t.a(bvVar);
        }
        if (bvVarA != null) {
            if (z2) {
                this.t.b(bvVarA);
            } else {
                bv bvVarB = this.t.b();
                if (bvVarB == null || l.a(bvVar, bvVarB) < 0 || (l.a(bvVar, bvVarB) == 0 && bvVar.ax() < bvVarB.ax())) {
                    z = true;
                }
            }
        }
        if (z) {
            this.t.b(bvVar);
        }
        return z2;
    }

    private double B() {
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
            return p.a(this.w.get(Math.min(i, i2)));
        }
    }

    private bv C() {
        return a(false);
    }

    public final bv a(boolean z) {
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
            bv bvVar = this.w.get(Math.min(i, i2));
            p.a(bvVar);
            return bvVar;
        }
    }

    private double D() {
        return c(true);
    }

    private bv E() {
        return a(true);
    }

    public final void h(bv bvVar) {
        synchronized (this.w) {
            if (this.w.size() == 0) {
                this.w.add(bvVar);
            } else {
                double dA = p.a(bvVar);
                for (int i = 0; i < this.w.size(); i++) {
                    if (dA > p.a(this.w.get(i))) {
                        this.w.add(i, bvVar);
                        break;
                    } else {
                        if (i == this.w.size() - 1) {
                            this.w.add(bvVar);
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
        synchronized (this.g) {
            a(arrayList, this.g);
        }
        Iterator<bv> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), nVar, false, 21);
        }
    }

    private static void a(bv bvVar, n nVar, boolean z, int i) {
        ad adVarR = bvVar.R();
        if (adVarR != null) {
            com.anythink.core.b.d.c.a(adVarR, new aw(2, bvVar, nVar), z, i);
        }
    }

    private void a(List<bv> list, List<bv> list2) {
        int iAs;
        int size = list2.size();
        int size2 = this.w.size();
        for (int i = 0; i < size; i++) {
            bv bvVar = list2.get(i);
            if (bvVar.o() && (iAs = bvVar.as()) > 0 && iAs <= size2 && l.a(bvVar, this.w.get(iAs - 1)) > 0) {
                list.add(bvVar);
            }
        }
    }

    private boolean k(bv bvVar) {
        return a(bvVar, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0045  */
    public final boolean a(bv bvVar, boolean z) {
        double dA;
        boolean z2;
        if (bvVar.br()) {
            return true;
        }
        double dA2 = p.a(bvVar);
        double dC = c(true);
        synchronized (this.g) {
            Iterator<bv> it = this.g.iterator();
            do {
                if (!it.hasNext()) {
                    dA = 0.0d;
                    break;
                }
                bv next = it.next();
                dA = p.a(next);
                if (z) {
                    if (!next.o() || dA <= p.a(bvVar)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else if (dA > p.a(bvVar)) {
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
    public static boolean a(bv bvVar, j jVar) {
        boolean z = bvVar.af() == 1;
        if (z) {
            int iQ = bvVar.q();
            if (iQ == 1 || iQ == 3) {
                if (jVar.f) {
                    return false;
                }
                jVar.f = true;
            } else if (iQ != 6) {
                if (iQ == 7) {
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

    public static void a(Context context, String str, String str2, bv bvVar, bv bvVar2) {
        bz.a aVar;
        bz.a aVar2 = null;
        if (bvVar != null) {
            bz.a aVar3 = new bz.a(bvVar, bvVar.R());
            aVar = null;
            aVar2 = aVar3;
        } else {
            aVar = bvVar2 != null ? new bz.a(bvVar2, bvVar2.R()) : null;
        }
        x.a(context).a(str, str2, aVar2, aVar);
    }

    public static void a(Context context, String str) {
        x.a(context).a(str);
    }

    public static void a(String str) {
        com.anythink.core.common.d.a().b(str);
    }

    public final synchronized void b(bv bvVar, int i) {
        List<bv> list;
        try {
            if (i == 2) {
                list = this.h;
            } else {
                list = this.f;
            }
            synchronized (list) {
                p.a(list, bvVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean a(String str, bv bvVar, n nVar) {
        boolean z = false;
        try {
            if (bvVar.o()) {
                ad adVarR = bvVar.R();
                com.anythink.core.b.f.a().a(str, adVarR);
                if (adVarR != null && adVarR.a()) {
                    z = true;
                }
                if (z && adVarR != null) {
                    com.anythink.core.b.d.c.a(adVarR, new aw(1, bvVar, nVar), true, 25);
                }
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public final bv b(boolean z) {
        bv bvVarA;
        if (!z || (bvVarA = this.t.a()) == null) {
            return null;
        }
        if (!bvVarA.o()) {
            bvVarA.toString();
            return null;
        }
        if (bvVarA.av() == 1) {
            return null;
        }
        synchronized (this.g) {
            for (bv bvVar : this.g) {
                if (l.a(bvVar, bvVarA) < 0) {
                    bvVar.toString();
                    return null;
                }
            }
            synchronized (this.i) {
                Iterator<f> it = this.i.iterator();
                while (it.hasNext()) {
                    bv bvVar2 = it.next().a;
                    if (l.a(bvVar2, bvVarA) < 0) {
                        bvVar2.toString();
                        return null;
                    }
                }
                bvVarA.toString();
                return bvVarA;
            }
        }
    }

    public final void b(n nVar) {
        synchronized (this.f) {
            for (bv bvVar : this.f) {
                if (bvVar != null && bvVar.o()) {
                    b(bvVar, nVar);
                }
            }
            this.f.clear();
        }
        synchronized (this.i) {
            for (f fVar : this.i) {
                if (fVar != null && fVar.a != null && fVar.a.o()) {
                    b(fVar.a, nVar);
                }
            }
            this.i.clear();
        }
        synchronized (this.h) {
            this.h.clear();
        }
    }

    public static void b(bv bvVar, n nVar) {
        if (bvVar != null && bvVar.o() && bvVar.P() == 2) {
            a(bvVar, nVar.af(), true, 22);
        }
    }

    public static void c(bv bvVar, n nVar) {
        if (l(bvVar)) {
            bvVar.toString();
            n nVarAf = nVar.af();
            ad adVarR = bvVar.R();
            if (adVarR != null) {
                com.anythink.core.b.d.c.a(adVarR, new aw(5, bvVar, nVarAf), true, 24);
            }
        }
    }

    public static void i(bv bvVar) {
        ad adVarR;
        if (!l(bvVar) || bvVar.aO() == 2 || (adVarR = bvVar.R()) == null) {
            return;
        }
        bvVar.toString();
        com.anythink.core.b.d.c.a(adVarR, bvVar, 3);
    }

    private static boolean l(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        int iD = bvVar.d();
        return iD == 4 || iD == 3;
    }

    public static double j(bv bvVar) {
        ad adVarR;
        double dA = p.a(bvVar);
        return (bvVar.an() && dA == 10000.0d && (adVarR = bvVar.R()) != null) ? adVarR.o : dA;
    }

    public final long a(boolean z, long j) {
        if (this.h.size() <= 0) {
            return -1L;
        }
        if (this.f.size() == 0 && z) {
            return 0L;
        }
        return j;
    }

    public final boolean t() {
        return this.f.size() == 0 && this.h.size() == 0 && this.i.size() == 0 && this.g.size() == 0;
    }

    public static bv a(Map<String, e> map) {
        bv bvVar;
        Iterator<Map.Entry<String, e>> it = map.entrySet().iterator();
        bv bvVar2 = null;
        if (it != null) {
            while (it.hasNext()) {
                e value = it.next().getValue();
                if (value != null && !value.i && (bvVar = value.c) != null && (bvVar2 == null || l.a(bvVar, bvVar2) < 0)) {
                    bvVar2 = bvVar;
                }
            }
        }
        return bvVar2;
    }

    public final boolean u() {
        return this.n < this.d;
    }

    public final ATRequestingInfo d(bv bvVar, n nVar) {
        List listSynchronizedList;
        List listSynchronizedList2;
        synchronized (this.g) {
            listSynchronizedList = null;
            for (bv bvVar2 : this.g) {
                if (l.a(bvVar2, bvVar) < 0) {
                    new StringBuilder("getHigherAdInfoInLoading, higher price ad: ").append(bvVar2);
                    n nVarAf = nVar.af();
                    aj.a(nVarAf, bvVar2, 0, false);
                    com.anythink.core.common.d.l lVarA = com.anythink.core.common.d.l.a(nVarAf, (com.anythink.core.common.d.f) null, 2);
                    if (lVarA != null) {
                        if (listSynchronizedList == null) {
                            listSynchronizedList = Collections.synchronizedList(new ArrayList());
                        }
                        listSynchronizedList.add(lVarA);
                    }
                }
            }
        }
        if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
            Collections.sort(listSynchronizedList, new Comparator<ATAdInfo>() { // from class: com.anythink.core.common.w.g.1
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
        if (this.l.size() > 0) {
            synchronized (this.l) {
                listSynchronizedList2 = null;
                for (bv bvVar3 : this.l) {
                    new StringBuilder("getHigherAdInfoInLoading, waiting bid result ad: ").append(bvVar3);
                    n nVarAf2 = nVar.af();
                    aj.a(nVarAf2, bvVar3, 0, false);
                    aj.a(nVarAf2);
                    com.anythink.core.common.d.l lVarA2 = com.anythink.core.common.d.l.a(nVarAf2, (com.anythink.core.common.d.f) null);
                    if (lVarA2 != null) {
                        if (listSynchronizedList2 == null) {
                            listSynchronizedList2 = Collections.synchronizedList(new ArrayList());
                        }
                        listSynchronizedList2.add(lVarA2);
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

    public final boolean a(boolean z, bv bvVar) {
        bv bvVar2;
        if (!z) {
            return false;
        }
        synchronized (this.g) {
            bvVar2 = null;
            for (bv bvVar3 : this.g) {
                if (l.a(bvVar3, bvVar2) < 0) {
                    bvVar2 = bvVar3;
                }
            }
        }
        bv bvVarV = v();
        if (l.a(bvVar2, bvVarV) >= 0) {
            bvVar2 = bvVarV;
        }
        return l.a(bvVar, bvVar2) <= 0;
    }

    private double F() {
        return Math.max(p.a(x()), p.a(A()));
    }

    public final bv v() {
        bv bvVarX = x();
        bv bvVarA = A();
        return l.a(bvVarX, bvVarA) < 0 ? bvVarX : bvVarA;
    }

    public final Map<String, Double> a(List<bv> list, bv bvVar) {
        HashMap map = new HashMap();
        double d = this.v;
        double dA = p.a(bvVar);
        if (dA > d) {
            d = dA;
        }
        if (list != null) {
            for (bv bvVar2 : list) {
                double dAr = bvVar2.ar();
                String strZ = bvVar2.z();
                if (dAr <= d) {
                    dAr = d;
                }
                map.put(strZ, Double.valueOf(dAr));
            }
        }
        return map;
    }
}
