package com.byazt.ms;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.ho.BaseConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 8})
public class s {
    public static JSONObject n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            return new JSONObject(strOptString);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("open_ad_sdk_download_extra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.byazt.wg.qg.AD_TAG_FEED.equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || com.byazt.wg.qg.AD_TAG_BANNER.equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || com.byazt.wg.qg.AD_TAG_EXPRESS_BANNER.equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    @com.byazt.cp.n(n = {0, 1, 238, 546})
    public static class n extends com.byazt.qit.x {
        public TTDownloadEventModel n;
        public boolean q;
        public com.byazt.esa.qg qg;
        public pk s;

        public static n n(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            return new n(tTDownloadEventModel, z);
        }

        private boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long jOptLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long jOptLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String strOptString = jSONObject.optString("req_id");
                String strOptString2 = jSONObject2.optString("req_id");
                long jOptLong3 = jSONObject.optLong("creative_id");
                long jOptLong4 = jSONObject2.optLong("creative_id");
                String strOptString3 = jSONObject.optString("origin_req_id");
                String strOptString4 = jSONObject2.optString("origin_req_id");
                if (jOptLong != 0 && jOptLong == jOptLong2 && jOptLong3 != 0 && jOptLong3 == jOptLong4) {
                    if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                        return TextUtils.equals(strOptString3, strOptString4);
                    }
                    return TextUtils.equals(strOptString, strOptString2);
                }
            }
            return false;
        }

        private n(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            JSONObject extJson;
            pk pkVar;
            super("LogTask");
            this.n = tTDownloadEventModel;
            this.q = z;
            if (tTDownloadEventModel == null || tTDownloadEventModel.getExtJson() == null || (extJson = this.n.getExtJson()) == null) {
                return;
            }
            String strOptString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra");
                com.byazt.esa.qg qgVarN = com.byazt.esa.qg.n(jSONObjectOptJSONObject);
                this.qg = qgVarN;
                if (qgVarN == null) {
                    return;
                }
                qgVarN.n(tTDownloadEventModel.getTag());
                this.qg.qg(this.n.getLabel());
                this.s = this.qg.n;
                JSONObject materialMeta = tTDownloadEventModel.getMaterialMeta();
                if (materialMeta == null || (pkVar = this.s) == null || n(materialMeta, pkVar.A_())) {
                    return;
                }
                this.s.t(materialMeta.toString());
                this.s.h(String.valueOf(materialMeta.optLong("creative_id")));
                JSONObject jSONObjectPv = this.s.pv();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectPv);
                com.byazt.esa.qg qgVarN2 = com.byazt.esa.qg.n(jSONObjectOptJSONObject);
                if (qgVarN2 == null) {
                    return;
                }
                this.qg = qgVarN2;
                qgVarN2.qg(tTDownloadEventModel.getLabel());
                this.n = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(jSONObjectPv).setExtJson(extJson);
                this.s = this.qg.n;
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return com.byazt.nf.rv.getContext();
        }

        private boolean n(String str) {
            return this.q || s.s(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTDownloadEventModel tTDownloadEventModel = this.n;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                this.n.getLabel();
                com.byazt.esa.qg qgVar = this.qg;
                if (qgVar != null && !TextUtils.isEmpty(qgVar.qg)) {
                    tag = this.qg.qg;
                }
                if (!com.byazt.esa.s.n(tag, this.n.getLabel(), this.s, 0) && this.qg != null && this.s != null && !TextUtils.isEmpty(this.n.getTag()) && !TextUtils.isEmpty(this.n.getLabel())) {
                    JSONObject jSONObjectN = s.n(this.n.getExtJson());
                    String str = this.qg.qg;
                    if (!n(this.n.getTag()) || "click".equals(this.n.getLabel())) {
                        return;
                    }
                    jSONObjectN.remove("open_ad_sdk_download_extra");
                    jSONObjectN.putOpt("obm_convert", um.qg(this.s));
                    if (n(this.n.getLabel(), jSONObjectN)) {
                        com.byazt.eji.s.n().qg(this.s, this.n.getLabel(), jSONObjectN);
                    } else {
                        com.byazt.hm.n.qg(this.s, str, this.n.getLabel(), jSONObjectN);
                    }
                }
            } catch (Throwable th) {
                com.byazt.eji.s.n().n("dl_event", th);
            }
        }

        private boolean n(String str, JSONObject jSONObject) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "download_finish") && !TextUtils.equals(str, "install_finish")) {
                if (jSONObject != null && jSONObject.optInt("csj_report_stats", -1) == 1) {
                    jSONObject.remove("csj_report_stats");
                    return true;
                }
                JSONArray jSONArrayCi = com.byazt.nf.rv.qg().ci();
                if (jSONArrayCi != null) {
                    for (int i = 0; i < jSONArrayCi.length(); i++) {
                        if (TextUtils.equals(jSONArrayCi.optString(i), str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
