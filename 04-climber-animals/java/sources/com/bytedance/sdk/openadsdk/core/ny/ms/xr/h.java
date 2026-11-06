package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class h implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = "type")
    private String f3164ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "log_extra")
    private String xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (!ms()) {
            com.bytedance.sdk.component.utils.sl.d("UChain_ReportStatsAction", "ifHasAllRequiredParam = false");
            msVar.xr(map2);
            return false;
        }
        final JSONObject jSONObjectMs = ms(map);
        final int iX = f.x(this.ah);
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ny.ms.xr.h.1
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms(h.this.f3164ms).x(h.this.xr).ms(iX).xr(jSONObjectMs.toString());
            }
        }, this.f3164ms);
        msVar.ms(map2);
        return true;
    }

    private JSONObject ms(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add("type");
            hashSet.add("log_extra");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private boolean ms() {
        return (TextUtils.isEmpty(this.f3164ms) || TextUtils.isEmpty(this.xr)) ? false : true;
    }
}
