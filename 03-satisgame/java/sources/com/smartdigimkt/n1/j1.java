package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 implements Runnable {
    public final /* synthetic */ BaseScreenATView a;

    public j1(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r3 r3Var = this.a.i0;
        if (r3Var == null || r3Var.b == null) {
            return;
        }
        r3Var.a.post(new q3(r3Var));
    }
}
