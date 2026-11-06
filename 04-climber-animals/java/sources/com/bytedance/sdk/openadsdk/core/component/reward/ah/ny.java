package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.yu;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends ms {
    private String h;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public int ab() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    protected float x() {
        return 0.6f;
    }

    ny(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
        yu yuVarYl = this.ab.yl();
        if (yuVarYl != null) {
            this.h = yuVarYl.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean c() {
        String str = this.h;
        return (str == null || str.equals("0") || TextUtils.isEmpty(this.h)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        return ah(chVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("red_pack_amount", this.h);
            boolean z = false;
            try {
                if (Double.parseDouble(this.h) != 0.0d) {
                    z = true;
                }
            } catch (NumberFormatException unused) {
            }
            jSONObject.put("is_display_unit", z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }
}
