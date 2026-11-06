package com.byazt.lkw;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.byazt.lj.k;
import com.byazt.lj.lb;
import com.byazt.mdu.hn;
import com.byazt.mdu.x;
import com.byazt.tuy.uc;
import com.byazt.zkm.zo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 970, 13})
public class hw implements k {
    public BroadcastReceiver hw;
    public List<Integer> pr;

    @Override // com.byazt.lj.k
    public List<String> pr() {
        return hn.hn();
    }

    @Override // com.byazt.lj.k
    public void pr(final List<DownloadInfo> list, final int i) {
        if (uc.x()) {
            com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.lkw.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hw.this.hw(list, i);
                    } catch (Exception e) {
                    }
                }
            });
        } else {
            hw(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        x.w();
        Context contextOf = com.byazt.lj.hn.of();
        if (contextOf == null) {
            return;
        }
        boolean zHw = uc.hw(contextOf);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            pr(contextOf, it.next(), zHw, i);
        }
        List<Integer> list2 = this.pr;
        if (list2 != null && !list2.isEmpty() && this.hw == null) {
            this.hw = new BroadcastReceiver() { // from class: com.byazt.lkw.hw.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    final Context applicationContext = context.getApplicationContext();
                    if (!uc.hw(applicationContext)) {
                        return;
                    }
                    com.byazt.p000do.pr.hw("LaunchResume", "onReceive : wifi connected !!!");
                    com.byazt.lj.hn.k().execute(new Runnable() { // from class: com.byazt.lkw.hw.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (hw.this.pr != null && !hw.this.pr.isEmpty()) {
                                    int size = hw.this.pr.size();
                                    Integer[] numArr = new Integer[size];
                                    hw.this.pr.toArray(numArr);
                                    hw.this.pr.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            hw.this.pr(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(hw.this.hw);
                    } catch (Throwable th) {
                    }
                    hw.this.hw = null;
                }
            };
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                contextOf.registerReceiver(this.hw, intentFilter);
            } catch (Throwable th) {
                this.hw = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v39 */
    public void pr(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        boolean z3;
        if (downloadInfo == 0 || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus != -5 || (!"application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) && downloadInfo.isDownloaded())) {
            if (realStatus == -3 && pr(downloadInfo)) {
                com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
                if (hn.pr(context, downloadInfo)) {
                    return;
                }
                int iPr = prVarPr.pr("uninstall_resume_max_count", 0);
                double dPr = prVarPr.pr("uninstall_resume_max_hours", 72.0d);
                double dPr2 = prVarPr.pr("uninstall_resume_min_hours", 12.0d);
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z4 = downloadInfo.getUninstallResumeCount() < iPr && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dPr * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastUninstallResumeTime())) > dPr2 * 3600000.0d;
                com.byazt.p000do.pr.hn("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z4);
                if (z4) {
                    com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
                    if (prVarC == null) {
                        prVarC = new com.byazt.owr.pr(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                        com.byazt.lxs.hw.pr().pr(prVarC);
                    } else {
                        prVarC.pr(downloadInfo);
                    }
                    prVarC.hw(downloadInfo.getTotalBytes());
                    prVarC.pr(downloadInfo.getTotalBytes());
                    prVarC.pr(downloadInfo.getStatus(), null, false, false);
                    downloadInfo.setLastUninstallResumeTime(jCurrentTimeMillis);
                    downloadInfo.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + 1);
                    downloadInfo.updateSpData();
                    return;
                }
                return;
            }
            if (realStatus == -2) {
                if (downloadInfo.isPauseReserveOnWifi()) {
                    if (z) {
                        hn.pr(downloadInfo, true, true);
                        downloadInfo.updateSpData();
                        downloadInfo.setDownloadFromReserveWifi(true);
                        zo zoVarG = x.w().g();
                        if (zoVarG != null) {
                            zoVarG.pr(downloadInfo, true);
                        }
                        lb lbVarHo = x.w().ho();
                        if (lbVarHo != null) {
                            lbVarHo.pr(downloadInfo, 5, i);
                            return;
                        }
                        return;
                    }
                    if (this.pr == null) {
                        this.pr = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.pr.contains(Integer.valueOf(id))) {
                        this.pr.add(Integer.valueOf(id));
                    }
                    com.byazt.ts.lb.pr().pr(downloadInfo);
                }
                pr(downloadInfo, context);
                return;
            }
            return;
        }
        com.byazt.ew.pr prVarPr2 = com.byazt.ew.pr.pr(downloadInfo.getId());
        int iPr2 = prVarPr2.pr("failed_resume_max_count", 0);
        double dPr3 = prVarPr2.pr("failed_resume_max_hours", 72.0d);
        double dPr4 = prVarPr2.pr("failed_resume_min_hours", 12.0d);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean z5 = downloadInfo.getFailedResumeCount() < iPr2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dPr3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastFailedResumeTime())) > dPr4 * 3600000.0d;
        if (downloadInfo.isPauseReserveOnWifi() && z) {
            z2 = true;
        } else {
            z2 = z5;
        }
        if (z2) {
            boolean z6 = prVarPr2.pr("failed_resume_need_wifi", 1) == 1;
            boolean z7 = prVarPr2.pr("failed_resume_need_wait_wifi", 0) == 1;
            if (z || !z6 || !z7) {
                ?? r3 = 1;
                hn.pr(downloadInfo, (boolean) r3, z6);
                downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis2);
                downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + r3);
                downloadInfo.updateSpData();
                if (downloadInfo.isPauseReserveOnWifi() && z) {
                    downloadInfo.setDownloadFromReserveWifi(r3);
                    lb lbVarHo2 = x.w().ho();
                    if (lbVarHo2 != null) {
                        lbVarHo2.pr(downloadInfo, 5, i);
                    }
                }
                z3 = true;
            } else {
                if (this.pr == null) {
                    this.pr = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.pr.contains(Integer.valueOf(id2))) {
                    this.pr.add(Integer.valueOf(id2));
                }
                downloadInfo.setOnlyWifi(true);
                com.byazt.ts.lb.pr().pr(downloadInfo);
                z3 = false;
            }
        } else {
            z3 = false;
        }
        com.byazt.p000do.pr.hn("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z2 + ", downloadResumed = " + z3);
        zo zoVarG2 = x.w().g();
        if (zoVarG2 != null) {
            zoVarG2.pr(downloadInfo, z3);
        }
    }

    private void pr(DownloadInfo downloadInfo, Context context) {
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
        int iPr = prVarPr.pr("paused_resume_max_count", 0);
        double dPr = prVarPr.pr("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iPr && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dPr * 3600000.0d) {
            com.byazt.lxs.pr prVarC = com.byazt.lxs.hw.pr().c(downloadInfo.getId());
            if (prVarC == null) {
                prVarC = new com.byazt.owr.pr(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.byazt.lxs.hw.pr().pr(prVarC);
            } else {
                prVarC.pr(downloadInfo);
            }
            prVarC.hw(downloadInfo.getTotalBytes());
            prVarC.pr(downloadInfo.getCurBytes());
            prVarC.pr(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean pr(DownloadInfo downloadInfo) {
        if (com.byazt.ew.pr.pr(downloadInfo.getId()).hw("uninstall_can_not_resume_for_force_task", false)) {
            return uc.pr(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
