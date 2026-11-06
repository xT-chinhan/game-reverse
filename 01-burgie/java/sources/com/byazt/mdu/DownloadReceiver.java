package com.byazt.mdu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.b;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, PointerIconCompat.TYPE_NO_DROP})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String pr = DownloadReceiver.class.getSimpleName();
    public Handler hw = new Handler(Looper.getMainLooper());

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
            if (com.byazt.p000do.pr.pr()) {
                com.byazt.p000do.pr.pr(pr, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            pr(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.mdu.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.byazt.zkm.c cVarHn = x.w().hn();
                    if (cVarHn != null) {
                        cVarHn.pr(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && hn.pr(downloadInfo, schemeSpecificPart)) {
                                b downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.byazt.tuy.uc.uc(downloadNotificationEventListener.pr())) {
                                    downloadNotificationEventListener.pr(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
                                if (prVarC != null) {
                                    prVarC.pr((BaseException) null, false);
                                }
                                if (com.byazt.ew.pr.pr(downloadInfo.getId()).pr("install_queue_enable", 0) == 1) {
                                    fw.pr().pr(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.hw.postDelayed(new Runnable() { // from class: com.byazt.mdu.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.mdu.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        com.byazt.tuy.uc.hw(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
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

    private void pr(final Context context, final String str) {
        if (!com.byazt.lj.hn.e()) {
            return;
        }
        com.byazt.lj.hn.pr(new Runnable() { // from class: com.byazt.mdu.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th) {
                }
            }
        }, 2000L, TimeUnit.MILLISECONDS);
    }
}
