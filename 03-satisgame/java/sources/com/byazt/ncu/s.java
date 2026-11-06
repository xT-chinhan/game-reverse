package com.byazt.ncu;

import com.byazt.qit.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 8})
public class s implements Comparable<s>, Runnable {
    public static final AtomicInteger n = new AtomicInteger(0);
    public static boolean qg = false;
    public long fs;
    public w q;
    public final Runnable s;
    public boolean l = true;
    public boolean w = true;
    public final long x = System.currentTimeMillis();
    public int rv = 0;
    public int tj = 0;

    public s(Runnable runnable) {
        this.s = runnable;
    }

    public s(Runnable runnable, w wVar) {
        this.s = runnable;
        this.q = wVar;
    }

    public void n(w wVar) {
        this.q = wVar;
    }

    public Runnable n() {
        return this.s;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        int i2;
        long j2;
        com.byazt.sf.s sVar;
        boolean zPy = rv.qg.py();
        if (zPy) {
            int activeCount = rv.qg.rv().getActiveCount();
            int activeCount2 = rv.qg.tj().getActiveCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            i2 = activeCount2;
            i = activeCount;
            j2 = jCurrentTimeMillis;
            j = (jCurrentTimeMillis - this.fs) - this.x;
        } else {
            j = 0;
            i = 0;
            i2 = 0;
            j2 = 0;
        }
        this.s.run();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
        if (!this.l && this.rv == 2) {
            n.decrementAndGet();
        }
        s(false);
        if (zPy) {
            if ((n(j) || jCurrentTimeMillis2 > rv.qg.a()) && (sVar = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null))) != null) {
                n(j, jCurrentTimeMillis2, "", 0, i, i2, sVar);
            }
        }
    }

    public void qg() {
        this.fs = System.currentTimeMillis() - this.x;
    }

    private boolean n(long j) {
        if (this.tj == 1) {
            return j > rv.qg.cd();
        }
        return j > rv.qg.um();
    }

    private void n(long j, long j2, String str, int i, int i2, int i3, com.byazt.sf.s sVar) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.x);
            jSONObject.put("is_wrap", this.s instanceof s);
            jSONObject.put("is_oom", qg);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.fs);
            jSONObject.put("pool_type", this.rv);
            jSONObject.put("origin_pool_type", this.tj);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put("thread_name", Thread.currentThread().getName());
            rv rvVar = rv.qg;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", rvVar.k());
            jSONObject.put("auto_size", rv.q);
            jSONObject.put("pri_task_in_little", n.get());
            jSONObject.put("core_count", rvVar.fs());
            jSONObject.put("max_pool_size", rvVar.cp());
            jSONObject.put("use_little_pool", rvVar.hd());
        } catch (Exception unused) {
        }
        sVar.n("task_run_cost", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.ncu.s.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private void s(boolean z) {
        w wVar = this.q;
        if (wVar != null) {
            wVar.n(this, z);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(s sVar) {
        Class<?> cls = this.s.getClass();
        Class<?> cls2 = sVar.s.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.s;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = sVar.s;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public boolean s() {
        return this.w;
    }

    public void qg(boolean z) {
        this.w = z;
    }

    public void n(int i) {
        int i2 = this.rv;
        if (i2 == 0) {
            this.tj = i;
        } else {
            this.tj = i2;
        }
        this.rv = i;
    }

    public int q() {
        return this.rv;
    }
}
