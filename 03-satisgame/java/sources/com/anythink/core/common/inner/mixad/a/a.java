package com.anythink.core.common.inner.mixad.a;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.bridge.IATBaseAdAdapter;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartySplashBannerATView;
import com.anythink.core.common.k.b.a.b;
import com.anythink.core.common.k.b.a.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.anythink.core.common.k.b.a.a {
    private Context a;
    private b b;
    private IATBaseAdAdapter c;
    private int d;

    public a(com.anythink.core.common.k.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.a = aVar.a();
        this.b = aVar.i();
        this.c = aVar.f();
        this.d = aVar.a("countdown");
    }

    @Override // com.anythink.core.common.k.b.a.a
    public final c a() {
        if (this.a == null) {
            return null;
        }
        IATBaseAdAdapter iATBaseAdAdapter = this.c;
        View mixView = iATBaseAdAdapter != null ? iATBaseAdAdapter.getMixView() : null;
        if (mixView == null) {
            return null;
        }
        ThirdPartySplashBannerATView thirdPartySplashBannerATView = new ThirdPartySplashBannerATView(this.a);
        thirdPartySplashBannerATView.addBannerView(mixView);
        thirdPartySplashBannerATView.addCountDownView(this.d, new AnonymousClass1());
        return thirdPartySplashBannerATView;
    }

    private c a(View view) {
        ThirdPartySplashBannerATView thirdPartySplashBannerATView = new ThirdPartySplashBannerATView(this.a);
        thirdPartySplashBannerATView.addBannerView(view);
        thirdPartySplashBannerATView.addCountDownView(this.d, new AnonymousClass1());
        return thirdPartySplashBannerATView;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.mixad.a.a$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.inner.ui.thirdparty.a.InterfaceC0027a {
        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.inner.ui.thirdparty.a.InterfaceC0027a
        public final void a(int i) {
            if (a.this.b != null) {
                a.this.b.a(i);
                a.this.b = null;
            }
            if (a.this.c != null) {
                a.this.c.destory();
            }
        }
    }
}
