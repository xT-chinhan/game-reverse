package com.bytedance.sdk.component.xr.ms.ms.xr;

import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.ny;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ny.ms {
    int ah = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    List<ny> f1617ms;
    u xr;

    xr(List<ny> list, u uVar) {
        this.f1617ms = list;
        this.xr = uVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ny.ms
    public u ms() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.xr.ms.ny.ms
    public ao ms(u uVar) throws IOException {
        this.xr = uVar;
        int i = this.ah + 1;
        this.ah = i;
        return this.f1617ms.get(i).ms(this);
    }
}
