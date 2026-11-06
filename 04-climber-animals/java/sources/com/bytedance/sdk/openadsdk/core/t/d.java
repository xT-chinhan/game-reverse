package com.bytedance.sdk.openadsdk.core.t;

import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.jw.b;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {"embed_applog"})
public class d {
    @ATSMethod(1)
    public String ms() {
        return com.bytedance.sdk.openadsdk.core.c.ms().ah();
    }

    @ATSMethod(2)
    public String xr() {
        return b.ms(false);
    }

    @ATSMethod(3)
    public byte[] ms(byte[] bArr, int i) {
        return com.bytedance.sdk.openadsdk.op.xr.ms(bArr, i);
    }
}
