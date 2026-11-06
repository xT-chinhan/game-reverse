package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.component.reward.c.xr {
    private boolean pc;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.xr, com.bytedance.sdk.openadsdk.core.video.xr.ms
    protected int re() {
        return 4;
    }

    public d(Context context, ViewGroup viewGroup, lm lmVar) {
        super(context, viewGroup, lmVar, null);
        ms(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms
    protected void c(boolean z) {
        super.c(z);
        xr();
    }

    public boolean i() {
        return h() != null && h().u();
    }

    public boolean w() {
        return this.pc;
    }

    public void ab(boolean z) {
        this.pc = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.c.xr, com.bytedance.sdk.openadsdk.core.video.xr.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public void x() {
        if (this.pc) {
            return;
        }
        super.x();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public void ch() {
        this.pc = false;
        super.ch();
    }
}
