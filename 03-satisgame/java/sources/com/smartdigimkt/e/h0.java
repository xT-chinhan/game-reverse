package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.LeftSkipSinglePictureSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LeftSkipSinglePictureSplashATView b;

    public h0(LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView, int i) {
        this.b = leftSkipSinglePictureSplashATView;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LeftSkipSinglePictureSplashATView.a(this.b, this.a + 1);
    }
}
