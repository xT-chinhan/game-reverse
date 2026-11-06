package com.byazt.ch;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 61})
public class aj {
    public float aj;
    public String c;
    public boolean fw;
    public String hn;
    public JSONObject hw;
    public JSONObject pr;
    public JSONObject uc;
    public boolean vk;
    public JSONObject x;
    public float zo;

    public aj(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public aj(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        this.vk = true;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.pr = jSONObject.optJSONObject("body");
            } else {
                this.pr = jSONObject.optJSONObject("main_template");
            }
            this.hw = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has("meta")) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.fw = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.hn = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.hn = "3.0";
                    }
                } else {
                    this.hn = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.c = jSONObjectOptJSONObject.optString("adType");
                }
                if (jSONObjectOptJSONObject.has("gestureThrough")) {
                    this.vk = com.byazt.aa.hn.pr(jSONObjectOptJSONObject.optString("gestureThrough"), true);
                }
            } else if (jSONObject.has("body")) {
                this.hn = "3.0";
                this.fw = true;
            }
            this.x = jSONObject2;
            this.uc = jSONObject3;
        }
    }

    public pr pr() {
        return c();
    }

    public void pr(float f, float f2) {
        this.zo = f;
        this.aj = f2;
    }

    private pr c() {
        if (!x()) {
            return pr(this.pr, (pr) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.zo;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.aj;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            JSONObject jSONObject2 = this.x;
            if (jSONObject2 != null) {
                String strOptString = jSONObject2.optString("xSize");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    if (jSONObject3.optInt("width") > 0) {
                        jSONObject.put("width", jSONObject3.optInt("width"));
                    }
                    if (jSONObject3.optInt("height") > 0) {
                        jSONObject.put("height", jSONObject3.optInt("height"));
                    }
                }
            }
        } catch (JSONException e) {
        }
        pr prVar = new pr();
        prVar.hw = "View";
        prVar.pr = "virtualNode";
        prVar.hn = jSONObject;
        prVar.uc = null;
        prVar.fw = this.hn;
        prVar.aj = this.vk;
        prVar.zo = this.c;
        prVar.pr(pr(this.pr, prVar));
        return prVar;
    }

    public String hw() {
        return this.hn;
    }

    public List<pr> hn() {
        if (this.hw == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.hw.keys();
        while (itKeys.hasNext()) {
            pr prVarPr = pr(this.hw.optJSONObject(itKeys.next()), (pr) null);
            if (prVarPr != null) {
                arrayList.add(prVarPr);
            }
        }
        return arrayList;
    }

    private pr pr(JSONObject jSONObject, pr prVar) {
        String strOptString;
        String strOptString2;
        pr prVarPr;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString(Common.System.NAME);
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                }
            }
        }
        pr prVar2 = new pr();
        prVar2.pr = strOptString3;
        if (!this.fw || !TextUtils.equals("Video", strOptString)) {
            prVar2.hw = strOptString;
        } else {
            prVar2.hw = strOptString + "V3";
        }
        prVar2.hn = jSONObject2;
        prVar2.uc = prVar;
        prVar2.fw = this.hn;
        prVar2.aj = this.vk;
        prVar2.zo = this.c;
        if (jSONObject2.has("i18n")) {
            prVar2.x = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            pr(jSONObject, prVar2.hn);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return prVar2;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONObject.has("type")) {
                strOptString2 = jSONObject.optString("type");
            } else {
                strOptString2 = jSONObject.optString(Common.System.NAME);
            }
            String strPr = com.byazt.tn.hw.pr(jSONObjectOptJSONObject.optString("id"), this.x);
            if (TextUtils.equals(strOptString2, "Template")) {
                JSONObject jSONObject3 = this.hw;
                if (jSONObject3 == null) {
                    prVarPr = null;
                } else {
                    jSONObjectOptJSONObject = jSONObject3.optJSONObject(strPr);
                    prVarPr = pr(jSONObjectOptJSONObject, prVar2);
                }
            } else {
                prVarPr = pr(jSONObjectOptJSONObject, prVar2);
            }
            if (prVarPr != null) {
                prVarPr.hw(hw(prVarPr));
                prVarPr.pr(pr(prVarPr));
            }
            if (hn(prVarPr)) {
                i++;
                prVar2.hw(prVarPr);
            } else if (prVarPr != null) {
                prVar2.pr(i2 - i, prVarPr);
            }
        }
        return prVar2;
    }

    public boolean pr(pr prVar) {
        JSONObject jSONObjectC;
        if (prVar == null || (jSONObjectC = prVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("width"), "match_parent");
    }

    public boolean hw(pr prVar) {
        JSONObject jSONObjectC;
        if (prVar == null || (jSONObjectC = prVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("height"), "match_parent");
    }

    public boolean hn(pr prVar) {
        JSONObject jSONObjectC;
        if (prVar == null || (jSONObjectC = prVar.c()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectC.optString("position"), "absolute");
    }

    public boolean x() {
        return this.fw;
    }

    private void pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.uc == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.uc.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("targetProps");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object objOpt = jSONObjectOptJSONObject.opt(next);
                    if (TextUtils.equals(next, d.ar) && jSONObject3.has(d.ar)) {
                        if (objOpt instanceof JSONArray) {
                            com.byazt.aa.hw.pr(jSONObject3.optJSONArray(d.ar), (JSONArray) objOpt);
                        }
                    } else {
                        jSONObject3.put(next, objOpt);
                    }
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                jSONArrayOptJSONArray.put(jSONObject3);
                if (!jSONObject.has("children")) {
                    jSONObject.put("children", jSONArrayOptJSONArray);
                }
            }
        } catch (JSONException e) {
        }
    }

    public static boolean x(pr prVar) {
        return (prVar == null || prVar.hn == null) ? false : true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr {
        public boolean aj;
        public LinkedList<pr> c;
        public String fw;
        public JSONObject hn;
        public String hw;
        public String pr;
        public pr uc;
        public boolean vk;
        public boolean w;
        public JSONObject x;
        public String zo;

        public String pr() {
            return this.pr;
        }

        public String hw() {
            return this.fw;
        }

        public boolean hn() {
            return this.aj;
        }

        public String x() {
            return this.hw;
        }

        public void pr(String str) {
            this.hw = str;
        }

        public void pr(boolean z) {
            this.vk = z;
        }

        public void hw(boolean z) {
            this.w = z;
        }

        public JSONObject c() {
            return this.hn;
        }

        public List<pr> uc() {
            return this.c;
        }

        public void pr(pr prVar) {
            if (this.c == null) {
                this.c = new LinkedList<>();
            }
            this.c.add(prVar);
        }

        public void hw(pr prVar) {
            if (this.c == null) {
                this.c = new LinkedList<>();
            }
            this.c.addLast(prVar);
        }

        public void pr(int i, pr prVar) {
            if (this.c == null) {
                this.c = new LinkedList<>();
            }
            this.c.add(i, prVar);
        }

        public JSONObject fw() {
            return this.x;
        }

        public String toString() {
            return "UGNode{id='" + this.pr + "', name='" + this.hw + '\'' + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
