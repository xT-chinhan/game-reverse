package com.byazt.sp;

import android.os.Handler;
import android.util.Log;
import com.byazt.ca.aj;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c<T> {
    public long aj;
    public final long c;
    public final hw<T> fw;
    public final Callable<T> hn;
    public int hw;
    public final Runnable k;
    public final Handler pr;
    public volatile boolean uc;
    public volatile boolean vk;
    public volatile boolean w;
    public final int x;
    public volatile Thread zo;

    public interface hw<T> {
        boolean pr(Exception exc);

        boolean pr(T t);
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.hw;
        cVar.hw = i + 1;
        return i;
    }

    private c(pr<T> prVar) {
        this.pr = aj.hn();
        this.hw = 0;
        this.uc = false;
        this.aj = 0L;
        this.vk = false;
        this.w = false;
        this.k = new Runnable() { // from class: com.byazt.sp.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (c.this.hw >= c.this.x || c.this.w) {
                        return;
                    }
                    if (!zo.nt().y()) {
                        long jUc = c.this.uc();
                        c.c(c.this);
                        c.this.hn.call();
                        c.this.pr.postDelayed(c.this.k, jUc);
                        return;
                    }
                    c.this.hn();
                } catch (Exception e) {
                }
            }
        };
        this.hn = prVar.pr;
        this.fw = prVar.hw;
        this.x = prVar.hn;
        this.c = prVar.x;
        this.aj = prVar.c;
    }

    public T pr() throws Exception {
        this.zo = Thread.currentThread();
        this.hw = 0;
        T tCall = null;
        while (this.hw < this.x && !this.uc) {
            try {
                if (zo.nt().y()) {
                    this.uc = true;
                    break;
                }
                tCall = this.hn.call();
                hw<T> hwVar = this.fw;
                if (hwVar == null || !hwVar.pr(tCall)) {
                    break;
                }
                x();
            } catch (Exception e) {
                hw<T> hwVar2 = this.fw;
                if (hwVar2 != null && hwVar2.pr(e)) {
                    x();
                } else {
                    Log.getStackTraceString(e);
                    throw e;
                }
            }
        }
        return tCall;
    }

    private void x() {
        if (this.uc) {
            return;
        }
        this.hw++;
        c();
    }

    private void c() {
        try {
            Thread.sleep(uc());
        } catch (InterruptedException e) {
            this.uc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long uc() {
        return (long) ((this.aj * Math.pow(2.0d, this.hw)) + this.c);
    }

    public void hw() {
        this.pr.removeCallbacks(this.k);
        if (this.hw >= this.x || this.vk) {
            return;
        }
        if (zo.nt().y()) {
            hn();
            return;
        }
        long jUc = uc();
        this.vk = true;
        this.pr.postDelayed(this.k, jUc);
    }

    public void hn() {
        this.pr.removeCallbacks(this.k);
        this.hw = 0;
        this.vk = false;
        this.w = true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 169})
    public static class pr<T> {
        public hw<T> hw;
        public final Callable<T> pr;
        public int hn = 5;
        public long x = 0;
        public long c = 1000;

        public pr(Callable<T> callable) {
            this.pr = callable;
        }

        public pr(Callable<T> callable, hw<T> hwVar) {
            this.pr = callable;
            this.hw = hwVar;
        }

        public pr<T> pr(int i) {
            this.hn = i;
            return this;
        }

        public pr<T> pr(long j) {
            this.x = j;
            return this;
        }

        public c<T> pr() {
            return new c<>(this);
        }
    }

    public static boolean pr(Throwable th) {
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

    public static boolean pr(int i) {
        return i >= 500 || i == 429;
    }
}
