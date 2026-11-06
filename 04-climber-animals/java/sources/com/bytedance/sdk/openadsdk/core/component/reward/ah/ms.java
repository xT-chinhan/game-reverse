package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.nw.gy;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends xr {
    protected boolean ah;
    protected boolean c;
    protected boolean d;
    protected boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected int f2097ms;
    protected int xr;

    public ms(Activity activity, lm lmVar) {
        super(activity, lmVar);
    }

    public ms(Activity activity, lm lmVar, gy gyVar) {
        super(activity, lmVar, gyVar);
    }

    public void ms(int i) {
        this.f2097ms = i;
    }

    public void xr(int i) {
        this.xr = i;
    }

    public void ms(boolean z) {
        this.ah = z;
    }

    public void xr(boolean z) {
        this.d = z;
    }

    public void ah(boolean z) {
        this.c = z;
    }

    public void d(boolean z) {
        this.ka = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(ch chVar) {
        zb zbVar = new zb(this.x, this.ab);
        zbVar.xr(this.d);
        zbVar.ms(this.ah);
        zbVar.ms(this.f2097ms);
        zbVar.xr(this.xr);
        zbVar.d(this.hi);
        zbVar.ah(this.sl);
        zbVar.ms(this.ao);
        zbVar.xr(this.ub);
        zbVar.ah(this.c);
        zbVar.d(this.ka);
        return zbVar.xr(chVar);
    }
}
