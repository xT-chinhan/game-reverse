package com.byazt.yi;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.m.a.m;
import com.byazt.km.cp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 200, 101})
public class fs extends n {
    public JSONArray a;
    public long cd;
    public long cy;
    public byte[] d;
    public JSONArray hd;
    public JSONArray k;
    public JSONObject m;
    public int oa;
    public JSONArray ou;
    public long py;
    public int sz;
    public w um;
    public tj wm;

    @Override // com.byazt.yi.n
    public String q() {
        return "pack";
    }

    public void n(JSONObject jSONObject, w wVar, tj tjVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        n(0L);
        this.m = jSONObject;
        this.um = wVar;
        this.wm = tjVar;
        this.ou = jSONArray;
        this.k = jSONArrayArr[0];
        this.cy = jArr[0];
        this.hd = jSONArrayArr[1];
        this.cd = jArr[1];
        this.a = jSONArrayArr[2];
        this.py = jArr[2];
        this.tj = i;
    }

    @Override // com.byazt.yi.n
    public List<String> n() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.byazt.yi.n
    public int n(Cursor cursor) {
        this.n = cursor.getLong(0);
        this.qg = cursor.getLong(1);
        this.d = cursor.getBlob(2);
        this.oa = cursor.getInt(3);
        this.tj = cursor.getInt(4);
        this.q = "";
        this.m = null;
        this.um = null;
        this.wm = null;
        this.ou = null;
        this.k = null;
        this.hd = null;
        this.a = null;
        return 5;
    }

    @Override // com.byazt.yi.n
    public void n(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.qg));
        contentValues.put("_data", tj());
        contentValues.put("event_type", Integer.valueOf(this.tj));
    }

    public byte[] tj() {
        this.d = null;
        try {
            byte[] bArrN = com.byazt.km.q.n(w().toString());
            this.d = bArrN;
            return bArrN;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < qg.s.length; i++) {
                if (qg.s[i] != null) {
                    sb.append(qg.s[i].toString()).append(";");
                }
            }
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.byazt.yi.n
    public void n(JSONObject jSONObject) {
        cp.qg((Throwable) null);
    }

    @Override // com.byazt.yi.n
    public JSONObject qg() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.m);
        jSONObject.put("time_sync", com.byazt.jy.n.n);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.um != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.um.w());
            jSONObject.put("launch", jSONArray);
        }
        tj tjVar = this.wm;
        int i = 0;
        if (tjVar != null) {
            JSONObject jSONObjectW = tjVar.w();
            JSONArray jSONArray2 = this.ou;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.ou.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt(MediationConstant.EXTRA_DURATION, i) + m.h) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectW.put("$page_title", jSONObject3.optString("page_title", ""));
                    jSONObjectW.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectW.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectW);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.k;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.k);
        }
        JSONArray jSONArray7 = this.ou;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.hd;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.hd);
        }
        JSONArray jSONArray9 = this.a;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.a);
        }
        StringBuilder sb = new StringBuilder("pack {ts:");
        sb.append(this.qg);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.um;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        tj tjVar2 = this.wm;
        sbAppend2.append(tjVar2 != null ? tjVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        cp.n(sb.toString());
        return jSONObject;
    }

    @Override // com.byazt.yi.n
    public n qg(JSONObject jSONObject) {
        cp.qg((Throwable) null);
        return null;
    }

    @Override // com.byazt.yi.n
    public String fs() {
        return String.valueOf(this.n);
    }
}
