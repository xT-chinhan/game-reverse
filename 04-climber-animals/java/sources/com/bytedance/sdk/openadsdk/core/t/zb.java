package com.bytedance.sdk.openadsdk.core.t;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class zb implements com.bytedance.sdk.openadsdk.core.t.ah.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final zb f3364ms = new zb();

    private zb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.t.ah.ms
    public void ms(final com.bytedance.sdk.openadsdk.hi.ms.ms msVar, final String str, final boolean z) {
        com.bytedance.sdk.openadsdk.op.ab.xr(new com.bytedance.sdk.component.ch.ny("uploadLogEvent") { // from class: com.bytedance.sdk.openadsdk.core.t.zb.1
            @Override // java.lang.Runnable
            public void run() {
                if (ka.ms(str, 1.0d) || !z) {
                    zb.this.ms(msVar, z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(com.bytedance.sdk.openadsdk.hi.ms.ms msVar, boolean z) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObjectMs = msVar.ms().ms();
            if (jSONObjectMs != null) {
                String strOptString = jSONObjectMs.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(strOptString);
                }
                int iIncrementAndGet = xr.xr.incrementAndGet();
                jSONObject.put("stats_index", iIncrementAndGet);
                jSONObject.put("sdk_session_id", xr.f3363ms);
                jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.ch.ub().lm() ? 1 : 0);
                if (!TextUtils.isEmpty(f.ny)) {
                    jSONObject.put("wrong_stats_url", f.ny);
                }
                if (!TextUtils.isEmpty(f.ch)) {
                    jSONObject.put("wrong_applog_url", f.ch);
                }
                try {
                    jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("DeviceRate", "bytebench_value")));
                } catch (Exception unused) {
                }
                try {
                    jSONObject.put("abtest_version", com.bytedance.sdk.openadsdk.core.ch.ub().v());
                } catch (Exception unused2) {
                }
                if (com.bytedance.sdk.openadsdk.core.ch.ub().ab()) {
                    jSONObject.putOpt("first_of_two", 1);
                }
                jSONObjectMs.put("event_extra", jSONObject.toString());
                com.bytedance.sdk.component.x.xr.d.ms.ms msVar2 = new com.bytedance.sdk.component.x.xr.d.ms.ms(UUID.randomUUID().toString(), jSONObjectMs);
                msVar2.ah((byte) 0);
                msVar2.xr((byte) 3);
                msVar2.ms((byte) 1);
                xr.ms(msVar2, jSONObjectMs.optString("type"), iIncrementAndGet);
            }
        } catch (Throwable unused3) {
        }
    }
}
