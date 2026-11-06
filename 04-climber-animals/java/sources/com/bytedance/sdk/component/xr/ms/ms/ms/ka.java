package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements com.bytedance.sdk.component.xr.ms.ny.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    t.ms f1607ms;

    public ka(t.ms msVar) {
        this.f1607ms = msVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ny.ms
    public u ms() {
        return new x(this.f1607ms.ms());
    }

    @Override // com.bytedance.sdk.component.xr.ms.ny.ms
    public ao ms(u uVar) throws IOException {
        return new ny(this.f1607ms.ms(this.f1607ms.ms().c().ms(uVar.xr().ms()).ms()));
    }
}
