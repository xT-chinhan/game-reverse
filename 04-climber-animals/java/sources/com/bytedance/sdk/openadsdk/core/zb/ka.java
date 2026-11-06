package com.bytedance.sdk.openadsdk.core.zb;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.ch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private final lm xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile boolean f3862ms = false;
    private String ah = "landingpage";
    private long d = 0;
    private long ka = 0;
    private long c = 0;
    private long ab = 0;
    private long x = 0;
    private long ny = 0;
    private AtomicInteger ch = new AtomicInteger(0);
    private boolean hi = false;
    private AtomicBoolean sl = new AtomicBoolean(false);

    public ka(lm lmVar) {
        this.xr = lmVar;
    }

    public ka ms(boolean z) {
        this.hi = z;
        return this;
    }

    public void ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(j.w.E, "ugen");
            lm lmVar = this.xr;
            if (lmVar != null && ch.x(lmVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xr.qv()));
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        ms("open_url_h5", jSONObject);
    }

    public void xr() {
        if (this.f3862ms) {
            return;
        }
        this.ab = System.currentTimeMillis();
        this.ny = System.currentTimeMillis();
        this.f3862ms = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(j.w.E, "ugen");
            lm lmVar = this.xr;
            if (lmVar != null && ch.x(lmVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xr.qv()));
            }
        } catch (Exception unused) {
        }
        ms("load_start", jSONObject);
    }

    public void ms(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(j.w.E, "ugen");
            lm lmVar = this.xr;
            if (lmVar != null && ch.x(lmVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xr.qv()));
            }
            jSONObject.putOpt("code", Integer.valueOf(i));
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            sl.ms(e);
        }
        ms("load_fail", jSONObject);
    }

    public void ms(long j) {
        if (this.sl.get()) {
            return;
        }
        this.sl.set(true);
        this.x = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.x - this.ab;
        try {
            jSONObject.putOpt(j.w.E, "ugen");
            jSONObject.put("net_work_duration", j);
            lm lmVar = this.xr;
            if (lmVar != null && ch.x(lmVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xr.qv()));
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        ms("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void ah() {
        this.c = System.currentTimeMillis();
        this.d = System.currentTimeMillis();
    }

    public void ms(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.ka = jCurrentTimeMillis;
        long jMax = jCurrentTimeMillis - Math.max(this.d, this.c);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.ch.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt(j.w.E, "ugen");
            lm lmVar = this.xr;
            if (lmVar != null && ch.x(lmVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.xr.qv()));
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        ms("stay_page", jSONObject, Math.min(jMax, 600000L));
    }

    public void d() {
        if (this.sl.get() || !this.f3862ms) {
            return;
        }
        ah.ms(this.xr, this.ah, "load", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.ka.1
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt(j.w.E, "ugen");
                if (ka.this.xr != null && ch.x(ka.this.xr)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(ka.this.xr.qv()));
                }
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject2, ka.this.xr);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(System.currentTimeMillis() - ka.this.ny, 600000L));
            }
        });
    }

    private void ms(String str, JSONObject jSONObject) {
        ms(str, jSONObject, -1L);
    }

    private void ms(String str, JSONObject jSONObject, long j) {
        if (!this.hi || this.xr == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject3;
                    sl.ms(e);
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        ah.ah(this.xr, this.ah, str, jSONObject2);
    }
}
