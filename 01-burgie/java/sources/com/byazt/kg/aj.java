package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 61})
public class aj extends pr {
    public String a;
    public String g;
    public String ho;
    public long k;
    public String lb;
    public String m;
    public String nt;
    public int qa;
    public String yb;

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        List<String> listPr = super.pr();
        ArrayList arrayList = new ArrayList(listPr.size());
        arrayList.addAll(listPr);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", "integer", "is_back", "integer", "last_session", "varchar", "page_title", "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        int iPr = super.pr(cursor);
        int i = iPr + 1;
        this.g = cursor.getString(iPr);
        int i2 = i + 1;
        this.m = cursor.getString(i);
        int i3 = i2 + 1;
        this.k = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.qa = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.a = cursor.getString(i4);
        int i6 = i5 + 1;
        this.ho = cursor.getString(i5);
        int i7 = i6 + 1;
        this.nt = cursor.getString(i6);
        int i8 = i7 + 1;
        this.yb = cursor.getString(i7);
        int i9 = i8 + 1;
        this.lb = cursor.getString(i8);
        return i9;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        super.pr(contentValues);
        contentValues.put("page_key", this.g);
        contentValues.put("refer_page_key", this.m);
        contentValues.put("duration", Long.valueOf(this.k));
        contentValues.put("is_back", Integer.valueOf(this.qa));
        contentValues.put("last_session", this.a);
        contentValues.put("page_title", this.ho);
        contentValues.put("refer_page_title", this.nt);
        contentValues.put("page_path", this.yb);
        contentValues.put("referrer_page_path", this.lb);
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) throws JSONException {
        super.pr(jSONObject);
        jSONObject.put("page_key", this.g);
        jSONObject.put("refer_page_key", this.m);
        jSONObject.put("duration", this.k);
        jSONObject.put("is_back", this.qa);
        jSONObject.put("page_title", this.ho);
        jSONObject.put("refer_page_title", this.nt);
        jSONObject.put("page_path", this.yb);
        jSONObject.put("referrer_page_path", this.lb);
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        super.hw(jSONObject);
        this.g = jSONObject.optString("page_key", null);
        this.m = jSONObject.optString("refer_page_key", null);
        this.k = jSONObject.optLong("duration", 0L);
        this.qa = jSONObject.optInt("is_back", 0);
        this.ho = jSONObject.optString("page_title", null);
        this.nt = jSONObject.optString("refer_page_title", null);
        this.yb = jSONObject.optString("page_path", null);
        this.lb = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.byazt.kg.pr
    public JSONObject hw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.hw);
        jSONObject.put("tea_event_index", this.hn);
        jSONObject.put("session_id", this.x);
        if (this.c > 0) {
            jSONObject.put(Common.System.USER_ID, this.c);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.uc) ? JSONObject.NULL : this.uc);
        if (!TextUtils.isEmpty(this.fw)) {
            jSONObject.put("ssid", this.fw);
        }
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", k());
        jSONObject.put("datetime", this.w);
        return jSONObject;
    }

    private JSONObject k() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.g);
        jSONObject.put("refer_page_key", this.m);
        jSONObject.put("is_back", this.qa);
        jSONObject.put("duration", this.k);
        jSONObject.put("page_title", this.ho);
        jSONObject.put("refer_page_title", this.nt);
        jSONObject.put("page_path", this.yb);
        jSONObject.put("referrer_page_path", this.lb);
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "page";
    }

    public boolean vk() {
        return this.k == -1;
    }

    public boolean w() {
        return this.g.contains(":");
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return this.g + ", " + this.k;
    }
}
