package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.r;
import com.anythink.core.common.v.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private static r a(String str, JSONObject jSONObject, int i) {
        return a(str, jSONObject, i, false);
    }

    public static r a(String str, JSONObject jSONObject, int i, boolean z) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.anythink.core.common.d.j.e.e);
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            } else if (!jSONObject.has("seatbid")) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONArray("seatbid").optJSONObject(0);
            r rVar = new r();
            rVar.L(jSONObjectOptJSONObject2.toString());
            rVar.V(jSONObject.toString());
            rVar.b(str);
            rVar.k(jSONObjectOptJSONObject2.optString(com.anythink.core.common.k.ah));
            rVar.l(jSONObjectOptJSONObject2.optString("c_id"));
            rVar.x(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.A));
            rVar.m(jSONObjectOptJSONObject2.optString("title"));
            rVar.n(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.f));
            rVar.i(jSONObjectOptJSONObject2.optInt("rating"));
            rVar.o(jSONObjectOptJSONObject2.optString("icon_u"));
            rVar.q(jSONObjectOptJSONObject2.optString("full_u"));
            rVar.g(jSONObjectOptJSONObject2.optInt("unit_type"));
            rVar.r(jSONObjectOptJSONObject2.optString("tp_logo_u"));
            rVar.s(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.k));
            rVar.t(jSONObjectOptJSONObject2.optString("video_u"));
            rVar.e(jSONObjectOptJSONObject2.optInt("video_l"));
            rVar.ac(jSONObjectOptJSONObject2.optString("video_r"));
            rVar.ad(jSONObjectOptJSONObject2.optString("ec_u"));
            rVar.u(jSONObjectOptJSONObject2.optString("store_u"));
            rVar.h(jSONObjectOptJSONObject2.optInt("link_type"));
            rVar.w(jSONObjectOptJSONObject2.optString("click_u"));
            rVar.v(jSONObjectOptJSONObject2.optString("deeplink"));
            rVar.t(jSONObjectOptJSONObject2.optInt("crt_type", 1));
            rVar.ae(jSONObjectOptJSONObject2.optString("img_list"));
            rVar.af(jSONObjectOptJSONObject2.optString("banner_xhtml"));
            rVar.f(jSONObjectOptJSONObject2.optInt("offer_firm_id"));
            rVar.j(jSONObjectOptJSONObject2.optString("jump_url"));
            try {
                String strOptString = jSONObjectOptJSONObject2.optString("sdk_resp");
                if (!TextUtils.isEmpty(strOptString)) {
                    rVar.a(new JSONObject(strOptString).optString("data"));
                }
            } catch (Throwable unused) {
            }
            rVar.ag(jSONObjectOptJSONObject2.optString("app_name"));
            rVar.z(jSONObjectOptJSONObject2.optString("publisher"));
            rVar.A(jSONObjectOptJSONObject2.optString("app_version"));
            rVar.B(jSONObjectOptJSONObject2.optString("privacy"));
            rVar.C(jSONObjectOptJSONObject2.optString("permission"));
            rVar.c(jSONObjectOptJSONObject2.optString(com.anythink.core.common.e.g.a.N));
            rVar.i(jSONObjectOptJSONObject2.optString("mtr_ver"));
            int i2 = 2;
            rVar.u(jSONObjectOptJSONObject2.optInt("o_im_cap_sw", 2));
            rVar.v(jSONObjectOptJSONObject2.optInt("o_cl_cap_sw", 2));
            rVar.w(jSONObjectOptJSONObject2.optInt("c_im_cap_sw", 2));
            rVar.x(jSONObjectOptJSONObject2.optInt("c_cl_cap_sw", 2));
            if (i == 67) {
                rVar.a(2);
            } else {
                rVar.a(1);
            }
            rVar.c(bk.u(jSONObjectOptJSONObject2.optString("ctrl")));
            rVar.a(bl.a(jSONObjectOptJSONObject2.optString("tk")));
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject2.optString("nw_info"));
                rVar.X(jSONObject2.optString("app_id"));
                rVar.Y(jSONObject2.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.APP_KEY));
                rVar.Z(jSONObject2.optString("unit_id"));
            } catch (Throwable unused2) {
            }
            rVar.aa(jSONObjectOptJSONObject2.optString("dsp_id", ""));
            rVar.ab(jSONObjectOptJSONObject2.optString("dsp_oid", ""));
            rVar.r(jSONObjectOptJSONObject2.optInt("fca", -1));
            rVar.s(jSONObjectOptJSONObject2.optInt("install_sw", -1));
            rVar.H(jSONObjectOptJSONObject2.optString("wv_ctrl"));
            rVar.e(jSONObjectOptJSONObject2.optInt("adp_type"));
            rVar.f(jSONObjectOptJSONObject2.optString("offer_html"));
            rVar.g(jSONObjectOptJSONObject2.optString("offer_url"));
            rVar.d(jSONObjectOptJSONObject2.optString("wx_username"));
            rVar.e(jSONObjectOptJSONObject2.optString("wx_path"));
            rVar.c(jSONObjectOptJSONObject2.optInt("o_w"));
            rVar.d(jSONObjectOptJSONObject2.optInt("o_h"));
            if (z) {
                jSONObjectOptJSONObject2.put(r.c, 1);
            }
            rVar.b(jSONObjectOptJSONObject2.optInt(r.c));
            rVar.J(jSONObjectOptJSONObject2.optString("mraid_u"));
            if (i == 66 && !TextUtils.isEmpty(rVar.G())) {
                String strOptString2 = jSONObjectOptJSONObject2.optString("dp_package", "");
                rVar.D(strOptString2);
                if (TextUtils.isEmpty(strOptString2)) {
                    i2 = 3;
                } else if (q.b(t.b().g(), strOptString2)) {
                    i2 = 1;
                }
                rVar.j(i2);
            }
            rVar.K(jSONObjectOptJSONObject2.optString("adm"));
            rVar.p(jSONObjectOptJSONObject2.optInt("cr_m", 1));
            rVar.q(jSONObjectOptJSONObject2.optInt("scr_m", 1));
            rVar.n(jSONObjectOptJSONObject2.optInt("img_w", 0));
            rVar.o(jSONObjectOptJSONObject2.optInt("img_h", 0));
            rVar.k(jSONObjectOptJSONObject2.optInt("video_w", 0));
            rVar.l(jSONObjectOptJSONObject2.optInt("video_h", 0));
            rVar.N(jSONObjectOptJSONObject2.optString("a_info", ""));
            rVar.O(jSONObjectOptJSONObject2.optString("a_privacy", ""));
            rVar.M(jSONObjectOptJSONObject2.optString("a_info_url", ""));
            rVar.S(jSONObjectOptJSONObject2.optString("fast_u", ""));
            rVar.R(jSONObjectOptJSONObject2.optString("market_u", ""));
            rVar.T(jSONObjectOptJSONObject2.optString("d_c_u", ""));
            rVar.U(jSONObjectOptJSONObject2.optString("om_ids", ""));
            rVar.W(jSONObjectOptJSONObject2.optString("p_pkg", ""));
            return rVar;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
