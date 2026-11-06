package com.byazt.uvh;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 576, 26})
public final class qg implements Choreographer.FrameCallback {
    public long q;
    public final n qg;
    public boolean s;
    public final Handler n = new Handler(Looper.getMainLooper());
    public int l = 16;

    public interface n {
        void n(s sVar);
    }

    public qg(n nVar) {
        this.qg = nVar;
    }

    public void n() {
        this.n.post(new Runnable() { // from class: com.byazt.uvh.qg.1
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.s) {
                    return;
                }
                qg.this.s = true;
                qg.this.q = 0L;
                qg.this.l = qg.q();
                Choreographer.getInstance().postFrameCallback(qg.this);
            }
        });
    }

    public void qg() {
        this.n.post(new Runnable() { // from class: com.byazt.uvh.qg.2
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.s) {
                    qg.this.s = false;
                    qg.this.q = 0L;
                    Choreographer.getInstance().removeFrameCallback(qg.this);
                }
            }
        });
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        StringBuilder sb;
        if (this.s) {
            try {
                long j2 = this.q;
                if (j2 > 0) {
                    long j3 = j - j2;
                    if (j3 > 0 && j3 <= 500000000) {
                        int iN = n(j3);
                        int iMax = Math.max(0, (iN / this.l) - 1);
                        n nVar = this.qg;
                        if (nVar != null) {
                            nVar.n(new s(iN, iMax, System.currentTimeMillis()));
                        }
                    }
                }
                this.q = j;
                if (this.s) {
                    try {
                    } catch (Exception e) {
                        e = e;
                        this.s = false;
                        sb = new StringBuilder("jank frame callback err: ");
                        StringBuilder sbAppend = sb.append(e.getMessage());
                    }
                }
            } catch (Exception e2) {
                k.qg("PerfMonitor", "jank frame listener err: " + e2.getMessage());
                this.q = j;
                if (this.s) {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        this.s = false;
                        sb = new StringBuilder("jank frame callback err: ");
                        StringBuilder sbAppend2 = sb.append(e.getMessage());
                    }
                }
            } finally {
                this.q = j;
                if (this.s) {
                    try {
                        Choreographer.getInstance().postFrameCallback(this);
                    } catch (Exception e4) {
                        this.s = false;
                        k.qg("PerfMonitor", "jank frame callback err: " + e4.getMessage());
                    }
                }
            }
        }
    }

    private static int n(long j) {
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
    public static int q() {
        WindowManager windowManager;
        Display defaultDisplay;
        int i;
        try {
            Context context = rv.getContext();
            if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return 16;
            }
            float refreshRate = defaultDisplay.getRefreshRate();
            if (refreshRate > 0.0f && (i = (int) (1000.0f / refreshRate)) > 0) {
                return i;
            }
            return 16;
        } catch (Throwable th) {
            k.qg("PerfMonitor", "read frame interval err: " + th.getMessage());
            return 16;
        }
    }
}
