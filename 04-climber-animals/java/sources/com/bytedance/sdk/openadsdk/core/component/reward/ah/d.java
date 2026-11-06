package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import android.text.TextUtils;
import com.anythink.core.common.e.n;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    private int h;
    private int qv;
    private String t;
    private String y;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.55f;
    }

    d(Activity activity, lm lmVar, gy gyVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, lmVar, gyVar);
        JSONObject jSONObjectXr = gyVar.xr();
        if (jSONObjectXr == null || (jSONObjectOptJSONObject = jSONObjectXr.optJSONObject("coupon")) == null) {
            return;
        }
        this.h = jSONObjectOptJSONObject.optInt(com.tapsdk.tapad.internal.tracker.experiment.d.q);
        this.qv = jSONObjectOptJSONObject.optInt("threshold");
        this.y = jSONObjectOptJSONObject.optString("start_time");
        this.t = jSONObjectOptJSONObject.optString(n.a.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        return (this.h == 0 || this.qv == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.d.q, this.h);
            jSONObject.put("threshold", "满" + this.qv + "元可用");
            if (TextUtils.isEmpty(this.y)) {
                str = TextUtils.isEmpty(this.t) ? "领取当日起30分钟内有效" : "有效期至" + this.t;
            } else if (TextUtils.isEmpty(this.t)) {
                str = "有效期至" + this.y;
            } else {
                str = "有效期" + this.y + "至" + this.t;
            }
            jSONObject.put("start_time", this.y);
            jSONObject.put("expire_text", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
