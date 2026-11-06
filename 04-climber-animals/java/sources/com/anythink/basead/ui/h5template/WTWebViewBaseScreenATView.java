package com.anythink.basead.ui.h5template;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.basead.b.c.d;
import com.anythink.basead.b.e;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.ui.BaseScreenATView;
import com.anythink.basead.ui.CloseImageView;
import com.anythink.basead.webtemplet.WTWebContainerView;
import com.anythink.basead.webtemplet.WTWebView;
import com.anythink.basead.webtemplet.adformat.intestitial.a;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WTWebViewBaseScreenATView extends BaseScreenATView {
    WTWebContainerView ah;
    final int ai;
    private final String aj;

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void Q() {
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void U() {
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final CloseImageView X() {
        return null;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void ac() {
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final boolean b(int i) {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final int r() {
        return 100;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final boolean t() {
        return false;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final int y() {
        return 8;
    }

    public WTWebViewBaseScreenATView(Context context) {
        super(context);
        this.aj = "WTWebViewBaseScreenATView";
        this.ai = 1;
    }

    public WTWebViewBaseScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        this.aj = "WTWebViewBaseScreenATView";
        this.ai = 1;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_h5_template_half_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void b() {
        super.b();
        this.ah = new WTWebContainerView(getContext(), this.g, this.f, new WTWebContainerView.a() { // from class: com.anythink.basead.ui.h5template.WTWebViewBaseScreenATView.1
            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void a() {
            }

            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void b() {
                if (WTWebViewBaseScreenATView.this.Q != null) {
                    WTWebViewBaseScreenATView.this.Q.setVisibility(8);
                }
                WTWebViewBaseScreenATView.this.a(302);
                if (3 != WTWebViewBaseScreenATView.this.a || e.a(WTWebViewBaseScreenATView.this.g, WTWebViewBaseScreenATView.this.f)) {
                    return;
                }
                WTWebViewBaseScreenATView.this.ae();
            }

            @Override // com.anythink.basead.webtemplet.WTWebContainerView.a
            public final void a(f fVar) {
                WTWebViewBaseScreenATView.this.a(g.a(g.k, g.af + fVar.c()));
                WTWebViewBaseScreenATView.this.c(10);
            }
        });
        if (this.r != null) {
            this.r.a(this.ah);
            this.r.b(true);
        }
        Object aVar = null;
        try {
            if (d.a(this.g)) {
                WTWebView wTWebViewD = d.d(d.a((x) null, this.g, 3));
                if (wTWebViewD != null) {
                    aVar = wTWebViewD.getJsCommunicationObject();
                }
            } else {
                aVar = new a();
            }
            if (aVar != null && (aVar instanceof a)) {
                ((a) aVar).a(this.r);
                ((a) aVar).a(new com.anythink.basead.webtemplet.adformat.d() { // from class: com.anythink.basead.ui.h5template.WTWebViewBaseScreenATView.2
                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(int i, int i2) {
                        WTWebViewBaseScreenATView.this.a(i, i2);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(int i) {
                        WTWebViewBaseScreenATView.this.c(i);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a(String str, String str2) {
                        WTWebViewBaseScreenATView.this.a(g.a(g.k, g.af + str + "," + str2));
                        WTWebViewBaseScreenATView.this.c(10);
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void a() {
                        WTWebViewBaseScreenATView.this.z();
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void b(int i) {
                        if (i == 1) {
                            WTWebViewBaseScreenATView.this.a(303);
                        } else {
                            WTWebViewBaseScreenATView.this.a(304);
                        }
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.a
                    public final void b() {
                        WTWebViewBaseScreenATView.this.r.c(0);
                        WTWebViewBaseScreenATView.this.C();
                    }

                    @Override // com.anythink.basead.webtemplet.adformat.d
                    public final void c() {
                        WTWebViewBaseScreenATView.this.ad();
                    }
                });
            }
        } catch (Throwable unused) {
        }
        if (aVar == null || !(aVar instanceof a)) {
            a(g.a(g.k, "Adx template show fail without exception:empty jsCommunication"));
            c(10);
            return;
        }
        this.ah.init(aVar);
        if (this.M != null) {
            this.ah.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.M.addView(this.ah, 1);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void a(List<Bitmap> list) {
        super.a(list);
        this.r.c(4);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void x() {
        ab();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void L() {
        if (this.Q != null) {
            this.Q.setVisibility(0);
            this.Q.setAlpha(0.2f);
            this.Q.animate().alpha(1.0f).setDuration(1000L).start();
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.h5template.WTWebViewBaseScreenATView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WTWebViewBaseScreenATView.this.M();
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void c(int i) {
        super.N();
        WTWebContainerView wTWebContainerView = this.ah;
        if (wTWebContainerView != null) {
            wTWebContainerView.release();
        }
        super.c(i);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void M() {
        c(9);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(int i) {
        super.a(i);
        if (this.ah != null) {
            this.ah.notifyInnerAdEvent(i, this.s != null ? this.s.b() : null);
        }
    }
}
