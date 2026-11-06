package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 20})
public class hn extends pr {
    public String g;
    public String ho;
    public String k;
    public String m;
    public long nt;
    public long yb;

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        List<String> listPr = super.pr();
        ArrayList arrayList = new ArrayList(listPr.size());
        arrayList.addAll(listPr);
        arrayList.addAll(Arrays.asList("category", "varchar", "tag", "varchar", Constants.VALUE_FIELD, "integer", "ext_value", "integer", "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        int iPr = super.pr(cursor);
        int i = iPr + 1;
        this.k = cursor.getString(iPr);
        int i2 = i + 1;
        this.m = cursor.getString(i);
        int i3 = i2 + 1;
        this.nt = cursor.getLong(i2);
        int i4 = i3 + 1;
        this.yb = cursor.getLong(i3);
        int i5 = i4 + 1;
        this.ho = cursor.getString(i4);
        int i6 = i5 + 1;
        this.g = cursor.getString(i5);
        return i6;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        super.pr(contentValues);
        contentValues.put("category", this.k);
        contentValues.put("tag", this.m);
        contentValues.put(Constants.VALUE_FIELD, Long.valueOf(this.nt));
        contentValues.put("ext_value", Long.valueOf(this.yb));
        contentValues.put("params", this.ho);
        contentValues.put("label", this.g);
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) throws JSONException {
        super.pr(jSONObject);
        jSONObject.put("tea_event_index", this.hn);
        jSONObject.put("category", this.k);
        jSONObject.put("tag", this.m);
        jSONObject.put(Constants.VALUE_FIELD, this.nt);
        jSONObject.put("ext_value", this.yb);
        jSONObject.put("params", this.ho);
        jSONObject.put("label", this.g);
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        super.hw(jSONObject);
        this.hn = jSONObject.optLong("tea_event_index", 0L);
        this.k = jSONObject.optString("category", null);
        this.m = jSONObject.optString("tag", null);
        this.nt = jSONObject.optLong(Constants.VALUE_FIELD, 0L);
        this.yb = jSONObject.optLong("ext_value", 0L);
        this.ho = jSONObject.optString("params", null);
        this.g = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.byazt.kg.pr
    public JSONObject hw() throws JSONException {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.ho)) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject(this.ho);
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
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
        jSONObject.put("category", this.k);
        jSONObject.put("tag", this.m);
        jSONObject.put(Constants.VALUE_FIELD, this.nt);
        jSONObject.put("ext_value", this.yb);
        jSONObject.put("label", this.g);
        jSONObject.put("datetime", this.w);
        if (!TextUtils.isEmpty(this.zo)) {
            jSONObject.put("ab_sdk_version", this.zo);
        }
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return this.m + ", " + this.g;
    }

    @Override // com.byazt.kg.pr
    public String aj() {
        return this.ho;
    }
}
