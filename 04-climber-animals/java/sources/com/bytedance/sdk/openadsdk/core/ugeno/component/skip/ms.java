package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<CycleSkipView> {
    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public CycleSkipView ms() {
        return new CycleSkipView(this.xr);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
    }

    public void xr(int i, int i2) {
        if (this.ka != 0) {
            ((CycleSkipView) this.ka).ms(i, i2);
        }
    }
}
