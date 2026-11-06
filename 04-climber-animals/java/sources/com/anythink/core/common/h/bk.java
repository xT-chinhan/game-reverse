package com.anythink.core.common.h;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bk extends y {
    private int o;
    private int p;
    private int q;

    public final int a() {
        return this.p;
    }

    private void aI(int i) {
        this.p = i;
    }

    public final int b() {
        return this.o;
    }

    private void aJ(int i) {
        this.o = i;
    }

    public final int c() {
        return this.q;
    }

    private void aK(int i) {
        this.q = i;
    }

    public static bk u(String str) {
        int i;
        bk bkVar = new bk();
        if (TextUtils.isEmpty(str)) {
            return bkVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bkVar.s(jSONObject.optInt("f_t"));
            int iOptInt = jSONObject.optInt("v_c");
            if (iOptInt == 1) {
                iOptInt = 0;
            } else if (iOptInt == 2) {
                iOptInt = 1;
            }
            bkVar.t(iOptInt);
            bkVar.u(jSONObject.optInt("s_b_t"));
            if (jSONObject.has("s_b_d")) {
                bkVar.v(jSONObject.optInt("s_b_d"));
            }
            int iOptInt2 = jSONObject.optInt("e_c_a");
            if (iOptInt2 == 1) {
                iOptInt2 = 0;
            } else if (iOptInt2 == 2) {
                iOptInt2 = 1;
            } else if (iOptInt2 == 3) {
                iOptInt2 = 2;
            }
            bkVar.w(iOptInt2);
            int iOptInt3 = jSONObject.optInt("ak_cfm");
            if (iOptInt3 == 1) {
                iOptInt3 = 0;
            } else if (iOptInt3 == 2) {
                iOptInt3 = 1;
            }
            bkVar.o(iOptInt3);
            bkVar.n(jSONObject.optInt("m_t"));
            int iOptInt4 = jSONObject.optInt("cm");
            if (iOptInt4 == 1) {
                iOptInt4 = 0;
            } else if (iOptInt4 == 2) {
                iOptInt4 = 1;
            }
            bkVar.o = iOptInt4;
            bkVar.e(jSONObject.optInt("ipua"));
            bkVar.f(jSONObject.optInt("clua"));
            bkVar.m(jSONObject.optInt("dp_cm"));
            bkVar.p = jSONObject.optInt("l_o_num");
            bkVar.l(jSONObject.optInt("ld_t"));
            bkVar.z(jSONObject.optInt("ec_r"));
            bkVar.A(jSONObject.optInt("ec_s_t"));
            bkVar.B(jSONObject.optInt("ec_l_t"));
            bkVar.a(jSONObject.optLong("or_t"));
            bkVar.g(jSONObject.optInt("rv_fail_reward"));
            bkVar.h(jSONObject.optInt("cl_sz"));
            bkVar.k(jSONObject.optInt("si_fit"));
            if (jSONObject.has("at_cl_sw")) {
                bkVar.C(jSONObject.optInt("at_cl_sw"));
            }
            if (jSONObject.has("at_ct_ti")) {
                bkVar.D(jSONObject.optInt("at_ct_ti"));
            }
            if (jSONObject.has("int_cl_sw")) {
                bkVar.E(jSONObject.optInt("int_cl_sw"));
            }
            if (jSONObject.has("int_cl_ti")) {
                bkVar.F(jSONObject.optInt("int_cl_ti"));
            }
            if (jSONObject.has("sh_ec")) {
                bkVar.G(jSONObject.optInt("sh_ec"));
            }
            if (jSONObject.has("ap_arpt")) {
                bkVar.H(jSONObject.optInt("ap_arpt"));
            }
            if (jSONObject.has("ap_pasbl")) {
                bkVar.I(jSONObject.optInt("ap_pasbl"));
            }
            if (jSONObject.has(com.anythink.core.common.k.aF)) {
                bkVar.f(jSONObject.optString(com.anythink.core.common.k.aF));
            }
            if (jSONObject.has("shk_sw")) {
                bkVar.J(jSONObject.optInt("shk_sw"));
            }
            if (jSONObject.has("shk_strength_and")) {
                bkVar.K(jSONObject.optInt("shk_strength_and"));
            }
            if (jSONObject.has("shk_time")) {
                bkVar.d(jSONObject.optLong("shk_time"));
            }
            if (jSONObject.has("click_cache_time")) {
                bkVar.L(jSONObject.optInt("click_cache_time"));
            }
            if (jSONObject.has("click_nt_sw")) {
                bkVar.M(jSONObject.optInt("click_nt_sw"));
            }
            if (jSONObject.has("ft_cl_sz")) {
                bkVar.i(jSONObject.optInt("ft_cl_sz"));
            } else {
                bkVar.i(1);
            }
            if (jSONObject.has("sh_cl_itp")) {
                bkVar.j(jSONObject.optInt("sh_cl_itp"));
            } else {
                bkVar.j(2);
            }
            bkVar.N(jSONObject.optInt("shm_t", -1));
            if (jSONObject.has(com.anythink.core.common.e.q.a.d)) {
                bkVar.O(jSONObject.optInt(com.anythink.core.common.e.q.a.d));
            } else {
                bkVar.O(100);
            }
            if (jSONObject.has("rsdl_rate")) {
                bkVar.P(jSONObject.optInt("rsdl_rate"));
            } else {
                bkVar.P(0);
            }
            if (jSONObject.has("video_ctn_type")) {
                bkVar.Q(jSONObject.optInt("video_ctn_type"));
            } else {
                bkVar.Q(2);
            }
            if (jSONObject.has("preload_offer_html")) {
                bkVar.a(jSONObject.optInt("preload_offer_html") == 1);
            } else {
                bkVar.a(true);
            }
            if (jSONObject.has("re_monitor")) {
                bkVar.b(jSONObject.optInt("re_monitor") == 1);
                i = 0;
            } else {
                i = 0;
                bkVar.b(false);
            }
            bkVar.q = jSONObject.optInt(com.anythink.core.common.k.ar, i);
            bkVar.c(jSONObject.optInt("at_cl_img", 2) == 1);
            bkVar.d(jSONObject.optInt("at_cl_video", 2) == 1);
            bkVar.e(jSONObject.optInt("at_cl_ec", 2) == 1);
            bkVar.e(jSONObject.optLong("at_cl_pt", 5000L));
            bkVar.f(jSONObject.optLong("at_cl_pct", 5000L));
            bkVar.g(jSONObject.optLong("at_cl_ec_pt", 5000L));
            bkVar.h(jSONObject.optLong("at_cl_ec_pct", 5000L));
            bkVar.i(jSONObject.optLong("or_img_t", 5000L));
            bkVar.S(jSONObject.optInt("animate_type", -1));
            bkVar.R(jSONObject.optInt("render_wv_ld", 2));
            bkVar.T(jSONObject.optInt("cl_invalid_sw", 2));
            bkVar.U(jSONObject.optInt("stc_sw", 1));
            bkVar.V(jSONObject.optInt("close_button_m", 0));
            bkVar.W(jSONObject.optInt("cgf_sw", 1));
            bkVar.j(jSONObject.optLong("cgf_t", 0L));
            bkVar.g(jSONObject.optString("cgf_list", ""));
            bkVar.h(jSONObject.optString("qa_po", ""));
            bkVar.b(jSONObject.optInt("lp_pop", 2));
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("shk_obj");
                if (jSONObjectOptJSONObject != null) {
                    bkVar.a(jSONObjectOptJSONObject.optInt("shk_type", 3));
                    bkVar.a(jSONObjectOptJSONObject.optString("shk_icon", ""));
                    bkVar.b(jSONObjectOptJSONObject.optString("shk_text_l", ""));
                    bkVar.c(jSONObjectOptJSONObject.optString("shk_text_m", ""));
                    bkVar.d(jSONObjectOptJSONObject.optString("shk_text_s", ""));
                }
            } catch (Throwable unused) {
            }
            bkVar.y(jSONObject.optInt("s_c_t", 0));
            bkVar.aa(jSONObject.optInt("v_cls", 1));
            bkVar.k(jSONObject.optLong("sub_splash_time", 0L));
            bkVar.l(jSONObject.optLong("s_b_t_top", com.anythink.basead.exoplayer.i.a.f));
            bkVar.m(jSONObject.optLong("s_b_d_top", 5000L));
            bkVar.ad(jSONObject.optInt("cd_play_sw", 2));
            bkVar.X(jSONObject.optInt(com.anythink.core.common.e.g.a.j, 1));
            bkVar.Y(jSONObject.optInt("apk_redown", 2));
            bkVar.Z(jSONObject.optInt("install_bg", 1));
            bkVar.c(jSONObject.optInt("adx_cache_time", 604800000));
            bkVar.ab(jSONObject.optInt("click_close", 2));
            bkVar.ac(jSONObject.optInt("cta_type", 1));
            bkVar.ae(jSONObject.optInt("a_s_way", 1));
            bkVar.af(jSONObject.optInt("s_m_t", 800));
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
            bkVar.a(arrayList);
            bkVar.ag(jSONObject.optInt("s_s_a", 10));
            bkVar.g(jSONObject.optInt("cta_pause", 2) == 1);
            if (bkVar.aM()) {
                bkVar.I(1);
            }
            bkVar.an(jSONObject.optInt("nv_tmpt", -1));
            bkVar.ah(jSONObject.optInt("cta_style", 1));
            try {
                String string = jSONObject.getString("dcta_txt");
                if (!TextUtils.isEmpty(string)) {
                    bkVar.m(new JSONObject(string).optString("lb_txt", ""));
                }
            } catch (Throwable unused3) {
            }
            bkVar.ai(jSONObject.optInt("ec_style", 1));
            int iAO = bkVar.aO();
            int i3 = iAO != 2 ? (iAO == 3 || iAO == 4) ? 5 : 0 : 3;
            bkVar.n(jSONObject.optInt("ec_cd_n", i3));
            bkVar.aj(jSONObject.optInt("ec_rp_style", 1));
            bkVar.ak(jSONObject.optInt("ec_rp_ca", 0));
            try {
                String string2 = jSONObject.getString("ec_rp_txt");
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject jSONObject2 = new JSONObject(string2);
                    bkVar.i(jSONObject2.optString("rp_t", ""));
                    bkVar.j(jSONObject2.optString("rp_g", ""));
                    bkVar.k(jSONObject2.optString("dl", ""));
                    bkVar.l(jSONObject2.optString("n", ""));
                }
            } catch (Throwable unused4) {
            }
            bkVar.o(jSONObject.optInt("sec_cd", i3));
            bkVar.al(jSONObject.optInt("sec_ca", 1));
            bkVar.am(jSONObject.optInt("ec_wd_ca", 1));
            try {
                String string3 = jSONObject.getString("ec_wd_txt");
                if (!TextUtils.isEmpty(string3)) {
                    JSONObject jSONObject3 = new JSONObject(string3);
                    bkVar.n(jSONObject3.optString("wd_v", ""));
                    bkVar.o(jSONObject3.optString("wd_i", ""));
                    bkVar.p(jSONObject3.optString("wd_c_t", ""));
                    bkVar.q(jSONObject3.optString("wd_c_i", ""));
                    bkVar.r(jSONObject3.optString("wd_c_b_t", ""));
                }
            } catch (Throwable unused5) {
            }
            bkVar.ao(jSONObject.optInt("cls_style", 1));
            bkVar.s(jSONObject.optString("cls_style_cw", ""));
            bkVar.q(jSONObject.optLong("v_cd_style", 1L));
            bkVar.p(jSONObject.optLong("rv_reward_tip", 0L));
            bkVar.ap(jSONObject.optInt("wf_dl_sw", 1));
            bkVar.aq(jSONObject.optInt("dp_b_sw", 2));
            bkVar.ar(jSONObject.optInt("ac_b", 1));
            bkVar.as(jSONObject.optInt("it_cfg_type", 1));
            bkVar.r(jSONObject.optLong("it_cfg_d_t", 5000L));
            bkVar.s(jSONObject.optLong("it_cfg_r_t", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
            bkVar.t(jSONObject.optLong("it_cfg_h_t", 5000L));
            bkVar.at(jSONObject.optInt("p_a_style", 1));
            bkVar.au(jSONObject.optInt("s_style", 1));
            bkVar.av(jSONObject.optInt("s_cta_style", 1));
            bkVar.aw(jSONObject.optInt("ins_m_sw", 1));
            bkVar.a(jSONObject.optDouble("o_c_b", 1.0d));
            bkVar.u(jSONObject.optLong("s_d_t", 50L));
            bkVar.ax(jSONObject.optInt("deeplink_c_sw", 2));
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ic_link_list");
                ArrayList arrayList2 = new ArrayList();
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        arrayList2.add(jSONArrayOptJSONArray2.getString(i4));
                    }
                }
                bkVar.b(arrayList2);
            } catch (Throwable unused6) {
            }
            bkVar.ay(jSONObject.optInt("h5_ad_sw", 2));
            bkVar.aA(jSONObject.optInt("h5_n_f", 2));
            bkVar.az(jSONObject.optInt("h5_ad_pre", 2));
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h5_ad_t");
                if (jSONObjectOptJSONObject2 != null) {
                    bkVar.t(jSONObjectOptJSONObject2.optString("t_url"));
                    bkVar.aB(jSONObjectOptJSONObject2.optInt("id"));
                }
            } catch (Throwable unused7) {
            }
            bkVar.aC(jSONObject.optInt("x_cl", 0));
            bkVar.aD(1);
            bkVar.aE(jSONObject.optInt("o_h_w_load_sw", 2));
            bkVar.v(jSONObject.optLong("h5_l_l", 5000L));
            bkVar.w(jSONObject.optLong("h5_r_t", com.tapsdk.tapad.e.a.f));
            bkVar.aF(jSONObject.optInt("offer_d_c", 1));
            bkVar.aG(jSONObject.optInt("check_w_f", 1));
            bkVar.aH(jSONObject.optInt("s_full", 2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bkVar;
    }
}
