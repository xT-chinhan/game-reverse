package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class rt extends tz {
    public String ao;
    public String h;
    public String qv;
    public long sl;
    public String t;
    public String u;
    public String ub;
    public int y;
    public String zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "page";
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        List<String> listMs = super.ms();
        ArrayList arrayList = new ArrayList(listMs.size());
        arrayList.addAll(listMs);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        int iMs = super.ms(cursor);
        int i = iMs + 1;
        this.u = cursor.getString(iMs);
        int i2 = i + 1;
        this.zb = cursor.getString(i);
        int i3 = i2 + 1;
        this.sl = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.y = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.t = cursor.getString(i4);
        int i6 = i5 + 1;
        this.ub = cursor.getString(i5);
        int i7 = i6 + 1;
        this.ao = cursor.getString(i6);
        int i8 = i7 + 1;
        this.h = cursor.getString(i7);
        int i9 = i8 + 1;
        this.qv = cursor.getString(i8);
        return i9;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        super.ms(contentValues);
        contentValues.put("page_key", this.u);
        contentValues.put("refer_page_key", this.zb);
        contentValues.put("duration", Long.valueOf(this.sl));
        contentValues.put("is_back", Integer.valueOf(this.y));
        contentValues.put("last_session", this.t);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.ub);
        contentValues.put("refer_page_title", this.ao);
        contentValues.put("page_path", this.h);
        contentValues.put("referrer_page_path", this.qv);
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) throws JSONException {
        super.ms(jSONObject);
        jSONObject.put("page_key", this.u);
        jSONObject.put("refer_page_key", this.zb);
        jSONObject.put("duration", this.sl);
        jSONObject.put("is_back", this.y);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.ub);
        jSONObject.put("refer_page_title", this.ao);
        jSONObject.put("page_path", this.h);
        jSONObject.put("referrer_page_path", this.qv);
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        super.xr(jSONObject);
        this.u = jSONObject.optString("page_key", null);
        this.zb = jSONObject.optString("refer_page_key", null);
        this.sl = jSONObject.optLong("duration", 0L);
        this.y = jSONObject.optInt("is_back", 0);
        this.ub = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.ao = jSONObject.optString("refer_page_title", null);
        this.h = jSONObject.optString("page_path", null);
        this.qv = jSONObject.optString("referrer_page_path", null);
        return this;
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", sl());
        jSONObject.put("datetime", this.hi);
        return jSONObject;
    }

    private JSONObject sl() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.u);
        jSONObject.put("refer_page_key", this.zb);
        jSONObject.put("is_back", this.y);
        jSONObject.put("duration", this.sl);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.ub);
        jSONObject.put("refer_page_title", this.ao);
        jSONObject.put("page_path", this.h);
        jSONObject.put("referrer_page_path", this.qv);
        return jSONObject;
    }

    public boolean ch() {
        return this.sl == -1;
    }

    public boolean hi() {
        return this.u.contains(":");
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return this.u + ", " + this.sl;
    }
}
