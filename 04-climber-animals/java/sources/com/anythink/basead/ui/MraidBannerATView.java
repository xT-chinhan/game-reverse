package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class MraidBannerATView extends BaseBannerATView {
    MraidContainerView A;
    boolean B;
    boolean C;
    boolean D;

    public MraidBannerATView(Context context) {
        super(context);
    }

    public MraidBannerATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
        c();
    }

    protected final synchronized void d() {
        if (this.B && this.C && !this.D) {
            this.D = true;
            e.a(this.f, this.g);
        }
    }

    private void w() {
        String strB = this.f.o.B();
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        int iA = q.a(getContext(), 50.0f);
        int iA2 = q.a(getContext(), 320.0f);
        strB.hashCode();
        switch (strB) {
            case "300x250":
                iA2 = q.a(getContext(), 300.0f);
                iA = q.a(getContext(), 250.0f);
                break;
            case "320x90":
                iA2 = q.a(getContext(), 320.0f);
                iA = q.a(getContext(), 90.0f);
                break;
            case "728x90":
                iA2 = q.a(getContext(), 720.0f);
                iA = q.a(getContext(), 90.0f);
                break;
        }
        int iMin = Math.min(iA2, getResources().getDisplayMetrics().widthPixels);
        if (this.z != null) {
            a(findViewById(q.a(getContext(), "myoffer_banner_root", "id")));
            this.z.a(this.b);
        }
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.g, this.f, this.z, new AnonymousClass1());
        this.A = mraidContainerView;
        mraidContainerView.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_web", "id"));
        this.A.setMinimumHeight(q.a(getContext(), 50.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iA);
        layoutParams.gravity = 17;
        frameLayout.addView(this.A, 0, layoutParams);
        setLayoutParams(new ViewGroup.LayoutParams(iMin, iA));
        if (this.f.o.C() == 0) {
            this.b.setVisibility(0);
            a((b) this.b, false);
        } else {
            this.b.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.MraidBannerATView$1, reason: invalid class name */
    final class AnonymousClass1 implements MraidContainerView.a {
        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
        }

        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidBannerATView.this.g.w(str);
            MraidBannerATView.this.a(1, 13);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            MraidBannerATView.this.B = true;
            MraidBannerATView.this.d();
            try {
                MraidBannerATView.this.b();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseBannerATView, com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.C = true;
        d();
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.C = false;
    }

    @Override // com.anythink.basead.ui.BaseBannerATView
    protected final void b() {
        if (this.A == null) {
            return;
        }
        super.b();
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.A;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        String strB = this.f.o.B();
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        int iA = q.a(getContext(), 50.0f);
        int iA2 = q.a(getContext(), 320.0f);
        strB.hashCode();
        switch (strB) {
            case "300x250":
                iA2 = q.a(getContext(), 300.0f);
                iA = q.a(getContext(), 250.0f);
                break;
            case "320x90":
                iA2 = q.a(getContext(), 320.0f);
                iA = q.a(getContext(), 90.0f);
                break;
            case "728x90":
                iA2 = q.a(getContext(), 720.0f);
                iA = q.a(getContext(), 90.0f);
                break;
        }
        int iMin = Math.min(iA2, getResources().getDisplayMetrics().widthPixels);
        if (this.z != null) {
            a(findViewById(q.a(getContext(), "myoffer_banner_root", "id")));
            this.z.a(this.b);
        }
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.g, this.f, this.z, new AnonymousClass1());
        this.A = mraidContainerView;
        mraidContainerView.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_web", "id"));
        this.A.setMinimumHeight(q.a(getContext(), 50.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iA);
        layoutParams.gravity = 17;
        frameLayout.addView(this.A, 0, layoutParams);
        setLayoutParams(new ViewGroup.LayoutParams(iMin, iA));
        if (this.f.o.C() == 0) {
            this.b.setVisibility(0);
            a((b) this.b, false);
        } else {
            this.b.setVisibility(8);
        }
        this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
        this.d.b(this);
    }
}
