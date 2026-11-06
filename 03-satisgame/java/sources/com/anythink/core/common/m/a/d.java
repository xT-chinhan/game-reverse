package com.anythink.core.common.m.a;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String a = "d";
    private static final long b = 500;
    private static volatile d c;
    private volatile k[] e;
    private volatile m f = null;
    private volatile k g = null;
    private final l<String, n[]> d = new l<>();

    private d() {
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public final synchronized void a(m mVar, k[] kVarArr) {
        if (mVar == null) {
            try {
                mVar = m.j;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f = mVar;
        this.e = kVarArr;
    }

    public final synchronized boolean b() {
        return this.e != null && this.e.length > 0;
    }

    private synchronized void c() {
        this.d.clear();
    }

    public final synchronized o a(j jVar) {
        if (TextUtils.isEmpty(jVar.a) || jVar.a.trim().isEmpty()) {
            throw new IllegalArgumentException("empty domain");
        }
        if (a(jVar.a)) {
            return new o(new InetAddress[]{InetAddress.getByName(jVar.a)}, this.g);
        }
        n[] nVarArrB = b(this.d.get(jVar.a));
        if (nVarArrB != null && nVarArrB.length > 0) {
            return a(jVar.a, nVarArrB);
        }
        k[] kVarArr = this.e;
        if (kVarArr == null || kVarArr.length == 0) {
            throw new IllegalArgumentException("no resolver");
        }
        n[] nVarArrA = a(jVar, kVarArr);
        if (nVarArrA == null || nVarArrA.length == 0) {
            throw new UnknownHostException(jVar.a + " (dual stack lookup failed)");
        }
        this.d.put(jVar.a, nVarArrA);
        return a(jVar.a, nVarArrA);
    }

    private n[] a(final j jVar, final k[] kVarArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        final List listSynchronizedList = Collections.synchronizedList(new ArrayList(4));
        final List listSynchronizedList2 = Collections.synchronizedList(new ArrayList(4));
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable runnable = new Runnable() { // from class: com.anythink.core.common.m.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    n[] nVarArrA = d.this.a(jVar, 1, kVarArr);
                    if (nVarArrA != null) {
                        Collections.addAll(listSynchronizedList, nVarArrA);
                    }
                } catch (Throwable unused) {
                }
                countDownLatch.countDown();
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.anythink.core.common.m.a.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    n[] nVarArrA = d.this.a(jVar, 28, kVarArr);
                    if (nVarArrA != null) {
                        Collections.addAll(listSynchronizedList2, nVarArrA);
                    }
                } catch (Throwable unused) {
                }
                countDownLatch.countDown();
            }
        };
        try {
            com.anythink.core.common.u.b.c.a().f(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.b, runnable));
            com.anythink.core.common.u.b.c.a().f(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.b, runnable2));
            try {
                countDownLatch.await(a(kVarArr), TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            synchronized (listSynchronizedList) {
                arrayList = new ArrayList(listSynchronizedList);
            }
            synchronized (listSynchronizedList2) {
                arrayList2 = new ArrayList(listSynchronizedList2);
            }
            ArrayList arrayList3 = new ArrayList(arrayList.size() + arrayList2.size());
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
            if (arrayList3.isEmpty()) {
                return null;
            }
            return (n[]) arrayList3.toArray(new n[0]);
        } catch (Throwable unused2) {
            try {
                n[] nVarArrA = a(jVar, 1, kVarArr);
                if (nVarArrA != null) {
                    return nVarArrA;
                }
                return null;
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n[] a(j jVar, int i, k[] kVarArr) {
        n[] nVarArrA;
        int length = kVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            k hVar = kVarArr[i2];
            if (hVar != null) {
                if (i != 1) {
                    g gVarA = hVar.a();
                    if (TextUtils.isEmpty(gVarA.a())) {
                        continue;
                    } else {
                        hVar = new h(gVarA.a(), gVarA.b(), gVarA.c(), i);
                        try {
                            nVarArrA = hVar.a(jVar);
                            if (nVarArrA != null && nVarArrA.length > 0) {
                                ArrayList arrayList = new ArrayList(nVarArrA.length);
                                for (n nVar : nVarArrA) {
                                    if (nVar != null && (nVar.a() || nVar.b())) {
                                        arrayList.add(nVar);
                                    }
                                }
                                n[] nVarArr = (n[]) arrayList.toArray(new n[0]);
                                if (nVarArr.length > 0) {
                                    this.g = hVar;
                                    return nVarArr;
                                }
                                continue;
                            }
                        } catch (Exception unused) {
                            continue;
                        }
                    }
                } else {
                    nVarArrA = hVar.a(jVar);
                    if (nVarArrA != null) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private o a(String str, n[] nVarArr) {
        if (nVarArr == null || nVarArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(nVarArr.length);
        int i = 0;
        for (n nVar : nVarArr) {
            if (nVar != null && !TextUtils.isEmpty(nVar.g)) {
                arrayList.add(nVar.g);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List<InetAddress> listA = com.anythink.core.common.l.b.a.a(str, arrayList);
        if (listA.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(listA.size());
        ArrayList arrayList3 = new ArrayList(listA.size());
        for (InetAddress inetAddress : listA) {
            if (inetAddress instanceof Inet4Address) {
                arrayList2.add(inetAddress);
            } else if (inetAddress instanceof Inet6Address) {
                arrayList3.add(inetAddress);
            }
        }
        int size = arrayList2.size() + arrayList3.size();
        if (size == 0) {
            return null;
        }
        InetAddress[] inetAddressArr = new InetAddress[size];
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            inetAddressArr[i] = (InetAddress) it.next();
            i++;
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            inetAddressArr[i] = (InetAddress) it2.next();
            i++;
        }
        return new o(inetAddressArr, this.g);
    }

    private static long a(k[] kVarArr) {
        if (kVarArr == null || kVarArr.length == 0) {
            return 500L;
        }
        long jC = 0;
        for (k kVar : kVarArr) {
            if (kVar != null) {
                g gVarA = kVar.a();
                if (gVarA.c() > jC) {
                    jC = gVarA.c();
                }
            }
        }
        return Math.max((jC * ((long) kVarArr.length)) + 500, 500L);
    }

    private static n[] a(n[] nVarArr) {
        ArrayList arrayList = new ArrayList(nVarArr.length);
        for (n nVar : nVarArr) {
            if (nVar != null && (nVar.a() || nVar.b())) {
                arrayList.add(nVar);
            }
        }
        return (n[]) arrayList.toArray(new n[0]);
    }

    private static n[] b(n[] nVarArr) {
        if (nVarArr == null || nVarArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(nVarArr.length);
        for (n nVar : nVarArr) {
            if (nVar != null && !TextUtils.isEmpty(nVar.g)) {
                if (!(nVar.i != -1 && nVar.j + ((long) nVar.i) <= System.currentTimeMillis() / 1000)) {
                    arrayList.add(nVar);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (n[]) arrayList.toArray(new n[0]);
    }

    private static boolean a(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || str.contains("-")) {
            return false;
        }
        try {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf != -1 && Integer.parseInt(str.substring(0, iIndexOf)) > 255) {
                return false;
            }
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(46, i);
            if (iIndexOf2 != -1 && Integer.parseInt(str.substring(i, iIndexOf2)) > 255) {
                return false;
            }
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(46, i2);
            return iIndexOf3 == -1 || Integer.parseInt(str.substring(i2, iIndexOf3)) <= 255 || Integer.parseInt(str.substring(iIndexOf3 + 1, str.length() - 1)) <= 255 || str.charAt(str.length() - 1) == '.';
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
