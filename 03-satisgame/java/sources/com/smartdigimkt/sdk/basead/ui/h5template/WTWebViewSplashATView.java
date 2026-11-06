package com.smartdigimkt.sdk.basead.ui.h5template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.inner.b.b;
import com.smartdigimkt.a2.e;
import com.smartdigimkt.a2.f;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n2.a;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebContainerView;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.z.c0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class WTWebViewSplashATView extends BaseSdkSplashATView {
    public static final /* synthetic */ int o0 = 0;
    public WTWebContainerView m0;
    public CloseImageView n0;

    public WTWebViewSplashATView(Context context) {
        super(context);
    }

    public final /* synthetic */ void a(View view) {
        a(9, true);
    }

    public final void b(g gVar) {
        gVar.a();
        CloseImageView closeImageView = this.n0;
        if (closeImageView != null) {
            closeImageView.setVisibility(0);
            this.n0.setAlpha(0.2f);
            this.n0.animate().alpha(1.0f).setDuration(300L).start();
        }
        a(new g(b.k, b.af + gVar.a()));
        a(10, true);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        WTWebContainerView wTWebContainerView = this.m0;
        if (wTWebContainerView != null) {
            wTWebContainerView.release();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_h5_template_splash", "layout"), this);
        r();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 100;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, com.smartdigimkt.p3.d
    public int impressionMaterialType() {
        return c0.a(this.c, this.b);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public boolean needShowSplashEndCard() {
        return false;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void r() {
        super.r();
        setDontCountDown(true);
        v();
        WTWebContainerView wTWebContainerView = new WTWebContainerView(getContext(), this.c, this.b, new e(this));
        this.m0 = wTWebContainerView;
        d dVar = this.n;
        if (dVar != null) {
            dVar.m = wTWebContainerView;
        }
        Object aVar = null;
        try {
            c cVar = this.c;
            if (cVar != null) {
                if (s.b.containsKey(s.c(cVar))) {
                    WTWebView wTWebView = (WTWebView) s.b.get(s.c(this.c));
                    if (wTWebView != null) {
                        aVar = wTWebView.getJsCommunicationObject();
                    }
                }
                if (aVar != null && (aVar instanceof a)) {
                    ((a) aVar).b = this.n;
                    ((a) aVar).a = new f(this);
                }
                if (aVar != null || !(aVar instanceof a)) {
                    b(new g(b.k, "empty jsCommunication"));
                }
                this.m0.init(aVar);
                this.m0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.m0, 1);
                return;
            }
            HashMap map = s.a;
            aVar = new a();
            if (aVar != null) {
                ((a) aVar).b = this.n;
                ((a) aVar).a = new f(this);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        if (aVar != null) {
        }
        b(new g(b.k, "empty jsCommunication"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void s() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void setDontCountDown(boolean z) {
        super.setDontCountDown(true);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void t() {
    }

    public final void v() {
        CloseImageView closeImageView = (CloseImageView) findViewById(k.a(getContext(), "myoffer_btn_close_id", "id"));
        this.n0 = closeImageView;
        if (closeImageView == null) {
            return;
        }
        closeImageView.setVisibility(8);
        this.n0.setOnClickListener(new View.OnClickListener() { // from class: com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    public WTWebViewSplashATView(Context context, com.smartdigimkt.a3.a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i) {
        super.a(i);
        WTWebContainerView wTWebContainerView = this.m0;
        if (wTWebContainerView != null) {
            e0 e0Var = this.o;
            wTWebContainerView.notifyInnerAdEvent(i, e0Var != null ? e0Var.f : null);
        }
    }
}
