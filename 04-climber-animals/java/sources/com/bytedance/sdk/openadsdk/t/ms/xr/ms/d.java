package com.bytedance.sdk.openadsdk.t.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.hi;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4117ms;

    public d(Bridge bridge) {
        this.f4117ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, String str) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        this.f4117ms.call(132101, xrVarMs.xr(), Void.class);
    }

    public void ms(hi hiVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, hiVar);
        this.f4117ms.call(132102, xrVarMs.xr(), Void.class);
    }

    public void xr() {
        this.f4117ms.call(132104, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), Void.class);
    }

    public void xr(hi hiVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, hiVar);
        this.f4117ms.call(132103, xrVarMs.xr(), Void.class);
    }
}
