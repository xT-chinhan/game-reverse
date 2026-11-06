package com.byazt.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.je.h;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 1111})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String n = "DownloadReceiver";
    public Handler qg = new Handler(Looper.getMainLooper());

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
            if (com.byazt.fe.n.n()) {
                com.byazt.fe.n.n(n, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            n(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.e.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.byazt.z.l lVarS = q.cp().s();
                    if (lVarS != null) {
                        lVarS.n(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && s.n(downloadInfo, schemeSpecificPart)) {
                                h downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.byazt.ta.w.w(downloadNotificationEventListener.n())) {
                                    downloadNotificationEventListener.n(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
                                if (nVarL != null) {
                                    nVarL.n((BaseException) null, false);
                                }
                                if (com.byazt.f.n.n(downloadInfo.getId()).n("install_queue_enable", 0) == 1) {
                                    x.n().n(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.qg.postDelayed(new Runnable() { // from class: com.byazt.e.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.e.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        com.byazt.ta.w.qg(downloadInfo);
                                                    }
                                                } catch (Throwable unused) {
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

    private void n(final Context context, final String str) {
        if (com.byazt.xv.s.an()) {
            com.byazt.xv.s.n(new Runnable() { // from class: com.byazt.e.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable unused) {
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }
}
