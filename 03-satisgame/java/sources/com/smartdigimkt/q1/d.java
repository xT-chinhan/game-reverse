package com.smartdigimkt.q1;

import com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ BaseAnimPlayerView a;

    public d(BaseAnimPlayerView baseAnimPlayerView) {
        this.a = baseAnimPlayerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar;
        Thread threadCurrentThread = Thread.currentThread();
        while (this.a.j && !this.a.B && this.a.m == threadCurrentThread) {
            BaseAnimPlayerView baseAnimPlayerView = this.a;
            if (baseAnimPlayerView.l || (cVar = baseAnimPlayerView.n) == null) {
                try {
                    Thread.sleep(10L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else {
                try {
                    cVar.sendEmptyMessage(1);
                } catch (Throwable unused) {
                }
                try {
                    Thread.sleep(200L);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
