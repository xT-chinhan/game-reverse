package com.byazt.lj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.byazt.lxs.DownloadNotificationService;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, PointerIconCompat.TYPE_NO_DROP})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String pr = DownloadReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.pr(pr, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            pr(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            hw(context, action);
        }
    }

    private void pr(final Context context, final String str) {
        if (!hn.e()) {
            return;
        }
        hn.pr(new Runnable() { // from class: com.byazt.lj.DownloadReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                        com.byazt.rnu.pr.pr().pr(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                }
            }
        }, 2000L, TimeUnit.MILLISECONDS);
    }

    private void hw(final Context context, final String str) {
        hn.pr(new Runnable() { // from class: com.byazt.lj.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                        com.byazt.rnu.pr.pr().pr(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
