package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 implements Runnable {
    public final /* synthetic */ BaseScreenATView a;

    public d1(BaseScreenATView baseScreenATView) {
        this.a = baseScreenATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseScreenATView baseScreenATView = this.a;
        String str = BaseScreenATView.TAG;
        baseScreenATView.m();
    }
}
