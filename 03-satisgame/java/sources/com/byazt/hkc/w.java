package com.byazt.hkc;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.byazt.udb.oa;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.taptap.sdk.compilance.constants.BundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 13})
public class w {
    public static HashMap<String, String> x;
    public s l;
    public JSONObject n;
    public n q;
    public JSONObject qg;
    public com.byazt.lh.s s;
    public com.byazt.lh.q w;

    static {
        HashMap<String, String> map = new HashMap<>();
        x = map;
        map.put(MediaFormat.KEY_SUBTITLE, BundleKey.DESCRIPTION);
        x.put("source", "source|app.app_name");
        x.put("screenshot", "dynamic_creative.screenshot");
    }

    public w(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.n = jSONObject;
        this.qg = jSONObject2;
        this.s = new com.byazt.lh.s(jSONObject2);
        this.q = n.n(jSONObject3);
        this.w = com.byazt.lh.q.n(jSONObject4);
    }

    public com.byazt.lh.fs n(double d, int i, double d2, String str, oa oaVar) {
        JSONObject jSONObject;
        this.s.n();
        try {
            jSONObject = new JSONObject(this.w.qg);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.byazt.lh.fs fsVarN = n(q.n(this.n, jSONObject), (com.byazt.lh.fs) null);
        n(fsVarN);
        l lVar = new l(d, i, d2, str, oaVar);
        l.n nVar = new l.n();
        nVar.n = this.q.n;
        nVar.qg = this.q.qg;
        nVar.s = 0.0f;
        lVar.n(nVar);
        lVar.n(fsVarN, 0.0f, 0.0f);
        lVar.n();
        if (lVar.n.q == 65536.0f) {
            return null;
        }
        return lVar.n.w;
    }

    private void n(com.byazt.lh.fs fsVar) {
        int iN;
        if (fsVar == null) {
            return;
        }
        if (com.byazt.gkj.n.n().s() != null) {
            iN = com.byazt.gkj.n.n().s().oa();
        } else {
            iN = com.byazt.cq.fs.n(com.byazt.twc.q.getContext());
        }
        float fMin = this.q.s ? this.q.n : Math.min(this.q.n, com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), iN));
        if (this.q.qg == 0.0f) {
            fsVar.l(fMin);
            fsVar.tj().l().tj("auto");
            fsVar.w(0.0f);
        } else {
            fsVar.l(fMin);
            fsVar.w(this.q.s ? this.q.qg : Math.min(this.q.qg, com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), com.byazt.cq.fs.s(com.byazt.twc.q.getContext()))));
            fsVar.tj().l().tj("fixed");
        }
    }

    public com.byazt.lh.fs n(JSONObject jSONObject, com.byazt.lh.fs fsVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.w != null) {
                s sVar = new s();
                this.l = sVar;
                JSONObject jSONObjectN = sVar.n(this.w.n, iOptInt, jSONObject);
                if (jSONObjectN != null) {
                    jSONObject = jSONObjectN;
                }
            }
        }
        com.byazt.lh.fs fsVarN = n(jSONObject);
        fsVarN.n(fsVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            fsVarN.n((List<com.byazt.lh.fs>) null);
            return fsVarN;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = fsVarN.tj().l().z();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.byazt.lh.fs fsVarN2 = n(jSONArrayOptJSONArray2.optJSONObject(i2), fsVarN);
                    if (com.byazt.twc.q.n() && "skip-with-time".equals(fsVarN.tj().getType()) && !"transparent".equals(fsVarN.wm()) && !TextUtils.isEmpty(fsVarN.wm())) {
                        fsVarN2.s(fsVarN.wm());
                    }
                    arrayList.add(fsVarN2);
                    arrayList3.add(fsVarN2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            fsVarN.n(arrayList);
        }
        if (arrayList2.size() > 0) {
            fsVarN.qg(arrayList2);
        }
        return fsVarN;
    }

    public com.byazt.lh.fs n(JSONObject jSONObject) {
        String strN;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        rv.n(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectN = rv.n(strOptString, rv.n(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.byazt.lh.fs fsVar = new com.byazt.lh.fs();
        if (TextUtils.isEmpty(strOptString2)) {
            fsVar.qg(String.valueOf(fsVar.hashCode()));
        } else {
            fsVar.qg(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            qg(fsVar);
            fsVar.s((float) jSONObjectOptJSONObject.optDouble(com.byazt.af.x.n));
            fsVar.q((float) jSONObjectOptJSONObject.optDouble("y"));
            fsVar.l((float) jSONObjectOptJSONObject.optDouble("width"));
            fsVar.w((float) jSONObjectOptJSONObject.optDouble("height"));
            fsVar.x(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.byazt.lh.l lVar = new com.byazt.lh.l();
            lVar.n(strOptString);
            lVar.qg(jSONObjectOptJSONObject.optString(f.R));
            lVar.s(jSONObjectOptJSONObject.optString("filterData"));
            lVar.q(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.byazt.lh.w wVarN = com.byazt.lh.w.n(jSONObjectOptJSONObject);
            lVar.n(wVarN);
            com.byazt.lh.w wVarN2 = com.byazt.lh.w.n(jSONObjectN);
            if (wVarN2 == null) {
                lVar.qg(wVarN);
            } else {
                lVar.qg(wVarN2);
            }
            n(wVarN);
            n(wVarN2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.qg) != null) {
                n(lVar, jSONObject2.optInt("image_mode"));
            }
            String type = lVar.getType();
            com.byazt.lh.w wVarL = lVar.l();
            if (x.containsKey(type) && !wVarL.ri()) {
                wVarL.a(x.get(type));
            }
            if (wVarL.ri()) {
                strN = lVar.qg();
            } else {
                strN = n(lVar.qg());
            }
            if (com.byazt.twc.q.n()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strN = n("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strN = n("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && wVarN.bz()) {
                    strN = n("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(n()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                lVar.qg(strN + "adx:" + n());
            } else {
                lVar.qg(strN);
            }
            lVar.s(n(lVar.s()));
            fsVar.n(lVar);
        }
        return fsVar;
    }

    private void qg(com.byazt.lh.fs fsVar) {
        com.byazt.lh.s sVar;
        Object objN;
        Object objN2;
        Object objN3;
        Object objN4;
        if (fsVar == null || (sVar = this.s) == null || (objN = sVar.n("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objN);
        if (TextUtils.isEmpty(strValueOf) || (objN2 = this.s.n("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objN2);
        if (TextUtils.isEmpty(strValueOf2) || (objN3 = this.s.n(BundleKey.DESCRIPTION)) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objN3);
        if (TextUtils.isEmpty(strValueOf3) || (objN4 = this.s.n("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objN4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objN5 = this.s.n("app.app_name");
        Object objN6 = this.s.n("source");
        if (objN5 == null && objN6 == null) {
            return;
        }
        if (objN5 == null) {
            objN5 = objN6;
        }
        String strValueOf5 = String.valueOf(objN5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        fsVar.n("imageUrl", strValueOf);
        fsVar.n("title", strValueOf2);
        fsVar.n(BundleKey.DESCRIPTION, strValueOf3);
        fsVar.n("icon", strValueOf4);
        fsVar.n("app_name", strValueOf5);
        fsVar.n(true);
    }

    private void n(com.byazt.lh.l lVar, int i) {
        int iLastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            lVar.n(MediaFormat.KEY_VIDEO);
            String strN = rv.n(MediaFormat.KEY_VIDEO);
            lVar.l().a(strN);
            String strN2 = rv.n(MediaFormat.KEY_VIDEO, "clickArea");
            if (!TextUtils.isEmpty(strN2)) {
                lVar.l().k(strN2);
                lVar.x().k(strN2);
            }
            lVar.x().a(strN);
            lVar.qg(strN);
            lVar.l().jh();
            return;
        }
        lVar.n("image");
        String strN3 = rv.n("image");
        com.byazt.lh.w wVarL = lVar.l();
        wVarL.a(strN3);
        lVar.x().a(strN3);
        String strN4 = rv.n("image", "clickArea");
        if (!TextUtils.isEmpty(strN4)) {
            wVarL.k(strN4);
            lVar.x().k(strN4);
        }
        JSONObject jSONObjectTi = wVarL.ti();
        if (jSONObjectTi != null) {
            wVarL.wm(jSONObjectTi.optString("imageLottieTosPath"));
            wVarL.d(jSONObjectTi.optBoolean("animationsLoop"));
            wVarL.h(jSONObjectTi.optInt("lottieAppNameMaxLength"));
            wVarL.ur(jSONObjectTi.optInt("lottieAdDescMaxLength"));
            wVarL.t(jSONObjectTi.optInt("lottieAdTitleMaxLength"));
        }
        lVar.qg(strN3);
        if (strN3 != null && (iLastIndexOf = strN3.lastIndexOf(i.E)) > 0) {
            String strSubstring = strN3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", n(strSubstring + ".width"));
                jSONObject.put("height", n(strSubstring + ".height"));
            } catch (JSONException unused) {
            }
            lVar.q(jSONObject.toString());
        }
        wVarL.xb();
    }

    private String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.s.qg(str2)) {
                String strValueOf = String.valueOf(this.s.n(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String n() {
        com.byazt.lh.s sVar = this.s;
        return sVar == null ? "" : String.valueOf(sVar.n("adx_name"));
    }

    private void n(com.byazt.lh.w wVar) {
        if (wVar == null) {
            return;
        }
        String strBb = wVar.bb();
        if (com.byazt.twc.q.n()) {
            String strQ = com.byazt.cq.fs.q(com.byazt.twc.q.getContext());
            if ("zh".equals(strQ)) {
                strQ = "cn";
            }
            if (!TextUtils.isEmpty(strQ) && wVar.w() != null) {
                String strOptString = wVar.w().optString(strQ);
                if (!TextUtils.isEmpty(strOptString)) {
                    strBb = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strBb)) {
            return;
        }
        int iIndexOf = strBb.indexOf("{{");
        int iIndexOf2 = strBb.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            wVar.d(strBb);
            return;
        }
        String strN = n(strBb.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strBb.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strN)) {
            sb.append(strN);
        }
        sb.append(strBb.substring(iIndexOf2 + 2));
        wVar.d(sb.toString());
    }

    @com.byazt.cp.n(n = {0, 1, 46, 108})
    static class n {
        public float n;
        public float qg;
        public boolean s;

        public static n n(JSONObject jSONObject) {
            n nVar = new n();
            if (jSONObject != null) {
                nVar.n = (float) jSONObject.optDouble("width");
                nVar.qg = (float) jSONObject.optDouble("height");
                nVar.s = jSONObject.optBoolean("isLandscape");
            }
            return nVar;
        }
    }
}
