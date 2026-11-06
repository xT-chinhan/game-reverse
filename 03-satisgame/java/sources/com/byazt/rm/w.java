package com.byazt.rm;

import android.text.TextUtils;
import com.byazt.gdj.fs;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qk.x;
import com.byazt.tk.k;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 13})
public class w {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.gwu.l qg(String str) {
        return com.byazt.lk.l.qg(str, "strategy_data");
    }

    public static void n(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME);
                String strOptString2 = jSONObjectOptJSONObject.optString(ImagesContract.URL);
                String strOptString3 = jSONObjectOptJSONObject.optString("md5");
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enable", true);
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString) && zOptBoolean) {
                    n(strOptString, strOptString3, strOptString2, str);
                }
            }
        }
    }

    public static void n(Set<String> set, String str) {
        try {
            com.byazt.gwu.l lVarQg = qg(str);
            Map all = lVarQg.getAll();
            if (all != null && !all.isEmpty()) {
                for (String str2 : all.keySet()) {
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("csj_strategy_rule_") && n(str2, set)) {
                        lVarQg.n(str2);
                    }
                }
            }
        } catch (Throwable th) {
            k.n("Tmee_TTStrategyUtils", "cleanupExpiredKv error", th);
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
        StringBuilder sb = new StringBuilder("csj_strategy_rule_");
        sb.append(str).append("_").append(str2);
        return sb.toString();
    }

    private static void n(final String str, final String str2, String str3, final String str4) {
        rv rvVarS;
        if (n(str, str2, str4) || (rvVarS = com.byazt.phf.s.s(str3)) == null) {
            return;
        }
        rvVarS.n(new x() { // from class: com.byazt.rm.w.1
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null) {
                    try {
                        if (oaVar.x()) {
                            String str5 = new String(oaVar.q());
                            w.qg(str4).n(w.s(str, str2), str5);
                            w.q(str, str5);
                        }
                    } catch (Throwable th) {
                        k.n("Tmee_TTStrategyUtils", "download strategy error, md5:" + str2, th);
                    }
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str5, Throwable th) {
                k.qg("Tmee_TTStrategyUtils", "download strategy failed error");
            }
        });
    }

    private static boolean n(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            String strQg = qg(str3).qg(s(str, str2), "");
            if (TextUtils.isEmpty(strQg)) {
                return false;
            }
            q(str, strQg);
            return true;
        } catch (Throwable th) {
            k.qg("Tmee_TTStrategyUtils", "get strategy from local error :" + th.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(String str, String str2) throws Exception {
        String strN = com.byazt.cl.q.n(new JSONObject(str2), false);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        List<fs> listN = l.n(new JSONObject(strN).optJSONArray("strategys"));
        if (listN != null) {
            for (fs fsVar : listN) {
                if (fsVar != null) {
                    fsVar.qg(str);
                }
            }
        }
        com.byazt.aun.fs.n().n(str, listN);
    }
}
