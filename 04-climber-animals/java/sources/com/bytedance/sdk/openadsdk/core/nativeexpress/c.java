package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.bytedance.sdk.openadsdk.core.xr.xr {
    private com.bytedance.sdk.openadsdk.core.nw.i ch;
    private boolean hi;
    protected int sl;
    protected int u;
    protected int zb;

    public c(Context context, lm lmVar, String str, int i) {
        super(context, lmVar, str, i);
        this.sl = 0;
        this.zb = -1;
        this.u = -1;
        this.hi = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
    public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
        com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms msVar = (com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class);
        msVar.ms(ms(msVar.ah()));
        super.ms(view, hiVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void ka(int i) {
        this.sl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void ah() {
        this.zb = 1;
        this.hi = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void d() {
        this.u = 1;
        this.hi = false;
    }

    private com.bytedance.sdk.openadsdk.core.nw.ch ms(String str) {
        int i;
        int i2;
        int iAh;
        int iAh2;
        View viewAb = this.ab.ab();
        int[] iArrMs = ul.ms(viewAb);
        if (iArrMs == null || iArrMs.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = iArrMs[0];
            i2 = iArrMs[1];
            if (this.sl == 0 && this.hi) {
                this.ab.ms((ul.ah(this.c, this.ab.u()) + i) - 0.5f);
                this.ab.xr((ul.ah(this.c, this.ab.ub()) + i2) - 0.5f);
                this.ab.ah((ul.ah(this.c, this.ab.ao()) + i) - 0.5f);
                this.ab.d((ul.ah(this.c, this.ab.h()) + i2) - 0.5f);
            }
        }
        float fC = ul.c(this.c);
        int iX = ul.x(this.c);
        float fAb = ul.ab(this.c);
        int[] iArrMs2 = {-1, -1};
        int[] iArrAh = {-1, -1};
        if (this.ch != null && this.hi) {
            this.ab.ms(this.ch.ka);
            this.ab.xr(this.ch.c);
            if (this.sl == 0) {
                iArrMs2[0] = ul.ah(this.c, this.ch.ab) + i;
                iArrMs2[1] = ul.ah(this.c, this.ch.x) + i2;
                iAh = ul.ah(this.c, this.ch.ny);
                iAh2 = ul.ah(this.c, this.ch.ch);
            } else {
                iArrMs2[0] = this.ch.ab;
                iArrMs2[1] = this.ch.x;
                iAh = this.ch.ny;
                iAh2 = this.ch.ch;
            }
            iArrAh[0] = iAh;
            iArrAh[1] = iAh2;
            View viewC = this.ab.c();
            if (iAh == 0 && iAh2 == 0 && viewC != null) {
                iArrMs2 = ul.ms(viewC);
                iArrAh = ul.ah(viewC);
            }
        }
        this.sl = 0;
        return new com.bytedance.sdk.openadsdk.core.nw.ch.ms().c(this.ab.u()).ka(this.ab.ub()).d(this.ab.ao()).ah(this.ab.h()).xr(this.ab.sl()).ms(this.ab.zb()).xr(iArrMs).ms(iArrMs2).ah(ul.ah(viewAb)).d(iArrAh).ah(this.ab.xr()).d(this.ab.ah()).ka(this.ab.d()).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(this.ab.ch()).ms(str).ms(fC).ms(iX).c(this.zb).ab(this.u).xr(fAb).ms();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void ms(com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        this.ch = iVar;
    }
}
