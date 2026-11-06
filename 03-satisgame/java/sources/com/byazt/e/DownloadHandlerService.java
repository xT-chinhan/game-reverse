package com.byazt.e;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.byazt.je.h;
import com.byazt.je.lh;
import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 1532})
public class DownloadHandlerService extends Service {
    public static final String n = "DownloadHandlerService";

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
        if (com.byazt.fe.n.n()) {
            com.byazt.fe.n.qg(n, "onStartCommand");
        }
        n(com.byazt.xv.s.u(), intent);
        stopSelf();
        return 2;
    }

    private boolean n(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.byazt.z.l lVarS = q.cp().s();
        h downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.byazt.f.n.n(intExtra).qg("notification_opt_2") == 1) {
            com.byazt.av.qg.n().w(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            qg(context, downloadInfo, lVarS, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            n(context, downloadInfo, lVarS, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            n(context, downloadInfo, lVarS, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.byazt.f.n.n(intExtra).n("no_hide_notification", 0) == 0) {
                if (!(com.byazt.f.n.n(intExtra).qg("enable_notification_ui") >= 2 && downloadInfo.getStatus() == -1)) {
                    com.byazt.av.qg.n().n(intExtra);
                    com.byazt.av.qg.n().w(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            s(context, downloadInfo, lVarS, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.byazt.av.qg.n().n(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.e.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.byazt.xv.s.u()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception unused) {
                    }
                }
            });
            return true;
        }
        return false;
    }

    private static void n(Context context, DownloadInfo downloadInfo) {
        if (com.byazt.ta.w.qg(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void n(Context context, final com.byazt.z.l lVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final h downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (lVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.e.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfoN;
                try {
                    File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                    if (file.exists()) {
                        String str = (com.byazt.xv.s.u() == null || (packageInfoN = s.n(downloadInfo, file)) == null) ? "" : packageInfoN.packageName;
                        com.byazt.z.l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.n(downloadInfo.getId(), 3, str, -3, downloadInfo.getDownloadTime());
                        }
                        h hVar = downloadNotificationEventListener;
                        if (hVar != null) {
                            hVar.n(3, downloadInfo, str, "");
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private void qg(Context context, DownloadInfo downloadInfo, com.byazt.z.l lVar, h hVar) {
        boolean zN;
        int id = downloadInfo.getId();
        lh lhVarOa = com.byazt.xv.q.n().oa(id);
        if (lhVarOa != null) {
            try {
                zN = lhVarOa.n(downloadInfo);
            } catch (Throwable unused) {
                zN = false;
            }
        } else {
            zN = false;
        }
        if (zN) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
        com.byazt.av.qg.n().n(id);
        downloadInfo.updateDownloadTime();
        if (lVar != null) {
            lVar.n(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (hVar != null) {
            hVar.n(7, downloadInfo, "", "");
        }
    }

    private void s(Context context, DownloadInfo downloadInfo, com.byazt.z.l lVar, h hVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
        com.byazt.av.qg.n().n(id);
        downloadInfo.updateDownloadTime();
        if (lVar != null) {
            lVar.n(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (hVar != null) {
            hVar.n(7, downloadInfo, "", "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001c  */
    private static void n(Context context, int i, boolean z) {
        boolean zQg;
        lh lhVarOa;
        if (!z || (lhVarOa = com.byazt.xv.q.n().oa(i)) == null) {
            zQg = false;
        } else {
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo != null) {
                    zQg = lhVarOa.qg(downloadInfo);
                } else {
                    zQg = false;
                }
            } catch (Throwable unused) {
            }
        }
        if (!zQg && s.n(context, i, true) == 0) {
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    public static void n(Context context, DownloadInfo downloadInfo, com.byazt.z.l lVar, h hVar) {
        com.byazt.av.n nVarL;
        int id = downloadInfo.getId();
        lh lhVarOa = com.byazt.xv.q.n().oa(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && lhVarOa != null && s.n(context, downloadInfo) && lhVarOa.s(downloadInfo)) {
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.byazt.f.n.n(id).qg("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                n(com.byazt.xv.s.u(), id, true);
                n(context, lVar, downloadInfo);
                if (com.byazt.f.n.n(id).n("notification_click_install_auto_cancel", 1) != 0 || (nVarL = com.byazt.av.qg.n().l(id)) == null) {
                    z = true;
                } else {
                    nVarL.x();
                    nVarL.n(-3, null, false, true);
                }
                if (z) {
                    com.byazt.av.qg.n().n(id);
                }
                break;
            case -2:
                if (com.byazt.xv.q.n().l(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    s.n(downloadInfo, true, false);
                }
                if (lVar != null) {
                    lVar.n(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (hVar != null) {
                    hVar.n(6, downloadInfo, "", "");
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                n(context, downloadInfo);
                if (lVar != null) {
                    lVar.n(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (hVar != null) {
                    hVar.n(5, downloadInfo, "", "");
                }
                break;
        }
    }
}
