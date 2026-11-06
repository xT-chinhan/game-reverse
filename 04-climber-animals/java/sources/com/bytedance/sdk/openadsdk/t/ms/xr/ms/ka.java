package com.bytedance.sdk.openadsdk.t.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4118ms;

    public ka(Bridge bridge) {
        this.f4118ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, String str) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        this.f4118ms.call(143101, xrVarMs.xr(), Void.class);
    }

    public void ms(List<zb> list) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, list);
        this.f4118ms.call(143102, xrVarMs.xr(), Void.class);
    }
}
