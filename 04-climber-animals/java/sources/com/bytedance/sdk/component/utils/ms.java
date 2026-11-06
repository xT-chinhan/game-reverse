package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.ms$ms, reason: collision with other inner class name */
    static class C0251ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final Random f1361ms = ms.ah();
    }

    public static JSONObject ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return ms(jSONObject.toString());
    }

    public static JSONObject ms(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            try {
                String strXr = xr(str);
                if (!TextUtils.isEmpty(strXr)) {
                    jSONObject.put("message", strXr);
                    jSONObject.put("cypher", 3);
                } else {
                    jSONObject.put("message", str);
                    jSONObject.put("cypher", 0);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable unused) {
            jSONObject.put("message", str);
            jSONObject.put("cypher", 0);
        }
        return jSONObject;
    }

    public static String xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strMs = ms();
        String strMs2 = ms(strMs, 32);
        String strXr = xr();
        String strMs3 = (strMs2 == null || strXr == null) ? null : com.bytedance.sdk.component.ka.ms.ms(str, strXr, strMs2);
        StringBuilder sb = new StringBuilder("3");
        sb.append(strMs).append(strXr).append(strMs3);
        return sb.toString();
    }

    public static String ah(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strMs = ms(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strMs == null) ? str : com.bytedance.sdk.component.ka.ms.xr(str.substring(49), strSubstring, strMs);
    }

    public static String ms() {
        String strMs = ms(16);
        if (strMs == null || strMs.length() != 32) {
            return null;
        }
        return strMs;
    }

    public static String ms(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String xr() {
        String strMs = ms(8);
        if (strMs == null || strMs.length() != 16) {
            return null;
        }
        return strMs;
    }

    public static String ms(int i) {
        try {
            byte[] bArr = new byte[i];
            C0251ms.f1361ms.nextBytes(bArr);
            return ka.ms(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Random ah() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }
}
