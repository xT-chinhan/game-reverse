package com.byazt.n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.byazt.e.q;
import com.byazt.e.s;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.cd;
import com.byazt.xv.d;
import com.byazt.z.fs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 19, 26})
public class qg implements d {
    public List<Integer> n;
    public BroadcastReceiver qg;

    @Override // com.byazt.xv.d
    public List<String> n() {
        return s.s();
    }

    @Override // com.byazt.xv.d
    public void n(final List<DownloadInfo> list, final int i) {
        if (w.q()) {
            com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.n.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        qg.this.qg(list, i);
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            qg(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        q.cp();
        Context contextU = com.byazt.xv.s.u();
        if (contextU == null) {
            return;
        }
        boolean zQg = w.qg(contextU);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            n(contextU, it.next(), zQg, i);
        }
        List<Integer> list2 = this.n;
        if (list2 == null || list2.isEmpty() || this.qg != null) {
            return;
        }
        this.qg = new BroadcastReceiver() { // from class: com.byazt.n.qg.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (w.qg(applicationContext)) {
                    com.byazt.fe.n.qg("LaunchResume", "onReceive : wifi connected !!!");
                    com.byazt.xv.s.d().execute(new Runnable() { // from class: com.byazt.n.qg.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (qg.this.n != null && !qg.this.n.isEmpty()) {
                                    int size = qg.this.n.size();
                                    Integer[] numArr = new Integer[size];
                                    qg.this.n.toArray(numArr);
                                    qg.this.n.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            qg.this.n(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(qg.this.qg);
                    } catch (Throwable unused) {
                    }
                    qg.this.qg = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextU.registerReceiver(this.qg, intentFilter);
        } catch (Throwable unused) {
            this.qg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
            int iN = nVarN.n("failed_resume_max_count", 0);
            double dN = nVarN.n("failed_resume_max_hours", 72.0d);
            double dN2 = nVarN.n("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (downloadInfo.isPauseReserveOnWifi() && z) ? true : downloadInfo.getFailedResumeCount() < iN && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dN * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastFailedResumeTime())) > dN2 * 3600000.0d;
            if (z3) {
                boolean z4 = nVarN.n("failed_resume_need_wifi", 1) == 1;
                boolean z5 = nVarN.n("failed_resume_need_wait_wifi", 0) == 1;
                if (z || !z4 || !z5) {
                    s.n(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        cd cdVarK = q.cp().k();
                        if (cdVarK != null) {
                            cdVarK.n(downloadInfo, 5, i);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.n == null) {
                        this.n = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.n.contains(Integer.valueOf(id))) {
                        this.n.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    com.byazt.i.cd.n().n(downloadInfo);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            com.byazt.fe.n.s("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            fs fsVarSz = q.cp().sz();
            if (fsVarSz != null) {
                fsVarSz.n(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus == -3 && n(downloadInfo)) {
            com.byazt.f.n nVarN2 = com.byazt.f.n.n(downloadInfo.getId());
            if (s.n(context, downloadInfo)) {
                return;
            }
            int iN2 = nVarN2.n("uninstall_resume_max_count", 0);
            double dN3 = nVarN2.n("uninstall_resume_max_hours", 72.0d);
            double dN4 = nVarN2.n("uninstall_resume_min_hours", 12.0d);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            boolean z6 = downloadInfo.getUninstallResumeCount() < iN2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dN3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > dN4 * 3600000.0d;
            com.byazt.fe.n.s("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z6);
            if (z6) {
                com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
                if (nVarL == null) {
                    nVarL = new com.byazt.j.n(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                    com.byazt.av.qg.n().n(nVarL);
                } else {
                    nVarL.n(downloadInfo);
                }
                nVarL.qg(downloadInfo.getTotalBytes());
                nVarL.n(downloadInfo.getTotalBytes());
                nVarL.n(downloadInfo.getStatus(), null, false, false);
                downloadInfo.setLastUninstallResumeTime(jCurrentTimeMillis2);
                downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + 1);
                downloadInfo.updateSpData();
                return;
            }
            return;
        }
        if (realStatus == -2) {
            if (downloadInfo.isPauseReserveOnWifi()) {
                if (z) {
                    s.n(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    fs fsVarSz2 = q.cp().sz();
                    if (fsVarSz2 != null) {
                        fsVarSz2.n(downloadInfo, true);
                    }
                    cd cdVarK2 = q.cp().k();
                    if (cdVarK2 != null) {
                        cdVarK2.n(downloadInfo, 5, i);
                        return;
                    }
                    return;
                }
                if (this.n == null) {
                    this.n = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.n.contains(Integer.valueOf(id2))) {
                    this.n.add(Integer.valueOf(id2));
                }
                com.byazt.i.cd.n().n(downloadInfo);
            }
            n(downloadInfo, context);
        }
    }

    private void n(DownloadInfo downloadInfo, Context context) {
        com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
        int iN = nVarN.n("paused_resume_max_count", 0);
        double dN = nVarN.n("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iN && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dN * 3600000.0d) {
            com.byazt.av.n nVarL = com.byazt.av.qg.n().l(downloadInfo.getId());
            if (nVarL == null) {
                nVarL = new com.byazt.j.n(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.byazt.av.qg.n().n(nVarL);
            } else {
                nVarL.n(downloadInfo);
            }
            nVarL.qg(downloadInfo.getTotalBytes());
            nVarL.n(downloadInfo.getCurBytes());
            nVarL.n(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean n(DownloadInfo downloadInfo) {
        if (com.byazt.f.n.n(downloadInfo.getId()).qg("uninstall_can_not_resume_for_force_task", false)) {
            return w.n(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
