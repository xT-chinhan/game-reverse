package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.75f;
    }

    sl(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.f2097ms);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
