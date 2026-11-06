package com.mcto.sspsdk.internal;

import android.view.ViewGroup;
import com.mcto.sspsdk.IQyNativeAd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 extends p7 {
    public final /* synthetic */ n3 a;

    public l3(n3 n3Var) {
        this.a = n3Var;
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(int i, int i2) {
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoError(n3Var, i, i2);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void b() {
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoLoad(n3Var);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void c() {
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoAdContinuePlay(n3Var);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar) {
        l.a().getClass();
        l.a(18, pVar, null);
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoAdComplete(n3Var);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void b(p pVar) {
        this.a.i |= 2;
        this.a.a();
        HashMap map = new HashMap(2);
        ViewGroup viewGroup = this.a.h;
        if (viewGroup != null) {
            map.put(v5.KEY_VIEW_COORDINATE, gj.a(viewGroup));
            map.put(v5.KEY_AD_VIEW_RECT, this.a.h.getWidth() + "_" + this.a.h.getHeight());
        }
        l.a().getClass();
        l.a(13, pVar, map);
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoAdStartPlay(n3Var);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void c(p pVar) {
        l.a().getClass();
        l.a(17, pVar, null);
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a() {
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onVideoAdPaused(n3Var);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(p pVar, long j, long j2) {
        l.a().getClass();
        l.b((int) j2, pVar);
        n3 n3Var = this.a;
        IQyNativeAd.IQyVideoAdListener iQyVideoAdListener = n3Var.q;
        if (iQyVideoAdListener != null) {
            iQyVideoAdListener.onProgressUpdate(n3Var, j, j2);
        }
    }

    @Override // com.mcto.sspsdk.internal.p7
    public final void a(float f) {
    }
}
