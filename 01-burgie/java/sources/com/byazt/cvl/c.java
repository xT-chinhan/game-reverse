package com.byazt.cvl;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.lj.Downloader;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public ScheduledExecutorService hn;
    public ExecutorService hw;
    public ExecutorService pr;
    public ExecutorService x;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 169})
    private static class pr {
        public static c pr = new c();
    }

    public static c pr() {
        return pr.pr;
    }

    private c() {
    }

    public void pr(Runnable runnable) {
        pr(runnable, false);
    }

    public void hw(Runnable runnable) {
        hw(runnable, false);
    }

    public void pr(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !m.hw()) {
            runnable.run();
        } else {
            hw().execute(runnable);
        }
    }

    public void hn(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        c().execute(runnable);
    }

    public void hw(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !m.hw()) {
            runnable.run();
        } else {
            hn().execute(runnable);
        }
    }

    public void pr(Runnable runnable, long j) {
        try {
            x().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
        }
    }

    public ExecutorService hw() {
        if (this.pr == null) {
            synchronized (c.class) {
                if (this.pr == null) {
                    this.pr = new com.byazt.fr.x(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.gi.pr(vk.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.pr;
    }

    public ExecutorService hn() {
        if (this.hw == null) {
            synchronized (c.class) {
                if (this.hw == null) {
                    this.hw = new com.byazt.fr.x(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.gi.pr(vk.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.hw;
    }

    public ScheduledExecutorService x() {
        if (this.hn == null) {
            synchronized (c.class) {
                if (this.hn == null) {
                    this.hn = new com.byazt.fr.c(0, new com.byazt.gi.pr(vk.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.hn;
    }

    public ExecutorService c() {
        if (this.x == null) {
            synchronized (c.class) {
                if (this.x == null) {
                    this.x = new com.byazt.fr.x(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.byazt.gi.pr(vk.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.x;
    }

    public void uc() {
        pr(new Runnable() { // from class: com.byazt.cvl.c.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.class) {
                    try {
                        try {
                            String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                            for (int i = 0; i < 13; i++) {
                                SharedPreferences sharedPreferencesPr = com.byazt.zs.aj.pr(k.getContext(), strArr[i], 0);
                                if (sharedPreferencesPr != null) {
                                    sharedPreferencesPr.edit().clear().apply();
                                }
                            }
                            com.byazt.lj.vk vkVarZ = com.byazt.lj.hn.z();
                            if (!(vkVarZ instanceof com.byazt.ts.x)) {
                                return;
                            }
                            SparseArray<DownloadInfo> sparseArrayPr = ((com.byazt.ts.x) vkVarZ).pr().pr();
                            for (int size = sparseArrayPr.size() - 1; size >= 0; size--) {
                                DownloadInfo downloadInfo = sparseArrayPr.get(sparseArrayPr.keyAt(size));
                                if (downloadInfo != null) {
                                    Downloader.getInstance(k.getContext()).clearDownloadData(downloadInfo.getId());
                                }
                            }
                        } catch (Throwable th) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        });
    }
}
