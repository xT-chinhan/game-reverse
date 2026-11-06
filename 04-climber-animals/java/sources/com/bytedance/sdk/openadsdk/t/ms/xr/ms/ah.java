package com.bytedance.sdk.openadsdk.t.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ch;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4115ms;

    public ah(Bridge bridge) {
        this.f4115ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(int i, String str) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, i);
        xrVarMs.ms(1, str);
        this.f4115ms.call(164101, xrVarMs.xr(), Void.class);
    }

    public void ms(List<ch> list) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, list);
        this.f4115ms.call(164102, xrVarMs.xr(), Void.class);
    }
}
