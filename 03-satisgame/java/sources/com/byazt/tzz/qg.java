package com.byazt.tzz;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.f.h;
import com.byazt.hls.x;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.vf.wo;
import com.google.android.gms.common.internal.ImagesContract;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 444, 26})
public class qg implements com.byazt.lcx.n {
    public final Context n;
    public final com.byazt.lcx.qg qg;
    public com.byazt.vr.qg s;

    public qg(Context context, com.byazt.lcx.qg qgVar, com.byazt.vr.qg qgVar2) {
        this.n = context;
        this.qg = qgVar;
        this.s = qgVar2;
    }

    @Override // com.byazt.lcx.n
    public void n(String str, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        com.byazt.vr.s sVarN = this.s.n();
        if (sVarN == null || this.n == null || !sVarN.qg()) {
            return;
        }
        wo woVar = (wo) com.byazt.qp.q.n("thread_service");
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            woVar.n().execute(new n(new s(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5, jSONObject, 1), str, map));
        }
    }

    @Override // com.byazt.lcx.n
    public void n(final String str) {
        com.byazt.vr.s sVarN = this.s.n();
        if (sVarN == null || !sVarN.qg()) {
            return;
        }
        ((wo) com.byazt.qp.q.n("thread_service")).n().execute(new Runnable() { // from class: com.byazt.tzz.qg.1
            @Override // java.lang.Runnable
            public void run() {
                qg.this.n(qg.this.qg.n(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<s> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wo woVar = (wo) com.byazt.qp.q.n("thread_service");
        Iterator<s> it = list.iterator();
        while (it.hasNext()) {
            woVar.n().execute(new n(it.next(), str, null));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 444, 48})
    private class n implements Runnable {
        public final Map<String, String> q;
        public final s qg;
        public final String s;

        private n(s sVar, String str, Map<String, String> map) {
            this.qg = sVar;
            this.s = str;
            this.q = map;
        }

        private String s(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.s)) ? str.replace("{UID}", this.s).replace("__UID__", this.s) : str;
        }

        public boolean n(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }

        public String qg(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(qg.qg().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception unused) {
                return str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            oa oaVarN;
            com.byazt.vr.s sVarN = qg.this.s.n();
            if (sVarN == null || !sVarN.qg()) {
                return;
            }
            String strS = this.qg.s();
            if (!n(strS)) {
                n(null, sVarN, this.qg, strS, "not http url");
                return;
            }
            if (this.qg.l() == 0) {
                qg.this.qg.delete(this.qg);
                n(null, sVarN, this.qg, strS, "retry max");
                return;
            }
            try {
                if (this.qg.l() == 5) {
                    qg.this.qg.insert(this.qg);
                }
                com.byazt.vf.oa oaVar = (com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new");
                if (!(((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(60000L) != 0)) {
                    n(null, sVarN, this.qg, strS, "no net");
                    return;
                }
                String strS2 = s(strS);
                if (this.qg.q()) {
                    strS2 = qg(strS2);
                }
                rv rvVarQ = com.byazt.hls.q.q(strS2);
                if (rvVarQ == null) {
                    n(null, sVarN, this.qg, strS2, "no executor");
                    return;
                }
                rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, oaVar.qg(false));
                rvVarQ.n("csj_client_source_from", "1");
                if (this.q != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.q.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    rvVarQ.n("csj_extra_info", jSONObject.toString());
                }
                try {
                    oaVarN = rvVarQ.n();
                } catch (Throwable unused) {
                    oaVarN = null;
                }
                oa oaVar2 = oaVarN;
                if (oaVar2 != null && oaVar2.x()) {
                    qg.this.qg.delete(this.qg);
                    x.n("trackurl", "track success : ".concat(String.valueOf(strS)));
                } else {
                    if (oaVar2 != null && oaVar2.n() == 8848) {
                        x.n("trackurl", "block url : " + oaVar2.qg());
                        qg.this.qg.delete(this.qg);
                    }
                    x.n("trackurl", "track fail : ".concat(String.valueOf(strS)));
                    s sVar = this.qg;
                    sVar.n(sVar.l() - 1);
                    if (this.qg.l() == 0) {
                        qg.this.qg.delete(this.qg);
                        x.n("trackurl", "track fail and delete : ".concat(String.valueOf(strS)));
                    } else {
                        qg.this.qg.update(this.qg);
                    }
                }
                n(oaVar2, sVarN, this.qg, strS2, null);
            } catch (Throwable unused2) {
            }
        }

        private void n(oa oaVar, com.byazt.vr.s sVar, s sVar2, String str, String str2) {
            try {
                sVar.n(this.qg.n(), n(oaVar, sVar2, str, str2));
            } catch (Exception unused) {
            }
        }

        private JSONObject n(oa oaVar, s sVar, String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            if (sVar == null) {
                return jSONObject;
            }
            try {
                jSONObject.put(h.b.h, 5 - sVar.l());
                JSONObject jSONObjectN = sVar.n();
                if (jSONObjectN != null) {
                    jSONObject.put("track_type", jSONObjectN.optString("track_type", ""));
                }
                jSONObject.put(ImagesContract.URL, str);
                jSONObject.put("current", System.currentTimeMillis());
                jSONObject.put("error_msg", str2);
                if (oaVar != null) {
                    jSONObject.put("http_code", oaVar.n());
                    String strFs = oaVar.fs();
                    if (!TextUtils.isEmpty(strFs)) {
                        if (strFs.length() > 5000) {
                            strFs = strFs.substring(0, 5000);
                        }
                        jSONObject.put("http_response", strFs);
                    }
                    jSONObject.put("success", oaVar.x() ? 1 : 0);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random qg() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
