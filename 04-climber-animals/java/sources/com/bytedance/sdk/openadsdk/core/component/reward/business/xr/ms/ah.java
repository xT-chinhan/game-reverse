package com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms;

import android.app.Activity;
import android.text.TextUtils;
import com.anythink.core.common.e.b;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.75f;
    }

    public ah(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        return (TextUtils.isEmpty(this.hi) || TextUtils.isEmpty(this.sl)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reward_name", this.hi);
            jSONObject.put("reward_amount", this.sl);
            jSONObject.put(b.a.f, this.f2122ms);
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject.toString();
    }
}
