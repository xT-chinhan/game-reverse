package com.bytedance.pangle.x;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    public static boolean ms(String str, String str2) throws Throwable {
        ub ubVarMs;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (com.bytedance.pangle.util.ny.ms()) {
                ubVarMs = d.ms(str, 1);
            } else {
                ubVarMs = ms.ms(str, true);
            }
            Signature[] signatureArr = ubVarMs != null ? ubVarMs.xr : null;
            byte[] bArrDecode = Base64.decode(Zeus.getPlugin(str2).mSignature, 0);
            if (bArrDecode == null || bArrDecode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                return false;
            }
            int length = 0;
            for (Signature signature : signatureArr) {
                length += signature.toByteArray().length;
            }
            byte[] bArr = new byte[length];
            int length2 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, length2, signature2.toByteArray().length);
                length2 += signature2.toByteArray().length;
            }
            boolean zMs = ub.ms(bArr, bArrDecode);
            if (!zMs) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return zMs;
        } catch (h e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
