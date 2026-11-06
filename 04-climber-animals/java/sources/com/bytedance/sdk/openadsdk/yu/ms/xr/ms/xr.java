package com.bytedance.sdk.openadsdk.yu.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4316ms;

    public xr(Bridge bridge) {
        this.f4316ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, com.bytedance.sdk.openadsdk.h.ms.ms.xr.ms.ms msVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, msVar);
        this.f4316ms.call(122101, xrVarMs.xr(), Void.class);
    }
}
