package com.byted.ms.ms.ms;

import android.content.Context;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@ATSApi("alog")
public interface ms {
    @ATSMethod(17)
    void ah();

    @ATSMethod(10)
    void ah(String str, String str2);

    @ATSMethod(11)
    void d(String str, String str2);

    @ATSMethod(14)
    void ka(String str, String str2);

    @ATSMethod(3)
    void ms();

    @ATSMethod(4)
    void ms(int i);

    @ATSMethod(5)
    void ms(Context context, String str, String str2);

    @ATSMethod(1)
    void ms(Context context, JSONObject jSONObject);

    @ATSMethod(6)
    void ms(String str);

    @ATSMethod(8)
    void ms(String str, String str2);

    @ATSMethod(13)
    void ms(String str, String str2, Throwable th);

    @ATSMethod(12)
    void ms(String str, Throwable th);

    @ATSMethod(2)
    void ms(ScheduledExecutorService scheduledExecutorService);

    @ATSMethod(7)
    void xr();

    @ATSMethod(9)
    void xr(String str, String str2);

    @ATSMethod(15)
    void xr(String str, String str2, Throwable th);

    @ATSMethod(16)
    void xr(String str, Throwable th);
}
