package com.byazt.njk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c {
    public static Handler hw;
    public static HandlerThread pr;
    public long aj;
    public final x hn;
    public volatile int vk;
    public volatile int w;
    public volatile boolean zo;
    public uc x = new uc();
    public uc c = new uc();
    public uc uc = new uc();
    public final Object fw = new Object();
    public final Runnable k = new Runnable() { // from class: com.byazt.njk.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.zo) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                float f = 0.033333335f;
                if (c.this.aj != 0) {
                    float f2 = (jUptimeMillis - c.this.aj) / 1000.0f;
                    if (f2 <= 0.033333335f) {
                        f = f2;
                    }
                } else {
                    f = 0.016f;
                }
                c.this.aj = jUptimeMillis;
                c.this.hn.pr(c.this.vk, c.this.w);
                c.this.hn.update(f);
                c.this.hn.pr(c.this.x);
                synchronized (c.this.fw) {
                    uc ucVar = c.this.c;
                    c cVar = c.this;
                    cVar.c = cVar.x;
                    c.this.x = ucVar;
                }
                if (c.this.zo) {
                    c.zo().postDelayed(this, 16L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Handler zo() {
        if (pr == null) {
            HandlerThread handlerThread = new HandlerThread("ugen-particle-physics", 10);
            pr = handlerThread;
            handlerThread.start();
            hw = new Handler(pr.getLooper());
        }
        return hw;
    }

    public c(hw hwVar) {
        this.hn = new x(hwVar);
    }

    public void pr(int i, int i2) {
        this.vk = i;
        this.w = i2;
    }

    public uc pr() {
        uc ucVar;
        synchronized (this.fw) {
            uc ucVar2 = this.uc;
            ucVar = this.c;
            this.uc = ucVar;
            this.c = ucVar2;
        }
        return ucVar;
    }

    public hw hw() {
        return this.hn.hw();
    }

    public hw.x[] hn() {
        return this.hn.pr();
    }

    public void x() {
        if (this.zo) {
            return;
        }
        this.zo = true;
        this.aj = 0L;
        zo().post(this.k);
    }

    public void c() {
        this.zo = false;
        zo().removeCallbacks(this.k);
    }

    public void uc() {
        c();
        synchronized (this.fw) {
            this.x = new uc();
            this.c = new uc();
            this.uc = new uc();
        }
    }
}
