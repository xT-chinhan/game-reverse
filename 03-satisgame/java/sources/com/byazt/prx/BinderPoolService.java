package com.byazt.prx;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION, 2236})
public class BinderPoolService extends Service {
    public Binder n = new n.BinderC0306n();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.n;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
