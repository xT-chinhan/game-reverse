package com.bytedance.sdk.openadsdk.core.ny.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.bytedance.sdk.component.hi.xr.xr
public class ao implements com.bytedance.sdk.component.hi.ms.ms.ah {

    @com.bytedance.sdk.component.hi.xr.ms(ms = "material_meta")
    private lm ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    @com.bytedance.sdk.component.hi.xr.ms(ms = TTDownloadField.TT_LABEL)
    private String f3158ms;

    @com.bytedance.sdk.component.hi.xr.ms(ms = "log_extra")
    private String xr;

    @Override // com.bytedance.sdk.component.hi.ms.ms.ah
    public boolean ms(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.hi.ms.ms msVar) {
        if (!ms()) {
            com.bytedance.sdk.component.utils.sl.d("UChain_ReportEventAction", "ifHasAllRequiredParam = false");
            msVar.xr(map2);
            return false;
        }
        JSONObject jSONObjectMs = ms(map);
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, f.xr(this.ah), this.f3158ms, jSONObjectMs);
        msVar.ms(map2);
        return true;
    }

    private JSONObject ms(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(TTDownloadField.TT_LABEL);
            hashSet.add("ad_id");
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
        return (TextUtils.isEmpty(this.f3158ms) || TextUtils.isEmpty(this.xr) || this.ah == null) ? false : true;
    }
}
