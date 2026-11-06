package com.byazt.lxs;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.gi.fw;
import com.byazt.lhc.BaseException;
import com.byazt.lj.Downloader;
import com.byazt.lj.hn;
import com.byazt.lj.m;
import com.byazt.lj.x;
import com.byazt.mrs.c;
import com.byazt.tuy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 956})
public class DownloadNotificationService extends Service {
    public static volatile long fw;
    public static volatile long uc;
    public static boolean zo;
    public fw vk;
    public final SparseArray<Notification> w = new SparseArray<>(2);
    public static final String pr = DownloadNotificationService.class.getSimpleName();
    public static int hw = -1;
    public static int hn = -1;
    public static boolean x = true;
    public static boolean c = false;
    public static long aj = 900;

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        x();
        hn.pr(this);
        com.byazt.ew.pr prVarHn = com.byazt.ew.pr.hn();
        int iPr = prVarHn.pr("download_service_foreground", 0);
        if ((iPr == 1 || iPr == 3) && hw == -1) {
            hw = 0;
        }
        if ((iPr == 2 || iPr == 3) && hn == -1) {
            hn = 0;
        }
        c = prVarHn.hw("non_going_notification_foreground", false);
        zo = prVarHn.hw("notify_too_fast", false);
        long jPr = prVarHn.pr("notification_time_window", 900L);
        aj = jPr;
        if (jPr < 0 || jPr > 1200) {
            aj = 900L;
        }
    }

    private void x() {
        if (this.vk == null) {
            fw fwVar = new fw("DownloaderNotifyThread");
            this.vk = fwVar;
            fwVar.pr();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        fw fwVar = this.vk;
        if (fwVar != null) {
            try {
                fwVar.hw();
            } catch (Throwable th) {
            }
            this.vk = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        pr(intent);
        return 2;
    }

    private void pr(final Intent intent) {
        fw fwVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && (fwVar = this.vk) != null) {
            fwVar.pr(new Runnable() { // from class: com.byazt.lxs.DownloadNotificationService.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectivityManager connectivityManager;
                    NetworkInfo activeNetworkInfo;
                    final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                    final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                    if (!action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                        if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                            if (intExtra != 0) {
                                DownloadNotificationService.this.hw(notificationManager, intExtra);
                                return;
                            }
                            return;
                        }
                        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                            try {
                                if (uc.pr((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                                    ArrayList arrayList = new ArrayList();
                                    if (!TextUtils.isEmpty(c.pr)) {
                                        arrayList.add(c.pr);
                                    }
                                    arrayList.add("mime_type_plg");
                                    Context applicationContext = DownloadNotificationService.this.getApplicationContext();
                                    if (applicationContext != null) {
                                        Downloader.getInstance(applicationContext).restartAllFailedDownloadTasks(arrayList);
                                        Downloader.getInstance(applicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                            try {
                                Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                                return;
                            } catch (Exception e2) {
                                return;
                            }
                        }
                        return;
                    }
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra != 0 && notification != null && notificationManager != null) {
                        if (intExtra2 != 4) {
                            if (intExtra2 == -2 || intExtra2 == -3) {
                                if (DownloadNotificationService.zo) {
                                    DownloadNotificationService.this.pr(notificationManager, intExtra, notification);
                                    return;
                                } else {
                                    if (DownloadNotificationService.this.vk != null) {
                                        DownloadNotificationService.this.vk.pr(new Runnable() { // from class: com.byazt.lxs.DownloadNotificationService.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                DownloadNotificationService.this.hw(notificationManager, intExtra, notification);
                                            }
                                        }, intExtra2 == -2 ? 50L : 200L);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (DownloadNotificationService.zo) {
                                DownloadNotificationService.this.pr(notificationManager, intExtra, notification);
                                return;
                            } else {
                                DownloadNotificationService.this.hw(notificationManager, intExtra, notification);
                                return;
                            }
                        }
                        if (!Downloader.getInstance(hn.of()).isDownloading(intExtra)) {
                            return;
                        }
                        DownloadInfo downloadInfo = Downloader.getInstance(hn.of()).getDownloadInfo(intExtra);
                        if (DownloadNotificationService.zo) {
                            if (downloadInfo != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - DownloadNotificationService.fw > DownloadNotificationService.aj) {
                                DownloadNotificationService.this.hw(notificationManager, intExtra, notification);
                                downloadInfo.setLastNotifyProgressTime();
                                return;
                            }
                            return;
                        }
                        if (downloadInfo != null && downloadInfo.canNotifyProgress()) {
                            DownloadNotificationService.this.hw(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.w) {
            int iIndexOfKey = this.w.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.w.size()) {
                this.w.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = aj - (System.currentTimeMillis() - uc);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            fw = jCurrentTimeMillis2;
            uc = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                hw(notificationManager, i, notification);
            } else if (this.vk != null) {
                synchronized (this.w) {
                    this.w.put(i, notification);
                }
                this.vk.pr(new Runnable() { // from class: com.byazt.lxs.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.pr(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.w) {
            notification = this.w.get(i);
            this.w.remove(i);
        }
        if (notification != null) {
            hw(notificationManager, i, notification);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean pr(int i, Notification notification) {
        int i2;
        int i3;
        if (!x || (i2 = hw) == i || (i3 = hn) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (c && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(NotificationManager notificationManager, int i, Notification notification) {
        if (pr(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = x.pr().pr(i) == 1 && !uc.hn();
                if (!z2 && hw == 0) {
                    z = true;
                } else if (z2 && hn == 0) {
                    z = true;
                }
                if (z) {
                    m mVarHn = x.pr().hn(i);
                    if (mVarHn.fw() && !mVarHn.hw()) {
                        com.byazt.p000do.pr.hn(pr, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            hn = i;
                        } else {
                            hw = i;
                        }
                        mVarHn.pr(i, notification);
                    } else {
                        com.byazt.p000do.pr.hn(pr, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable th) {
            }
        } else if ((hw == i || hn == i) && c && (notification.flags & 2) == 0) {
            hw(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (uc < jCurrentTimeMillis) {
                uc = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable th2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(NotificationManager notificationManager, int i) {
        boolean z;
        pr prVarValueAt;
        int iPr;
        int i2 = hw;
        if (i2 == i || hn == i) {
            boolean z2 = true;
            if (i2 == i) {
                hw = 0;
                z = false;
            } else {
                hn = 0;
                z = true;
            }
            try {
                m mVarHn = x.pr().hn(i);
                if (!mVarHn.hw()) {
                    x = false;
                    com.byazt.p000do.pr.x(pr, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
                }
                com.byazt.p000do.pr.hn(pr, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
                mVarHn.pr(false, true);
            } catch (Throwable th) {
            }
            try {
                notificationManager.cancel(i);
            } catch (Throwable th2) {
            }
            if (!x) {
                return;
            }
            try {
                SparseArray<pr> sparseArrayHw = hw.pr().hw();
                if (sparseArrayHw != null) {
                    int size = sparseArrayHw.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            prVarValueAt = sparseArrayHw.valueAt(size);
                            if (prVarValueAt != null && (iPr = prVarValueAt.pr()) != i && iPr != hw && iPr != hn && prVarValueAt.zo()) {
                                if ((x.pr().pr(prVarValueAt.pr()) == 1 && !uc.hn()) == z) {
                                    break;
                                }
                            }
                            size--;
                        } else {
                            prVarValueAt = null;
                            break;
                        }
                    }
                } else {
                    prVarValueAt = null;
                    break;
                }
                if (prVarValueAt != null) {
                    int iPr2 = prVarValueAt.pr();
                    try {
                        notificationManager.cancel(iPr2);
                    } catch (Throwable th3) {
                    }
                    if (Downloader.getInstance(this).getStatus(iPr2) != 1) {
                        z2 = false;
                    }
                    com.byazt.p000do.pr.hn(pr, "doCancel, updateNotification id = ".concat(String.valueOf(iPr2)));
                    prVarValueAt.pr((BaseException) null, z2);
                    return;
                }
                return;
            } catch (Throwable th4) {
                return;
            }
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable th5) {
        }
    }
}
