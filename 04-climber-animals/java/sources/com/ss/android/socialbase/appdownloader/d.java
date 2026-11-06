package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.anythink.dlopt.common.a.a;
import com.ss.android.socialbase.appdownloader.ah.ch;
import com.ss.android.socialbase.appdownloader.ah.ub;
import com.ss.android.socialbase.appdownloader.ah.zb;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.cv;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.qv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static boolean ab = false;
    private static boolean c = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4570ms = "d";
    private static boolean x = false;
    private static volatile d xr;
    private String ah;
    private com.ss.android.socialbase.appdownloader.ah.ab ao;
    private ub b;
    private int ch;
    private String d;
    private zb h;
    private p nw;
    private Future ny;
    private com.ss.android.socialbase.appdownloader.ah.c qv;
    private cv t;
    private com.ss.android.socialbase.appdownloader.ah.d u;
    private com.ss.android.socialbase.appdownloader.ah.x ub;
    private ch y;
    private com.ss.android.socialbase.appdownloader.ah.ah zb;
    private DownloadReceiver ka = new DownloadReceiver();
    private boolean hi = false;
    private boolean sl = false;

    public com.ss.android.socialbase.appdownloader.ah.ah ms() {
        return this.zb;
    }

    public com.ss.android.socialbase.appdownloader.ah.d xr() {
        return this.u;
    }

    public com.ss.android.socialbase.appdownloader.ah.x ah() {
        return this.ub;
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public com.ss.android.socialbase.appdownloader.ah.c ka() {
        return this.qv;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.ab.ms.xr().optInt("package_flag_config", 1) == 1;
    }

    public ch ab() {
        return this.y;
    }

    public void ms(ch chVar) {
        this.y = chVar;
    }

    public File x() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getGlobalSaveDir();
    }

    public String ny() {
        return this.ah;
    }

    private d() {
    }

    public static d ch() {
        if (xr == null) {
            synchronized (d.class) {
                if (xr == null) {
                    xr = new d();
                }
            }
        }
        return xr;
    }

    @Deprecated
    public void ms(Context context, String str, com.ss.android.socialbase.appdownloader.ah.ah ahVar, com.ss.android.socialbase.appdownloader.ah.d dVar, com.ss.android.socialbase.appdownloader.ah.x xVar) {
        if (ahVar != null) {
            this.zb = ahVar;
        }
        if (dVar != null) {
            this.u = dVar;
        }
        if (xVar != null) {
            this.ub = xVar;
        }
        ah(context);
    }

    private void ah(Context context) {
        if (context == null || c) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.ka.ms("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.ah.ms(context);
        com.ss.android.socialbase.downloader.downloader.ah.ms(new com.ss.android.socialbase.appdownloader.d.xr());
        if (this.sl) {
            com.ss.android.socialbase.downloader.downloader.ah.ms(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.y();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            y();
        }
        t();
        c = true;
    }

    public void xr(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).setDefaultSavePath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        synchronized (this.ka) {
            if (ab) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.ss.android.socialbase.downloader.downloader.ah.k().registerReceiver(this.ka, intentFilter);
                com.ss.android.socialbase.downloader.downloader.ah.k().registerReceiver(this.ka, intentFilter2);
                ab = true;
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "registerDownloadReceiver mIsRegistered:" + ab);
        }
    }

    public void hi() {
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "disable app install receiver");
            return;
        }
        synchronized (this.ka) {
            try {
                if (!x) {
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        intentFilter.addDataScheme("package");
                        com.ss.android.socialbase.downloader.downloader.ah.k().registerReceiver(this.ka, intentFilter);
                        x = true;
                        ub ubVar = this.b;
                        if (ubVar != null) {
                            ubVar.ms();
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(th);
                    }
                    xr(0);
                    com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + ab);
                    return;
                }
                xr(0);
            } catch (Throwable th2) {
                xr(0);
                throw th2;
            }
        }
    }

    private void xr(int i) {
        this.ch = com.ss.android.socialbase.downloader.ab.ms.ah().ms("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.ch);
        if (this.ch <= 0) {
            return;
        }
        if (i > 0) {
            this.ch = i;
        }
        Future future = this.ny;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        }
        this.ny = com.ss.android.socialbase.downloader.downloader.ah.ms(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.ah.ms.xr(d.f4570ms, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                d.this.sl();
                d.this.y();
            }
        }, this.ch, TimeUnit.SECONDS);
    }

    public void sl() {
        ub ubVar;
        synchronized (this.ka) {
            try {
                if (ab) {
                    com.ss.android.socialbase.downloader.downloader.ah.k().unregisterReceiver(this.ka);
                    if (x && (ubVar = this.b) != null) {
                        ubVar.xr();
                    }
                    ab = false;
                    x = false;
                } else {
                    ab = false;
                    x = false;
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            throw th;
        }
        com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    private void t() {
        qv.ms(new qv.xr() { // from class: com.ss.android.socialbase.appdownloader.d.3
            @Override // com.ss.android.socialbase.downloader.impls.qv.xr
            public void ms(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.ms(downloadInfo, j, z, i);
            }
        });
    }

    public static boolean ms(Context context, int i) {
        return ah.ms(context, i, true) == 1;
    }

    public void ms(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    ah.ms(context, i, true);
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
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    public int ms(c cVar) {
        int i;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (cVar == null || cVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.model.ah> listMs = ms(cVar.d());
            String strMs = cVar.ms();
            if (TextUtils.isEmpty(strMs)) {
                return 0;
            }
            final int iY = cVar.y();
            final boolean z = iY == 0;
            String strM = cVar.m();
            final String strXr = cVar.xr();
            if (TextUtils.isEmpty(strM)) {
                strM = ah.ms(strMs, strXr, cVar.sl(), z);
            }
            if (strM.length() > 255) {
                strM = strM.substring(strM.length() - 255);
            }
            if (TextUtils.isEmpty(strXr)) {
                strXr = strM;
            }
            String strSl = cVar.sl();
            if (strM.endsWith(a.h) && !ah.ah(cVar.sl())) {
                strSl = "application/vnd.android.package-archive";
            }
            String strAh = cVar.ah();
            if (TextUtils.isEmpty(cVar.ah())) {
                strAh = ah.xr();
            }
            String str = strAh;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strM)) {
                String strIl = cVar.il();
                if (TextUtils.isEmpty(strIl)) {
                    strIl = strMs;
                }
                int iMs = com.ss.android.socialbase.downloader.downloader.ah.ms(strIl, str);
                if (com.ss.android.socialbase.downloader.ab.ms.ms(cVar.rt()).ms("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getDownloadInfo(iMs)) != null) {
                    try {
                        cVar.ms(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.ab.ms.ms(iMs, cVar.rt());
                boolean zAz = cVar.az();
                boolean z2 = (com.ss.android.socialbase.downloader.ab.ms.ms(iMs).ms("modify_force", 1) == 1 && !zAz && com.ss.android.socialbase.downloader.ny.c.d(str, strM) && Downloader.getInstance(cVar.getContext()).getDownloadInfo(iMs) == null) ? true : zAz;
                IDownloadListener iDownloadListenerCh = cVar.ch();
                if (iDownloadListenerCh == null && (cVar.ka() || cVar.c())) {
                    if (cVar.u() != null) {
                        iDownloadListenerCh = new com.ss.android.socialbase.appdownloader.ka.xr(cVar.u());
                    } else {
                        iDownloadListenerCh = new com.ss.android.socialbase.appdownloader.ka.xr(cVar.getContext(), iMs, strXr, str, strM, cVar.hi());
                    }
                }
                u uVarE = cVar.e();
                if (uVarE == null) {
                    uVarE = new u() { // from class: com.ss.android.socialbase.appdownloader.d.4
                        @Override // com.ss.android.socialbase.downloader.depend.u
                        public void ms(DownloadInfo downloadInfo2, BaseException baseException, int i2) {
                            if (d.this.ub != null) {
                                d.this.ub.ms(downloadInfo2, baseException, i2);
                            }
                        }
                    };
                }
                List<com.ss.android.socialbase.downloader.depend.zb> listLe = com.ss.android.socialbase.downloader.downloader.ah.le();
                if (!listLe.isEmpty()) {
                    Iterator<com.ss.android.socialbase.downloader.depend.zb> it = listLe.iterator();
                    while (it.hasNext()) {
                        cVar.ms(it.next());
                    }
                }
                String strHi = cVar.hi();
                try {
                    if (!TextUtils.isEmpty(strHi)) {
                        jSONObject = new JSONObject(strHi);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", cVar.ab());
                    jSONObject.put("auto_install_without_notification", cVar.c());
                    strHi = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = cVar.ka() || cVar.c();
                if (!z3 || com.ss.android.socialbase.downloader.ab.ms.ms(iMs).xr("enable_notification_ui") <= 0) {
                    i = iMs;
                } else {
                    i = iMs;
                    com.ss.android.socialbase.appdownloader.ka.ah.ms().ms(i, cVar.qk());
                }
                final DownloadTask autoInstall = Downloader.with(cVar.getContext()).url(strMs).backUpUrls(cVar.vm()).name(strM).title(strXr).savePath(str).onlyWifi(cVar.x()).extraHeaders(listMs).depend(uVarE).retryCount(cVar.re()).backUpUrlRetryCount(cVar.i()).showNotification(z3).extra(strHi).mimeType(strSl).minProgressTimeMsInterval(cVar.g()).maxProgressCount(cVar.of()).mainThreadListener(cVar.ny()).notificationListener(iDownloadListenerCh).notificationEventListener(ms(cVar.k())).force(z2).autoResumed(cVar.h()).showNotificationForAutoResumed(cVar.qv()).chunkStategy(cVar.ub()).chunkAdjustCalculator(cVar.ao()).needHttpsToHttpRetry(cVar.zb()).packageName(cVar.t()).md5(cVar.nw()).expectFileLength(cVar.b()).needRetryDelay(cVar.w()).retryDelayTimeArray(cVar.yu()).needDefaultHttpServiceBackUp(cVar.op()).needReuseFirstConnection(cVar.le()).needReuseChunkRunnable(cVar.p()).needIndependentProcess(cVar.pc()).enqueueType(cVar.ul()).monitorDepend(cVar.lm()).retryDelayTimeCalculator(cVar.cv()).headConnectionAvailable(cVar.jw()).fileUriProvider(cVar.eg()).diskSpaceHandler(cVar.zf()).needChunkDowngradeRetry(cVar.f()).notificationClickCallback(cVar.fm()).downloadSetting(cVar.rt()).iconUrl(cVar.qk()).needSDKMonitor(cVar.sa()).monitorScene(cVar.tz()).extraMonitorStatus(cVar.ti()).executorGroup(cVar.l()).throttleNetSpeed(cVar.am()).distinctDirectory(cVar.s()).taskKey(cVar.il()).setAutoInstall(cVar.v());
                if (autoInstall != null && !cVar.xn().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(cVar.xn());
                }
                if (autoInstall != null) {
                    if (z3 && cVar.qf() && cVar.getActivity() != null && !cVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.ka.d.ms()) {
                        com.ss.android.socialbase.appdownloader.ka.d.ms(cVar.getActivity(), new com.ss.android.socialbase.appdownloader.ah.u() { // from class: com.ss.android.socialbase.appdownloader.d.5
                            @Override // com.ss.android.socialbase.appdownloader.ah.u
                            public void ms() {
                                com.ss.android.socialbase.downloader.ah.ms.xr(d.f4570ms, "notification permission granted, start download :" + strXr);
                                d.this.ms(autoInstall, iY, z);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.ah.u
                            public void xr() {
                                com.ss.android.socialbase.downloader.ah.ms.xr(d.f4570ms, "notification permission denied, start download :" + strXr);
                                d.this.ms(autoInstall, iY, z);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, "notification permission need not request, start download :".concat(String.valueOf(strXr)));
                        ms(autoInstall, iY, z);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.d.ms.ms(cVar.lm(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.ny.c.xr(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.ah.ms.ka(f4570ms, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.ah> ms(List<com.ss.android.socialbase.downloader.model.ah> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
                if (ahVar != null && !TextUtils.isEmpty(ahVar.ms()) && !TextUtils.isEmpty(ahVar.xr())) {
                    if (ahVar.ms().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.ah(ahVar.ms(), ahVar.xr()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.ah("User-Agent", com.ss.android.socialbase.appdownloader.xr.ms.f4610ms));
        }
        return arrayList;
    }

    public String ms(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(a.h) || ah.ah(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private yu ms(final com.ss.android.socialbase.appdownloader.ah.ka kaVar) {
        if (kaVar == null) {
            return null;
        }
        return new yu() { // from class: com.ss.android.socialbase.appdownloader.d.6
            @Override // com.ss.android.socialbase.downloader.depend.yu
            public void ms(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 8:
                            downloadInfo.getPackageName();
                            break;
                        case 9:
                            com.ss.android.socialbase.downloader.downloader.ah.k();
                            break;
                    }
                    return;
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.ss.android.socialbase.downloader.depend.yu
            public boolean ms(boolean z) {
                return kaVar.ms(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.yu
            public String ms() {
                return kaVar.ms();
            }
        };
    }

    public DownloadInfo ms(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoMs = ms(context, str, x());
                if (downloadInfoMs == null) {
                    downloadInfoMs = ms(context, str, com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoMs == null) {
                    downloadInfoMs = ms(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoMs == null) {
                    downloadInfoMs = ms(context, str, com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context));
                }
                return (downloadInfoMs == null && com.ss.android.socialbase.downloader.ab.ms.ah().ms("get_download_info_by_list")) ? xr(context, str) : downloadInfoMs;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.ah.ms.xr(f4570ms, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo ms(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private DownloadInfo xr(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public List<DownloadInfo> ms(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public List<DownloadInfo> xr(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public zb zb() {
        return this.h;
    }

    public com.ss.android.socialbase.appdownloader.ah.ab u() {
        return this.ao;
    }

    public void ms(com.ss.android.socialbase.appdownloader.ah.ab abVar) {
        this.ao = abVar;
    }

    public com.ss.android.socialbase.downloader.downloader.qv ub() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).getReserveWifiStatusListener();
    }

    public void ms(com.ss.android.socialbase.downloader.downloader.qv qvVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.ah.k()).setReserveWifiStatusListener(qvVar);
    }

    public void ms(cv cvVar) {
        this.t = cvVar;
    }

    public cv ao() {
        return this.t;
    }

    public void ms(p pVar) {
        this.nw = pVar;
    }

    public p h() {
        return this.nw;
    }

    public void ms(int i) {
        if (com.ss.android.socialbase.downloader.ab.ms.ah().ms("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        hi();
        xr(i);
    }

    public void ms(ub ubVar) {
        this.b = ubVar;
    }

    public void ms(boolean z) {
        this.sl = z;
    }
}
