package com.byazt.pmn;

import android.os.Looper;
import com.byazt.qit.x;
import com.byazt.vyf.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, 1185})
public class DownloadListenerTask extends x {
    public static final String ON_DOWNLOAD_ACTIVE = "onDownloadActive";
    public static final String ON_DOWNLOAD_FAILED = "onDownloadFailed";
    public static final String ON_DOWNLOAD_FINISHED = "onDownloadFinished";
    public static final String ON_DOWNLOAD_PAUSED = "onDownloadPaused";
    public static final String ON_IDLE = "onIdle";
    public static final String ON_INSTALLED = "onInstalled";
    public String l;
    public String n;
    public long q;
    public AppDownloadListener qg;
    public long s;
    public String w;

    public DownloadListenerTask(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.qg == null) {
        }
        String str = this.n;
        str.hashCode();
        switch (str) {
            case "onIdle":
                this.qg.onIdle();
                break;
            case "onInstalled":
                this.qg.onInstalled(this.l, this.w);
                break;
            case "onDownloadActive":
                this.qg.onDownloadActive(this.s, this.q, this.l, this.w);
                break;
            case "onDownloadFailed":
                this.qg.onDownloadFailed(this.s, this.q, this.l, this.w);
                break;
            case "onDownloadPaused":
                this.qg.onDownloadPaused(this.s, this.q, this.l, this.w);
                break;
            case "onDownloadFinished":
                this.qg.onDownloadFinished(this.s, this.l, this.w);
                break;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE, 2393})
    static class n {
        public String l;
        public String n;
        public String q;
        public long qg;
        public long s;
        public AppDownloadListener w;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n n(AppDownloadListener appDownloadListener) {
            this.w = appDownloadListener;
            return this;
        }

        public n n(long j) {
            this.qg = j;
            return this;
        }

        public n qg(long j) {
            this.s = j;
            return this;
        }

        public n qg(String str) {
            this.q = str;
            return this;
        }

        public n s(String str) {
            this.l = str;
            return this;
        }

        public void n() {
            DownloadListenerTask downloadListenerTask = new DownloadListenerTask("tt_csj_download_thread");
            downloadListenerTask.w = this.l;
            downloadListenerTask.l = this.q;
            downloadListenerTask.q = this.s;
            downloadListenerTask.s = this.qg;
            downloadListenerTask.n = this.n;
            downloadListenerTask.qg = this.w;
            DownloadListenerTask.qg(downloadListenerTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            l.q().post(runnable);
        } else {
            runnable.run();
        }
    }
}
