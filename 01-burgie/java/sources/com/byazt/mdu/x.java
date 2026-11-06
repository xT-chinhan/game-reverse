package com.byazt.mdu;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.auw.DownloadTask;
import com.byazt.ewn.AbsServerManager;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.IDownloadListener;
import com.byazt.fn.b;
import com.byazt.fn.g;
import com.byazt.fn.gz;
import com.byazt.fn.m;
import com.byazt.fn.ww;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.ts.lb;
import com.byazt.zkm.aj;
import com.byazt.zkm.ho;
import com.byazt.zkm.w;
import com.byazt.zkm.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 121})
public class x {
    public ww a;
    public Future aj;
    public ho cz;
    public com.byazt.zkm.c g;
    public String hn;
    public aj ho;
    public w lb;
    public com.byazt.zkm.x m;
    public zo nt;
    public com.byazt.zkm.hn ny;
    public gz qa;
    public int vk;
    public String x;
    public com.byazt.zkm.fw yb;
    public static final String pr = x.class.getSimpleName();
    public static volatile x hw = null;
    public static boolean uc = false;
    public static boolean fw = false;
    public static boolean zo = false;
    public DownloadReceiver c = new DownloadReceiver();
    public boolean w = false;
    public boolean k = false;

    public com.byazt.zkm.hn pr() {
        return this.ny;
    }

    public void pr(com.byazt.zkm.hn hnVar) {
        this.ny = hnVar;
    }

    public com.byazt.zkm.x hw() {
        return this.m;
    }

    public com.byazt.zkm.c hn() {
        return this.g;
    }

    public aj x() {
        return this.ho;
    }

    public void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.x = str;
    }

    public String c() {
        return this.x;
    }

    public com.byazt.zkm.fw uc() {
        return this.yb;
    }

    public void pr(com.byazt.zkm.fw fwVar) {
        this.yb = fwVar;
    }

    public boolean fw() {
        return com.byazt.ew.pr.hw().optInt("package_flag_config", 1) == 1;
    }

    public w zo() {
        return this.lb;
    }

    public void pr(w wVar) {
        this.lb = wVar;
    }

    public File aj() {
        return Downloader.getInstance(com.byazt.lj.hn.of()).getGlobalSaveDir();
    }

    public String vk() {
        return this.hn;
    }

    private x() {
    }

    public static x w() {
        if (hw == null) {
            synchronized (x.class) {
                if (hw == null) {
                    hw = new x();
                }
            }
        }
        return hw;
    }

    @Deprecated
    public void pr(Context context, String str, com.byazt.zkm.x xVar, com.byazt.zkm.c cVar, aj ajVar) {
        if (xVar != null) {
            this.m = xVar;
        }
        if (cVar != null) {
            this.g = cVar;
        }
        if (ajVar != null) {
            this.ho = ajVar;
        }
        hn(context);
    }

    private void hn(Context context) {
        if (context != null && !uc) {
            com.byazt.mrs.c.pr(AdBaseConstants.MIME_APK);
            com.byazt.lj.hn.pr(context);
            com.byazt.lj.hn.pr(new com.byazt.lkw.hw());
            if (this.k) {
                com.byazt.lj.hn.pr(new Runnable() { // from class: com.byazt.mdu.x.1
                    @Override // java.lang.Runnable
                    public void run() {
                        x.this.qa();
                    }
                }, 5L, TimeUnit.SECONDS);
            } else {
                qa();
            }
            a();
            uc = true;
        }
    }

    public void hw(String str) {
        Downloader.getInstance(com.byazt.lj.hn.of()).setDefaultSavePath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        synchronized (this.c) {
            if (fw) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.byazt.lj.hn.of().registerReceiver(this.c, intentFilter);
                com.byazt.lj.hn.of().registerReceiver(this.c, intentFilter2);
                fw = true;
            } catch (Exception e) {
            }
            com.byazt.p000do.pr.hw(pr, "registerDownloadReceiver mIsRegistered:" + fw);
        }
    }

    public void k() {
        if (com.byazt.ew.pr.hn().pr("enable_app_install_receiver", 1) <= 0) {
            com.byazt.p000do.pr.hw(pr, "disable app install receiver");
            return;
        }
        synchronized (this.c) {
            try {
                if (!zo) {
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
                        com.byazt.lj.hn.of().registerReceiver(this.c, intentFilter);
                        zo = true;
                        ho hoVar = this.cz;
                        if (hoVar != null) {
                            hoVar.pr();
                        }
                    } catch (Throwable th) {
                    }
                    hw(0);
                    com.byazt.p000do.pr.hw(pr, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + fw);
                    return;
                }
                hw(0);
            } catch (Throwable th2) {
                hw(0);
                throw th2;
            }
        }
    }

    private void hw(int i) {
        this.vk = com.byazt.ew.pr.hn().pr("app_install_keep_receiver_time_s", 60);
        com.byazt.p000do.pr.hw(pr, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.vk);
        if (this.vk <= 0) {
            return;
        }
        if (i > 0) {
            this.vk = i;
        }
        Future future = this.aj;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
            }
        }
        this.aj = com.byazt.lj.hn.pr(new Runnable() { // from class: com.byazt.mdu.x.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.p000do.pr.hw(x.pr, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                x.this.m();
                x.this.qa();
            }
        }, this.vk, TimeUnit.SECONDS);
    }

    public void m() {
        ho hoVar;
        synchronized (this.c) {
            try {
                if (fw) {
                    com.byazt.lj.hn.of().unregisterReceiver(this.c);
                    if (zo && (hoVar = this.cz) != null) {
                        hoVar.hw();
                    }
                }
            } catch (Exception e) {
            }
            fw = false;
            zo = false;
        }
        com.byazt.p000do.pr.hw(pr, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 21) {
            lb.pr(new lb.hw() { // from class: com.byazt.mdu.x.3
                @Override // com.byazt.ts.lb.hw
                public void pr(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.pr(downloadInfo, j, z, i);
                }
            });
        }
    }

    public static boolean pr(Context context, int i) {
        return hn.pr(context, i, true) == 1;
    }

    public void pr(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    hn.pr(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
        }
    }

    public int pr(c cVar) {
        String strSubstring;
        String str;
        String strHw;
        boolean z;
        IDownloadListener hwVar;
        g gVar;
        int i;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (cVar != null && cVar.getContext() != null) {
            try {
                List<com.byazt.auw.hn> listPr = pr(cVar.x());
                String strPr = cVar.pr();
                if (TextUtils.isEmpty(strPr)) {
                    return 0;
                }
                final int iQa = cVar.qa();
                final boolean z2 = iQa == 0;
                String strV = cVar.v();
                final String strHw2 = cVar.hw();
                if (TextUtils.isEmpty(strV)) {
                    strV = hn.pr(strPr, strHw2, cVar.k(), z2);
                }
                if (strV.length() <= 255) {
                    strSubstring = strV;
                } else {
                    strSubstring = strV.substring(strV.length() - 255);
                }
                if (TextUtils.isEmpty(strHw2)) {
                    strHw2 = strSubstring;
                }
                String strK = cVar.k();
                if (strSubstring.endsWith(".apk") && !hn.hn(cVar.k())) {
                    str = AdBaseConstants.MIME_APK;
                } else {
                    str = strK;
                }
                String strHn = cVar.hn();
                if (!TextUtils.isEmpty(cVar.hn())) {
                    strHw = strHn;
                } else {
                    strHw = hn.hw();
                }
                if (!TextUtils.isEmpty(strHw) && !TextUtils.isEmpty(strSubstring)) {
                    String strHs = cVar.hs();
                    if (TextUtils.isEmpty(strHs)) {
                        strHs = strPr;
                    }
                    int iPr = com.byazt.lj.hn.pr(strHs, strHw);
                    if (com.byazt.ew.pr.pr(cVar.sv()).pr("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.byazt.lj.hn.of()).getDownloadInfo(iPr)) != null) {
                        try {
                            cVar.pr(new JSONObject(downloadInfo.getDownloadSettingString()));
                        } catch (Throwable th) {
                        }
                    }
                    com.byazt.ew.pr.pr(iPr, cVar.sv());
                    boolean zEr = cVar.er();
                    if (com.byazt.ew.pr.pr(iPr).pr("modify_force", 1) == 1 && !zEr && com.byazt.tuy.uc.x(strHw, strSubstring) && Downloader.getInstance(cVar.getContext()).getDownloadInfo(iPr) == null) {
                        z = true;
                    } else {
                        z = zEr;
                    }
                    IDownloadListener iDownloadListenerVk = cVar.vk();
                    if (iDownloadListenerVk == null && (cVar.c() || cVar.uc())) {
                        if (cVar.g() != null) {
                            hwVar = new com.byazt.owr.hw(cVar.g());
                            iPr = iPr;
                            strHw = strHw;
                            str = str;
                        } else {
                            iPr = iPr;
                            strHw = strHw;
                            str = str;
                            hwVar = new com.byazt.owr.hw(cVar.getContext(), iPr, strHw2, strHw, strSubstring, cVar.w());
                        }
                    } else {
                        hwVar = iDownloadListenerVk;
                    }
                    g gVarQn = cVar.qn();
                    if (gVarQn == null) {
                        gVar = new g() { // from class: com.byazt.mdu.x.4
                            @Override // com.byazt.fn.g
                            public void pr(DownloadInfo downloadInfo2, BaseException baseException, int i2) {
                                if (x.this.ho != null) {
                                    x.this.ho.pr(downloadInfo2, baseException, i2);
                                }
                            }
                        };
                    } else {
                        gVar = gVarQn;
                    }
                    List<m> listVe = com.byazt.lj.hn.ve();
                    if (!listVe.isEmpty()) {
                        Iterator<m> it = listVe.iterator();
                        while (it.hasNext()) {
                            cVar.pr(it.next());
                        }
                    }
                    String strW = cVar.w();
                    try {
                        if (!TextUtils.isEmpty(strW)) {
                            jSONObject = new JSONObject(strW);
                        } else {
                            jSONObject = new JSONObject();
                        }
                        jSONObject.put("auto_install_with_notification", cVar.fw());
                        jSONObject.put("auto_install_without_notification", cVar.uc());
                        strW = jSONObject.toString();
                    } catch (Throwable th2) {
                    }
                    boolean z3 = cVar.c() || cVar.uc();
                    if (!z3 || com.byazt.ew.pr.pr(iPr).hw("enable_notification_ui") <= 0) {
                        i = iPr;
                    } else {
                        i = iPr;
                        com.byazt.owr.hn.pr().pr(i, cVar.od());
                    }
                    final DownloadTask autoInstall = Downloader.with(cVar.getContext()).url(strPr).backUpUrls(cVar.vj()).name(strSubstring).title(strHw2).savePath(strHw).onlyWifi(cVar.zo()).extraHeaders(listPr).depend(gVar).retryCount(cVar.fo()).backUpUrlRetryCount(cVar.rc()).showNotification(z3).extra(strW).mimeType(str).minProgressTimeMsInterval(cVar.nl()).maxProgressCount(cVar.y()).mainThreadListener(cVar.aj()).notificationListener(hwVar).notificationEventListener(pr(cVar.of())).force(z).autoResumed(cVar.yb()).showNotificationForAutoResumed(cVar.lb()).chunkStategy(cVar.ho()).chunkAdjustCalculator(cVar.nt()).needHttpsToHttpRetry(cVar.m()).packageName(cVar.a()).md5(cVar.cz()).expectFileLength(cVar.ny()).needRetryDelay(cVar.z()).retryDelayTimeArray(cVar.b()).needDefaultHttpServiceBackUp(cVar.iu()).needReuseFirstConnection(cVar.ve()).needReuseChunkRunnable(cVar.ww()).needIndependentProcess(cVar.n()).enqueueType(cVar.ls()).monitorDepend(cVar.qi()).retryDelayTimeCalculator(cVar.gz()).headConnectionAvailable(cVar.e()).fileUriProvider(cVar.ii()).diskSpaceHandler(cVar.mw()).needChunkDowngradeRetry(cVar.s()).notificationClickCallback(cVar.i()).downloadSetting(cVar.sv()).iconUrl(cVar.od()).needSDKMonitor(cVar.f()).monitorScene(cVar.bm()).extraMonitorStatus(cVar.jn()).executorGroup(cVar.ie()).throttleNetSpeed(cVar.o()).distinctDirectory(cVar.l()).taskKey(cVar.hs()).setAutoInstall(cVar.lv());
                    if (autoInstall != null && !cVar.r().isEmpty()) {
                        autoInstall.setDownloadCompleteHandlers(cVar.r());
                    }
                    if (autoInstall != null) {
                        if (z3 && cVar.nw() && cVar.getActivity() != null && !cVar.getActivity().isFinishing() && !com.byazt.owr.x.pr()) {
                            com.byazt.owr.x.pr(cVar.getActivity(), new com.byazt.zkm.g() { // from class: com.byazt.mdu.x.5
                                @Override // com.byazt.zkm.g
                                public void pr() {
                                    com.byazt.p000do.pr.hw(x.pr, "notification permission granted, start download :" + strHw2);
                                    x.this.pr(autoInstall, iQa, z2);
                                }

                                @Override // com.byazt.zkm.g
                                public void hw() {
                                    com.byazt.p000do.pr.hw(x.pr, "notification permission denied, start download :" + strHw2);
                                    x.this.pr(autoInstall, iQa, z2);
                                }
                            });
                        } else {
                            com.byazt.p000do.pr.hw(pr, "notification permission need not request, start download :".concat(String.valueOf(strHw2)));
                            com.byazt.owr.x.pr(i);
                            pr(autoInstall, iQa, z2);
                            autoInstall.getDownloadInfo();
                        }
                    }
                    return i;
                }
                return 0;
            } catch (Throwable th3) {
                com.byazt.cha.pr.pr(cVar.qi(), (DownloadInfo) null, new BaseException(1003, com.byazt.tuy.uc.hw(th3, "addDownloadTask")), 0);
                com.byazt.p000do.pr.c(pr, String.format("add download task error:%s", th3));
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo != null && z) {
            downloadInfo.setSavePathRedirected(z);
        }
    }

    private List<com.byazt.auw.hn> pr(List<com.byazt.auw.hn> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.byazt.auw.hn hnVar : list) {
                if (hnVar != null && !TextUtils.isEmpty(hnVar.pr()) && !TextUtils.isEmpty(hnVar.hw())) {
                    if (hnVar.pr().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.byazt.auw.hn(hnVar.pr(), hnVar.hw()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.byazt.auw.hn("User-Agent", com.byazt.up.pr.pr));
        }
        return arrayList;
    }

    public String pr(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.endsWith(".apk") && !hn.hn(str2)) {
            return AdBaseConstants.MIME_APK;
        }
        return str2;
    }

    private b pr(final com.byazt.zkm.uc ucVar) {
        if (ucVar == null) {
            return null;
        }
        return new b() { // from class: com.byazt.mdu.x.6
            @Override // com.byazt.fn.b
            public void pr(int i, DownloadInfo downloadInfo, String str, String str2) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                        downloadInfo.getStatus();
                        downloadInfo.getDownloadTime();
                        break;
                    case 8:
                        downloadInfo.getPackageName();
                        break;
                    case 9:
                        com.byazt.lj.hn.of();
                        break;
                }
            }

            @Override // com.byazt.fn.b
            public boolean pr(boolean z) {
                return ucVar.pr(z);
            }

            @Override // com.byazt.fn.b
            public String pr() {
                return ucVar.pr();
            }
        };
    }

    public DownloadInfo pr(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            DownloadInfo downloadInfoPr = pr(context, str, aj());
            if (downloadInfoPr == null) {
                downloadInfoPr = pr(context, str, com.byazt.mg.hw.pr(context, Environment.DIRECTORY_DOWNLOADS));
            }
            if (downloadInfoPr == null) {
                downloadInfoPr = pr(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
            }
            if (downloadInfoPr == null) {
                downloadInfoPr = pr(context, str, com.byazt.mg.hw.pr(context));
            }
            boolean zPr = com.byazt.ew.pr.hn().pr("get_download_info_by_list");
            if (downloadInfoPr == null && zPr) {
                return hw(context, str);
            }
            return downloadInfoPr;
        } catch (Throwable th) {
            com.byazt.p000do.pr.hw(pr, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            return null;
        }
    }

    private DownloadInfo pr(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private DownloadInfo hw(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public List<DownloadInfo> pr(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public List<DownloadInfo> hw(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public zo g() {
        return this.nt;
    }

    public void pr(zo zoVar) {
        this.nt = zoVar;
    }

    public com.byazt.lj.lb ho() {
        return Downloader.getInstance(com.byazt.lj.hn.of()).getReserveWifiStatusListener();
    }

    public void pr(com.byazt.lj.lb lbVar) {
        Downloader.getInstance(com.byazt.lj.hn.of()).setReserveWifiStatusListener(lbVar);
    }

    public void pr(gz gzVar) {
        this.qa = gzVar;
    }

    public gz nt() {
        return this.qa;
    }

    public void pr(ww wwVar) {
        this.a = wwVar;
    }

    public ww yb() {
        return this.a;
    }

    public void pr(int i) {
        if (com.byazt.ew.pr.hn().pr("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        k();
        hw(i);
    }

    public void pr(ho hoVar) {
        this.cz = hoVar;
    }
}
