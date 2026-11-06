package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s extends tz {
    public long ao;
    long h;
    public String sl;
    public String u;
    public String ub;
    public String zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    s() {
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        List<String> listMs = super.ms();
        ArrayList arrayList = new ArrayList(listMs.size());
        arrayList.addAll(listMs);
        arrayList.addAll(Arrays.asList("category", "varchar", TTDownloadField.TT_TAG, "varchar", com.anythink.core.common.e.f.a.d, "integer", "ext_value", "integer", "params", "varchar", TTDownloadField.TT_LABEL, "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        int iMs = super.ms(cursor);
        int i = iMs + 1;
        this.sl = cursor.getString(iMs);
        int i2 = i + 1;
        this.zb = cursor.getString(i);
        int i3 = i2 + 1;
        this.ao = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.h = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.ub = cursor.getString(i4);
        int i6 = i5 + 1;
        this.u = cursor.getString(i5);
        return i6;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        super.ms(contentValues);
        contentValues.put("category", this.sl);
        contentValues.put(TTDownloadField.TT_TAG, this.zb);
        contentValues.put(com.anythink.core.common.e.f.a.d, Long.valueOf(this.ao));
        contentValues.put("ext_value", Long.valueOf(this.h));
        contentValues.put("params", this.ub);
        contentValues.put(TTDownloadField.TT_LABEL, this.u);
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) throws JSONException {
        super.ms(jSONObject);
        jSONObject.put("tea_event_index", this.ah);
        jSONObject.put("category", this.sl);
        jSONObject.put(TTDownloadField.TT_TAG, this.zb);
        jSONObject.put(com.anythink.core.common.e.f.a.d, this.ao);
        jSONObject.put("ext_value", this.h);
        jSONObject.put("params", this.ub);
        jSONObject.put(TTDownloadField.TT_LABEL, this.u);
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        super.xr(jSONObject);
        this.ah = jSONObject.optLong("tea_event_index", 0L);
        this.sl = jSONObject.optString("category", null);
        this.zb = jSONObject.optString(TTDownloadField.TT_TAG, null);
        this.ao = jSONObject.optLong(com.anythink.core.common.e.f.a.d, 0L);
        this.h = jSONObject.optLong("ext_value", 0L);
        this.ub = jSONObject.optString("params", null);
        this.u = jSONObject.optString(TTDownloadField.TT_LABEL, null);
        return this;
    }

    @Override // com.bytedance.embedapplog.tz
    protected JSONObject xr() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.ub) ? new JSONObject(this.ub) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put("category", this.sl);
        jSONObject.put(TTDownloadField.TT_TAG, this.zb);
        jSONObject.put(com.anythink.core.common.e.f.a.d, this.ao);
        jSONObject.put("ext_value", this.h);
        jSONObject.put(TTDownloadField.TT_LABEL, this.u);
        jSONObject.put("datetime", this.hi);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return this.zb + ", " + this.u;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String ny() {
        return this.ub;
    }
}
