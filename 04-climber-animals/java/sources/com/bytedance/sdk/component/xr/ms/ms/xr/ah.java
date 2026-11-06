package com.bytedance.sdk.component.xr.ms.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends sl {
    public d zb;

    public ah(sl.ms msVar) {
        super(msVar);
        this.zb = new d();
    }

    @Override // com.bytedance.sdk.component.xr.ms.sl
    public com.bytedance.sdk.component.xr.ms.d ms() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.component.xr.ms.sl
    public com.bytedance.sdk.component.xr.ms.xr ms(u uVar) {
        uVar.ms(this);
        if (uVar == null || uVar.xr() == null || uVar.xr().ms() == null || TextUtils.isEmpty(uVar.xr().ms().toString())) {
            return null;
        }
        return new ms(uVar, this.zb);
    }
}
