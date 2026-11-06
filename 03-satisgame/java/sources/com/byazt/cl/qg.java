package com.byazt.cl;

import com.byakv.z.TTEncryptUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1321, 26})
public class qg {
    public static byte[] n(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.n(bArr, i);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
