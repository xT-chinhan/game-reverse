package com.bytedance.sdk.component.x.xr.xr.ah;

import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    protected final com.bytedance.sdk.component.x.xr.xr.xr ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile ah f1578ms;
    protected final com.bytedance.sdk.component.x.ms.ka xr;

    public void ah() {
    }

    public d(com.bytedance.sdk.component.x.ms.ka kaVar, com.bytedance.sdk.component.x.xr.xr.xr xrVar) {
        this.xr = kaVar;
        this.ah = xrVar;
    }

    public ah ka() {
        if (this.f1578ms == null) {
            synchronized (this) {
                if (this.f1578ms == null) {
                    this.f1578ms = new ah();
                }
            }
        }
        return this.f1578ms;
    }

    public void c() {
        com.bytedance.sdk.component.x.ms.d dVarD = this.xr.d();
        if (dVarD == null || dVarD.xr() == null) {
            ah ahVarKa = ka();
            ahVarKa.ms(this);
            ahVarKa.start();
            return;
        }
        ah();
    }

    public Looper ab() {
        com.bytedance.sdk.component.x.ms.d dVarD = this.xr.d();
        if (dVarD == null || dVarD.xr() == null) {
            return ka().getLooper();
        }
        return dVarD.xr();
    }
}
