package com.mcto.sspsdk;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ QySdkConfig b;
    public final /* synthetic */ QySdk.InitCallBack c;

    public a(Context context, QySdkConfig qySdkConfig, QySdk.InitCallBack initCallBack) {
        this.a = context;
        this.b = qySdkConfig;
        this.c = initCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            QySdk.init(this.a, this.b);
            QySdk.postToMainThread(this.c, true, null);
        } catch (Throwable th) {
            synchronized (QySdk.class) {
                boolean unused = QySdk.sInitialized = false;
                QySdk.postToMainThread(this.c, false, th);
            }
        }
    }
}
