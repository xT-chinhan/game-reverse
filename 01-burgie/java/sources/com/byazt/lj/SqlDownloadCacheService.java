package com.byazt.lj;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 1670})
public class SqlDownloadCacheService extends Service {
    public static final String pr = SqlDownloadCacheService.class.getSimpleName();

    public static void pr(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        hn.pr(getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a aVarUc;
        vk vkVarZ = hn.z();
        if (vkVarZ instanceof com.byazt.ts.x) {
            aVarUc = ((com.byazt.ts.x) vkVarZ).uc();
        } else if (!(vkVarZ instanceof a)) {
            aVarUc = null;
        } else {
            aVarUc = (a) vkVarZ;
        }
        if (aVarUc instanceof IBinder) {
            return (IBinder) aVarUc;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (hn.vk()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
