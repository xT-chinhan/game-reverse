package com.byazt.yi;

import android.os.SystemClock;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.byakv.z.SoftDecTool;
import com.byazt.ca.ho;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 586, 37})
public class pr {
    public static String pr(String str, String str2, String str3) {
        try {
            int iPr = pr();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strHn = hn(str, str2, str3);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (!TextUtils.isEmpty(strHn)) {
                return strHn;
            }
            pr(301, jElapsedRealtime2, iPr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            ho.hw("AES", String.valueOf(th.getMessage()));
            return null;
        }
    }

    public static String hw(String str, String str2, String str3) {
        try {
            int iPr = pr();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strX = x(str, str2, str3);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (!TextUtils.isEmpty(strX)) {
                return strX;
            }
            pr(302, jElapsedRealtime2, iPr);
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(cipher.doFinal(bArrDecode));
        } catch (Throwable th) {
            ho.hw("AES", String.valueOf(th.getMessage()));
            return null;
        }
    }

    private static String hn(String str, String str2, String str3) {
        if (!c(str, str2, str3)) {
            return null;
        }
        try {
            byte[] bArrPr = pr(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, str.getBytes("utf-8"), str2.getBytes(), str3.getBytes());
            if (bArrPr != null && bArrPr.length > 0) {
                return Base64.encodeToString(bArrPr, 0);
            }
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
        return null;
    }

    private static String x(String str, String str2, String str3) {
        if (!c(str, str2, str3)) {
            return null;
        }
        try {
            byte[] bArrPr = pr(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, Base64.decode(str, 0), str2.getBytes(), str3.getBytes());
            if (bArrPr != null && bArrPr.length > 0) {
                return new String(bArrPr, "utf-8");
            }
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
        return null;
    }

    private static void pr(int i, long j, int i2) {
        try {
            final JSONObject jSONObject = new JSONObject();
            if (j >= 0) {
                jSONObject.put("cost_time", j);
            }
            if (i != -1) {
                jSONObject.put("event_res", i);
            }
            if (i2 != -1) {
                jSONObject.put("armor_load_status", i2);
            }
            com.byazt.zs.uc.hw(null);
            ((com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log")).pr("encrypt_track", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.yi.pr.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    return jSONObject;
                }
            });
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
    }

    private static int pr() {
        try {
            return w.hn();
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
            return -1;
        }
    }

    private static byte[] pr(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrPr;
        if (bArr == null || bArr.length == 0 || !w.hw() || (bArrPr = pr(bArr, bArr2, bArr3)) == null) {
            return null;
        }
        try {
            return SoftDecTool.bc(i, bArrPr);
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
            return null;
        }
    }

    private static byte[] pr(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2 == null || bArr2.length != 16 || bArr3 == null || bArr3.length != 32) {
            return null;
        }
        byte[] bArr4 = new byte[bArr.length + 48];
        System.arraycopy(bArr2, 0, bArr4, 0, 16);
        System.arraycopy(bArr3, 0, bArr4, 16, 32);
        System.arraycopy(bArr, 0, bArr4, 48, bArr.length);
        return bArr4;
    }

    private static boolean c(String str, String str2, String str3) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str2.length() != 16 || str3.length() != 32) ? false : true;
    }
}
