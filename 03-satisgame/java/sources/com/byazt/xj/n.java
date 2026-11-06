package com.byazt.xj;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.l.x;
import com.byazt.sk.l;
import com.byazt.ta.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.s;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1078, 19})
public class n {
    public static volatile n x;
    public volatile long n;
    public volatile x q;
    public volatile long qg;
    public long s = 1000;
    public final SparseArray<Notification> l = new SparseArray<>(2);
    public AtomicBoolean w = new AtomicBoolean(false);

    public static n n() {
        if (x == null) {
            synchronized (n.class) {
                if (x == null) {
                    x = new n();
                }
            }
        }
        return x;
    }

    public void qg() {
        if (this.w.compareAndSet(false, true)) {
            this.q = new x("DownloaderNotifyThread");
            this.q.n();
            long jN = com.byazt.f.n.s().n("notification_time_window", 1000L);
            this.s = jN;
            if (jN < 0 || jN > 1200) {
                this.s = 1000L;
            }
        }
    }

    public void n(final Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        qg();
        if (this.q == null) {
            return;
        }
        this.q.n(new Runnable() { // from class: com.byazt.xj.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        DownloadInfo downloadInfo;
        Context contextU = s.u();
        if (contextU == null) {
            return;
        }
        String action = intent.getAction();
        NotificationManager notificationManager = (NotificationManager) contextU.getSystemService("notification");
        int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(action)) {
            Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
            int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
            if (intExtra == 0 || notification == null || notificationManager == null) {
                return;
            }
            if (intExtra2 != 4) {
                if (intExtra2 == -2 || intExtra2 == -3) {
                    n(notificationManager, intExtra, notification);
                    return;
                } else {
                    n(notificationManager, intExtra, notification);
                    return;
                }
            }
            if (Downloader.getInstance(s.u()).isDownloading(intExtra) && (downloadInfo = Downloader.getInstance(s.u()).getDownloadInfo(intExtra)) != null && downloadInfo.canNotifyProgress() && System.currentTimeMillis() - this.qg > this.s) {
                qg(notificationManager, intExtra, notification);
                downloadInfo.setLastNotifyProgressTime();
                return;
            }
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(action)) {
            if (intExtra != 0) {
                qg(notificationManager, intExtra);
                return;
            }
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            try {
                if (w.n(contextU, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) contextU.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(l.n)) {
                        arrayList.add(l.n);
                    }
                    arrayList.add("mime_type_plg");
                    Downloader.getInstance(contextU).restartAllFailedDownloadTasks(arrayList);
                    Downloader.getInstance(contextU).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(action) || "android.intent.action.MEDIA_REMOVED".equals(action) || "android.intent.action.MEDIA_BAD_REMOVAL".equals(action) || "android.intent.action.MEDIA_EJECT".equals(action)) {
            try {
                Downloader.getInstance(s.u()).pauseAll();
            } catch (Exception unused2) {
            }
        }
    }

    private void n(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.l) {
            int iIndexOfKey = this.l.indexOfKey(i);
            if (iIndexOfKey >= 0 && iIndexOfKey < this.l.size()) {
                this.l.setValueAt(iIndexOfKey, notification);
                return;
            }
            long jCurrentTimeMillis = this.s - (System.currentTimeMillis() - this.n);
            if (jCurrentTimeMillis <= 0) {
                jCurrentTimeMillis = 0;
            }
            if (jCurrentTimeMillis > 20000) {
                jCurrentTimeMillis = 20000;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() + jCurrentTimeMillis;
            this.qg = jCurrentTimeMillis2;
            this.n = jCurrentTimeMillis2;
            if (jCurrentTimeMillis <= 0) {
                qg(notificationManager, i, notification);
            } else if (this.q != null) {
                synchronized (this.l) {
                    this.l.put(i, notification);
                }
                this.q.n(new Runnable() { // from class: com.byazt.xj.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n(notificationManager, i);
                    }
                }, jCurrentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.l) {
            notification = this.l.get(i);
            this.l.remove(i);
        }
        if (notification != null) {
            qg(notificationManager, i, notification);
        }
    }

    private void qg(NotificationManager notificationManager, int i, Notification notification) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.n < jCurrentTimeMillis) {
                this.n = jCurrentTimeMillis;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable unused) {
        }
    }

    private void qg(NotificationManager notificationManager, int i) {
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused) {
        }
    }
}
