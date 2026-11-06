package com.byazt.vo;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 13})
public class hw {
    public String hn;
    public String hw;
    public of pr;
    public JSONObject x;

    public static hw pr() {
        return new hw();
    }

    public static hw pr(JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        JSONObject jSONObjectOptJSONObject;
        of ofVarPr = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            strOptString = jSONObject.optString("tag", null);
            try {
                strOptString2 = jSONObject.optString("label", null);
                try {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        ofVarPr = com.byazt.sd.pr.pr(jSONObject.optJSONObject("material_meta"));
                    } catch (Exception e) {
                    }
                } catch (Exception e2) {
                    jSONObjectOptJSONObject = null;
                }
            } catch (Exception e3) {
                strOptString2 = null;
                jSONObjectOptJSONObject = strOptString2;
            }
        } catch (Exception e4) {
            strOptString = null;
            strOptString2 = null;
        }
        return pr().pr(strOptString).hw(strOptString2).hw(jSONObjectOptJSONObject).pr(ofVarPr);
    }

    public hw pr(of ofVar) {
        this.pr = ofVar;
        return this;
    }

    public hw pr(String str) {
        this.hw = str;
        return this;
    }

    public hw hw(String str) {
        this.hn = str;
        return this;
    }

    public hw hw(JSONObject jSONObject) {
        this.x = jSONObject;
        return this;
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", this.hw);
            jSONObject.put("label", this.hn);
            JSONObject jSONObject2 = this.x;
            if (jSONObject2 != null) {
                jSONObject.put("extra", jSONObject2);
            }
            of ofVar = this.pr;
            if (ofVar != null) {
                jSONObject.put("material_meta", ofVar.to());
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
