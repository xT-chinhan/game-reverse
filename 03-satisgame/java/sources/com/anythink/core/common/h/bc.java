package com.anythink.core.common.h;

import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bc extends y {
    protected int o;

    public static bc u(String str) {
        bc bcVar = new bc();
        if (TextUtils.isEmpty(str)) {
            return bcVar;
        }
        try {
            return a(new JSONObject(str));
        } catch (Throwable unused) {
            return bcVar;
        }
    }

    private static bc a(JSONObject jSONObject) {
        bc bcVar = new bc();
        try {
            bcVar.r(jSONObject.optInt("f_t"));
            bcVar.s(jSONObject.optInt("v_c"));
            bcVar.t(jSONObject.optInt("s_b_t"));
            bcVar.v(jSONObject.optInt("e_c_a"));
            bcVar.w(jSONObject.optInt("v_m"));
            bcVar.x(jSONObject.optInt("s_c_t"));
            bcVar.m(jSONObject.optInt("m_t"));
            bcVar.c(jSONObject.optLong("o_c_t", com.anythink.core.e.i.f));
            bcVar.n(jSONObject.optInt("ak_cfm"));
            bcVar.b(jSONObject.optLong("ctdown_time"));
            bcVar.o(jSONObject.optInt("sk_able"));
            bcVar.p(jSONObject.optInt("orient"));
            bcVar.e(jSONObject.optString("size"));
            bcVar.q(jSONObject.optInt("cl_btn"));
            bcVar.y(jSONObject.optInt("ec_r"));
            bcVar.z(jSONObject.optInt("ec_s_t"));
            bcVar.A(jSONObject.optInt("ec_l_t"));
            bcVar.f(jSONObject.optString(com.anythink.core.common.k.aG));
            bcVar.o = jSONObject.optInt("spl_type");
            bcVar.a(jSONObject.optLong("or_t"));
            bcVar.f(jSONObject.optInt("rv_fail_reward"));
            bcVar.g(jSONObject.optInt("cl_sz"));
            bcVar.j(jSONObject.optInt("si_fit"));
            if (jSONObject.has("at_cl_sw")) {
                bcVar.B(jSONObject.optInt("at_cl_sw"));
            }
            if (jSONObject.has("at_ct_ti")) {
                bcVar.C(jSONObject.optInt("at_ct_ti"));
            }
            if (jSONObject.has("int_cl_sw")) {
                bcVar.D(jSONObject.optInt("int_cl_sw"));
            }
            if (jSONObject.has("int_cl_ti")) {
                bcVar.E(jSONObject.optInt("int_cl_ti"));
            }
            if (jSONObject.has("sh_ec")) {
                bcVar.F(jSONObject.optInt("sh_ec"));
            }
            if (jSONObject.has("ipua")) {
                bcVar.d(jSONObject.optInt("ipua"));
            }
            if (jSONObject.has("clua")) {
                bcVar.e(jSONObject.optInt("clua"));
            }
            if (jSONObject.has("ap_arpt")) {
                bcVar.G(jSONObject.optInt("ap_arpt"));
            }
            if (jSONObject.has("ap_pasbl")) {
                bcVar.H(jSONObject.optInt("ap_pasbl"));
            }
            if (jSONObject.has("shk_sw")) {
                bcVar.I(jSONObject.optInt("shk_sw"));
            }
            if (jSONObject.has("shk_strength_and")) {
                bcVar.J(jSONObject.optInt("shk_strength_and"));
            }
            if (jSONObject.has("shk_time")) {
                bcVar.d(jSONObject.optLong("shk_time"));
            }
            if (jSONObject.has("click_cache_time")) {
                bcVar.K(jSONObject.optInt("click_cache_time"));
            } else {
                bcVar.K(BaseConstants.Time.HOUR);
            }
            if (jSONObject.has("click_nt_sw")) {
                bcVar.L(jSONObject.optInt("click_nt_sw"));
            } else {
                bcVar.L(1);
            }
            if (jSONObject.has("ft_cl_sz")) {
                bcVar.h(jSONObject.optInt("ft_cl_sz"));
            } else {
                bcVar.h(1);
            }
            if (jSONObject.has("sh_cl_itp")) {
                bcVar.i(jSONObject.optInt("sh_cl_itp"));
            } else {
                bcVar.i(2);
            }
            bcVar.M(jSONObject.optInt("shm_t", -1));
            if (jSONObject.has(com.anythink.core.common.f.k.a.d)) {
                bcVar.N(jSONObject.optInt(com.anythink.core.common.f.k.a.d));
            } else {
                bcVar.N(100);
            }
            if (jSONObject.has("rsdl_rate")) {
                bcVar.O(jSONObject.optInt("rsdl_rate"));
            } else {
                bcVar.O(0);
            }
            if (jSONObject.has("video_ctn_type")) {
                bcVar.P(jSONObject.optInt("video_ctn_type"));
            } else {
                bcVar.P(2);
            }
            bcVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
            bcVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
            bcVar.e(jSONObject.optInt("at_cl_ec", 2) == 1);
            bcVar.e(jSONObject.optLong("at_cl_pt", 5000L));
            bcVar.f(jSONObject.optLong("at_cl_pct", 5000L));
            bcVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
            bcVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
            bcVar.k(jSONObject.optLong("sub_splash_time", 0L));
            bcVar.l(jSONObject.optLong("s_b_t_top", 2000L));
            bcVar.m(jSONObject.optLong("s_b_d_top", 5000L));
            bcVar.W(jSONObject.optInt("apk_verify", 1));
            bcVar.X(jSONObject.optInt("apk_redown", 2));
            bcVar.Y(jSONObject.optInt("install_bg", 1));
            bcVar.aa(jSONObject.optInt("click_close", 2));
            bcVar.ab(jSONObject.optInt("cta_type", 1));
            bcVar.ac(jSONObject.optInt("cd_play_sw", 2));
            bcVar.ad(2);
            bcVar.af(bcVar.w());
            bcVar.ae(800);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Double.valueOf(15.0d));
            arrayList.add(Double.valueOf(10.0d));
            bcVar.a(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bcVar;
    }

    private int ae() {
        return this.o;
    }

    private void aG(int i) {
        this.o = i;
    }
}
