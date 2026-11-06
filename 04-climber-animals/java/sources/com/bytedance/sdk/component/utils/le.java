package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class le extends Handler {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected WeakReference<ms> f1360ms;

    public interface ms {
        void ms(Message message);
    }

    public le(Looper looper, ms msVar) {
        super(looper);
        if (msVar != null) {
            this.f1360ms = new WeakReference<>(msVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ms msVar;
        WeakReference<ms> weakReference = this.f1360ms;
        if (weakReference == null || (msVar = weakReference.get()) == null || message == null) {
            return;
        }
        msVar.ms(message);
    }
}
