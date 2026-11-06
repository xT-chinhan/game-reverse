package com.smartdigimkt.c;

import com.smartdigimkt.china.based.twist.TwistG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ TwistG2CV2View a;

    public b(TwistG2CV2View twistG2CV2View) {
        this.a = twistG2CV2View;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TwistG2CV2View.a(this.a);
    }
}
