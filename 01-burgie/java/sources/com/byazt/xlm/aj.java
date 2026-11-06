package com.byazt.xlm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.constants.ErrorCode;
import com.taptap.sdk.update.download.DownloadTask;
import com.umeng.analytics.pro.an;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 61})
public final class aj {
    public volatile ThreadPoolExecutor a;
    public boolean b;
    public volatile ScheduledExecutorService cz;
    public int fo;
    public volatile boolean iu;
    public com.byazt.rj.c lb;
    public volatile ThreadPoolExecutor qa;
    public volatile boolean ve;
    public volatile boolean vk;
    public static final int pr = Runtime.getRuntime().availableProcessors();
    public static final aj hw = new aj();
    public static boolean x = true;
    public volatile boolean hn = true;
    public long fw = 5000;
    public long zo = 20000;
    public volatile boolean aj = true;
    public boolean w = true;
    public long k = 100;
    public long m = 50;
    public long g = 1000;
    public long ho = 3000;
    public boolean nt = false;
    public volatile boolean yb = true;
    public boolean ny = true;
    public boolean rc = true;
    public com.byazt.rj.hw z = new com.byazt.rj.hw() { // from class: com.byazt.xlm.aj.1
        @Override // com.byazt.rj.hw
        public String pr(String str) {
            if (str != null) {
                if (str.startsWith("csj")) {
                    return str;
                }
                return "csj_".concat(String.valueOf(str));
            }
            return "csj_uk";
        }
    };
    public volatile boolean gz = true;
    public volatile boolean nl = true;
    public int c = Math.min(pr, 4);
    public int uc = 50;

    private aj() {
    }

    public void pr(int i) {
        this.fo = i;
    }

    public boolean hw(int i) {
        return (this.fo & i) == i;
    }

    public boolean pr() {
        return this.w;
    }

    public void pr(boolean z) {
        this.w = z;
    }

    public boolean hw() {
        return this.ny;
    }

    public void hw(boolean z) {
        this.ny = z;
    }

    public com.byazt.rj.hw hn() {
        return this.z;
    }

    public long x() {
        return this.k;
    }

    public boolean c() {
        return this.hn;
    }

    public void hn(boolean z) {
        this.hn = z;
    }

    public boolean uc() {
        return this.b;
    }

    public void x(boolean z) {
        this.b = z;
    }

    public com.byazt.rj.c fw() {
        if (this.lb == null) {
            this.lb = new com.byazt.rj.c();
        }
        return this.lb;
    }

    public int zo() {
        return this.c;
    }

    public void hn(int i) {
        this.c = i;
        aj().setCorePoolSize(i);
        vk().setCorePoolSize(i);
    }

    public ThreadPoolExecutor aj() {
        if (this.qa == null) {
            synchronized (this) {
                if (this.qa == null) {
                    this.qa = new com.byazt.mz.x(this.c, this.uc, this.zo, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new zo(10, an.av) { // from class: com.byazt.xlm.aj.2
                        @Override // com.byazt.xlm.zo
                        public Thread pr(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.qa;
    }

    public ThreadPoolExecutor vk() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new com.byazt.mz.hw(this.c, this.uc, this.fw, TimeUnit.MILLISECONDS, new zo(10, "b") { // from class: com.byazt.xlm.aj.3
                        @Override // com.byazt.xlm.zo
                        public Thread pr(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.nl) {
                        try {
                            this.a.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        }
        return this.a;
    }

    public void x(int i) {
        this.uc = i;
        aj().setMaximumPoolSize(i);
        vk().setMaximumPoolSize(i);
    }

    public int w() {
        return this.uc;
    }

    public void c(boolean z) {
        this.vk = z;
    }

    public ScheduledExecutorService k() {
        if (this.cz == null) {
            synchronized (this) {
                if (this.cz == null) {
                    this.cz = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.byazt.xlm.aj.4
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, aj.this.b ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.byazt.fr.pr.pr);
                }
            }
        }
        return this.cz;
    }

    public ThreadPoolExecutor m() {
        if (this.vk) {
            return vk();
        }
        return aj();
    }

    public void pr(long j) {
        this.fw = j;
        vk().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void uc(boolean z) {
        this.aj = z;
    }

    public boolean g() {
        return this.iu;
    }

    public void fw(boolean z) {
        if (z) {
            zo(false);
            x = false;
        }
        this.iu = z;
    }

    public boolean ho() {
        return this.ve;
    }

    public boolean nt() {
        return this.gz && x;
    }

    public void zo(boolean z) {
        if (this.iu) {
            return;
        }
        if (this.a != null) {
            this.a.allowCoreThreadTimeOut(z);
        }
        this.nl = z;
    }

    public long yb() {
        return this.m;
    }

    public void hw(long j) {
        this.m = j;
    }

    public long lb() {
        return this.g;
    }

    public void hn(long j) {
        this.g = j;
    }

    public long qa() {
        return this.ho;
    }

    public void x(long j) {
        this.ho = j;
    }

    public boolean a() {
        return this.nt;
    }

    public void aj(boolean z) {
        this.nt = z;
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aj ajVar = hw;
        int iOptInt = jSONObject.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            ajVar.x(iOptInt);
        }
        int iOptInt2 = jSONObject.optInt("core_count", 0);
        if (iOptInt2 > 0) {
            ajVar.hn(iOptInt2);
        }
        int iOptInt3 = jSONObject.optInt("big_keep_alive", 0);
        if (iOptInt3 > 0) {
            ajVar.pr(iOptInt3);
        }
        ajVar.c(jSONObject.optBoolean("big_priority", false));
        ajVar.hn(jSONObject.optBoolean("catch_oom", true));
        ajVar.hw(jSONObject.optBoolean("forbid_autosize_oom", true));
        ajVar.uc(jSONObject.optBoolean("enable_proxy", true));
        x = jSONObject.optBoolean("autosize", true);
        ajVar.aj(jSONObject.optBoolean("report_task", false));
        ajVar.hw(jSONObject.optInt("wait_in_big", 50));
        ajVar.hn(jSONObject.optInt("wait_in_little", DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS));
        ajVar.x(jSONObject.optInt("run_cost", ErrorCode.UNKNOWN_ERROR));
    }
}
