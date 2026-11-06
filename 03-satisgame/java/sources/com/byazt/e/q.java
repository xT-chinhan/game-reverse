package com.byazt.e;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.byazt.i.cd;
import com.byazt.je.IDownloadListener;
import com.byazt.je.bb;
import com.byazt.je.h;
import com.byazt.je.oa;
import com.byazt.je.sz;
import com.byazt.je.v;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.byazt.wm.DownloadTask;
import com.byazt.xv.Downloader;
import com.byazt.z.cp;
import com.byazt.z.fs;
import com.byazt.z.k;
import com.byazt.z.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.core.RequestParamsUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE, 5})
public class q {
    public static boolean fs = false;
    public static final String n = "q";
    public static volatile q qg = null;
    public static boolean w = false;
    public static boolean x = false;
    public v a;
    public cp cd;
    public fs cy;
    public com.byazt.z.x hd;
    public rv k;
    public com.byazt.z.q oa;
    public com.byazt.z.s ou;
    public k py;
    public String q;
    public Future rv;
    public String s;
    public com.byazt.z.l sz;
    public int tj;
    public bb um;
    public DownloadReceiver l = new DownloadReceiver();
    public boolean cp = false;
    public boolean d = false;

    public com.byazt.z.s n() {
        return this.ou;
    }

    public void n(com.byazt.z.s sVar) {
        this.ou = sVar;
    }

    public com.byazt.z.q qg() {
        return this.oa;
    }

    public com.byazt.z.l s() {
        return this.sz;
    }

    public rv q() {
        return this.k;
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.q = str;
    }

    public String l() {
        return this.q;
    }

    public com.byazt.z.x w() {
        return this.hd;
    }

    public void n(com.byazt.z.x xVar) {
        this.hd = xVar;
    }

    public boolean x() {
        return com.byazt.f.n.qg().optInt("package_flag_config", 1) == 1;
    }

    public cp fs() {
        return this.cd;
    }

    public void n(cp cpVar) {
        this.cd = cpVar;
    }

    public File rv() {
        return Downloader.getInstance(com.byazt.xv.s.u()).getGlobalSaveDir();
    }

    public String tj() {
        return this.s;
    }

    private q() {
    }

    public static q cp() {
        if (qg == null) {
            synchronized (q.class) {
                if (qg == null) {
                    qg = new q();
                }
            }
        }
        return qg;
    }

    @Deprecated
    public void n(Context context, String str, com.byazt.z.q qVar, com.byazt.z.l lVar, rv rvVar) {
        if (qVar != null) {
            this.oa = qVar;
        }
        if (lVar != null) {
            this.sz = lVar;
        }
        if (rvVar != null) {
            this.k = rvVar;
        }
        s(context);
    }

    private void s(Context context) {
        if (context == null || w) {
            return;
        }
        com.byazt.sk.l.n(AdBaseConstants.MIME_APK);
        com.byazt.xv.s.n(context);
        com.byazt.xv.s.n(new com.byazt.n.qg());
        if (this.d) {
            com.byazt.xv.s.n(new Runnable() { // from class: com.byazt.e.q.1
                @Override // java.lang.Runnable
                public void run() {
                    q.this.um();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            um();
        }
        a();
        w = true;
    }

    public void qg(String str) {
        Downloader.getInstance(com.byazt.xv.s.u()).setDefaultSavePath(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        synchronized (this.l) {
            if (x) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme("file");
                com.byazt.xv.s.u().registerReceiver(this.l, intentFilter);
                com.byazt.xv.s.u().registerReceiver(this.l, intentFilter2);
                x = true;
            } catch (Exception unused) {
            }
            com.byazt.fe.n.qg(n, "registerDownloadReceiver mIsRegistered:" + x);
        }
    }

    public void d() {
        if (com.byazt.f.n.s().n("enable_app_install_receiver", 1) <= 0) {
            com.byazt.fe.n.qg(n, "disable app install receiver");
            return;
        }
        synchronized (this.l) {
            try {
                if (!fs) {
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        intentFilter.addDataScheme(AbsServerManager.PACKAGE_QUERY_BINDER);
                        com.byazt.xv.s.u().registerReceiver(this.l, intentFilter);
                        fs = true;
                        k kVar = this.py;
                        if (kVar != null) {
                            kVar.n();
                        }
                    } catch (Throwable unused) {
                    }
                    qg(0);
                    com.byazt.fe.n.qg(n, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + x);
                    return;
                }
                qg(0);
            } catch (Throwable th) {
                qg(0);
                throw th;
            }
        }
    }

    private void qg(int i) {
        this.tj = com.byazt.f.n.s().n("app_install_keep_receiver_time_s", 60);
        com.byazt.fe.n.qg(n, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.tj);
        if (this.tj <= 0) {
            return;
        }
        if (i > 0) {
            this.tj = i;
        }
        Future future = this.rv;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
        }
        this.rv = com.byazt.xv.s.n(new Runnable() { // from class: com.byazt.e.q.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.fe.n.qg(q.n, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                q.this.oa();
                q.this.um();
            }
        }, this.tj, TimeUnit.SECONDS);
    }

    public void oa() {
        k kVar;
        synchronized (this.l) {
            try {
                if (x) {
                    com.byazt.xv.s.u().unregisterReceiver(this.l);
                    if (fs && (kVar = this.py) != null) {
                        kVar.qg();
                    }
                }
            } catch (Exception unused) {
            }
            x = false;
            fs = false;
        }
        com.byazt.fe.n.qg(n, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    private void a() {
        cd.n(new cd.qg() { // from class: com.byazt.e.q.3
            @Override // com.byazt.i.cd.qg
            public void n(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.n(downloadInfo, j, z, i);
            }
        });
    }

    public static boolean n(Context context, int i) {
        return s.n(context, i, true) == 1;
    }

    public void n(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    s.n(context, i, true);
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
        } catch (Exception unused) {
        }
    }

    public int n(l lVar) {
        int i;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        if (lVar == null || lVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.byazt.wm.s> listN = n(lVar.q());
            String strN = lVar.n();
            if (TextUtils.isEmpty(strN)) {
                return 0;
            }
            final int iUm = lVar.um();
            final boolean z = iUm == 0;
            String strDf = lVar.df();
            final String strQg = lVar.qg();
            if (TextUtils.isEmpty(strDf)) {
                strDf = s.n(strN, strQg, lVar.d(), z);
            }
            if (strDf.length() > 255) {
                strDf = strDf.substring(strDf.length() - 255);
            }
            if (TextUtils.isEmpty(strQg)) {
                strQg = strDf;
            }
            String strD = lVar.d();
            if (strDf.endsWith(".apk") && !s.s(lVar.d())) {
                strD = AdBaseConstants.MIME_APK;
            }
            String strS = lVar.s();
            if (TextUtils.isEmpty(lVar.s())) {
                strS = s.qg();
            }
            String str = strS;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(strDf)) {
                String strY = lVar.y();
                if (TextUtils.isEmpty(strY)) {
                    strY = strN;
                }
                int iN = com.byazt.xv.s.n(strY, str);
                if (com.byazt.f.n.n(lVar.ci()).n("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.byazt.xv.s.u()).getDownloadInfo(iN)) != null) {
                    try {
                        lVar.n(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                com.byazt.f.n.n(iN, lVar.ci());
                boolean zFi = lVar.fi();
                boolean z2 = (com.byazt.f.n.n(iN).n("modify_force", 1) == 1 && !zFi && com.byazt.ta.w.q(str, strDf) && Downloader.getInstance(lVar.getContext()).getDownloadInfo(iN) == null) ? true : zFi;
                IDownloadListener iDownloadListenerTj = lVar.tj();
                if (iDownloadListenerTj == null && (lVar.l() || lVar.w())) {
                    if (lVar.sz() != null) {
                        iDownloadListenerTj = new com.byazt.j.qg(lVar.sz());
                    } else {
                        iDownloadListenerTj = new com.byazt.j.qg(lVar.getContext(), iN, strQg, str, strDf, lVar.cp());
                    }
                }
                sz szVarDg = lVar.dg();
                if (szVarDg == null) {
                    szVarDg = new sz() { // from class: com.byazt.e.q.4
                        @Override // com.byazt.je.sz
                        public void n(DownloadInfo downloadInfo2, BaseException baseException, int i2) {
                            if (q.this.k != null) {
                                q.this.k.n(downloadInfo2, baseException, i2);
                            }
                        }
                    };
                }
                List<oa> listUr = com.byazt.xv.s.ur();
                if (!listUr.isEmpty()) {
                    Iterator<oa> it = listUr.iterator();
                    while (it.hasNext()) {
                        lVar.n(it.next());
                    }
                }
                String strCp = lVar.cp();
                try {
                    if (!TextUtils.isEmpty(strCp)) {
                        jSONObject = new JSONObject(strCp);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", lVar.x());
                    jSONObject.put("auto_install_without_notification", lVar.w());
                    strCp = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = lVar.l() || lVar.w();
                if (!z3 || com.byazt.f.n.n(iN).qg("enable_notification_ui") <= 0) {
                    i = iN;
                } else {
                    i = iN;
                    com.byazt.j.s.n().n(i, lVar.cx());
                }
                final DownloadTask autoInstall = Downloader.with(lVar.getContext()).url(strN).backUpUrls(lVar.lq()).name(strDf).title(strQg).savePath(str).onlyWifi(lVar.fs()).extraHeaders(listN).depend(szVarDg).retryCount(lVar.wm()).backUpUrlRetryCount(lVar.m()).showNotification(z3).extra(strCp).mimeType(strD).minProgressTimeMsInterval(lVar.ln()).maxProgressCount(lVar.lh()).mainThreadListener(lVar.rv()).notificationListener(iDownloadListenerTj).notificationEventListener(n(lVar.u())).force(z2).autoResumed(lVar.hd()).showNotificationForAutoResumed(lVar.cd()).chunkStategy(lVar.k()).chunkAdjustCalculator(lVar.cy()).needHttpsToHttpRetry(lVar.oa()).packageName(lVar.a()).md5(lVar.py()).expectFileLength(lVar.ou()).needRetryDelay(lVar.hu()).retryDelayTimeArray(lVar.h()).needDefaultHttpServiceBackUp(lVar.t()).needReuseFirstConnection(lVar.ur()).needReuseChunkRunnable(lVar.v()).needIndependentProcess(lVar.j()).enqueueType(lVar.f()).monitorDepend(lVar.oj()).retryDelayTimeCalculator(lVar.bb()).headConnectionAvailable(lVar.an()).fileUriProvider(lVar.pk()).diskSpaceHandler(lVar.ic()).needChunkDowngradeRetry(lVar.ae()).notificationClickCallback(lVar.wo()).downloadSetting(lVar.ci()).iconUrl(lVar.cx()).needSDKMonitor(lVar.ri()).monitorScene(lVar.nf()).extraMonitorStatus(lVar.pe()).executorGroup(lVar.dh()).throttleNetSpeed(lVar.b()).distinctDirectory(lVar.e()).taskKey(lVar.y()).setAutoInstall(lVar.yw());
                if (autoInstall != null && !lVar.sh().isEmpty()) {
                    autoInstall.setDownloadCompleteHandlers(lVar.sh());
                }
                if (autoInstall != null) {
                    if (z3 && lVar.rf() && lVar.getActivity() != null && !lVar.getActivity().isFinishing() && !com.byazt.j.q.n()) {
                        com.byazt.j.q.n(lVar.getActivity(), new com.byazt.z.sz() { // from class: com.byazt.e.q.5
                            @Override // com.byazt.z.sz
                            public void n() {
                                com.byazt.fe.n.qg(q.n, "notification permission granted, start download :" + strQg);
                                q.this.n(autoInstall, iUm, z);
                            }

                            @Override // com.byazt.z.sz
                            public void qg() {
                                com.byazt.fe.n.qg(q.n, "notification permission denied, start download :" + strQg);
                                q.this.n(autoInstall, iUm, z);
                            }
                        });
                    } else {
                        com.byazt.fe.n.qg(n, "notification permission need not request, start download :".concat(String.valueOf(strQg)));
                        com.byazt.j.q.n(i);
                        n(autoInstall, iUm, z);
                        autoInstall.getDownloadInfo();
                    }
                }
                return i;
            }
            return 0;
        } catch (Throwable th) {
            com.byazt.g.n.n(lVar.oj(), (DownloadInfo) null, new BaseException(1003, com.byazt.ta.w.qg(th, "addDownloadTask")), 0);
            com.byazt.fe.n.l(n, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(DownloadTask downloadTask, int i, boolean z) {
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

    private List<com.byazt.wm.s> n(List<com.byazt.wm.s> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.byazt.wm.s sVar : list) {
                if (sVar != null && !TextUtils.isEmpty(sVar.n()) && !TextUtils.isEmpty(sVar.qg())) {
                    if (sVar.n().equals(RequestParamsUtils.USER_AGENT_KEY)) {
                        z = true;
                    }
                    arrayList.add(new com.byazt.wm.s(sVar.n(), sVar.qg()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.byazt.wm.s(RequestParamsUtils.USER_AGENT_KEY, com.byazt.d.n.n));
        }
        return arrayList;
    }

    public String n(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || s.s(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private h n(final com.byazt.z.w wVar) {
        if (wVar == null) {
            return null;
        }
        return new h() { // from class: com.byazt.e.q.6
            @Override // com.byazt.je.h
            public void n(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 8:
                            downloadInfo.getPackageName();
                            break;
                        case 9:
                            com.byazt.xv.s.u();
                            break;
                    }
                    return;
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.byazt.je.h
            public boolean n(boolean z) {
                return wVar.n(z);
            }

            @Override // com.byazt.je.h
            public String n() {
                return wVar.n();
            }
        };
    }

    public DownloadInfo n(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoN = n(context, str, rv());
                if (downloadInfoN == null) {
                    downloadInfoN = n(context, str, com.byazt.qyu.qg.n(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoN == null) {
                    downloadInfoN = n(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (downloadInfoN == null) {
                    downloadInfoN = n(context, str, com.byazt.qyu.qg.n(context));
                }
                return (downloadInfoN == null && com.byazt.f.n.s().n("get_download_info_by_list")) ? qg(context, str) : downloadInfoN;
            } catch (Throwable th) {
                com.byazt.fe.n.qg(n, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private DownloadInfo n(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private DownloadInfo qg(Context context, String str) {
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

    public List<DownloadInfo> n(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public List<DownloadInfo> qg(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public fs sz() {
        return this.cy;
    }

    public void n(fs fsVar) {
        this.cy = fsVar;
    }

    public com.byazt.xv.cd k() {
        return Downloader.getInstance(com.byazt.xv.s.u()).getReserveWifiStatusListener();
    }

    public void n(com.byazt.xv.cd cdVar) {
        Downloader.getInstance(com.byazt.xv.s.u()).setReserveWifiStatusListener(cdVar);
    }

    public void n(bb bbVar) {
        this.um = bbVar;
    }

    public bb cy() {
        return this.um;
    }

    public void n(v vVar) {
        this.a = vVar;
    }

    public v hd() {
        return this.a;
    }

    public void n(int i) {
        if (com.byazt.f.n.s().n("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        d();
        qg(i);
    }

    public void n(k kVar) {
        this.py = kVar;
    }
}
