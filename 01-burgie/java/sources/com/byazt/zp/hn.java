package com.byazt.zp;

import com.byakv.z.TTEncryptUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 20})
public class hn {
    public static byte[] pr(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.pr(bArr, i);
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
