package com.smartdigimkt.sdk.basead.ui.h5template;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.smartdigimkt.a2.a;
import com.smartdigimkt.a2.b;
import com.smartdigimkt.a2.c;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.j1.v;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebContainerView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.z.c0;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WTWebViewBaseScreenATView extends BaseScreenATView {
    public static final /* synthetic */ int C0 = 0;
    public WTWebContainerView B0;

    public WTWebViewBaseScreenATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void A() {
        c(9);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void E() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void K() {
        F();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void L() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void M() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void a(List list) {
        super.a(list);
        BasePlayerView basePlayerView = this.n.h;
        if (basePlayerView != null) {
            basePlayerView.setVisibility(4);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void c(int i) {
        O();
        WTWebContainerView wTWebContainerView = this.B0;
        if (wTWebContainerView != null) {
            wTWebContainerView.release();
        }
        super.c(i);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_h5_template_half_screen", "layout"), this);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final boolean g() {
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 100;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public CloseImageView getCloseView() {
        return null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public int getPanelViewTypeForShowEndCard() {
        return 108;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView, com.smartdigimkt.p3.d
    public int impressionMaterialType() {
        return c0.a(this.c, this.b);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void t() {
        CloseImageView closeImageView = this.l0;
        if (closeImageView != null) {
            closeImageView.setVisibility(0);
            this.l0.setAlpha(0.2f);
            this.l0.animate().alpha(1.0f).setDuration(1000L).start();
            this.l0.setOnClickListener(new c(this));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0098  */
    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void x() {
        g gVar;
        v vVar;
        super.x();
        WTWebContainerView wTWebContainerView = new WTWebContainerView(getContext(), this.c, this.b, new a(this));
        this.B0 = wTWebContainerView;
        d dVar = this.n;
        if (dVar != null) {
            dVar.m = wTWebContainerView;
            dVar.s = true;
            dVar.b();
        }
        Object aVar = null;
        try {
            com.smartdigimkt.b3.c cVar = this.c;
            if (cVar != null) {
                if (s.b.containsKey(s.c(cVar))) {
                    WTWebView wTWebView = (WTWebView) s.b.get(s.c(this.c));
                    if (wTWebView != null) {
                        aVar = wTWebView.getJsCommunicationObject();
                    }
                }
                if (aVar != null && (aVar instanceof com.smartdigimkt.m2.a)) {
                    ((com.smartdigimkt.m2.a) aVar).b = this.n;
                    ((com.smartdigimkt.m2.a) aVar).a = new b(this);
                }
                if (aVar == null && (aVar instanceof com.smartdigimkt.m2.a)) {
                    this.B0.init(aVar);
                    if (this.f0 != null) {
                        this.B0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        this.f0.addView(this.B0, 1);
                        return;
                    }
                    return;
                }
                gVar = new g(com.anythink.core.common.inner.b.b.k, "Adx template show fail without exception:empty jsCommunication");
                vVar = this.t0;
                if (vVar != null) {
                    vVar.a(gVar);
                }
                c(10);
            }
            HashMap map = s.a;
            aVar = new com.smartdigimkt.m2.a();
            if (aVar != null) {
                ((com.smartdigimkt.m2.a) aVar).b = this.n;
                ((com.smartdigimkt.m2.a) aVar).a = new b(this);
            }
        } catch (Throwable unused) {
        }
        if (aVar == null) {
        }
        gVar = new g(com.anythink.core.common.inner.b.b.k, "Adx template show fail without exception:empty jsCommunication");
        vVar = this.t0;
        if (vVar != null) {
            vVar.a(gVar);
        }
        c(10);
    }

    public WTWebViewBaseScreenATView(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str, int i, int i2) {
        super(context, aVar, cVar, str, i, i2);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i) {
        super.a(i);
        WTWebContainerView wTWebContainerView = this.B0;
        if (wTWebContainerView != null) {
            e0 e0Var = this.o;
            wTWebContainerView.notifyInnerAdEvent(i, e0Var != null ? e0Var.f : null);
        }
    }
}
