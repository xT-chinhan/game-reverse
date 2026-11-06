package com.smartdigimkt.n1;

import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements com.smartdigimkt.q1.k {
    public final /* synthetic */ BaseSdkSplashATView a;

    public p1(BaseSdkSplashATView baseSdkSplashATView) {
        this.a = baseSdkSplashATView;
    }

    @Override // com.smartdigimkt.q1.k
    public final void a() {
        BaseSdkSplashATView baseSdkSplashATView = this.a;
        baseSdkSplashATView.l0 = true;
        com.smartdigimkt.u1.d dVar = baseSdkSplashATView.n;
        if (dVar != null) {
            dVar.b(2);
        }
        if (baseSdkSplashATView.c0) {
            baseSdkSplashATView.a(7, true);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(long j) {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b() {
    }

    @Override // com.smartdigimkt.q1.k
    public final void b(long j) {
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
        ImageView imageView = this.a.h0;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = this.a.g0;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void g() {
        BaseSdkSplashATView baseSdkSplashATView = this.a;
        if (baseSdkSplashATView.b.s.e != 1) {
            baseSdkSplashATView.a(1, 3);
        }
    }

    @Override // com.smartdigimkt.q1.k
    public final void a(com.smartdigimkt.h0.g gVar) {
        BaseSdkSplashATView baseSdkSplashATView = this.a;
        baseSdkSplashATView.l0 = true;
        com.smartdigimkt.u1.d dVar = baseSdkSplashATView.n;
        if (dVar != null) {
            dVar.b(2);
        }
        if (baseSdkSplashATView.c0) {
            baseSdkSplashATView.a(7, true);
        }
        BaseSdkSplashATView baseSdkSplashATView2 = this.a;
        com.smartdigimkt.n3.k.a(baseSdkSplashATView2.b, baseSdkSplashATView2.c, 2, gVar.a());
    }
}
