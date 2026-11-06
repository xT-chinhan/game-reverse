package com.bytedance.sdk.openadsdk.y.ms.xr.ms;

import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4312ms;

    public ms(Bridge bridge) {
        this.f4312ms = bridge == null ? xr.xr : bridge;
    }

    public void ms() {
        this.f4312ms.call(244101, xr.ms(0).xr(), Void.class);
    }

    public void ms(int i, String str, boolean z) {
        xr xrVarMs = xr.ms(3);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        xrVarMs.ms(2, z);
        this.f4312ms.call(244102, xrVarMs.xr(), Void.class);
    }

    public void xr() {
        this.f4312ms.call(244103, xr.ms(0).xr(), Void.class);
    }
}
