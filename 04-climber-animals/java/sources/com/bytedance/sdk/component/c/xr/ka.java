package com.bytedance.sdk.component.c.xr;

import com.bytedance.sdk.component.c.ab;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ab {
    private long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f1195ms;
    private long xr;

    @Override // com.bytedance.sdk.component.c.ab
    @ATSMethod(1)
    public long ms() {
        return this.f1195ms;
    }

    public void ms(long j) {
        this.f1195ms = j;
    }

    @Override // com.bytedance.sdk.component.c.ab
    @ATSMethod(2)
    public long xr() {
        return this.xr;
    }

    public void xr(long j) {
        this.xr = j;
    }

    @Override // com.bytedance.sdk.component.c.ab
    @ATSMethod(3)
    public long ah() {
        return this.ah;
    }

    public void ah(long j) {
        this.ah = j;
    }
}
