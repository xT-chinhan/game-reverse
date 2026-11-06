package com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends com.bytedance.sdk.openadsdk.core.component.reward.ah.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f2122ms;

    public void ms(String str) {
        this.f2122ms = str;
    }

    public ms(Activity activity, lm lmVar) {
        super(activity, lmVar);
    }

    public ms(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(ch chVar) {
        d dVar = new d(this.x, this.ab);
        dVar.d(this.hi);
        dVar.ah(this.sl);
        dVar.xr(this.ub);
        dVar.ms(this.f2122ms);
        return dVar.ms(chVar);
    }
}
