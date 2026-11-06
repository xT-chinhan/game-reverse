package com.byazt.kg;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import com.byazt.ec.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.ar;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 421, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends pr {
    public JSONArray a;
    public long cz;
    public vk fo;
    public int g;
    public JSONArray ho;
    public byte[] k;
    public long lb;
    public int m;
    public long nt;
    public JSONArray ny;
    public uc qa;
    public JSONObject rc;
    public JSONArray yb;

    public void pr(JSONObject jSONObject, uc ucVar, vk vkVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, int i) {
        pr(0L);
        this.rc = jSONObject;
        this.qa = ucVar;
        this.fo = vkVar;
        this.ny = jSONArray;
        this.ho = jSONArrayArr[0];
        this.nt = jArr[0];
        this.yb = jSONArrayArr[1];
        this.lb = jArr[1];
        this.a = jSONArrayArr[2];
        this.cz = jArr[2];
        this.vk = i;
    }

    @Override // com.byazt.kg.pr
    public List<String> pr() {
        return Arrays.asList(ar.d, "integer primary key autoincrement", "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "event_type", "integer");
    }

    @Override // com.byazt.kg.pr
    public int pr(Cursor cursor) {
        this.pr = cursor.getLong(0);
        this.hw = cursor.getLong(1);
        this.k = cursor.getBlob(2);
        this.m = cursor.getInt(3);
        this.vk = cursor.getInt(4);
        this.x = "";
        this.rc = null;
        this.qa = null;
        this.fo = null;
        this.ny = null;
        this.ho = null;
        this.yb = null;
        this.a = null;
        return 5;
    }

    @Override // com.byazt.kg.pr
    public void pr(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.hw));
        contentValues.put("_data", vk());
        contentValues.put("event_type", Integer.valueOf(this.vk));
    }

    public byte[] vk() {
        this.k = null;
        try {
            byte[] bArrPr = com.byazt.ec.x.pr(uc().toString());
            this.k = bArrPr;
            return bArrPr;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hw.hn.length; i++) {
                if (hw.hn[i] != null) {
                    sb.append(hw.hn[i].toString()).append(";");
                }
            }
            throw new RuntimeException(sb.toString(), e);
        }
    }

    @Override // com.byazt.kg.pr
    public void pr(JSONObject jSONObject) {
        w.hw((Throwable) null);
    }

    @Override // com.byazt.kg.pr
    public JSONObject hw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.rc);
        jSONObject.put("time_sync", com.byazt.yj.pr.pr);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.qa != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.qa.uc());
            jSONObject.put("launch", jSONArray);
        }
        vk vkVar = this.fo;
        int i = 0;
        if (vkVar != null) {
            JSONObject jSONObjectUc = vkVar.uc();
            JSONArray jSONArray2 = this.ny;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            int i2 = 0;
            long j = 0;
            while (i2 < length) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(this.ny.optString(i2));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("params"));
                jSONArray4.put(i, jSONObject3.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject3.optInt("duration", i) + 999) / 1000);
                jSONArray3.put(jSONArray4);
                int i3 = length;
                long jOptLong = jSONObject2.optLong("local_time_ms", 0L);
                if (jOptLong > j) {
                    jSONObjectUc.put("$page_title", jSONObject3.optString("page_title", ""));
                    jSONObjectUc.put("$page_key", jSONObject3.optString("page_key", ""));
                    j = jOptLong;
                }
                i2++;
                length = i3;
                i = 0;
            }
            if (length > 0) {
                jSONObjectUc.put("activites", jSONArray3);
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectUc);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.ho;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.ho);
        }
        JSONArray jSONArray7 = this.ny;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.yb;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.yb);
        }
        JSONArray jSONArray9 = this.a;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.a);
        }
        StringBuilder sb = new StringBuilder("pack {");
        sb.append("ts:").append(this.hw);
        StringBuilder sbAppend = sb.append(", la:");
        Object obj = this.qa;
        if (obj == null) {
            obj = "0";
        }
        sbAppend.append(obj);
        StringBuilder sbAppend2 = sb.append(", te:");
        vk vkVar2 = this.fo;
        sbAppend2.append(vkVar2 != null ? vkVar2 : "0");
        sb.append(", p:").append(length3);
        sb.append(", v1:").append(length2);
        sb.append(", v3:").append(length4);
        sb.append(", m:").append(length5);
        w.pr(sb.toString());
        return jSONObject;
    }

    @Override // com.byazt.kg.pr
    public pr hw(JSONObject jSONObject) {
        w.hw((Throwable) null);
        return null;
    }

    @Override // com.byazt.kg.pr
    public String x() {
        return "pack";
    }

    @Override // com.byazt.kg.pr
    public String zo() {
        return String.valueOf(this.pr);
    }
}
