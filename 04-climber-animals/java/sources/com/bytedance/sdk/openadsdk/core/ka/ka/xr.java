package com.bytedance.sdk.openadsdk.core.ka.ka;

import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.x;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    protected com.bytedance.sdk.openadsdk.core.ka.ah.ms ah = xr();
    protected com.bytedance.sdk.openadsdk.core.ka.ms.xr d = ah();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected x.ms f2806ms;
    protected int xr;

    public xr(int i) {
        this.xr = i;
        this.f2806ms = ms(i);
    }

    public static x.ms ms(int i) {
        if (i == 7) {
            return x.ms();
        }
        if (i != 8) {
            return null;
        }
        return x.xr();
    }

    private com.bytedance.sdk.openadsdk.core.ka.ah.ms xr() {
        int iD = d();
        if (iD == -1) {
            return new com.bytedance.sdk.openadsdk.core.ka.ah.ah(this.xr);
        }
        if (iD == 0) {
            return new com.bytedance.sdk.openadsdk.core.ka.ah.xr(this.xr);
        }
        if (iD == 1) {
            return new com.bytedance.sdk.openadsdk.core.ka.ah.ka(this.xr);
        }
        if (iD == 3) {
            return new com.bytedance.sdk.openadsdk.core.ka.ah.d(this.xr);
        }
        return ms.xr(this.xr);
    }

    private com.bytedance.sdk.openadsdk.core.ka.ms.xr ah() {
        int i = this.xr;
        if (i == 7) {
            return new com.bytedance.sdk.openadsdk.core.ka.ms.ah(this);
        }
        if (i != 8) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.ka.ms.ms(this);
    }

    protected boolean ms(lm lmVar) {
        return com.bytedance.sdk.openadsdk.core.live.xr.ms().ah(lmVar) != 3;
    }

    private int d() {
        x.ms msVar = this.f2806ms;
        if (msVar == null) {
            return -2;
        }
        if (msVar.ab() && re.xr().ci()) {
            return this.f2806ms.d();
        }
        return -1;
    }

    public com.bytedance.sdk.openadsdk.core.ka.ah.ms ms() {
        return this.ah;
    }
}
