package com.byazt.uko;

import android.text.TextUtils;
import com.byazt.mq.m;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 5})
public class uc {
    public static HashMap<String, String> fw;
    public hn c;
    public com.byazt.rk.hn hn;
    public JSONObject hw;
    public JSONObject pr;
    public com.byazt.rk.x uc;
    public pr x;

    static {
        HashMap<String, String> map = new HashMap<>();
        fw = map;
        map.put(MediaFormat.KEY_SUBTITLE, BundleKey.DESCRIPTION);
        fw.put("source", "source|app.app_name");
        fw.put("screenshot", "dynamic_creative.screenshot");
    }

    public uc(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.pr = jSONObject;
        this.hw = jSONObject2;
        this.hn = new com.byazt.rk.hn(jSONObject2);
        this.x = pr.pr(jSONObject3);
        this.uc = com.byazt.rk.x.pr(jSONObject4);
    }

    public com.byazt.rk.zo pr(double d, int i, double d2, String str, m mVar) {
        JSONObject jSONObject;
        this.hn.pr();
        try {
            jSONObject = new JSONObject(this.uc.hw);
        } catch (JSONException e) {
            jSONObject = null;
        }
        com.byazt.rk.zo zoVarPr = pr(x.pr(this.pr, jSONObject), (com.byazt.rk.zo) null);
        pr(zoVarPr);
        c cVar = new c(d, i, d2, str, mVar);
        c.pr prVar = new c.pr();
        prVar.pr = this.x.pr;
        prVar.hw = this.x.hw;
        prVar.hn = 0.0f;
        cVar.pr(prVar);
        cVar.pr(zoVarPr, 0.0f, 0.0f);
        cVar.pr();
        if (cVar.pr.x == 65536.0f) {
            return null;
        }
        return cVar.pr.uc;
    }

    private void pr(com.byazt.rk.zo zoVar) {
        int iPr;
        if (zoVar == null) {
            return;
        }
        if (com.byazt.bg.pr.pr().hn() != null) {
            iPr = com.byazt.bg.pr.pr().hn().m();
        } else {
            iPr = com.byazt.js.zo.pr(com.byazt.dj.x.getContext());
        }
        float fMin = this.x.hn ? this.x.pr : Math.min(this.x.pr, com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), iPr));
        if (this.x.hw == 0.0f) {
            zoVar.c(fMin);
            zoVar.vk().c().vk("auto");
            zoVar.uc(0.0f);
        } else {
            zoVar.c(fMin);
            zoVar.uc(this.x.hn ? this.x.hw : Math.min(this.x.hw, com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), com.byazt.js.zo.hn(com.byazt.dj.x.getContext()))));
            zoVar.vk().c().vk("fixed");
        }
    }

    public com.byazt.rk.zo pr(JSONObject jSONObject, com.byazt.rk.zo zoVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.equals(strOptString, "custom-component-vessel")) {
            int iOptInt = jSONObject.optInt("componentId");
            if (this.uc != null) {
                hn hnVar = new hn();
                this.c = hnVar;
                JSONObject jSONObjectPr = hnVar.pr(this.uc.pr, iOptInt, jSONObject);
                if (jSONObjectPr != null) {
                    jSONObject = jSONObjectPr;
                }
            }
        }
        com.byazt.rk.zo zoVarPr = pr(jSONObject);
        zoVarPr.pr(zoVar);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("children");
        if (jSONArrayOptJSONArray == null) {
            zoVarPr.pr((List<com.byazt.rk.zo>) null);
            return zoVarPr;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(strOptString, "tag-group")) {
                    length = zoVarPr.vk().c().pq();
                } else {
                    length = jSONArrayOptJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.byazt.rk.zo zoVarPr2 = pr(jSONArrayOptJSONArray2.optJSONObject(i2), zoVarPr);
                    if (com.byazt.dj.x.pr() && "skip-with-time".equals(zoVarPr.vk().getType()) && !"transparent".equals(zoVarPr.fo()) && !TextUtils.isEmpty(zoVarPr.fo())) {
                        zoVarPr2.hn(zoVarPr.fo());
                    }
                    arrayList.add(zoVarPr2);
                    arrayList3.add(zoVarPr2);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            zoVarPr.pr(arrayList);
        }
        if (arrayList2.size() > 0) {
            zoVarPr.hw(arrayList2);
        }
        return zoVarPr;
    }

    public com.byazt.rk.zo pr(JSONObject jSONObject) {
        String strPr;
        JSONObject jSONObject2;
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("id");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("values");
        aj.pr(strOptString, jSONObjectOptJSONObject);
        JSONObject jSONObjectPr = aj.pr(strOptString, aj.pr(jSONObject.optJSONArray("sceneValues")), jSONObjectOptJSONObject);
        com.byazt.rk.zo zoVar = new com.byazt.rk.zo();
        if (TextUtils.isEmpty(strOptString2)) {
            zoVar.hw(String.valueOf(zoVar.hashCode()));
        } else {
            zoVar.hw(strOptString2);
        }
        if (jSONObjectOptJSONObject != null) {
            hw(zoVar);
            zoVar.hn((float) jSONObjectOptJSONObject.optDouble("x"));
            zoVar.x((float) jSONObjectOptJSONObject.optDouble("y"));
            zoVar.c((float) jSONObjectOptJSONObject.optDouble("width"));
            zoVar.uc((float) jSONObjectOptJSONObject.optDouble("height"));
            zoVar.fw(jSONObjectOptJSONObject.optInt("remainWidth"));
            com.byazt.rk.c cVar = new com.byazt.rk.c();
            cVar.pr(strOptString);
            cVar.hw(jSONObjectOptJSONObject.optString("data"));
            cVar.hn(jSONObjectOptJSONObject.optString("filterData"));
            cVar.x(jSONObjectOptJSONObject.optString("dataExtraInfo"));
            com.byazt.rk.uc ucVarPr = com.byazt.rk.uc.pr(jSONObjectOptJSONObject);
            cVar.pr(ucVarPr);
            com.byazt.rk.uc ucVarPr2 = com.byazt.rk.uc.pr(jSONObjectPr);
            if (ucVarPr2 == null) {
                cVar.hw(ucVarPr);
            } else {
                cVar.hw(ucVarPr2);
            }
            pr(ucVarPr);
            pr(ucVarPr2);
            if (TextUtils.equals(strOptString, "video-image-budget") && (jSONObject2 = this.hw) != null) {
                pr(cVar, jSONObject2.optInt("image_mode"));
            }
            String type = cVar.getType();
            com.byazt.rk.uc ucVarC = cVar.c();
            if (fw.containsKey(type) && !ucVarC.f()) {
                ucVarC.a(fw.get(type));
            }
            if (ucVarC.f()) {
                strPr = cVar.hw();
            } else {
                strPr = pr(cVar.hw());
            }
            if (com.byazt.dj.x.pr()) {
                if (TextUtils.equals(type, "star") || TextUtils.equals(type, "text_star")) {
                    strPr = pr("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(type, "score-count") || TextUtils.equals(type, "score-count-type-1") || TextUtils.equals(type, "score-count-type-2")) {
                    strPr = pr("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(type) && ucVarPr.xg()) {
                    strPr = pr("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(pr()) && (TextUtils.equals("logo-union", strOptString) || TextUtils.equals("logo", strOptString))) {
                cVar.hw(strPr + "adx:" + pr());
            } else {
                cVar.hw(strPr);
            }
            cVar.hn(pr(cVar.hn()));
            zoVar.pr(cVar);
        }
        return zoVar;
    }

    private void hw(com.byazt.rk.zo zoVar) {
        com.byazt.rk.hn hnVar;
        Object objPr;
        Object objPr2;
        Object objPr3;
        Object objPr4;
        if (zoVar == null || (hnVar = this.hn) == null || (objPr = hnVar.pr("image.0.url")) == null) {
            return;
        }
        String strValueOf = String.valueOf(objPr);
        if (TextUtils.isEmpty(strValueOf) || (objPr2 = this.hn.pr(BundleKey.TITLE)) == null) {
            return;
        }
        String strValueOf2 = String.valueOf(objPr2);
        if (TextUtils.isEmpty(strValueOf2) || (objPr3 = this.hn.pr(BundleKey.DESCRIPTION)) == null) {
            return;
        }
        String strValueOf3 = String.valueOf(objPr3);
        if (TextUtils.isEmpty(strValueOf3) || (objPr4 = this.hn.pr("icon")) == null) {
            return;
        }
        String strValueOf4 = String.valueOf(objPr4);
        if (TextUtils.isEmpty(strValueOf4)) {
            return;
        }
        Object objPr5 = this.hn.pr("app.app_name");
        Object objPr6 = this.hn.pr("source");
        if (objPr5 == null && objPr6 == null) {
            return;
        }
        if (objPr5 == null) {
            objPr5 = objPr6;
        }
        String strValueOf5 = String.valueOf(objPr5);
        if (TextUtils.isEmpty(strValueOf5)) {
            return;
        }
        zoVar.pr("imageUrl", strValueOf);
        zoVar.pr(BundleKey.TITLE, strValueOf2);
        zoVar.pr(BundleKey.DESCRIPTION, strValueOf3);
        zoVar.pr("icon", strValueOf4);
        zoVar.pr(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, strValueOf5);
        zoVar.pr(true);
    }

    private void pr(com.byazt.rk.c cVar, int i) {
        int iLastIndexOf;
        switch (i) {
            case 5:
            case 15:
            case 50:
            case MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET /* 154 */:
                cVar.pr("video");
                String strPr = aj.pr("video");
                cVar.c().a(strPr);
                String strPr2 = aj.pr("video", "clickArea");
                if (!TextUtils.isEmpty(strPr2)) {
                    cVar.c().ho(strPr2);
                    cVar.fw().ho(strPr2);
                }
                cVar.fw().a(strPr);
                cVar.hw(strPr);
                cVar.c().vv();
                break;
            default:
                cVar.pr(ImageViewManager.NAME);
                String strPr3 = aj.pr(ImageViewManager.NAME);
                com.byazt.rk.uc ucVarC = cVar.c();
                ucVarC.a(strPr3);
                cVar.fw().a(strPr3);
                String strPr4 = aj.pr(ImageViewManager.NAME, "clickArea");
                if (!TextUtils.isEmpty(strPr4)) {
                    ucVarC.ho(strPr4);
                    cVar.fw().ho(strPr4);
                }
                JSONObject jSONObjectT = ucVarC.t();
                if (jSONObjectT != null) {
                    ucVarC.fo(jSONObjectT.optString("imageLottieTosPath"));
                    ucVarC.k(jSONObjectT.optBoolean("animationsLoop"));
                    ucVarC.b(jSONObjectT.optInt("lottieAppNameMaxLength"));
                    ucVarC.ve(jSONObjectT.optInt("lottieAdDescMaxLength"));
                    ucVarC.iu(jSONObjectT.optInt("lottieAdTitleMaxLength"));
                }
                cVar.hw(strPr3);
                if (strPr3 != null && (iLastIndexOf = strPr3.lastIndexOf(".")) > 0) {
                    String strSubstring = strPr3.substring(0, iLastIndexOf);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", pr(strSubstring + ".width"));
                        jSONObject.put("height", pr(strSubstring + ".height"));
                        break;
                    } catch (JSONException e) {
                    }
                    cVar.x(jSONObject.toString());
                }
                ucVarC.tv();
                break;
        }
    }

    private String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.hn.hw(str2)) {
                String strValueOf = String.valueOf(this.hn.pr(str2));
                if (!TextUtils.isEmpty(strValueOf)) {
                    return strValueOf;
                }
            }
        }
        return "";
    }

    private String pr() {
        com.byazt.rk.hn hnVar = this.hn;
        if (hnVar == null) {
            return "";
        }
        return String.valueOf(hnVar.pr("adx_name"));
    }

    private void pr(com.byazt.rk.uc ucVar) {
        if (ucVar == null) {
            return;
        }
        String strGz = ucVar.gz();
        if (com.byazt.dj.x.pr()) {
            String strX = com.byazt.js.zo.x(com.byazt.dj.x.getContext());
            if ("zh".equals(strX)) {
                strX = "cn";
            }
            if (!TextUtils.isEmpty(strX) && ucVar.uc() != null) {
                String strOptString = ucVar.uc().optString(strX);
                if (!TextUtils.isEmpty(strOptString)) {
                    strGz = strOptString;
                }
            }
        }
        if (TextUtils.isEmpty(strGz)) {
            return;
        }
        int iIndexOf = strGz.indexOf("{{");
        int iIndexOf2 = strGz.indexOf("}}");
        if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf2 < iIndexOf) {
            ucVar.k(strGz);
            return;
        }
        String strPr = pr(strGz.substring(iIndexOf + 2, iIndexOf2));
        StringBuilder sb = new StringBuilder(strGz.substring(0, iIndexOf));
        if (!TextUtils.isEmpty(strPr)) {
            sb.append(strPr);
        }
        sb.append(strGz.substring(iIndexOf2 + 2));
        ucVar.k(sb.toString());
    }

    @com.byazt.vzx.pr(pr = {0, 1, 931, 129})
    static class pr {
        public boolean hn;
        public float hw;
        public float pr;

        public static pr pr(JSONObject jSONObject) {
            pr prVar = new pr();
            if (jSONObject != null) {
                prVar.pr = (float) jSONObject.optDouble("width");
                prVar.hw = (float) jSONObject.optDouble("height");
                prVar.hn = jSONObject.optBoolean("isLandscape");
            }
            return prVar;
        }
    }
}
