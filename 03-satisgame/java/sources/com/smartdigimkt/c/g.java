package com.smartdigimkt.c;

import com.smartdigimkt.china.based.twist.TwistG2CV2View;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {
    public final /* synthetic */ j a;

    public g(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TwistG2CV2View twistG2CV2View = this.a.i;
        if (twistG2CV2View != null) {
            twistG2CV2View.registerGyroscopeAfterShowNotified();
        }
    }
}
