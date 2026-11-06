package com.bytedance.sdk.openadsdk.core.hi.ah.ah;

import com.bytedance.sdk.openadsdk.core.nw.nw;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private boolean ka = false;
    private int c = 0;
    private boolean ab = false;

    public void xr(boolean z) {
        this.ka = z;
    }

    public void ms(int i) {
        this.c = i;
    }

    public void ah(boolean z) {
        this.ab = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.ah.ah.ms
    protected boolean ah() {
        this.ah = 1;
        boolean z = c.d;
        int iSl = nw.sl(this.xr);
        if (z) {
            iSl = 0;
            c.d = false;
        }
        if (this.ab) {
            return d();
        }
        if (this.ka) {
            int i = this.c;
            if (i == 2) {
                return d();
            }
            if (iSl == 2 && i == 1) {
                return d();
            }
        }
        if (iSl == 0) {
            return d();
        }
        return true;
    }
}
