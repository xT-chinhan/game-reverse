package com.byazt.mdu;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.auw.DownloadInfo;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.b;
import com.byazt.fn.y;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 1414})
public class DownloadHandlerService extends Service {
    public static final String pr = DownloadHandlerService.class.getSimpleName();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.byazt.lj.hn.pr(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.byazt.p000do.pr.pr()) {
            com.byazt.p000do.pr.hw(pr, "onStartCommand");
        }
        pr(com.byazt.lj.hn.of(), intent);
        stopSelf();
        return 2;
    }

    private boolean pr(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.byazt.zkm.c cVarHn = x.w().hn();
        b downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && com.byazt.ew.pr.pr(intExtra).hw("notification_opt_2") == 1) {
            com.byazt.lxs.hw.pr().uc(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            hw(context, downloadInfo, cVarHn, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            pr(context, downloadInfo, cVarHn, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            pr(context, downloadInfo, cVarHn, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.byazt.ew.pr.pr(intExtra).pr("no_hide_notification", 0) == 0) {
                if (com.byazt.ew.pr.pr(intExtra).hw("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1) {
                    z = false;
                }
                if (!z) {
                    com.byazt.lxs.hw.pr().pr(intExtra);
                    com.byazt.lxs.hw.pr().uc(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            hn(context, downloadInfo, cVarHn, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.byazt.lxs.hw.pr().pr(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.mdu.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.byazt.lj.hn.of()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void pr(Context context, DownloadInfo downloadInfo) {
        if (com.byazt.tuy.uc.hw(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void pr(Context context, final com.byazt.zkm.c cVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final b downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (cVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.mdu.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                PackageInfo packageInfoPr;
                try {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        try {
                            if (com.byazt.lj.hn.of() == null || (packageInfoPr = hn.pr(downloadInfo, file)) == null) {
                                str = "";
                            } else {
                                str = packageInfoPr.packageName;
                            }
                            com.byazt.zkm.c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.pr(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                            }
                            b bVar = downloadNotificationEventListener;
                            if (bVar != null) {
                                bVar.pr(3, downloadInfo, str, "");
                            }
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                }
            }
        });
    }

    private void hw(Context context, DownloadInfo downloadInfo, com.byazt.zkm.c cVar, b bVar) {
        boolean zPr;
        int id = downloadInfo.getId();
        y yVarM = com.byazt.lj.x.pr().m(id);
        if (yVarM != null) {
            try {
                zPr = yVarM.pr(downloadInfo);
            } catch (Throwable th) {
                zPr = false;
            }
        } else {
            zPr = false;
        }
        if (!zPr) {
            Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
            intent.putExtra("extra_click_download_ids", id);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(intent);
            com.byazt.lxs.hw.pr().pr(id);
            downloadInfo.updateDownloadTime();
            if (cVar != null) {
                cVar.pr(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
            if (bVar != null) {
                bVar.pr(7, downloadInfo, "", "");
            }
        }
    }

    private void hn(Context context, DownloadInfo downloadInfo, com.byazt.zkm.c cVar, b bVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
        com.byazt.lxs.hw.pr().pr(id);
        downloadInfo.updateDownloadTime();
        if (cVar != null) {
            cVar.pr(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (bVar != null) {
            bVar.pr(7, downloadInfo, "", "");
        }
    }

    private static void pr(Context context, int i, boolean z) {
        boolean zHw;
        y yVarM;
        if (z && (yVarM = com.byazt.lj.x.pr().m(i)) != null) {
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo == null) {
                    zHw = false;
                } else {
                    zHw = yVarM.hw(downloadInfo);
                }
            } catch (Throwable th) {
                zHw = false;
            }
        } else {
            zHw = false;
        }
        if (!zHw && hn.pr(context, i, true) == 0) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void pr(Context context, DownloadInfo downloadInfo, com.byazt.zkm.c cVar, b bVar) {
        com.byazt.lxs.pr prVarC;
        int id = downloadInfo.getId();
        y yVarM = com.byazt.lj.x.pr().m(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && yVarM != null && hn.pr(context, downloadInfo) && yVarM.hn(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.byazt.ew.pr.pr(id).hw("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                pr(com.byazt.lj.hn.of(), id, true);
                pr(context, cVar, downloadInfo);
                if (com.byazt.ew.pr.pr(id).pr("notification_click_install_auto_cancel", 1) == 0 && (prVarC = com.byazt.lxs.hw.pr().c(id)) != null) {
                    prVarC.fw();
                    prVarC.pr(-3, null, false, true);
                } else {
                    z = true;
                }
                if (z) {
                    com.byazt.lxs.hw.pr().pr(id);
                }
                break;
            case -2:
                if (com.byazt.lj.x.pr().c(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    hn.pr(downloadInfo, true, false);
                }
                if (cVar != null) {
                    cVar.pr(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (bVar != null) {
                    bVar.pr(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                pr(context, downloadInfo);
                if (cVar != null) {
                    cVar.pr(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (bVar != null) {
                    bVar.pr(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
