package com.byakv.z;

import com.byazt.km.cp;
import com.byazt.xhd.s;

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
            s.n("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            cp.qg(e);
        }
    }

    public static byte[] n(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] qg(byte[] bArr, int i) {
        try {
            return ttDecrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
