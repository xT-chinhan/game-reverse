package com.bytedance.sdk.component.d;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@ATSApi(NotificationCompat.CATEGORY_EVENT)
public interface ms {
    @ATSMethod(2)
    void ms(String str, JSONObject jSONObject);

    @ATSMethod(1)
    void ms(String str, JSONObject jSONObject, Throwable th);
}
