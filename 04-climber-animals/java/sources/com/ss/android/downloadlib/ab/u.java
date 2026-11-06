package com.ss.android.downloadlib.ab;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class u extends Handler {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    WeakReference<ms> f4341ms;

    public interface ms {
        void ms(Message message);
    }

    public u(Looper looper, ms msVar) {
        super(looper);
        this.f4341ms = new WeakReference<>(msVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ms msVar = this.f4341ms.get();
        if (msVar == null || message == null) {
            return;
        }
        msVar.ms(message);
    }
}
