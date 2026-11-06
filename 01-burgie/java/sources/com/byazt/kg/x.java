package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.ec.w;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, 121})
public class x extends pr {
    public String k;
    public String m;

    public x(String str, JSONObject jSONObject) {
        this.m = str;
        this.k = jSONObject.toString();
        this.vk = 0;
    }

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        List<String> listPr = super.pr();
        ArrayList arrayList = new ArrayList(listPr.size());
        arrayList.addAll(listPr);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        int iPr = super.pr(cursor);
        int i = iPr + 1;
        this.k = cursor.getString(iPr);
        int i2 = i + 1;
        this.m = cursor.getString(i);
        return i2;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        super.pr(contentValues);
        contentValues.put("params", this.k);
        contentValues.put("log_type", this.m);
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) throws JSONException {
        super.pr(jSONObject);
        jSONObject.put("params", this.k);
        jSONObject.put("log_type", this.m);
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
        jSONObject.put("log_type", this.m);
        try {
            JSONObject jSONObject2 = new JSONObject(this.k);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    w.hw("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            w.hn("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        super.hw(jSONObject);
        this.k = jSONObject.optString("params", null);
        this.m = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "event_misc";
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return "param:" + this.k + " logType:" + this.m;
    }

    @Override // com.byazt.kg.pr
    public String aj() {
        return this.k;
    }
}
