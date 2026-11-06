package com.byazt.vh;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public float fs;
    public String l;
    public JSONObject n;
    public JSONObject q;
    public JSONObject qg;
    public float rv;
    public String s;
    public boolean tj;
    public JSONObject w;
    public boolean x;

    public rv(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public rv(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        this.tj = true;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.n = jSONObject.optJSONObject("body");
            } else {
                this.n = jSONObject.optJSONObject("main_template");
            }
            if (jSONObject.has("sub")) {
                this.qg = jSONObject.optJSONObject("sub");
            } else {
                this.qg = jSONObject.optJSONObject("sub_templates");
            }
            if (jSONObject.has("meta")) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("meta");
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.x = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.s = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.s = "3.0";
                    }
                } else {
                    this.s = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.l = jSONObjectOptJSONObject.optString("adType");
                }
                if (jSONObjectOptJSONObject.has("gestureThrough")) {
                    this.tj = com.byazt.hb.s.n(jSONObjectOptJSONObject.optString("gestureThrough"), true);
                }
            } else if (jSONObject.has("body")) {
                this.s = "3.0";
                this.x = true;
            }
            this.q = jSONObject2;
            this.w = jSONObject3;
        }
    }

    public n n() {
        return l();
    }

    public void n(float f, float f2) {
        this.fs = f;
        this.rv = f2;
    }

    private n l() {
        if (!q()) {
            return n(this.n, (n) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.fs;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.rv;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            JSONObject jSONObject2 = this.q;
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
        } catch (JSONException unused) {
        }
        n nVar = new n();
        nVar.qg = "View";
        nVar.n = "virtualNode";
        nVar.s = jSONObject;
        nVar.x = null;
        nVar.fs = this.s;
        nVar.tj = this.tj;
        nVar.rv = this.l;
        nVar.n(n(this.n, nVar));
        return nVar;
    }

    public String qg() {
        return this.s;
    }

    public List<n> s() {
        if (this.qg == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.qg.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            n nVarN = n(this.qg.optJSONObject(next), (n) null);
            if (nVarN != null) {
                nVarN.n(next);
                arrayList.add(nVarN);
            }
        }
        return arrayList;
    }

    private n n(JSONObject jSONObject, n nVar) {
        String strOptString;
        String strOptString2;
        n nVarN;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            strOptString = jSONObject.optString("type");
        } else {
            strOptString = jSONObject.optString(TapEventParamConstants.PARAM_NAME);
        }
        String strOptString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        n nVar2 = new n();
        nVar2.n = strOptString3;
        if (!this.x || !TextUtils.equals("Video", strOptString)) {
            nVar2.qg = strOptString;
        } else {
            nVar2.qg = strOptString + "V3";
        }
        nVar2.s = jSONObject2;
        nVar2.x = nVar;
        nVar2.fs = this.s;
        nVar2.tj = this.tj;
        nVar2.rv = this.l;
        if (jSONObject2.has("i18n")) {
            nVar2.q = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            n(jSONObject, nVar2.s);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString(TapEventParamConstants.PARAM_NAME);
                }
                String strN = com.byazt.mcb.qg.n(jSONObjectOptJSONObject.optString("id"), this.q);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.qg;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strN);
                        nVarN = n(jSONObjectOptJSONObject, nVar2);
                    } else {
                        nVarN = null;
                    }
                } else {
                    nVarN = n(jSONObjectOptJSONObject, nVar2);
                }
                if (nVarN != null) {
                    nVarN.qg(qg(nVarN));
                    nVarN.n(n(nVarN));
                }
                if (s(nVarN)) {
                    i++;
                    nVar2.qg(nVarN);
                } else if (nVarN != null) {
                    nVar2.n(i2 - i, nVarN);
                }
            }
        }
        return nVar2;
    }

    public boolean n(n nVar) {
        JSONObject jSONObjectW;
        if (nVar == null || (jSONObjectW = nVar.w()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectW.optString("width"), "match_parent");
    }

    public boolean qg(n nVar) {
        JSONObject jSONObjectW;
        if (nVar == null || (jSONObjectW = nVar.w()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectW.optString("height"), "match_parent");
    }

    public boolean s(n nVar) {
        JSONObject jSONObjectW;
        if (nVar == null || (jSONObjectW = nVar.w()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectW.optString("position"), "absolute");
    }

    public boolean q() {
        return this.x;
    }

    private void n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.w == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.w.optString(jSONObject2.optString("targetId"));
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
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (objOpt instanceof JSONArray) {
                            com.byazt.hb.qg.n(jSONObject3.optJSONArray("events"), (JSONArray) objOpt);
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
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", jSONArrayOptJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean q(n nVar) {
        return (nVar == null || nVar.s == null) ? false : true;
    }

    @com.byazt.cp.n(n = {0, 1, 1778, 160})
    public static class n {
        public boolean cp;
        public boolean d;
        public String fs;
        public String l;
        public String n;
        public JSONObject q;
        public String qg;
        public String rv;
        public JSONObject s;
        public boolean tj;
        public LinkedList<n> w;
        public n x;

        public String n() {
            return this.n;
        }

        public String qg() {
            return this.l;
        }

        public void n(String str) {
            this.l = str;
        }

        public String s() {
            return this.fs;
        }

        public boolean q() {
            return this.tj;
        }

        public String l() {
            return this.qg;
        }

        public void qg(String str) {
            this.qg = str;
        }

        public void n(boolean z) {
            this.cp = z;
        }

        public void qg(boolean z) {
            this.d = z;
        }

        public JSONObject w() {
            return this.s;
        }

        public List<n> x() {
            return this.w;
        }

        public void n(n nVar) {
            if (this.w == null) {
                this.w = new LinkedList<>();
            }
            this.w.add(nVar);
        }

        public void qg(n nVar) {
            if (this.w == null) {
                this.w = new LinkedList<>();
            }
            this.w.addLast(nVar);
        }

        public void n(int i, n nVar) {
            if (this.w == null) {
                this.w = new LinkedList<>();
            }
            this.w.add(i, nVar);
        }

        public JSONObject fs() {
            return this.q;
        }

        public String toString() {
            return "UGNode{id='" + this.n + "', name='" + this.qg + "'}";
        }
    }
}
