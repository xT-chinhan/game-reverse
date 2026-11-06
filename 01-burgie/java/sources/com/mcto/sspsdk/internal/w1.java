package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQyBanner;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 implements t5 {
    public final /* synthetic */ y2 a;
    public final /* synthetic */ z1 b;

    public w1(z1 z1Var, y2 y2Var) {
        this.b = z1Var;
        this.a = y2Var;
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void a() {
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void onWindowFocusChanged(boolean z) {
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void a(d8 d8Var) {
        if (this.b.a.m()) {
            return;
        }
        HashMap map = new HashMap(4);
        map.put(v5.KEY_VIEW_COORDINATE, d8Var.d);
        map.put(v5.KEY_TOKEN_VIEW_COORDINATE, gj.a(this.a));
        map.put(v5.KEY_AD_VIEW_RECT, d8Var.e + "_" + d8Var.f);
        map.put(v5.KEY_IMPRESSION_INTERVAL_TIME, Long.valueOf(System.currentTimeMillis() - d8Var.g));
        l lVarA = l.a();
        p pVar = this.b.a;
        lVarA.getClass();
        l.a(12, pVar, map);
        this.b.b.postDelayed(new v1(this), 2000L);
        IQyBanner.IAdInteractionListener iAdInteractionListener = this.b.c;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdShow();
        }
    }
}
