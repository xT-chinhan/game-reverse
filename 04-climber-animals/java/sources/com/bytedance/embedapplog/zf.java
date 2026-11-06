package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zf extends tz {
    long ao;
    private JSONArray b;
    JSONArray h;
    private JSONObject i;
    long nw;
    long qv;
    private vy re;
    public byte[] sl;
    JSONArray t;
    public int u;
    JSONArray ub;
    vm y;
    int zb;

    @Override // com.bytedance.embedapplog.tz
    String d() {
        return "pack";
    }

    void ms(JSONObject jSONObject, vm vmVar, vy vyVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        ms(0L);
        this.i = jSONObject;
        this.y = vmVar;
        this.re = vyVar;
        this.b = jSONArray;
        this.ub = jSONArrayArr[0];
        this.ao = jArr[0];
        this.h = jSONArrayArr[1];
        this.qv = jArr[1];
        this.t = jSONArrayArr[2];
        this.nw = jArr[2];
        this.ch = i;
    }

    @Override // com.bytedance.embedapplog.tz
    protected List<String> ms() {
        return Arrays.asList(com.umeng.analytics.pro.bz.d, "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", com.anythink.core.common.e.a.C0080a.b, "integer");
    }

    @Override // com.bytedance.embedapplog.tz
    public int ms(Cursor cursor) {
        this.f529ms = cursor.getLong(0);
        this.xr = cursor.getLong(1);
        this.sl = cursor.getBlob(2);
        this.zb = cursor.getInt(3);
        this.ch = cursor.getInt(4);
        this.d = "";
        this.i = null;
        this.y = null;
        this.re = null;
        this.b = null;
        this.ub = null;
        this.h = null;
        this.t = null;
        return 5;
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.xr));
        contentValues.put("_data", ch());
        contentValues.put(com.anythink.core.common.e.a.C0080a.b, Integer.valueOf(this.ch));
    }

    public byte[] ch() {
        this.sl = null;
        try {
            byte[] bArrMs = vl.ms(c().toString());
            this.sl = bArrMs;
            return bArrMs;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ti.ah.length; i++) {
                if (ti.ah[i] != null) {
                    sb.append(ti.ah[i].toString()).append(";");
                }
            }
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.bytedance.embedapplog.tz
    protected void ms(JSONObject jSONObject) {
        oh.xr((Throwable) null);
    }

    @Override // com.bytedance.embedapplog.tz
    protected JSONObject xr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.i);
        jSONObject.put("time_sync", am.f476ms);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.y != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.y.c());
            jSONObject.put("launch", jSONArray);
        }
        vy vyVar = this.re;
        int i = 0;
        if (vyVar != null) {
            JSONObject jSONObjectC = vyVar.c();
            JSONArray jSONArray2 = this.b;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.b.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectC.put("$page_title", jSONObject3.optString(ArticleInfo.PAGE_TITLE, ""));
                    jSONObjectC.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectC.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectC);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.ub;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.ub);
        }
        JSONArray jSONArray7 = this.b;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.h;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.h);
        }
        JSONArray jSONArray9 = this.t;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.t);
        }
        StringBuilder sb = new StringBuilder("pack {ts:");
        sb.append(this.xr);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.y;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        vy vyVar2 = this.re;
        sbAppend2.append(vyVar2 != null ? vyVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        oh.ms(sb.toString());
        return jSONObject;
    }

    @Override // com.bytedance.embedapplog.tz
    protected tz xr(JSONObject jSONObject) {
        oh.xr((Throwable) null);
        return null;
    }

    @Override // com.bytedance.embedapplog.tz
    protected String x() {
        return String.valueOf(this.f529ms);
    }
}
