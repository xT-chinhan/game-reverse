package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ms {
    ms h;

    public zb(Activity activity, lm lmVar) {
        super(activity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        ArrayList<gy> arrayListT = qf.t(this.ab);
        if (arrayListT == null) {
            return new xr.ms(false, 0, "");
        }
        for (gy gyVar : arrayListT) {
            switch (gyVar.ah()) {
                case 1:
                    this.h = new sl(this.x, this.ab, gyVar);
                    break;
                case 2:
                    this.h = new hi(this.x, this.ab, gyVar);
                    break;
                case 3:
                    this.h = new c(this.x, this.ab, gyVar);
                    break;
                case 4:
                    this.h = new ab(this.x, this.ab, gyVar);
                    break;
                case 5:
                    this.h = new ny(this.x, this.ab, gyVar);
                    break;
                case 6:
                    this.h = new d(this.x, this.ab, gyVar);
                    break;
            }
            ms msVar = this.h;
            if (msVar != null) {
                msVar.ms(this.ah);
                this.h.ms(this.f2097ms);
                this.h.xr(this.xr);
                this.h.xr(this.d);
                this.h.ah(this.sl);
                this.h.d(this.hi);
                this.h.ah(this.c);
                this.h.d(this.ka);
                this.h.ms(this.ao);
                this.h.xr(ny());
                xr.ms msVarXr = this.h.xr(chVar);
                if (msVarXr.ah()) {
                    return msVarXr;
                }
            }
        }
        return new xr.ms(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void xr(String str) {
        super.xr(str);
        ms msVar = this.h;
        if (msVar == null) {
            return;
        }
        msVar.xr(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        ms msVar = this.h;
        if (msVar == null) {
            return null;
        }
        String strMs = msVar.ms();
        try {
            JSONObject jSONObject = new JSONObject(strMs);
            jSONObject.put("is_need_click", this.ka);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return strMs;
        }
    }
}
