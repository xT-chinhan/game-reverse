package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.kuaishou.weapon.p0.g;
import com.ss.android.socialbase.downloader.constants.ka;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.ah;
import com.ss.android.socialbase.downloader.downloader.d;
import com.ss.android.socialbase.downloader.downloader.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ny.c;
import com.ss.android.socialbase.downloader.x.ab;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationService extends Service {
    private static volatile long ab = 0;
    private static int ah = -1;
    private static volatile long c = 0;
    private static boolean d = true;
    private static boolean ka = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4738ms = "DownloadNotificationService";
    private static long ny = 900;
    private static boolean x = false;
    private static int xr = -1;
    private ab ch;
    private final SparseArray<Notification> hi = new SparseArray<>(2);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d();
        ah.ms(this);
        com.ss.android.socialbase.downloader.ab.ms msVarAh = com.ss.android.socialbase.downloader.ab.ms.ah();
        int iMs = msVarAh.ms("download_service_foreground", 0);
        if ((iMs == 1 || iMs == 3) && xr == -1) {
            xr = 0;
        }
        if ((iMs == 2 || iMs == 3) && ah == -1) {
            ah = 0;
        }
        ka = msVarAh.xr("non_going_notification_foreground", false);
        x = msVarAh.xr("notify_too_fast", false);
        long jMs = msVarAh.ms("notification_time_window", 900L);
        ny = jMs;
        if (jMs < 0 || jMs > 1200) {
            ny = 900L;
        }
    }

    private void d() {
        if (this.ch == null) {
            ab abVar = new ab("DownloaderNotifyThread");
            this.ch = abVar;
            abVar.ms();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ab abVar = this.ch;
        if (abVar != null) {
            try {
                abVar.xr();
            } catch (Throwable unused) {
            }
            this.ch = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ms(intent);
        return 2;
    }

    private void ms(final Intent intent) {
        ab abVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (abVar = this.ch) == null) {
            return;
        }
        abVar.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
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
                            if (DownloadNotificationService.x) {
                                DownloadNotificationService.this.ms(notificationManager, intExtra, notification);
                                return;
                            } else {
                                if (DownloadNotificationService.this.ch != null) {
                                    DownloadNotificationService.this.ch.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.xr(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                        }
                        if (DownloadNotificationService.x) {
                            DownloadNotificationService.this.ms(notificationManager, intExtra, notification);
                            return;
                        } else {
                            DownloadNotificationService.this.xr(notificationManager, intExtra, notification);
                            return;
                        }
                    }
                    if (Downloader.getInstance(ah.k()).isDownloading(intExtra)) {
                        DownloadInfo downloadInfo = Downloader.getInstance(ah.k()).getDownloadInfo(intExtra);
                        if (DownloadNotificationService.x) {
                            if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.ab <= DownloadNotificationService.ny) {
                                return;
                            }
                            DownloadNotificationService.this.xr(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                            return;
                        }
                        if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                            return;
                        }
                        DownloadNotificationService.this.xr(notificationManager, intExtra, notification);
                        downloadInfo.setLastNotifyProgressTime();
                        return;
                    }
                    return;
                }
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.xr(notificationManager, intExtra);
                        return;
                    }
                    return;
                }
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (c.ms((Context) DownloadNotificationService.this, g.b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getApplicationContext().getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(ka.f4631ms)) {
                                arrayList.add(ka.f4631ms);
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
                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        return;
                    }
                }
                if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                    } catch (Exception e2) {
                        com.bytedance.sdk.openadsdk.api.ab.ms(e2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.hi) {
            int iIndexOfKey = this.hi.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.hi.size()) {
                this.hi.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = ny - (System.currentTimeMillis() - c);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            ab = jCurrentTimeMillis2;
            c = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                xr(notificationManager, i, notification);
            } else if (this.ch != null) {
                synchronized (this.hi) {
                    this.hi.put(i, notification);
                }
                this.ch.ms(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.ms(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.hi) {
            notification = this.hi.get(i);
            this.hi.remove(i);
        }
        if (notification != null) {
            xr(notificationManager, i, notification);
        }
    }

    private boolean ms(int i, Notification notification) {
        int i2;
        int i3;
        if (!d || (i2 = xr) == i || (i3 = ah) == i) {
            return false;
        }
        if (i2 == 0 || i3 == 0) {
            return ((ka && (notification.flags & 2) == 0) || TextUtils.isEmpty(notification.getChannelId())) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(NotificationManager notificationManager, int i, Notification notification) {
        if (ms(i, notification)) {
            try {
                boolean z = false;
                boolean z2 = d.ms().ms(i) == 1 && !c.ah();
                if ((!z2 && xr == 0) || (z2 && ah == 0)) {
                    z = true;
                }
                if (z) {
                    zb zbVarAh = d.ms().ah(i);
                    if (zbVarAh.ab() && !zbVarAh.xr()) {
                        com.ss.android.socialbase.downloader.ah.ms.ah(f4738ms, "doNotify, startForeground, ======== id = " + i + ", isIndependentProcess = " + z2);
                        if (z2) {
                            ah = i;
                        } else {
                            xr = i;
                        }
                        zbVarAh.ms(i, notification);
                    } else {
                        com.ss.android.socialbase.downloader.ah.ms.ah(f4738ms, "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = ".concat(String.valueOf(z2)));
                    }
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
        } else if ((xr == i || ah == i) && ka && (notification.flags & 2) == 0) {
            xr(notificationManager, i);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (c < jCurrentTimeMillis) {
                c = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(NotificationManager notificationManager, int i) {
        boolean z;
        ms msVarValueAt;
        int iMs;
        int i2 = xr;
        if (i2 == i || ah == i) {
            boolean z2 = true;
            if (i2 == i) {
                xr = 0;
                z = false;
            } else {
                ah = 0;
                z = true;
            }
            try {
                zb zbVarAh = d.ms().ah(i);
                if (!zbVarAh.xr()) {
                    d = false;
                    com.ss.android.socialbase.downloader.ah.ms.d(f4738ms, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
                }
                com.ss.android.socialbase.downloader.ah.ms.ah(f4738ms, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
                zbVarAh.ms(false, true);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
            }
            try {
                notificationManager.cancel(i);
            } catch (Throwable unused) {
            }
            if (d) {
                try {
                    SparseArray<ms> sparseArrayXr = xr.ms().xr();
                    if (sparseArrayXr == null) {
                        msVarValueAt = null;
                        break;
                    }
                    int size = sparseArrayXr.size() - 1;
                    while (true) {
                        if (size < 0) {
                            msVarValueAt = null;
                            break;
                        }
                        msVarValueAt = sparseArrayXr.valueAt(size);
                        if (msVarValueAt != null && (iMs = msVarValueAt.ms()) != i && iMs != xr && iMs != ah && msVarValueAt.x()) {
                            if ((d.ms().ms(msVarValueAt.ms()) == 1 && !c.ah()) == z) {
                                break;
                            }
                        }
                        size--;
                    }
                    if (msVarValueAt != null) {
                        int iMs2 = msVarValueAt.ms();
                        try {
                            notificationManager.cancel(iMs2);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                        }
                        if (Downloader.getInstance(this).getStatus(iMs2) != 1) {
                            z2 = false;
                        }
                        com.ss.android.socialbase.downloader.ah.ms.ah(f4738ms, "doCancel, updateNotification id = ".concat(String.valueOf(iMs2)));
                        msVarValueAt.ms((BaseException) null, z2);
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    com.bytedance.sdk.openadsdk.api.ab.ms(th3);
                    return;
                }
            }
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused2) {
        }
    }
}
