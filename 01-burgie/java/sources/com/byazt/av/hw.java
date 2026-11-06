package com.byazt.av;

import android.os.Message;
import android.os.SystemClock;
import com.byazt.nn.fw;
import com.byazt.vkw.k;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 13})
public final class hw {
    public final k fw;
    public final com.byazt.hh.hw uc;
    public final AtomicInteger pr = new AtomicInteger(0);
    public final AtomicInteger hw = new AtomicInteger(0);
    public final AtomicBoolean hn = new AtomicBoolean(false);
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicLong c = new AtomicLong();

    public hw(com.byazt.hh.hw hwVar, k kVar) {
        this.uc = hwVar;
        this.fw = kVar;
    }

    public void pr(Message message) {
        if (message != null && message.what == 74 && this.pr.decrementAndGet() <= 0) {
            fw();
        }
    }

    public void pr() {
        this.pr.incrementAndGet();
        x();
    }

    public void hw() {
        this.c.compareAndSet(0L, SystemClock.uptimeMillis());
        this.hw.incrementAndGet();
        c();
    }

    public void hn() {
        this.hw.set(0);
        this.x.set(false);
        this.c.set(0L);
    }

    private void x() {
        int i;
        if (!uc() || (i = this.pr.get()) < 100 || !this.hn.compareAndSet(false, true)) {
            return;
        }
        pr(i);
    }

    private void c() {
        int i;
        if (!uc() || (i = this.hw.get()) < 100 || !this.x.compareAndSet(false, true)) {
            return;
        }
        hw(i);
    }

    private boolean uc() {
        com.byazt.hh.hw hwVar;
        k kVar = this.fw;
        return (kVar == null || !kVar.zo() || (hwVar = this.uc) == null || hwVar.pr() == null) ? false : true;
    }

    private void pr(int i) {
        if (this.uc.pr() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pending_new_event_count", i);
            com.byazt.nn.x.pr("adlog_handler_block_monitor", jSONObject, null, this.uc);
        } catch (Throwable th) {
            fw.pr("blocked monitor", th);
        }
    }

    private void hw(int i) {
        if (this.uc.pr() == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init_delay_event_count", i);
            jSONObject.put("init_delay_first_diff", SystemClock.uptimeMillis() - this.c.get());
            com.byazt.nn.x.pr("adlog_init_delay_monitor", jSONObject, null, this.uc);
        } catch (Throwable th) {
            fw.pr("init delay monitor", th);
        }
    }

    private void fw() {
        this.pr.set(0);
        this.hn.set(false);
    }
}
