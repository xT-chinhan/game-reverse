package com.smartdigimkt.n3;

import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {
    public final /* synthetic */ w a;

    public v(w wVar) {
        this.a = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w wVar = this.a;
        Handler handler = wVar.b;
        if (handler != null) {
            handler.post(wVar.f);
        } else {
            wVar.f.run();
        }
    }
}
