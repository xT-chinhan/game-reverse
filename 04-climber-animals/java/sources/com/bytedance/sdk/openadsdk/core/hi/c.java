package com.bytedance.sdk.openadsdk.core.hi;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static JSONObject ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("ad_extra_data");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            return new JSONObject(strOptString);
        } catch (JSONException e) {
            sl.ms(e);
            return null;
        }
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("open_ad_sdk_download_extra");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ah(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static class ms extends com.bytedance.sdk.component.ch.ny {
        private lm ah;
        private boolean d;
        private Bridge ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private TTDownloadEventModel f2633ms;
        private com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms xr;

        public static ms ms(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            return new ms(tTDownloadEventModel, z);
        }

        private boolean ms(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long jOptLong = jSONObject.optLong("ad_id");
                long jOptLong2 = jSONObject2.optLong("ad_id");
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

        private ms(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            JSONObject extJson;
            JSONObject materialMeta;
            lm lmVar;
            super("LogTask");
            this.f2633ms = tTDownloadEventModel;
            this.d = z;
            this.ka = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
            TTDownloadEventModel tTDownloadEventModel2 = this.f2633ms;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null || (extJson = this.f2633ms.getExtJson()) == null) {
                return;
            }
            String strOptString = extJson.optString("ad_extra_data");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("open_ad_sdk_download_extra");
                com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms.ms(jSONObjectOptJSONObject);
                this.xr = msVarMs;
                if (msVarMs == null) {
                    return;
                }
                msVarMs.ms(tTDownloadEventModel.getTag());
                this.xr.xr(this.f2633ms.getLabel());
                this.ah = this.xr.f2623ms;
                if (g.xr < 4400 || (materialMeta = tTDownloadEventModel.getMaterialMeta()) == null || (lmVar = this.ah) == null || ms(materialMeta, lmVar.it())) {
                    return;
                }
                this.ah.nw(materialMeta.toString());
                this.ah.t(String.valueOf(materialMeta.optLong("creative_id")));
                JSONObject jSONObjectRm = this.ah.rm();
                jSONObjectOptJSONObject.put("material_meta", jSONObjectRm);
                com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms msVarMs2 = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms.ms(jSONObjectOptJSONObject);
                if (msVarMs2 == null) {
                    return;
                }
                this.xr = msVarMs2;
                msVarMs2.xr(tTDownloadEventModel.getLabel());
                this.f2633ms = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(jSONObjectRm).setExtJson(extJson);
                this.ah = this.xr.f2623ms;
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return re.getContext();
        }

        private boolean ms(String str) {
            return this.d || c.ah(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TTDownloadEventModel tTDownloadEventModel = this.f2633ms;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                sl.ms("LibEventLogger", "label: " + this.f2633ms.getLabel() + " tag: " + tag);
                com.bytedance.sdk.openadsdk.core.hi.ah.xr.ms msVar = this.xr;
                if (msVar != null && !TextUtils.isEmpty(msVar.xr)) {
                    tag = this.xr.xr;
                }
                if (this.ka != null) {
                    if (((Boolean) this.ka.call(2, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_TAG_INTERCEPT, tag).ms(TTDownloadField.TT_LABEL, this.f2633ms.getLabel()).ms(TTDownloadField.TT_META, this.ah.rm().toString())).xr(), Boolean.class)).booleanValue()) {
                        return;
                    }
                }
                if (this.xr != null && this.ah != null && !TextUtils.isEmpty(this.f2633ms.getTag()) && !TextUtils.isEmpty(this.f2633ms.getLabel())) {
                    JSONObject jSONObjectMs = c.ms(this.f2633ms.getExtJson());
                    String str = this.xr.xr;
                    if (!ms(this.f2633ms.getTag()) || "click".equals(this.f2633ms.getLabel())) {
                        return;
                    }
                    jSONObjectMs.remove("open_ad_sdk_download_extra");
                    jSONObjectMs.putOpt("obm_convert", nw.ah(this.ah));
                    com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ah, str, this.f2633ms.getLabel(), jSONObjectMs);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
