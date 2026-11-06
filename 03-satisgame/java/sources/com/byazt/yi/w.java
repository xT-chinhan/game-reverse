package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.km.cp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 13})
public class w extends n {
    public boolean a;
    public String cd;
    public int cy;
    public int d;
    public String hd;
    public String k;
    public String oa;
    public boolean sz;
    public boolean um;

    @Override // com.byazt.yi.n
    public String q() {
        return "launch";
    }

    public w(boolean z) {
        this.a = z;
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        List<String> listN = super.n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", "page_title", "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        int iN = super.n(cursor);
        int i = iN + 1;
        this.oa = cursor.getString(iN);
        int i2 = i + 1;
        this.d = cursor.getInt(i);
        int i3 = i2 + 1;
        this.k = cursor.getString(i2);
        int i4 = i3 + 1;
        this.cy = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.hd = cursor.getString(i4);
        int i6 = i5 + 1;
        this.cd = cursor.getString(i5);
        int i7 = i6 + 1;
        this.um = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        super.n(contentValues);
        contentValues.put("ver_name", this.oa);
        contentValues.put("ver_code", Integer.valueOf(this.d));
        contentValues.put("last_session", this.k);
        contentValues.put("is_first_time", Integer.valueOf(this.cy));
        contentValues.put("page_title", this.hd);
        contentValues.put("page_key", this.cd);
        contentValues.put("resume_from_background", Integer.valueOf(this.um ? 1 : 0));
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) {
        cp.qg((Throwable) null);
    }

    @Override // com.byazt.yi.n
    public JSONObject qg() throws JSONException {
        JSONObject jSONObject = new JSONObject();
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
        boolean z = this.sz;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.cp);
        if (!TextUtils.isEmpty(this.fs)) {
            jSONObject.put("ab_sdk_version", this.fs);
        }
        if (!TextUtils.isEmpty(this.k)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.k);
        }
        if (this.cy == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.a);
        jSONObject.put("is_background", !this.a);
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        cp.qg((Throwable) null);
        return null;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return this.sz ? "bg" : "fg";
    }
}
