package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms {
    private int h;
    private int qv;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected void ms(com.bytedance.sdk.openadsdk.core.widget.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.75f;
    }

    c(Activity activity, lm lmVar, gy gyVar) {
        JSONObject jSONObjectXr;
        super(activity, lmVar, gyVar);
        if (this.ny == null || (jSONObjectXr = this.ny.xr()) == null) {
            return;
        }
        this.h = jSONObjectXr.optInt("reduce_time");
        this.qv = jSONObjectXr.optInt("reduce_duration");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        return (this.ny == null || !this.ny.c()) && this.h > 0 && this.qv > 0 && this.xr < this.qv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected void d(ch chVar) {
        if (chVar != null) {
            chVar.ms(this.h);
        }
        this.ny.ms(true);
        if (chVar != null) {
            chVar.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.h + "s");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
