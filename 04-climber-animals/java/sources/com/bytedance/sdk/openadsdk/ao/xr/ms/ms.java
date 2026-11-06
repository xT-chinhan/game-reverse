package com.bytedance.sdk.openadsdk.ao.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f1700ms;

    public ms(Bridge bridge) {
        this.f1700ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, Map map) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, map);
        this.f1700ms.call(100101, xrVarMs.xr(), Void.class);
    }
}
