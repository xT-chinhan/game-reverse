package com.byakv.z;

import com.byazt.ec.w;
import com.byazt.zp.fw;

/* JADX INFO: loaded from: classes.dex */
public class TTEncryptUtils {
    public static native String clientPackedBase64(byte[] bArr, int i);

    public static native byte[] clientUnpackedBase64(String str);

    public static native String getDA0Result(String str);

    public static native int[] getDI0Result(String[] strArr);

    private static native byte[] ttDecrypt(byte[] bArr, int i);

    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            fw.pr("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            w.hw(e);
        }
    }

    public static byte[] pr(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] hw(byte[] bArr, int i) {
        try {
            return ttDecrypt(bArr, i);
        } catch (Throwable th) {
            return null;
        }
    }
}
