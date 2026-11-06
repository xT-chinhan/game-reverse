package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.basead.exoplayer.i.a;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4550ms = "DownloadReceiver";
    private Handler xr = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
                com.ss.android.socialbase.downloader.ah.ms.ms(f4550ms, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            ms(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.ss.android.socialbase.appdownloader.ah.d dVarXr = d.ch().xr();
                    if (dVarXr != null) {
                        dVarXr.ms(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && ah.ms(downloadInfo, schemeSpecificPart)) {
                                yu downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.ss.android.socialbase.downloader.ny.c.c(downloadNotificationEventListener.ms())) {
                                    downloadNotificationEventListener.ms(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
                                if (msVarKa != null) {
                                    msVarKa.ms((BaseException) null, false);
                                }
                                if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("install_queue_enable", 0) == 1) {
                                    x.ms().ms(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.xr.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        com.ss.android.socialbase.downloader.ny.c.xr(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
                                                    com.bytedance.sdk.openadsdk.api.ab.ms(th);
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void ms(final Context context, final String str) {
        if (com.ss.android.socialbase.downloader.downloader.ah.jw()) {
            com.ss.android.socialbase.downloader.downloader.ah.ms(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                }
            }, a.f, TimeUnit.MILLISECONDS);
        }
    }
}
