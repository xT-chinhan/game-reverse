package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ba extends y {
    protected int o;

    public static ba u(String str) {
        ba baVar = new ba();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                baVar.s(jSONObject.optInt("f_t"));
                baVar.t(jSONObject.optInt("v_c"));
                baVar.u(jSONObject.optInt("s_b_t"));
                baVar.w(jSONObject.optInt("e_c_a"));
                baVar.x(jSONObject.optInt("v_m"));
                baVar.y(jSONObject.optInt("s_c_t"));
                baVar.n(jSONObject.optInt("m_t"));
                baVar.c(jSONObject.optLong("o_c_t", 604800000L));
                baVar.o(jSONObject.optInt("ak_cfm"));
                baVar.b(jSONObject.optLong("ctdown_time"));
                baVar.p(jSONObject.optInt("sk_able"));
                baVar.q(jSONObject.optInt("orient"));
                baVar.e(jSONObject.optString("size"));
                baVar.r(jSONObject.optInt("cl_btn"));
                baVar.z(jSONObject.optInt("ec_r"));
                baVar.A(jSONObject.optInt("ec_s_t"));
                baVar.B(jSONObject.optInt("ec_l_t"));
                baVar.f(jSONObject.optString(com.anythink.core.common.k.aF));
                baVar.o = jSONObject.optInt("spl_type");
                baVar.a(jSONObject.optLong("or_t"));
                baVar.g(jSONObject.optInt("rv_fail_reward"));
                baVar.h(jSONObject.optInt("cl_sz"));
                baVar.k(jSONObject.optInt("si_fit"));
                if (jSONObject.has("at_cl_sw")) {
                    baVar.C(jSONObject.optInt("at_cl_sw"));
                }
                if (jSONObject.has("at_ct_ti")) {
                    baVar.D(jSONObject.optInt("at_ct_ti"));
                }
                if (jSONObject.has("int_cl_sw")) {
                    baVar.E(jSONObject.optInt("int_cl_sw"));
                }
                if (jSONObject.has("int_cl_ti")) {
                    baVar.F(jSONObject.optInt("int_cl_ti"));
                }
                if (jSONObject.has("sh_ec")) {
                    baVar.G(jSONObject.optInt("sh_ec"));
                }
                if (jSONObject.has("ipua")) {
                    baVar.e(jSONObject.optInt("ipua"));
                }
                if (jSONObject.has("clua")) {
                    baVar.f(jSONObject.optInt("clua"));
                }
                if (jSONObject.has("ap_arpt")) {
                    baVar.H(jSONObject.optInt("ap_arpt"));
                }
                if (jSONObject.has("ap_pasbl")) {
                    baVar.I(jSONObject.optInt("ap_pasbl"));
                }
                if (jSONObject.has("shk_sw")) {
                    baVar.J(jSONObject.optInt("shk_sw"));
                }
                if (jSONObject.has("shk_strength_and")) {
                    baVar.K(jSONObject.optInt("shk_strength_and"));
                }
                if (jSONObject.has("shk_time")) {
                    baVar.d(jSONObject.optLong("shk_time"));
                }
                if (jSONObject.has("click_cache_time")) {
                    baVar.L(jSONObject.optInt("click_cache_time"));
                } else {
                    baVar.L(3600000);
                }
                if (jSONObject.has("click_nt_sw")) {
                    baVar.M(jSONObject.optInt("click_nt_sw"));
                } else {
                    baVar.M(1);
                }
                if (jSONObject.has("ft_cl_sz")) {
                    baVar.i(jSONObject.optInt("ft_cl_sz"));
                } else {
                    baVar.i(1);
                }
                if (jSONObject.has("sh_cl_itp")) {
                    baVar.j(jSONObject.optInt("sh_cl_itp"));
                } else {
                    baVar.j(2);
                }
                baVar.N(jSONObject.optInt("shm_t", -1));
                if (jSONObject.has(com.anythink.core.common.e.q.a.d)) {
                    baVar.O(jSONObject.optInt(com.anythink.core.common.e.q.a.d));
                } else {
                    baVar.O(100);
                }
                if (jSONObject.has("rsdl_rate")) {
                    baVar.P(jSONObject.optInt("rsdl_rate"));
                } else {
                    baVar.P(0);
                }
                if (jSONObject.has("video_ctn_type")) {
                    baVar.Q(jSONObject.optInt("video_ctn_type"));
                } else {
                    baVar.Q(2);
                }
                baVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
                baVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
                baVar.e(jSONObject.optInt("at_cl_ec", 2) == 1);
                baVar.e(jSONObject.optLong("at_cl_pt", 5000L));
                baVar.f(jSONObject.optLong("at_cl_pct", 5000L));
                baVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
                baVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
                baVar.k(jSONObject.optLong("sub_splash_time", 0L));
                baVar.l(jSONObject.optLong("s_b_t_top", com.anythink.basead.exoplayer.i.a.f));
                baVar.m(jSONObject.optLong("s_b_d_top", 5000L));
                baVar.X(jSONObject.optInt(com.anythink.core.common.e.g.a.j, 1));
                baVar.Y(jSONObject.optInt("apk_redown", 2));
                baVar.Z(jSONObject.optInt("install_bg", 1));
                baVar.ab(jSONObject.optInt("click_close", 2));
                baVar.ac(jSONObject.optInt("cta_type", 1));
                baVar.ad(jSONObject.optInt("cd_play_sw", 2));
                baVar.ae(2);
                baVar.ag(baVar.V());
                baVar.af(800);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Double.valueOf(15.0d));
                arrayList.add(Double.valueOf(10.0d));
                baVar.a(arrayList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return baVar;
    }

    public final int a() {
        return this.o;
    }

    private void aI(int i) {
        this.o = i;
    }
}
