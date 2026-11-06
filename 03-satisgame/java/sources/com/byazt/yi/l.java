package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.l.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 18})
public class l extends n {
    public String d;
    public String oa;
    public boolean sz;

    @Override // com.byazt.yi.n
    public String q() {
        return "eventv3";
    }

    public l(String str, boolean z, String str2) {
        this.oa = str;
        this.sz = z;
        this.d = str2;
        this.tj = 0;
    }

    public l(String str, boolean z, String str2, int i) {
        this.oa = str;
        this.sz = z;
        this.d = str2;
        this.tj = i;
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        List<String> listN = super.n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", "integer"));
        return arrayList;
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        int iN = super.n(cursor);
        int i = iN + 1;
        this.oa = cursor.getString(iN);
        int i2 = i + 1;
        this.d = cursor.getString(i);
        int i3 = i2 + 1;
        this.sz = cursor.getInt(i2) == 1;
        return i3;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        super.n(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.oa);
        contentValues.put("params", this.d);
        contentValues.put("is_bav", Integer.valueOf(this.sz ? 1 : 0));
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) throws JSONException {
        super.n(jSONObject);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.oa);
        jSONObject.put("params", this.d);
        jSONObject.put("is_bav", this.sz);
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.oa);
        if (this.sz) {
            jSONObject.put("is_bav", 1);
        }
        if (!TextUtils.isEmpty(this.d)) {
            jSONObject.put("params", new JSONObject(this.d));
        }
        jSONObject.put("datetime", this.cp);
        if (!TextUtils.isEmpty(this.fs)) {
            jSONObject.put("ab_sdk_version", this.fs);
        }
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        super.qg(jSONObject);
        this.oa = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.d = jSONObject.optString("params", null);
        this.sz = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return this.oa;
    }

    @Override // com.byazt.yi.n
    public String rv() {
        return this.d;
    }
}
