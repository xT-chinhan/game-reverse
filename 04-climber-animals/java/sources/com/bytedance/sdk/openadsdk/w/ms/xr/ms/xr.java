package com.bytedance.sdk.openadsdk.w.ms.xr.ms;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Bridge f4288ms;

    public xr(Bridge bridge) {
        this.f4288ms = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    public void ms(View view, int i) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, view);
        xrVarMs.ms(1, i);
        this.f4288ms.call(151101, xrVarMs.xr(), Void.class);
    }

    public void xr(View view, int i) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(2);
        xrVarMs.ms(0, view);
        xrVarMs.ms(1, i);
        this.f4288ms.call(151102, xrVarMs.xr(), Void.class);
    }

    public void ms(View view, String str, int i) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(3);
        xrVarMs.ms(0, view);
        xrVarMs.ms(1, str);
        xrVarMs.ms(2, i);
        this.f4288ms.call(151103, xrVarMs.xr(), Void.class);
    }

    public void ms(View view, float f, float f2) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(3);
        xrVarMs.ms(0, view);
        xrVarMs.ms(1, f);
        xrVarMs.ms(2, f2);
        this.f4288ms.call(151104, xrVarMs.xr(), Void.class);
    }
}
