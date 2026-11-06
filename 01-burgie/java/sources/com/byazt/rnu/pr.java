package com.byazt.rnu;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.gi.fw;
import com.byazt.lj.Downloader;
import com.byazt.lj.hn;
import com.byazt.mrs.c;
import com.byazt.tuy.uc;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 125, 37})
public class pr {
    public static volatile pr fw;
    public volatile long hw;
    public volatile long pr;
    public volatile fw x;
    public long hn = 1000;
    public final SparseArray<Notification> c = new SparseArray<>(2);
    public AtomicBoolean uc = new AtomicBoolean(false);

    public static pr pr() {
        if (fw == null) {
            synchronized (pr.class) {
                if (fw == null) {
                    fw = new pr();
                }
            }
        }
        return fw;
    }

    public void hw() {
        if (!this.uc.compareAndSet(false, true)) {
            return;
        }
        this.x = new fw("DownloaderNotifyThread");
        this.x.pr();
        long jPr = com.byazt.ew.pr.hn().pr("notification_time_window", 1000L);
        this.hn = jPr;
        if (jPr < 0 || jPr > 1200) {
            this.hn = 1000L;
        }
    }

    public void pr(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        hw();
        if (this.x == null) {
            return;
        }
        this.x.pr(new Runnable() { // from class: com.byazt.rnu.pr.1
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hw(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context contextOf = hn.of();
        if (contextOf == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextOf.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra != 0 && notification != null && notificationManager != null) {
                if (intExtra2 != 4) {
                    if (intExtra2 == -2 || intExtra2 == -3) {
                        pr(notificationManager, intExtra, notification);
                        return;
                    } else {
                        pr(notificationManager, intExtra, notification);
                        return;
                    }
                }
                if (Downloader.getInstance(hn.of()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(hn.of()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.hw > this.hn) {
                    hw(notificationManager, intExtra, notification);
                    downloadInfo.setLastNotifyProgressTime();
                    return;
                }
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                hw(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (uc.pr(contextOf, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) contextOf.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(c.pr)) {
                        arrayList.add(c.pr);
                    }
                    arrayList.add("mime_type_plg");
                    Downloader.getInstance(contextOf).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(contextOf).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(hn.of()).pauseAll();
            } catch (Exception e2) {
            }
        }
    }

    private void pr(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.c) {
            int iIndexOfKey = this.c.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.c.size()) {
                this.c.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.hn - (System.currentTimeMillis() - this.pr);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.hw = jCurrentTimeMillis2;
            this.pr = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                hw(notificationManager, i, notification);
            } else if (this.x != null) {
                synchronized (this.c) {
                    this.c.put(i, notification);
                }
                this.x.pr(new Runnable() { // from class: com.byazt.rnu.pr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.pr(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.c) {
            notification = this.c.get(i);
            this.c.remove(i);
        }
        if (notification != null) {
            hw(notificationManager, i, notification);
        }
    }

    private void hw(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.pr < jCurrentTimeMillis) {
                this.pr = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable th) {
        }
    }

    private void hw(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable th) {
        }
    }
}
