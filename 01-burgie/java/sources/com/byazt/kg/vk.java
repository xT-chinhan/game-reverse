package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.ec.w;
import com.taptap.sdk.db.constant.Common;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 50})
public class vk extends pr {
    public String g;
    public int ho = 0;
    public long k;
    public long m;

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        return null;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        w.hw((Throwable) null);
        return 0;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        w.hw((Throwable) null);
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) {
        w.hw((Throwable) null);
    }

    @Override // com.byazt.kg.pr
    public JSONObject hw() throws JSONException {
        uc ucVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hw);
        jSONObject.put("tea_event_index", this.hn);
        jSONObject.put("session_id", this.x);
        jSONObject.put("stop_timestamp", this.m / 1000);
        jSONObject.put("duration", this.k / 1000);
        jSONObject.put("datetime", this.w);
        if (this.c > 0) {
            jSONObject.put(Common.System.USER_ID, this.c);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.uc) ? JSONObject.NULL : this.uc);
        if (!TextUtils.isEmpty(this.fw)) {
            jSONObject.put("ssid", this.fw);
        }
        if (!TextUtils.isEmpty(this.zo)) {
            jSONObject.put("ab_sdk_version", this.zo);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.g, this.x)) {
                jSONObject.put("original_session_id", this.g);
            }
        }
        if (this.ho == 0 && (ucVar = (uc) hw.hw.get("launch")) != null && !ucVar.a) {
            this.ho = 6;
        }
        jSONObject.put("launch_from", this.ho);
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        w.hw((Throwable) null);
        return this;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "terminate";
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return String.valueOf(this.k);
    }
}
