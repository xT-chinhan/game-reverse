package com.anythink.basead.f.e;

import com.anythink.core.common.d.j;
import com.anythink.core.common.e.g;
import com.anythink.core.common.h.bi;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.x;
import com.anythink.core.common.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String a = "sdk_updatetime";

    public static final bi a(x xVar, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(j.e.e);
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONArray("offers").optJSONObject(0);
            bi biVar = new bi();
            biVar.a(xVar.f);
            biVar.k(jSONObjectOptJSONObject2.optString(k.ah));
            biVar.l(jSONObjectOptJSONObject2.optString("c_id"));
            biVar.x(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.A));
            biVar.m(jSONObjectOptJSONObject2.optString("title"));
            biVar.n(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.f));
            biVar.i(jSONObjectOptJSONObject2.optInt("rating"));
            biVar.o(jSONObjectOptJSONObject2.optString("icon_u"));
            biVar.q(jSONObjectOptJSONObject2.optString("full_u"));
            biVar.g(jSONObjectOptJSONObject2.optInt("unit_type"));
            biVar.r(jSONObjectOptJSONObject2.optString("tp_logo_u"));
            biVar.s(jSONObjectOptJSONObject2.optString(com.anythink.basead.c.b.a.k));
            biVar.t(jSONObjectOptJSONObject2.optString("video_u"));
            biVar.e(jSONObjectOptJSONObject2.optInt("video_l"));
            biVar.ac(jSONObjectOptJSONObject2.optString("video_r"));
            biVar.ad(jSONObjectOptJSONObject2.optString("ec_u"));
            biVar.u(jSONObjectOptJSONObject2.optString("store_u"));
            biVar.h(jSONObjectOptJSONObject2.optInt("link_type"));
            biVar.w(jSONObjectOptJSONObject2.optString("click_u"));
            biVar.v(jSONObjectOptJSONObject2.optString("deeplink"));
            biVar.b(jSONObjectOptJSONObject2.optInt("r_target"));
            biVar.b(jSONObjectOptJSONObject2.optLong("expire"));
            biVar.y(jSONObjectOptJSONObject2.optString("ad_logo_title"));
            biVar.t(jSONObjectOptJSONObject2.optInt("crt_type", 1));
            biVar.ae(jSONObjectOptJSONObject2.optString("img_list"));
            biVar.af(jSONObjectOptJSONObject2.optString("banner_xhtml"));
            biVar.c(jSONObject.optLong(a));
            biVar.f(jSONObjectOptJSONObject2.optInt("offer_firm_id"));
            biVar.j(jSONObjectOptJSONObject2.optString("jump_url"));
            biVar.ag(jSONObjectOptJSONObject2.optString("app_name"));
            biVar.z(jSONObjectOptJSONObject2.optString("publisher"));
            biVar.A(jSONObjectOptJSONObject2.optString("app_version"));
            biVar.B(jSONObjectOptJSONObject2.optString("privacy"));
            biVar.C(jSONObjectOptJSONObject2.optString("permission"));
            biVar.c(jSONObjectOptJSONObject2.optString(g.a.N));
            biVar.H(jSONObjectOptJSONObject2.optString("wv_ctrl"));
            biVar.c(bk.u(jSONObjectOptJSONObject2.optString("ctrl")));
            biVar.a(bl.a(jSONObjectOptJSONObject2.optString("tk")));
            biVar.e(jSONObjectOptJSONObject2.optInt("adp_type"));
            biVar.f(jSONObjectOptJSONObject2.optString("offer_html"));
            biVar.g(jSONObjectOptJSONObject2.optString("offer_url"));
            biVar.d(jSONObjectOptJSONObject2.optString("wx_username"));
            biVar.e(jSONObjectOptJSONObject2.optString("wx_path"));
            biVar.c(jSONObjectOptJSONObject2.optInt("o_w"));
            biVar.d(jSONObjectOptJSONObject2.optInt("o_h"));
            return biVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
