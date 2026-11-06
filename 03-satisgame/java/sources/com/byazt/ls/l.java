package com.byazt.ls;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 18})
public class l {
    public static boolean n(String str, String str2, StringBuilder sb) throws Throwable {
        k kVarN;
        if (TextUtils.isEmpty(str)) {
            sb.append("apkPath null");
            return false;
        }
        try {
            if (com.byazt.gx.rv.n()) {
                kVarN = q.n(str, 1);
            } else {
                kVarN = n.n(str, true);
            }
            Signature[] signatureArr = kVarN != null ? kVarN.qg : null;
            String str3 = Zeus.getPlugin(str2).mSignature;
            byte[] bArrDecode = Base64.decode(str3, 0);
            if (bArrDecode == null || bArrDecode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                sb.append("hostSignature null ");
                if (TextUtils.isEmpty(str3)) {
                    sb.append("origin sign is null");
                }
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
            boolean zN = k.n(bArr, bArrDecode);
            if (!zN) {
                sb.append("signature error");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return zN;
        } catch (hd e) {
            sb.append("verify e:").append(Log.getStackTraceString(e));
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
