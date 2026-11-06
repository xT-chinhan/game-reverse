package com.byazt.jeb;

import android.os.Message;
import android.os.SystemClock;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1621, 26})
public final class qg {
    public final com.byazt.vr.qg w;
    public final cp x;
    public final AtomicInteger n = new AtomicInteger(0);
    public final AtomicInteger qg = new AtomicInteger(0);
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicBoolean q = new AtomicBoolean(false);
    public final AtomicLong l = new AtomicLong();

    public qg(com.byazt.vr.qg qgVar, cp cpVar) {
        this.w = qgVar;
        this.x = cpVar;
    }

    public void n(Message message) {
        if (message == null || message.what != 74 || this.n.decrementAndGet() > 0) {
            return;
        }
        x();
    }

    public void n() {
        this.n.incrementAndGet();
        q();
    }

    public void qg() {
        this.l.compareAndSet(0L, SystemClock.uptimeMillis());
        this.qg.incrementAndGet();
        l();
    }

    public void s() {
        this.qg.set(0);
        this.q.set(false);
        this.l.set(0L);
    }

    private void q() {
        int i;
        if (w() && (i = this.n.get()) >= 500 && this.s.compareAndSet(false, true)) {
            n(i);
        }
    }

    private void l() {
        int i;
        if (w() && (i = this.qg.get()) >= 500 && this.q.compareAndSet(false, true)) {
            qg(i);
        }
    }

    private boolean w() {
        com.byazt.vr.qg qgVar;
        cp cpVar = this.x;
        return (cpVar == null || !cpVar.fs() || (qgVar = this.w) == null || qgVar.n() == null) ? false : true;
    }

    private void n(int i) {
        if (this.w.n() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pending_new_event_count", i);
            com.byazt.hls.q.n("adlog_handler_block_monitor", jSONObject, null, this.w);
        } catch (Throwable th) {
            x.n("blocked monitor", th);
        }
    }

    private void qg(int i) {
        if (this.w.n() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init_delay_event_count", i);
            jSONObject.put("init_delay_first_diff", SystemClock.uptimeMillis() - this.l.get());
            com.byazt.hls.q.n("adlog_init_delay_monitor", jSONObject, null, this.w);
        } catch (Throwable th) {
            x.n("init delay monitor", th);
        }
    }

    private void x() {
        this.n.set(0);
        this.s.set(false);
    }
}
