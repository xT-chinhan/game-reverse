package com.bytedance.sdk.openadsdk.core.t;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@ATS(single = true, value = {NotificationCompat.CATEGORY_EVENT})
public class ah implements com.bytedance.sdk.component.d.ms {
    @Override // com.bytedance.sdk.component.d.ms
    @ATSMethod(1)
    public void ms(String str, JSONObject jSONObject, Throwable th) {
        if (ka.ms(str, 1.0d)) {
            u.ms().ms(str, jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.d.ms
    @ATSMethod(2)
    public void ms(String str, JSONObject jSONObject) {
        u.ms().ms(str, jSONObject);
    }
}
