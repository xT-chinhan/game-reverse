package com.byazt.e;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.a.JumpUnknownSourceActivity;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 21})
public class x {
    public SoftReference<JumpUnknownSourceActivity> l;
    public final Queue<Integer> n;
    public long q;
    public boolean qg;
    public long s;
    public Handler w;
    public Runnable x;

    private x() {
        this.n = new ArrayDeque();
        this.qg = false;
        this.w = new Handler(Looper.getMainLooper());
        this.x = new Runnable() { // from class: com.byazt.e.x.1
            @Override // java.lang.Runnable
            public void run() {
                x.this.s();
            }
        };
        com.byazt.b.n.n().n(new com.byazt.b.n.InterfaceC0133n() { // from class: com.byazt.e.x.2
            @Override // com.byazt.b.n.InterfaceC0133n
            public void s() {
            }

            @Override // com.byazt.b.n.InterfaceC0133n
            public void qg() {
                if (x.this.n.isEmpty()) {
                    return;
                }
                long jN = com.byazt.f.n.s().n("install_on_resume_install_interval", i.l.c);
                long jCurrentTimeMillis = System.currentTimeMillis() - x.this.q;
                if (jCurrentTimeMillis < jN) {
                    if (x.this.w.hasCallbacks(x.this.x)) {
                        return;
                    }
                    x.this.w.postDelayed(x.this.x, jN - jCurrentTimeMillis);
                } else {
                    x.this.q = System.currentTimeMillis();
                    x.this.s();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.byazt.b.n.n().qg()) {
            synchronized (this.n) {
                numPoll = this.n.poll();
            }
            this.w.removeCallbacks(this.x);
            if (numPoll != null) {
                final Context contextU = com.byazt.xv.s.u();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    this.w.post(new Runnable() { // from class: com.byazt.e.x.3
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.qg(contextU, numPoll.intValue(), false);
                        }
                    });
                } else {
                    qg(contextU, numPoll.intValue(), false);
                }
                this.w.postDelayed(this.x, 20000L);
                return;
            }
            this.qg = false;
        }
    }

    public void n(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        s();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static class n {
        public static final x n = new x();
    }

    public static x n() {
        return n.n;
    }

    public int n(final Context context, final int i, final boolean z) {
        if (z) {
            return qg(context, i, z);
        }
        if (q()) {
            this.w.postDelayed(new Runnable() { // from class: com.byazt.e.x.4
                @Override // java.lang.Runnable
                public void run() {
                    x.this.n(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.byazt.b.n.n().qg()) {
            com.byazt.fe.n.s("leaves", "on Foreground");
            return qg(context, i, z);
        }
        if (qg.n()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.n.isEmpty() && !this.qg && z2) {
            return qg(context, i, z);
        }
        int iN = com.byazt.f.n.s().n("install_queue_size", 3);
        synchronized (this.n) {
            while (this.n.size() > iN) {
                this.n.poll();
            }
        }
        if (z2) {
            this.w.removeCallbacks(this.x);
            this.w.postDelayed(this.x, com.byazt.f.n.n(i).n("install_queue_timeout", 20000L));
        }
        synchronized (this.n) {
            if (!this.n.contains(Integer.valueOf(i))) {
                this.n.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean q() {
        return System.currentTimeMillis() - this.s < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qg(Context context, int i, boolean z) {
        int iQg = s.qg(context, i, z);
        if (iQg == 1) {
            this.qg = true;
        }
        this.s = System.currentTimeMillis();
        return iQg;
    }

    public void n(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.l = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity qg() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.l;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.l = null;
        return jumpUnknownSourceActivity;
    }
}
