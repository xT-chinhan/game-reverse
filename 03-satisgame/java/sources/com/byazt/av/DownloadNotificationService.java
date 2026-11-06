package com.byazt.av;

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
import androidx.core.view.PointerIconCompat;
import com.byazt.l.x;
import com.byazt.qx.BaseException;
import com.byazt.sk.l;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.oa;
import com.byazt.xv.q;
import com.byazt.xv.s;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 425, PointerIconCompat.TYPE_VERTICAL_TEXT})
public class DownloadNotificationService extends Service {
    public static boolean fs = false;
    public static boolean l = false;
    public static final String n = "DownloadNotificationService";
    public static boolean q = true;
    public static int qg = -1;
    public static long rv = 900;
    public static int s = -1;
    public static volatile long w;
    public static volatile long x;
    public final SparseArray<Notification> cp = new SparseArray<>(2);
    public x tj;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        q();
        s.n(this);
        com.byazt.f.n nVarS = com.byazt.f.n.s();
        int iN = nVarS.n("download_service_foreground", 0);
        if ((iN == 1 || iN == 3) && qg == -1) {
            qg = 0;
        }
        if ((iN == 2 || iN == 3) && s == -1) {
            s = 0;
        }
        l = nVarS.qg("non_going_notification_foreground", false);
        fs = nVarS.qg("notify_too_fast", false);
        long jN = nVarS.n("notification_time_window", 900L);
        rv = jN;
        if (jN < 0 || jN > 1200) {
            rv = 900L;
        }
    }

    private void q() {
        if (this.tj == null) {
            x xVar = new x("DownloaderNotifyThread");
            this.tj = xVar;
            xVar.n();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        x xVar = this.tj;
        if (xVar != null) {
            try {
                xVar.qg();
            } catch (Throwable unused) {
            }
            this.tj = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        n(intent);
        return 2;
    }

    private void n(final Intent intent) {
        x xVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (xVar = this.tj) == null) {
            return;
        }
        xVar.n(new Runnable() { // from class: com.byazt.av.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra == 0 || notification == null || notificationManager == null) {
                        return;
                    }
                    if (intExtra2 != 4) {
                        if (intExtra2 == -2 || intExtra2 == -3) {
                            if (DownloadNotificationService.fs) {
                                DownloadNotificationService.this.n(notificationManager, intExtra, notification);
                                return;
                            } else {
                                if (DownloadNotificationService.this.tj != null) {
                                    DownloadNotificationService.this.tj.n(new Runnable() { // from class: com.byazt.av.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.qg(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                        }
                        if (DownloadNotificationService.fs) {
                            DownloadNotificationService.this.n(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.qg(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (Downloader.getInstance(s.u()).isDownloading(intExtra)) {
                        DownloadInfo downloadInfo = Downloader.getInstance(s.u()).getDownloadInfo(intExtra);
                        if (DownloadNotificationService.fs) {
                            if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.x <= DownloadNotificationService.rv) {
                                return;
                            }
                            DownloadNotificationService.this.qg(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                            return;
                        }
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.qg(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    return;
                }
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.qg(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (w.n((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(l.n)) {
                                arrayList.add(l.n);
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
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                    } catch (Exception unused2) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.cp) {
            int iIndexOfKey = this.cp.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.cp.size()) {
                this.cp.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = rv - (System.currentTimeMillis() - w);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            x = jCurrentTimeMillis2;
            w = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                qg(notificationManager, i, notification);
            } else if (this.tj != null) {
                synchronized (this.cp) {
                    this.cp.put(i, notification);
                }
                this.tj.n(new Runnable() { // from class: com.byazt.av.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.n(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.cp) {
            notification = this.cp.get(i);
            this.cp.remove(i);
        }
        if (notification != null) {
            qg(notificationManager, i, notification);
        }
    }

    private boolean n(int i, Notification notification) {
        int i2;
        int i3;
        if (!q || (i2 = qg) == i || (i3 = s) == i) {
            return false;
        }
        if (i2 != 0 && i3 != 0) {
            return false;
        }
        if (l && (notification.flags & 2) == 0) {
            return false;
        }
        return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(NotificationManager notificationManager, int i, Notification notification) {
        if (n(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = q.n().n(i) == 1 && !w.s();
                if ((!z2 && qg == 0) || (z2 && s == 0)) {
                    z = true;
                }
                if (z) {
                    oa oaVarS = q.n().s(i);
                    if (oaVarS.x() && !oaVarS.qg()) {
                        com.byazt.fe.n.s(n, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            s = i;
                        } else {
                            qg = i;
                        }
                        oaVarS.n(i, notification);
                    } else {
                        com.byazt.fe.n.s(n, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable unused) {
            }
        } else if ((qg == i || s == i) && l && (notification.flags & 2) == 0) {
            qg(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (w < jCurrentTimeMillis) {
                w = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(NotificationManager notificationManager, int i) {
        boolean z;
        n nVarValueAt;
        int iN;
        int i2 = qg;
        if (i2 == i || s == i) {
            boolean z2 = true;
            if (i2 == i) {
                qg = 0;
                z = false;
            } else {
                s = 0;
                z = true;
            }
            try {
                oa oaVarS = q.n().s(i);
                if (!oaVarS.qg()) {
                    q = false;
                    com.byazt.fe.n.q(n, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
                }
                com.byazt.fe.n.s(n, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
                oaVarS.n(false, true);
            } catch (Throwable unused) {
            }
            try {
                notificationManager.cancel(i);
            } catch (Throwable unused2) {
            }
            if (q) {
                try {
                    SparseArray<n> sparseArrayQg = qg.n().qg();
                    if (sparseArrayQg == null) {
                        nVarValueAt = null;
                        break;
                    }
                    int size = sparseArrayQg.size() - 1;
                    while (true) {
                        if (size < 0) {
                            nVarValueAt = null;
                            break;
                        }
                        nVarValueAt = sparseArrayQg.valueAt(size);
                        if (nVarValueAt != null && (iN = nVarValueAt.n()) != i && iN != qg && iN != s && nVarValueAt.fs()) {
                            if ((q.n().n(nVarValueAt.n()) == 1 && !w.s()) == z) {
                                break;
                            }
                        }
                        size--;
                    }
                    if (nVarValueAt != null) {
                        int iN2 = nVarValueAt.n();
                        try {
                            notificationManager.cancel(iN2);
                        } catch (Throwable unused3) {
                        }
                        if (Downloader.getInstance(this).getStatus(iN2) != 1) {
                            z2 = false;
                        }
                        com.byazt.fe.n.s(n, "doCancel, updateNotification id = ".concat(String.valueOf(iN2)));
                        nVarValueAt.n((BaseException) null, z2);
                        return;
                    }
                    return;
                } catch (Throwable unused4) {
                    return;
                }
            }
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused5) {
        }
    }
}
