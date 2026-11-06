package com.byazt.hcw;

import android.util.Log;
import com.byazt.tbt.oa;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, 26})
public class qg implements n {
    public volatile long n;

    @Override // com.byazt.hcw.n
    public void n(com.byazt.tbt.qg qgVar, InetSocketAddress inetSocketAddress, Proxy proxy, oa oaVar, IOException iOException) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.n <= 60000) {
            return;
        }
        try {
            String strN = n(qgVar);
            if (n(strN)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int length = strN == null ? 0 : strN.length();
            jSONObject.put(ImagesContract.URL, qg(strN, 4096));
            jSONObject.put("url_len", length);
            this.n = jCurrentTimeMillis;
            n("okhttp_connectFailed", jSONObject, iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.hcw.n
    public void n(com.byazt.tbt.qg qgVar, IOException iOException) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.n <= 60000) {
            return;
        }
        try {
            String strN = n(qgVar);
            if (n(strN)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int length = strN == null ? 0 : strN.length();
            jSONObject.put(ImagesContract.URL, qg(strN, 4096));
            jSONObject.put("url_len", length);
            this.n = jCurrentTimeMillis;
            n("okhttp_callFailed", jSONObject, iOException);
        } catch (Exception unused) {
        }
    }

    private void n(final String str, final JSONObject jSONObject, final Throwable th) {
        ((com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null))).n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.hcw.qg.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("scene", str);
                jSONObject3.putOpt("object", jSONObject);
                Throwable th2 = th;
                if (th2 != null) {
                    jSONObject3.putOpt("exception", qg.qg(Log.getStackTraceString(th2), 4096));
                }
                return jSONObject3;
            }
        });
    }

    private static boolean n(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("/api/ad/union/sdk/stats/batch/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(String str, int i) {
        return (str == null || str.length() <= i) ? str : str.substring(0, i) + "...(" + str.length() + ")";
    }

    private String n(com.byazt.tbt.qg qgVar) throws NullPointerException {
        return qgVar.n().qg().toString();
    }
}
