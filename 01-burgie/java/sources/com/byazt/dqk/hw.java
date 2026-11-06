package com.byazt.dqk;

import android.util.Log;
import com.byazt.nzn.m;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, 13})
public class hw implements pr {
    public volatile long pr;

    @Override // com.byazt.dqk.pr
    public void pr(com.byazt.nzn.hw hwVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar, IOException iOException) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.pr <= 60000) {
            return;
        }
        try {
            String strPr = pr(hwVar);
            if (pr(strPr)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int length = strPr == null ? 0 : strPr.length();
            jSONObject.put(BreakpointSQLiteKey.URL, hw(strPr, 4096));
            jSONObject.put("url_len", length);
            this.pr = jCurrentTimeMillis;
            pr("okhttp_connectFailed", jSONObject, iOException);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.dqk.pr
    public void pr(com.byazt.nzn.hw hwVar, IOException iOException) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.pr <= 60000) {
            return;
        }
        try {
            String strPr = pr(hwVar);
            if (pr(strPr)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int length = strPr == null ? 0 : strPr.length();
            jSONObject.put(BreakpointSQLiteKey.URL, hw(strPr, 4096));
            jSONObject.put("url_len", length);
            this.pr = jCurrentTimeMillis;
            pr("okhttp_callFailed", jSONObject, iOException);
        } catch (Exception e) {
        }
    }

    private void pr(final String str, final JSONObject jSONObject, final Throwable th) {
        ((com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null))).pr("exception", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.dqk.hw.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("scene", str);
                jSONObject3.putOpt("object", jSONObject);
                Throwable th2 = th;
                if (th2 != null) {
                    jSONObject3.putOpt("exception", hw.hw(Log.getStackTraceString(th2), 4096));
                }
                return jSONObject3;
            }
        });
    }

    private static boolean pr(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("/api/ad/union/sdk/stats/batch/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(String str, int i) {
        if (str == null || str.length() <= i) {
            return str;
        }
        return str.substring(0, i) + "...(" + str.length() + ")";
    }

    private String pr(com.byazt.nzn.hw hwVar) throws NullPointerException {
        return hwVar.pr().hw().toString();
    }
}
