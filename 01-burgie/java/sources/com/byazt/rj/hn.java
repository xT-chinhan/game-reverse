package com.byazt.rj;

import com.byazt.xlm.aj;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1628, 20})
public class hn implements Comparable<hn>, Runnable {
    public final Runnable hn;
    public uc x;
    public long zo;
    public static final AtomicInteger pr = new AtomicInteger(0);
    public static boolean hw = false;
    public boolean c = true;
    public boolean uc = true;
    public final long fw = System.currentTimeMillis();
    public int aj = 0;
    public int vk = 0;

    public hn(Runnable runnable) {
        this.hn = runnable;
    }

    public hn(Runnable runnable, uc ucVar) {
        this.hn = runnable;
        this.x = ucVar;
    }

    public void pr(uc ucVar) {
        this.x = ucVar;
    }

    public Runnable pr() {
        return this.hn;
    }

    public void run() {
        long j;
        int i;
        int i2;
        com.byazt.fu.hn hnVar;
        boolean zA = aj.hw.a();
        long j2 = 0;
        if (!zA) {
            j = 0;
            i = 0;
            i2 = 0;
        } else {
            int activeCount = aj.hw.aj().getActiveCount();
            int activeCount2 = aj.hw.vk().getActiveCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            i = activeCount;
            i2 = activeCount2;
            j2 = jCurrentTimeMillis;
            j = (jCurrentTimeMillis - this.zo) - this.fw;
        }
        this.hn.run();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
        if (!this.c && this.aj == 2) {
            pr.decrementAndGet();
        }
        hn(false);
        if (!zA) {
            return;
        }
        if ((!pr(j) && jCurrentTimeMillis2 <= aj.hw.qa()) || (hnVar = (com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null))) == null) {
            return;
        }
        pr(j, jCurrentTimeMillis2, "", 0, i, i2, hnVar);
    }

    public void hw() {
        this.zo = System.currentTimeMillis() - this.fw;
    }

    private boolean pr(long j) {
        if (this.vk == 1) {
            return j > aj.hw.yb();
        }
        return j > aj.hw.lb();
    }

    private void pr(long j, long j2, String str, int i, int i2, int i3, com.byazt.fu.hn hnVar) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.fw);
            jSONObject.put("is_wrap", this.hn instanceof hn);
            jSONObject.put("is_oom", hw);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.zo);
            jSONObject.put("pool_type", this.aj);
            jSONObject.put("origin_pool_type", this.vk);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put(Constants.THREAD_NAME_FIELD, Thread.currentThread().getName());
            aj ajVar = aj.hw;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", ajVar.g());
            jSONObject.put("auto_size", aj.x);
            jSONObject.put("pri_task_in_little", pr.get());
            jSONObject.put("core_count", ajVar.zo());
            jSONObject.put("max_pool_size", ajVar.w());
            jSONObject.put("use_little_pool", ajVar.nt());
        } catch (Exception e) {
        }
        hnVar.pr("task_run_cost", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.rj.hn.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private void hn(boolean z) {
        uc ucVar = this.x;
        if (ucVar != null) {
            ucVar.pr(this, z);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        Class<?> cls = this.hn.getClass();
        Class<?> cls2 = hnVar.hn.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.hn;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = hnVar.hn;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public boolean hn() {
        return this.uc;
    }

    public void hw(boolean z) {
        this.uc = z;
    }

    public void pr(int i) {
        int i2 = this.aj;
        if (i2 == 0) {
            this.vk = i;
        } else {
            this.vk = i2;
        }
        this.aj = i;
    }

    public int x() {
        return this.aj;
    }
}
