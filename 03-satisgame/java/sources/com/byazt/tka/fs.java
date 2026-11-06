package com.byazt.tka;

import android.text.TextUtils;
import com.byakv.z.SoftDecTool;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 101})
public final class fs {
    public static final AtomicInteger n = new AtomicInteger();
    public static volatile com.byazt.zqc.q.n qg;

    private fs() {
    }

    public static void n(int i, int i2, boolean z) {
        if (z && tj.s() != null && n(i)) {
            n.set(i2);
            n();
            new com.byazt.xis.s(new Runnable() { // from class: com.byazt.tka.fs.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.zqc.q.n().qg();
                }
            }, "har").start();
        }
    }

    private static void n() {
        if (qg != null) {
            return;
        }
        synchronized (fs.class) {
            if (qg != null) {
                return;
            }
            qg = new com.byazt.zqc.q.n() { // from class: com.byazt.tka.fs.2
                @Override // com.byazt.zqc.q.n
                public void n(JSONObject jSONObject) {
                    fs.qg(jSONObject);
                }
            };
            com.byazt.zqc.q.n().n(qg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("scene", n.get());
        } catch (JSONException unused) {
        }
        q(jSONObject);
        s(jSONObject);
    }

    private static boolean n(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zQg = com.byazt.zqc.l.n().qg();
        long jL = com.byazt.zqc.l.n().l();
        boolean z = jL > 0 && ((long) (i - 1)) % jL == 0;
        boolean z2 = jCurrentTimeMillis - com.byazt.zqc.q.n().q() > com.byazt.zqc.l.n().q();
        boolean zS = com.byazt.zqc.q.n().s();
        com.byazt.zqc.l.n();
        com.byazt.zqc.l.n();
        com.byazt.zqc.l.n();
        com.byazt.zqc.l.n();
        double d = SoftDecTool.acs;
        long j = SoftDecTool.act;
        return z && z2 && zQg && !zS;
    }

    private static void s(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        d.n("har_automatic", jSONObject);
    }

    private static void q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.byazt.ek.s sVar = (com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new");
            if (sVar == null) {
                return;
            }
            sVar.n("antispam_handhold", jSONObject, false, -1L, new com.byazt.rr.cp() { // from class: com.byazt.tka.fs.3
                @Override // com.byazt.rr.cp
                public void n(String str, boolean z, long j, com.byazt.rr.s sVar2, JSONObject jSONObject2, com.byazt.rr.rv rvVar) {
                    if (!z || jSONObject2 == null) {
                        String.valueOf(sVar2);
                        return;
                    }
                    try {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("probability");
                        if (jSONArrayOptJSONArray == null && !TextUtils.isEmpty(jSONObject2.optString("probability"))) {
                            jSONArrayOptJSONArray = new JSONArray(jSONObject2.optString("probability"));
                        }
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 1) {
                            return;
                        }
                        SoftDecTool.ua(jSONArrayOptJSONArray.optDouble(0), System.currentTimeMillis());
                        double d = SoftDecTool.acs;
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
    }
}
