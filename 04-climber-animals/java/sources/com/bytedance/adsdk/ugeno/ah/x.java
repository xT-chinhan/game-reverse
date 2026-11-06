package com.bytedance.adsdk.ugeno.ah;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private boolean ab;
    private String ah;
    private JSONObject c;
    private JSONObject d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f337ms;
    private JSONObject xr;

    public x(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public x(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.f337ms = jSONObject.optJSONObject("body");
            } else {
                this.f337ms = jSONObject.optJSONObject("main_template");
            }
            this.xr = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has(TTDownloadField.TT_META)) {
                jSONObjectOptJSONObject = jSONObject.optJSONObject(TTDownloadField.TT_META);
            } else {
                jSONObjectOptJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (jSONObjectOptJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.ab = true;
                    String strOptString = jSONObjectOptJSONObject.optString("version");
                    this.ah = strOptString;
                    if (TextUtils.isEmpty(strOptString)) {
                        this.ah = "3.0";
                    }
                } else {
                    this.ah = jSONObjectOptJSONObject.optString("sdk_version");
                }
                if (jSONObjectOptJSONObject.has("adType")) {
                    this.ka = jSONObjectOptJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.ah = "3.0";
                this.ab = true;
            }
            this.d = jSONObject2;
            this.c = jSONObject3;
        }
    }

    public ms ms() {
        return ka();
    }

    private ms ka() {
        if (!d()) {
            return ms(this.f337ms, (ms) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            String strOptString = this.d.optString("xSize");
            if (!TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(strOptString);
                if (jSONObject2.optInt("width") > 0) {
                    jSONObject.put("width", jSONObject2.optInt("width"));
                }
                if (jSONObject2.optInt("height") > 0) {
                    jSONObject.put("height", jSONObject2.optInt("height"));
                }
            }
        } catch (JSONException unused) {
        }
        ms msVar = new ms();
        msVar.xr = "View";
        msVar.f338ms = "virtualNode";
        msVar.ah = jSONObject;
        msVar.c = null;
        msVar.ab = this.ah;
        msVar.x = this.ka;
        msVar.ms(ms(this.f337ms, msVar));
        return msVar;
    }

    public String xr() {
        return this.ah;
    }

    public List<ms> ah() {
        if (this.xr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = this.xr.keys();
        while (itKeys.hasNext()) {
            ms msVarMs = ms(this.xr.optJSONObject(itKeys.next()), (ms) null);
            if (msVarMs != null) {
                arrayList.add(msVarMs);
            }
        }
        return arrayList;
    }

    private ms ms(JSONObject jSONObject, ms msVar) {
        String strOptString;
        String strOptString2;
        ms msVarMs;
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
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        }
        ms msVar2 = new ms();
        msVar2.f338ms = strOptString3;
        if (!this.ab || !TextUtils.equals("Video", strOptString)) {
            msVar2.xr = strOptString;
        } else {
            msVar2.xr = strOptString + "V3";
        }
        msVar2.ah = jSONObject2;
        msVar2.c = msVar;
        msVar2.ab = this.ah;
        msVar2.x = this.ka;
        if (jSONObject2.has("i18n")) {
            msVar2.d = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(strOptString, "CustomComponent")) {
            ms(jSONObject, msVar2.ah);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    strOptString2 = jSONObject.optString("type");
                } else {
                    strOptString2 = jSONObject.optString(Common.System.NAME);
                }
                String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectOptJSONObject.optString("id"), this.d);
                if (TextUtils.equals(strOptString2, "Template")) {
                    JSONObject jSONObject3 = this.xr;
                    if (jSONObject3 != null) {
                        jSONObjectOptJSONObject = jSONObject3.optJSONObject(strMs);
                        msVarMs = ms(jSONObjectOptJSONObject, msVar2);
                    } else {
                        msVarMs = null;
                    }
                } else {
                    msVarMs = ms(jSONObjectOptJSONObject, msVar2);
                }
                if (msVarMs != null) {
                    msVarMs.xr(xr(msVarMs));
                    msVarMs.ms(ms(msVarMs));
                }
                if (ah(msVarMs)) {
                    i++;
                    msVar2.xr(msVarMs);
                } else if (msVarMs != null) {
                    msVar2.ms(i2 - i, msVarMs);
                }
            }
        }
        return msVar2;
    }

    public boolean ms(ms msVar) {
        JSONObject jSONObjectD;
        if (msVar == null || (jSONObjectD = msVar.d()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectD.optString("width"), "match_parent");
    }

    public boolean xr(ms msVar) {
        JSONObject jSONObjectD;
        if (msVar == null || (jSONObjectD = msVar.d()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectD.optString("height"), "match_parent");
    }

    public boolean ah(ms msVar) {
        JSONObject jSONObjectD;
        if (msVar == null || (jSONObjectD = msVar.d()) == null) {
            return false;
        }
        return TextUtils.equals(jSONObjectD.optString("position"), "absolute");
    }

    public boolean d() {
        return this.ab;
    }

    private void ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.c == null || jSONObject2 == null) {
            return;
        }
        try {
            String strOptString = this.c.optString(jSONObject2.optString("targetId"));
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
                    if (TextUtils.equals(next, g.ax) && jSONObject3.has(g.ax)) {
                        if (objOpt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.c.xr.ms(jSONObject3.optJSONArray(g.ax), (JSONArray) objOpt);
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
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static boolean d(ms msVar) {
        return (msVar == null || msVar.ah == null) ? false : true;
    }

    public static class ms {
        private String ab;
        private JSONObject ah;
        private ms c;
        private boolean ch;
        private JSONObject d;
        private LinkedList<ms> ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f338ms;
        private boolean ny;
        private String x;
        private String xr;

        public String ms() {
            return this.f338ms;
        }

        public String xr() {
            return this.ab;
        }

        public String ah() {
            return this.xr;
        }

        public void ms(String str) {
            this.xr = str;
        }

        public void ms(boolean z) {
            this.ny = z;
        }

        public void xr(boolean z) {
            this.ch = z;
        }

        public JSONObject d() {
            return this.ah;
        }

        public List<ms> ka() {
            return this.ka;
        }

        public void ms(ms msVar) {
            if (this.ka == null) {
                this.ka = new LinkedList<>();
            }
            this.ka.add(msVar);
        }

        public void xr(ms msVar) {
            if (this.ka == null) {
                this.ka = new LinkedList<>();
            }
            this.ka.addLast(msVar);
        }

        public void ms(int i, ms msVar) {
            if (this.ka == null) {
                this.ka = new LinkedList<>();
            }
            this.ka.add(i, msVar);
        }

        public JSONObject c() {
            return this.d;
        }

        public String toString() {
            return "UGNode{id='" + this.f338ms + "', name='" + this.xr + "'}";
        }
    }
}
