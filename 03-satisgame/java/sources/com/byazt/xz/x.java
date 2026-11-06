package com.byazt.xz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 774, 21})
public class x {
    public n n;
    public List<n> qg;
    public boolean s = false;
    public int q = 0;

    public n n() {
        return this.n;
    }

    public List<n> qg() {
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    @com.byazt.cp.n(n = {0, 1, 774, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    public static class n {
        public Map<String, Object> l;
        public String n;
        public String q;
        public String qg;
        public String s = "global";
        public Map<String, Object> w;
        public Map<String, Object> x;

        public String n() {
            return this.s;
        }

        public void n(String str) {
            this.s = str;
        }

        public String qg() {
            return this.q;
        }

        public void qg(String str) {
            this.q = str;
        }

        public Map<String, Object> s() {
            return this.l;
        }

        public void n(Map<String, Object> map) {
            this.l = map;
        }

        public Map<String, Object> q() {
            return this.w;
        }

        public void qg(Map<String, Object> map) {
            this.w = map;
        }

        public void s(String str) {
            this.n = str;
        }

        public String l() {
            return this.n;
        }

        public void q(String str) {
            this.qg = str;
        }

        public String w() {
            return this.qg;
        }

        public Map<String, Object> x() {
            return this.x;
        }

        public void s(Map<String, Object> map) {
            this.x = map;
        }

        public String toString() {
            return "Action{scheme='" + this.s + "', name='" + this.q + "', params=" + this.l + ", host='" + this.qg + "', origin='" + this.n + "', extra=" + this.x + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static x n(JSONObject jSONObject, JSONObject jSONObject2) {
        n nVarN;
        n nVarN2;
        if (jSONObject == null) {
            return null;
        }
        x xVar = new x();
        Object objOpt = jSONObject.opt(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        if (objOpt instanceof String) {
            nVarN = oa.n((String) objOpt, jSONObject2);
        } else {
            nVarN = objOpt instanceof JSONObject ? oa.n((JSONObject) objOpt, jSONObject2) : null;
        }
        if (nVarN != null) {
            xVar.n = nVarN;
        }
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            Object objOpt2 = jSONArrayOptJSONArray.opt(i);
            if (objOpt2 instanceof String) {
                n nVarN3 = oa.n((String) objOpt2, jSONObject2);
                if (nVarN3 != null) {
                    arrayList.add(nVarN3);
                }
            } else if ((objOpt2 instanceof JSONObject) && (nVarN2 = oa.n((JSONObject) objOpt2, jSONObject2)) != null) {
                arrayList.add(nVarN2);
            }
        }
        xVar.qg = arrayList;
        if (jSONObject.has("delay")) {
            xVar.q = com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("delay"), jSONObject2), 0);
        }
        if (jSONObject.has("disable")) {
            xVar.s = com.byazt.hb.s.n(com.byazt.mcb.qg.n(jSONObject.optString("disable"), jSONObject2), false);
        }
        return xVar;
    }
}
