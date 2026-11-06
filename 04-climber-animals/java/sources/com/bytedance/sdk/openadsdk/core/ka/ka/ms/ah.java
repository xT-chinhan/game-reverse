package com.bytedance.sdk.openadsdk.core.ka.ka.ms;

import com.bytedance.sdk.openadsdk.core.ka.ka.ka;
import com.bytedance.sdk.openadsdk.core.nw.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicBoolean f2803ms = new AtomicBoolean(false);
    private final AtomicBoolean xr = new AtomicBoolean(false);
    private final AtomicBoolean ah = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean sl = new AtomicBoolean(false);

    public ah(x.ms msVar) {
        this.ka = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(ka kaVar, int i, String str) {
        this.x = kaVar;
        this.ny = i;
        this.ch = str;
        this.xr.set(true);
        this.sl.set(true);
        ms();
    }

    public void ms() {
        if (this.d.get() && this.hi != 2 && this.ab != null) {
            ms(this.ab, 2);
            return;
        }
        if (this.sl.get()) {
            if (this.c != null) {
                ms(this.c, 1);
            } else if (this.ah.get()) {
                ms(null, 3);
            }
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar, int i) {
        if (!this.f2803ms.compareAndSet(false, true)) {
            if (ahVar != null) {
                ahVar.ah();
                return;
            }
            return;
        }
        this.hi = i;
        if (i == 3) {
            if (this.x != null) {
                this.x.ms(this.ny, this.ch);
            }
        } else if (ahVar != null) {
            ahVar.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(boolean z) {
        if (z) {
            this.d.set(true);
            ms();
        } else {
            this.ah.set(true);
            ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ah() {
        this.sl.set(true);
        ms();
    }
}
