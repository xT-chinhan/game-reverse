package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.nw;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends g {
    private final com.bytedance.sdk.component.ah.ms.ka ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f1065ms;
    private final long xr;

    public x(String str, long j, com.bytedance.sdk.component.ah.ms.ka kaVar) {
        this.f1065ms = str;
        this.xr = j;
        this.ah = kaVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.g
    public nw ms() {
        String str = this.f1065ms;
        if (str != null) {
            return nw.ms(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ah.xr.g
    public long xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.ah.xr.g
    public com.bytedance.sdk.component.ah.ms.ka ah() {
        return this.ah;
    }
}
