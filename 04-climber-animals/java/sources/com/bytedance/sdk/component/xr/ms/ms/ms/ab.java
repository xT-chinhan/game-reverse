package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.re;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.component.xr.ms.d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    re f1603ms;

    public ab(re reVar) {
        this.f1603ms = reVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.d
    public void ms(int i) {
        this.f1603ms.y().ms(i);
    }

    @Override // com.bytedance.sdk.component.xr.ms.d
    public void xr(int i) {
        if (i < 5) {
            this.f1603ms.y().xr(5);
        } else {
            this.f1603ms.y().xr(i);
        }
    }
}
