package com.byazt.dd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 62})
public class fw {
    public List<pr> hw;
    public pr pr;
    public boolean hn = false;
    public int x = 0;

    public pr pr() {
        return this.pr;
    }

    public List<pr> hw() {
        return this.hw;
    }

    public boolean hn() {
        return this.hn;
    }

    public int x() {
        return this.x;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 766})
    public static class pr {
        public Map<String, Object> c;
        public String hn = "global";
        public String hw;
        public String pr;
        public Map<String, Object> uc;
        public String x;

        public String pr() {
            return this.hn;
        }

        public void pr(String str) {
            this.hn = str;
        }

        public String hw() {
            return this.x;
        }

        public void hw(String str) {
            this.x = str;
        }

        public Map<String, Object> hn() {
            return this.c;
        }

        public void pr(Map<String, Object> map) {
            this.c = map;
        }

        public void hn(String str) {
            this.pr = str;
        }

        public String x() {
            return this.pr;
        }

        public void x(String str) {
            this.hw = str;
        }

        public String c() {
            return this.hw;
        }

        public String toString() {
            return "Action{scheme='" + this.hn + "', name='" + this.x + "', params=" + this.c + ", host='" + this.hw + "', origin='" + this.pr + "', extra=" + this.uc + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static fw pr(JSONObject jSONObject, JSONObject jSONObject2) {
        pr prVarPr;
        pr prVarPr2;
        if (jSONObject == null) {
            return null;
        }
        fw fwVar = new fw();
        Object objOpt = jSONObject.opt(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("handlers");
        if (objOpt instanceof String) {
            prVarPr = m.pr((String) objOpt, jSONObject2);
        } else if (!(objOpt instanceof JSONObject)) {
            prVarPr = null;
        } else {
            prVarPr = m.pr((JSONObject) objOpt, jSONObject2);
        }
        if (prVarPr != null) {
            fwVar.pr = prVarPr;
        }
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            Object objOpt2 = jSONArrayOptJSONArray.opt(i);
            if (objOpt2 instanceof String) {
                pr prVarPr3 = m.pr((String) objOpt2, jSONObject2);
                if (prVarPr3 != null) {
                    arrayList.add(prVarPr3);
                }
            } else if ((objOpt2 instanceof JSONObject) && (prVarPr2 = m.pr((JSONObject) objOpt2, jSONObject2)) != null) {
                arrayList.add(prVarPr2);
            }
        }
        fwVar.hw = arrayList;
        if (jSONObject.has(Constants.DELAY_FIELD)) {
            fwVar.x = com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString(Constants.DELAY_FIELD), jSONObject2), 0);
        }
        if (jSONObject.has("disable")) {
            fwVar.hn = com.byazt.aa.hn.pr(com.byazt.tn.hw.pr(jSONObject.optString("disable"), jSONObject2), false);
        }
        return fwVar;
    }
}
