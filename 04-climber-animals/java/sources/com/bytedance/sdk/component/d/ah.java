package com.bytedance.sdk.component.d;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi("system_info")
public interface ah {
    @ATSMethod(3)
    long ah(String str);

    @ATSMethod(4)
    boolean d(String str);

    @ATSMethod(1)
    String ms(String str);

    @ATSMethod(5)
    void ms(String str, String str2);

    @ATSMethod(2)
    int xr(String str);
}
