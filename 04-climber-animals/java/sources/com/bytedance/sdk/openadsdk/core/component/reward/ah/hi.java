package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.75f;
    }

    hi(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        if (!qf.ah(this.ab)) {
            return false;
        }
        try {
            return (Integer.parseInt(this.sl) == 0 || TextUtils.isEmpty(this.sl) || TextUtils.isEmpty(this.hi)) ? false : true;
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.f2097ms + "s 可获得奖励");
            jSONObject.put("number", this.sl);
            jSONObject.put("number_unit", this.hi);
            jSONObject.put("remain_time", this.f2097ms);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
