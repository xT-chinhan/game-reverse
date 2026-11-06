package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.ec.w;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 5})
public class uc extends pr {
    public boolean a;
    public boolean g;
    public String ho;
    public int k;
    public String lb;
    public String m;
    public int nt;
    public boolean qa;
    public String yb;

    public uc(boolean z) {
        this.a = z;
    }

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        List<String> listPr = super.pr();
        ArrayList arrayList = new ArrayList(listPr.size());
        arrayList.addAll(listPr);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", "integer", "last_session", "varchar", "is_first_time", "integer", "page_title", "varchar", "page_key", "varchar", "resume_from_background", "integer"));
        return arrayList;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        int iPr = super.pr(cursor);
        int i = iPr + 1;
        this.m = cursor.getString(iPr);
        int i2 = i + 1;
        this.k = cursor.getInt(i);
        int i3 = i2 + 1;
        this.ho = cursor.getString(i2);
        int i4 = i3 + 1;
        this.nt = cursor.getInt(i3);
        int i5 = i4 + 1;
        this.yb = cursor.getString(i4);
        int i6 = i5 + 1;
        this.lb = cursor.getString(i5);
        int i7 = i6 + 1;
        this.qa = cursor.getInt(i6) == 0;
        return i7;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        super.pr(contentValues);
        contentValues.put("ver_name", this.m);
        contentValues.put("ver_code", Integer.valueOf(this.k));
        contentValues.put("last_session", this.ho);
        contentValues.put("is_first_time", Integer.valueOf(this.nt));
        contentValues.put("page_title", this.yb);
        contentValues.put("page_key", this.lb);
        contentValues.put("resume_from_background", Integer.valueOf(this.qa ? 1 : 0));
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) {
        w.hw((Throwable) null);
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
        boolean z = this.g;
        if (z) {
            jSONObject.put("is_background", z);
        }
        jSONObject.put("datetime", this.w);
        if (!TextUtils.isEmpty(this.zo)) {
            jSONObject.put("ab_sdk_version", this.zo);
        }
        if (!TextUtils.isEmpty(this.ho)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.ho);
        }
        if (this.nt == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        jSONObject.put("$resume_from_background", !this.a);
        jSONObject.put("is_background", !this.a);
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        w.hw((Throwable) null);
        return null;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "launch";
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return this.g ? "bg" : "fg";
    }
}
