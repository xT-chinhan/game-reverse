package com.bytedance.sdk.component.c;

import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi("img_service")
public interface ub {
    @ATSMethod(4)
    void ah(double d);

    @ATSMethod(1)
    ch ms(String str);

    @ATSMethod(6)
    InputStream ms(String str, String str2);

    @ATSMethod(7)
    InputStream ms(String str, String str2, String str3);

    @ATSMethod(5)
    void ms();

    @ATSMethod(2)
    void ms(double d);

    @ATSMethod(3)
    void xr(double d);

    @ATSMethod(8)
    boolean xr(String str, String str2, String str3);
}
