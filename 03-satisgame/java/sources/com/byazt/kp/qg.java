package com.byazt.kp;

import android.text.TextUtils;
import com.byazt.hls.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, 26})
public class qg {
    public StringBuffer n = new StringBuffer();
    public StringBuffer qg = new StringBuffer();
    public AtomicLong s = new AtomicLong(0);
    public AtomicLong q = new AtomicLong(0);
    public AtomicLong l = new AtomicLong(0);
    public AtomicLong w = new AtomicLong(0);
    public AtomicLong x = new AtomicLong(0);
    public AtomicLong fs = new AtomicLong(0);
    public AtomicLong rv = new AtomicLong(0);
    public AtomicLong tj = new AtomicLong(0);
    public AtomicLong cp = new AtomicLong(0);
    public AtomicLong d = new AtomicLong(0);
    public AtomicLong oa = new AtomicLong(0);
    public AtomicLong sz = new AtomicLong(0);
    public AtomicLong k = new AtomicLong(0);
    public AtomicLong cy = new AtomicLong(0);
    public AtomicLong hd = new AtomicLong(0);
    public AtomicLong cd = new AtomicLong(0);
    public AtomicLong um = new AtomicLong(0);
    public AtomicLong a = new AtomicLong(0);
    public AtomicLong py = new AtomicLong(0);
    public AtomicLong ou = new AtomicLong(0);
    public AtomicLong wm = new AtomicLong(0);
    public AtomicLong m = new AtomicLong(0);
    public AtomicLong hu = new AtomicLong(0);
    public AtomicLong h = new AtomicLong(0);
    public AtomicLong t = new AtomicLong(0);
    public AtomicLong ur = new AtomicLong(0);
    public AtomicLong bb = new AtomicLong(0);
    public AtomicLong ln = new AtomicLong(0);
    public AtomicLong lh = new AtomicLong(0);
    public AtomicLong v = new AtomicLong(0);
    public AtomicLong j = new AtomicLong(0);
    public AtomicLong an = new AtomicLong(0);
    public AtomicLong ae = new AtomicLong(0);
    public AtomicLong f = new AtomicLong(0);

    public AtomicLong n() {
        return this.f;
    }

    public AtomicLong qg() {
        return this.ae;
    }

    public AtomicLong s() {
        return this.an;
    }

    public AtomicLong q() {
        return this.j;
    }

    public AtomicLong l() {
        return this.hu;
    }

    public synchronized void n(long j, com.byazt.vr.n nVar) {
        this.s.getAndAdd(j);
        this.q.incrementAndGet();
        if (TextUtils.equals("show", q.n(nVar))) {
            this.oa.incrementAndGet();
        } else {
            if (TextUtils.equals("click", q.n(nVar))) {
                this.k.incrementAndGet();
            }
        }
    }

    public JSONObject n(long j, com.byazt.vf.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = rv().get();
            jSONObject.put("type", "new_adlog_monitor");
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (d().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = fs().get();
            jSONObject.put("save_upload_cost_ts_avg", (oa().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.hu.get());
            jSONObject.put("all_delete_count", sz().get());
            jSONObject.put("success_delete_count", k().get());
            jSONObject.put("invalid_delete_count", cy().get());
            jSONObject.put("will_save_count", hd().get());
            jSONObject.put("will_save_show_count", an().get());
            jSONObject.put("save_success_show_count", ae().get());
            jSONObject.put("will_save_click_count", f().get());
            jSONObject.put("save_success_click_count", fi().get());
            jSONObject.put("did_send_count", tj().get());
            jSONObject.put("did_send_distinct_count", t().get());
            jSONObject.put("did_send_show_count", ur().get());
            jSONObject.put("did_send_show_distinct_count", bb().get());
            jSONObject.put("send_show_success_valid_count", ln().get());
            jSONObject.put("did_send_click_count", lh().get());
            jSONObject.put("did_send_click_distinct_count", v().get());
            jSONObject.put("send_click_success_valid_count", j().get());
            jSONObject.put("send_success_valid_count", cd().get());
            long j5 = x().get();
            jSONObject.put("send_success_invalid_count", um().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", cp().get());
            jSONObject.put("success_tm", q().get());
            jSONObject.put("queue_timeout_tm", s().get());
            jSONObject.put("after_upload_tm", qg().get());
            jSONObject.put("quit_tm", n().get());
            long j6 = py().get();
            long j7 = ou().get();
            jSONObject.put("success_request_cost_ts_avg", (wm().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = m().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", a().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", nVar.qg());
            jSONObject.put("app_start_time", s.q);
            jSONObject.put("app_first_time", s.l);
            jSONObject.put("fail_code_list", this.n.toString());
            jSONObject.put("delete_msg", this.qg.toString());
            jSONObject.put("is_debug", nVar.rv());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public synchronized void w() {
        oa().set(0L);
        py().set(0L);
        ou().set(0L);
        a().set(0L);
        m().set(0L);
        wm().set(0L);
        um().set(0L);
        cd().set(0L);
        t().set(0L);
        ur().set(0L);
        bb().set(0L);
        ln().set(0L);
        lh().set(0L);
        v().set(0L);
        j().set(0L);
        cy().set(0L);
        d().set(0L);
        sz().set(0L);
        hd().set(0L);
        an().set(0L);
        ae().set(0L);
        f().set(0L);
        fi().set(0L);
        k().set(0L);
        tj().set(0L);
        fs().set(0L);
        rv().set(0L);
        x().set(0L);
        cp().set(0L);
        q().set(0L);
        s().set(0L);
        qg().set(0L);
        n().set(0L);
        try {
            if (this.n.length() != 0) {
                this.n.setLength(0);
            }
        } catch (Exception unused) {
        }
        try {
            if (this.qg.length() != 0) {
                this.qg.setLength(0);
            }
        } catch (Exception unused2) {
        }
    }

    public AtomicLong x() {
        return this.tj;
    }

    public AtomicLong fs() {
        return this.w;
    }

    public AtomicLong rv() {
        return this.q;
    }

    public AtomicLong tj() {
        return this.cy;
    }

    public AtomicLong cp() {
        return this.v;
    }

    public AtomicLong d() {
        return this.s;
    }

    public AtomicLong oa() {
        return this.l;
    }

    public AtomicLong sz() {
        return this.x;
    }

    public AtomicLong k() {
        return this.fs;
    }

    public AtomicLong cy() {
        return this.rv;
    }

    public AtomicLong hd() {
        return this.cp;
    }

    public AtomicLong cd() {
        return this.m;
    }

    public AtomicLong um() {
        return this.h;
    }

    public AtomicLong a() {
        return this.t;
    }

    public AtomicLong py() {
        return this.ur;
    }

    public AtomicLong ou() {
        return this.bb;
    }

    public AtomicLong wm() {
        return this.ln;
    }

    public AtomicLong m() {
        return this.lh;
    }

    public StringBuffer hu() {
        return this.n;
    }

    public StringBuffer h() {
        return this.qg;
    }

    public AtomicLong t() {
        return this.hd;
    }

    public AtomicLong ur() {
        return this.cd;
    }

    public AtomicLong bb() {
        return this.um;
    }

    public AtomicLong ln() {
        return this.a;
    }

    public AtomicLong lh() {
        return this.py;
    }

    public AtomicLong v() {
        return this.ou;
    }

    public AtomicLong j() {
        return this.wm;
    }

    public AtomicLong an() {
        return this.d;
    }

    public AtomicLong ae() {
        return this.oa;
    }

    public AtomicLong f() {
        return this.sz;
    }

    public AtomicLong fi() {
        return this.k;
    }
}
