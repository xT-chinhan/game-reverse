package com.byazt.yt;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.vkw.g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, 5})
public class uc extends x {
    public JSONObject aj;
    public com.byazt.ttf.pr c;
    public long fw;
    public String uc;
    public g zo;

    public uc(String str, JSONObject jSONObject) {
        super(str, jSONObject);
        try {
            this.aj = new JSONObject(jSONObject.optJSONObject("params").optString("event_extra"));
            this.uc = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
            this.fw = this.aj.optInt("eventIndex");
        } catch (Exception e) {
        }
    }

    public uc(String str, g gVar) {
        super(null, null);
        this.uc = str;
        this.zo = gVar;
        this.fw = hn.sMediationEventIndex.incrementAndGet();
    }

    public void pr(com.byazt.ttf.pr prVar) {
        this.c = prVar;
    }

    @Override // com.byazt.hh.pr
    public byte w() {
        return (byte) 3;
    }

    @Override // com.byazt.hh.pr
    public byte k() {
        return (byte) 2;
    }

    @Override // com.byazt.hh.pr
    public String ho() {
        return this.uc;
    }

    @Override // com.byazt.yt.x
    public JSONObject pr(String str) {
        if (this.hn == null) {
            return this.hw;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, this.uc);
            com.byazt.ttf.pr prVar = this.c;
            if (prVar != null) {
                this.aj = prVar.pr(jSONObject);
            }
            JSONObject jSONObject2 = null;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("event_extra");
                if (!TextUtils.isEmpty(strOptString)) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                JSONObject jSONObjectPr = pr(jSONObject2, this.aj);
                this.aj = jSONObjectPr;
                jSONObjectOptJSONObject.putOpt("event_extra", jSONObjectPr.toString());
            }
            jSONObject.putOpt("params", jSONObjectOptJSONObject);
            jSONObject.putOpt("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date()));
        } catch (Exception e) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("event_extra");
                    if (!TextUtils.isEmpty(strOptString2)) {
                        JSONObject jSONObject3 = new JSONObject(strOptString2);
                        jSONObject3.putOpt("v3_err_msg", e.toString());
                        jSONObjectOptJSONObject2.putOpt("event_extra", jSONObject3.toString());
                    }
                }
            } catch (Throwable th) {
            }
        }
        return jSONObject;
    }

    @Override // com.byazt.hh.pr
    public long g() {
        return this.fw;
    }
}
