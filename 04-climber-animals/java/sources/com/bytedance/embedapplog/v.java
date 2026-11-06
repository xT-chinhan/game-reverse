package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v extends tz {
    private String sl;
    private String zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "event_misc";
    }

    public v(String str, JSONObject jSONObject) {
        this.zb = str;
        this.sl = jSONObject.toString();
        this.ch = 0;
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        List<String> listMs = super.ms();
        ArrayList arrayList = new ArrayList(listMs.size());
        arrayList.addAll(listMs);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        int iMs = super.ms(cursor);
        int i = iMs + 1;
        this.sl = cursor.getString(iMs);
        int i2 = i + 1;
        this.zb = cursor.getString(i);
        return i2;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        super.ms(contentValues);
        contentValues.put("params", this.sl);
        contentValues.put("log_type", this.zb);
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) throws JSONException {
        super.ms(jSONObject);
        jSONObject.put("params", this.sl);
        jSONObject.put("log_type", this.zb);
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
        jSONObject.put("log_type", this.zb);
        try {
            JSONObject jSONObject2 = new JSONObject(this.sl);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    oh.xr("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
        } catch (Exception e) {
            oh.ah("解析 event misc 失败", e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        super.xr(jSONObject);
        this.sl = jSONObject.optString("params", null);
        this.zb = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return "param:" + this.sl + " logType:" + this.zb;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String ny() {
        return this.sl;
    }
}
