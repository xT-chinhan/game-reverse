package com.byazt.lxs;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.byazt.lj.hn;
import com.byazt.lj.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 13})
public class hw {
    public static volatile hw hn = null;
    public static final Object c = new Object();
    public final long pr = 1000;
    public final Map<Integer, Long> hw = new HashMap();
    public final Set<String> x = new HashSet();
    public final SparseArray<pr> uc = new SparseArray<>();

    private hw() {
    }

    public static hw pr() {
        if (hn == null) {
            synchronized (hw.class) {
                if (hn == null) {
                    hn = new hw();
                }
            }
        }
        return hn;
    }

    public void pr(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(hn.of()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        pr(downloadInfo);
        hw(downloadInfo);
    }

    public void pr(DownloadInfo downloadInfo) {
        vk vkVarZ = hn.z();
        if (vkVarZ != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                vkVarZ.pr(downloadInfo);
            } catch (SQLiteException e) {
            }
        }
    }

    public void hw(DownloadInfo downloadInfo) {
        if (hn(downloadInfo)) {
            uc(downloadInfo.getId());
        }
    }

    public static boolean hn(DownloadInfo downloadInfo) {
        if (downloadInfo.isDownloadOverStatus() && hw(downloadInfo.getNotificationVisibility())) {
            return true;
        }
        return false;
    }

    public static boolean hw(int i) {
        if (i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public void pr(int i, int i2, Notification notification) {
        Context contextOf = hn.of();
        if (contextOf == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.hw) {
                Long l = this.hw.get(Integer.valueOf(i));
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(jCurrentTimeMillis - l.longValue()) < 1000) {
                    return;
                } else {
                    this.hw.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
                }
            }
        }
        Intent intent = new Intent(contextOf, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                com.byazt.rnu.pr.pr().pr(intent);
            } else {
                contextOf.startService(intent);
            }
        } catch (Throwable th) {
            if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                com.byazt.rnu.pr.pr().pr(intent);
            }
        }
    }

    public void hn(int i) {
        Context contextOf = hn.of();
        if (contextOf == null || i == 0) {
            return;
        }
        Intent intent = new Intent(contextOf, (Class<?>) DownloadNotificationService.class);
        try {
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                com.byazt.rnu.pr.pr().pr(intent);
            } else {
                contextOf.startService(intent);
            }
        } catch (Throwable th) {
            if (com.byazt.ew.pr.hn().hw("enable_target_34") > 0) {
                com.byazt.rnu.pr.pr().pr(intent);
            }
        }
    }

    public void pr(pr prVar) {
        if (prVar == null) {
            return;
        }
        synchronized (this.uc) {
            this.uc.put(prVar.pr(), prVar);
        }
    }

    public pr x(int i) {
        pr prVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.uc) {
            prVar = this.uc.get(i);
            if (prVar != null) {
                this.uc.remove(i);
                com.byazt.p000do.pr.pr("removeNotificationId ".concat(String.valueOf(i)));
            }
        }
        return prVar;
    }

    public pr c(int i) {
        pr prVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.uc) {
            prVar = this.uc.get(i);
        }
        return prVar;
    }

    public SparseArray<pr> hw() {
        SparseArray<pr> sparseArray;
        synchronized (this.uc) {
            sparseArray = this.uc;
        }
        return sparseArray;
    }

    public void uc(int i) {
        x(i);
        if (i != 0) {
            pr().hn(i);
        }
    }
}
