package com.byazt.lm;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 61})
public class aj {
    public static JSONObject pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString);
                } catch (JSONException e) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("open_ad_sdk_download_extra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.byazt.pfl.hw.AD_TAG_FEED.equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || com.byazt.pfl.hw.AD_TAG_BANNER.equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || com.byazt.pfl.hw.AD_TAG_EXPRESS_BANNER.equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    public static class pr extends com.byazt.xlm.fw {
        public of hn;
        public com.byazt.vo.hw hw;
        public zo pr;
        public boolean x;

        public static pr pr(zo zoVar, boolean z) {
            return new pr(zoVar, z);
        }

        private boolean pr(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject == null || jSONObject2 == null) {
                return false;
            }
            long jOptLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
            long jOptLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
            String strOptString = jSONObject.optString("req_id");
            String strOptString2 = jSONObject2.optString("req_id");
            long jOptLong3 = jSONObject.optLong("creative_id");
            long jOptLong4 = jSONObject2.optLong("creative_id");
            String strOptString3 = jSONObject.optString("origin_req_id");
            String strOptString4 = jSONObject2.optString("origin_req_id");
            if (jOptLong == 0 || jOptLong != jOptLong2 || jOptLong3 == 0 || jOptLong3 != jOptLong4) {
                return false;
            }
            if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                return TextUtils.equals(strOptString3, strOptString4);
            }
            return TextUtils.equals(strOptString, strOptString2);
        }

        private pr(zo zoVar, boolean z) {
            JSONObject jSONObjectX;
            of ofVar;
            super("LogTask");
            this.x = false;
            this.pr = zoVar;
            this.x = z;
            if (zoVar == null || zoVar.x() == null || (jSONObjectX = this.pr.x()) == null) {
                return;
            }
            String strOptString = jSONObjectX.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra");
                com.byazt.vo.hw hwVarPr = com.byazt.vo.hw.pr(jSONObjectOptJSONObject);
                this.hw = hwVarPr;
                if (hwVarPr == null) {
                    return;
                }
                hwVarPr.pr(zoVar.hw());
                this.hw.hw(this.pr.hn());
                this.hn = this.hw.pr;
                JSONObject jSONObjectC = zoVar.c();
                if (jSONObjectC == null || (ofVar = this.hn) == null || pr(jSONObjectC, ofVar.v_())) {
                    return;
                }
                this.hn.z(jSONObjectC.toString());
                this.hn.rc(String.valueOf(jSONObjectC.optLong("creative_id")));
                JSONObject jSONObject = this.hn.to();
                jSONObjectOptJSONObject.put("material_meta", jSONObject);
                com.byazt.vo.hw hwVarPr2 = com.byazt.vo.hw.pr(jSONObjectOptJSONObject);
                if (hwVarPr2 == null) {
                    return;
                }
                this.hw = hwVarPr2;
                hwVarPr2.hw(zoVar.hn());
                this.pr = zo.pr().pr(zoVar.hw()).hw(zoVar.hn()).pr(jSONObject).hw(jSONObjectX);
                this.hn = this.hw.pr;
            } catch (Exception e) {
            }
        }

        private Context getContext() {
            return a.getContext();
        }

        private boolean pr(String str) {
            return this.x || aj.hn(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                zo zoVar = this.pr;
                if (zoVar == null) {
                    return;
                }
                String strHw = zoVar.hw();
                com.byazt.vo.hw hwVar = this.hw;
                if (hwVar != null && !TextUtils.isEmpty(hwVar.hw)) {
                    strHw = this.hw.hw;
                }
                if (!com.byazt.vo.hn.pr(strHw, this.pr.hn(), this.hn, 0) && this.hw != null && this.hn != null && !TextUtils.isEmpty(this.pr.hw()) && !TextUtils.isEmpty(this.pr.hn())) {
                    JSONObject jSONObjectPr = aj.pr(this.pr.x());
                    String str = this.hw.hw;
                    if (!pr(this.pr.hw()) || "click".equals(this.pr.hn())) {
                        return;
                    }
                    jSONObjectPr.remove("open_ad_sdk_download_extra");
                    jSONObjectPr.putOpt("obm_convert", qa.hw(this.hn));
                    com.byazt.pj.pr.hw(this.hn, str, this.pr.hn(), jSONObjectPr);
                }
            } catch (Throwable th) {
            }
        }
    }
}
