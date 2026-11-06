package com.byazt.fm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1624, 19})
public class n {
    public int l;
    public String n;
    public boolean q;
    public String qg;
    public String s;
    public int w;
    public final Map<String, String> x = new HashMap();
    public List<C0176n> fs = new ArrayList();
    public final List<C0176n> rv = new ArrayList();
    public final List<C0176n> tj = new ArrayList();

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }

    public int l() {
        return this.l;
    }

    public Map<String, String> w() {
        return this.x;
    }

    public List<C0176n> x() {
        return this.fs;
    }

    public n(JSONObject jSONObject) {
        n(jSONObject);
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optString(TapEventParamConstants.PARAM_NAME);
        this.w = jSONObject.optInt("index");
        this.qg = jSONObject.optString("scheme");
        this.s = jSONObject.optString("condition");
        this.q = jSONObject.optBoolean("enableCondition");
        this.l = jSONObject.optInt("priority", Integer.MAX_VALUE);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.x.put(next, jSONObjectOptJSONObject.optString(next));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("next");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.fs.add(new C0176n(jSONObjectOptJSONObject2.optString(TapEventParamConstants.PARAM_NAME), jSONObjectOptJSONObject2.optString("condition")));
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("next");
            if (jSONObjectOptJSONObject3 != null) {
                this.fs.add(new C0176n(jSONObjectOptJSONObject3.optString(TapEventParamConstants.PARAM_NAME), jSONObjectOptJSONObject3.optString("condition")));
            }
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("callback");
        if (jSONObjectOptJSONObject4 == null) {
            jSONObjectOptJSONObject4 = new JSONObject();
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("success");
        if (jSONArrayOptJSONArray2 == null) {
            jSONArrayOptJSONArray2 = new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
            if (jSONObjectOptJSONObject5 != null) {
                this.rv.add(new C0176n(jSONObjectOptJSONObject5.optString(TapEventParamConstants.PARAM_NAME), jSONObjectOptJSONObject5.optString("condition")));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject4.optJSONArray("fail");
        if (jSONArrayOptJSONArray3 == null) {
            jSONArrayOptJSONArray3 = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
            if (jSONObjectOptJSONObject6 != null) {
                this.tj.add(new C0176n(jSONObjectOptJSONObject6.optString(TapEventParamConstants.PARAM_NAME), jSONObjectOptJSONObject6.optString("condition")));
            }
        }
    }

    public List<C0176n> fs() {
        return this.rv;
    }

    public List<C0176n> rv() {
        return this.tj;
    }

    /* JADX INFO: renamed from: com.byazt.fm.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1624, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0176n {
        public String n;
        public String qg;

        public String n() {
            return this.n;
        }

        public String qg() {
            return this.qg;
        }

        public C0176n(String str, String str2) {
            this.n = str;
            this.qg = str2;
        }
    }
}
