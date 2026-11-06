package com.anythink.core.common.l.c;

import android.text.TextUtils;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.i;
import com.anythink.core.common.m.a.k;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static final long a = 500;
    private static final b[] b = {new b(i.aa.a, 53, 500), new b(i.aa.b, 53, 500), new b(i.aa.c, 53, 500), new b(i.aa.d, 53, 500), new b(i.aa.e, 53, 500), new b(i.aa.f, 53, 500)};
    private int c;
    private a d;
    private long f;
    private int e = 1;
    private int g = 1;
    private int h = 1;
    private int i = 1;

    private c() {
    }

    public static c a(JSONObject jSONObject) {
        int[] iArr = null;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.c = jSONObject.optInt("net_type", 2);
        cVar.e = jSONObject.optInt("dns_udp_sw", 1);
        cVar.g = jSONObject.optInt("dns_doh_sw", 1);
        cVar.f = jSONObject.optLong("tcp_f_timeout", 0L);
        cVar.h = jSONObject.optInt("api_tcp_sw", 1);
        cVar.i = jSONObject.optInt("bid_tcp_sw", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("net_d");
        if (jSONObjectOptJSONObject != null) {
            long jOptLong = jSONObjectOptJSONObject.optLong("s_timeout", 500L);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("s_i");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("srv");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                iArr = new int[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    iArr[i] = jSONArrayOptJSONArray.optInt(i);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString = jSONObjectOptJSONObject2.optString("ip");
                        if (!TextUtils.isEmpty(strOptString)) {
                            arrayList.add(new b(strOptString, jSONObjectOptJSONObject2.optInt("port", 53), jSONObjectOptJSONObject2.optLong("timeout", 500L)));
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                cVar.d = new a(iArr, jOptLong, (b[]) arrayList.toArray(new b[0]));
            }
        }
        return cVar;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = this.d;
        boolean z = (aVar == null || aVar.b() == null || this.d.b().length <= 0 || this.d.a() == null || this.d.a().length <= 0 || ATSDK.isCnSDK()) ? false : true;
        if (!z) {
            return z;
        }
        int[] iArrA = this.d.a();
        try {
            int iA = g.a(str);
            for (int i : iArrA) {
                if (iA == i) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final k[] a() {
        a aVar = this.d;
        b[] bVarArrB = aVar != null ? aVar.b() : null;
        if (bVarArrB == null || bVarArrB.length == 0) {
            return b();
        }
        k[] kVarArr = new k[bVarArrB.length];
        for (int i = 0; i < bVarArrB.length; i++) {
            b bVar = bVarArrB[i];
            if (bVar != null) {
                kVarArr[i] = new com.anythink.core.common.m.a.h(bVar.a(), bVar.b(), bVar.c());
            }
        }
        return kVarArr;
    }

    public static k[] b() {
        if (ATSDK.isCnSDK()) {
            return null;
        }
        k[] kVarArr = new k[b.length];
        int i = 0;
        while (true) {
            b[] bVarArr = b;
            if (i >= bVarArr.length) {
                return kVarArr;
            }
            b bVar = bVarArr[i];
            kVarArr[i] = new com.anythink.core.common.m.a.h(bVar.a(), bVar.b(), bVar.c());
            i++;
        }
    }

    public final int c() {
        return this.c;
    }

    private void a(int i) {
        this.c = i;
    }

    private void a(a aVar) {
        this.d = aVar;
    }

    public final int d() {
        return this.e;
    }

    private void b(int i) {
        this.e = i;
    }

    public final long e() {
        return this.f;
    }

    private void a(long j) {
        this.f = j;
    }

    public final int f() {
        return this.g;
    }

    private void c(int i) {
        this.g = i;
    }

    public final int g() {
        return this.h;
    }

    private void d(int i) {
        this.h = i;
    }

    public final int h() {
        return this.i;
    }

    private void e(int i) {
        this.i = i;
    }

    public static class a {
        private final int[] a;
        private final long b;
        private final b[] c;

        public a(int[] iArr, long j, b[] bVarArr) {
            this.a = iArr;
            this.b = j;
            this.c = bVarArr;
        }

        public final int[] a() {
            return this.a;
        }

        public final b[] b() {
            return this.c;
        }

        private long c() {
            return this.b;
        }
    }

    public static class b {
        private final String a;
        private final int b;
        private final long c;

        public b(String str, int i, long j) {
            this.a = str;
            this.b = i;
            this.c = j;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final long c() {
            return this.c;
        }
    }
}
