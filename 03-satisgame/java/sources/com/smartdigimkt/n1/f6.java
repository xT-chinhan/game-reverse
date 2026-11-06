package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.SpreadAnimLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class f6 implements Runnable {
    public final /* synthetic */ SpreadAnimLayout a;

    public f6(SpreadAnimLayout spreadAnimLayout) {
        this.a = spreadAnimLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.startSpreadAnimation();
    }
}
