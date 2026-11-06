package com.byazt.asa;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.f.e;
import com.byazt.ho.BaseConstants;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 18})
public class l extends q {
    public static final Set<String> l = Collections.synchronizedSet(new HashSet());
    public String cp;
    public com.byazt.rs.n d;
    public String fs;
    public JSONObject k;
    public String oa;
    public String rv;
    public long sz;
    public String tj;
    public JSONObject w;
    public String x;

    @Override // com.byazt.vr.n
    public byte cp() {
        return (byte) 0;
    }

    public static int tj() {
        return l.size();
    }

    public l(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        this.w = new JSONObject();
        this.k = null;
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject == null) {
                cy();
                jSONObjectOptJSONObject = this.qg.optJSONObject("params");
            }
            if (jSONObjectOptJSONObject != null) {
                this.fs = this.qg.optString(NotificationCompat.CATEGORY_EVENT);
                this.x = jSONObjectOptJSONObject.optString("tag");
                this.oa = jSONObjectOptJSONObject.optString("log_extra");
                this.rv = jSONObjectOptJSONObject.optString("category");
                this.tj = jSONObjectOptJSONObject.optString(e.a.d);
                this.cp = jSONObjectOptJSONObject.optString("ext_value");
                String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                this.n = jSONObjectOptJSONObject.optLong("event_ts");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    this.k = jSONObject2;
                    this.sz = jSONObject2.optLong("sdk_event_index");
                    return;
                } catch (Exception e) {
                    com.byazt.hls.x.n("log", "create error", e);
                    return;
                }
            }
            com.byazt.hls.x.q("create err");
            return;
        }
        com.byazt.hls.x.q("create error");
    }

    private void cy() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = this.qg;
            String strOptString = jSONObject2.optString("label");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject2.optString(NotificationCompat.CATEGORY_EVENT);
            }
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, strOptString);
            long jOptLong = jSONObject2.optLong("event_ts", System.currentTimeMillis());
            jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
            jSONObject.putOpt("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jOptLong)));
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject2.has("params") && jSONObject2.has(NotificationCompat.CATEGORY_EVENT)) {
                jSONObject3 = jSONObject2.optJSONObject("params");
                if (jSONObject3 == null) {
                    jSONObject3 = new JSONObject();
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject3.putOpt(next, jSONObject2.opt(next));
                        }
                    }
                }
            } else {
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (!TextUtils.equals(next2, "label")) {
                        jSONObject3.putOpt(next2, jSONObject2.opt(next2));
                    }
                }
            }
            jSONObject.putOpt("params", jSONObject3);
            this.qg = jSONObject;
        } catch (Exception e) {
            com.byazt.hls.x.n("transform", e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar) {
        super(null, null);
        JSONObject jSONObject = null;
        this.w = new JSONObject();
        this.k = null;
        this.d = nVar.fs;
        this.oa = nVar.q;
        this.x = nVar.n;
        this.fs = nVar.qg;
        if (TextUtils.isEmpty(nVar.s)) {
            this.rv = "app_union";
        } else {
            this.rv = nVar.s;
        }
        this.tj = nVar.l;
        this.cp = nVar.w;
        this.w = nVar.x = nVar.x != null ? nVar.x : new JSONObject();
        this.n = System.currentTimeMillis();
        try {
            this.sz = s.sAppLogEventIndex.incrementAndGet();
        } catch (Exception unused) {
        }
        if (!"show".equals(this.fs) || TextUtils.isEmpty(this.tj)) {
            return;
        }
        try {
            jSONObject = new JSONObject(this.oa);
        } catch (Exception unused2) {
        }
        String strQ = com.byazt.hls.q.q(jSONObject);
        if (TextUtils.isEmpty(strQ)) {
            l.add(this.tj);
        } else {
            l.add(strQ + "_" + this.tj);
        }
    }

    @Override // com.byazt.asa.q
    public JSONObject n(String str) {
        if (this.s == null) {
            return this.qg;
        }
        JSONObject jSONObject = new JSONObject();
        cp cpVar = (cp) com.byazt.qp.q.n("csj_settings", this.s);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("tag", this.x);
            jSONObject2.putOpt("category", this.rv);
            jSONObject2.put("event_ts", this.n);
            if (!TextUtils.isEmpty(this.tj)) {
                try {
                    jSONObject2.putOpt(e.a.d, Long.valueOf(Long.parseLong(this.tj)));
                } catch (NumberFormatException unused) {
                    jSONObject2.putOpt(e.a.d, 0L);
                }
            }
            if (!TextUtils.isEmpty(this.cp)) {
                jSONObject2.putOpt("ext_value", this.cp);
            }
            if (!TextUtils.isEmpty(this.oa)) {
                jSONObject2.putOpt("log_extra", this.oa);
            }
            if (!TextUtils.equals(this.fs, "pangle_live_sdk_monitor")) {
                jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            }
            jSONObject2.putOpt("nt", Integer.valueOf(((oa) com.byazt.qp.q.n("device_info_new")).n(60000L)));
            jSONObject2.putOpt("tob_ab_sdk_version", "");
            Iterator<String> itKeys = this.w.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.putOpt(next, this.w.opt(next));
            }
            com.byazt.rs.n nVar = this.d;
            if (nVar != null) {
                this.k = nVar.n(jSONObject2);
            }
            String strOptString = jSONObject2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            JSONObject jSONObjectN = n(!TextUtils.isEmpty(strOptString) ? new JSONObject(strOptString) : null, this.k);
            this.k = jSONObjectN;
            jSONObjectN.put("sdk_event_index", this.sz);
            this.k.put("sdk_event_self_count", com.byazt.hls.q.n(this.fs));
            if (cpVar.w() && !TextUtils.isEmpty(str)) {
                this.k.put("will_save_labels", str);
            }
            this.k.put("create_ts", System.currentTimeMillis());
            this.k.put("sdk_session_id", ((com.byazt.sf.s) com.byazt.qp.q.n("ad_log", this.s)).qg());
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.k.toString());
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.fs);
            jSONObject.put("params", jSONObject2);
            jSONObject.putOpt("local_time_ms", Long.valueOf(this.n));
            jSONObject.putOpt("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(this.n)));
        } catch (Throwable th) {
            com.byazt.hls.x.n("AdEvent", th);
            com.byazt.hls.q.n("csj_ad_event", null, th, this.q);
        }
        return jSONObject;
    }

    @Override // com.byazt.vr.n
    public byte d() {
        return oa() ? (byte) 1 : (byte) 2;
    }

    public boolean oa() {
        if (TextUtils.isEmpty(this.fs)) {
            return false;
        }
        return qg.n.contains(this.fs);
    }

    @Override // com.byazt.vr.n
    public long sz() {
        return this.sz;
    }

    @Override // com.byazt.vr.n
    public String k() {
        return this.fs;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static final class n {
        public com.byazt.rs.n fs;
        public String l;
        public String n;
        public String q;
        public String qg;
        public String s;
        public String w;
        public JSONObject x;

        public n n(String str) {
            this.n = str;
            return this;
        }

        public n qg(String str) {
            this.qg = str;
            return this;
        }

        public n s(String str) {
            this.s = str;
            return this;
        }

        public n q(String str) {
            this.q = str;
            return this;
        }

        public n l(String str) {
            this.l = str;
            return this;
        }

        public n w(String str) {
            this.w = str;
            return this;
        }

        public n n(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.x = jSONObject;
            return this;
        }

        public l n(com.byazt.rs.n nVar) {
            this.fs = nVar;
            return new l(this);
        }
    }
}
