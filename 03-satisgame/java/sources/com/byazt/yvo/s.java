package com.byazt.yvo;

import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.byazt.gct.pk;
import com.byazt.vgx.w;
import com.byazt.wea.rv;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1177, 8})
public class s {
    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject s(qg qgVar, pk pkVar, com.byazt.wea.n nVar) {
        if (qgVar != null && nVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String strQg = qgVar.qg();
                String strN = qgVar.n();
                jSONObject.putOpt("event_source", 1);
                jSONObject.putOpt("lifecycle_id", nVar.n());
                jSONObject.putOpt("type", strQg + "_" + strN);
                jSONObject.putOpt("l_type", strQg);
                jSONObject.putOpt(WebLoginFragment.QUERY_KEY_ID, strN);
                jSONObject.putOpt("state_num", q.n(qgVar));
                if ("ad_load_loaded".equals(strQg + "_" + strN) && (nVar instanceof com.byazt.wea.s)) {
                    jSONObject.putOpt("ad_count", Integer.valueOf(((com.byazt.wea.s) nVar).q()));
                } else {
                    jSONObject.putOpt("ad_count", Integer.valueOf(n(nVar)));
                }
                jSONObject.putOpt("bidding_type", Integer.valueOf(nVar.qg));
                if ((nVar instanceof com.byazt.wea.s) && ((com.byazt.wea.s) nVar).tj != null) {
                    int iN = ((com.byazt.wea.s) nVar).tj.n();
                    int iN2 = n(((com.byazt.wea.s) nVar).tj.qg());
                    jSONObject.putOpt("error_code", Integer.valueOf(iN));
                    jSONObject.putOpt("error_reason", Integer.valueOf(iN2));
                    jSONObject.putOpt("error_code_reason", iN + "_" + iN2);
                    jSONObject.putOpt("error_msg", ((com.byazt.wea.s) nVar).tj.qg());
                }
                if (nVar instanceof rv) {
                    jSONObject.putOpt("ugen_id", ((rv) nVar).fs);
                    jSONObject.putOpt("category_id", Integer.valueOf(((rv) nVar).rv));
                }
                if (nVar instanceof com.byazt.wea.q) {
                    jSONObject.putOpt("ugen_id", ((com.byazt.wea.q) nVar).cy);
                    jSONObject.putOpt("category_id", Integer.valueOf(((com.byazt.wea.q) nVar).hd));
                }
                if (qgVar.q() != -1) {
                    jSONObject.putOpt("source", Integer.valueOf(qgVar.q()));
                }
                jSONObject.putOpt("ts", Long.valueOf(qgVar.s()));
                JSONObject jSONObject2 = new JSONObject();
                if (nVar.n > 0) {
                    jSONObject2.putOpt("ad_slot_type", Integer.valueOf(nVar.n == 4 ? 3 : nVar.n));
                }
                jSONObject2.putOpt("rit", nVar.s);
                if (pkVar != null) {
                    jSONObject2.putOpt("aid", pkVar.q());
                    jSONObject2.putOpt("cid", pkVar.wm());
                    jSONObject2.putOpt("req_id", pkVar.ou());
                    jSONObject2.putOpt("bidding_type", Integer.valueOf(q.n(pkVar)));
                    jSONObject2.putOpt(e.a.h, Integer.valueOf(w.ou(pkVar)));
                }
                jSONObject.putOpt("ad_info", jSONObject2);
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static int n(com.byazt.wea.n nVar) {
        int iD;
        if (!(nVar instanceof com.byazt.wea.s)) {
            return 1;
        }
        com.byazt.wea.s sVar = (com.byazt.wea.s) nVar;
        if (sVar.x == null || (iD = sVar.x.d()) <= 0) {
            return 1;
        }
        return iD;
    }

    public static void n(final qg qgVar, final pk pkVar, final com.byazt.wea.n nVar) {
        if (com.byazt.rm.q.n() == null) {
            return;
        }
        com.byazt.rm.q.n().post(new Runnable() { // from class: com.byazt.yvo.s.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectS = s.s(qgVar, pkVar, nVar);
                    if (jSONObjectS != null) {
                        com.byazt.aun.q.n().n(jSONObjectS);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static int n(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] strArrSplit2 = str.split("message:");
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                String str2 = strArrSplit2[0];
                if (!TextUtils.isEmpty(str2) && (strArrSplit = str2.trim().split(":")) != null && strArrSplit.length >= 2) {
                    String str3 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str3)) {
                        return Integer.valueOf(str3.trim()).intValue();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
