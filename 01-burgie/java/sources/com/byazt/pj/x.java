package com.byazt.pj;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.ea.w;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.mg.PluginConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 121})
public class x {
    public final of hw;
    public volatile boolean pr = false;
    public String hn = "landingpage";
    public long x = 0;
    public long c = 0;
    public long uc = 0;
    public long fw = 0;
    public long zo = 0;
    public long aj = 0;
    public AtomicInteger vk = new AtomicInteger(0);
    public boolean w = false;
    public AtomicBoolean k = new AtomicBoolean(false);

    public x(of ofVar) {
        this.hw = ofVar;
    }

    public x pr(boolean z) {
        this.w = z;
        return this;
    }

    public void pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            of ofVar = this.hw;
            if (ofVar != null && w.zo(ofVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hw.ie()));
            }
        } catch (JSONException e) {
        }
        pr("open_url_h5", jSONObject);
    }

    public void hw() {
        if (!this.pr) {
            this.fw = System.currentTimeMillis();
            this.aj = System.currentTimeMillis();
            this.pr = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "ugen");
                of ofVar = this.hw;
                if (ofVar != null && w.zo(ofVar)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hw.ie()));
                }
            } catch (Exception e) {
            }
            pr("load_start", jSONObject);
        }
    }

    public void pr(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            of ofVar = this.hw;
            if (ofVar != null && w.zo(ofVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hw.ie()));
            }
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (JSONException e) {
        }
        pr("load_fail", jSONObject);
    }

    public void pr(long j) {
        if (this.k.get()) {
            return;
        }
        this.k.set(true);
        this.zo = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.zo - this.fw;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            of ofVar = this.hw;
            if (ofVar != null && w.zo(ofVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hw.ie()));
            }
        } catch (JSONException e) {
        }
        pr("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void hn() {
        this.uc = System.currentTimeMillis();
        this.x = System.currentTimeMillis();
    }

    public void pr(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.x, this.uc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.vk.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            of ofVar = this.hw;
            if (ofVar != null && w.zo(ofVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hw.ie()));
            }
        } catch (JSONException e) {
        }
        pr("stay_page", jSONObject, Math.min(jMax, 600000L));
    }

    public void x() {
        if (!this.k.get() && this.pr) {
            pr.pr(this.hw, this.hn, "load", new com.byazt.ttf.pr() { // from class: com.byazt.pj.x.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "ugen");
                    if (x.this.hw != null && w.zo(x.this.hw)) {
                        jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(x.this.hw.ie()));
                    }
                    com.byazt.ja.pr.pr(jSONObject2, x.this.hw);
                    jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                    jSONObject.put("duration", Math.min(System.currentTimeMillis() - x.this.aj, 600000L));
                    return jSONObject2;
                }
            });
        }
    }

    private void pr(String str, JSONObject jSONObject) {
        pr(str, jSONObject, -1L);
    }

    private void pr(String str, JSONObject jSONObject, long j) {
        if (!this.w || this.hw == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    jSONObject2 = jSONObject3;
                }
            } catch (JSONException e2) {
            }
        }
        pr.hn(this.hw, this.hn, str, jSONObject2);
    }
}
