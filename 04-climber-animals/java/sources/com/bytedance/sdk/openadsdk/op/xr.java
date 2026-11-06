package com.bytedance.sdk.openadsdk.op;

import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static byte[] ms(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.a(bArr, i);
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return null;
    }
}
