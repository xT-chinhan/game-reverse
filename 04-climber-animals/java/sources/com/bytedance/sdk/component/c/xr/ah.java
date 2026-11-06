package com.bytedance.sdk.component.c.xr;

import com.bytedance.sdk.component.c.u;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.component.c.ka {
    private boolean ah;
    private u d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1193ms;
    private boolean xr;

    public ah(String str, boolean z, boolean z2, u uVar) {
        this.f1193ms = str;
        this.xr = z;
        this.ah = z2;
        this.d = uVar;
    }

    @Override // com.bytedance.sdk.component.c.ka
    public String ms() {
        return this.f1193ms;
    }

    @Override // com.bytedance.sdk.component.c.ka
    public boolean xr() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.c.ka
    public boolean ah() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.c.ka
    public u d() {
        return this.d;
    }
}
