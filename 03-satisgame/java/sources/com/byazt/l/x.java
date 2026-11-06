package com.byazt.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 21})
public class x {
    public Handler q;
    public n s;
    public Object n = new Object();
    public Queue<qg> qg = new ConcurrentLinkedQueue();

    public x(String str) {
        this.s = new n(str);
    }

    public void n() {
        this.s.start();
    }

    public void n(Runnable runnable) {
        n(runnable, 0L);
    }

    public void n(Runnable runnable, long j) {
        if (this.q == null) {
            synchronized (this.n) {
                if (this.q == null) {
                    this.qg.add(new qg(runnable, j));
                    return;
                }
            }
        }
        this.q.postDelayed(runnable, j);
    }

    public void qg() {
        this.s.quit();
    }

    @com.byazt.cp.n(n = {0, 1, 18, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private class n extends HandlerThread {
        public n(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (x.this.n) {
                x.this.q = new Handler(looper);
            }
            while (!x.this.qg.isEmpty()) {
                qg qgVar = (qg) x.this.qg.poll();
                if (qgVar != null) {
                    x.this.q.postDelayed(qgVar.n, qgVar.qg);
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 18, 1181})
    private class qg {
        public Runnable n;
        public long qg;

        public qg(Runnable runnable, long j) {
            this.n = runnable;
            this.qg = j;
        }
    }
}
