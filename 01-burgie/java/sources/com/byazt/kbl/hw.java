package com.byazt.kbl;

import android.text.TextUtils;
import com.byazt.nn.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX, 13})
public class hw {
    public StringBuffer pr = new StringBuffer();
    public StringBuffer hw = new StringBuffer();
    public AtomicLong hn = new AtomicLong(0);
    public AtomicLong x = new AtomicLong(0);
    public AtomicLong c = new AtomicLong(0);
    public AtomicLong uc = new AtomicLong(0);
    public AtomicLong fw = new AtomicLong(0);
    public AtomicLong zo = new AtomicLong(0);
    public AtomicLong aj = new AtomicLong(0);
    public AtomicLong vk = new AtomicLong(0);
    public AtomicLong w = new AtomicLong(0);
    public AtomicLong k = new AtomicLong(0);
    public AtomicLong m = new AtomicLong(0);
    public AtomicLong g = new AtomicLong(0);
    public AtomicLong ho = new AtomicLong(0);
    public AtomicLong nt = new AtomicLong(0);
    public AtomicLong yb = new AtomicLong(0);
    public AtomicLong lb = new AtomicLong(0);
    public AtomicLong qa = new AtomicLong(0);
    public AtomicLong a = new AtomicLong(0);
    public AtomicLong cz = new AtomicLong(0);
    public AtomicLong ny = new AtomicLong(0);
    public AtomicLong fo = new AtomicLong(0);
    public AtomicLong rc = new AtomicLong(0);
    public AtomicLong z = new AtomicLong(0);
    public AtomicLong b = new AtomicLong(0);
    public AtomicLong iu = new AtomicLong(0);
    public AtomicLong ve = new AtomicLong(0);
    public AtomicLong gz = new AtomicLong(0);
    public AtomicLong nl = new AtomicLong(0);
    public AtomicLong y = new AtomicLong(0);
    public AtomicLong ww = new AtomicLong(0);
    public AtomicLong n = new AtomicLong(0);
    public AtomicLong e = new AtomicLong(0);
    public AtomicLong s = new AtomicLong(0);
    public AtomicLong ls = new AtomicLong(0);

    public AtomicLong pr() {
        return this.ls;
    }

    public AtomicLong hw() {
        return this.s;
    }

    public AtomicLong hn() {
        return this.e;
    }

    public AtomicLong x() {
        return this.n;
    }

    public AtomicLong c() {
        return this.z;
    }

    public synchronized void pr(long j, com.byazt.hh.pr prVar) {
        this.hn.getAndAdd(j);
        this.x.incrementAndGet();
        if (TextUtils.equals("show", x.pr(prVar))) {
            this.m.incrementAndGet();
        } else {
            if (TextUtils.equals("click", x.pr(prVar))) {
                this.ho.incrementAndGet();
            }
        }
    }

    public JSONObject pr(long j, com.byazt.vkw.pr prVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            long j2 = aj().get();
            jSONObject.put("type", "new_adlog_monitor");
            long j3 = 1;
            jSONObject.put("create_save_cost_ts_avg", (k().get() * 1.0f) / (j2 == 0 ? 1L : j2));
            jSONObject.put("save_success_count", j2);
            long j4 = zo().get();
            jSONObject.put("save_upload_cost_ts_avg", (m().get() * 1.0f) / (j4 == 0 ? 1L : j4));
            jSONObject.put("will_send_count", j4);
            jSONObject.put("sdk_event_index", j);
            jSONObject.put("sdk_send_success_count", this.z.get());
            jSONObject.put("all_delete_count", g().get());
            jSONObject.put("success_delete_count", ho().get());
            jSONObject.put("invalid_delete_count", nt().get());
            jSONObject.put("will_save_count", yb().get());
            jSONObject.put("will_save_show_count", e().get());
            jSONObject.put("save_success_show_count", s().get());
            jSONObject.put("will_save_click_count", ls().get());
            jSONObject.put("save_success_click_count", er().get());
            jSONObject.put("did_send_count", vk().get());
            jSONObject.put("did_send_distinct_count", iu().get());
            jSONObject.put("did_send_show_count", ve().get());
            jSONObject.put("did_send_show_distinct_count", gz().get());
            jSONObject.put("send_show_success_valid_count", nl().get());
            jSONObject.put("did_send_click_count", y().get());
            jSONObject.put("did_send_click_distinct_count", ww().get());
            jSONObject.put("send_click_success_valid_count", n().get());
            jSONObject.put("send_success_valid_count", lb().get());
            long j5 = fw().get();
            jSONObject.put("send_success_invalid_count", qa().get());
            jSONObject.put("send_fail_count", j5);
            jSONObject.put("before_save_count", w().get());
            jSONObject.put("success_tm", x().get());
            jSONObject.put("queue_timeout_tm", hn().get());
            jSONObject.put("after_upload_tm", hw().get());
            jSONObject.put("quit_tm", pr().get());
            long j6 = cz().get();
            long j7 = ny().get();
            jSONObject.put("success_request_cost_ts_avg", (fo().get() * 1.0f) / (j6 == 0 ? 1L : j6));
            float f = rc().get() * 1.0f;
            if (j7 != 0) {
                j3 = j7;
            }
            jSONObject.put("fail_request_cost_ts_avg", f / j3);
            jSONObject.put("request_count", a().get());
            jSONObject.put("request_success_count", j6);
            jSONObject.put("request_fail_count", j7);
            jSONObject.put("is_multi_process", prVar.hw());
            jSONObject.put("app_start_time", hn.x);
            jSONObject.put("app_first_time", hn.c);
            jSONObject.put("fail_code_list", this.pr.toString());
            jSONObject.put("delete_msg", this.hw.toString());
            jSONObject.put("is_debug", prVar.aj());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public synchronized void uc() {
        m().set(0L);
        cz().set(0L);
        ny().set(0L);
        a().set(0L);
        rc().set(0L);
        fo().set(0L);
        qa().set(0L);
        lb().set(0L);
        iu().set(0L);
        ve().set(0L);
        gz().set(0L);
        nl().set(0L);
        y().set(0L);
        ww().set(0L);
        n().set(0L);
        nt().set(0L);
        k().set(0L);
        g().set(0L);
        yb().set(0L);
        e().set(0L);
        s().set(0L);
        ls().set(0L);
        er().set(0L);
        ho().set(0L);
        vk().set(0L);
        zo().set(0L);
        aj().set(0L);
        fw().set(0L);
        w().set(0L);
        x().set(0L);
        hn().set(0L);
        hw().set(0L);
        pr().set(0L);
        try {
            if (this.pr.length() != 0) {
                this.pr.setLength(0);
            }
        } catch (Exception e) {
        }
        try {
            if (this.hw.length() != 0) {
                this.hw.setLength(0);
            }
        } catch (Exception e2) {
        }
    }

    public AtomicLong fw() {
        return this.vk;
    }

    public AtomicLong zo() {
        return this.uc;
    }

    public AtomicLong aj() {
        return this.x;
    }

    public AtomicLong vk() {
        return this.nt;
    }

    public AtomicLong w() {
        return this.ww;
    }

    public AtomicLong k() {
        return this.hn;
    }

    public AtomicLong m() {
        return this.c;
    }

    public AtomicLong g() {
        return this.fw;
    }

    public AtomicLong ho() {
        return this.zo;
    }

    public AtomicLong nt() {
        return this.aj;
    }

    public AtomicLong yb() {
        return this.w;
    }

    public AtomicLong lb() {
        return this.rc;
    }

    public AtomicLong qa() {
        return this.b;
    }

    public AtomicLong a() {
        return this.iu;
    }

    public AtomicLong cz() {
        return this.ve;
    }

    public AtomicLong ny() {
        return this.gz;
    }

    public AtomicLong fo() {
        return this.nl;
    }

    public AtomicLong rc() {
        return this.y;
    }

    public StringBuffer z() {
        return this.pr;
    }

    public StringBuffer b() {
        return this.hw;
    }

    public AtomicLong iu() {
        return this.yb;
    }

    public AtomicLong ve() {
        return this.lb;
    }

    public AtomicLong gz() {
        return this.qa;
    }

    public AtomicLong nl() {
        return this.a;
    }

    public AtomicLong y() {
        return this.cz;
    }

    public AtomicLong ww() {
        return this.ny;
    }

    public AtomicLong n() {
        return this.fo;
    }

    public AtomicLong e() {
        return this.k;
    }

    public AtomicLong s() {
        return this.m;
    }

    public AtomicLong ls() {
        return this.g;
    }

    public AtomicLong er() {
        return this.ho;
    }
}
