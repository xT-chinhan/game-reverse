package com.bytedance.sdk.openadsdk.t.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ub;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4114ms;

    public ab(Bridge bridge) {
        this.f4114ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, String str) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        this.f4114ms.call(124101, xrVarMs.xr(), Void.class);
    }

    public void ms(ub ubVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, ubVar);
        this.f4114ms.call(124102, xrVarMs.xr(), Void.class);
    }

    public void xr() {
        this.f4114ms.call(124104, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), Void.class);
    }

    public void xr(ub ubVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, ubVar);
        this.f4114ms.call(124103, xrVarMs.xr(), Void.class);
    }
}
