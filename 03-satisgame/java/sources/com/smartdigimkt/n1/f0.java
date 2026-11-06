package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.BaseATView;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ com.smartdigimkt.j1.w a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseATView d;

    public f0(BaseATView baseATView, com.smartdigimkt.j1.w wVar, int i, int i2) {
        this.d = baseATView;
        this.a = wVar;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseATView baseATView = this.d;
        com.smartdigimkt.j1.w wVar = this.a;
        int i = this.b;
        int i2 = this.c;
        int i3 = BaseATView.C;
        baseATView.a(wVar, i, i2);
    }
}
