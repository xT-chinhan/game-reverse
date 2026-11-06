package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.ah;
import com.ss.android.socialbase.downloader.downloader.ch;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    private static volatile xr ah;
    private static final Object ka = new Object();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f4743ms = 1000;
    private final Map<Integer, Long> xr = new HashMap();
    private final Set<String> d = new HashSet();
    private final SparseArray<ms> c = new SparseArray<>();

    static boolean xr(int i) {
        return i == 1 || i == 3;
    }

    private xr() {
    }

    public static xr ms() {
        if (ah == null) {
            synchronized (xr.class) {
                if (ah == null) {
                    ah = new xr();
                }
            }
        }
        return ah;
    }

    public void ms(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(ah.k()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        ms(downloadInfo);
        xr(downloadInfo);
    }

    void ms(DownloadInfo downloadInfo) {
        ch chVarW = ah.w();
        if (chVarW != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                chVarW.ms(downloadInfo);
            } catch (SQLiteException e) {
                ab.ms(e);
            }
        }
    }

    void xr(DownloadInfo downloadInfo) {
        if (ah(downloadInfo)) {
            c(downloadInfo.getId());
        }
    }

    static boolean ah(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && xr(downloadInfo.getNotificationVisibility());
    }

    public void ms(int i, int i2, Notification notification) {
        Context contextK = ah.k();
        if (contextK == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.xr) {
                Long l = this.xr.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.xr.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        try {
            Intent intent = new Intent(contextK, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            contextK.startService(intent);
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    public void ah(int i) {
        Context contextK = ah.k();
        if (contextK == null || i == 0) {
            return;
        }
        try {
            Intent intent = new Intent(contextK, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            contextK.startService(intent);
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    public void ms(ms msVar) {
        if (msVar == null) {
            return;
        }
        synchronized (this.c) {
            this.c.put(msVar.ms(), msVar);
        }
    }

    public ms d(int i) {
        ms msVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.c) {
            msVar = this.c.get(i);
            if (msVar != null) {
                this.c.remove(i);
                com.ss.android.socialbase.downloader.ah.ms.ms("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return msVar;
    }

    public ms ka(int i) {
        ms msVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.c) {
            msVar = this.c.get(i);
        }
        return msVar;
    }

    SparseArray<ms> xr() {
        SparseArray<ms> sparseArray;
        synchronized (this.c) {
            sparseArray = this.c;
        }
        return sparseArray;
    }

    public void c(int i) {
        d(i);
        if (i != 0) {
            ms().ah(i);
        }
    }
}
