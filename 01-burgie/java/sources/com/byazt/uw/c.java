package com.byazt.uw;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.aj;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 99, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.zq.c hw(String str) {
        return com.byazt.qn.x.hw(str, "strategy_data");
    }

    public static void pr(JSONArray jSONArray, String str) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
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
        aj ajVarHn;
        if (pr(str, str3) || (ajVarHn = com.byazt.tf.hn.hn(str2)) == null) {
            return;
        }
        ajVarHn.pr(new fw() { // from class: com.byazt.uw.c.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null) {
                    try {
                        if (mVar.fw()) {
                            String str4 = new String(mVar.x());
                            c.hw(str3).pr(str, str4);
                            com.byazt.gf.x.pr().pr(new JSONObject(str4).optJSONArray("strategys"));
                        }
                    } catch (Throwable th) {
                        ho.pr("Tmee_TTStrategyUtils", "download strategy error, md5:" + str, th);
                    }
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str4, Throwable th) {
                ho.hw("Tmee_TTStrategyUtils", "download strategy failed error");
            }
        });
    }

    private static boolean pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String strHw = hw(str2).hw(str, "");
            if (TextUtils.isEmpty(strHw)) {
                return false;
            }
            com.byazt.gf.x.pr().pr(new JSONObject(strHw).optJSONArray("strategys"));
            return true;
        } catch (Throwable th) {
            ho.hw("Tmee_TTStrategyUtils", "get strategy from local error :" + th.toString());
            return false;
        }
    }
}
