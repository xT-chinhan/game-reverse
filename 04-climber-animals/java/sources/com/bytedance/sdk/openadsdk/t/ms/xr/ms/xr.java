package com.bytedance.sdk.openadsdk.t.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ny;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4120ms;

    public xr(Bridge bridge) {
        this.f4120ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, String str) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        this.f4120ms.call(172101, xrVarMs.xr(), Void.class);
    }

    public void ms(List<ny> list) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, list);
        this.f4120ms.call(172102, xrVarMs.xr(), Void.class);
    }
}
