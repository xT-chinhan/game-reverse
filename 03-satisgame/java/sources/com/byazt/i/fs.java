package com.byazt.i;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.byazt.xv.CSJDownloadService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 101})
public class fs extends com.byazt.xv.n {
    public static final String l = "fs";

    @Override // com.byazt.xv.n
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, (Class<?>) CSJDownloadService.class));
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.xv.n
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, (Class<?>) CSJDownloadService.class));
        this.qg = false;
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void s() {
        if (com.byazt.ta.n.n(262144)) {
            this.qg = true;
            this.q = false;
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.qg(l, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.byazt.xv.n, com.byazt.xv.k
    public void n(Intent intent, int i, int i2) {
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(l, "onStartCommand");
        }
        if (!com.byazt.ta.n.n(262144)) {
            this.qg = true;
        }
        l();
    }
}
