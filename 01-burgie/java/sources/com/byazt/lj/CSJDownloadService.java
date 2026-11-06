package com.byazt.lj;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 915})
public class CSJDownloadService extends Service {
    public static final String hw = CSJDownloadService.class.getSimpleName();
    public ho pr;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        hn.pr(this);
        ho hoVarB = hn.b();
        this.pr = hoVarB;
        hoVarB.pr(new WeakReference(this));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.byazt.p000do.pr.hw(hw, "onBind downloadServiceHandler != null:" + (this.pr != null));
        ho hoVar = this.pr;
        if (hoVar != null) {
            return hoVar.pr(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.byazt.p000do.pr.pr()) {
            com.byazt.p000do.pr.hw(hw, "DownloadService onStartCommand");
        }
        this.pr.hn();
        ExecutorService executorServiceK = hn.k();
        if (executorServiceK != null) {
            executorServiceK.execute(new Runnable() { // from class: com.byazt.lj.CSJDownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CSJDownloadService.this.pr != null) {
                        CSJDownloadService.this.pr.pr(intent, i, i2);
                    }
                }
            });
        }
        if (hn.vk()) {
            return 2;
        }
        return 3;
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.byazt.p000do.pr.pr()) {
            com.byazt.p000do.pr.hw(hw, "Service onDestroy");
        }
        ho hoVar = this.pr;
        if (hoVar != null) {
            hoVar.x();
            this.pr = null;
        }
        super.onDestroy();
    }
}
