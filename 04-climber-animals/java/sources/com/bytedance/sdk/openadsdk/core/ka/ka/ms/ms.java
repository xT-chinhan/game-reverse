package com.bytedance.sdk.openadsdk.core.ka.ka.ms;

import com.bytedance.sdk.openadsdk.core.ka.ka.ka;
import com.bytedance.sdk.openadsdk.core.nw.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicBoolean f2805ms = new AtomicBoolean(false);
    private final AtomicBoolean xr = new AtomicBoolean(false);
    private final AtomicBoolean ah = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);

    public abstract void ms();

    public ms(x.ms msVar) {
        this.ka = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(ka kaVar, int i, String str) {
        this.x = kaVar;
        this.ny = i;
        this.ch = str;
        this.d.set(true);
        xr();
    }

    public void xr() {
        if (this.ah.get() && this.ab != null) {
            ms(this.ab, 2);
        } else if (this.d.get()) {
            if (this.c != null) {
                ms(this.c, 1);
            } else {
                ms(null, 3);
            }
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar, int i) {
        if (this.f2805ms.compareAndSet(false, true)) {
            if (i == 3) {
                if (this.x != null) {
                    this.x.ms(this.ny, this.ch);
                }
            } else if (ahVar != null) {
                ahVar.ms();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(boolean z) {
        if (z) {
            this.ah.set(true);
            xr();
        } else {
            this.xr.set(true);
            ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ah() {
        this.d.set(true);
        xr();
    }
}
