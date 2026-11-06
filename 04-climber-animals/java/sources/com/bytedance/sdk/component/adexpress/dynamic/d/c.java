package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.sl;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static HashMap<String, String> ab;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ah ah;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.d c;
    private ms d;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f785ms;
    private JSONObject xr;

    static {
        HashMap<String, String> map = new HashMap<>();
        ab = map;
        map.put(MediaFormat.KEY_SUBTITLE, BundleKey.DESCRIPTION);
        ab.put("source", "source|app.app_name");
        ab.put("screenshot", "dynamic_creative.screenshot");
    }

    public c(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f785ms = jSONObject;
        this.xr = jSONObject2;
        this.ah = new com.bytedance.sdk.component.adexpress.dynamic.ah.ah(jSONObject2);
        this.d = ms.ms(jSONObject3);
        this.c = com.bytedance.sdk.component.adexpress.dynamic.ah.d.ms(jSONObject4);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ah.x ms(double d, int i, double d2, String str, zb zbVar) {
        JSONObject jSONObject;
        this.ah.ms();
        try {
            jSONObject = new JSONObject(this.c.xr);
        } catch (JSONException e) {
            sl.ms(e);
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVarMs = ms(d.ms(this.f785ms, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.ah.x) null);
        ms(xVarMs);
        ka kaVar = new ka(d, i, d2, str, zbVar);
        ka.ms msVar = new ka.ms();
        msVar.f789ms = this.d.f786ms;
        msVar.xr = this.d.xr;
        msVar.ah = 0.0f;
        kaVar.ms(msVar);
        kaVar.ms(xVarMs, 0.0f, 0.0f);
        kaVar.ms();
        if (kaVar.f788ms.d == 65536.0f) {
            return null;
        }
        return kaVar.f788ms.c;
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        int iMs;
        if (xVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah() != null) {
            iMs = com.bytedance.sdk.component.adexpress.ms.ms.ms.ms().ah().ub();
        } else {
            iMs = com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext());
        }
        float fMin = this.d.ah ? this.d.f786ms : Math.min(this.d.f786ms, com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), iMs));
        if (this.d.xr == 0.0f) {
            xVar.ka(fMin);
            xVar.ch().ka().ch("auto");
            xVar.c(0.0f);
        } else {
            xVar.ka(fMin);
            xVar.c(this.d.ah ? this.d.xr : Math.min(this.d.xr, com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), com.bytedance.sdk.component.adexpress.d.x.ah(com.bytedance.sdk.component.adexpress.d.getContext()))));
            xVar.ch().ka().ch("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ah.x ms(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.c != null) {
                ah ahVar = new ah();
                this.ka = ahVar;
                JSONObject jSONObjectMs = ahVar.ms(this.c.f762ms, iOptInt, jSONObject);
                if (jSONObjectMs != null) {
                    jSONObject = jSONObjectMs;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVarMs = ms(jSONObject);
        xVarMs.ms(xVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            xVarMs.ms((List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>) null);
            return xVarMs;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = xVarMs.ch().ka().gy();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.ah.x xVarMs2 = ms(jSONArrayOptJSONArray2.optJSONObject(i2), xVarMs);
                    if (com.bytedance.sdk.component.adexpress.d.ms() && "skip-with-time".equals(xVarMs.ch().getType()) && !"transparent".equals(xVarMs.re()) && !TextUtils.isEmpty(xVarMs.re())) {
                        xVarMs2.ah(xVarMs.re());
                    }
                    arrayList.add(xVarMs2);
                    arrayList3.add(xVarMs2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            xVarMs.ms(arrayList);
        }
        if (arrayList2.size() > 0) {
            xVarMs.xr(arrayList2);
        }
        return xVarMs;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ah.x ms(JSONObject jSONObject) {
        String strMs;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        ny.ms(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectMs = ny.ms(strOptString, ny.ms(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar = new com.bytedance.sdk.component.adexpress.dynamic.ah.x();
        if (TextUtils.isEmpty(strOptString2)) {
            xVar.xr(String.valueOf(xVar.hashCode()));
        } else {
            xVar.xr(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            xr(xVar);
            xVar.ah((float) jSONObjectOptJSONObject.optDouble("x"));
            xVar.d((float) jSONObjectOptJSONObject.optDouble("y"));
            xVar.ka((float) jSONObjectOptJSONObject.optDouble("width"));
            xVar.c((float) jSONObjectOptJSONObject.optDouble("height"));
            xVar.ab(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.ah.ka kaVar = new com.bytedance.sdk.component.adexpress.dynamic.ah.ka();
            kaVar.ms(strOptString);
            kaVar.xr(jSONObjectOptJSONObject.optString("data"));
            kaVar.ah(jSONObjectOptJSONObject.optString("filterData"));
            kaVar.d(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarMs = com.bytedance.sdk.component.adexpress.dynamic.ah.c.ms(jSONObjectOptJSONObject);
            kaVar.ms(cVarMs);
            com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarMs2 = com.bytedance.sdk.component.adexpress.dynamic.ah.c.ms(jSONObjectMs);
            if (cVarMs2 == null) {
                kaVar.xr(cVarMs);
            } else {
                kaVar.xr(cVarMs2);
            }
            ms(cVarMs);
            ms(cVarMs2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.xr) != null) {
                ms(kaVar, jSONObject2.optInt("image_mode"));
            }
            String type = kaVar.getType();
            com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = kaVar.ka();
            if (ab.containsKey(type) && !cVarKa.sa()) {
                cVarKa.t(ab.get(type));
            }
            if (cVarKa.sa()) {
                strMs = kaVar.xr();
            } else {
                strMs = ms(kaVar.xr());
            }
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strMs = ms("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strMs = ms("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && cVarMs.pl()) {
                    strMs = ms("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(ms()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                kaVar.xr(strMs + "adx:" + ms());
            } else {
                kaVar.xr(strMs);
            }
            kaVar.ah(ms(kaVar.ah()));
            xVar.ms(kaVar);
        }
        return xVar;
    }

    private void xr(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        com.bytedance.sdk.component.adexpress.dynamic.ah.ah ahVar;
        Object objMs;
        Object objMs2;
        Object objMs3;
        Object objMs4;
        if (xVar == null || (ahVar = this.ah) == null || (objMs = ahVar.ms("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objMs);
        if (TextUtils.isEmpty(strValueOf) || (objMs2 = this.ah.ms("title")) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objMs2);
        if (TextUtils.isEmpty(strValueOf2) || (objMs3 = this.ah.ms(BundleKey.DESCRIPTION)) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objMs3);
        if (TextUtils.isEmpty(strValueOf3) || (objMs4 = this.ah.ms("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objMs4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objMs5 = this.ah.ms("app.app_name");
        Object objMs6 = this.ah.ms("source");
        if (objMs5 == null && objMs6 == null) {
            return;
        }
        if (objMs5 == null) {
            objMs5 = objMs6;
        }
        String strValueOf5 = String.valueOf(objMs5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        xVar.ms("imageUrl", strValueOf);
        xVar.ms("title", strValueOf2);
        xVar.ms(BundleKey.DESCRIPTION, strValueOf3);
        xVar.ms("icon", strValueOf4);
        xVar.ms("app_name", strValueOf5);
        xVar.ms(true);
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.ka kaVar, int i) {
        int iLastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            kaVar.ms("video");
            String strMs = ny.ms("video");
            kaVar.ka().t(strMs);
            String strMs2 = ny.ms("video", "clickArea");
            if (!TextUtils.isEmpty(strMs2)) {
                kaVar.ka().ub(strMs2);
                kaVar.ab().ub(strMs2);
            }
            kaVar.ab().t(strMs);
            kaVar.xr(strMs);
            kaVar.ka().oy();
            return;
        }
        kaVar.ms("image");
        String strMs3 = ny.ms("image");
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = kaVar.ka();
        cVarKa.t(strMs3);
        kaVar.ab().t(strMs3);
        String strMs4 = ny.ms("image", "clickArea");
        if (!TextUtils.isEmpty(strMs4)) {
            cVarKa.ub(strMs4);
            kaVar.ab().ub(strMs4);
        }
        JSONObject jSONObjectZx = cVarKa.zx();
        if (jSONObjectZx != null) {
            cVarKa.re(jSONObjectZx.optString("imageLottieTosPath"));
            cVarKa.sl(jSONObjectZx.optBoolean("animationsLoop"));
            cVarKa.yu(jSONObjectZx.optInt("lottieAppNameMaxLength"));
            cVarKa.le(jSONObjectZx.optInt("lottieAdDescMaxLength"));
            cVarKa.op(jSONObjectZx.optInt("lottieAdTitleMaxLength"));
        }
        kaVar.xr(strMs3);
        if (strMs3 != null && (iLastIndexOf = strMs3.lastIndexOf(j.z)) > 0) {
            String strSubstring = strMs3.substring(0, iLastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", ms(strSubstring + ".width"));
                jSONObject.put("height", ms(strSubstring + ".height"));
            } catch (JSONException e) {
                sl.ms(e);
            }
            kaVar.d(jSONObject.toString());
        }
        cVarKa.oi();
    }

    private String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.ah.xr(str2)) {
                String strValueOf = String.valueOf(this.ah.ms(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String ms() {
        com.bytedance.sdk.component.adexpress.dynamic.ah.ah ahVar = this.ah;
        return ahVar == null ? "" : String.valueOf(ahVar.ms("adx_name"));
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.c cVar) {
        if (cVar == null) {
            return;
        }
        String strCv = cVar.cv();
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            String strD = com.bytedance.sdk.component.adexpress.d.x.d(com.bytedance.sdk.component.adexpress.d.getContext());
            if ("zh".equals(strD)) {
                strD = "cn";
            }
            if (!TextUtils.isEmpty(strD) && cVar.c() != null) {
                String strOptString = cVar.c().optString(strD);
                if (!TextUtils.isEmpty(strOptString)) {
                    strCv = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strCv)) {
            return;
        }
        int iIndexOf = strCv.indexOf("{{");
        int iIndexOf2 = strCv.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            cVar.sl(strCv);
            return;
        }
        String strMs = ms(strCv.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strCv.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strMs)) {
            sb.append(strMs);
        }
        sb.append(strCv.substring(iIndexOf2 + 2));
        cVar.sl(sb.toString());
    }

    static class ms {
        boolean ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f786ms;
        float xr;

        public static ms ms(JSONObject jSONObject) {
            ms msVar = new ms();
            if (jSONObject != null) {
                msVar.f786ms = (float) jSONObject.optDouble("width");
                msVar.xr = (float) jSONObject.optDouble("height");
                msVar.ah = jSONObject.optBoolean("isLandscape");
            }
            return msVar;
        }
    }
}
