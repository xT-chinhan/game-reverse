package com.bytedance.sdk.openadsdk.core.ugeno.component.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;
import com.bytedance.adsdk.ugeno.xr.ah;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.widget.ah.ms {
    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: am, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout ms() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.xr);
        uGFrameLayout.ms(this);
        return uGFrameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.ah.ms, com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
    }

    public void ms(long j, long j2) {
        zb zbVar;
        JSONObject jSONObjectAh;
        if (!ms(12) || (zbVar = this.nn.get(12)) == null || (jSONObjectAh = zbVar.ah()) == null) {
            return;
        }
        jSONObjectAh.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectAh.optJSONArray("actions");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt("progress") * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    ah ahVarXr = xr(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
                    if (ahVarXr != null) {
                        ahVarXr.ah(strOptString2).xr(0);
                    }
                }
            }
        }
    }
}
