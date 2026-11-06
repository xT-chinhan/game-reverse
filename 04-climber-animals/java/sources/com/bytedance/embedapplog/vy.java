package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vy extends tz {
    long sl;
    String u;
    public int ub = 0;
    long zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "terminate";
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        return null;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        oh.xr((Throwable) null);
        return 0;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        oh.xr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) {
        oh.xr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.tz
    protected JSONObject xr() throws JSONException {
        vm vmVar;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.xr);
        jSONObject.put("tea_event_index", this.ah);
        jSONObject.put("session_id", this.d);
        jSONObject.put("stop_timestamp", this.zb / 1000);
        jSONObject.put("duration", this.sl / 1000);
        jSONObject.put("datetime", this.hi);
        if (this.ka > 0) {
            jSONObject.put("user_id", this.ka);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.c) ? JSONObject.NULL : this.c);
        if (!TextUtils.isEmpty(this.ab)) {
            jSONObject.put("ssid", this.ab);
        }
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        if (!TextUtils.isEmpty(this.u)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.u, this.d)) {
                jSONObject.put("original_session_id", this.u);
            }
        }
        if (this.ub == 0 && (vmVar = (vm) ti.xr.get("launch")) != null && !vmVar.t) {
            this.ub = 6;
        }
        jSONObject.put("launch_from", this.ub);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        oh.xr((Throwable) null);
        return this;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return String.valueOf(this.sl);
    }
}
