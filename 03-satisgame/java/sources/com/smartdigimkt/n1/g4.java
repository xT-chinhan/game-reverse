package com.smartdigimkt.n1;

import android.os.SystemClock;
import com.smartdigimkt.sdk.basead.ui.PlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class g4 implements Runnable {
    public final /* synthetic */ PlayerView a;

    public g4(PlayerView playerView) {
        this.a = playerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerView playerView;
        e4 e4Var;
        Thread threadCurrentThread = Thread.currentThread();
        while (true) {
            long jElapsedRealtime = 0;
            while (!this.a.M && this.a.L == threadCurrentThread) {
                PlayerView playerView2 = this.a;
                if (playerView2.l || !playerView2.isPlaying() || (e4Var = (playerView = this.a).J) == null) {
                    if (jElapsedRealtime == 0) {
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    }
                    try {
                        Thread.sleep(10L);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (SystemClock.elapsedRealtime() - jElapsedRealtime > 5000 && jElapsedRealtime != 0) {
                        PlayerView playerView3 = this.a;
                        synchronized (playerView3) {
                            if (!playerView3.M && playerView3.L == threadCurrentThread) {
                                playerView3.b();
                                playerView3.N = threadCurrentThread;
                                com.smartdigimkt.q3.f.a().a(new h4(playerView3, threadCurrentThread));
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    try {
                        e4Var.sendEmptyMessage((int) playerView.t.b.f());
                    } catch (Throwable unused) {
                    }
                    try {
                        Thread.sleep(200L);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
            return;
        }
    }
}
