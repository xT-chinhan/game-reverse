package com.byazt.xev;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 101})
public final class qa {
    public final Long c;
    public final Long fw;
    public final Boolean hn;
    public final String hw;
    public final String pr;
    public final Integer uc;
    public final Long x;

    public qa(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.pr = str;
        this.hw = str2;
        this.hn = bool;
        this.x = l;
        this.c = l2;
        this.uc = num;
        this.fw = l3;
    }

    public String toString() {
        return hw().toString();
    }

    public Map<String, String> pr() {
        HashMap map = new HashMap();
        nt.pr(map, "id", this.pr);
        nt.pr(map, "req_id", this.hw);
        nt.pr(map, "is_track_limited", String.valueOf(this.hn));
        nt.pr(map, "take_ms", String.valueOf(this.x));
        nt.pr(map, "time", String.valueOf(this.c));
        nt.pr(map, "query_times", String.valueOf(this.uc));
        nt.pr(map, "hw_id_version_code", String.valueOf(this.fw));
        return map;
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        nt.pr(jSONObject, "id", this.pr);
        nt.pr(jSONObject, "req_id", this.hw);
        nt.pr(jSONObject, "is_track_limited", this.hn);
        nt.pr(jSONObject, "take_ms", this.x);
        nt.pr(jSONObject, "time", this.c);
        nt.pr(jSONObject, "query_times", this.uc);
        nt.pr(jSONObject, "hw_id_version_code", this.fw);
        return jSONObject;
    }

    public static qa pr(String str) {
        Boolean boolValueOf;
        Long lValueOf;
        Long lValueOf2;
        Integer numValueOf;
        Long lValueOf3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("id", null);
            String strOptString2 = jSONObject.optString("req_id", null);
            if (!jSONObject.has("is_track_limited")) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(jSONObject.optBoolean("is_track_limited"));
            }
            if (!jSONObject.has("take_ms")) {
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(jSONObject.optLong("take_ms", -1L));
            }
            if (!jSONObject.has("time")) {
                lValueOf2 = null;
            } else {
                lValueOf2 = Long.valueOf(jSONObject.optLong("time", -1L));
            }
            if (!jSONObject.has("query_times")) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(jSONObject.optInt("query_times", -1));
            }
            if (!jSONObject.has("hw_id_version_code")) {
                lValueOf3 = null;
            } else {
                lValueOf3 = Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L));
            }
            return new qa(strOptString, strOptString2, boolValueOf, lValueOf, lValueOf2, numValueOf, lValueOf3);
        } catch (JSONException e) {
            com.byazt.ec.w.pr(e);
            return null;
        }
    }
}
