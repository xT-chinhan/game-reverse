package com.smartdigimkt.e;

import com.smartdigimkt.china.formatbusiness.ui.LeftSkipAsseblemSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ LeftSkipAsseblemSplashATView b;

    public z(LeftSkipAsseblemSplashATView leftSkipAsseblemSplashATView, int i) {
        this.b = leftSkipAsseblemSplashATView;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LeftSkipAsseblemSplashATView.a(this.b, this.a + 1);
    }
}
