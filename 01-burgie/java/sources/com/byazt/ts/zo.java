package com.byazt.ts;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.byazt.lj.CSJDownloadService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends com.byazt.lj.pr {
    public static final String c = zo.class.getSimpleName();

    @Override // com.byazt.lj.pr
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.lj.pr
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.hw = false;
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void hn() {
        if (com.byazt.tuy.pr.pr(262144)) {
            this.hw = true;
            this.x = false;
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.hw(c, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.byazt.lj.pr, com.byazt.lj.ho
    public void pr(Intent intent, int i, int i2) {
        if (com.byazt.p000do.pr.pr()) {
            com.byazt.p000do.pr.hw(c, "onStartCommand");
        }
        if (!com.byazt.tuy.pr.pr(262144)) {
            this.hw = true;
        }
        c();
    }
}
