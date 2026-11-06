package com.smartdigimkt.e3;

import android.text.TextUtils;
import com.anythink.core.common.k;
import com.byazt.ho.BaseConstants;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.r4.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {
    public int X1;

    public static b t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a = jSONObject.optInt("f_t");
            bVar.b = jSONObject.optInt("v_c");
            bVar.c = jSONObject.optInt("s_b_t");
            bVar.e = jSONObject.optInt("e_c_a");
            bVar.f = jSONObject.optInt("v_m");
            bVar.g = jSONObject.optInt("s_c_t");
            bVar.p = jSONObject.optInt("m_t");
            bVar.q = jSONObject.optLong("o_c_t", 86400000L);
            bVar.h = jSONObject.optInt("ak_cfm");
            bVar.l = jSONObject.optLong("ctdown_time");
            bVar.k = jSONObject.optInt("sk_able");
            bVar.m = jSONObject.optInt("orient");
            bVar.n = jSONObject.optString("size");
            bVar.o = jSONObject.optInt("cl_btn");
            bVar.t = jSONObject.optInt("ec_r");
            bVar.u = jSONObject.optInt("ec_s_t");
            bVar.v = jSONObject.optInt("ec_l_t");
            bVar.w = jSONObject.optString(k.aG);
            bVar.X1 = jSONObject.optInt("spl_type");
            bVar.x = jSONObject.optLong("or_t");
            bVar.y = jSONObject.optInt("rv_fail_reward");
            bVar.z = jSONObject.optInt("cl_sz");
            bVar.A = jSONObject.optInt("si_fit");
            if (jSONObject.has("at_cl_sw")) {
                jSONObject.optInt("at_cl_sw");
            }
            if (jSONObject.has("at_ct_ti")) {
                jSONObject.optInt("at_ct_ti");
            }
            if (jSONObject.has("int_cl_sw")) {
                bVar.B = jSONObject.optInt("int_cl_sw");
            }
            if (jSONObject.has("int_cl_ti")) {
                bVar.C = jSONObject.optInt("int_cl_ti");
            }
            if (jSONObject.has("sh_ec")) {
                bVar.D = jSONObject.optInt("sh_ec");
            }
            if (jSONObject.has("ipua")) {
                bVar.E = jSONObject.optInt("ipua");
            }
            if (jSONObject.has("clua")) {
                bVar.F = jSONObject.optInt("clua");
            }
            if (jSONObject.has("ap_arpt")) {
                bVar.G = jSONObject.optInt("ap_arpt");
            }
            if (jSONObject.has("ap_pasbl")) {
                bVar.H = jSONObject.optInt("ap_pasbl");
            }
            if (jSONObject.has("shk_sw")) {
                bVar.K = jSONObject.optInt("shk_sw");
            }
            if (jSONObject.has("shk_strength_and")) {
                bVar.L = jSONObject.optInt("shk_strength_and");
            }
            if (jSONObject.has("click_cache_time")) {
                bVar.N = jSONObject.optInt("click_cache_time");
            } else {
                bVar.N = BaseConstants.Time.HOUR;
            }
            if (jSONObject.has("click_nt_sw")) {
                bVar.O = jSONObject.optInt("click_nt_sw");
            } else {
                bVar.O = 1;
            }
            if (jSONObject.has("ft_cl_sz")) {
                bVar.P = jSONObject.optInt("ft_cl_sz");
            } else {
                bVar.P = 1;
            }
            if (jSONObject.has("sh_cl_itp")) {
                bVar.Q = jSONObject.optInt("sh_cl_itp");
            } else {
                bVar.Q = 2;
            }
            bVar.R = jSONObject.optInt("shm_t", -1);
            if (jSONObject.has(com.anythink.core.common.f.k.a.d)) {
                bVar.S = jSONObject.optInt(com.anythink.core.common.f.k.a.d);
            } else {
                bVar.S = 100;
            }
            if (jSONObject.has("rsdl_rate")) {
                bVar.T = jSONObject.optInt("rsdl_rate");
            } else {
                bVar.T = 0;
            }
            if (jSONObject.has("video_ctn_type")) {
                bVar.U = jSONObject.optInt("video_ctn_type");
            } else {
                bVar.U = 2;
            }
            bVar.a0 = jSONObject.optInt("at_cl_img", 2) == 1;
            bVar.b0 = jSONObject.optInt("at_cl_video", 2) == 1;
            bVar.c0 = jSONObject.optInt("at_cl_ec", 2) == 1;
            bVar.d0 = jSONObject.optLong("at_cl_pt", 5000L);
            bVar.e0 = jSONObject.optLong("at_cl_pct", 5000L);
            bVar.f0 = jSONObject.optLong("at_cl_ec_pt", 5000L);
            bVar.g0 = jSONObject.optLong("at_cl_ec_pct", 5000L);
            bVar.B0 = jSONObject.optLong("sub_splash_time", 0L);
            bVar.C0 = jSONObject.optLong("s_b_t_top", 2000L);
            bVar.D0 = jSONObject.optLong("s_b_d_top", 5000L);
            bVar.w0 = jSONObject.optInt(o.a, 1);
            bVar.x0 = jSONObject.optInt(o.b, 2);
            bVar.y0 = jSONObject.optInt(o.c, 1);
            bVar.A0 = jSONObject.optInt("click_close", 2);
            bVar.z0 = jSONObject.optInt("cta_type", 1);
            bVar.E0 = jSONObject.optInt("cd_play_sw", 2);
            bVar.K1 = 2;
            int i = bVar.L;
            if (i <= 0) {
                i = 10;
            }
            bVar.N1 = i;
            return bVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return bVar;
        }
    }
}
