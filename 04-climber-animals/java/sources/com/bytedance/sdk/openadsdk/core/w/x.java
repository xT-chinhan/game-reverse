package com.bytedance.sdk.openadsdk.core.w;

import com.bykv.vk.openvk.api.proto.Result;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3691ms;
    private Result xr;

    public x(Result result, int i) {
        this.f3691ms = i;
        this.xr = result;
    }

    public int getType() {
        return this.f3691ms;
    }

    public Result ah() {
        return this.xr;
    }

    public void setResult(Result result) {
        this.xr = result;
    }
}
