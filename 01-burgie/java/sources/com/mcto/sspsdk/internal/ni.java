package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQySplash;
import com.mcto.sspsdk.QyAdSlot;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ni implements t5 {
    public final /* synthetic */ pi a;

    public ni(pi piVar) {
        this.a = piVar;
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void a() {
        this.a.n.removeCallbacksAndMessages(null);
        this.a.j.removeAllViews();
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void onWindowFocusChanged(boolean z) {
        if (z) {
            this.a.c.get();
            if (this.a.c.get() == 0) {
                this.a.c.set(1);
                this.a.c.get();
                this.a.n.sendEmptyMessage(1);
                return;
            }
            return;
        }
        this.a.c.get();
        if (this.a.c.get() == 1) {
            this.a.c.set(0);
            this.a.c.get();
            this.a.n.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.mcto.sspsdk.internal.t5
    public final void a(d8 d8Var) {
        this.a.b.set(true);
        if (this.a.c.get() == 0) {
            this.a.c.set(1);
            this.a.n.sendEmptyMessage(1);
        }
        HashMap map = new HashMap(1);
        map.put(v5.KEY_VIEW_COORDINATE, d8Var.d);
        map.put(v5.KEY_AD_VIEW_RECT, d8Var.e + "_" + d8Var.f);
        map.put(v5.KEY_TOKEN_VIEW_COORDINATE, gj.a(this.a.j));
        map.put(v5.KEY_IMPRESSION_INTERVAL_TIME, Long.valueOf(System.currentTimeMillis() - d8Var.g));
        l lVarA = l.a();
        p pVar = this.a.e;
        lVarA.getClass();
        l.a(12, pVar, map);
        nh.a(jd.a).a("iad_spa", "csalio", String.valueOf(this.a.e.w));
        IQySplash.IAdInteractionListener iAdInteractionListener = this.a.k;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdShow();
        }
        QyAdSlot qyAdSlot = this.a.f;
        if (qyAdSlot == null || !qyAdSlot.isSupportPreRequest()) {
            return;
        }
        fi.a(this.a.f, 0);
    }
}
