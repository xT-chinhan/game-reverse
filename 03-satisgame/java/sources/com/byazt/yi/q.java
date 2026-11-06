package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.km.cp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 5})
public class q extends n {
    public String d;
    public String oa;

    @Override // com.byazt.yi.n
    public String q() {
        return "event_misc";
    }

    public q(String str, JSONObject jSONObject) {
        this.oa = str;
        this.d = jSONObject.toString();
        this.tj = 0;
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        List<String> listN = super.n();
        ArrayList arrayList = new ArrayList(listN.size());
        arrayList.addAll(listN);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        int iN = super.n(cursor);
        int i = iN + 1;
        this.d = cursor.getString(iN);
        int i2 = i + 1;
        this.oa = cursor.getString(i);
        return i2;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        super.n(contentValues);
        contentValues.put("params", this.d);
        contentValues.put("log_type", this.oa);
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) throws JSONException {
        super.n(jSONObject);
        jSONObject.put("params", this.d);
        jSONObject.put("log_type", this.oa);
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
        jSONObject.put("log_type", this.oa);
        try {
            JSONObject jSONObject2 = new JSONObject(this.d);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    cp.qg("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            cp.s("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        super.qg(jSONObject);
        this.d = jSONObject.optString("params", null);
        this.oa = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return "param:" + this.d + " logType:" + this.oa;
    }

    @Override // com.byazt.yi.n
    public String rv() {
        return this.d;
    }
}
