package com.smartdigimkt.t2;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.core.SDKContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static com.smartdigimkt.b3.b a(String str, JSONObject jSONObject, String str2, int i, boolean z) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.l.f.R);
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            } else if (!jSONObject.has("seatbid")) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONArray("seatbid").optJSONObject(0);
            if (jSONObjectOptJSONObject2 == null) {
                return null;
            }
            com.smartdigimkt.b3.b bVar = new com.smartdigimkt.b3.b();
            if (TextUtils.isEmpty(str2)) {
                bVar.Q = jSONObject.toString();
            } else {
                bVar.Q = str2;
            }
            bVar.a = jSONObjectOptJSONObject2.optString(com.anythink.core.common.k.ai);
            bVar.b = jSONObjectOptJSONObject2.optString("c_id");
            bVar.m = jSONObjectOptJSONObject2.optString(SDMAdConst.NETWORK_CUSTOM_KEY.PKG);
            bVar.c = jSONObjectOptJSONObject2.optString("title");
            bVar.d = jSONObjectOptJSONObject2.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
            jSONObjectOptJSONObject2.optInt("rating");
            bVar.e = jSONObjectOptJSONObject2.optString("icon_u");
            bVar.f = jSONObjectOptJSONObject2.optString("full_u");
            bVar.n = jSONObjectOptJSONObject2.optInt("unit_type");
            bVar.g = jSONObjectOptJSONObject2.optString("tp_logo_u");
            bVar.h = jSONObjectOptJSONObject2.optString("cta");
            bVar.i = jSONObjectOptJSONObject2.optString("video_u");
            bVar.S = jSONObjectOptJSONObject2.optInt("video_l");
            jSONObjectOptJSONObject2.optString("video_r");
            bVar.T = jSONObjectOptJSONObject2.optString("ec_u");
            bVar.j = jSONObjectOptJSONObject2.optString("store_u");
            bVar.o = jSONObjectOptJSONObject2.optInt("link_type");
            bVar.l = jSONObjectOptJSONObject2.optString("click_u");
            bVar.k = jSONObjectOptJSONObject2.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DEEPLINK);
            bVar.U = jSONObjectOptJSONObject2.optInt("crt_type", 1);
            bVar.V = jSONObjectOptJSONObject2.optString("img_list");
            jSONObjectOptJSONObject2.optString("banner_xhtml");
            bVar.p = jSONObjectOptJSONObject2.optInt("offer_firm_id");
            bVar.q = jSONObjectOptJSONObject2.optString("jump_url");
            String strOptString = jSONObjectOptJSONObject2.optString("sdk_resp");
            if (!TextUtils.isEmpty(strOptString)) {
                bVar.l0 = strOptString;
            }
            bVar.X = jSONObjectOptJSONObject2.optString("app_name");
            bVar.r = jSONObjectOptJSONObject2.optString("publisher");
            bVar.s = jSONObjectOptJSONObject2.optString("app_version");
            bVar.t = jSONObjectOptJSONObject2.optString("privacy");
            bVar.u = jSONObjectOptJSONObject2.optString("permission");
            bVar.v = jSONObjectOptJSONObject2.optString(SDMAdConst.NETWORK_CUSTOM_KEY.APP_FUNCTION_URL);
            bVar.Y = jSONObjectOptJSONObject2.optInt("o_im_cap_sw", 2);
            bVar.Z = jSONObjectOptJSONObject2.optInt("o_cl_cap_sw", 2);
            bVar.a0 = jSONObjectOptJSONObject2.optInt("c_im_cap_sw", 2);
            bVar.b0 = jSONObjectOptJSONObject2.optInt("c_cl_cap_sw", 2);
            if (i == 67) {
                bVar.j0 = 2;
            } else {
                bVar.j0 = 1;
            }
            bVar.w = com.smartdigimkt.b3.m.a(jSONObjectOptJSONObject2.optJSONObject("ctrl"));
            bVar.W = com.smartdigimkt.b3.n.a(jSONObjectOptJSONObject2.optJSONObject("tk"));
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("nw_info");
                if (jSONObjectOptJSONObject3 != null) {
                    jSONObjectOptJSONObject3.optString("app_id");
                    jSONObjectOptJSONObject3.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.APP_KEY);
                    jSONObjectOptJSONObject3.optString("unit_id");
                }
            } catch (Throwable unused) {
            }
            bVar.c0 = jSONObjectOptJSONObject2.optString("dsp_id", "");
            bVar.d0 = jSONObjectOptJSONObject2.optString("dsp_oid", "");
            bVar.e0 = jSONObjectOptJSONObject2.optInt("fca", -1);
            bVar.f0 = jSONObjectOptJSONObject2.optInt(com.smartdigimkt.r4.o.d, -1);
            bVar.y = jSONObjectOptJSONObject2.optString("wv_ctrl");
            bVar.z = jSONObjectOptJSONObject2.optInt("adp_type");
            bVar.A = jSONObjectOptJSONObject2.optString("wx_username");
            bVar.B = jSONObjectOptJSONObject2.optString("wx_path");
            jSONObjectOptJSONObject2.optInt("o_w");
            jSONObjectOptJSONObject2.optInt("o_h");
            if (z) {
                jSONObjectOptJSONObject2.put(com.anythink.core.common.h.r.c, 1);
            }
            bVar.k0 = jSONObjectOptJSONObject2.optInt(com.anythink.core.common.h.r.c);
            if (i == 66 && !TextUtils.isEmpty(bVar.k)) {
                String strOptString2 = jSONObjectOptJSONObject2.optString("dp_package", "");
                bVar.K = strOptString2;
                if (TextUtils.isEmpty(strOptString2)) {
                    bVar.J = 3;
                } else {
                    bVar.J = com.smartdigimkt.r4.k.c(SDKContext.getInstance().d(), strOptString2) ? 1 : 2;
                }
            }
            jSONObjectOptJSONObject2.optInt("cr_m", 1);
            int iOptInt = jSONObjectOptJSONObject2.optInt("img_w", 0);
            synchronized (bVar) {
                bVar.E = iOptInt;
            }
            bVar.a(jSONObjectOptJSONObject2.optInt("img_h", 0));
            bVar.G = jSONObjectOptJSONObject2.optInt("video_w", 0);
            bVar.H = jSONObjectOptJSONObject2.optInt("video_h", 0);
            bVar.O = jSONObjectOptJSONObject2.optString("fast_u", "");
            bVar.N = jSONObjectOptJSONObject2.optString("market_u", "");
            bVar.P = jSONObjectOptJSONObject2.optString("d_c_u", "");
            bVar.R = jSONObjectOptJSONObject2.optString("p_pkg", "");
            if (TextUtils.isEmpty(bVar.m)) {
                String strB = com.smartdigimkt.z.k.b(bVar.k);
                if (TextUtils.isEmpty(strB)) {
                    strB = com.smartdigimkt.z.k.b(bVar.N);
                }
                if (!TextUtils.isEmpty(strB)) {
                    bVar.m = strB;
                }
            }
            return bVar;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
