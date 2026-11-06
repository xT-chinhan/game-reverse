package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile u f2735ms;
    private com.bytedance.sdk.component.d.ms.xr xr;

    public static u ms() {
        if (f2735ms == null) {
            synchronized (u.class) {
                if (f2735ms == null) {
                    f2735ms = new u();
                }
            }
        }
        return f2735ms;
    }

    public void ms(Intent intent) {
        final boolean z = (intent.getFlags() & 8388608) == 8388608;
        com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.u.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int iXr = u.this.xr().xr("all_activity_count", 0) + 1;
                if (z) {
                    int iXr2 = u.this.xr().xr("hide_activity_count", 0) + 1;
                    if (iXr2 >= 10) {
                        u.this.ms(iXr);
                        iXr = 0;
                    } else {
                        i = iXr2;
                    }
                    u.this.xr().ms("hide_activity_count", i);
                }
                u.this.xr().ms("all_activity_count", iXr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.d.ms.xr xr() {
        if (this.xr == null) {
            this.xr = g.ms("hide_recent_activity_recorder");
        }
        return this.xr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final int i) {
        try {
            com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.jw.u.2
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ac", i);
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("hide_activity_record").xr(jSONObject.toString());
                }
            }, "hide_activity_record");
        } catch (Throwable unused) {
        }
    }
}
