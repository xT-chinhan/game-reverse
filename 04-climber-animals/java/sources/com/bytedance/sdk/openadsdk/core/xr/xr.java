package com.bytedance.sdk.openadsdk.core.xr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ab;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.c;
import com.bytedance.sdk.openadsdk.core.xr.ms.xr.ny;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends d {
    protected final int ah;
    public int d;
    protected com.bytedance.sdk.openadsdk.core.xr.ms.ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final lm f3795ms;
    protected final String xr;

    protected boolean ms() {
        return false;
    }

    public xr(Context context, lm lmVar, String str, int i) {
        super(context);
        this.d = 1;
        this.f3795ms = lmVar;
        this.xr = str;
        this.ah = i;
        ka();
    }

    private void ka() {
        com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVarMs = this.x.ms(this.f3795ms, this.c, this, ms());
        this.ka = ahVarMs;
        ahVarMs.ms(this.ab);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(this.xr);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.xr);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ah);
        ((ny) ms(ny.class)).ms(this.xr);
        ((ny) ms(ny.class)).ms(this.ah);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah) ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ah.class)).ms(this.xr);
        ((c) ms(c.class)).ms(this.xr);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka) ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka.class)).ms(this.xr);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka) ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.ka.class)).ms(this.ah);
        if (ms()) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).d(true);
            ((ny) ms(ny.class)).ms(true);
            ((ab) ms(ab.class)).ms(this);
        }
    }

    public void ms(int i) {
        this.d = i;
        if (this.ab != null) {
            this.ab.ms(i);
        }
    }

    public void ms(hi hiVar) {
        this.ab = hiVar;
    }

    public hi xr() {
        return this.ab;
    }

    public void ms(View view) {
        this.ab.xr(view);
    }

    public void xr(View view) {
        this.ab.ms(view);
    }

    public void xr(int i) {
        this.ab.d(i);
    }

    public void ah(int i) {
        this.ab.ah(i);
    }

    public void d(int i) {
        this.ab.xr(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.d
    public void ms(View view, hi hiVar) {
        if (lm.ka(this.f3795ms)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ka());
        this.ka.ms(view);
        if (hiVar == null) {
            hiVar = new hi();
        }
        this.ka.ms(hiVar);
        this.ka.ms();
        lm.c(this.f3795ms);
    }
}
