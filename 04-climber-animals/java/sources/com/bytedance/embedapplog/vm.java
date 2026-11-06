package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vm extends tz {
    public int ao;
    public String h;
    public String qv;
    public int sl;
    public boolean t;
    public boolean u;
    public String ub;
    public boolean y;
    public String zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "launch";
    }

    public vm(boolean z) {
        this.t = z;
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        List<String> listMs = super.ms();
        ArrayList arrayList = new ArrayList(listMs.size());
        arrayList.addAll(listMs);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", ArticleInfo.PAGE_TITLE, "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        int iMs = super.ms(cursor);
        int i = iMs + 1;
        this.zb = cursor.getString(iMs);
        int i2 = i + 1;
        this.sl = cursor.getInt(i);
        int i3 = i2 + 1;
        this.ub = cursor.getString(i2);
        int i4 = i3 + 1;
        this.ao = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.h = cursor.getString(i4);
        int i6 = i5 + 1;
        this.qv = cursor.getString(i5);
        int i7 = i6 + 1;
        this.y = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        super.ms(contentValues);
        contentValues.put("ver_name", this.zb);
        contentValues.put("ver_code", Integer.valueOf(this.sl));
        contentValues.put("last_session", this.ub);
        contentValues.put("is_first_time", Integer.valueOf(this.ao));
        contentValues.put(ArticleInfo.PAGE_TITLE, this.h);
        contentValues.put("page_key", this.qv);
        contentValues.put("resume_from_background", Integer.valueOf(this.y ? 1 : 0));
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) {
        oh.xr((Throwable) null);
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
        boolean z = this.u;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.hi);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        if (!TextUtils.isEmpty(this.ub)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.ub);
        }
        if (this.ao == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.t);
        jSONObject.put("is_background", !this.t);
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        oh.xr((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return this.u ? "bg" : "fg";
    }
}
