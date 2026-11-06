package com.byazt.uw;

import android.os.Handler;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 99, 20})
public class hn {
    public static volatile Handler pr;

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.zq.c hn(String str) {
        return com.byazt.qn.x.hw(str, "feature_data");
    }

    public static void pr(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(BreakpointSQLiteKey.URL);
                String strOptString2 = jSONObjectOptJSONObject.optString("md5");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    pr(strOptString2, strOptString, str);
                }
            }
        }
    }

    private static void pr(final String str, String str2, final String str3) {
        if (pr(str, str3)) {
            return;
        }
        com.byazt.tf.hn.hn(str2).pr(new fw() { // from class: com.byazt.uw.hn.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null) {
                    try {
                        if (mVar.fw()) {
                            String str4 = new String(mVar.x());
                            hn.hn(str3).pr(str, str4);
                            com.byazt.gf.hw.pr().pr(new JSONObject(str4).optJSONArray("rules"));
                        }
                    } catch (Throwable th) {
                        ho.pr("Tmee_TTFeatureUtils", "download rule error, md5:" + str, th);
                    }
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str4, Throwable th) {
                ho.hw("Tmee_TTFeatureUtils", "download rule failed error");
            }
        });
    }

    private static boolean pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String strHw = hn(str2).hw(str, "");
            if (TextUtils.isEmpty(strHw)) {
                return false;
            }
            com.byazt.gf.hw.pr().pr(new JSONObject(strHw).optJSONArray("rules"));
            return true;
        } catch (Throwable th) {
            ho.hw("Tmee_TTFeatureUtils", "get feature rule error :" + th.toString());
            return false;
        }
    }

    public static Handler pr() {
        Handler handlerPr;
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null && (handlerPr = ((qi) uc.pr("thread_service")).pr("tt_csj_feature_handler")) != null) {
                    pr = handlerPr;
                }
            }
        }
        return pr;
    }

    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("${") && str.endsWith("}")) {
            return str.substring(2, str.length() - 1);
        }
        return str;
    }
}
