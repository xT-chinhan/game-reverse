package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class k2 implements Runnable {
    public final /* synthetic */ BaseSplashATView a;

    public k2(BaseSplashATView baseSplashATView) {
        this.a = baseSplashATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r3 r3Var = this.a.M;
        if (r3Var.b != null) {
            r3Var.a.post(new q3(r3Var));
        }
    }
}
