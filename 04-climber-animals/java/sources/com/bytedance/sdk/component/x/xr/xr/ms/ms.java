package com.bytedance.sdk.component.x.xr.xr.ms;

import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import com.bytedance.sdk.component.x.ms.x;
import com.bytedance.sdk.component.x.xr.xr.xr;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private StringBuffer f1584ms = new StringBuffer();
    private AtomicLong xr = new AtomicLong(0);
    private AtomicLong ah = new AtomicLong(0);
    private AtomicLong d = new AtomicLong(0);
    private AtomicLong ka = new AtomicLong(0);
    private AtomicLong c = new AtomicLong(0);
    private AtomicLong ab = new AtomicLong(0);
    private AtomicLong x = new AtomicLong(0);
    private AtomicLong ny = new AtomicLong(0);
    private AtomicLong ch = new AtomicLong(0);
    private AtomicLong hi = new AtomicLong(0);
    private AtomicLong sl = new AtomicLong(0);
    private AtomicLong zb = new AtomicLong(0);
    private AtomicLong u = new AtomicLong(0);
    private AtomicLong ub = new AtomicLong(0);
    private AtomicLong ao = new AtomicLong(0);
    private AtomicLong h = new AtomicLong(0);
    private AtomicLong qv = new AtomicLong(0);
    private AtomicLong y = new AtomicLong(0);
    private AtomicLong t = new AtomicLong(0);
    private AtomicLong nw = new AtomicLong(0);
    private AtomicLong b = new AtomicLong(0);
    private AtomicLong re = new AtomicLong(0);
    private AtomicLong i = new AtomicLong(0);

    public AtomicLong ms() {
        return this.i;
    }

    public AtomicLong xr() {
        return this.re;
    }

    public AtomicLong ah() {
        return this.b;
    }

    public AtomicLong d() {
        return this.nw;
    }

    public AtomicLong ka() {
        return this.zb;
    }

    public synchronized void ms(long j) {
        this.xr.getAndAdd(j);
        this.ah.incrementAndGet();
    }

    public JSONObject ms(long j, ka kaVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = ny().get();
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (sl().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = x().get();
            jSONObject.put("save_upload_cost_ts_avg", (zb().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.zb.get());
            jSONObject.put("all_delete_count", u().get());
            jSONObject.put("success_delete_count", ub().get());
            jSONObject.put("invalid_delete_count", ao().get());
            jSONObject.put("will_save_count", h().get());
            jSONObject.put("did_send_count", ch().get());
            jSONObject.put("send_success_valid_count", qv().get());
            long j5 = ab().get();
            jSONObject.put("send_success_invalid_count", y().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", hi().get());
            jSONObject.put("success_tm", d().get());
            jSONObject.put("queue_timeout_tm", ah().get());
            jSONObject.put("after_upload_tm", xr().get());
            jSONObject.put("quit_tm", ms().get());
            long j6 = nw().get();
            long j7 = b().get();
            jSONObject.put("success_request_cost_ts_avg", (re().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = i().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", t().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", kaVar.hi());
            jSONObject.put("app_start_time", xr.ah);
            jSONObject.put("app_first_time", xr.d);
            jSONObject.put("fail_code_list", this.f1584ms.toString());
            d dVarD = kaVar.d();
            if (dVarD != null) {
                jSONObject.put("is_debug", dVarD.ah());
                x xVarU = dVarD.u();
                if (xVarU != null) {
                    jSONObject.put("is_plugin", xVarU.x());
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    public synchronized void c() {
        zb().set(0L);
        nw().set(0L);
        b().set(0L);
        t().set(0L);
        i().set(0L);
        re().set(0L);
        y().set(0L);
        qv().set(0L);
        ao().set(0L);
        sl().set(0L);
        u().set(0L);
        h().set(0L);
        ub().set(0L);
        ch().set(0L);
        x().set(0L);
        ny().set(0L);
        ab().set(0L);
        hi().set(0L);
        d().set(0L);
        ah().set(0L);
        xr().set(0L);
        ms().set(0L);
        try {
            if (this.f1584ms.length() != 0) {
                this.f1584ms.setLength(0);
            }
        } catch (Exception unused) {
        }
    }

    public AtomicLong ab() {
        return this.ny;
    }

    public AtomicLong x() {
        return this.ka;
    }

    public AtomicLong ny() {
        return this.ah;
    }

    public AtomicLong ch() {
        return this.hi;
    }

    public AtomicLong hi() {
        return this.t;
    }

    public AtomicLong sl() {
        return this.xr;
    }

    public AtomicLong zb() {
        return this.d;
    }

    public AtomicLong u() {
        return this.c;
    }

    public AtomicLong ub() {
        return this.ab;
    }

    public AtomicLong ao() {
        return this.x;
    }

    public AtomicLong h() {
        return this.ch;
    }

    public AtomicLong qv() {
        return this.sl;
    }

    public AtomicLong y() {
        return this.u;
    }

    public AtomicLong t() {
        return this.ub;
    }

    public AtomicLong nw() {
        return this.ao;
    }

    public AtomicLong b() {
        return this.h;
    }

    public AtomicLong re() {
        return this.qv;
    }

    public AtomicLong i() {
        return this.y;
    }

    public StringBuffer w() {
        return this.f1584ms;
    }
}
