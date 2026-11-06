package com.bytedance.sdk.component.c.ah.ms.xr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.c.qv;

/* JADX INFO: loaded from: classes2.dex */
public class d implements qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final qv f1180ms;
    private final com.bytedance.sdk.component.c.ah.ms.xr xr;

    public d(qv qvVar) {
        this(qvVar, null);
    }

    public d(qv qvVar, com.bytedance.sdk.component.c.ah.ms.xr xrVar) {
        this.f1180ms = qvVar;
        this.xr = xrVar;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean ms(String str, Bitmap bitmap) {
        boolean zMs = this.f1180ms.ms(str, bitmap);
        if (this.xr != null) {
            Boolean.valueOf(zMs);
        }
        return zMs;
    }

    @Override // com.bytedance.sdk.component.c.ms
    public Bitmap ms(String str) {
        return this.f1180ms.ms(str);
    }

    @Override // com.bytedance.sdk.component.c.ms
    public boolean xr(String str) {
        return this.f1180ms.xr(str);
    }

    @Override // com.bytedance.sdk.component.c.ms
    public void ms(double d) {
        this.f1180ms.ms(d);
    }
}
