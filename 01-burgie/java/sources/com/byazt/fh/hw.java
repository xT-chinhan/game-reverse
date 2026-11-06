package com.byazt.fh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 890, 13})
public final class hw implements Choreographer.FrameCallback {
    public boolean hn;
    public final pr hw;
    public long x;
    public final Handler pr = new Handler(Looper.getMainLooper());
    public int c = 16;

    public interface pr {
        void pr(hn hnVar);
    }

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public void pr() {
        this.pr.post(new Runnable() { // from class: com.byazt.fh.hw.1
            @Override // java.lang.Runnable
            public void run() {
                if (!hw.this.hn) {
                    hw.this.hn = true;
                    hw.this.x = 0L;
                    hw.this.c = hw.x();
                    Choreographer.getInstance().postFrameCallback(hw.this);
                }
            }
        });
    }

    public void hw() {
        this.pr.post(new Runnable() { // from class: com.byazt.fh.hw.2
            @Override // java.lang.Runnable
            public void run() {
                if (hw.this.hn) {
                    hw.this.hn = false;
                    hw.this.x = 0L;
                    Choreographer.getInstance().removeFrameCallback(hw.this);
                }
            }
        });
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        StringBuilder sb;
        if (this.hn) {
            try {
                long j2 = this.x;
                if (j2 > 0) {
                    long j3 = j - j2;
                    if (j3 > 0 && j3 <= 500000000) {
                        int iPr = pr(j3);
                        int iMax = Math.max(0, (iPr / this.c) - 1);
                        pr prVar = this.hw;
                        if (prVar != null) {
                            prVar.pr(new hn(iPr, iMax, System.currentTimeMillis()));
                        }
                    }
                }
                this.x = j;
                if (this.hn) {
                    try {
                    } catch (Exception e) {
                        e = e;
                        this.hn = false;
                        sb = new StringBuilder("jank frame callback err: ");
                        StringBuilder sbAppend = sb.append(e.getMessage());
                    }
                }
            } catch (Exception e2) {
                ho.hw("PerfMonitor", "jank frame listener err: " + e2.getMessage());
                this.x = j;
                if (this.hn) {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        this.hn = false;
                        sb = new StringBuilder("jank frame callback err: ");
                        StringBuilder sbAppend2 = sb.append(e.getMessage());
                    }
                }
            } finally {
                this.x = j;
                if (this.hn) {
                    try {
                        Choreographer.getInstance().postFrameCallback(this);
                    } catch (Exception e4) {
                        this.hn = false;
                        ho.hw("PerfMonitor", "jank frame callback err: " + e4.getMessage());
                    }
                }
            }
        }
    }

    private static int pr(long j) {
        if (j <= 0) {
            return 0;
        }
        long j2 = j / C.MICROS_PER_SECOND;
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x() {
        WindowManager windowManager;
        Display defaultDisplay;
        int i;
        try {
            Context context = a.getContext();
            if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return 16;
            }
            float refreshRate = defaultDisplay.getRefreshRate();
            if (refreshRate > 0.0f && (i = (int) (1000.0f / refreshRate)) > 0) {
                return i;
            }
            return 16;
        } catch (Throwable th) {
            ho.hw("PerfMonitor", "read frame interval err: " + th.getMessage());
            return 16;
        }
    }
}
