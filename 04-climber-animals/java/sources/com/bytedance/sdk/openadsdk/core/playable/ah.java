package com.bytedance.sdk.openadsdk.core.playable;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.op.ch;

/* JADX INFO: loaded from: classes2.dex */
class ah extends com.bytedance.sdk.openadsdk.core.video.xr.ms {
    private boolean pc;

    @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms
    protected int re() {
        return 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms
    protected boolean u_() {
        return false;
    }

    protected ah(Context context, ViewGroup viewGroup, lm lmVar, com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        super(context, viewGroup, lmVar, msVar);
        this.pc = true;
        ms(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms
    protected void c(boolean z) {
        super.c(z);
        if (this.pc) {
            if (!ch.ms(this.c) || ka()) {
                xr();
            }
        }
    }

    public void i() {
        xn();
    }

    public void ab(boolean z) {
        this.pc = z;
    }
}
