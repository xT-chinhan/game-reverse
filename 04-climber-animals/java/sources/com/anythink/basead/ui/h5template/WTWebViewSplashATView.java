package com.anythink.basead.ui.h5template;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.anythink.basead.b.c.d;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.g.a;
import com.anythink.basead.ui.BaseSdkSplashATView;
import com.anythink.basead.webtemplet.WTWebContainerView;
import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class WTWebViewSplashATView extends BaseSdkSplashATView {
    WTWebContainerView a;
    final int b;
    private final String c;

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void b() {
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void d() {
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    public boolean needShowSplashEndCard() {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    protected final int r() {
        return 100;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final boolean t() {
        return false;
    }

    public WTWebViewSplashATView(Context context) {
        super(context);
        this.c = "WTWebViewBaseScreenATView";
        this.b = 1;
    }

    public WTWebViewSplashATView(Context context, x xVar, w wVar, a aVar) {
        super(context, xVar, wVar, aVar);
        this.c = "WTWebViewBaseScreenATView";
        this.b = 1;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_h5_template_splash", "layout"), this);
        w();
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    protected final void w() {
        super.w();
        this.a = new WTWebContainerView(getContext(), this.g, this.f, new WTWebContainerView.a() { // from class: com.anythink.basead.ui.h5template.WTWebViewSplashATView.1
            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void a() {
            }

            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void b() {
                WTWebViewSplashATView.this.a(302);
                WTWebViewSplashATView wTWebViewSplashATView = WTWebViewSplashATView.this;
                WTWebViewSplashATView.super.a(wTWebViewSplashATView.f.o.Z() < 0 ? 100 : WTWebViewSplashATView.this.f.o.Z(), new Runnable() { // from class: com.anythink.basead.ui.h5template.WTWebViewSplashATView.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (WTWebViewSplashATView.this.O == null) {
                            return;
                        }
                        WTWebViewSplashATView.this.j();
                    }
                });
            }

            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void a(f fVar) {
                WTWebViewSplashATView.this.a(g.a(g.k, g.af + fVar.c()));
                WTWebViewSplashATView.this.a(true, 10);
            }
        });
        if (this.r != null) {
            this.r.a(this.a);
        }
        Object aVar = null;
        try {
            if (d.a(this.g)) {
                WTWebView wTWebViewD = d.d(d.a((x) null, this.g, 3));
                if (wTWebViewD != null) {
                    aVar = wTWebViewD.getJsCommunicationObject();
                }
            } else {
                aVar = new com.anythink.basead.webtemplet.adformat.splash.a();
            }
            if (aVar != null && (aVar instanceof com.anythink.basead.webtemplet.adformat.splash.a)) {
                ((com.anythink.basead.webtemplet.adformat.splash.a) aVar).a(this.r);
                ((com.anythink.basead.webtemplet.adformat.splash.a) aVar).a(new com.anythink.basead.webtemplet.adformat.a() { // from class: com.anythink.basead.ui.h5template.WTWebViewSplashATView.2
                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(int i, int i2) {
                        WTWebViewSplashATView.this.a(i, i2);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(int i) {
                        WTWebViewSplashATView.this.a(true, i);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(String str, String str2) {
                        WTWebViewSplashATView.this.a(g.a(g.k, g.af + str + "," + str2));
                        WTWebViewSplashATView.this.a(true, 10);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a() {
                        WTWebViewSplashATView.this.A();
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void b(int i) {
                        if (i == 1) {
                            WTWebViewSplashATView.this.a(303);
                        } else {
                            WTWebViewSplashATView.this.a(304);
                        }
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void b() {
                        WTWebViewSplashATView.this.r.c(0);
                        WTWebViewSplashATView.this.z();
                    }
                });
            }
        } catch (Throwable unused) {
        }
        if (aVar == null || !(aVar instanceof com.anythink.basead.webtemplet.adformat.splash.a)) {
            a(g.a(g.k, "Adx template show fail without exception:empty jsCommunication"));
            a(true, 10);
        } else {
            this.a.init(aVar);
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.a, 1);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView, com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    protected final void a(int i) {
        super.a(i);
        if (this.a != null) {
            this.a.notifyInnerAdEvent(i, this.s != null ? this.s.b() : null);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        WTWebContainerView wTWebContainerView = this.a;
        if (wTWebContainerView != null) {
            wTWebContainerView.release();
        }
    }
}
