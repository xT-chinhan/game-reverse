package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private t f1013ms;

    public ny(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1013ms = tVar;
    }

    public final t ms() {
        return this.f1013ms;
    }

    public final ny ms(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1013ms = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public t ms(long j, TimeUnit timeUnit) {
        return this.f1013ms.ms(j, timeUnit);
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public long f_() {
        return this.f1013ms.f_();
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public boolean ah() {
        return this.f1013ms.ah();
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public long g_() {
        return this.f1013ms.g_();
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public t ms(long j) {
        return this.f1013ms.ms(j);
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public t ka() {
        return this.f1013ms.ka();
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public t c() {
        return this.f1013ms.c();
    }

    @Override // com.bytedance.sdk.component.ah.ms.t
    public void ab() throws IOException {
        this.f1013ms.ab();
    }
}
