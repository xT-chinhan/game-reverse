package com.smartdigimkt.p4;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.e.l;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.o4.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b {
    public String A;
    public int B;
    public String C;
    public com.smartdigimkt.c3.a D;
    public String E;
    public String F;
    public String G;
    public int H;
    public long I;
    public JSONObject J;
    public boolean L;
    public String M;
    public int O;
    public String P;
    public long Q;
    public String S;
    public String T;
    public String U;
    public ArrayList V;
    public ArrayList W;
    public ArrayList X;
    public String Y;
    public int Z;
    public com.smartdigimkt.b4.a b0;
    public ArrayList f;
    public boolean g;
    public long h;
    public long i;
    public String j;
    public int k;
    public long l;
    public String m;
    public int n;
    public long o;
    public long p;
    public long q;
    public String r;
    public Map s;
    public Map t;
    public Map u;
    public Map v;
    public Map w;
    public int x;
    public String y;
    public int z;
    public com.smartdigimkt.p3.f e = new com.smartdigimkt.p3.f(null);
    public int K = 2;
    public String N = "";
    public int R = 1;
    public int a0 = 2;

    public final void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    this.f = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.f.add((Integer) jSONArray.get(i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str) {
        this.P = str;
    }

    public final void c(String str) {
        this.S = str;
        this.V = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.V.add(jSONArray.optString(i));
            }
        } catch (Throwable unused) {
        }
    }

    public final void d(String str) {
        this.U = str;
        this.X = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.X.add(jSONArray.optString(i));
            }
        } catch (Throwable unused) {
        }
    }

    public final void e(String str) {
        this.T = str;
        this.W = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.W.add(jSONArray.optString(i));
            }
        } catch (Throwable unused) {
        }
    }

    public final void f(int i) {
        this.z = i;
    }

    public final void g(String str) {
        this.G = str;
    }

    public final void h(String str) {
        this.Y = str;
    }

    public final void i(String str) {
        this.A = str;
    }

    public final void j(String str) {
        this.C = str;
    }

    public final void k(String str) {
        this.M = str;
    }

    public final void b(int i) {
        this.O = i;
    }

    public final void f(String str) {
        this.r = str;
    }

    public final void a(com.smartdigimkt.b4.a aVar) {
        this.b0 = aVar;
    }

    public final void c(int i) {
        this.R = i;
    }

    public final void d(int i) {
        this.K = i;
    }

    public final void e(int i) {
        this.B = i;
    }

    public static a c(JSONObject jSONObject) {
        String str;
        Map map;
        Map map2;
        Map map3;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = jSONObject;
            aVar.e = new com.smartdigimkt.p3.f(jSONObject);
            aVar.b(jSONObject);
            aVar.a(jSONObject);
            if (!jSONObject.isNull("req_ver")) {
                jSONObject.optString("req_ver");
            }
            if (jSONObject.isNull("scet")) {
                aVar.h = i.l.a;
            } else {
                aVar.h = jSONObject.optLong("scet");
            }
            if (!jSONObject.isNull("pl_n")) {
                jSONObject.optLong("pl_n");
            }
            if (jSONObject.isNull("logger")) {
                str = "la_sw";
            } else {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logger");
                jSONObjectOptJSONObject.toString();
                aVar.j = jSONObjectOptJSONObject.optString("tk_address");
                aVar.k = jSONObjectOptJSONObject.optInt("tk_max_amount");
                String str2 = "la_sw";
                aVar.l = jSONObjectOptJSONObject.optLong(com.anythink.core.e.b.a.V);
                aVar.m = jSONObjectOptJSONObject.optString("da_address");
                aVar.n = jSONObjectOptJSONObject.optInt("da_max_amount");
                aVar.o = jSONObjectOptJSONObject.optLong(com.anythink.core.e.b.a.X);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                try {
                    if (jSONObjectOptJSONObject.isNull("tk_firm")) {
                        str = str2;
                    } else {
                        JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("tk_firm"));
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            Iterator<String> it = itKeys;
                            com.smartdigimkt.c3.b bVar = new com.smartdigimkt.c3.b();
                            str = str2;
                            try {
                                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject(next);
                                JSONObject jSONObject3 = jSONObject2;
                                jSONObjectOptJSONObject2.optInt("tk_fi_re_sw");
                                jSONObjectOptJSONObject2.optInt("tk_im_sw");
                                jSONObjectOptJSONObject2.optInt("tk_sh_sw");
                                jSONObjectOptJSONObject2.optInt("tk_ck_sw");
                                jSONObjectOptJSONObject2.optString("pg_m_li");
                                concurrentHashMap.put(next, bVar);
                                itKeys = it;
                                str2 = str;
                                jSONObject2 = jSONObject3;
                            } catch (Exception unused) {
                            }
                        }
                        str = str2;
                    }
                } catch (Exception unused2) {
                }
                if (jSONObjectOptJSONObject.isNull(com.anythink.core.e.b.a.ab)) {
                    aVar.s = null;
                } else {
                    try {
                        JSONObject jSONObject4 = new JSONObject(jSONObjectOptJSONObject.optString(com.anythink.core.e.b.a.ab));
                        Iterator<String> itKeys2 = jSONObject4.keys();
                        HashMap map4 = new HashMap();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            map4.put(next2, jSONObject4.optString(next2));
                        }
                        aVar.s = map4;
                    } catch (Throwable unused3) {
                        map = null;
                        aVar.s = null;
                    }
                }
                map = null;
                if (jSONObjectOptJSONObject.isNull("da_not_keys_ft")) {
                    aVar.u = map;
                } else {
                    try {
                        JSONObject jSONObject5 = new JSONObject(jSONObjectOptJSONObject.optString("da_not_keys_ft"));
                        Iterator<String> itKeys3 = jSONObject5.keys();
                        HashMap map5 = new HashMap();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            map5.put(next3, jSONObject5.optString(next3));
                        }
                        aVar.u = map5;
                    } catch (Throwable unused4) {
                        map2 = null;
                        aVar.u = null;
                    }
                }
                map2 = null;
                if (jSONObjectOptJSONObject.isNull("tk_no_t_ft")) {
                    aVar.t = map2;
                } else {
                    try {
                        JSONObject jSONObject6 = new JSONObject(jSONObjectOptJSONObject.optString("tk_no_t_ft"));
                        Iterator<String> itKeys4 = jSONObject6.keys();
                        HashMap map6 = new HashMap();
                        while (itKeys4.hasNext()) {
                            String next4 = itKeys4.next();
                            map6.put(next4, jSONObject6.optString(next4));
                        }
                        aVar.t = map6;
                    } catch (Throwable unused5) {
                        aVar.t = null;
                    }
                }
                aVar.i(jSONObjectOptJSONObject.optString("tcp_domain"));
                aVar.e(jSONObjectOptJSONObject.optInt("tcp_port"));
                aVar.f(jSONObjectOptJSONObject.optInt(com.anythink.core.common.l.f.S));
                aVar.j(jSONObjectOptJSONObject.optString(com.anythink.core.common.l.f.U));
                if (jSONObjectOptJSONObject.isNull("tk_no_nt_t")) {
                    aVar.E = null;
                } else {
                    aVar.E = jSONObjectOptJSONObject.optString("tk_no_nt_t");
                }
                if (jSONObjectOptJSONObject.isNull("da_no_nt_k")) {
                    aVar.F = null;
                } else {
                    aVar.F = jSONObjectOptJSONObject.optString("da_no_nt_k");
                }
                if (jSONObjectOptJSONObject.isNull("tk_rt_sp_ft")) {
                    aVar.v = null;
                } else {
                    try {
                        JSONObject jSONObject7 = new JSONObject(jSONObjectOptJSONObject.optString("tk_rt_sp_ft"));
                        HashMap map7 = new HashMap();
                        for (Iterator<String> itKeys5 = jSONObject7.keys(); itKeys5.hasNext(); itKeys5 = itKeys5) {
                            String next5 = itKeys5.next();
                            HashMap map8 = new HashMap();
                            JSONObject jSONObject8 = new JSONObject(jSONObject7.optString(next5));
                            JSONArray jSONArrayOptJSONArray = jSONObject8.optJSONArray("ids");
                            JSONObject jSONObject9 = jSONObject7;
                            String strOptString = jSONObject8.optString("formats");
                            if (jSONArrayOptJSONArray.length() > 0 && !TextUtils.isEmpty(strOptString)) {
                                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    map8.put(jSONArrayOptJSONArray.optString(i), strOptString);
                                }
                            }
                            map7.put(next5, map8);
                            jSONObject7 = jSONObject9;
                        }
                        aVar.v = map7;
                    } catch (Throwable unused6) {
                        map3 = null;
                        aVar.v = null;
                    }
                }
                map3 = null;
                if (jSONObjectOptJSONObject.isNull("da_rt_sp_ft")) {
                    aVar.w = map3;
                } else {
                    try {
                        JSONObject jSONObject10 = new JSONObject(jSONObjectOptJSONObject.optString("da_rt_sp_ft"));
                        HashMap map9 = new HashMap();
                        for (Iterator<String> itKeys6 = jSONObject10.keys(); itKeys6.hasNext(); itKeys6 = itKeys6) {
                            String next6 = itKeys6.next();
                            HashMap map10 = new HashMap();
                            JSONObject jSONObject11 = new JSONObject(jSONObject10.optString(next6));
                            JSONArray jSONArrayOptJSONArray2 = jSONObject11.optJSONArray("ids");
                            JSONObject jSONObject12 = jSONObject10;
                            String strOptString2 = jSONObject11.optString("formats");
                            if (jSONArrayOptJSONArray2.length() > 0 && !TextUtils.isEmpty(strOptString2)) {
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                    map10.put(jSONArrayOptJSONArray2.optString(i2), strOptString2);
                                }
                            }
                            map9.put(next6, map10);
                            jSONObject10 = jSONObject12;
                        }
                        aVar.w = map9;
                    } catch (Throwable unused7) {
                        aVar.w = null;
                    }
                }
                if (!jSONObjectOptJSONObject.isNull("pl_st_addr")) {
                    aVar.h(jSONObjectOptJSONObject.optString("pl_st_addr"));
                }
                if (!jSONObjectOptJSONObject.isNull("app_sp_close")) {
                    aVar.Z = jSONObjectOptJSONObject.optInt("app_sp_close");
                }
            }
            if (!jSONObject.isNull("app_sp_close")) {
                aVar.Z = jSONObject.optInt("app_sp_close");
            }
            if (!jSONObject.isNull("n_psid_tm")) {
                aVar.p = jSONObject.optLong("n_psid_tm");
            }
            if (!jSONObject.isNull("c_a")) {
                aVar.q = jSONObject.optLong("c_a");
            }
            if (!jSONObject.isNull("data_level")) {
                aVar.f(jSONObject.optString("data_level"));
            }
            if (!jSONObject.isNull("psid_hl")) {
                jSONObject.optInt("psid_hl");
            }
            String str3 = str;
            if (!jSONObject.isNull(str3)) {
                jSONObject.optInt(str3);
            }
            if (jSONObject.isNull(r7)) {
                aVar.x = 1;
            } else {
                aVar.x = jSONObject.optInt("crash_sw");
            }
            if (jSONObject.isNull("crash_list")) {
                aVar.y = "";
            } else {
                aVar.y = jSONObject.optString("crash_list");
            }
            if (!jSONObject.isNull("sy_id")) {
                jSONObject.optString("sy_id");
            }
            if (jSONObject.isNull("adx")) {
                aVar.D = null;
            } else {
                com.smartdigimkt.c3.a aVar2 = new com.smartdigimkt.c3.a();
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("adx");
                if (jSONObjectOptJSONObject3 != null) {
                    aVar2.b(jSONObjectOptJSONObject3.optString("req_addr"));
                    aVar2.a(jSONObjectOptJSONObject3.optString("bid_addr"));
                    aVar2.c(jSONObjectOptJSONObject3.optString("tk_addr"));
                    jSONObjectOptJSONObject3.optString("ol_req_addr");
                }
                aVar.D = aVar2;
            }
            if (!jSONObject.isNull("custom")) {
                try {
                    JSONObject jSONObject13 = new JSONObject(jSONObject.optString("custom"));
                    HashMap map11 = new HashMap();
                    Iterator<String> itKeys7 = jSONObject13.keys();
                    while (itKeys7.hasNext()) {
                        String next7 = itKeys7.next();
                        map11.put(next7, jSONObject13.opt(next7));
                    }
                } catch (Throwable unused8) {
                }
            }
            jSONObject.optString("s2s_addr");
            if (!jSONObject.isNull("show_delay_url")) {
                jSONObject.optString("show_delay_url");
            }
            if (!jSONObject.isNull("show_delay_text")) {
                jSONObject.optString("show_delay_text");
            }
            if (!jSONObject.isNull("store_wakup")) {
                jSONObject.optString("store_wakup");
            }
            if (!jSONObject.isNull("admob_m_sw")) {
                jSONObject.optInt("admob_m_sw");
            }
            if (!jSONObject.isNull("pil")) {
                aVar.g(jSONObject.optString("pil"));
            }
            if (!jSONObject.isNull("lrqf_interval_v2")) {
                jSONObject.optString("lrqf_interval_v2");
            }
            if (!jSONObject.isNull("a_c")) {
                aVar.d(jSONObject.optJSONObject("a_c"));
            }
            jSONObject.optInt("device_perf_sw", 0);
            aVar.c(jSONObject.optString("at_a_cg", ""));
            aVar.e(jSONObject.optString("at_a_re", ""));
            aVar.d(jSONObject.optString("at_a_rc", ""));
            jSONObject.optJSONObject("nw_ext");
            aVar.d(jSONObject.optInt("sens_sw", 2));
            aVar.a();
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("job");
            if (jSONObjectOptJSONObject4 != null) {
                jSONObjectOptJSONObject4.optString("c_t", "");
                jSONObjectOptJSONObject4.optString(ImagesContract.URL, "");
            }
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("pub_st");
            if (jSONObjectOptJSONObject5 != null) {
                aVar.H = jSONObjectOptJSONObject5.optInt("pil_fu", 2);
                aVar.I = jSONObjectOptJSONObject5.optInt("pil_int", 0);
            } else {
                aVar.H = 2;
                aVar.I = 0L;
            }
            aVar.k(jSONObject.optString("wx_app_openid"));
            jSONObject.optInt("admob_init", 1);
            jSONObject.optString("smart_wf_addr");
            jSONObject.optLong("api_hf_req_int", com.anythink.core.common.g.c.a);
            aVar.a(jSONObject.optJSONArray("bid_i_sw"));
            jSONObject.optInt("adx_lc_sw", 1);
            aVar.a(jSONObject.optInt("a_i_mode", 2));
            jSONObject.optInt("fd_s_sw", 2);
            JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject(l.a.aR);
            if (jSONObjectOptJSONObject6 != null) {
                jSONObjectOptJSONObject6.optString(com.anythink.core.e.b.a.z);
                aVar.b(jSONObjectOptJSONObject6.optString("adx_sdk_dl"));
            }
            aVar.b(jSONObject.optInt("wv_c_sw", 2));
            JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject(com.anythink.core.e.b.a.C);
            com.smartdigimkt.b4.a aVarA = com.smartdigimkt.b4.a.a(jSONObjectOptJSONObject7);
            if (jSONObjectOptJSONObject7 != null) {
                aVar.c(jSONObjectOptJSONObject7.optInt("plugin_attr_sw", 1));
            }
            aVar.a(aVarA);
            aVar.a(jSONObject.optLong(com.anythink.core.e.b.a.E, 0L));
            try {
                m mVarA = m.a(jSONObject);
                if (mVarA != null) {
                    com.smartdigimkt.o4.l.b().a(mVarA);
                    mVarA.toString();
                }
            } catch (Throwable unused9) {
            }
            jSONObject.optInt("c_dp_i", 2);
            aVar.a(jSONObject.optString("h5_pre_tp", ""));
        } catch (Throwable unused10) {
        }
        return aVar;
    }

    public final void a(String str) {
        this.N = str;
    }

    public final void d(JSONObject jSONObject) {
        this.J = jSONObject;
    }

    public final void a(int i) {
        this.a0 = i;
    }

    public final void a() {
        this.L = true;
    }

    public final void a(long j) {
        this.Q = j;
    }
}
