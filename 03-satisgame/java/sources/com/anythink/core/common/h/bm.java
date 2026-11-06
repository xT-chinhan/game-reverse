package com.anythink.core.common.h;

import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bm extends y {
    private int o;
    private int p;
    private int q;

    private int ae() {
        return this.p;
    }

    private void aG(int i) {
        this.p = i;
    }

    private int af() {
        return this.o;
    }

    private void aH(int i) {
        this.o = i;
    }

    private int ag() {
        return this.q;
    }

    private void aI(int i) {
        this.q = i;
    }

    public static bm u(String str) {
        int i;
        bm bmVar = new bm();
        if (TextUtils.isEmpty(str)) {
            return bmVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bmVar.r(jSONObject.optInt("f_t"));
            int iOptInt = jSONObject.optInt("v_c");
            if (iOptInt == 1) {
                iOptInt = 0;
            } else if (iOptInt == 2) {
                iOptInt = 1;
            }
            bmVar.s(iOptInt);
            bmVar.t(jSONObject.optInt("s_b_t"));
            if (jSONObject.has("s_b_d")) {
                bmVar.u(jSONObject.optInt("s_b_d"));
            }
            int iOptInt2 = jSONObject.optInt("e_c_a");
            if (iOptInt2 == 1) {
                iOptInt2 = 0;
            } else if (iOptInt2 == 2) {
                iOptInt2 = 1;
            } else if (iOptInt2 == 3) {
                iOptInt2 = 2;
            }
            bmVar.v(iOptInt2);
            int iOptInt3 = jSONObject.optInt("ak_cfm");
            if (iOptInt3 == 1) {
                iOptInt3 = 0;
            } else if (iOptInt3 == 2) {
                iOptInt3 = 1;
            }
            bmVar.n(iOptInt3);
            bmVar.m(jSONObject.optInt("m_t"));
            int iOptInt4 = jSONObject.optInt("cm");
            if (iOptInt4 == 1) {
                iOptInt4 = 0;
            } else if (iOptInt4 == 2) {
                iOptInt4 = 1;
            }
            bmVar.o = iOptInt4;
            bmVar.d(jSONObject.optInt("ipua"));
            bmVar.e(jSONObject.optInt("clua"));
            bmVar.l(jSONObject.optInt("dp_cm"));
            bmVar.p = jSONObject.optInt("l_o_num");
            bmVar.k(jSONObject.optInt("ld_t"));
            bmVar.y(jSONObject.optInt("ec_r"));
            bmVar.z(jSONObject.optInt("ec_s_t"));
            bmVar.A(jSONObject.optInt("ec_l_t"));
            bmVar.a(jSONObject.optLong("or_t"));
            bmVar.f(jSONObject.optInt("rv_fail_reward"));
            bmVar.g(jSONObject.optInt("cl_sz"));
            bmVar.j(jSONObject.optInt("si_fit"));
            if (jSONObject.has("at_cl_sw")) {
                bmVar.B(jSONObject.optInt("at_cl_sw"));
            }
            if (jSONObject.has("at_ct_ti")) {
                bmVar.C(jSONObject.optInt("at_ct_ti"));
            }
            if (jSONObject.has("int_cl_sw")) {
                bmVar.D(jSONObject.optInt("int_cl_sw"));
            }
            if (jSONObject.has("int_cl_ti")) {
                bmVar.E(jSONObject.optInt("int_cl_ti"));
            }
            if (jSONObject.has("sh_ec")) {
                bmVar.F(jSONObject.optInt("sh_ec"));
            }
            if (jSONObject.has("ap_arpt")) {
                bmVar.G(jSONObject.optInt("ap_arpt"));
            }
            if (jSONObject.has("ap_pasbl")) {
                bmVar.H(jSONObject.optInt("ap_pasbl"));
            }
            if (jSONObject.has(com.anythink.core.common.k.aG)) {
                bmVar.f(jSONObject.optString(com.anythink.core.common.k.aG));
            }
            if (jSONObject.has("shk_sw")) {
                bmVar.I(jSONObject.optInt("shk_sw"));
            }
            if (jSONObject.has("shk_strength_and")) {
                bmVar.J(jSONObject.optInt("shk_strength_and"));
            }
            if (jSONObject.has("shk_time")) {
                bmVar.d(jSONObject.optLong("shk_time"));
            }
            if (jSONObject.has("click_cache_time")) {
                bmVar.K(jSONObject.optInt("click_cache_time"));
            }
            if (jSONObject.has("click_nt_sw")) {
                bmVar.L(jSONObject.optInt("click_nt_sw"));
            }
            if (jSONObject.has("ft_cl_sz")) {
                bmVar.h(jSONObject.optInt("ft_cl_sz"));
            } else {
                bmVar.h(1);
            }
            if (jSONObject.has("sh_cl_itp")) {
                bmVar.i(jSONObject.optInt("sh_cl_itp"));
            } else {
                bmVar.i(2);
            }
            bmVar.M(jSONObject.optInt("shm_t", -1));
            if (jSONObject.has(com.anythink.core.common.f.k.a.d)) {
                bmVar.N(jSONObject.optInt(com.anythink.core.common.f.k.a.d));
            } else {
                bmVar.N(100);
            }
            if (jSONObject.has("rsdl_rate")) {
                bmVar.O(jSONObject.optInt("rsdl_rate"));
            } else {
                bmVar.O(0);
            }
            if (jSONObject.has("video_ctn_type")) {
                bmVar.P(jSONObject.optInt("video_ctn_type"));
            } else {
                bmVar.P(2);
            }
            if (jSONObject.has("preload_offer_html")) {
                bmVar.a(jSONObject.optInt("preload_offer_html") == 1);
            } else {
                bmVar.a(true);
            }
            if (jSONObject.has("re_monitor")) {
                bmVar.b(jSONObject.optInt("re_monitor") == 1);
                i = 0;
            } else {
                i = 0;
                bmVar.b(false);
            }
            bmVar.q = jSONObject.optInt(com.anythink.core.common.k.as, i);
            bmVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
            bmVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
            bmVar.e(jSONObject.optInt("at_cl_ec", 2) == 1);
            bmVar.e(jSONObject.optLong("at_cl_pt", 5000L));
            bmVar.f(jSONObject.optLong("at_cl_pct", 5000L));
            bmVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
            bmVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
            bmVar.i(jSONObject.optLong("or_img_t", 5000L));
            bmVar.R(jSONObject.optInt("animate_type", -1));
            bmVar.Q(jSONObject.optInt("render_wv_ld", 2));
            bmVar.S(jSONObject.optInt("cl_invalid_sw", 2));
            bmVar.T(jSONObject.optInt("stc_sw", 1));
            bmVar.U(jSONObject.optInt("close_button_m", 0));
            bmVar.V(jSONObject.optInt("cgf_sw", 1));
            bmVar.j(jSONObject.optLong("cgf_t", 0L));
            bmVar.g(jSONObject.optString("cgf_list", ""));
            bmVar.h(jSONObject.optString("qa_po", ""));
            bmVar.c(jSONObject.optInt("lp_pop", 2));
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("shk_obj");
                if (jSONObjectOptJSONObject != null) {
                    bmVar.b(jSONObjectOptJSONObject.optInt("shk_type", 3));
                    bmVar.a(jSONObjectOptJSONObject.optString("shk_icon", ""));
                    bmVar.b(jSONObjectOptJSONObject.optString("shk_text_l", ""));
                    bmVar.c(jSONObjectOptJSONObject.optString("shk_text_m", ""));
                    bmVar.d(jSONObjectOptJSONObject.optString("shk_text_s", ""));
                }
            } catch (Throwable unused) {
            }
            bmVar.x(jSONObject.optInt("s_c_t", 0));
            bmVar.Z(jSONObject.optInt("v_cls", 1));
            bmVar.k(jSONObject.optLong("sub_splash_time", 0L));
            bmVar.l(jSONObject.optLong("s_b_t_top", 2000L));
            bmVar.m(jSONObject.optLong("s_b_d_top", 5000L));
            bmVar.ac(jSONObject.optInt("cd_play_sw", 2));
            bmVar.W(jSONObject.optInt("apk_verify", 1));
            bmVar.X(jSONObject.optInt("apk_redown", 2));
            bmVar.Y(jSONObject.optInt("install_bg", 1));
            bmVar.c(jSONObject.optInt("adx_cache_time", BaseConstants.Time.WEEK));
            bmVar.aa(jSONObject.optInt("click_close", 2));
            bmVar.ab(jSONObject.optInt("cta_type", 1));
            bmVar.ad(jSONObject.optInt("a_s_way", 1));
            bmVar.ae(jSONObject.optInt("s_m_t", 800));
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("s_m_a");
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(Double.valueOf(jSONArrayOptJSONArray.getDouble(i2)));
                    }
                } else {
                    arrayList.add(Double.valueOf(15.0d));
                    arrayList.add(Double.valueOf(10.0d));
                }
            } catch (Throwable unused2) {
                arrayList.clear();
                arrayList.add(Double.valueOf(15.0d));
                arrayList.add(Double.valueOf(10.0d));
            }
            bmVar.a(arrayList);
            bmVar.af(jSONObject.optInt("s_s_a", 10));
            bmVar.f(jSONObject.optInt("cta_pause", 2) == 1);
            if (bmVar.J()) {
                bmVar.H(1);
            }
            bmVar.am(jSONObject.optInt("nv_tmpt", -1));
            bmVar.ag(jSONObject.optInt("cta_style", 1));
            try {
                String string = jSONObject.getString("dcta_txt");
                if (!TextUtils.isEmpty(string)) {
                    bmVar.m(new JSONObject(string).optString("lb_txt", ""));
                }
            } catch (Throwable unused3) {
            }
            bmVar.ah(jSONObject.optInt("ec_style", 1));
            int iK = bmVar.K();
            int i3 = iK != 2 ? (iK == 3 || iK == 4) ? 5 : 0 : 3;
            bmVar.n(jSONObject.optInt("ec_cd_n", i3));
            bmVar.ai(jSONObject.optInt("ec_rp_style", 1));
            bmVar.aj(jSONObject.optInt("ec_rp_ca", 0));
            try {
                String string2 = jSONObject.getString("ec_rp_txt");
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject jSONObject2 = new JSONObject(string2);
                    bmVar.i(jSONObject2.optString("rp_t", ""));
                    bmVar.j(jSONObject2.optString("rp_g", ""));
                    bmVar.k(jSONObject2.optString("dl", ""));
                    bmVar.l(jSONObject2.optString(com.byazt.ug.n.n, ""));
                }
            } catch (Throwable unused4) {
            }
            bmVar.o(jSONObject.optInt("sec_cd", i3));
            bmVar.ak(jSONObject.optInt("sec_ca", 1));
            bmVar.al(jSONObject.optInt("ec_wd_ca", 1));
            try {
                String string3 = jSONObject.getString("ec_wd_txt");
                if (!TextUtils.isEmpty(string3)) {
                    JSONObject jSONObject3 = new JSONObject(string3);
                    bmVar.n(jSONObject3.optString("wd_v", ""));
                    bmVar.o(jSONObject3.optString("wd_i", ""));
                    bmVar.p(jSONObject3.optString("wd_c_t", ""));
                    bmVar.q(jSONObject3.optString("wd_c_i", ""));
                    bmVar.r(jSONObject3.optString("wd_c_b_t", ""));
                }
            } catch (Throwable unused5) {
            }
            bmVar.an(jSONObject.optInt("cls_style", 1));
            bmVar.s(jSONObject.optString("cls_style_cw", ""));
            bmVar.q(jSONObject.optLong("v_cd_style", 1L));
            bmVar.p(jSONObject.optLong("rv_reward_tip", 0L));
            bmVar.ao(jSONObject.optInt("wf_dl_sw", 1));
            bmVar.ap(jSONObject.optInt("dp_b_sw", 2));
            bmVar.aq(jSONObject.optInt("ac_b", 1));
            bmVar.ar(jSONObject.optInt("it_cfg_type", 1));
            bmVar.r(jSONObject.optLong("it_cfg_d_t", 5000L));
            bmVar.s(jSONObject.optLong("it_cfg_r_t", 10000L));
            bmVar.t(jSONObject.optLong("it_cfg_h_t", 5000L));
            bmVar.as(jSONObject.optInt("p_a_style", 1));
            bmVar.at(jSONObject.optInt("s_style", 1));
            bmVar.au(jSONObject.optInt("s_cta_style", 1));
            bmVar.av(jSONObject.optInt("ins_m_sw", 1));
            bmVar.a(jSONObject.optDouble("o_c_b", 1.0d));
            bmVar.u(jSONObject.optLong("s_d_t", 50L));
            bmVar.aw(jSONObject.optInt("deeplink_c_sw", 2));
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ic_link_list");
                ArrayList arrayList2 = new ArrayList();
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        arrayList2.add(jSONArrayOptJSONArray2.getString(i4));
                    }
                }
                bmVar.b(arrayList2);
            } catch (Throwable unused6) {
            }
            bmVar.ax(jSONObject.optInt("h5_ad_sw", 2));
            bmVar.az(jSONObject.optInt("h5_n_f", 2));
            bmVar.ay(jSONObject.optInt("h5_ad_pre", 2));
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h5_ad_t");
                if (jSONObjectOptJSONObject2 != null) {
                    bmVar.t(jSONObjectOptJSONObject2.optString("t_url"));
                    bmVar.aA(jSONObjectOptJSONObject2.optInt("id"));
                }
            } catch (Throwable unused7) {
            }
            bmVar.aB(jSONObject.optInt("x_cl", 0));
            bmVar.ab();
            bmVar.aC(jSONObject.optInt("o_h_w_load_sw", 2));
            bmVar.v(jSONObject.optLong("h5_l_l", 5000L));
            bmVar.w(jSONObject.optLong("h5_r_t", 3000L));
            bmVar.aD(jSONObject.optInt("offer_d_c", 1));
            bmVar.aE(jSONObject.optInt("check_w_f", 1));
            bmVar.aF(jSONObject.optInt("s_full", 2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bmVar;
    }
}
