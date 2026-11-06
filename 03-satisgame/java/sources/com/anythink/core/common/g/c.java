package com.anythink.core.common.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATOsDmEntity;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.b.e;
import com.anythink.core.common.u.j;
import com.anythink.core.common.u.p;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final long a = 1800000;
    private static final String b = "DomainManager";
    private static final String c = "anythink_sdk";
    private static final String d = "ru";
    private static final String e = "api.";
    private static final String f = j.b("");
    private static volatile c w;
    private volatile boolean i;
    private volatile boolean j;
    private volatile long k;
    private ArrayDeque<a> p;
    private String q;
    private String r;
    private String s;
    private String t;
    private int u;
    private int v;
    private final Object g = new Object();
    private final Object h = new Object();
    private volatile String l = "";
    private volatile String m = "";
    private volatile String n = "";
    private volatile String o = "";

    /* JADX INFO: renamed from: com.anythink.core.common.g.c$c, reason: collision with other inner class name */
    private interface InterfaceC0019c {
        void a(int i, Object obj, Object obj2, long j);

        void a(int i, String str, AdError adError, long j);

        void a(String str, String str2);

        void b(String str, String str2);
    }

    static /* synthetic */ void g() {
    }

    private static void j() {
    }

    private static void k() {
    }

    private static long m() {
        return a;
    }

    private c() {
    }

    public static c a() {
        if (w == null) {
            synchronized (c.class) {
                w = new c();
            }
        }
        return w;
    }

    public final void a(Context context) {
        if (ATSDK.isCnSDK()) {
            return;
        }
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        if (this.i) {
            return;
        }
        this.i = true;
        boolean zD = d();
        this.n = zD ? f : i.g.a.a;
        this.o = i.g.a.b;
        r rVarC = s.b().c();
        if (rVarC != null && rVarC.getOsDmEntity() != null) {
            ATOsDmEntity osDmEntity = rVarC.getOsDmEntity();
            String mainDm = osDmEntity.getMainDm();
            if (!TextUtils.isEmpty(mainDm)) {
                this.n = mainDm;
                String ruBpDm = osDmEntity.getRuBpDm();
                if (zD && !TextUtils.isEmpty(ruBpDm)) {
                    this.n = ruBpDm;
                }
            }
            String backupDm = osDmEntity.getBackupDm();
            if (!TextUtils.isEmpty(backupDm)) {
                this.o = backupDm;
            }
        }
        s.b();
        String strC = ad.c(context, "anythink_sdk", t.a.J, "");
        if (!TextUtils.isEmpty(strC)) {
            this.n = strC;
        }
        s.b();
        String strC2 = ad.c(context, "anythink_sdk", t.a.K, "");
        if (!TextUtils.isEmpty(strC2)) {
            this.o = strC2;
        }
        c(this.n, this.o);
    }

    private static String a(boolean z) {
        String strAK;
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        if (bVarA != null) {
            strAK = z ? bVarA.aK() : bVarA.aL();
        } else {
            strAK = "";
        }
        if (TextUtils.isEmpty(strAK)) {
            return z ? i.g.a.a : i.g.a.b;
        }
        return strAK;
    }

    public final String b() {
        if (ATSDK.isCnSDK()) {
            return a(true);
        }
        return this.l;
    }

    public final String c() {
        if (ATSDK.isCnSDK()) {
            return a(false);
        }
        return this.m;
    }

    private static String h() {
        s.b();
        return t.a.J;
    }

    private static String i() {
        s.b();
        return t.a.K;
    }

    private void c(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.l = str;
            Context contextG = s.b().g();
            s.b();
            ad.b(contextG, "anythink_sdk", t.a.J, str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.m = str2;
        Context contextG2 = s.b().g();
        s.b();
        ad.b(contextG2, "anythink_sdk", t.a.K, str2);
    }

    public final String a(String str, String str2) {
        return a(str, str2, true);
    }

    public final String a(String str, String str2, boolean z) {
        return ATSDK.isCnSDK() ? str : b(str, a(str2, z));
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            return !str2.equals(host) ? str.replace(host, str2) : str;
        } catch (Throwable unused) {
            return str;
        }
    }

    private String a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z ? this.l : this.m;
        }
        r rVarC = s.b().c();
        if (rVarC == null || rVarC.getOsDmEntity() == null) {
            return "";
        }
        ATOsDmEntity osDmEntity = rVarC.getOsDmEntity();
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

    public final void a(String str, String str2, String str3, boolean z, String str4) {
        String str5 = this.l;
        String str6 = this.m;
        c(str, str2);
        if (z) {
            com.anythink.core.e.d.a(s.b().g()).c(str4);
        }
        f.a(this.n, str, str3, String.valueOf(g(s.b().g())), "", "", str5, "", "", "", "", 0, str2, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long g(Context context) {
        long jB = this.k;
        if (jB == 0) {
            jB = ad.b(context, "anythink_sdk", t.a.I, 0L);
        }
        return Long.valueOf(jB);
    }

    public static boolean d() {
        String language;
        try {
            language = Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            language = "";
        }
        return language.equalsIgnoreCase(d);
    }

    private static void e(String str) {
        com.anythink.core.e.d.a(s.b().g()).c(str);
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        f.a(this.n, str, str5, String.valueOf(g(s.b().g())), "", "", str3, "", "", "", "", 0, str2, str4);
    }

    public static String e() {
        return f;
    }

    private void a(boolean z, String str, String str2, long j, int i) {
        f.a(this.n, this.l, "", String.valueOf(this.k), "", "", "", "1", z ? "1" : "0", str, String.valueOf(j), i, str2, this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z) {
        if (dVar == null) {
            return;
        }
        synchronized (this.h) {
            if (this.p == null) {
                this.p = new ArrayDeque<>();
            }
            this.p.addLast(new a(dVar, z));
        }
    }

    private a l() {
        a aVarRemoveFirst;
        ArrayDeque<a> arrayDeque = this.p;
        if (arrayDeque == null || arrayDeque.isEmpty()) {
            return null;
        }
        synchronized (this.h) {
            aVarRemoveFirst = this.p.removeFirst();
        }
        return aVarRemoveFirst;
    }

    private void h(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.k = jCurrentTimeMillis;
        ad.a(context, "anythink_sdk", t.a.I, jCurrentTimeMillis);
    }

    private void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.q = str;
            ad.b(context, "anythink_sdk", t.a.L, str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.r = str2;
        ad.b(context, "anythink_sdk", t.a.M, str2);
    }

    public final void b(Context context) {
        if (context == null) {
            return;
        }
        this.k = 0L;
        ad.a(context, "anythink_sdk", t.a.I);
    }

    private String i(Context context) {
        String str = this.q;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.L, "") : str;
    }

    private String j(Context context) {
        String str = this.r;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.M, "") : str;
    }

    private void a(Context context, String str, String str2, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            this.s = str;
            ad.b(context, "anythink_sdk", t.a.N, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.t = str2;
            ad.b(context, "anythink_sdk", t.a.O, str2);
        }
        if (i > 0) {
            this.u = i;
            ad.a(context, "anythink_sdk", t.a.P, i);
        }
        if (i2 > 0) {
            this.v = i2;
            ad.a(context, "anythink_sdk", t.a.Q, i2);
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(58);
        return iLastIndexOf < 0 ? str : str.substring(0, iLastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int iLastIndexOf = str.lastIndexOf(58);
        if (iLastIndexOf < 0) {
            return i.g.b.a;
        }
        try {
            int i = Integer.parseInt(str.substring(iLastIndexOf + 1).trim());
            return (i <= 0 || i > 65535) ? i.g.b.a : i;
        } catch (NumberFormatException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(58)) >= 0 && iLastIndexOf != str.length() - 1) {
            try {
                int i = Integer.parseInt(str.substring(iLastIndexOf + 1).trim());
                if (i > 0 && i <= 65535) {
                    return i;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private String k(Context context) {
        String str = this.s;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.N, "") : str;
    }

    private String l(Context context) {
        String str = this.t;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.O, "") : str;
    }

    private int m(Context context) {
        int i = this.u;
        return i > 0 ? i : ad.b(context, "anythink_sdk", t.a.P, 0);
    }

    private int n(Context context) {
        int i = this.v;
        return i > 0 ? i : ad.b(context, "anythink_sdk", t.a.Q, 0);
    }

    public final void a(d dVar) {
        b(dVar);
    }

    private void b(final d dVar) {
        a(new InterfaceC0019c() { // from class: com.anythink.core.common.g.c.1
            @Override // com.anythink.core.common.g.c.InterfaceC0019c
            public final void a(int i, Object obj, Object obj2, long j) {
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0019c
            public final void a(int i, String str, AdError adError, long j) {
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0019c
            public final void b(String str, String str2) {
            }

            @Override // com.anythink.core.common.g.c.InterfaceC0019c
            public final void a(String str, String str2) {
                d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a(str, str2);
                }
            }
        });
    }

    private void a(InterfaceC0019c interfaceC0019c) {
        String str = this.l;
        String str2 = this.m;
        final Context contextG = s.b().g();
        if (contextG == null || ATSDK.isCnSDK() || !p.a(contextG)) {
            interfaceC0019c.a(str, str2);
            return;
        }
        final b bVar = new b(interfaceC0019c);
        if (this.j) {
            a((d) bVar, true);
        } else {
            com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(e.aN, new Runnable() { // from class: com.anythink.core.common.g.c.2
                final /* synthetic */ boolean b = true;

                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (c.this.g) {
                        if (c.this.j) {
                            c.this.a(bVar, this.b);
                            return;
                        }
                        c.this.j = true;
                        c cVar = c.this;
                        cVar.k = cVar.g(contextG).longValue();
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        long j = jCurrentTimeMillis - c.this.k;
                        long unused = c.a;
                        if (c.this.k <= 0 || j >= c.a) {
                            String unused2 = c.this.l;
                            c.g();
                            com.anythink.core.e.a aVar = new com.anythink.core.e.a(com.anythink.core.e.d.a());
                            final int iA = aVar.a();
                            aVar.a(new com.anythink.core.common.l.c() { // from class: com.anythink.core.common.g.c.2.1
                                /* JADX WARN: Code duplicated, block: B:42:0x00e1  */
                                /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
                                @Override // com.anythink.core.common.l.s
                                public final void onLoadFinish(int i, Object obj) {
                                    Throwable th;
                                    String strOptString;
                                    String strB;
                                    String strB2;
                                    int i2;
                                    int i3;
                                    String str3;
                                    String str4;
                                    String str5;
                                    String str6;
                                    String str7;
                                    long jCurrentTimeMillis2;
                                    String strConcat;
                                    int i4 = 0;
                                    c.this.j = false;
                                    String str8 = "";
                                    try {
                                        if (!(obj instanceof String) || TextUtils.isEmpty(obj.toString())) {
                                            strConcat = "";
                                        } else {
                                            JSONObject jSONObject = new JSONObject(obj.toString());
                                            int iOptInt = jSONObject.optInt("code", 0);
                                            if (iOptInt == 0) {
                                                String strOptString2 = jSONObject.optString(com.anythink.core.common.l.f.R);
                                                try {
                                                    strOptString = jSONObject.optString("data_bck");
                                                    try {
                                                        String strOptString3 = jSONObject.optString("data_tcp");
                                                        String strOptString4 = jSONObject.optString("data_tcp_bck");
                                                        strB = c.b(strOptString3);
                                                        try {
                                                            strB2 = c.b(strOptString4);
                                                            try {
                                                                int iG = c.g(strOptString3);
                                                                try {
                                                                    int iH = c.h(strOptString4);
                                                                    i4 = iH > 0 ? iH : iG;
                                                                    c.d(c.this, contextG);
                                                                    i2 = i4;
                                                                    str4 = "";
                                                                    str3 = strOptString2;
                                                                    str5 = strB;
                                                                    str6 = strB2;
                                                                    i3 = iG;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    i4 = i4;
                                                                    str8 = strOptString2;
                                                                    i4 = iG;
                                                                    i2 = i4;
                                                                    i3 = i4;
                                                                    str3 = str8;
                                                                    str4 = "parse cdn domain error: " + th.getMessage();
                                                                    str5 = strB;
                                                                    str6 = strB2;
                                                                }
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                i4 = 0;
                                                                str8 = strOptString2;
                                                                i2 = i4;
                                                                i3 = i4;
                                                                str3 = str8;
                                                                str4 = "parse cdn domain error: " + th.getMessage();
                                                                str5 = strB;
                                                                str6 = strB2;
                                                                str7 = strOptString;
                                                                c.a(c.this, contextG, str3, str7);
                                                                c.a(c.this, contextG, str5, str6, i3, i2);
                                                                jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                                if (TextUtils.isEmpty(str4)) {
                                                                    String str9 = str3;
                                                                    c.a(c.this, true, str9, str7, jCurrentTimeMillis2, iA);
                                                                    bVar.a(0, str9, str7, jCurrentTimeMillis);
                                                                } else {
                                                                    String str10 = str4;
                                                                    c.a(c.this, false, str10, "", jCurrentTimeMillis2, iA);
                                                                    bVar.a(0, str10, (AdError) null, jCurrentTimeMillis);
                                                                }
                                                                c.d(c.this);
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            i4 = 0;
                                                            strB2 = "";
                                                        }
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        strB = "";
                                                        strB2 = strB;
                                                        str8 = strOptString2;
                                                        i2 = i4;
                                                        i3 = i4;
                                                        str3 = str8;
                                                        str4 = "parse cdn domain error: " + th.getMessage();
                                                        str5 = strB;
                                                        str6 = strB2;
                                                        str7 = strOptString;
                                                        c.a(c.this, contextG, str3, str7);
                                                        c.a(c.this, contextG, str5, str6, i3, i2);
                                                        jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                        if (TextUtils.isEmpty(str4)) {
                                                            String str11 = str3;
                                                            c.a(c.this, true, str11, str7, jCurrentTimeMillis2, iA);
                                                            bVar.a(0, str11, str7, jCurrentTimeMillis);
                                                        } else {
                                                            String str12 = str4;
                                                            c.a(c.this, false, str12, "", jCurrentTimeMillis2, iA);
                                                            bVar.a(0, str12, (AdError) null, jCurrentTimeMillis);
                                                        }
                                                        c.d(c.this);
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    strOptString = "";
                                                    strB = strOptString;
                                                }
                                                str7 = strOptString;
                                                c.a(c.this, contextG, str3, str7);
                                                c.a(c.this, contextG, str5, str6, i3, i2);
                                                jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                if (TextUtils.isEmpty(str4)) {
                                                    String str13 = str3;
                                                    c.a(c.this, true, str13, str7, jCurrentTimeMillis2, iA);
                                                    bVar.a(0, str13, str7, jCurrentTimeMillis);
                                                } else {
                                                    String str14 = str4;
                                                    c.a(c.this, false, str14, "", jCurrentTimeMillis2, iA);
                                                    bVar.a(0, str14, (AdError) null, jCurrentTimeMillis);
                                                }
                                                c.d(c.this);
                                            }
                                            strConcat = "request failed. error code: ".concat(String.valueOf(iOptInt));
                                        }
                                        str4 = strConcat;
                                        i3 = 0;
                                        i2 = 0;
                                        str3 = "";
                                        str7 = str3;
                                        str5 = str7;
                                        str6 = str5;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        i4 = 0;
                                        strOptString = "";
                                        strB = strOptString;
                                        strB2 = strB;
                                    }
                                    c.a(c.this, contextG, str3, str7);
                                    c.a(c.this, contextG, str5, str6, i3, i2);
                                    jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (TextUtils.isEmpty(str4)) {
                                        String str15 = str3;
                                        c.a(c.this, true, str15, str7, jCurrentTimeMillis2, iA);
                                        bVar.a(0, str15, str7, jCurrentTimeMillis);
                                    } else {
                                        String str16 = str4;
                                        c.a(c.this, false, str16, "", jCurrentTimeMillis2, iA);
                                        bVar.a(0, str16, (AdError) null, jCurrentTimeMillis);
                                    }
                                    c.d(c.this);
                                }

                                @Override // com.anythink.core.common.l.s
                                public final void onLoadError(int i, String str3, AdError adError) {
                                    c.this.j = false;
                                    c.a(c.this, false, str3, "", System.currentTimeMillis() - jCurrentTimeMillis, iA);
                                    bVar.a(-1, str3, (AdError) null, jCurrentTimeMillis);
                                    c.d(c.this);
                                }
                            });
                            return;
                        }
                        String strB = c.b(c.this, contextG);
                        String strC = c.c(c.this, contextG);
                        c.g();
                        c.this.j = false;
                        bVar.b(strB, strC);
                        c.d(c.this);
                    }
                }
            }));
        }
    }

    private void n() {
        try {
            a aVarL = l();
            if (aVarL != null) {
                d dVarA = aVarL.a();
                aVarL.b();
                new StringBuilder("requestDomainNext() >>> next domainRequest: ").append(dVarA);
                if (dVarA != null) {
                    b(dVarA);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static class b implements InterfaceC0019c, d {
        private boolean a;
        private final InterfaceC0019c b;

        public b(InterfaceC0019c interfaceC0019c) {
            this.b = interfaceC0019c;
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0019c
        public final void a(String str, String str2) {
            InterfaceC0019c interfaceC0019c;
            if (this.a || (interfaceC0019c = this.b) == null) {
                return;
            }
            this.a = true;
            interfaceC0019c.a(str, str2);
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0019c
        public final void b(String str, String str2) {
            InterfaceC0019c interfaceC0019c = this.b;
            if (interfaceC0019c != null) {
                interfaceC0019c.b(str, str2);
            }
            a(str, str2);
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0019c
        public final void a(int i, String str, AdError adError, long j) {
            InterfaceC0019c interfaceC0019c = this.b;
            if (interfaceC0019c != null) {
                interfaceC0019c.a(i, str, adError, j);
            }
            a("", "");
        }

        @Override // com.anythink.core.common.g.c.InterfaceC0019c
        public final void a(int i, Object obj, Object obj2, long j) {
            InterfaceC0019c interfaceC0019c = this.b;
            if (interfaceC0019c != null) {
                interfaceC0019c.a(i, obj, obj2, j);
            }
            a(obj != null ? obj.toString() : "", obj2 != null ? obj2.toString() : "");
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

    public final String a(String str) {
        return a(str, "", true);
    }

    public final String c(Context context) {
        String strC = this.s;
        if (TextUtils.isEmpty(strC)) {
            strC = ad.c(context, "anythink_sdk", t.a.N, "");
        }
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        r rVarC = s.b().c();
        if (rVarC != null && rVarC.getOsDmEntity() != null) {
            String strategyTcpDm = rVarC.getOsDmEntity().getStrategyTcpDm();
            if (!TextUtils.isEmpty(strategyTcpDm)) {
                return strategyTcpDm;
            }
        }
        return "";
    }

    public final String d(Context context) {
        String strC = this.t;
        if (TextUtils.isEmpty(strC)) {
            strC = ad.c(context, "anythink_sdk", t.a.O, "");
        }
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        r rVarC = s.b().c();
        if (rVarC != null && rVarC.getOsDmEntity() != null) {
            String strategyTcpBackupDm = rVarC.getOsDmEntity().getStrategyTcpBackupDm();
            if (!TextUtils.isEmpty(strategyTcpBackupDm)) {
                return strategyTcpBackupDm;
            }
        }
        return "";
    }

    public final int e(Context context) {
        int iB = this.u;
        if (iB <= 0) {
            iB = ad.b(context, "anythink_sdk", t.a.P, 0);
        }
        return iB > 0 ? iB : i.g.b.a;
    }

    public final int f(Context context) {
        int iB = this.v;
        if (iB <= 0) {
            iB = ad.b(context, "anythink_sdk", t.a.Q, 0);
        }
        return iB > 0 ? iB : e(context);
    }

    static /* synthetic */ String b(c cVar, Context context) {
        String str = cVar.q;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.L, "") : str;
    }

    static /* synthetic */ String c(c cVar, Context context) {
        String str = cVar.r;
        return TextUtils.isEmpty(str) ? ad.c(context, "anythink_sdk", t.a.M, "") : str;
    }

    static /* synthetic */ void d(c cVar) {
        try {
            a aVarL = cVar.l();
            if (aVarL != null) {
                d dVarA = aVarL.a();
                aVarL.b();
                new StringBuilder("requestDomainNext() >>> next domainRequest: ").append(dVarA);
                if (dVarA != null) {
                    cVar.b(dVarA);
                }
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(58);
        return iLastIndexOf < 0 ? str : str.substring(0, iLastIndexOf);
    }

    static /* synthetic */ void d(c cVar, Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.k = jCurrentTimeMillis;
        ad.a(context, "anythink_sdk", t.a.I, jCurrentTimeMillis);
    }

    static /* synthetic */ void a(c cVar, Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            cVar.q = str;
            ad.b(context, "anythink_sdk", t.a.L, str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        cVar.r = str2;
        ad.b(context, "anythink_sdk", t.a.M, str2);
    }

    static /* synthetic */ void a(c cVar, Context context, String str, String str2, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            cVar.s = str;
            ad.b(context, "anythink_sdk", t.a.N, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            cVar.t = str2;
            ad.b(context, "anythink_sdk", t.a.O, str2);
        }
        if (i > 0) {
            cVar.u = i;
            ad.a(context, "anythink_sdk", t.a.P, i);
        }
        if (i2 > 0) {
            cVar.v = i2;
            ad.a(context, "anythink_sdk", t.a.Q, i2);
        }
    }

    static /* synthetic */ void a(c cVar, boolean z, String str, String str2, long j, int i) {
        f.a(cVar.n, cVar.l, "", String.valueOf(cVar.k), "", "", "", "1", z ? "1" : "0", str, String.valueOf(j), i, str2, cVar.m);
    }
}
