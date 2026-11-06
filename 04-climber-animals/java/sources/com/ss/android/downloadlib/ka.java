package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private ScheduledExecutorService ah;
    private ExecutorService d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ExecutorService f4497ms;
    private ExecutorService xr;

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ka f4499ms = new ka();
    }

    public static ka ms() {
        return ms.f4499ms;
    }

    private ka() {
    }

    public void ms(Runnable runnable) {
        ms(runnable, false);
    }

    public void xr(Runnable runnable) {
        xr(runnable, false);
    }

    public void ms(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !zb.xr()) {
            runnable.run();
        } else {
            xr().execute(runnable);
        }
    }

    public void ah(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        ka().execute(runnable);
    }

    public void xr(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !zb.xr()) {
            runnable.run();
        } else {
            ah().execute(runnable);
        }
    }

    public void ms(Runnable runnable, long j) {
        try {
            d().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public ExecutorService xr() {
        if (this.f4497ms == null) {
            synchronized (ka.class) {
                if (this.f4497ms == null) {
                    this.f4497ms = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.x.ms(ch.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f4497ms;
    }

    public ExecutorService ah() {
        if (this.xr == null) {
            synchronized (ka.class) {
                if (this.xr == null) {
                    this.xr = new com.bytedance.sdk.component.ch.d.d(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.x.ms(ch.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.xr;
    }

    public ScheduledExecutorService d() {
        if (this.ah == null) {
            synchronized (ka.class) {
                if (this.ah == null) {
                    this.ah = new com.bytedance.sdk.component.ch.d.ka(0, new com.ss.android.socialbase.downloader.x.ms(ch.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.ah;
    }

    public ExecutorService ka() {
        if (this.d == null) {
            synchronized (ka.class) {
                if (this.d == null) {
                    this.d = new com.bytedance.sdk.component.ch.d.d(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.x.ms(ch.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.d;
    }

    public void c() {
        ms(new Runnable() { // from class: com.ss.android.downloadlib.ka.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ka.class) {
                    try {
                        try {
                            String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                            for (int i = 0; i < 13; i++) {
                                SharedPreferences sharedPreferencesMs = com.bytedance.sdk.openadsdk.ats.ah.ms(hi.getContext(), strArr[i], 0);
                                if (sharedPreferencesMs != null) {
                                    sharedPreferencesMs.edit().clear().apply();
                                }
                            }
                            com.ss.android.socialbase.downloader.downloader.ch chVarW = com.ss.android.socialbase.downloader.downloader.ah.w();
                            if (!(chVarW instanceof com.ss.android.socialbase.downloader.impls.d)) {
                                return;
                            }
                            SparseArray<DownloadInfo> sparseArrayMs = ((com.ss.android.socialbase.downloader.impls.d) chVarW).ms().ms();
                            for (int size = sparseArrayMs.size() - 1; size >= 0; size--) {
                                DownloadInfo downloadInfo = sparseArrayMs.get(sparseArrayMs.keyAt(size));
                                if (downloadInfo != null) {
                                    Downloader.getInstance(hi.getContext()).clearDownloadData(downloadInfo.getId());
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
