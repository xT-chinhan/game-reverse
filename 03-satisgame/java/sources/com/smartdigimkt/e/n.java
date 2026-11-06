package com.smartdigimkt.e;

import android.os.Vibrator;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {
    public final /* synthetic */ Vibrator a;

    public n(Vibrator vibrator) {
        this.a = vibrator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.a(this.a);
    }
}
