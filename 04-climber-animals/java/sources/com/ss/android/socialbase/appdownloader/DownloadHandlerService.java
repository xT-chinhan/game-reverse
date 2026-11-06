package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadHandlerService extends Service {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4547ms = "DownloadHandlerService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.ah.ms(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.ah.ms.ms()) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4547ms, "onStartCommand");
        }
        ms(intent);
        stopSelf();
        return 2;
    }

    private boolean ms(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.ah.d dVarXr = d.ch().xr();
        yu downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.ab.ms.ms(intExtra).xr("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.xr.ms().c(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            ms(downloadInfo, dVarXr, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            ms(this, downloadInfo, dVarXr, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            ms(this, downloadInfo, dVarXr, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.ab.ms.ms(intExtra).ms("no_hide_notification", 0) == 0) {
                if (!(com.ss.android.socialbase.downloader.ab.ms.ms(intExtra).xr("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.ss.android.socialbase.downloader.notification.xr.ms().ms(intExtra);
                    com.ss.android.socialbase.downloader.notification.xr.ms().c(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            xr(downloadInfo, dVarXr, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.xr.ms().ms(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void ms(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.ny.c.xr(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void ms(Context context, final com.ss.android.socialbase.appdownloader.ah.d dVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final yu downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (dVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfoMs;
                try {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.ah.k() == null || (packageInfoMs = ah.ms(downloadInfo, file)) == null) ? "" : packageInfoMs.packageName;
                            com.ss.android.socialbase.appdownloader.ah.d dVar2 = dVar;
                            if (dVar2 != null) {
                                dVar2.ms(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                            }
                            yu yuVar = downloadNotificationEventListener;
                            if (yuVar != null) {
                                yuVar.ms(3, downloadInfo, str, "");
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                    }
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                }
            }
        });
    }

    private void ms(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ah.d dVar, yu yuVar) {
        boolean zMs;
        int id = downloadInfo.getId();
        of ofVarZb = com.ss.android.socialbase.downloader.downloader.d.ms().zb(id);
        if (ofVarZb != null) {
            try {
                zMs = ofVarZb.ms(downloadInfo);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                zMs = false;
            }
        } else {
            zMs = false;
        }
        if (zMs) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.xr.ms().ms(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.ms(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (yuVar != null) {
            yuVar.ms(7, downloadInfo, "", "");
        }
    }

    private void xr(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ah.d dVar, yu yuVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.xr.ms().ms(id);
        downloadInfo.updateDownloadTime();
        if (dVar != null) {
            dVar.ms(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (yuVar != null) {
            yuVar.ms(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    private static void ms(Context context, int i, boolean z) {
        boolean zXr;
        of ofVarZb;
        if (!z || (ofVarZb = com.ss.android.socialbase.downloader.downloader.d.ms().zb(i)) == null) {
            zXr = false;
        } else {
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo != null) {
                    zXr = ofVarZb.xr(downloadInfo);
                } else {
                    zXr = false;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        if (!zXr && ah.ms(context, i, true) == 0) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    public static void ms(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ah.d dVar, yu yuVar) {
        com.ss.android.socialbase.downloader.notification.ms msVarKa;
        int id = downloadInfo.getId();
        of ofVarZb = com.ss.android.socialbase.downloader.downloader.d.ms().zb(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && ofVarZb != null && ah.ms(context, downloadInfo) && ofVarZb.ah(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.ab.ms.ms(id).xr("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                ms(com.ss.android.socialbase.downloader.downloader.ah.k(), id, true);
                ms(context, dVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.ab.ms.ms(id).ms("notification_click_install_auto_cancel", 1) != 0 || (msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(id)) == null) {
                    z = true;
                } else {
                    msVarKa.ab();
                    msVarKa.ms(-3, null, false, true);
                }
                if (z) {
                    com.ss.android.socialbase.downloader.notification.xr.ms().ms(id);
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.d.ms().ka(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    ah.ms(downloadInfo, true, false);
                }
                if (dVar != null) {
                    dVar.ms(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (yuVar != null) {
                    yuVar.ms(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                ms(context, downloadInfo);
                if (dVar != null) {
                    dVar.ms(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (yuVar != null) {
                    yuVar.ms(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
