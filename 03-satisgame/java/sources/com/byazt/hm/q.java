package com.byazt.hm;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.ep.cp;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 5})
public class q {
    public final pk qg;
    public volatile boolean n = false;
    public String s = "landingpage";
    public long q = 0;
    public long l = 0;
    public long w = 0;
    public long x = 0;
    public long fs = 0;
    public long rv = 0;
    public AtomicInteger tj = new AtomicInteger(0);
    public boolean cp = false;
    public AtomicBoolean d = new AtomicBoolean(false);

    public q(pk pkVar) {
        this.qg = pkVar;
    }

    public q n(boolean z) {
        this.cp = z;
        return this;
    }

    public void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            pk pkVar = this.qg;
            if (pkVar != null && cp.fs(pkVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.qg.cx()));
            }
        } catch (JSONException unused) {
        }
        n("open_url_h5", jSONObject);
    }

    public void qg() {
        if (this.n) {
            return;
        }
        this.x = System.currentTimeMillis();
        this.rv = System.currentTimeMillis();
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            pk pkVar = this.qg;
            if (pkVar != null && cp.fs(pkVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.qg.cx()));
            }
        } catch (Exception unused) {
        }
        n("load_start", jSONObject);
    }

    public void n(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            pk pkVar = this.qg;
            if (pkVar != null && cp.fs(pkVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.qg.cx()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (JSONException unused) {
        }
        n("load_fail", jSONObject);
    }

    public void n(long j) {
        if (this.d.get()) {
            return;
        }
        this.d.set(true);
        this.fs = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.fs - this.x;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            pk pkVar = this.qg;
            if (pkVar != null && cp.fs(pkVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.qg.cx()));
            }
        } catch (JSONException unused) {
        }
        n("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void s() {
        this.w = System.currentTimeMillis();
        this.q = System.currentTimeMillis();
    }

    public void n(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.l = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.q, this.w);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.tj.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            pk pkVar = this.qg;
            if (pkVar != null && cp.fs(pkVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.qg.cx()));
            }
        } catch (JSONException unused) {
        }
        n("stay_page", jSONObject, Math.min(jMax, 600000L));
    }

    public void q() {
        if (this.d.get() || !this.n) {
            return;
        }
        n.n(this.qg, this.s, "load", new com.byazt.rs.n() { // from class: com.byazt.hm.q.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (q.this.qg != null && cp.fs(q.this.qg)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(q.this.qg.cx()));
                }
                com.byazt.aci.n.n(jSONObject2, q.this.qg);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put(MediationConstant.EXTRA_DURATION, Math.min(System.currentTimeMillis() - q.this.rv, 600000L));
                return jSONObject2;
            }
        });
    }

    private void n(String str, JSONObject jSONObject) {
        n(str, jSONObject, -1L);
    }

    private void n(String str, JSONObject jSONObject, long j) {
        if (!this.cp || this.qg == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put(MediationConstant.EXTRA_DURATION, j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        n.s(this.qg, this.s, str, jSONObject2);
    }
}
