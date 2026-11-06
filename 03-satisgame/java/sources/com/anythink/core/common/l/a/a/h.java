package com.anythink.core.common.l.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.m.a.j;
import com.anythink.core.common.m.a.k;
import com.anythink.core.common.m.a.m;
import com.anythink.core.common.m.a.o;
import com.anythink.core.common.m.b.q;
import com.byazt.iip.l$$ExternalSyntheticBackport0;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String a = "h";
    private static final int b = 3;
    private static final long c = 300000;
    private static final int d = 100;
    private static final long e = 12000;
    private static final Map<String, Long> f = new LinkedHashMap<String, Long>() { // from class: com.anythink.core.common.l.a.a.h.1
        @Override // java.util.LinkedHashMap
        protected final boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return size() > 100;
        }
    };

    private static int a(Throwable th, Throwable th2, boolean z) {
        if (!z) {
            return 1;
        }
        if (th != null) {
            return 2;
        }
        return th2 != null ? 3 : 4;
    }

    private h() {
    }

    public static List<InetAddress> a(String str, boolean z, com.anythink.core.common.l.c.a aVar) {
        return a(str, z, aVar, 0L);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0086  */
    public static List<InetAddress> a(String str, boolean z, com.anythink.core.common.l.c.a aVar, long j) throws UnknownHostException {
        RuntimeException runtimeException;
        String str2;
        if (a(j)) {
            throw b(str);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        List<InetAddress> listB = b(str, aVar);
        if (a(j)) {
            throw b(str);
        }
        if (listB != null && !listB.isEmpty()) {
            if (aVar != null) {
                aVar.d(1);
                aVar.d(SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
            return listB;
        }
        if (z) {
            boolean zA = a();
            boolean zB = b();
            if (zA || zB) {
                List<InetAddress> listA = a(str, aVar, jElapsedRealtime, zA, zB, j);
                if (a(j)) {
                    throw b(str);
                }
                if (listA != null && !listA.isEmpty()) {
                    return listA;
                }
                runtimeException = new RuntimeException("L2/L3 both failed/empty (includeL2=" + zA + ", includeL3=" + zB + ")");
            } else {
                runtimeException = null;
            }
        } else {
            runtimeException = null;
        }
        if (a(j)) {
            throw b(str);
        }
        List<InetAddress> listD = d(str);
        if (listD != null && !listD.isEmpty()) {
            if (a(j)) {
                throw b(str);
            }
            if (aVar != null) {
                aVar.d(4);
                aVar.d(SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
            e(str);
            return listD;
        }
        if (aVar != null) {
            aVar.d(0);
            aVar.d(SystemClock.elapsedRealtime() - jElapsedRealtime);
            aVar.e(a(runtimeException, (Throwable) null, z));
        }
        if (runtimeException != null) {
            str2 = runtimeException + ": " + runtimeException.getMessage();
        } else {
            str2 = "cant not resolve \"" + str + "\".";
        }
        if (aVar != null && TextUtils.isEmpty(aVar.k())) {
            aVar.c(str2);
        }
        throw new UnknownHostException(str2);
    }

    private static boolean a(long j) {
        return j > 0 && SystemClock.elapsedRealtime() >= j;
    }

    private static UnknownHostException b(String str) {
        UnknownHostException unknownHostException = new UnknownHostException("DNS resolve deadline exceeded: ".concat(String.valueOf(str)));
        try {
            unknownHostException.initCause(new SocketTimeoutException("DNS resolve deadline exceeded"));
        } catch (Throwable unused) {
        }
        return unknownHostException;
    }

    private static long a(long j, long j2) {
        return j <= 0 ? e : Math.max(0L, Math.min(e, j - j2));
    }

    private static List<InetAddress> b(String str, com.anythink.core.common.l.c.a aVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            List<InetAddress> listA = q.b.a(str);
            if (aVar != null) {
                aVar.b(SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
            List<InetAddress> listA2 = d.a(listA);
            if (listA2 != null && !listA2.isEmpty()) {
                return listA2;
            }
            if (listA == null || listA.isEmpty() || aVar == null) {
                return null;
            }
            aVar.h();
            aVar.b("All " + listA.size() + " address(es) filtered as invalid (likely DNS hijacking)");
            return null;
        } catch (Throwable th) {
            if (aVar == null) {
                return null;
            }
            aVar.h();
            aVar.b(th + ": " + th.getMessage());
            return null;
        }
    }

    private static List<InetAddress> c(String str, com.anythink.core.common.l.c.a aVar) {
        k[] kVarArrB;
        if (aVar != null) {
            aVar.o();
        }
        com.anythink.core.common.m.a.d dVarA = com.anythink.core.common.m.a.d.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = dVarA.b();
        if (!zB && (kVarArrB = com.anythink.core.common.l.c.c.b()) != null && kVarArrB.length > 0) {
            dVarA.a(m.j, kVarArrB);
            zB = dVarA.b();
        }
        if (!zB) {
            throw new IllegalArgumentException("init custom dns server failed.");
        }
        o oVarA = dVarA.a(new j(str));
        ArrayList arrayList = null;
        com.anythink.core.common.m.a.g gVarB = oVarA != null ? oVarA.b() : null;
        if (aVar != null) {
            aVar.c(SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (gVarB != null) {
                aVar.a(gVarB.a());
                aVar.a(gVarB.b());
                aVar.a(gVarB.c());
            }
        }
        InetAddress[] inetAddressArrA = oVarA != null ? oVarA.a() : null;
        if (inetAddressArrA != null && inetAddressArrA.length > 0) {
            arrayList = new ArrayList();
            Collections.addAll(arrayList, inetAddressArrA);
            if (aVar != null) {
                aVar.b(1);
            }
        }
        return arrayList;
    }

    private static List<InetAddress> c(String str) {
        List<InetAddress> listA = com.anythink.core.common.m.a.a.a().a(str);
        if (listA != null) {
            listA.isEmpty();
        }
        return listA;
    }

    private static boolean a() {
        try {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            return bVarA == null || bVarA.aD();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b() {
        try {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            return bVarA == null || bVarA.aE();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static List<InetAddress> a(final String str, final com.anythink.core.common.l.c.a aVar, long j, boolean z, boolean z2, long j2) {
        if (!z && !z2) {
            return null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final AtomicInteger atomicInteger2 = new AtomicInteger((z ? 1 : 0) + (z2 ? 1 : 0));
        if (z) {
            try {
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new Runnable() { // from class: com.anythink.core.common.l.a.a.h.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            List<InetAddress> listA = d.a(h.a(str, aVar));
                            if (listA != null && !listA.isEmpty() && l$$ExternalSyntheticBackport0.m(atomicReference, null, listA)) {
                                atomicInteger.set(2);
                                countDownLatch.countDown();
                            }
                            if (atomicInteger2.decrementAndGet() != 0 || atomicReference.get() != null) {
                            }
                        } catch (Throwable th) {
                            try {
                                com.anythink.core.common.l.c.a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.c(th + ": " + th.getMessage());
                                }
                            } finally {
                                if (atomicInteger2.decrementAndGet() == 0 && atomicReference.get() == null) {
                                    countDownLatch.countDown();
                                }
                            }
                        }
                    }
                }));
            } catch (Throwable unused) {
                if (atomicInteger2.decrementAndGet() == 0 && atomicReference.get() == null) {
                    countDownLatch.countDown();
                }
            }
        }
        if (z2) {
            try {
                com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new Runnable() { // from class: com.anythink.core.common.l.a.a.h.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            List<InetAddress> listA = d.a(h.a(str));
                            if (listA != null && !listA.isEmpty() && l$$ExternalSyntheticBackport0.m(atomicReference, null, listA)) {
                                atomicInteger.set(3);
                                countDownLatch.countDown();
                            }
                            if (atomicInteger2.decrementAndGet() != 0 || atomicReference.get() != null) {
                                return;
                            }
                        } catch (Throwable unused2) {
                            if (atomicInteger2.decrementAndGet() != 0 || atomicReference.get() != null) {
                                return;
                            }
                        }
                        countDownLatch.countDown();
                    }
                }));
            } catch (Throwable unused2) {
                if (atomicInteger2.decrementAndGet() == 0 && atomicReference.get() == null) {
                    countDownLatch.countDown();
                }
            }
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = e;
            if (j2 > 0) {
                jMax = Math.max(0L, Math.min(e, j2 - jElapsedRealtime));
            }
            if (jMax > 0) {
                countDownLatch.await(jMax, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException unused3) {
            Thread.currentThread().interrupt();
        }
        List<InetAddress> list = (List) atomicReference.get();
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (aVar != null) {
            aVar.d(atomicInteger.get());
            aVar.d(SystemClock.elapsedRealtime() - j);
        }
        return list;
    }

    private static List<InetAddress> d(String str) {
        List<String> listA = com.anythink.core.common.l.b.b.a().a(str);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        List<InetAddress> listA2 = com.anythink.core.common.l.b.a.a(str, listA);
        if (listA2.isEmpty()) {
            return null;
        }
        return listA2;
    }

    private static void e(final String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, Long> map = f;
        synchronized (map) {
            Long l = map.get(str);
            if (l == null || jElapsedRealtime - l.longValue() >= c) {
                map.put(str, Long.valueOf(jElapsedRealtime));
                try {
                    com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.a, new Runnable() { // from class: com.anythink.core.common.l.a.a.h.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                q.b.a(str);
                            } catch (Throwable unused) {
                            }
                        }
                    }));
                } catch (Throwable unused) {
                }
            }
        }
    }

    static /* synthetic */ List a(String str, com.anythink.core.common.l.c.a aVar) {
        k[] kVarArrB;
        if (aVar != null) {
            aVar.o();
        }
        com.anythink.core.common.m.a.d dVarA = com.anythink.core.common.m.a.d.a();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zB = dVarA.b();
        if (!zB && (kVarArrB = com.anythink.core.common.l.c.c.b()) != null && kVarArrB.length > 0) {
            dVarA.a(m.j, kVarArrB);
            zB = dVarA.b();
        }
        if (!zB) {
            throw new IllegalArgumentException("init custom dns server failed.");
        }
        o oVarA = dVarA.a(new j(str));
        ArrayList arrayList = null;
        com.anythink.core.common.m.a.g gVarB = oVarA != null ? oVarA.b() : null;
        if (aVar != null) {
            aVar.c(SystemClock.elapsedRealtime() - jElapsedRealtime);
            if (gVarB != null) {
                aVar.a(gVarB.a());
                aVar.a(gVarB.b());
                aVar.a(gVarB.c());
            }
        }
        InetAddress[] inetAddressArrA = oVarA != null ? oVarA.a() : null;
        if (inetAddressArrA != null && inetAddressArrA.length > 0) {
            arrayList = new ArrayList();
            Collections.addAll(arrayList, inetAddressArrA);
            if (aVar != null) {
                aVar.b(1);
            }
        }
        return arrayList;
    }

    static /* synthetic */ List a(String str) {
        List<InetAddress> listA = com.anythink.core.common.m.a.a.a().a(str);
        if (listA != null) {
            listA.isEmpty();
        }
        return listA;
    }
}
