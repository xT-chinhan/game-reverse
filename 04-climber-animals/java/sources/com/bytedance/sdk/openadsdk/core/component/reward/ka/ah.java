package com.bytedance.sdk.openadsdk.core.component.reward.ka;

import com.bytedance.sdk.openadsdk.core.component.reward.xr.c;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private int ah;
    private final c d;
    private final com.bytedance.sdk.openadsdk.core.component.reward.d.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f2189ms;
    private int xr;

    public ah(boolean z, lm lmVar, c cVar, com.bytedance.sdk.openadsdk.core.component.reward.d.ms msVar) {
        int iC;
        this.d = cVar;
        this.ka = msVar;
        if (z) {
            iC = re.xr().ka(f.ny(lmVar));
        } else {
            iC = re.xr().c(f.ny(lmVar));
        }
        this.f2189ms = iC;
    }

    public long ms() {
        return this.d.g();
    }

    public void xr() {
        this.xr++;
    }

    public int ah() {
        return this.xr;
    }

    public int d() {
        return this.ah;
    }

    public void ms(int i) {
        this.ah += i;
    }

    public int ka() {
        return this.f2189ms;
    }

    public int c() {
        return this.ka.f();
    }
}
