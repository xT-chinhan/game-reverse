package com.byazt.nr;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1357, 19})
public class n extends FileObserver {
    public final s n;
    public final int qg;
    public volatile boolean s;

    public n(s sVar, String str, int i) {
        super(str, i);
        this.qg = 5000;
        this.s = true;
        if (sVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.n = sVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (this.s && i == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && this.n != null) {
            this.s = false;
            this.n.n(200, "/data/anr/".concat(String.valueOf(str)), 80);
            new C0271n(5000).start();
        }
    }

    /* JADX INFO: renamed from: com.byazt.nr.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1357, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private final class C0271n extends com.byazt.xis.s {
        public int qg;

        public C0271n(int i) {
            super("ANRFileObserver$RestartMonitorThread");
            this.qg = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.qg);
            n.this.s = true;
        }
    }
}
