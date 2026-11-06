package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private lm ah;
    private boolean c = false;
    private xr d;
    private ka ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f2302ms;
    private final TTBaseVideoActivity xr;

    public d(TTBaseVideoActivity tTBaseVideoActivity) {
        this.xr = tTBaseVideoActivity;
    }

    public void ms(xr xrVar, lm lmVar, String str, ka kaVar) {
        if (this.c) {
            return;
        }
        this.c = true;
        this.d = xrVar;
        this.ah = lmVar;
        this.ka = kaVar;
    }

    public void ms() {
        if (nw.xr(this.ah) && !this.d.pc()) {
            d();
        }
    }

    public void ms(boolean z) {
        xr xrVar = this.d;
        if (xrVar != null && xrVar.le()) {
            this.f2302ms = z;
            this.ka.d(z);
            this.d.ms(this.f2302ms);
        }
    }

    public void xr() {
        if (nw.xr(this.ah)) {
            if (this.d.pc() || d()) {
                boolean z = !this.f2302ms;
                this.f2302ms = z;
                this.d.ms(z);
            }
        }
    }

    public void ms(boolean z, boolean z2) {
        this.d.i();
        ms(z);
        xr(z2);
    }

    public void ah() {
        this.d.op();
        this.ka.ms(this.xr.sa().tz());
    }

    public boolean d() {
        xr xrVar = this.d;
        if (xrVar != null) {
            return xrVar.cv();
        }
        return false;
    }

    public boolean ka() {
        if (nw.ah(this.ah)) {
            return this.d.p();
        }
        return false;
    }

    public void xr(boolean z) {
        this.d.c(z);
    }

    public void ms(int i, int i2) {
        this.d.xr(i, i2);
    }

    public void ms(lm lmVar) {
        this.ah = lmVar;
    }

    public boolean c() {
        return this.f2302ms;
    }
}
