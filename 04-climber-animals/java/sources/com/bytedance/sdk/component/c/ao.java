package com.bytedance.sdk.component.c;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi
public interface ao<T> {
    @ATSMethod(2)
    void ms(int i, String str, Throwable th);

    @ATSMethod(1)
    void ms(hi<T> hiVar);
}
