package com.anythink.core.common.m.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.m.b.ad;
import com.anythink.core.common.m.b.af;
import com.anythink.core.common.m.b.q;
import com.anythink.core.common.m.b.v;
import com.anythink.core.common.m.b.z;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.varbto.utils.api.UtilConst;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String a = "DnsDohResolver";
    private static final int b = 3;
    private static final long c = 300000;
    private static final long d = 2;
    private static final long e = 3;
    private static final long f = 2;
    private static final long g = 4;
    private static final String h = "https://" + com.anythink.core.common.d.i.aa.g + "/dns-query";
    private static final String i = "https://" + com.anythink.core.common.d.i.aa.h + "/resolve";
    private static final String j = "https://" + com.anythink.core.common.d.i.aa.i + "/resolve";
    private static final Map<String, List<String>> k;
    private static volatile a l = null;
    private static final int p = 5;
    private static final Random q;
    private final z m = new z.a().a(2, TimeUnit.SECONDS).b(e, TimeUnit.SECONDS).c(2, TimeUnit.SECONDS).a(TimeUnit.SECONDS).a(new com.anythink.core.common.m.b.k(2, TimeUnit.MINUTES)).a(new b(0)).a();
    private final C0034a[] n;
    private final i o;

    static {
        HashMap map = new HashMap();
        map.put(com.anythink.core.common.d.i.aa.g, Arrays.asList(com.anythink.core.common.d.i.aa.a, com.anythink.core.common.d.i.aa.b));
        map.put(com.anythink.core.common.d.i.aa.h, Arrays.asList(com.anythink.core.common.d.i.aa.c, com.anythink.core.common.d.i.aa.d));
        map.put(com.anythink.core.common.d.i.aa.i, Arrays.asList(com.anythink.core.common.d.i.aa.e, com.anythink.core.common.d.i.aa.f));
        k = Collections.unmodifiableMap(map);
        q = new Random();
    }

    public static a a() {
        if (l == null) {
            synchronized (a.class) {
                if (l == null) {
                    l = new a();
                }
            }
        }
        return l;
    }

    private a() {
        C0034a[] c0034aArr = {new C0034a(h), new C0034a(i), new C0034a(j)};
        this.n = c0034aArr;
        this.o = new i();
        i.a(c0034aArr);
    }

    public final List<InetAddress> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C0034a[] c0034aArr = (C0034a[]) this.n.clone();
        if (q.nextInt(100) < 5) {
            for (int length = c0034aArr.length - 1; length > 0; length--) {
                int iNextInt = q.nextInt(length + 1);
                C0034a c0034a = c0034aArr[length];
                c0034aArr[length] = c0034aArr[iNextInt];
                c0034aArr[iNextInt] = c0034a;
            }
        } else {
            double[] dArr = new double[c0034aArr.length];
            for (int i2 = 0; i2 < c0034aArr.length; i2++) {
                dArr[i2] = c0034aArr[i2].b();
            }
            int i3 = 0;
            while (i3 < c0034aArr.length - 1) {
                int i4 = i3 + 1;
                int i5 = i3;
                for (int i6 = i4; i6 < c0034aArr.length; i6++) {
                    if (dArr[i6] > dArr[i5]) {
                        i5 = i6;
                    }
                }
                if (i5 != i3) {
                    C0034a c0034a2 = c0034aArr[i3];
                    c0034aArr[i3] = c0034aArr[i5];
                    c0034aArr[i5] = c0034a2;
                    double d2 = dArr[i3];
                    dArr[i3] = dArr[i5];
                    dArr[i5] = d2;
                }
                i3 = i4;
            }
        }
        for (C0034a c0034a3 : c0034aArr) {
            if (c0034a3.a(jElapsedRealtime)) {
                try {
                    try {
                        List<InetAddress> listA = a(c0034a3.a, str);
                        if (listA != null && !listA.isEmpty()) {
                            c0034a3.a();
                            this.o.b(this.n);
                            return listA;
                        }
                    } catch (Throwable unused) {
                        int iB = c0034a3.b(SystemClock.elapsedRealtime());
                        if (iB > 0 && iB % 3 == 0) {
                            this.o.c(this.n);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return null;
    }

    private C0034a[] c() {
        C0034a[] c0034aArr = (C0034a[]) this.n.clone();
        int i2 = 0;
        if (q.nextInt(100) < 5) {
            for (int length = c0034aArr.length - 1; length > 0; length--) {
                int iNextInt = q.nextInt(length + 1);
                C0034a c0034a = c0034aArr[length];
                c0034aArr[length] = c0034aArr[iNextInt];
                c0034aArr[iNextInt] = c0034a;
            }
        } else {
            double[] dArr = new double[c0034aArr.length];
            for (int i3 = 0; i3 < c0034aArr.length; i3++) {
                dArr[i3] = c0034aArr[i3].b();
            }
            while (i2 < c0034aArr.length - 1) {
                int i4 = i2 + 1;
                int i5 = i2;
                for (int i6 = i4; i6 < c0034aArr.length; i6++) {
                    if (dArr[i6] > dArr[i5]) {
                        i5 = i6;
                    }
                }
                if (i5 != i2) {
                    C0034a c0034a2 = c0034aArr[i2];
                    c0034aArr[i2] = c0034aArr[i5];
                    c0034aArr[i5] = c0034a2;
                    double d2 = dArr[i2];
                    dArr[i2] = dArr[i5];
                    dArr[i5] = d2;
                }
                i2 = i4;
            }
        }
        return c0034aArr;
    }

    private List<InetAddress> a(String str, String str2) throws Throwable {
        v vVarD = v.d(str);
        if (vVarD == null) {
            throw new IllegalArgumentException("invalid endpoint url: ".concat(String.valueOf(str)));
        }
        ad adVarB = new ad.a().a(vVarD.m().a(TapEventParamConstants.PARAM_NAME, str2).a("type", UtilConst.CRASH_CAT_A).b()).b("Accept", "application/dns-json").a().b();
        af afVar = null;
        try {
            af afVarB = this.m.a(adVarB).b();
            try {
                if (!afVarB.d()) {
                    throw new IOException("HTTP " + afVarB.c());
                }
                String strD = afVarB.h() != null ? afVarB.h().d() : null;
                if (TextUtils.isEmpty(strD)) {
                    if (afVarB != null) {
                        try {
                            afVarB.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return null;
                }
                List<InetAddress> listB = b(strD, str2);
                if (afVarB != null) {
                    try {
                        afVarB.close();
                    } catch (Throwable unused2) {
                    }
                }
                return listB;
            } catch (Throwable th) {
                th = th;
                afVar = afVarB;
                if (afVar != null) {
                    try {
                        afVar.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static List<InetAddress> b(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("Status", -1) != 0) {
            return Collections.emptyList();
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("Answer");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("type", -1) == 1) {
                String strOptString = jSONObjectOptJSONObject.optString(com.anythink.core.common.l.f.R);
                if (!TextUtils.isEmpty(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return com.anythink.core.common.l.b.a.a(str2, arrayList);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.m.a.a$a, reason: collision with other inner class name */
    static final class C0034a {
        private static final double b = 0.2d;
        private static final double c = 0.5d;
        final String a;
        private int d;
        private long e;
        private double f = c;

        C0034a(String str) {
            this.a = str;
        }

        final synchronized boolean a(long j) {
            if (this.d < 3) {
                return true;
            }
            return j - this.e >= a.c;
        }

        final synchronized void a() {
            this.f = (this.f * 0.8d) + b;
            this.d = 0;
            this.e = 0L;
        }

        final synchronized int b(long j) {
            int i;
            this.f = (this.f * 0.8d) + 0.0d;
            i = this.d + 1;
            this.d = i;
            this.e = j;
            return i;
        }

        final synchronized double b() {
            return this.f;
        }

        final synchronized void a(double d) {
            if (d >= 0.0d && d <= 1.0d) {
                this.f = d;
            }
        }
    }

    private static final class b implements q {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.anythink.core.common.m.b.q
        public final List<InetAddress> a(String str) {
            List list = (List) a.k.get(str);
            if (list != null && !list.isEmpty()) {
                List<InetAddress> listA = com.anythink.core.common.l.b.a.a(str, (List<String>) list);
                if (!listA.isEmpty()) {
                    return listA;
                }
            }
            return q.b.a(str);
        }
    }
}
