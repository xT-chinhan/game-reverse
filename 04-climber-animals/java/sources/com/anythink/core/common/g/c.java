package com.anythink.core.common.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATOsDmEntity;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.q;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final long a = 86400000;
    public static final long b = 3600000;
    private static final String c = "DomainManager";
    private static final String d = "anythink_sdk";
    private static final String e = "ru";
    private static final String f = "api.";
    private static final String g = k.b("");
    private static volatile c s;
    private volatile boolean k;
    private volatile boolean l;
    private volatile long m;
    private volatile String p;
    private ArrayDeque<a> q;
    private ConcurrentHashMap<Long, String> r;
    private final Object h = new Object();
    private final Object i = new Object();
    private final List<String> j = Collections.synchronizedList(new ArrayList());
    private volatile String n = "";
    private volatile String o = "";

    /* JADX INFO: renamed from: com.anythink.core.common.g.c$c, reason: collision with other inner class name */
    private interface InterfaceC0082c {
        void a(int i, Object obj, long j);

        void a(int i, String str, AdError adError, long j);

        void a(String str);

        void b(String str);
    }

    private static void i() {
    }

    private c() {
        String[] strArr;
        this.p = "";
        if (ATSDK.isCnSDK() || (strArr = com.anythink.core.common.g.b.a) == null || strArr.length <= 0) {
            return;
        }
        List listAsList = Arrays.asList(strArr);
        String country = Locale.getDefault().getCountry();
        if (listAsList.contains(country)) {
            this.p = country;
        }
    }

    public static c a() {
        if (s == null) {
            synchronized (c.class) {
                s = new c();
            }
        }
        return s;
    }

    public final void a(Context context) {
        if (ATSDK.isCnSDK()) {
            return;
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        if (this.k) {
            return;
        }
        this.k = true;
        List<String> list = this.j;
        if (!c()) {
            list.add(j.g.a.a);
        }
        list.add(g);
        t.b();
        String strC = af.c(context, "anythink_sdk", u.a.G, "");
        if (!TextUtils.isEmpty(strC)) {
            a(list, strC);
        }
        s sVarC = t.b().c();
        if (sVarC != null && sVarC.getOsDmEntity() != null) {
            ATOsDmEntity osDmEntity = sVarC.getOsDmEntity();
            String mainDm = osDmEntity.getMainDm();
            if (!TextUtils.isEmpty(mainDm)) {
                list.clear();
                list.add(mainDm);
                String ruBpDm = osDmEntity.getRuBpDm();
                if (!TextUtils.isEmpty(ruBpDm)) {
                    list.add(ruBpDm);
                }
            }
        }
        e("initDomain() >>> curUseDomain = ".concat(String.valueOf(strC)));
        if (list.isEmpty()) {
            return;
        }
        this.o = list.get(0);
        if (TextUtils.isEmpty(this.o)) {
            return;
        }
        c(this.o);
    }

    public final String b() {
        return this.n;
    }

    private static void a(List<String> list) {
        s sVarC = t.b().c();
        if (sVarC == null || sVarC.getOsDmEntity() == null) {
            return;
        }
        ATOsDmEntity osDmEntity = sVarC.getOsDmEntity();
        String mainDm = osDmEntity.getMainDm();
        if (TextUtils.isEmpty(mainDm)) {
            return;
        }
        list.clear();
        list.add(mainDm);
        String ruBpDm = osDmEntity.getRuBpDm();
        if (TextUtils.isEmpty(ruBpDm)) {
            return;
        }
        list.add(ruBpDm);
    }

    private static String f() {
        t.b();
        return u.a.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.n = str;
        Context contextG = t.b().g();
        t.b();
        af.b(contextG, "anythink_sdk", u.a.G, str);
        e("setCurrentDomain() >>> currentDomain = ".concat(String.valueOf(str)));
    }

    public final String a(String str) {
        return a(str, "");
    }

    public final String a(String str, String str2) {
        return ATSDK.isCnSDK() ? str : b(str, d(str2));
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            if (str2.equals(host)) {
                return str;
            }
            e("replaceUrlDomainWithTarget() >>> start replace url, targetDomain: " + str2 + " url: " + str);
            return str.replace(host, str2);
        } catch (Throwable unused) {
            return str;
        }
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.n;
        }
        s sVarC = t.b().c();
        if (sVarC == null || sVarC.getOsDmEntity() == null) {
            return "";
        }
        ATOsDmEntity osDmEntity = sVarC.getOsDmEntity();
        str.hashCode();
        switch (str) {
            case "smart_wf":
                return osDmEntity.getSmartWFDm();
            case "bid":
                return osDmEntity.getBidDm();
            case "agent":
                return osDmEntity.getDaDm();
            case "tracking":
                return osDmEntity.getTkDm();
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<String> list, String str, String str2, String str3, int i, String str4, d dVar, AtomicBoolean atomicBoolean) {
        try {
            if (atomicBoolean.get()) {
                e("handleSwitchDomain() >>> have switch domain.");
                return;
            }
            atomicBoolean.set(true);
            String strA = a(list, str, str2);
            e("handleSwitchDomain() >>> targetDomain: " + strA + " currentDomain: " + this.n);
            if (!TextUtils.isEmpty(strA) && str2.equals(this.n)) {
                c(strA);
                com.anythink.core.d.d.a(t.b().g()).c();
                e.a(this.o, strA, str3, String.valueOf(b(t.b().g())), String.valueOf(i), str4, str2);
                a(dVar, strA, str2);
                return;
            }
            a(dVar, this.n, str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str, String str2, String str3, int i, String str4) {
        c(str);
        com.anythink.core.d.d.a(t.b().g()).c();
        e.a(this.o, str, str3, String.valueOf(b(t.b().g())), String.valueOf(i), str4, str2);
    }

    private static void a(d dVar, String str, String str2) {
        if (dVar != null && c(str, str2)) {
            dVar.a(str);
        }
    }

    private static boolean g() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        return (bVarB == null || TextUtils.isEmpty(bVarB.aG())) && q.a(t.b().g());
    }

    private static boolean c(String str, String str2) {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        return ((bVarB != null && !TextUtils.isEmpty(bVarB.aG())) || TextUtils.isEmpty(str) || str.equals(str2)) ? false : true;
    }

    private String a(List<String> list, String str, String str2) {
        String str3 = "";
        if (list == null) {
            return "";
        }
        try {
            a(list, str);
            for (String str4 : list) {
                if (!TextUtils.isEmpty(str4) && !str4.equals(str2)) {
                    str3 = str4;
                    break;
                }
            }
            a(list, str3);
            String strC = c(t.b().g());
            if (c() && !TextUtils.isEmpty(strC) && !strC.equals(str2)) {
                list.remove(str2);
            } else if (!TextUtils.isEmpty(str2) && list != null) {
                try {
                    int iIndexOf = list.indexOf(str2);
                    if (iIndexOf >= 0 && iIndexOf < list.size() - 1) {
                        list.remove(str2);
                        list.add(str2);
                    } else if (iIndexOf < 0) {
                        list.add(str2);
                    }
                } catch (Throwable unused) {
                }
            }
            e("getNextDomain() >>> nextDomain = " + str3 + " failedDomain = " + str2);
        } catch (Throwable unused2) {
        }
        return str3;
    }

    private static void a(List<String> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return;
        }
        try {
            int iIndexOf = list.indexOf(str);
            if (iIndexOf > 0) {
                list.remove(str);
                list.add(0, str);
            } else if (iIndexOf < 0) {
                list.add(0, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void b(List<String> list, String str) {
        if (TextUtils.isEmpty(str) || list == null) {
            return;
        }
        try {
            int iIndexOf = list.indexOf(str);
            if (iIndexOf >= 0 && iIndexOf < list.size() - 1) {
                list.remove(str);
                list.add(str);
            } else if (iIndexOf < 0) {
                list.add(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long b(Context context) {
        long jB = this.m;
        if (jB == 0) {
            jB = af.b(context, "anythink_sdk", u.a.F, 0L);
        }
        return Long.valueOf(jB);
    }

    public static boolean c() {
        String language;
        try {
            language = Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            language = "";
        }
        return language.equalsIgnoreCase(e);
    }

    private static void h() {
        com.anythink.core.d.d.a(t.b().g()).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        Thread.currentThread().getId();
    }

    private void a(String str, String str2, int i, String str3, String str4) {
        e.a(this.o, str, str2, String.valueOf(b(t.b().g())), String.valueOf(i), str3, str4);
    }

    public static String d() {
        return g;
    }

    private void a(List<String> list, String str, Context context) {
        if (list == null) {
            return;
        }
        try {
            list.remove(g);
            String strC = c(context);
            if (!TextUtils.isEmpty(strC) && !strC.equals(str)) {
                list.remove(strC);
            }
            a(list, str);
            e("replaceCdnDomainInList() >>>> cdnDomain: " + str + " lastCdnDomain: " + strC);
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z, String str, long j, int i) {
        e.a(this.o, this.n, "", String.valueOf(this.m), "", "", "", "1", z ? "1" : "0", str, String.valueOf(j), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar, boolean z) {
        if (dVar == null) {
            return;
        }
        synchronized (this.i) {
            if (this.q == null) {
                this.q = new ArrayDeque<>();
            }
            this.q.addLast(new a(dVar, z));
        }
        e("addDomainRequest() >>> called");
    }

    private a j() {
        a aVarRemoveFirst;
        ArrayDeque<a> arrayDeque = this.q;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return null;
        }
        synchronized (this.i) {
            aVarRemoveFirst = this.q.removeFirst();
        }
        e("getDomainRequest() >>> called");
        return aVarRemoveFirst;
    }

    private void a(Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.m = jCurrentTimeMillis;
        af.a(context, "anythink_sdk", u.a.F, jCurrentTimeMillis);
        k().put(Long.valueOf(jCurrentTimeMillis), str);
        af.b(context, "anythink_sdk", u.a.H, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        String str = this.m > 0 ? k().get(Long.valueOf(this.m)) : "";
        return TextUtils.isEmpty(str) ? af.c(context, "anythink_sdk", u.a.H, "") : str;
    }

    private synchronized ConcurrentHashMap<Long, String> k() {
        if (this.r == null) {
            this.r = new ConcurrentHashMap<>(1);
        }
        return this.r;
    }

    private static long l() {
        return c() ? 3600000L : 86400000L;
    }

    public final void a(d dVar) {
        a(dVar, true);
    }

    public final void a(final d dVar, boolean z) {
        final boolean z2 = c() && z;
        a(new InterfaceC0082c() { // from class: com.anythink.core.common.g.c.2
            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(int i, String str, AdError adError, long j) {
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void b(String str) {
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(String str) {
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(str);
                }
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(int i, Object obj, long j) {
                if (!(obj instanceof String) || TextUtils.isEmpty(obj.toString())) {
                    return;
                }
                Context contextG = t.b().g();
                String string = obj.toString();
                c cVar = c.this;
                c.a(cVar, cVar.j, string, contextG);
                if (z2) {
                    c.this.c(string);
                }
            }
        }, z2);
    }

    private void a(InterfaceC0082c interfaceC0082c, final boolean z) {
        String str = this.n;
        final Context contextG = t.b().g();
        if (contextG == null || ATSDK.isCnSDK() || !q.a(contextG)) {
            interfaceC0082c.a(str);
            return;
        }
        final b bVar = new b(interfaceC0082c);
        if (!z) {
            bVar.a(str);
        }
        if (this.l) {
            b(bVar, z);
        } else {
            com.anythink.core.common.v.b.b.a().c(new Runnable() { // from class: com.anythink.core.common.g.c.3
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (c.this.h) {
                        if (c.this.l) {
                            c.this.b(bVar, z);
                            return;
                        }
                        c.this.l = true;
                        c cVar = c.this;
                        cVar.m = cVar.b(contextG).longValue();
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        long j = jCurrentTimeMillis - c.this.m;
                        long jE = c.e();
                        if (c.this.m > 0 && j < jE) {
                            String strC = c.this.c(contextG);
                            c.e("requestDomain() >>> cache valid. cdnDomain: ".concat(String.valueOf(strC)));
                            if (!TextUtils.isEmpty(strC)) {
                                c.this.l = false;
                                bVar.b(strC);
                                c.e(c.this);
                                return;
                            }
                        }
                        c.e("requestDomain() >>> cache was expired. start request. currentDomain: " + c.this.n);
                        com.anythink.core.d.a aVar = new com.anythink.core.d.a(com.anythink.core.d.d.a());
                        final int iA = aVar.a();
                        aVar.a(new com.anythink.core.common.m.b() { // from class: com.anythink.core.common.g.c.3.1
                            @Override // com.anythink.core.common.m.q
                            public final void onLoadFinish(int i, Object obj) {
                                String strConcat;
                                c.this.l = false;
                                String strOptString = "";
                                try {
                                    if (!(obj instanceof String) || TextUtils.isEmpty(obj.toString())) {
                                        strConcat = "";
                                    } else {
                                        JSONObject jSONObject = new JSONObject(obj.toString());
                                        int iOptInt = jSONObject.optInt("code", 0);
                                        if (iOptInt == 0) {
                                            strConcat = "";
                                            strOptString = jSONObject.optString("data");
                                        } else {
                                            strConcat = "request failed. error code: ".concat(String.valueOf(iOptInt));
                                        }
                                    }
                                } catch (Throwable th) {
                                    strConcat = "parse cdn domain error: " + th.getMessage();
                                }
                                if (!TextUtils.isEmpty(strOptString)) {
                                    c.a(c.this, contextG, strOptString);
                                }
                                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                Object[] objArr = new Object[4];
                                String unused = c.this.n;
                                if (TextUtils.isEmpty(strConcat)) {
                                    c.a(c.this, true, strOptString, jCurrentTimeMillis2, iA);
                                    bVar.a(0, strOptString, jCurrentTimeMillis);
                                } else {
                                    String str2 = strConcat;
                                    c.a(c.this, false, str2, jCurrentTimeMillis2, iA);
                                    bVar.a(0, str2, null, jCurrentTimeMillis);
                                }
                                c.e(c.this);
                            }

                            @Override // com.anythink.core.common.m.q
                            public final void onLoadError(int i, String str2, AdError adError) {
                                c.this.l = false;
                                c.a(c.this, false, str2, System.currentTimeMillis() - jCurrentTimeMillis, iA);
                                bVar.a(-1, str2, null, jCurrentTimeMillis);
                                c.e(c.this);
                            }
                        });
                    }
                }
            }, 13);
        }
    }

    private void m() {
        try {
            a aVarJ = j();
            if (aVarJ != null) {
                d dVarA = aVarJ.a();
                boolean zB = aVarJ.b();
                e("requestDomainNext() >>> next domainRequest: " + dVarA + " awaitResponse: " + zB);
                if (dVarA != null) {
                    a(dVarA, zB);
                }
            }
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    private static class b implements InterfaceC0082c, d {
        private boolean a;
        private final InterfaceC0082c b;

        public b(InterfaceC0082c interfaceC0082c) {
            this.b = interfaceC0082c;
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0082c
        public final void a(String str) {
            InterfaceC0082c interfaceC0082c;
            if (this.a || (interfaceC0082c = this.b) == null) {
                return;
            }
            this.a = true;
            interfaceC0082c.a(str);
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0082c
        public final void b(String str) {
            Object[] objArr = new Object[1];
            InterfaceC0082c interfaceC0082c = this.b;
            if (interfaceC0082c != null) {
                interfaceC0082c.b(str);
            }
            a(str);
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0082c
        public final void a(int i, String str, AdError adError, long j) {
            Object[] objArr = new Object[2];
            InterfaceC0082c interfaceC0082c = this.b;
            if (interfaceC0082c != null) {
                interfaceC0082c.a(i, str, adError, j);
            }
            a("");
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0082c
        public final void a(int i, Object obj, long j) {
            Object[] objArr = new Object[1];
            InterfaceC0082c interfaceC0082c = this.b;
            if (interfaceC0082c != null) {
                interfaceC0082c.a(i, obj, j);
            }
            a(obj != null ? obj.toString() : "");
        }
    }

    private static class a {
        private d a;
        private boolean b;

        public a(d dVar, boolean z) {
            this.a = dVar;
            this.b = z;
        }

        public final d a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    public final void a(final String str, final int i, final String str2, final d dVar) {
        String host;
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (!((bVarB == null || TextUtils.isEmpty(bVarB.aG())) && q.a(t.b().g()))) {
            e("tryGetDomainFromCdn() >>> not allow switch domain.");
            return;
        }
        try {
            host = new URL(str).getHost();
        } catch (Exception e2) {
            e("tryGetDomainFromCdn() >>> failed: " + e2.getMessage());
            host = "";
        }
        final String str3 = host;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final List<String> list = this.j;
        e("tryGetDomainFromCdn() >>> start isTrying: " + this.l + " url: " + str + " failedDomain: " + str3);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        a(new InterfaceC0082c() { // from class: com.anythink.core.common.g.c.1
            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(String str4) {
                c.e("tryGetDomainFromCdn() >>> onCallback::domain = ".concat(String.valueOf(str4)));
                c.this.a(list, "", str3, str, i, str2, dVar, atomicBoolean);
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void b(String str4) {
                c.e("tryGetDomainFromCdn() >>> onCallbackCached::cacheDomain = ".concat(String.valueOf(str4)));
                c.this.a(list, str4, str3, str, i, str2, dVar, atomicBoolean);
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(int i2, String str4, AdError adError, long j) {
                c.e("tryGetDomainFromCdn() >>> onCallbackFailed::msg = ".concat(String.valueOf(str4)));
                c.this.a(list, "", str3, str, i, str2, dVar, atomicBoolean);
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0082c
            public final void a(int i2, Object obj, long j) {
                c.e("tryGetDomainFromCdn() >>> onCallbackSucceed::result = ".concat(String.valueOf(obj)));
                if (!(obj instanceof String) || TextUtils.isEmpty(obj.toString())) {
                    c.this.a(list, "", str3, str, i, str2, dVar, atomicBoolean);
                    return;
                }
                Context contextG = t.b().g();
                String string = obj.toString();
                c.a(c.this, list, string, contextG);
                c.this.a(list, string, str3, str, i, str2, dVar, atomicBoolean);
            }
        }, true);
    }

    static /* synthetic */ void a(c cVar, List list, String str, Context context) {
        if (list != null) {
            try {
                list.remove(g);
                String strC = cVar.c(context);
                if (!TextUtils.isEmpty(strC) && !strC.equals(str)) {
                    list.remove(strC);
                }
                a((List<String>) list, str);
                e("replaceCdnDomainInList() >>>> cdnDomain: " + str + " lastCdnDomain: " + strC);
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ long e() {
        return c() ? 3600000L : 86400000L;
    }

    static /* synthetic */ void e(c cVar) {
        try {
            a aVarJ = cVar.j();
            if (aVarJ != null) {
                d dVarA = aVarJ.a();
                boolean zB = aVarJ.b();
                e("requestDomainNext() >>> next domainRequest: " + dVarA + " awaitResponse: " + zB);
                if (dVarA != null) {
                    cVar.a(dVarA, zB);
                }
            }
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    static /* synthetic */ void a(c cVar, Context context, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.m = jCurrentTimeMillis;
        af.a(context, "anythink_sdk", u.a.F, jCurrentTimeMillis);
        cVar.k().put(Long.valueOf(jCurrentTimeMillis), str);
        af.b(context, "anythink_sdk", u.a.H, str);
    }

    static /* synthetic */ void a(c cVar, boolean z, String str, long j, int i) {
        e.a(cVar.o, cVar.n, "", String.valueOf(cVar.m), "", "", "", "1", z ? "1" : "0", str, String.valueOf(j), i);
    }
}
