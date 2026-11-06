package com.bytedance.sdk.openadsdk.core.zb;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.x.xr.d.ms.xr {
    private static final AtomicLong ah = new AtomicLong(0);
    private String ab;
    private String c;
    private com.bytedance.sdk.openadsdk.c.ms.ms ch;
    private JSONObject d;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String f3864ms;
    private String ny;
    private long sl;
    private AtomicBoolean u = new AtomicBoolean(false);
    private String x;
    protected final JSONObject xr;
    private long zb;

    ms(C0332ms c0332ms) {
        this.d = new JSONObject();
        this.f3864ms = TextUtils.isEmpty(c0332ms.f3865ms) ? UUID.randomUUID().toString() : c0332ms.f3865ms;
        this.ch = c0332ms.ch;
        this.hi = c0332ms.ka;
        this.ka = c0332ms.xr;
        this.c = c0332ms.ah;
        if (TextUtils.isEmpty(c0332ms.d)) {
            this.ab = "app_union";
        } else {
            this.ab = c0332ms.d;
        }
        this.x = c0332ms.c;
        this.ny = c0332ms.ab;
        this.d = c0332ms.x = c0332ms.x != null ? c0332ms.x : new JSONObject();
        this.zb = System.currentTimeMillis();
        this.xr = new JSONObject();
        try {
            ab();
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.d.ms.xr
    public long ms() {
        return this.zb;
    }

    private void ab() {
        this.sl = ah.incrementAndGet();
    }

    public String ah() {
        if (TextUtils.isEmpty(this.c)) {
            JSONObject jSONObject = this.xr;
            return jSONObject != null ? jSONObject.optString(TTDownloadField.TT_LABEL) : "";
        }
        return this.c;
    }

    public String d() {
        return this.f3864ms;
    }

    @Override // com.bytedance.sdk.component.x.xr.d.ms.xr
    public JSONObject ms(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectKa = ka();
        try {
            String strOptString = jSONObjectKa.optString("ad_extra_data");
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject = new JSONObject();
                if (re.xr().nw() && !TextUtils.isEmpty(str)) {
                    jSONObject.put("will_save_labels", str);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (re.xr().nw() && TextUtils.isEmpty(jSONObject2.optString("will_save_labels")) && !TextUtils.isEmpty(str)) {
                    jSONObject2.put("will_save_labels", str);
                }
                jSONObject = jSONObject2;
            }
            String strAb = com.bytedance.sdk.openadsdk.core.live.xr.ms().ab();
            if (strAb != null) {
                jSONObject.putOpt("live_plugin_version", strAb.replaceAll("\\.", ""));
            }
            if (ch.ub().ab()) {
                jSONObject.putOpt("first_of_two", 1);
            }
            jSONObjectKa.put("ad_extra_data", jSONObject.toString());
        } catch (Exception e) {
            sl.ms(e);
        }
        return jSONObjectKa;
    }

    public JSONObject ka() {
        if (this.u.get()) {
            return this.xr;
        }
        try {
            x();
            com.bytedance.sdk.openadsdk.c.ms.ms msVar = this.ch;
            if (msVar != null) {
                msVar.ms(this.xr);
            }
            ms(this.xr);
            this.u.set(true);
        } catch (Throwable th) {
            sl.xr("AdEvent", th);
        }
        return this.xr;
    }

    private void ms(JSONObject jSONObject) {
        try {
            if (this.sl != 0) {
                String strOptString = jSONObject.optString("ad_extra_data");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (jSONObject2.optInt("sdk_event_index") == 0) {
                        jSONObject2.put("sdk_event_index", this.sl);
                    }
                    if (jSONObject2.optInt("sdk_event_self_count") == 0) {
                        jSONObject2.put("sdk_event_self_count", com.bytedance.sdk.component.x.xr.ah.ms.ms(this.c));
                    }
                    jSONObject2.put("create_ts", System.currentTimeMillis());
                    jSONObject2.put("csj_type", ch.ub().lm() ? 1 : 0);
                    jSONObject2.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.d.ms.d());
                    jSONObject2.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.t.xr.f3363ms);
                    if (!TextUtils.isEmpty(f.ny)) {
                        jSONObject2.put("wrong_stats_url", f.ny);
                    }
                    if (!TextUtils.isEmpty(f.ch)) {
                        jSONObject2.put("wrong_applog_url", f.ch);
                    }
                    com.bytedance.sdk.openadsdk.core.ul.ms.ms().ms(jSONObject2);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_event_index", this.sl);
                jSONObject3.put("sdk_event_self_count", com.bytedance.sdk.component.x.xr.ah.ms.ms(this.c));
                jSONObject3.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.t.xr.f3363ms);
                jSONObject3.put("csj_type", ch.ub().lm() ? 1 : 0);
                jSONObject3.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.d.ms.d());
                jSONObject3.put("create_ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(f.ny)) {
                    jSONObject3.put("wrong_stats_url", f.ny);
                }
                if (!TextUtils.isEmpty(f.ch)) {
                    jSONObject3.put("wrong_applog_url", f.ch);
                }
                com.bytedance.sdk.openadsdk.core.ul.ms.ms().ms(jSONObject3);
                jSONObject.put("ad_extra_data", jSONObject3.toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.x.xr.d.ms.xr
    public long xr() {
        return this.sl;
    }

    private void x() throws JSONException {
        this.xr.putOpt(TTDownloadField.TT_TAG, this.ka);
        this.xr.putOpt(TTDownloadField.TT_LABEL, this.c);
        this.xr.putOpt("category", this.ab);
        if (!TextUtils.isEmpty(this.x)) {
            try {
                this.xr.putOpt(com.anythink.core.common.e.f.a.d, Long.valueOf(Long.parseLong(this.x)));
            } catch (NumberFormatException unused) {
                this.xr.putOpt(com.anythink.core.common.e.f.a.d, 0L);
            }
        }
        if (!TextUtils.isEmpty(this.ny)) {
            this.xr.putOpt("ext_value", this.ny);
        }
        if (!TextUtils.isEmpty(this.hi)) {
            this.xr.putOpt("log_extra", this.hi);
        }
        if (!TextUtils.equals(this.c, "pangle_live_sdk_monitor")) {
            this.xr.putOpt("is_ad_event", "1");
        }
        this.xr.putOpt("nt", Integer.valueOf(u.ah(re.getContext())));
        this.xr.putOpt("tob_ab_sdk_version", ch.ub().eg());
        Iterator<String> itKeys = this.d.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.xr.putOpt(next, this.d.opt(next));
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.zb.ms$ms, reason: collision with other inner class name */
    public static final class C0332ms {
        private String ab;
        private String ah;
        private String c;
        private com.bytedance.sdk.openadsdk.c.ms.ms ch;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f3865ms;
        private com.bytedance.sdk.openadsdk.c.ms.xr ny;
        private JSONObject x;
        private String xr;

        public C0332ms ms(String str) {
            this.xr = str;
            return this;
        }

        public C0332ms xr(String str) {
            this.ah = str;
            return this;
        }

        public C0332ms ah(String str) {
            this.d = str;
            return this;
        }

        public C0332ms d(String str) {
            this.ka = str;
            return this;
        }

        public C0332ms ka(String str) {
            this.c = str;
            return this;
        }

        public C0332ms c(String str) {
            this.ab = str;
            return this;
        }

        public C0332ms ms(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.x = jSONObject;
            return this;
        }

        public void ms(com.bytedance.sdk.openadsdk.c.ms.ms msVar) {
            if (com.bytedance.sdk.openadsdk.core.t.ka.ms(this.ah, 1.0d)) {
                this.ch = msVar;
                ms msVar2 = new ms(this);
                try {
                    com.bytedance.sdk.openadsdk.c.ms.xr xrVar = this.ny;
                    if (xrVar != null) {
                        xrVar.ms(msVar2.xr);
                    } else {
                        new com.bytedance.sdk.openadsdk.c.ms.ah().ms(msVar2.xr);
                    }
                } catch (Throwable th) {
                    sl.xr("AdEvent", th);
                }
                com.bytedance.sdk.openadsdk.core.t.xr.ms(msVar2, this.ah);
            }
        }
    }

    public boolean c() {
        JSONObject jSONObject = this.xr;
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString(TTDownloadField.TT_LABEL);
        if (TextUtils.isEmpty(strOptString)) {
            if (TextUtils.isEmpty(this.c)) {
                return false;
            }
            return xr.f3898ms.contains(this.c);
        }
        return xr.f3898ms.contains(strOptString);
    }
}
