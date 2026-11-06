package com.byazt.i;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 2153})
public class DownloadHandleService extends Service {
    public static final String n = "DownloadHandleService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.xv.s.n(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        n(intent);
        return 2;
    }

    private void n(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.i.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.xv.q.n().k(intExtra);
                    } catch (Exception unused) {
                    }
                }
            });
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            com.byazt.xv.q.n().hd(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            com.byazt.xv.s.qg();
        }
    }
}
