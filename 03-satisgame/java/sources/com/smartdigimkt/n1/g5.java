package com.smartdigimkt.n1;

import android.view.View;
import android.widget.ImageView;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;

/* JADX INFO: loaded from: classes3.dex */
public final class g5 implements com.smartdigimkt.q1.k {
    public final /* synthetic */ com.smartdigimkt.a3.a a;
    public final /* synthetic */ com.smartdigimkt.b3.c b;
    public final /* synthetic */ SimplePlayerMediaView c;

    public g5(SimplePlayerMediaView simplePlayerMediaView, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar) {
        this.c = simplePlayerMediaView;
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.smartdigimkt.q1.k
    public final void a() {
        com.smartdigimkt.b3.e eVar;
        WebProgressBarView webProgressBarView;
        SimplePlayerMediaView simplePlayerMediaView = this.c;
        if (simplePlayerMediaView.e > 0 && (webProgressBarView = simplePlayerMediaView.c) != null) {
            if (webProgressBarView.getVisibility() != 0) {
                this.c.c.setVisibility(0);
            }
            this.c.c.setProgress(100);
        }
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.c.f;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdComplete();
        }
        ImageView imageView = this.c.j;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        com.smartdigimkt.a3.a aVar = this.a;
        if (aVar == null || (eVar = aVar.s) == null || eVar.e != 0) {
            return;
        }
        SimplePlayerMediaView simplePlayerMediaView2 = this.c;
        String str = simplePlayerMediaView2.a;
        com.smartdigimkt.u1.d dVar = simplePlayerMediaView2.b;
        BasePlayerView basePlayerView = dVar == null ? null : dVar.h;
        if (basePlayerView != null) {
            basePlayerView.setClickable(false);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b(long j) {
        com.smartdigimkt.u1.d dVar;
        WebProgressBarView webProgressBarView;
        SimplePlayerMediaView simplePlayerMediaView = this.c;
        if (simplePlayerMediaView.e > 0 && (webProgressBarView = simplePlayerMediaView.c) != null) {
            if (webProgressBarView.getVisibility() != 0) {
                this.c.c.setVisibility(0);
            }
            SimplePlayerMediaView simplePlayerMediaView2 = this.c;
            simplePlayerMediaView2.c.setProgress((int) ((j * 100.0d) / simplePlayerMediaView2.e));
        }
        SimplePlayerMediaView simplePlayerMediaView3 = this.c;
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = simplePlayerMediaView3.f;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onProgressUpdate(j, simplePlayerMediaView3.e);
        }
        ImageView imageView = this.c.j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.c.m;
        if (view != null) {
            view.setVisibility(8);
        }
        SimplePlayerMediaView simplePlayerMediaView4 = this.c;
        if (simplePlayerMediaView4.o || (dVar = simplePlayerMediaView4.b) == null || simplePlayerMediaView4.h.a(simplePlayerMediaView4, dVar.h, 50, 0)) {
            return;
        }
        this.c.b.b(2);
        this.c.b();
    }

    @Override // com.smartdigimkt.q1.k
    public final void c() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void d() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void e() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void f() {
        ImageView imageView = this.c.k;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.c.l;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        com.smartdigimkt.u1.d dVar = this.c.b;
        BasePlayerView basePlayerView = dVar == null ? null : dVar.h;
        if (basePlayerView != null) {
            basePlayerView.setClickable(true);
        }
        SimplePlayerMediaView simplePlayerMediaView = this.c;
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = simplePlayerMediaView.f;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoAdStartPlay(simplePlayerMediaView.e);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void g() {
        View.OnClickListener onClickListener;
        com.smartdigimkt.u1.d dVar;
        BasePlayerView basePlayerView;
        BasePlayerView basePlayerView2;
        SimplePlayerMediaView simplePlayerMediaView = this.c;
        if ((simplePlayerMediaView.u || this.a.s.e == 0) && (onClickListener = simplePlayerMediaView.n) != null) {
            onClickListener.onClick(simplePlayerMediaView);
            return;
        }
        if (!String.valueOf(this.a.c).equals("0") || (dVar = this.c.b) == null) {
            return;
        }
        BasePlayerView basePlayerView3 = dVar.h;
        if ((basePlayerView3 == null || !basePlayerView3.isPlayCompletion()) && (basePlayerView = this.c.b.h) != null && basePlayerView.isPlaying()) {
            SimplePlayerMediaView simplePlayerMediaView2 = this.c;
            simplePlayerMediaView2.o = true;
            com.smartdigimkt.u1.d dVar2 = simplePlayerMediaView2.b;
            if (dVar2 != null && (basePlayerView2 = dVar2.h) != null && basePlayerView2.isPlaying()) {
                simplePlayerMediaView2.b.b(1);
            }
            ImageView imageView = simplePlayerMediaView2.i;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(com.smartdigimkt.h0.g gVar) {
        SDMNativeAdMediaViewListener sDMNativeAdMediaViewListener = this.c.f;
        if (sDMNativeAdMediaViewListener != null) {
            sDMNativeAdMediaViewListener.onVideoError(gVar.a, gVar.b);
        }
        this.c.o = true;
        com.smartdigimkt.n3.k.a(this.a, this.b, 2, gVar.a());
        if (this.c.b.a() > 0) {
            SimplePlayerMediaView simplePlayerMediaView = this.c;
            if (simplePlayerMediaView.j != null) {
                WebProgressBarView webProgressBarView = simplePlayerMediaView.c;
                if (webProgressBarView != null) {
                    webProgressBarView.setVisibility(8);
                }
                this.c.j.setVisibility(0);
                return;
            }
        }
        View view = this.c.m;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(long j) {
        WebProgressBarView webProgressBarView;
        SimplePlayerMediaView simplePlayerMediaView = this.c;
        simplePlayerMediaView.e = j;
        if (j <= 0 || (webProgressBarView = simplePlayerMediaView.c) == null) {
            return;
        }
        webProgressBarView.setVisibility(0);
    }
}
