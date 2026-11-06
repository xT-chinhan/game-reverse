package com.byazt.wf;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 109})
public final class w {
    public static void pr(com.byazt.lee.pr prVar, com.byazt.lee.hw hwVar, com.byazt.vlj.hn hnVar) {
        if (prVar == null || prVar.pr() == null || hnVar == null) {
            return;
        }
        JSONObject jSONObjectPr = prVar.pr();
        long jOptLong = jSONObjectPr.optLong("crash_time");
        int iHw = hw(pr("aid"));
        String strPr = com.byazt.vlj.zo.hn().pr();
        if (jOptLong > 0 && iHw > 0 && !TextUtils.isEmpty(strPr) && !"0".equals(strPr) && !TextUtils.isEmpty(hnVar.pr())) {
            try {
                String str = "android_" + iHw + "_" + strPr + "_" + jOptLong + "_" + hnVar;
                if (hwVar != null) {
                    JSONObject jSONObjectPr2 = hwVar.pr();
                    if (jSONObjectPr2 != null) {
                        jSONObjectPr2.put("unique_key", str);
                        return;
                    }
                    return;
                }
                jSONObjectPr.put("unique_key", str);
            } catch (JSONException e) {
            }
        }
    }

    public static String pr(String str) {
        Map<String, Object> mapPr;
        if (com.byazt.vlj.zo.pr() != null && (mapPr = com.byazt.vlj.zo.pr().pr()) != null) {
            Object obj = mapPr.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    public static int hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            vk.hw(e);
            return 0;
        }
    }
}
