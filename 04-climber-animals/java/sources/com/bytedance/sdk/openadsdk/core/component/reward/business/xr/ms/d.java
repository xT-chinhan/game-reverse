package com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    ms xr;

    public d(Activity activity, lm lmVar) {
        super(activity, lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(ch chVar) {
        ArrayList<gy> arrayListKa = k.ka(this.ab);
        if (arrayListKa == null) {
            return new com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms(false, 0, "");
        }
        for (gy gyVar : arrayListKa) {
            if (gyVar.ah() == 1) {
                this.xr = new ah(this.x, this.ab, gyVar);
            }
            ms msVar = this.xr;
            if (msVar != null) {
                msVar.ah(this.sl);
                this.xr.d(this.hi);
                this.xr.ms(this.f2122ms);
                this.xr.xr(ny());
                this.xr.ms(this.ao);
                com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms msVarMs = this.xr.ms(chVar);
                if (msVarMs.ah()) {
                    return msVarMs;
                }
            }
        }
        return new com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        ms msVar = this.xr;
        if (msVar == null) {
            return null;
        }
        return msVar.ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void xr(String str) {
        super.xr(str);
        ms msVar = this.xr;
        if (msVar == null) {
            return;
        }
        msVar.xr(str);
    }
}
