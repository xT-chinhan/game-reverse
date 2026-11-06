package com.byazt.ts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1941})
public class DownloadHandleService extends Service {
    public static final String pr = DownloadHandleService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.lj.hn.pr(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        pr(intent);
        return 2;
    }

    private void pr(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.ts.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.lj.x.pr().ho(intExtra);
                    } catch (Exception e) {
                    }
                }
            });
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            com.byazt.lj.x.pr().yb(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            com.byazt.lj.hn.hw();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
