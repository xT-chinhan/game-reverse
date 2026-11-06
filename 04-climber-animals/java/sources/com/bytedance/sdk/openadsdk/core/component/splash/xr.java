package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
abstract class xr {
    protected lm ah;
    protected ab.ms d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f2438ms;
    protected ViewGroup xr;

    public abstract String ms();

    public abstract void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar);

    public void ms(boolean z) {
    }

    xr() {
    }

    public void ms(Context context, ViewGroup viewGroup, lm lmVar) {
        this.f2438ms = context;
        this.xr = viewGroup;
        this.ah = lmVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, ab.ms msVar) {
        com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ah, "splash_ad", ms());
        this.xr.setVisibility(0);
        this.d = msVar;
    }

    public void xr() {
        ab.ms msVar = this.d;
        if (msVar != null) {
            msVar.xr();
        }
    }
}
