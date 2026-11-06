package com.bytedance.sdk.openadsdk.core.dislike.ah;

import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.ao.xr.xr.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final xr f2468ms;

    public ms(xr xrVar) {
        this.f2468ms = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.d
    public List<c> ms() {
        xr xrVar = this.f2468ms;
        if (xrVar == null) {
            return null;
        }
        return xrVar.ms();
    }
}
