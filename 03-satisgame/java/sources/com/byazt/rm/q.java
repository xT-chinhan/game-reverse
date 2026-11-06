package com.byazt.rm;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import com.byazt.tk.k;
import com.byazt.vf.wo;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 5})
public class q {
    public static volatile Handler n;

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.gwu.l s(String str) {
        return com.byazt.lk.l.qg(str, "feature_data");
    }

    public static void n(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME);
                String strOptString2 = jSONObjectOptJSONObject.optString(ImagesContract.URL);
                String strOptString3 = jSONObjectOptJSONObject.optString("md5");
                if (jSONObjectOptJSONObject.optBoolean("enable", false) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString)) {
                    n(strOptString, strOptString3, strOptString2, str);
                }
            }
        }
    }

    public static void n(Set<String> set, String str) {
        try {
            com.byazt.gwu.l lVarS = s(str);
            Map all = lVarS.getAll();
            if (all != null && !all.isEmpty()) {
                for (String str2 : all.keySet()) {
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("csj_feature_rule_") && n(str2, set)) {
                        lVarS.n(str2);
                    }
                }
            }
        } catch (Throwable th) {
            k.n("Tmee_TTFeatureUtils", "cleanupExpiredKv error", th);
        }
    }

    private static boolean n(String str, Set<String> set) {
        if (set != null && !set.isEmpty()) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : set) {
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(String str, String str2) {
        StringBuilder sb = new StringBuilder("csj_feature_rule_");
        sb.append(str).append("_").append(str2);
        return sb.toString();
    }

    private static void n(final String str, final String str2, String str3, final String str4) {
        rv rvVarS;
        if (n(str, str2, str4) || (rvVarS = com.byazt.phf.s.s(str3)) == null) {
            return;
        }
        rvVarS.n(new x() { // from class: com.byazt.rm.q.1
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null) {
                    try {
                        if (oaVar.x()) {
                            String str5 = new String(oaVar.q());
                            q.s(str4).n(q.s(str, str2), str5);
                            q.q(str, str5);
                        }
                    } catch (Throwable th) {
                        k.n("Tmee_TTFeatureUtils", "download rule error, md5:" + str2, th);
                    }
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str5, Throwable th) {
                k.qg("Tmee_TTFeatureUtils", "download rule failed error");
            }
        });
    }

    private static boolean n(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
            try {
                String strQg = s(str3).qg(s(str, str2), "");
                if (TextUtils.isEmpty(strQg)) {
                    return false;
                }
                q(str, strQg);
                return true;
            } catch (Throwable th) {
                k.qg("Tmee_TTFeatureUtils", "get feature rule error :" + th.toString());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(String str, String str2) throws Exception {
        String strN = com.byazt.cl.q.n(new JSONObject(str2), false);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(strN);
        List<com.byazt.gdj.l> listN = s.n(jSONObject.optJSONArray("rules"));
        if (listN != null) {
            for (com.byazt.gdj.l lVar : listN) {
                if (lVar != null) {
                    lVar.qg(str);
                }
            }
        }
        com.byazt.aun.l.n().n(str, listN);
        com.byazt.aun.l.n().qg(str, s.qg(jSONObject.optJSONArray("mergeOutputs")));
    }

    public static Handler n() {
        Handler handlerN;
        if (n == null) {
            synchronized (q.class) {
                if (n == null && (handlerN = ((wo) com.byazt.qp.q.n("thread_service")).n("tt_csj_feature_handler")) != null) {
                    n = handlerN;
                }
            }
        }
        return n;
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (str.startsWith("${") && str.endsWith("}")) ? str.substring(2, str.length() - 1) : str;
    }
}
