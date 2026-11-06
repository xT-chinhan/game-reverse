package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.oh;
import com.bytedance.sdk.openadsdk.op.c;

/* JADX INFO: loaded from: classes2.dex */
public class TTEncryptUtils {
    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            c.ms("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            oh.xr(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
