package com.byazt.mdu;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.sv.JumpUnknownSourceActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 62})
public class fw {
    public SoftReference<JumpUnknownSourceActivity> c;
    public Runnable fw;
    public long hn;
    public boolean hw;
    public final Queue<Integer> pr;
    public Handler uc;
    public long x;

    private fw() {
        this.pr = new ArrayDeque();
        this.hw = false;
        this.uc = new Handler(Looper.getMainLooper());
        this.fw = new Runnable() { // from class: com.byazt.mdu.fw.1
            @Override // java.lang.Runnable
            public void run() {
                fw.this.hn();
            }
        };
        com.byazt.wel.pr.pr().pr(new com.byazt.wel.pr.InterfaceC0223pr() { // from class: com.byazt.mdu.fw.2
            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hw() {
                if (fw.this.pr.isEmpty()) {
                    return;
                }
                long jPr = com.byazt.ew.pr.hn().pr("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - fw.this.x;
                if (jCurrentTimeMillis < jPr) {
                    if (!fw.this.uc.hasCallbacks(fw.this.fw)) {
                        fw.this.uc.postDelayed(fw.this.fw, jPr - jCurrentTimeMillis);
                    }
                } else {
                    fw.this.x = System.currentTimeMillis();
                    fw.this.hn();
                }
            }

            @Override // com.byazt.wel.pr.InterfaceC0223pr
            public void hn() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT >= 29 && !com.byazt.wel.pr.pr().hw()) {
            return;
        }
        synchronized (this.pr) {
            numPoll = this.pr.poll();
        }
        this.uc.removeCallbacks(this.fw);
        if (numPoll != null) {
            final Context contextOf = com.byazt.lj.hn.of();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                hw(contextOf, numPoll.intValue(), false);
            } else {
                this.uc.post(new Runnable() { // from class: com.byazt.mdu.fw.3
                    @Override // java.lang.Runnable
                    public void run() {
                        fw.this.hw(contextOf, numPoll.intValue(), false);
                    }
                });
            }
            this.uc.postDelayed(this.fw, 20000L);
            return;
        }
        this.hw = false;
    }

    public void pr(DownloadInfo downloadInfo, String str) {
        if (downloadInfo != null && !TextUtils.isEmpty(str)) {
            hn();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 766})
    private static class pr {
        public static final fw pr = new fw();
    }

    public static fw pr() {
        return pr.pr;
    }

    public int pr(final Context context, final int i, final boolean z) {
        if (z) {
            return hw(context, i, z);
        }
        if (x()) {
            this.uc.postDelayed(new Runnable() { // from class: com.byazt.mdu.fw.4
                @Override // java.lang.Runnable
                public void run() {
                    fw.this.pr(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.byazt.wel.pr.pr().hw()) {
            com.byazt.p000do.pr.hn("leaves", "on Foreground");
            return hw(context, i, z);
        }
        if (hw.pr()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.pr.isEmpty() && !this.hw && z2) {
            return hw(context, i, z);
        }
        int iPr = com.byazt.ew.pr.hn().pr("install_queue_size", 3);
        synchronized (this.pr) {
            while (this.pr.size() > iPr) {
                this.pr.poll();
            }
        }
        if (z2) {
            this.uc.removeCallbacks(this.fw);
            this.uc.postDelayed(this.fw, com.byazt.ew.pr.pr(i).pr("install_queue_timeout", 20000L));
        }
        synchronized (this.pr) {
            if (!this.pr.contains(Integer.valueOf(i))) {
                this.pr.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean x() {
        return System.currentTimeMillis() - this.hn < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hw(Context context, int i, boolean z) {
        int iHw = hn.hw(context, i, z);
        if (iHw == 1) {
            this.hw = true;
        }
        this.hn = System.currentTimeMillis();
        return iHw;
    }

    public void pr(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.c = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity hw() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.c;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.c = null;
        return jumpUnknownSourceActivity;
    }
}
