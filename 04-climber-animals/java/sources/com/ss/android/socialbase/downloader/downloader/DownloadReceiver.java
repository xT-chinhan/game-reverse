package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.basead.exoplayer.i.a;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4652ms = "DownloadReceiver";

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
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.ms(f4652ms, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            ms(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            xr(context, action);
        }
    }

    private void ms(final Context context, final String str) {
        if (ah.jw()) {
            ah.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                }
            }, a.f, TimeUnit.MILLISECONDS);
        }
    }

    private void xr(final Context context, final String str) {
        ah.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                }
            }
        });
    }
}
