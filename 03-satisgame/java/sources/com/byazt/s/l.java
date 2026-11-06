package com.byazt.s;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 18})
public class l {
    public ExecutorService n;
    public ExecutorService q;
    public ExecutorService qg;
    public ScheduledExecutorService s;

    @com.byazt.cp.n(n = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public static l n = new l();
    }

    public static l n() {
        return n.n;
    }

    private l() {
    }

    public void n(Runnable runnable) {
        n(runnable, false);
    }

    public void qg(Runnable runnable) {
        qg(runnable, false);
    }

    public void n(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !oa.qg()) {
            runnable.run();
        } else {
            qg().execute(runnable);
        }
    }

    public void s(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        l().execute(runnable);
    }

    public void qg(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !oa.qg()) {
            runnable.run();
        } else {
            s().execute(runnable);
        }
    }

    public void n(Runnable runnable, long j) {
        try {
            q().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
    }

    public ExecutorService qg() {
        if (this.n == null) {
            synchronized (l.class) {
                if (this.n == null) {
                    this.n = new com.byazt.xis.q(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.l.n(tj.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.n;
    }

    public ExecutorService s() {
        if (this.qg == null) {
            synchronized (l.class) {
                if (this.qg == null) {
                    this.qg = new com.byazt.xis.q(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.l.n(tj.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.qg;
    }

    public ScheduledExecutorService q() {
        if (this.s == null) {
            synchronized (l.class) {
                if (this.s == null) {
                    this.s = new com.byazt.xis.l(0, new com.byazt.l.n(tj.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.s;
    }

    public ExecutorService l() {
        if (this.q == null) {
            synchronized (l.class) {
                if (this.q == null) {
                    this.q = new com.byazt.xis.q(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.l.n(tj.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.q;
    }

    public void w() {
        n(new Runnable() { // from class: com.byazt.s.l.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (l.class) {
                    try {
                        try {
                            String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                            for (int i = 0; i < 13; i++) {
                                SharedPreferences sharedPreferencesN = com.byazt.qp.x.n(d.getContext(), strArr[i], 0);
                                if (sharedPreferencesN != null) {
                                    sharedPreferencesN.edit().clear().apply();
                                }
                            }
                            com.byazt.xv.tj tjVarHu = com.byazt.xv.s.hu();
                            if (!(tjVarHu instanceof com.byazt.i.q)) {
                                return;
                            }
                            SparseArray<DownloadInfo> sparseArrayN = ((com.byazt.i.q) tjVarHu).n().n();
                            for (int size = sparseArrayN.size() - 1; size >= 0; size--) {
                                DownloadInfo downloadInfo = sparseArrayN.get(sparseArrayN.keyAt(size));
                                if (downloadInfo != null) {
                                    Downloader.getInstance(d.getContext()).clearDownloadData(downloadInfo.getId());
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }
}
