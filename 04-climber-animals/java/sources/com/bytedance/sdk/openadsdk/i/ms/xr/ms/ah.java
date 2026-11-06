package com.bytedance.sdk.openadsdk.i.ms.xr.ms;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f3921ms;

    public ah(Bridge bridge) {
        this.f3921ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(View view, float f, float f2, boolean z) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(4);
        xrVarMs.ms(0, view);
        xrVarMs.ms(1, f);
        xrVarMs.ms(2, f2);
        xrVarMs.ms(3, z);
        this.f3921ms.call(142101, xrVarMs.xr(), Void.class);
    }
}
