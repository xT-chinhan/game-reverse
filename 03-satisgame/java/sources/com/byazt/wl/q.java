package com.byazt.wl;

import android.os.Handler;
import android.util.Log;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 888, 5})
public class q<T> {
    public volatile boolean cp;
    public final Runnable d;
    public volatile Thread fs;
    public final long l;
    public final Handler n;
    public final int q;
    public int qg;
    public long rv;
    public final Callable<T> s;
    public volatile boolean tj;
    public volatile boolean w;
    public final qg<T> x;

    public interface qg<T> {
        boolean n(Exception exc);

        boolean n(T t);
    }

    public static boolean n(int i) {
        return i >= 500 || i == 429;
    }

    public static /* synthetic */ int l(q qVar) {
        int i = qVar.qg;
        qVar.qg = i + 1;
        return i;
    }

    private q(n<T> nVar) {
        this.n = rv.s();
        this.qg = 0;
        this.w = false;
        this.rv = 0L;
        this.tj = false;
        this.cp = false;
        this.d = new Runnable() { // from class: com.byazt.wl.q.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (q.this.qg < q.this.q && !q.this.cp) {
                        if (!com.byazt.vyf.s.cy().lh()) {
                            long jW = q.this.w();
                            q.l(q.this);
                            q.this.s.call();
                            q.this.n.postDelayed(q.this.d, jW);
                            return;
                        }
                        q.this.s();
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.s = nVar.n;
        this.x = nVar.qg;
        this.q = nVar.s;
        this.l = nVar.q;
        this.rv = nVar.l;
    }

    public T n() throws Exception {
        this.fs = Thread.currentThread();
        this.qg = 0;
        T tCall = null;
        while (this.qg < this.q && !this.w) {
            try {
                if (com.byazt.vyf.s.cy().lh()) {
                    this.w = true;
                    break;
                }
                tCall = this.s.call();
                qg<T> qgVar = this.x;
                if (qgVar == null || !qgVar.n(tCall)) {
                    break;
                }
                q();
            } catch (Exception e) {
                qg<T> qgVar2 = this.x;
                if (qgVar2 != null && qgVar2.n(e)) {
                    q();
                } else {
                    Log.getStackTraceString(e);
                    throw e;
                }
            }
        }
        return tCall;
    }

    private void q() {
        if (this.w) {
            return;
        }
        this.qg++;
        l();
    }

    private void l() {
        try {
            Thread.sleep(w());
        } catch (InterruptedException unused) {
            this.w = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long w() {
        return (long) ((this.rv * Math.pow(2.0d, this.qg)) + this.l);
    }

    public void qg() {
        this.n.removeCallbacks(this.d);
        if (this.qg >= this.q || this.tj) {
            return;
        }
        if (com.byazt.vyf.s.cy().lh()) {
            s();
            return;
        }
        long jW = w();
        this.tj = true;
        this.n.postDelayed(this.d, jW);
    }

    public void s() {
        this.n.removeCallbacks(this.d);
        this.qg = 0;
        this.tj = false;
        this.cp = true;
    }

    @com.byazt.cp.n(n = {0, 1, 888, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n<T> {
        public final Callable<T> n;
        public qg<T> qg;
        public int s = 5;
        public long q = 0;
        public long l = 1000;

        public n(Callable<T> callable) {
            this.n = callable;
        }

        public n(Callable<T> callable, qg<T> qgVar) {
            this.n = callable;
            this.qg = qgVar;
        }

        public n<T> n(int i) {
            this.s = i;
            return this;
        }

        public n<T> n(long j) {
            this.q = j;
            return this;
        }

        public q<T> n() {
            return new q<>(this);
        }
    }

    public static boolean n(Throwable th) {
        String message;
        if ((th instanceof UnknownHostException) || (th instanceof SSLException) || (th instanceof InterruptedIOException) || (th instanceof EOFException) || (th instanceof SocketException)) {
            return true;
        }
        if (!(th instanceof IOException) || (message = th.getMessage()) == null) {
            return false;
        }
        String lowerCase = message.toLowerCase();
        return lowerCase.contains("canceled") || lowerCase.contains("timeout") || lowerCase.contains("etimedout") || lowerCase.contains("enetunreach") || lowerCase.contains("econnreset") || lowerCase.contains("connection abort") || lowerCase.contains("software caused connection abort");
    }
}
