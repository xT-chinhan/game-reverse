package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.85f;
    }

    ab(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "参与互动可以领取福利");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
