package com.anythink.core.common.m.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u.ad;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class i {
    private static final String a = "DohEndpointStatsStore";
    private static final int b = 1;
    private static final long c = 604800000;
    private static final long d = 60000;
    private static final String e = "v";
    private static final String f = "stats";
    private static final String g = "url";
    private static final String h = "successRate";
    private static final String i = "updateTs";
    private long j = 0;

    i() {
    }

    static void a(a.C0034a[] c0034aArr) {
        JSONArray jSONArrayOptJSONArray;
        a.C0034a c0034aA;
        if (c0034aArr == null || c0034aArr.length == 0) {
            return;
        }
        try {
            Context contextG = s.b().g();
            if (contextG == null) {
                return;
            }
            String strC = ad.c(contextG, t.b.o, t.a.T, "");
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strC);
            if (jSONObject.optInt(e, 0) == 1 && (jSONArrayOptJSONArray = jSONObject.optJSONArray(f)) != null && jSONArrayOptJSONArray.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString = jSONObjectOptJSONObject.optString("url", null);
                        if (!TextUtils.isEmpty(strOptString) && (c0034aA = a(c0034aArr, strOptString)) != null) {
                            long jOptLong = jSONObjectOptJSONObject.optLong(i, 0L);
                            if (jOptLong > 0 && jCurrentTimeMillis - jOptLong <= 604800000) {
                                double dOptDouble = jSONObjectOptJSONObject.optDouble(h, Double.NaN);
                                if (!Double.isNaN(dOptDouble) && dOptDouble >= 0.0d && dOptDouble <= 1.0d) {
                                    c0034aA.a(dOptDouble);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    final synchronized void b(a.C0034a[] c0034aArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.j < d) {
            return;
        }
        a(c0034aArr, jElapsedRealtime);
    }

    final synchronized void c(a.C0034a[] c0034aArr) {
        a(c0034aArr, SystemClock.elapsedRealtime());
    }

    private void a(a.C0034a[] c0034aArr, long j) {
        if (c0034aArr == null || c0034aArr.length == 0) {
            return;
        }
        try {
            Context contextG = s.b().g();
            if (contextG == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            for (a.C0034a c0034a : c0034aArr) {
                if (c0034a != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", c0034a.a);
                    jSONObject.put(h, c0034a.b());
                    jSONObject.put(i, jCurrentTimeMillis);
                    jSONArray.put(jSONObject);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(e, 1);
            jSONObject2.put(f, jSONArray);
            ad.b(contextG, t.b.o, t.a.T, jSONObject2.toString());
            this.j = j;
        } catch (Throwable unused) {
        }
    }

    private static a.C0034a a(a.C0034a[] c0034aArr, String str) {
        for (a.C0034a c0034a : c0034aArr) {
            if (c0034a != null && str.equals(c0034a.a)) {
                return c0034a;
            }
        }
        return null;
    }
}
