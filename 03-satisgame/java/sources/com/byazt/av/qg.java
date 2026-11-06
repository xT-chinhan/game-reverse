package com.byazt.av;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.s;
import com.byazt.xv.tj;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 425, 26})
public class qg {
    public static final Object l = new Object();
    public static volatile qg s;
    public final long n = 1000;
    public final Map<Integer, Long> qg = new HashMap();
    public final Set<String> q = new HashSet();
    public final SparseArray<n> w = new SparseArray<>();

    public static boolean qg(int i) {
        return i == 1 || i == 3;
    }

    private qg() {
    }

    public static qg n() {
        if (s == null) {
            synchronized (qg.class) {
                if (s == null) {
                    s = new qg();
                }
            }
        }
        return s;
    }

    public void n(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(s.u()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        n(downloadInfo);
        qg(downloadInfo);
    }

    public void n(DownloadInfo downloadInfo) {
        tj tjVarHu = s.hu();
        if (tjVarHu != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                tjVarHu.n(downloadInfo);
            } catch (SQLiteException unused) {
            }
        }
    }

    public void qg(DownloadInfo downloadInfo) {
        if (s(downloadInfo)) {
            w(downloadInfo.getId());
        }
    }

    public static boolean s(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && qg(downloadInfo.getNotificationVisibility());
    }

    public void n(int i, int i2, Notification notification) {
        Context contextU = s.u();
        if (contextU == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.qg) {
                Long l2 = this.qg.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l2 != null && Math.abs(jCurrentTimeMillis - l2.longValue()) < 1000) {
                    return;
                } else {
                    this.qg.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextU, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                com.byazt.xj.n.n().n(intent);
            } else {
                contextU.startService(intent);
            }
        } catch (Throwable unused) {
            if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                com.byazt.xj.n.n().n(intent);
            }
        }
    }

    public void s(int i) {
        Context contextU = s.u();
        if (contextU == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextU, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                com.byazt.xj.n.n().n(intent);
            } else {
                contextU.startService(intent);
            }
        } catch (Throwable unused) {
            if (com.byazt.f.n.s().qg("enable_target_34") > 0) {
                com.byazt.xj.n.n().n(intent);
            }
        }
    }

    public void n(n nVar) {
        if (nVar == null) {
            return;
        }
        synchronized (this.w) {
            this.w.put(nVar.n(), nVar);
        }
    }

    public n q(int i) {
        n nVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.w) {
            nVar = this.w.get(i);
            if (nVar != null) {
                this.w.remove(i);
                com.byazt.fe.n.n("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return nVar;
    }

    public n l(int i) {
        n nVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.w) {
            nVar = this.w.get(i);
        }
        return nVar;
    }

    public SparseArray<n> qg() {
        SparseArray<n> sparseArray;
        synchronized (this.w) {
            sparseArray = this.w;
        }
        return sparseArray;
    }

    public void w(int i) {
        q(i);
        if (i != 0) {
            n().s(i);
        }
    }
}
