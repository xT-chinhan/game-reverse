package com.byazt.yt;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends x {
    public static final Set<String> c = Collections.synchronizedSet(new HashSet());
    public String aj;
    public String fw;
    public long g;
    public JSONObject ho;
    public com.byazt.ttf.pr k;
    public String m;
    public JSONObject uc;
    public String vk;
    public String w;
    public String zo;

    public static int vk() {
        return c.size();
    }

    public c(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        this.uc = new JSONObject();
        this.ho = null;
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject == null) {
                nt();
                jSONObjectOptJSONObject = this.hw.optJSONObject("params");
            }
            if (jSONObjectOptJSONObject != null) {
                this.zo = this.hw.optString(NotificationCompat.CATEGORY_EVENT);
                this.fw = jSONObjectOptJSONObject.optString("tag");
                this.m = jSONObjectOptJSONObject.optString("log_extra");
                this.aj = jSONObjectOptJSONObject.optString("category");
                this.vk = jSONObjectOptJSONObject.optString(Constants.VALUE_FIELD);
                this.w = jSONObjectOptJSONObject.optString("ext_value");
                String strOptString = jSONObjectOptJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                this.pr = jSONObjectOptJSONObject.optLong("event_ts");
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(strOptString);
                        this.ho = jSONObject2;
                        this.g = jSONObject2.optLong("sdk_event_index");
                        return;
                    } catch (Exception e) {
                        com.byazt.nn.fw.pr("log", "create error", e);
                        return;
                    }
                }
                return;
            }
            com.byazt.nn.fw.x("create err");
            return;
        }
        com.byazt.nn.fw.x("create error");
    }

    private void nt() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = this.hw;
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
            this.hw = jSONObject;
        } catch (Exception e) {
            com.byazt.nn.fw.pr("transform", e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(pr prVar) {
        super(null, null);
        JSONObject jSONObject = null;
        this.uc = new JSONObject();
        this.ho = null;
        this.k = prVar.zo;
        this.m = prVar.x;
        this.fw = prVar.pr;
        this.zo = prVar.hw;
        if (TextUtils.isEmpty(prVar.hn)) {
            this.aj = "app_union";
        } else {
            this.aj = prVar.hn;
        }
        this.vk = prVar.c;
        this.w = prVar.uc;
        this.uc = prVar.fw = prVar.fw != null ? prVar.fw : new JSONObject();
        this.pr = System.currentTimeMillis();
        try {
            this.g = hn.sAppLogEventIndex.incrementAndGet();
        } catch (Exception e) {
        }
        if ("show".equals(this.zo) && !TextUtils.isEmpty(this.vk)) {
            try {
                jSONObject = new JSONObject(this.m);
            } catch (Exception e2) {
            }
            String strX = com.byazt.nn.x.x(jSONObject);
            if (TextUtils.isEmpty(strX)) {
                c.add(this.vk);
            } else {
                c.add(strX + "_" + this.vk);
            }
        }
    }

    @Override // com.byazt.yt.x
    public JSONObject pr(String str) {
        JSONObject jSONObject;
        if (this.hn == null) {
            return this.hw;
        }
        JSONObject jSONObject2 = new JSONObject();
        k kVar = (k) com.byazt.zs.uc.pr("csj_settings", this.hn);
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("tag", this.fw);
            jSONObject3.putOpt("category", this.aj);
            jSONObject3.put("event_ts", this.pr);
            if (!TextUtils.isEmpty(this.vk)) {
                try {
                    jSONObject3.putOpt(Constants.VALUE_FIELD, Long.valueOf(Long.parseLong(this.vk)));
                } catch (NumberFormatException e) {
                    jSONObject3.putOpt(Constants.VALUE_FIELD, 0L);
                }
            }
            if (!TextUtils.isEmpty(this.w)) {
                jSONObject3.putOpt("ext_value", this.w);
            }
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject3.putOpt("log_extra", this.m);
            }
            if (!TextUtils.equals(this.zo, "pangle_live_sdk_monitor")) {
                jSONObject3.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            }
            jSONObject3.putOpt("nt", Integer.valueOf(((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L)));
            jSONObject3.putOpt("tob_ab_sdk_version", "");
            Iterator<String> itKeys = this.uc.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject3.putOpt(next, this.uc.opt(next));
            }
            com.byazt.ttf.pr prVar = this.k;
            if (prVar != null) {
                this.ho = prVar.pr(jSONObject3);
            }
            String strOptString = jSONObject3.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(strOptString);
            }
            JSONObject jSONObjectPr = pr(jSONObject, this.ho);
            this.ho = jSONObjectPr;
            jSONObjectPr.put("sdk_event_index", this.g);
            this.ho.put("sdk_event_self_count", com.byazt.nn.x.pr(this.zo));
            if (kVar.uc() && !TextUtils.isEmpty(str)) {
                this.ho.put("will_save_labels", str);
            }
            this.ho.put("create_ts", System.currentTimeMillis());
            this.ho.put("sdk_session_id", ((com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", this.hn)).hw());
            jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.ho.toString());
            jSONObject2.put(NotificationCompat.CATEGORY_EVENT, this.zo);
            jSONObject2.put("params", jSONObject3);
            jSONObject2.putOpt("local_time_ms", Long.valueOf(this.pr));
            jSONObject2.putOpt("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(this.pr)));
        } catch (Throwable th) {
            com.byazt.nn.fw.pr("AdEvent", th);
            com.byazt.nn.x.pr("csj_ad_event", null, th, this.x);
        }
        return jSONObject2;
    }

    @Override // com.byazt.hh.pr
    public byte w() {
        return (byte) 0;
    }

    @Override // com.byazt.hh.pr
    public byte k() {
        return m() ? (byte) 1 : (byte) 2;
    }

    public boolean m() {
        if (TextUtils.isEmpty(this.zo)) {
            return false;
        }
        return hw.pr.contains(this.zo);
    }

    @Override // com.byazt.hh.pr
    public long g() {
        return this.g;
    }

    @Override // com.byazt.hh.pr
    public String ho() {
        return this.zo;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1312, 169})
    public static final class pr {
        public String c;
        public JSONObject fw;
        public String hn;
        public String hw;
        public String pr;
        public String uc;
        public String x;
        public com.byazt.ttf.pr zo;

        public pr pr(String str) {
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            this.hw = str;
            return this;
        }

        public pr hn(String str) {
            this.hn = str;
            return this;
        }

        public pr x(String str) {
            this.x = str;
            return this;
        }

        public pr c(String str) {
            this.c = str;
            return this;
        }

        public pr uc(String str) {
            this.uc = str;
            return this;
        }

        public pr pr(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.fw = jSONObject;
            return this;
        }

        public c pr(com.byazt.ttf.pr prVar) {
            this.zo = prVar;
            return new c(this);
        }
    }
}
