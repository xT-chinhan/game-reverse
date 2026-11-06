package com.byazt.asa;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 13})
public class w extends q {
    public oa fs;
    public com.byazt.rs.n l;
    public JSONObject rv;
    public String w;
    public long x;

    @Override // com.byazt.vr.n
    public byte cp() {
        return (byte) 3;
    }

    @Override // com.byazt.vr.n
    public byte d() {
        return (byte) 2;
    }

    public w(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        try {
            this.rv = new JSONObject(jSONObject.optJSONObject("params").optString("event_extra"));
            this.w = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            this.x = this.rv.optInt("eventIndex");
        } catch (Exception unused) {
        }
    }

    public w(String str, oa oaVar) {
        super(null, null);
        this.w = str;
        this.fs = oaVar;
        this.x = s.sMediationEventIndex.incrementAndGet();
    }

    public void n(com.byazt.rs.n nVar) {
        this.l = nVar;
    }

    @Override // com.byazt.vr.n
    public String k() {
        return this.w;
    }

    @Override // com.byazt.asa.q
    public JSONObject n(String str) {
        if (this.s == null) {
            return this.qg;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.w);
            com.byazt.rs.n nVar = this.l;
            if (nVar != null) {
                this.rv = nVar.n(jSONObject);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                JSONObject jSONObjectN = n(!TextUtils.isEmpty(strOptString) ? new JSONObject(strOptString) : null, this.rv);
                this.rv = jSONObjectN;
                jSONObjectOptJSONObject.putOpt("event_extra", jSONObjectN.toString());
            }
            jSONObject.putOpt("params", jSONObjectOptJSONObject);
            jSONObject.putOpt("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date()));
        } catch (Exception e) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        JSONObject jSONObject2 = new JSONObject(strOptString2);
                        jSONObject2.putOpt("v3_err_msg", e.toString());
                        jSONObjectOptJSONObject2.putOpt("event_extra", jSONObject2.toString());
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    @Override // com.byazt.vr.n
    public long sz() {
        return this.x;
    }
}
