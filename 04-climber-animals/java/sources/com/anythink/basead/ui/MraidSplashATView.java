package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.basead.d.g;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class MraidSplashATView extends BaseSplashATView {
    MraidContainerView a;
    boolean b;

    public MraidSplashATView(Context context) {
        super(context);
    }

    public MraidSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_web_splash_ad_layout", "layout"), this);
        if (this.T != null) {
            this.T.a(d.c).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.MraidSplashATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    MraidSplashATView.this.a(i, i2);
                }
            }).a(getContext(), this);
        }
        if (this.z != null) {
            a((View) this);
            this.z.a(findViewById(q.a(getContext(), "myoffer_splash_skip_area", "id")));
        }
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.g, this.f, this.z, new AnonymousClass2());
        this.a = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.a);
        }
    }

    private void b() {
        if (this.z != null) {
            a((View) this);
            this.z.a(findViewById(q.a(getContext(), "myoffer_splash_skip_area", "id")));
        }
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.g, this.f, this.z, new AnonymousClass2());
        this.a = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.a);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidSplashATView$2, reason: invalid class name */
    final class AnonymousClass2 implements MraidContainerView.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidSplashATView.this.g.w(str);
            MraidSplashATView.this.a(1, 13);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                MraidSplashATView.a(MraidSplashATView.this);
            } catch (Throwable unused) {
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
            MraidSplashATView.this.a(106);
            MraidSplashATView.this.x();
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
            MraidSplashATView.this.a(g.a(g.k, g.V));
            MraidSplashATView.this.a(true, 5);
        }
    }

    private void c() {
        if (this.g.n() && this.a == null) {
            return;
        }
        super.a(this.f.o.Z() < 0 ? 100 : this.f.o.Z(), new AnonymousClass3());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidSplashATView$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MraidSplashATView.this.O == null) {
                return;
            }
            MraidSplashATView.super.j();
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    protected final void x() {
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            View view = this.n.get(i);
            if (view != null) {
                view.setOnClickListener(this.S);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.a;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.a;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    static /* synthetic */ void a(MraidSplashATView mraidSplashATView) {
        if (mraidSplashATView.g.n() && mraidSplashATView.a == null) {
            return;
        }
        super.a(mraidSplashATView.f.o.Z() < 0 ? 100 : mraidSplashATView.f.o.Z(), mraidSplashATView.new AnonymousClass3());
    }
}
