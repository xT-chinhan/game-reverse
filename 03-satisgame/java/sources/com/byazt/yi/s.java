package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.f.e;
import com.anythink.core.common.l.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 8})
public class s extends n {
    public long cy;
    public String d;
    public long hd;
    public String k;
    public String oa;
    public String sz;

    @Override // com.byazt.yi.n
    public String q() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        List<String> listN = super.n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", e.a.d, "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        int iN = super.n(cursor);
        int i = iN + 1;
        this.d = cursor.getString(iN);
        int i2 = i + 1;
        this.oa = cursor.getString(i);
        int i3 = i2 + 1;
        this.cy = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.hd = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.k = cursor.getString(i4);
        int i6 = i5 + 1;
        this.sz = cursor.getString(i5);
        return i6;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        super.n(contentValues);
        contentValues.put("category", this.d);
        contentValues.put("tag", this.oa);
        contentValues.put(e.a.d, Long.valueOf(this.cy));
        contentValues.put("ext_value", Long.valueOf(this.hd));
        contentValues.put("params", this.k);
        contentValues.put("label", this.sz);
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) throws JSONException {
        super.n(jSONObject);
        jSONObject.put("tea_event_index", this.s);
        jSONObject.put("category", this.d);
        jSONObject.put("tag", this.oa);
        jSONObject.put(e.a.d, this.cy);
        jSONObject.put("ext_value", this.hd);
        jSONObject.put("params", this.k);
        jSONObject.put("label", this.sz);
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        super.qg(jSONObject);
        this.s = jSONObject.optLong("tea_event_index", 0L);
        this.d = jSONObject.optString("category", null);
        this.oa = jSONObject.optString("tag", null);
        this.cy = jSONObject.optLong(e.a.d, 0L);
        this.hd = jSONObject.optLong("ext_value", 0L);
        this.k = jSONObject.optString("params", null);
        this.sz = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.byazt.yi.n
    public JSONObject qg() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.k) ? new JSONObject(this.k) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.qg);
        jSONObject.put("tea_event_index", this.s);
        jSONObject.put(f.bo, this.q);
        if (this.l > 0) {
            jSONObject.put("user_id", this.l);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.w) ? JSONObject.NULL : this.w);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ssid", this.x);
        }
        jSONObject.put("category", this.d);
        jSONObject.put("tag", this.oa);
        jSONObject.put(e.a.d, this.cy);
        jSONObject.put("ext_value", this.hd);
        jSONObject.put("label", this.sz);
        jSONObject.put("datetime", this.cp);
        if (!TextUtils.isEmpty(this.fs)) {
            jSONObject.put("ab_sdk_version", this.fs);
        }
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return this.oa + ", " + this.sz;
    }

    @Override // com.byazt.yi.n
    public String rv() {
        return this.k;
    }
}
