package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 726})
public class su {
    public String fs;
    public JSONObject l;
    public String n;
    public String q;
    public String qg;
    public String s;
    public int w;
    public String x;

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public String q() {
        return this.q;
    }

    public JSONObject l() {
        return this.l;
    }

    public String w() {
        return this.x;
    }

    public int x() {
        return this.w;
    }

    public String fs() {
        return this.fs;
    }

    public static su n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        su suVar = new su();
        suVar.n = jSONObject.optString("id");
        suVar.q = jSONObject.optString(com.anythink.core.common.l.f.R);
        suVar.s = jSONObject.optString(ImagesContract.URL);
        suVar.qg = jSONObject.optString("md5");
        suVar.x = jSONObject.optString("express_gesture_priority");
        suVar.w = jSONObject.optInt("material_type");
        suVar.l = jSONObject.optJSONObject("custom_components");
        suVar.fs = jSONObject.optString(com.anythink.core.common.f.a.C0017a.o);
        return suVar;
    }

    public JSONObject rv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.n);
            jSONObject.put("md5", this.qg);
            jSONObject.put(ImagesContract.URL, this.s);
            jSONObject.put(com.anythink.core.common.l.f.R, this.q);
            jSONObject.put("material_type", this.w);
            jSONObject.put("custom_components", this.l);
            jSONObject.put("express_gesture_priority", this.x);
            jSONObject.put(com.anythink.core.common.f.a.C0017a.o, this.fs);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
