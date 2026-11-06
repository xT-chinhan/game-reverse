package com.byazt.nv;

import android.os.Looper;
import com.byazt.sd.lb;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 734, 13})
public class hw extends fw {
    public String c;
    public long hn;
    public com.byazt.nv.pr hw;
    public String pr;
    public String uc;
    public long x;

    public hw(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hw == null) {
        }
        switch (this.pr) {
            case "onIdle":
                this.hw.pr();
                break;
            case "onDownloadActive":
                this.hw.pr(this.hn, this.x, this.c, this.uc);
                break;
            case "onDownloadPaused":
                this.hw.hw(this.hn, this.x, this.c, this.uc);
                break;
            case "onDownloadFailed":
                this.hw.hn(this.hn, this.x, this.c, this.uc);
                break;
            case "onInstalled":
                this.hw.pr(this.c, this.uc);
                break;
            case "onDownloadFinished":
                this.hw.pr(this.hn, this.c, this.uc);
                break;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 734, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static class pr {
        public String c;
        public long hn;
        public long hw;
        public String pr;
        public com.byazt.nv.pr uc;
        public String x;

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr pr(com.byazt.nv.pr prVar) {
            this.uc = prVar;
            return this;
        }

        public pr pr(long j) {
            this.hw = j;
            return this;
        }

        public pr hw(long j) {
            this.hn = j;
            return this;
        }

        public pr hw(String str) {
            this.x = str;
            return this;
        }

        public pr hn(String str) {
            this.c = str;
            return this;
        }

        public void pr() {
            hw hwVar = new hw("tt_csj_download_thread");
            hwVar.uc = this.c;
            hwVar.c = this.x;
            hwVar.x = this.hn;
            hwVar.hn = this.hw;
            hwVar.pr = this.pr;
            hwVar.hw = this.uc;
            hw.hw(hwVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            lb.uc().post(runnable);
        } else {
            runnable.run();
        }
    }
}
