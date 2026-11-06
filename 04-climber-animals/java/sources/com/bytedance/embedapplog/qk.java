package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qk extends tz {
    protected String sl;
    private boolean u;
    protected String zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "eventv3";
    }

    public qk(String str, boolean z, String str2) {
        this.zb = str;
        this.u = z;
        this.sl = str2;
        this.ch = 0;
    }

    public qk(String str, boolean z, String str2, int i) {
        this.zb = str;
        this.u = z;
        this.sl = str2;
        this.ch = i;
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        List<String> listMs = super.ms();
        ArrayList arrayList = new ArrayList(listMs.size());
        arrayList.addAll(listMs);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        int iMs = super.ms(cursor);
        int i = iMs + 1;
        this.zb = cursor.getString(iMs);
        int i2 = i + 1;
        this.sl = cursor.getString(i);
        int i3 = i2 + 1;
        this.u = cursor.getInt(i2) == 1;
        return i3;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        super.ms(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.zb);
        contentValues.put("params", this.sl);
        contentValues.put("is_bav", Integer.valueOf(this.u ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) throws JSONException {
        super.ms(jSONObject);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.zb);
        jSONObject.put("params", this.sl);
        jSONObject.put("is_bav", this.u);
    }

    @Override // com.bytedance.embedapplog.tz
    protected JSONObject xr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.xr);
        jSONObject.put("tea_event_index", this.ah);
        jSONObject.put("session_id", this.d);
        if (this.ka > 0) {
            jSONObject.put("user_id", this.ka);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.c) ? JSONObject.NULL : this.c);
        if (!TextUtils.isEmpty(this.ab)) {
            jSONObject.put("ssid", this.ab);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.zb);
        if (this.u) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.sl)) {
            jSONObject.put("params", new JSONObject(this.sl));
        }
        jSONObject.put("datetime", this.hi);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        super.xr(jSONObject);
        this.zb = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.sl = jSONObject.optString("params", null);
        this.u = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return this.zb;
    }

    @Override // com.bytedance.embedapplog.tz
    public String ny() {
        return this.sl;
    }
}
