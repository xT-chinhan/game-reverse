package com.smartdigimkt.e;

import android.os.Vibrator;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ Vibrator a;

    public o(Vibrator vibrator) {
        this.a = vibrator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.a(this.a);
    }
}
