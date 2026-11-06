package com.byazt.nq;

import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1373, 20})
public class hn {
    public static Boolean pr = null;

    private static boolean pr() {
        if (pr == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes");
                pr = Boolean.TRUE;
            } catch (Throwable th) {
                pr = Boolean.FALSE;
            }
        }
        return pr.booleanValue();
    }

    public static String pr(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("game_more_kllkrtunities".equalsIgnoreCase(str)) {
                return pr(str);
            }
            return str;
        }
        if (pr()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
