package com.byazt.ud;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1485, 13})
public class hw {
    @JProtect
    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strPr = pr();
        String strPr2 = pr(strPr, 32);
        String strHw = hw();
        String strPr3 = null;
        if (strPr2 != null && strHw != null) {
            strPr3 = pr.pr(str, strHw, strPr2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(strPr).append(strHw).append(strPr3);
        return sb.toString();
    }

    @JProtect
    public static JSONObject pr(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            String strPr = pr(jSONObject.toString());
            if (!TextUtils.isEmpty(strPr)) {
                jSONObject2.put("message", strPr);
                jSONObject2.put("cypher", 3);
            } else {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable th) {
            try {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            } catch (Throwable th2) {
            }
        }
        return jSONObject2;
    }

    public static String hw(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 49) {
            String strPr = pr(str.substring(1, 33), 32);
            String strSubstring = str.substring(33, 49);
            if (strSubstring != null && strPr != null) {
                return pr.hw(str.substring(49), strSubstring, strPr);
            }
            return str;
        }
        return str;
    }

    public static String pr() {
        String strPr = pr(16);
        if (strPr == null || strPr.length() != 32) {
            return null;
        }
        return strPr;
    }

    public static String pr(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String hw() {
        String strPr = pr(8);
        if (strPr == null || strPr.length() != 16) {
            return null;
        }
        return strPr;
    }

    public static String pr(int i) {
        try {
            byte[] bArr = new byte[i];
            hn().nextBytes(bArr);
            return x.pr(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    private static SecureRandom hn() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable th) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }
}
