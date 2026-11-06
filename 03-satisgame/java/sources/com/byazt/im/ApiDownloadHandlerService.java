package com.byazt.im;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 147, 2489})
public class ApiDownloadHandlerService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s sVarN = s.n();
        if (sVarN != null) {
            HashMap map = new HashMap();
            map.put(com.anythink.core.common.s.a, this);
            sVarN.n(map, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        s sVarN = s.n();
        if (sVarN != null) {
            HashMap map = new HashMap();
            map.put("i", intent);
            map.put("c", this);
            sVarN.n(map, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME);
        }
        stopSelf();
        return 2;
    }
}
