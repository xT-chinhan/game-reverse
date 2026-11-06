package com.byazt.yb;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 33})
public final class um {
    public final Long l;
    public final String n;
    public final Long q;
    public final String qg;
    public final Boolean s;
    public final Integer w;
    public final Long x;

    public um(String str, String str2, Boolean bool, Long l, Long l2, Integer num, Long l3) {
        this.n = str;
        this.qg = str2;
        this.s = bool;
        this.q = l;
        this.l = l2;
        this.w = num;
        this.x = l3;
    }

    public String toString() {
        return qg().toString();
    }

    public Map<String, String> n() {
        HashMap map = new HashMap();
        cy.n(map, "id", this.n);
        cy.n(map, "req_id", this.qg);
        cy.n(map, "is_track_limited", String.valueOf(this.s));
        cy.n(map, "take_ms", String.valueOf(this.q));
        cy.n(map, "time", String.valueOf(this.l));
        cy.n(map, "query_times", String.valueOf(this.w));
        cy.n(map, "hw_id_version_code", String.valueOf(this.x));
        return map;
    }

    public JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        cy.n(jSONObject, "id", this.n);
        cy.n(jSONObject, "req_id", this.qg);
        cy.n(jSONObject, "is_track_limited", this.s);
        cy.n(jSONObject, "take_ms", this.q);
        cy.n(jSONObject, "time", this.l);
        cy.n(jSONObject, "query_times", this.w);
        cy.n(jSONObject, "hw_id_version_code", this.x);
        return jSONObject;
    }

    public static um n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new um(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            com.byazt.km.cp.n(e);
            return null;
        }
    }
}
