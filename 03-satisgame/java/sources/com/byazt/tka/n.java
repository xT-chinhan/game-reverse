package com.byazt.tka;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.PointerIconCompat;
import com.byakv.z.SoftDecTool;
import com.byazt.tk.k;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 19})
public class n {
    public static String n(String str, String str2, String str3) {
        try {
            int iN = n();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strS = s(str, str2, str3);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (!TextUtils.isEmpty(strS)) {
                return strS;
            }
            d.n(301, jElapsedRealtime2, iN);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Throwable th) {
            k.qg("AES", String.valueOf(th.getMessage()));
            return null;
        }
    }

    public static String qg(String str, String str2, String str3) {
        try {
            int iN = n();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strQ = q(str, str2, str3);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (!TextUtils.isEmpty(strQ)) {
                return strQ;
            }
            d.n(302, jElapsedRealtime2, iN);
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return new String(cipher.doFinal(bArrDecode));
        } catch (Throwable th) {
            k.qg("AES", String.valueOf(th.getMessage()));
            return null;
        }
    }

    private static String s(String str, String str2, String str3) {
        if (!l(str, str2, str3)) {
            return null;
        }
        try {
            byte[] bArrN = n(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, str.getBytes("utf-8"), str2.getBytes(), str3.getBytes());
            if (bArrN != null && bArrN.length > 0) {
                return Base64.encodeToString(bArrN, 0);
            }
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
        return null;
    }

    private static String q(String str, String str2, String str3) {
        if (!l(str, str2, str3)) {
            return null;
        }
        try {
            byte[] bArrN = n(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, Base64.decode(str, 0), str2.getBytes(), str3.getBytes());
            if (bArrN != null && bArrN.length > 0) {
                return new String(bArrN, "utf-8");
            }
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
        }
        return null;
    }

    private static int n() {
        try {
            return d.s();
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
            return -1;
        }
    }

    private static byte[] n(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrN;
        if (bArr == null || bArr.length == 0 || !d.qg() || (bArrN = n(bArr, bArr2, bArr3)) == null) {
            return null;
        }
        try {
            return SoftDecTool.bc(i, bArrN);
        } catch (Throwable th) {
            String.valueOf(th.getMessage());
            return null;
        }
    }

    private static byte[] n(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2 == null || bArr2.length != 16 || bArr3 == null || bArr3.length != 32) {
            return null;
        }
        byte[] bArr4 = new byte[bArr.length + 48];
        System.arraycopy(bArr2, 0, bArr4, 0, 16);
        System.arraycopy(bArr3, 0, bArr4, 16, 32);
        System.arraycopy(bArr, 0, bArr4, 48, bArr.length);
        return bArr4;
    }

    private static boolean l(String str, String str2, String str3) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || str2.length() != 16 || str3.length() != 32) ? false : true;
    }
}
