package com.byazt.eh;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2367, 26})
public class qg {
    @JProtect
    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strN = n();
        String strN2 = n(strN, 32);
        String strQg = qg();
        String strN3 = (strN2 == null || strQg == null) ? null : n.n(str, strQg, strN2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strN).append(strQg).append(strN3);
        return sb.toString();
    }

    @JProtect
    public static JSONObject n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strN = n(jSONObject.toString());
                if (!TextUtils.isEmpty(strN)) {
                    jSONObject2.put("message", strN);
                    jSONObject2.put("cypher", 3);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static String qg(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strN = n(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strN == null) ? str : n.qg(str.substring(49), strSubstring, strN);
    }

    public static String n() {
        String strN = n(16);
        if (strN == null || strN.length() != 32) {
            return null;
        }
        return strN;
    }

    public static String n(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String qg() {
        String strN = n(8);
        if (strN == null || strN.length() != 16) {
            return null;
        }
        return strN;
    }

    public static String n(int i) {
        try {
            byte[] bArr = new byte[i];
            s().nextBytes(bArr);
            return q.n(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static SecureRandom s() {
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
