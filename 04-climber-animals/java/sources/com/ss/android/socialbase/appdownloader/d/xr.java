package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.appdownloader.ah;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.qv;
import com.ss.android.socialbase.downloader.downloader.sl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ny.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private List<Integer> f4579ms;
    private BroadcastReceiver xr;

    @Override // com.ss.android.socialbase.downloader.downloader.sl
    public List<String> ms() {
        return ah.ah();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.sl
    public void ms(final List<DownloadInfo> list, final int i) {
        if (c.d()) {
            com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        xr.this.xr(list, i);
                    } catch (Exception e) {
                        ab.ms(e);
                    }
                }
            });
        } else {
            xr(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d.ch();
        Context contextK = com.ss.android.socialbase.downloader.downloader.ah.k();
        if (contextK == null) {
            return;
        }
        boolean zXr = c.xr(contextK);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            ms(contextK, it.next(), zXr, i);
        }
        List<Integer> list2 = this.f4579ms;
        if (list2 == null || list2.isEmpty() || this.xr != null) {
            return;
        }
        this.xr = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.d.xr.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (c.xr(applicationContext)) {
                    com.ss.android.socialbase.downloader.ah.ms.xr("LaunchResume", "onReceive : wifi connected !!!");
                    com.ss.android.socialbase.downloader.downloader.ah.sl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.d.xr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (xr.this.f4579ms != null && !xr.this.f4579ms.isEmpty()) {
                                    int size = xr.this.f4579ms.size();
                                    Integer[] numArr = new Integer[size];
                                    xr.this.f4579ms.toArray(numArr);
                                    xr.this.f4579ms.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            xr.this.ms(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                ab.ms(e);
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(xr.this.xr);
                    } catch (Throwable th) {
                        ab.ms(th);
                    }
                    xr.this.xr = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextK.registerReceiver(this.xr, intentFilter);
        } catch (Throwable th) {
            ab.ms(th);
            this.xr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        boolean z2;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5 && ("application/ttpatch".equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded())) {
            com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
            int iMs = msVarMs.ms("failed_resume_max_count", 0);
            double dMs = msVarMs.ms("failed_resume_max_hours", 72.0d);
            double dMs2 = msVarMs.ms("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (downloadInfo.isPauseReserveOnWifi() && z) ? true : downloadInfo.getFailedResumeCount() < iMs && ((double) (jCurrentTimeMillis - downloadInfo.getLastDownloadTime())) < dMs * 3600000.0d && ((double) (jCurrentTimeMillis - downloadInfo.getLastFailedResumeTime())) > dMs2 * 3600000.0d;
            if (z3) {
                boolean z4 = msVarMs.ms("failed_resume_need_wifi", 1) == 1;
                boolean z5 = msVarMs.ms("failed_resume_need_wait_wifi", 0) == 1;
                if (z || !z4 || !z5) {
                    ah.ms(downloadInfo, true, z4);
                    downloadInfo.setLastFailedResumeTime(jCurrentTimeMillis);
                    downloadInfo.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                    downloadInfo.updateSpData();
                    if (downloadInfo.isPauseReserveOnWifi() && z) {
                        downloadInfo.setDownloadFromReserveWifi(true);
                        qv qvVarUb = d.ch().ub();
                        if (qvVarUb != null) {
                            qvVarUb.ms(downloadInfo, 5, i);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.f4579ms == null) {
                        this.f4579ms = new ArrayList();
                    }
                    int id = downloadInfo.getId();
                    if (!this.f4579ms.contains(Integer.valueOf(id))) {
                        this.f4579ms.add(Integer.valueOf(id));
                    }
                    downloadInfo.setOnlyWifi(true);
                    com.ss.android.socialbase.downloader.impls.qv.ms().ms(downloadInfo);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            com.ss.android.socialbase.downloader.ah.ms.ah("LaunchResume", "launchResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            com.ss.android.socialbase.appdownloader.ah.ab abVarU = d.ch().u();
            if (abVarU != null) {
                abVarU.ms(downloadInfo, z2);
                return;
            }
            return;
        }
        if (realStatus == -3 && ms(downloadInfo)) {
            com.ss.android.socialbase.downloader.ab.ms msVarMs2 = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
            if (ah.ms(context, downloadInfo)) {
                return;
            }
            int iMs2 = msVarMs2.ms("uninstall_resume_max_count", 0);
            double dMs3 = msVarMs2.ms("uninstall_resume_max_hours", 72.0d);
            double dMs4 = msVarMs2.ms("uninstall_resume_min_hours", 12.0d);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            boolean z6 = downloadInfo.getUninstallResumeCount() < iMs2 && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastDownloadTime())) < dMs3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - downloadInfo.getLastUninstallResumeTime())) > dMs4 * 3600000.0d;
            com.ss.android.socialbase.downloader.ah.ms.ah("LaunchResume", "uninstallResume, name = " + downloadInfo.getTitle() + ", canShowNotification = " + z6);
            if (z6) {
                com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
                if (msVarKa == null) {
                    msVarKa = new com.ss.android.socialbase.appdownloader.ka.ms(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                    com.ss.android.socialbase.downloader.notification.xr.ms().ms(msVarKa);
                } else {
                    msVarKa.ms(downloadInfo);
                }
                msVarKa.xr(downloadInfo.getTotalBytes());
                msVarKa.ms(downloadInfo.getTotalBytes());
                msVarKa.ms(downloadInfo.getStatus(), null, false, false);
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
                    ah.ms(downloadInfo, true, true);
                    downloadInfo.updateSpData();
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.appdownloader.ah.ab abVarU2 = d.ch().u();
                    if (abVarU2 != null) {
                        abVarU2.ms(downloadInfo, true);
                    }
                    qv qvVarUb2 = d.ch().ub();
                    if (qvVarUb2 != null) {
                        qvVarUb2.ms(downloadInfo, 5, i);
                        return;
                    }
                    return;
                }
                if (this.f4579ms == null) {
                    this.f4579ms = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.f4579ms.contains(Integer.valueOf(id2))) {
                    this.f4579ms.add(Integer.valueOf(id2));
                }
                com.ss.android.socialbase.downloader.impls.qv.ms().ms(downloadInfo);
            }
            ms(downloadInfo, context);
        }
    }

    private void ms(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
        int iMs = msVarMs.ms("paused_resume_max_count", 0);
        double dMs = msVarMs.ms("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < iMs && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < dMs * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.ms msVarKa = com.ss.android.socialbase.downloader.notification.xr.ms().ka(downloadInfo.getId());
            if (msVarKa == null) {
                msVarKa = new com.ss.android.socialbase.appdownloader.ka.ms(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.xr.ms().ms(msVarKa);
            } else {
                msVarKa.ms(downloadInfo);
            }
            msVarKa.xr(downloadInfo.getTotalBytes());
            msVarKa.ms(downloadInfo.getCurBytes());
            msVarKa.ms(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean ms(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).xr("uninstall_can_not_resume_for_force_task", false)) {
            return c.ms(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
