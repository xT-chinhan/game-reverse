package com.bytedance.adsdk.ugeno.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class ny extends Handler {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final WeakReference<ms> f350ms;

    public interface ms {
        void ms(Message message);
    }

    public ny(Looper looper, ms msVar) {
        super(looper);
        this.f350ms = new WeakReference<>(msVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ms msVar = this.f350ms.get();
        if (msVar == null || message == null) {
            return;
        }
        msVar.ms(message);
    }
}
