package com.smartdigimkt.b3;

import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends e {
    public int X1;
    public int Y1;
    public int Z1;

    /* JADX WARN: Code duplicated, block: B:205:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:206:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:210:0x070e A[Catch: all -> 0x0750, TryCatch #0 {all -> 0x0750, blocks: (B:208:0x0706, B:210:0x070e, B:212:0x0726, B:218:0x0748, B:214:0x0731, B:216:0x0739, B:217:0x0740), top: B:234:0x0706 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0726 A[Catch: all -> 0x0750, TryCatch #0 {all -> 0x0750, blocks: (B:208:0x0706, B:210:0x070e, B:212:0x0726, B:218:0x0748, B:214:0x0731, B:216:0x0739, B:217:0x0740), top: B:234:0x0706 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x072f  */
    /* JADX WARN: Code duplicated, block: B:217:0x0740 A[Catch: all -> 0x0750, TryCatch #0 {all -> 0x0750, blocks: (B:208:0x0706, B:210:0x070e, B:212:0x0726, B:218:0x0748, B:214:0x0731, B:216:0x0739, B:217:0x0740), top: B:234:0x0706 }] */
    public static m a(JSONObject jSONObject) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        JSONObject jSONObjectOptJSONObject;
        d dVar;
        Object objOpt;
        m mVar = new m();
        if (jSONObject == null) {
            return mVar;
        }
        try {
            mVar.a = jSONObject.optInt("f_t");
            int iOptInt = jSONObject.optInt("v_c");
            if (iOptInt == 1) {
                iOptInt = 0;
            } else if (iOptInt == 2) {
                iOptInt = 1;
            }
            mVar.b = iOptInt;
            mVar.c = jSONObject.optInt("s_b_t");
            if (jSONObject.has("s_b_d")) {
                mVar.d = jSONObject.optInt("s_b_d");
            }
            int iOptInt2 = jSONObject.optInt("e_c_a");
            if (iOptInt2 == 1) {
                iOptInt2 = 0;
            } else if (iOptInt2 == 2) {
                iOptInt2 = 1;
            } else if (iOptInt2 == 3) {
                iOptInt2 = 2;
            }
            mVar.e = iOptInt2;
            int iOptInt3 = jSONObject.optInt("ak_cfm");
            if (iOptInt3 == 1) {
                iOptInt3 = 0;
            } else if (iOptInt3 == 2) {
                iOptInt3 = 1;
            }
            mVar.h = iOptInt3;
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ak_cfm_c");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    int i3 = 0;
                    while (i3 < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i3);
                        int iOptInt4 = jSONObject2.optInt("link_type");
                        JSONArray jSONArray = jSONArrayOptJSONArray;
                        int iOptInt5 = jSONObject2.optInt("scene");
                        if (iOptInt4 == 4) {
                            mVar.b(iOptInt5);
                        }
                        if (iOptInt4 == 1) {
                            mVar.u(iOptInt5);
                        }
                        i3++;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                }
            } catch (Throwable unused) {
            }
            mVar.p = jSONObject.optInt("m_t");
            int iOptInt6 = jSONObject.optInt("cm");
            if (iOptInt6 == 1) {
                iOptInt6 = 0;
            } else if (iOptInt6 == 2) {
                iOptInt6 = 1;
            }
            mVar.L(iOptInt6);
            mVar.E = jSONObject.optInt("ipua");
            mVar.F = jSONObject.optInt("clua");
            mVar.k(jSONObject.optInt("dp_cm"));
            mVar.M(jSONObject.optInt("l_o_num"));
            mVar.t(jSONObject.optInt("ld_t"));
            mVar.t = jSONObject.optInt("ec_r");
            mVar.u = jSONObject.optInt("ec_s_t");
            mVar.v = jSONObject.optInt("ec_l_t");
            mVar.x = jSONObject.optLong("or_t");
            mVar.y = jSONObject.optInt("rv_fail_reward");
            mVar.z = jSONObject.optInt("cl_sz");
            mVar.A = jSONObject.optInt("si_fit");
            if (jSONObject.has("at_cl_sw")) {
                jSONObject.optInt("at_cl_sw");
            }
            if (jSONObject.has("at_ct_ti")) {
                jSONObject.optInt("at_ct_ti");
            }
            if (jSONObject.has("int_cl_sw")) {
                mVar.B = jSONObject.optInt("int_cl_sw");
            }
            if (jSONObject.has("int_cl_ti")) {
                mVar.C = jSONObject.optInt("int_cl_ti");
            }
            if (jSONObject.has("sh_ec")) {
                mVar.D = jSONObject.optInt("sh_ec");
            }
            if (jSONObject.has("ap_arpt")) {
                mVar.G = jSONObject.optInt("ap_arpt");
            }
            if (jSONObject.has("ap_pasbl")) {
                mVar.H = jSONObject.optInt("ap_pasbl");
            }
            if (jSONObject.has(com.anythink.core.common.k.aG)) {
                mVar.w = jSONObject.optString(com.anythink.core.common.k.aG);
            }
            if (jSONObject.has("shk_sw")) {
                mVar.K = jSONObject.optInt("shk_sw");
            }
            if (jSONObject.has("shk_strength_and")) {
                mVar.L = jSONObject.optInt("shk_strength_and");
            }
            if (jSONObject.has("c_dp_i")) {
                mVar.M = jSONObject.optInt("c_dp_i");
            } else {
                mVar.M = 2;
            }
            if (jSONObject.has("click_cache_time")) {
                mVar.N = jSONObject.optInt("click_cache_time");
            }
            if (jSONObject.has("click_nt_sw")) {
                mVar.O = jSONObject.optInt("click_nt_sw");
            }
            if (jSONObject.has("ft_cl_sz")) {
                mVar.P = jSONObject.optInt("ft_cl_sz");
            } else {
                mVar.P = 1;
            }
            if (jSONObject.has("sh_cl_itp")) {
                mVar.Q = jSONObject.optInt("sh_cl_itp");
            } else {
                mVar.Q = 2;
            }
            mVar.R = jSONObject.optInt("shm_t", -1);
            if (jSONObject.has(com.anythink.core.common.f.k.a.d)) {
                mVar.S = jSONObject.optInt(com.anythink.core.common.f.k.a.d);
            } else {
                mVar.S = 100;
            }
            if (jSONObject.has("rsdl_rate")) {
                mVar.T = jSONObject.optInt("rsdl_rate");
            } else {
                mVar.T = 0;
            }
            if (jSONObject.has("video_ctn_type")) {
                mVar.U = jSONObject.optInt("video_ctn_type");
            } else {
                mVar.U = 2;
            }
            if (jSONObject.has("a_m_l_t")) {
                mVar.V = jSONObject.optInt("a_m_l_t");
            } else {
                mVar.V = 2;
            }
            if (jSONObject.has("c_t_a_r")) {
                mVar.W = jSONObject.optInt("c_t_a_r", 1);
                i = 1;
            } else {
                i = 1;
                mVar.W = 1;
            }
            if (jSONObject.has("s_t_a_r")) {
                mVar.X = jSONObject.optInt("s_t_a_r", i);
            } else {
                mVar.X = i;
            }
            if (jSONObject.has("i_a_b_r_l")) {
                mVar.Y = jSONObject.optInt("i_a_b_r_l", 0);
            } else {
                mVar.Y = 0;
            }
            if (jSONObject.has("re_monitor")) {
                mVar.Z = jSONObject.optInt("re_monitor") == 1;
                i2 = 0;
            } else {
                i2 = 0;
                mVar.Z = false;
            }
            mVar.N(jSONObject.optInt(com.anythink.core.common.k.as, i2));
            mVar.a0 = jSONObject.optInt("at_cl_img", 2) == 1;
            mVar.b0 = jSONObject.optInt("at_cl_video", 2) == 1;
            mVar.c0 = jSONObject.optInt("at_cl_ec", 2) == 1;
            mVar.d0 = jSONObject.optLong("at_cl_pt", 5000L);
            mVar.e0 = jSONObject.optLong("at_cl_pct", 5000L);
            mVar.f0 = jSONObject.optLong("at_cl_ec_pt", 5000L);
            mVar.g0 = jSONObject.optLong("at_cl_ec_pct", 5000L);
            mVar.j(jSONObject.optLong("or_img_t", 5000L));
            mVar.A(jSONObject.optInt("animate_type", -1));
            mVar.B(jSONObject.optInt("render_wv_ld", 2));
            mVar.f(jSONObject.optInt("cl_invalid_sw", 2));
            mVar.l0 = jSONObject.optInt("stc_sw", 1);
            mVar.m0 = jSONObject.optInt("close_button_m", 0);
            mVar.n0 = jSONObject.optInt("cgf_sw", 1);
            mVar.a(jSONObject.optLong("cgf_t", 0L));
            mVar.a(jSONObject.optString("cgf_list", ""));
            mVar.b(jSONObject.optString("qa_po", ""));
            mVar.K(jSONObject.optInt("lp_pop", 2));
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("shk_obj");
                if (jSONObjectOptJSONObject2 != null) {
                    mVar.D(jSONObjectOptJSONObject2.optInt("shk_type", 3));
                    mVar.o(jSONObjectOptJSONObject2.optString("shk_icon", ""));
                    mVar.p(jSONObjectOptJSONObject2.optString("shk_text_l", ""));
                    mVar.q(jSONObjectOptJSONObject2.optString("shk_text_m", ""));
                    mVar.r(jSONObjectOptJSONObject2.optString("shk_text_s", ""));
                }
            } catch (Throwable unused2) {
            }
            mVar.g = jSONObject.optInt("s_c_t", 0);
            mVar.w(jSONObject.optInt("v_cls", 1));
            mVar.B0 = jSONObject.optLong("sub_splash_time", 0L);
            mVar.C0 = jSONObject.optLong("s_b_t_top", 2000L);
            mVar.D0 = jSONObject.optLong("s_b_d_top", 5000L);
            mVar.E0 = jSONObject.optInt("cd_play_sw", 2);
            mVar.w0 = jSONObject.optInt(com.smartdigimkt.r4.o.a, 1);
            mVar.x0 = jSONObject.optInt(com.smartdigimkt.r4.o.b, 2);
            mVar.y0 = jSONObject.optInt(com.smartdigimkt.r4.o.c, 1);
            mVar.A0 = jSONObject.optInt("click_close", 2);
            mVar.z0 = jSONObject.optInt("cta_type", 1);
            mVar.a(jSONObject.optInt("cta_pause", 2) == 1);
            if (mVar.H0) {
                mVar.H = 1;
            }
            mVar.F0 = jSONObject.optInt("nv_tmpt", -1);
            mVar.h(jSONObject.optInt("cta_style", 1));
            try {
                String string = jSONObject.getString("dcta_txt");
                if (!TextUtils.isEmpty(string)) {
                    mVar.c(new JSONObject(string).optString("lb_txt", ""));
                }
            } catch (Throwable unused3) {
            }
            int iOptInt7 = jSONObject.optInt("ec_style", 1);
            mVar.K0 = iOptInt7;
            int i4 = iOptInt7 != 2 ? (iOptInt7 == 3 || iOptInt7 == 4) ? 5 : 0 : 3;
            mVar.c(jSONObject.optInt("ec_cd_n", i4));
            mVar.z(jSONObject.optInt("ec_rp_style", 1));
            mVar.y(jSONObject.optInt("ec_rp_ca", 0));
            try {
                String string2 = jSONObject.getString("ec_rp_txt");
                if (!TextUtils.isEmpty(string2)) {
                    JSONObject jSONObject3 = new JSONObject(string2);
                    mVar.j(jSONObject3.optString("rp_t", ""));
                    mVar.g(jSONObject3.optString("rp_g", ""));
                    mVar.h(jSONObject3.optString("dl", ""));
                    mVar.i(jSONObject3.optString(com.byazt.ug.n.n, ""));
                }
            } catch (Throwable unused4) {
            }
            mVar.k(jSONObject.optInt("sec_cd", i4));
            mVar.C(jSONObject.optInt("sec_ca", 1));
            mVar.x(jSONObject.optInt("ec_wd_ca", 1));
            try {
                String string3 = jSONObject.getString("ec_wd_txt");
                if (!TextUtils.isEmpty(string3)) {
                    JSONObject jSONObject4 = new JSONObject(string3);
                    mVar.f(jSONObject4.optString("wd_v", ""));
                    mVar.l(jSONObject4.optString("wd_i", ""));
                    mVar.n(jSONObject4.optString("wd_c_t", ""));
                    mVar.m(jSONObject4.optString("wd_c_i", ""));
                    mVar.k(jSONObject4.optString("wd_c_b_t", ""));
                }
            } catch (Throwable unused5) {
            }
            mVar.c1 = jSONObject.optInt("cls_style", 1);
            mVar.s(jSONObject.optString("cls_style_cw", ""));
            mVar.b(jSONObject.optLong("v_cd_style", 1L));
            mVar.i(jSONObject.optLong("rv_reward_tip", 0L));
            jSONObject.optInt("wf_dl_sw", 1);
            mVar.i(jSONObject.optInt("dp_b_sw", 2));
            mVar.f1 = jSONObject.optInt("it_cfg_type", 1);
            mVar.g(jSONObject.optLong("it_cfg_d_t", 5000L));
            mVar.h(jSONObject.optLong("it_cfg_r_t", 10000L));
            mVar.f(jSONObject.optLong("it_cfg_h_t", 5000L));
            mVar.a(jSONObject.optInt("p_a_style", 1));
            mVar.d(jSONObject.optInt("s_style", 1));
            mVar.E(jSONObject.optInt("s_cta_style", 1));
            mVar.c(jSONObject.optInt("ins_m_sw", 1));
            mVar.v(jSONObject.optInt("perm_sup_sw", 1));
            mVar.a(jSONObject.optDouble("o_c_b", 1.0d));
            mVar.j(jSONObject.optInt("deeplink_c_sw", 2));
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ic_link_list");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                        arrayList.add(jSONArrayOptJSONArray2.getString(i5));
                    }
                }
                mVar.a(arrayList);
            } catch (Throwable unused6) {
            }
            mVar.p(jSONObject.optInt("h5_ad_sw", 2));
            mVar.q(jSONObject.optInt("h5_n_f", 2));
            mVar.n(jSONObject.optInt("h5_ad_pre", 2));
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("h5_ad_t");
                if (jSONObjectOptJSONObject3 != null) {
                    mVar.e(jSONObjectOptJSONObject3.optString("t_url"));
                    mVar.m(jSONObjectOptJSONObject3.optInt("id"));
                    mVar.d(jSONObjectOptJSONObject3.optString("settings"));
                }
            } catch (Throwable unused7) {
            }
            mVar.l(jSONObject.optInt("x_cl", 0));
            mVar.B1 = 1;
            mVar.d(jSONObject.optLong("h5_l_l", 5000L));
            mVar.e(jSONObject.optLong("h5_r_t", 3000L));
            mVar.g(jSONObject.optInt("offer_d_c", 1));
            mVar.J(jSONObject.optInt("check_w_f", 1));
            mVar.r(jSONObject.optInt("s_full", 2));
            mVar.H(jSONObject.optInt("dps_tk_up", 2));
            StringBuilder sb = new StringBuilder();
            String str = com.smartdigimkt.r4.o.g;
            mVar.q = jSONObject.optInt(sb.append(str).append("_o_m_e").toString(), BaseConstants.Time.DAY);
            mVar.I(jSONObject.optInt(str + "_i_c_u", 2));
            mVar.e(jSONObject.optInt("b_dp_i", 2));
            mVar.o(jSONObject.optInt("h5_pre_l_c", 2));
            try {
                try {
                    JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("interaction");
                    if (jSONObjectOptJSONObject4 != null) {
                        z = false;
                        try {
                            mVar.s(jSONObjectOptJSONObject4.optInt("interaction_type", 0));
                            z2 = true;
                            try {
                                mVar.G(jSONObjectOptJSONObject4.optInt("swipe_type", 1));
                                mVar.F(jSONObjectOptJSONObject4.optInt("swipe_n", 10));
                                mVar.a((float) jSONObjectOptJSONObject4.optDouble("degree_x", 30.0d));
                                mVar.b((float) jSONObjectOptJSONObject4.optDouble("degree_y", 30.0d));
                                mVar.c((float) jSONObjectOptJSONObject4.optDouble("degree_z", 30.0d));
                            } catch (Throwable unused8) {
                            }
                        } catch (Throwable unused9) {
                            z2 = true;
                        }
                        mVar.a(u.a(jSONObject));
                        if (jSONObject.optJSONObject("interaction") != null) {
                            z3 = z2;
                        } else {
                            z3 = z;
                        }
                        mVar.b(z3);
                        a(mVar, jSONObject);
                        jSONObjectOptJSONObject = jSONObject.optJSONObject("interaction_t");
                        if (jSONObjectOptJSONObject != null) {
                            dVar = new d();
                            dVar.a(jSONObjectOptJSONObject.optLong("id", 0L));
                            objOpt = jSONObjectOptJSONObject.opt("ext");
                            if (objOpt instanceof JSONObject) {
                                dVar.b = ((JSONObject) objOpt).toString();
                            } else if (objOpt != null || JSONObject.NULL.equals(objOpt)) {
                                dVar.b = jSONObjectOptJSONObject.optString("ext", "");
                            } else {
                                dVar.b = String.valueOf(objOpt);
                            }
                            mVar.a(dVar);
                        }
                        return mVar;
                    }
                    z = false;
                } catch (Throwable unused10) {
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("interaction_t");
                if (jSONObjectOptJSONObject != null) {
                    dVar = new d();
                    dVar.a(jSONObjectOptJSONObject.optLong("id", 0L));
                    objOpt = jSONObjectOptJSONObject.opt("ext");
                    if (objOpt instanceof JSONObject) {
                        dVar.b = ((JSONObject) objOpt).toString();
                    } else if (objOpt != null) {
                        dVar.b = jSONObjectOptJSONObject.optString("ext", "");
                    } else {
                        dVar.b = jSONObjectOptJSONObject.optString("ext", "");
                    }
                    mVar.a(dVar);
                }
            } catch (Throwable unused11) {
            }
            z2 = true;
            mVar.a(u.a(jSONObject));
            if (jSONObject.optJSONObject("interaction") != null) {
                z3 = z2;
            } else {
                z3 = z;
            }
            mVar.b(z3);
            a(mVar, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mVar;
    }

    public final void L(int i) {
        this.X1 = i;
    }

    public final void M(int i) {
        this.Y1 = i;
    }

    public final void N(int i) {
        this.Z1 = i;
    }

    public static void a(m mVar, JSONObject jSONObject) {
        if (mVar.P1) {
            return;
        }
        mVar.K1 = jSONObject.optInt("a_s_way", 1);
        mVar.L1 = jSONObject.optInt("s_m_t", 800);
        mVar.N1 = jSONObject.optInt("s_s_a", 10);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("s_m_a");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                double dOptDouble = jSONArrayOptJSONArray.optDouble(i, Double.NaN);
                if (Double.isNaN(dOptDouble)) {
                    jSONArrayOptJSONArray = null;
                    break;
                }
                arrayList.add(Double.valueOf(dOptDouble));
            }
        }
        if (jSONArrayOptJSONArray == null) {
            arrayList.clear();
            arrayList.add(Double.valueOf(15.0d));
            arrayList.add(Double.valueOf(10.0d));
        }
        mVar.M1 = arrayList;
    }
}
