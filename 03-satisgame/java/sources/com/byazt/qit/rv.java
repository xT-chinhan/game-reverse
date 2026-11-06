package com.byazt.qit;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.constants.ErrorCode;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv {
    public volatile ThreadPoolExecutor a;
    public volatile boolean bb;
    public volatile boolean cp;
    public int m;
    public volatile ScheduledExecutorService ou;
    public volatile ThreadPoolExecutor py;
    public boolean t;
    public com.byazt.ncu.l um;
    public volatile boolean ur;
    public static final int n = Runtime.getRuntime().availableProcessors();
    public static final rv qg = new rv();
    public static boolean q = true;
    public volatile boolean s = true;
    public long fs = 5000;
    public long rv = 20000;
    public volatile boolean tj = true;
    public boolean d = true;
    public long oa = 100;
    public long sz = 50;
    public long k = 1000;
    public long cy = 3000;
    public boolean hd = false;
    public volatile boolean cd = true;
    public boolean wm = true;
    public boolean hu = true;
    public com.byazt.ncu.qg h = new com.byazt.ncu.qg() { // from class: com.byazt.qit.rv.1
        @Override // com.byazt.ncu.qg
        public String n(String str) {
            if (str != null) {
                return str.startsWith("csj") ? str : "csj_".concat(String.valueOf(str));
            }
            return "csj_uk";
        }
    };
    public volatile boolean ln = true;
    public volatile boolean lh = true;
    public int l = Math.min(n, 4);
    public int w = 50;
    public int x = 10;

    private rv() {
    }

    public void n(int i) {
        this.m = i;
    }

    public boolean qg(int i) {
        return (this.m & i) == i;
    }

    public boolean n() {
        return this.d;
    }

    public void n(boolean z) {
        this.d = z;
    }

    public boolean qg() {
        return this.wm;
    }

    public void qg(boolean z) {
        this.wm = z;
    }

    public com.byazt.ncu.qg s() {
        return this.h;
    }

    public long q() {
        return this.oa;
    }

    public boolean l() {
        return this.s;
    }

    public void s(boolean z) {
        this.s = z;
    }

    public boolean w() {
        return this.t;
    }

    public void q(boolean z) {
        this.t = z;
    }

    public com.byazt.ncu.l x() {
        if (this.um == null) {
            this.um = new com.byazt.ncu.l();
        }
        return this.um;
    }

    public int fs() {
        return this.l;
    }

    public void s(int i) {
        this.l = i;
        tj().setCorePoolSize(i);
    }

    public ThreadPoolExecutor rv() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new com.byazt.oo.q(this.l, Math.max(this.x, this.l), this.rv, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new fs(10, "a") { // from class: com.byazt.qit.rv.2
                        @Override // com.byazt.qit.fs
                        public Thread n(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.a;
    }

    public ThreadPoolExecutor tj() {
        if (this.py == null) {
            synchronized (this) {
                if (this.py == null) {
                    this.py = new com.byazt.oo.qg(this.l, this.w, this.fs, TimeUnit.MILLISECONDS, new fs(10, "b") { // from class: com.byazt.qit.rv.3
                        @Override // com.byazt.qit.fs
                        public Thread n(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.lh) {
                        try {
                            this.py.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.py;
    }

    public void q(int i) {
        this.w = i;
        tj().setMaximumPoolSize(i);
    }

    public int cp() {
        return this.w;
    }

    public void l(int i) {
        if (i <= 0) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = this.a;
        if (threadPoolExecutor == null) {
            this.x = i;
            return;
        }
        int iMax = Math.max(i, threadPoolExecutor.getCorePoolSize());
        this.x = iMax;
        threadPoolExecutor.setMaximumPoolSize(iMax);
    }

    public int d() {
        return this.x;
    }

    public void l(boolean z) {
        this.cp = z;
    }

    public ScheduledExecutorService oa() {
        if (this.ou == null) {
            synchronized (this) {
                if (this.ou == null) {
                    this.ou = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.byazt.qit.rv.4
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, rv.this.t ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.byazt.xis.n.n);
                }
            }
        }
        return this.ou;
    }

    public ThreadPoolExecutor sz() {
        if (this.cp) {
            return tj();
        }
        return rv();
    }

    public void n(long j) {
        this.fs = j;
        tj().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void w(boolean z) {
        this.tj = z;
    }

    public boolean k() {
        return this.ur;
    }

    public void x(boolean z) {
        if (z) {
            fs(false);
            q = false;
        }
        this.ur = z;
    }

    public boolean cy() {
        return this.bb;
    }

    public boolean hd() {
        return this.ln && q;
    }

    public void fs(boolean z) {
        if (this.ur) {
            return;
        }
        if (this.py != null) {
            this.py.allowCoreThreadTimeOut(z);
        }
        this.lh = z;
    }

    public long cd() {
        return this.sz;
    }

    public void qg(long j) {
        this.sz = j;
    }

    public long um() {
        return this.k;
    }

    public void s(long j) {
        this.k = j;
    }

    public long a() {
        return this.cy;
    }

    public void q(long j) {
        this.cy = j;
    }

    public boolean py() {
        return this.hd;
    }

    public void rv(boolean z) {
        this.hd = z;
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rv rvVar = qg;
        int iOptInt = jSONObject.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            rvVar.q(iOptInt);
        }
        int iOptInt2 = jSONObject.optInt("little_max_mum", 0);
        if (iOptInt2 > 0) {
            rvVar.l(iOptInt2);
        }
        rvVar.fs(jSONObject.optBoolean("allow_core_thread_timeout", true));
        com.byazt.txb.qg.n().n(jSONObject.optInt("handler_pool_max_size", 2));
        int iOptInt3 = jSONObject.optInt("core_count", 0);
        if (iOptInt3 > 0) {
            rvVar.s(iOptInt3);
        }
        int iOptInt4 = jSONObject.optInt("big_keep_alive", 0);
        if (iOptInt4 > 0) {
            rvVar.n(iOptInt4);
        }
        rvVar.l(jSONObject.optBoolean("big_priority", false));
        rvVar.s(jSONObject.optBoolean("catch_oom", true));
        rvVar.qg(jSONObject.optBoolean("forbid_autosize_oom", true));
        rvVar.w(jSONObject.optBoolean("enable_proxy", true));
        q = jSONObject.optBoolean("autosize", true);
        rvVar.rv(jSONObject.optBoolean("report_task", false));
        rvVar.qg(jSONObject.optInt("wait_in_big", 50));
        rvVar.s(jSONObject.optInt("wait_in_little", 2000));
        rvVar.q(jSONObject.optInt("run_cost", ErrorCode.UNKNOWN_ERROR));
    }
}
