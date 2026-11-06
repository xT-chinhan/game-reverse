package com.bytedance.sdk.openadsdk.core.ka.ka.ms;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.core.ka.ka.ka;
import com.bytedance.sdk.openadsdk.core.nw.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class d extends xr implements Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final AtomicBoolean f2804ms = new AtomicBoolean(false);
    private final AtomicBoolean xr = new AtomicBoolean(false);
    private final AtomicBoolean ah = new AtomicBoolean(false);
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final AtomicBoolean sl = new AtomicBoolean(false);

    public d(x.ms msVar) {
        this.ka = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(ka kaVar, int i, String str) {
        this.x = kaVar;
        this.ny = i;
        this.ch = str;
        this.ah.set(true);
        this.sl.set(true);
        xr();
    }

    public void ms() {
        com.bytedance.sdk.component.utils.x.xr().postDelayed(this, d());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2804ms.set(true);
        xr();
    }

    public void xr() {
        if (this.sl.get()) {
            com.bytedance.sdk.component.utils.x.xr().removeCallbacks(this);
            if (this.c != null) {
                ms(this.c, 1);
                return;
            } else {
                if (this.d.get()) {
                    if (this.ab != null) {
                        ms(this.ab, 2);
                        return;
                    } else {
                        ms(null, 3);
                        return;
                    }
                }
                return;
            }
        }
        if (this.f2804ms.get() && this.d.get()) {
            ms(this.ab, this.ab != null ? 2 : 3);
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.ka.ka.ah ahVar, int i) {
        if (this.xr.compareAndSet(false, true)) {
            this.hi = i;
            if (i == 3) {
                if (this.x != null) {
                    this.x.ms(this.ny, this.ch);
                }
            } else if (ahVar != null) {
                ahVar.ms();
            }
            if (i == 1 && this.ab != null) {
                this.ab.ah();
            }
            if (i != 2 || this.c == null) {
                return;
            }
            this.c.ah();
            return;
        }
        if (i == this.hi || ahVar == null) {
            return;
        }
        ahVar.ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ms(boolean z) {
        this.d.set(true);
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ka.ka.ms.xr
    public void ah() {
        this.sl.set(true);
        xr();
    }

    private long d() {
        return (this.ka == null || this.ka.c() <= 0) ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : this.ka.c();
    }
}
