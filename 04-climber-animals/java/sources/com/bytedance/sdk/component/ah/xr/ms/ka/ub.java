package com.bytedance.sdk.component.ah.xr.ms.ka;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ub extends IOException {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final xr f1101ms;

    public ub(xr xrVar) {
        super("stream was reset: ".concat(String.valueOf(xrVar)));
        this.f1101ms = xrVar;
    }
}
