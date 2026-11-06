package com.ss.android.socialbase.downloader.x;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class x extends Handler {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final WeakReference<ms> f4802ms;

    public interface ms {
        void ms(Message message);
    }

    public x(Looper looper, ms msVar) {
        super(looper);
        this.f4802ms = new WeakReference<>(msVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ms msVar = this.f4802ms.get();
        if (msVar == null || message == null) {
            return;
        }
        msVar.ms(message);
    }
}
