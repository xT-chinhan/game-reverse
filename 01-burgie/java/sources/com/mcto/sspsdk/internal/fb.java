package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class fb extends Handler {
    public final WeakReference a;

    public fb(Looper looper, eb ebVar) {
        super(looper);
        this.a = new WeakReference(ebVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        eb ebVar = (eb) this.a.get();
        if (ebVar == null || message == null) {
            return;
        }
        ebVar.a(message);
    }
}
