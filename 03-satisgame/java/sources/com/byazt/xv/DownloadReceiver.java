package com.byazt.xv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.av.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 41, 1111})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String n = "DownloadReceiver";

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
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.n(n, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            n(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            qg(context, action);
        }
    }

    private void n(final Context context, final String str) {
        if (s.an()) {
            s.n(new Runnable() { // from class: com.byazt.xv.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                            com.byazt.xj.n.n().n(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    private void qg(final Context context, final String str) {
        s.n(new Runnable() { // from class: com.byazt.xv.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                        com.byazt.xj.n.n().n(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
