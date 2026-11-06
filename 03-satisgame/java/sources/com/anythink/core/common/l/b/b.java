package com.anythink.core.common.l.b;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";
    private static final int b = 5;
    private static final int c = 100;
    private static final int d = 3;
    private static final long e = 3600000;
    private static volatile b f;
    private static final Comparator<C0033b> h = new Comparator<C0033b>() { // from class: com.anythink.core.common.l.b.b.2
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(C0033b c0033b, C0033b c0033b2) {
            return Long.compare(c0033b2.b, c0033b.b);
        }

        private static int a(C0033b c0033b, C0033b c0033b2) {
            return Long.compare(c0033b2.b, c0033b.b);
        }
    };
    private final LinkedHashMap<String, a> g = new LinkedHashMap<String, a>() { // from class: com.anythink.core.common.l.b.b.1
        @Override // java.util.LinkedHashMap
        protected final boolean removeEldestEntry(Map.Entry<String, a> entry) {
            return size() > 100;
        }
    };

    private b() {
    }

    public static b a() {
        if (f == null) {
            synchronized (b.class) {
                if (f == null) {
                    f = new b();
                }
            }
        }
        return f;
    }

    public final synchronized void a(String str, String str2) {
        if (d(str, str2)) {
            return;
        }
        a aVar = this.g.get(str);
        byte b2 = 0;
        if (aVar == null) {
            aVar = new a(b2);
            this.g.put(str, aVar);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a(aVar, jElapsedRealtime);
        Long l = aVar.b.get(str2);
        if (l == null || l.longValue() <= jElapsedRealtime) {
            C0033b c0033bA = a(aVar.a, str2);
            if (c0033bA != null) {
                c0033bA.b = jElapsedRealtime;
                c0033bA.c++;
                c0033bA.d = 0;
                return;
            }
            if (aVar.a.size() >= 5) {
                C0033b c0033b = null;
                for (C0033b c0033b2 : aVar.a) {
                    if (c0033b == null || c0033b2.b < c0033b.b) {
                        c0033b = c0033b2;
                    }
                }
                if (c0033b != null) {
                    aVar.a.remove(c0033b);
                }
            }
            C0033b c0033b3 = new C0033b(str2);
            c0033b3.b = jElapsedRealtime;
            c0033b3.c = 1;
            aVar.a.add(c0033b3);
        }
    }

    public final synchronized boolean b(String str, String str2) {
        if (d(str, str2)) {
            return false;
        }
        a aVar = this.g.get(str);
        if (aVar == null) {
            return false;
        }
        a(aVar, SystemClock.elapsedRealtime());
        C0033b c0033bA = a(aVar.a, str2);
        if (c0033bA == null) {
            return false;
        }
        c0033bA.d++;
        if (c0033bA.d < 3) {
            return false;
        }
        aVar.a.remove(c0033bA);
        aVar.b.put(str2, Long.valueOf(SystemClock.elapsedRealtime() + e));
        return true;
    }

    public final synchronized List<String> a(String str) {
        try {
            if (str == null) {
                return Collections.emptyList();
            }
            a aVar = this.g.get(str);
            if (aVar != null && !aVar.a.isEmpty()) {
                ArrayList arrayList = new ArrayList(aVar.a);
                Collections.sort(arrayList, h);
                int iMin = Math.min(3, arrayList.size());
                ArrayList arrayList2 = new ArrayList(iMin);
                for (int i = 0; i < iMin; i++) {
                    arrayList2.add(((C0033b) arrayList.get(i)).a);
                }
                return arrayList2;
            }
            return Collections.emptyList();
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized boolean c(String str, String str2) {
        if (d(str, str2)) {
            return false;
        }
        a aVar = this.g.get(str);
        if (aVar == null) {
            return false;
        }
        Long l = aVar.b.get(str2);
        return l != null && l.longValue() > SystemClock.elapsedRealtime();
    }

    private synchronized void b() {
        this.g.clear();
    }

    private synchronized int c() {
        return this.g.size();
    }

    private synchronized int b(String str) {
        a aVar = str != null ? this.g.get(str) : null;
        if (aVar == null) {
            return 0;
        }
        return aVar.a.size();
    }

    private static boolean d(String str, String str2) {
        return str == null || str.isEmpty() || str2 == null || str2.isEmpty();
    }

    private static C0033b a(List<C0033b> list, String str) {
        for (C0033b c0033b : list) {
            if (str.equals(c0033b.a)) {
                return c0033b;
            }
        }
        return null;
    }

    private static void a(a aVar, long j) {
        if (aVar.b.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it = aVar.b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().longValue() <= j) {
                it.remove();
            }
        }
    }

    private static class a {
        final List<C0033b> a;
        final Map<String, Long> b;

        private a() {
            this.a = new ArrayList(5);
            this.b = new HashMap(4);
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.l.b.b$b, reason: collision with other inner class name */
    public static class C0033b {
        public final String a;
        public long b;
        public int c;
        public int d;

        C0033b(String str) {
            this.a = str;
        }
    }
}
