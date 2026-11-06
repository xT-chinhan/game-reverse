package com.bytedance.embedapplog;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    final Long ab;
    final Boolean ah;
    final Integer c;
    final Long d;
    final Long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final String f475ms;
    final String xr;

    a(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.f475ms = str;
        this.xr = str2;
        this.ah = bool;
        this.d = l;
        this.ka = l2;
        this.c = num;
        this.ab = l3;
    }

    public String toString() {
        return xr().toString();
    }

    Map<String, String> ms() {
        HashMap map = new HashMap();
        si.ms(map, "id", this.f475ms);
        si.ms(map, "req_id", this.xr);
        si.ms(map, "is_track_limited", String.valueOf(this.ah));
        si.ms(map, "take_ms", String.valueOf(this.d));
        si.ms(map, "time", String.valueOf(this.ka));
        si.ms(map, "query_times", String.valueOf(this.c));
        si.ms(map, "hw_id_version_code", String.valueOf(this.ab));
        return map;
    }

    JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        si.ms(jSONObject, "id", this.f475ms);
        si.ms(jSONObject, "req_id", this.xr);
        si.ms(jSONObject, "is_track_limited", this.ah);
        si.ms(jSONObject, "take_ms", this.d);
        si.ms(jSONObject, "time", this.ka);
        si.ms(jSONObject, "query_times", this.c);
        si.ms(jSONObject, "hw_id_version_code", this.ab);
        return jSONObject;
    }

    static a ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            oh.ms(e);
            return null;
        }
    }
}
