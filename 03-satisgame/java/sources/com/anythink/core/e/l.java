package com.anythink.core.e;

import android.location.Location;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.bc;
import com.anythink.core.common.h.bm;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.byazt.ho.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l extends e {
    public static final String a = "Placement";
    public static final int b = 0;
    public static final int c = 1;
    public static final int e = 2;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    private long A;
    private long B;
    private long C;
    private int D;
    private String E;
    private bv F;
    private int G;
    private String H;
    private int I;
    private int J;
    private String K;
    private Map<String, Object> L;
    private Map<String, ATRewardInfo> M;
    private ATRewardInfo N;
    private String O;
    private String P;
    private long Q;
    private String R;
    private long S;
    private int T;
    private long U;
    private int V;
    private List<ba> W;
    private bc X;
    private long Y;
    private double Z;
    private int aA;
    private int aB;
    private int aD;
    private double[][] aH;
    private int aJ;
    private g aK;
    private boolean aM;
    private int aN;
    private int aO;
    private int aP;
    private long aQ;
    private long aR;
    private long aS;
    private int aT;
    private int aU;
    private JSONArray aV;
    private JSONArray aW;
    private JSONArray aX;
    private JSONArray aY;
    private JSONArray aZ;
    private String aa;
    private List<String> ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private long ag;
    private String ah;
    private String ai;
    private double aj;
    private long ak;
    private long al;
    private long am;
    private long an;
    private int ao;
    private int ap;
    private int aq;
    private long ar;
    private JSONObject as;
    private JSONObject at;
    private String au;
    private String av;
    private int aw;
    private int ax;
    private List<Integer> ay;
    private int az;
    private int bA;
    private int bB;
    private aj bC;
    private List<String> bD;
    private JSONObject bE;
    private JSONObject bI;
    private long bK;
    private int bL;
    private long bN;
    private List<com.anythink.core.common.b.d> bO;
    private int bP;
    private String bQ;
    private String bR;
    private long bS;
    private double bT;
    private int bU;
    private int bV;
    private int bW;
    private int bX;
    private JSONObject bY;
    private int bZ;
    private JSONArray ba;
    private JSONArray bb;
    private JSONArray bc;
    private JSONArray bd;
    private JSONArray be;
    private JSONArray bf;
    private JSONArray bg;
    private f bh;
    private long bi;
    private int bj;
    private int bk;
    private int bl;
    private List<Integer> bm;
    private int bo;
    private String bp;
    private int bq;
    private int br;
    private int[] bs;
    private Boolean bu;
    private int bv;
    private String bw;
    private aq bx;
    private int by;
    private int bz;
    private long ca;
    ATAdRequest i;
    private String j;
    private long k;
    private long l;
    private int m;
    private int n;
    private int o;
    private long p;
    private long q;
    private long r;
    private int s;
    private int t;
    private int u;
    private int v;
    private List<by> w;
    private Map<String, by> x;
    private int y;
    private int z;
    private int aC = 0;
    private int aE = 10;
    private int aF = 10;
    private int aG = 2;
    private int aI = 1;
    private com.anythink.core.common.h.q aL = new com.anythink.core.common.h.q();
    private int bn = 2;
    private int bt = 2;
    private int bF = 1;
    private int bG = 10000;
    private int bH = 3000;
    private int bJ = 1;
    private int bM = 2;

    public static class a {
        public static final String A = "req_w_time";
        public static final String B = "wf_loadts";
        public static final String C = "req_ug_type";
        public static final String D = "req_ug_numsp";
        public static final String E = "bf_ldf_rf_sw";
        public static final String F = "hb_start_time";
        public static final String G = "dsp_list";
        public static final String H = "bid_floor";
        public static final String I = "max_unit_ids";
        public static final String J = "xdb_list";
        public static final String K = "s2s_bd_max";
        public static final String L = "req_merge";
        public static final String M = "exclude_id_max";
        public static final String N = "install_id_max";
        public static final String O = "install_ids";
        public static final String P = "exclude_ids";
        public static final String Q = "is_test";
        public static final String R = "gsp_rates";
        public static final String S = "adx_ext";
        public static final String T = "wf_id";
        public static final String U = "sysh_mtg_sw";
        public static final String V = "mid_gdt_sw";
        public static final String W = "lm_lrqf_interval_sws";
        public static final String X = "wf_lscb_type";
        public static final String Y = "reqid_pg_sw";
        public static final String Z = "sr_sw";
        public static final String a = "hb_bid_timeout";
        public static final String aA = "unique_id";
        public static final String aB = "e_key_data";
        public static final String aC = "c_pub_key";
        public static final String aD = "s_id";
        public static final String aE = "c_id";
        public static final String aF = "sp_sdk_pri_timeout";
        public static final String aG = "dn_c2shb_list";
        public static final String aH = "dn_s2shb_list";
        public static final String aI = "bid_wait_other_time";
        public static final String aJ = "h_s_t_auto_sdk_to_time";
        public static final String aK = "ps_ct_out_cus";
        public static final String aL = "autoload_t";
        public static final String aM = "ads_lg_st";
        public static final String aN = "rotation_num";
        public static final String aO = "rotation_inter";
        public static final String aP = "rotation_cache_ts";
        public static final String aQ = "adx_id_b_sw";
        public static final String aR = "addr_st";
        public static final String aS = "i_r_sw";
        public static final String aT = "strategy_domain_type_key";
        public static final String aU = "anr_dyna_st";
        public static final String aV = "wf_dfp";
        private static final String aW = "ps_id_timeout";
        private static final String aX = "ps_ct";
        private static final String aY = "ps_ct_out";
        private static final String aZ = "pucs";
        public static final String aa = "p_c";
        public static final String ab = "has_1st_rl";
        public static final String ac = "updateTime";
        public static final String ad = "upd_type";
        public static final String ae = "upd_th";
        public static final String af = "value_n";
        public static final String ag = "bid_value_n";
        public static final String ah = "sto_stg";
        public static final String ai = "lf_rt_itr";
        public static final String aj = "wf2_mode_sw";
        public static final String ak = "wf2_req_ug_type";
        public static final String al = "wf2_mode_req_num";
        public static final String am = "am_est_num";
        public static final String an = "share_pl_id";
        public static final String ao = "s2s_sw";
        public static final String ap = "bd_req_bid_sw";
        public static final String aq = "bn_template_id";
        public static final String ar = "mix_click_type";
        public static final String as = "auto_refresh_type";
        public static final String at = "wf_sw";
        public static final String au = "wf_obj";
        public static final String av = "pl_wf_st_type";
        public static final String aw = "presetwf_reload_sw";
        public static final String ax = "wf2_nf_sw";
        public static final String ay = "ps_ct_max";
        public static final String az = "adx_dsp";
        public static final String b = "addr_bid";
        private static final String bA = "m_o_ks";
        private static final String bB = "p_m_o";
        private static final String bC = "callback";
        private static final String bD = "sc_list";
        private static final String bE = "rw_n";
        private static final String bF = "rw_num";
        private static final String bG = "reward";
        private static final String bH = "currency";
        private static final String bI = "cc";
        private static final String bJ = "exch_r";
        private static final String bK = "acct_cy";
        private static final String bL = "req_ug_type_v2";
        private static final String bM = "device_perf_sw";
        private static final String bN = "max_cached_num";
        private static final String bO = "wf_req_wait_t";
        private static final String bP = "c2s_req_wait_t";
        private static final String bQ = "s2s_req_wait_t";
        private static final String bR = "auto_req_type";
        private static final String bS = "auto_refresh_type_v2";
        private static final String bT = "pl_refresh_timeout";
        private static final String bU = "wait_bid_load_sw";
        private static final String bV = "wait_bid_cb_t";
        private static final String ba = "ad_delivery_sw";
        private static final String bb = "req_ug_num";
        private static final String bc = "unit_caps_d";
        private static final String bd = "unit_caps_h";
        private static final String be = "unit_pacing";
        private static final String bf = "wifi_auto_sw";
        private static final String bg = "show_type";
        private static final String bh = "refresh";
        private static final String bi = "ug_list";
        private static final String bj = "ol_list";
        private static final String bk = "gro_id";
        private static final String bl = "hb_list";
        private static final String bm = "s2shb_list";
        private static final String bn = "format";
        private static final String bo = "auto_refresh";
        private static final String bp = "auto_refresh_time";
        private static final String bq = "s_t";
        private static final String br = "l_s_t";
        private static final String bs = "ra";
        private static final String bt = "asid";
        private static final String bu = "tp_ps";
        private static final String bv = "t_g_id";
        private static final String bw = "s_id";
        private static final String bx = "u_n_f_sw";
        private static final String by = "m_o";
        private static final String bz = "m_o_s";
        public static final String c = "load_fail_wtime";
        public static final String d = "load_cap";
        public static final String e = "load_cap_time";
        public static final String f = "cached_offers_num";
        public static final String g = "adx_list";
        public static final String h = "adx_st";
        public static final String i = "ilrd";
        public static final String j = "hb_list";
        public static final String k = "inh_list";
        public static final String l = "fbhb_bid_wtime";
        public static final String m = "burl_nt_firm";
        public static final String n = "wf_bid_addr";
        public static final String o = "ss_data";
        public static final String p = "cn_addr_bid";
        public static final String q = "cn_wf_bid_addr";
        public static final String r = "byuid_wt";
        public static final String s = "addr_bks";
        public static final String t = "addr_subbks";
        public static final String u = "s2sbks_list";
        public static final String v = "exch_rate_c2u";
        public static final String w = "doffer_list";
        public static final String x = "bottom_list";
        public static final String y = "bottom_reqts";
        public static final String z = "cb_w_time";
    }

    public final int a() {
        return this.aN;
    }

    private void c(int i) {
        this.aN = i;
    }

    public final int b() {
        return this.aO;
    }

    private void d(int i) {
        this.aO = i;
    }

    public final int c() {
        return this.aP;
    }

    private void g(int i) {
        this.aP = i;
    }

    public final long d() {
        return this.aQ;
    }

    private void a(long j) {
        this.aQ = j;
    }

    public final long e() {
        return this.aR;
    }

    private void b(long j) {
        this.aR = j;
    }

    public final long f() {
        return this.aS;
    }

    private void c(long j) {
        this.aS = j;
    }

    public final int g() {
        return this.aT;
    }

    private void h(int i) {
        this.aT = i;
    }

    public final int h() {
        return this.aU;
    }

    private void i(int i) {
        this.aU = i;
    }

    private l(String str) {
        this.j = str;
    }

    public final String i() {
        return this.j;
    }

    public final g j() {
        return this.aK;
    }

    private void a(g gVar) {
        this.aK = gVar;
    }

    public final f k() {
        return this.bh;
    }

    private void a(f fVar) {
        this.bh = fVar;
    }

    public final int l() {
        return this.aJ;
    }

    private void j(int i) {
        this.aJ = i;
    }

    public final int m() {
        return this.aB;
    }

    private void k(int i) {
        this.aB = i;
    }

    public final List<Integer> n() {
        return this.bm;
    }

    private void a(List<Integer> list) {
        this.bm = list;
    }

    public final int o() {
        return this.bk;
    }

    private void l(int i) {
        this.bk = i;
    }

    public final int p() {
        return this.bl;
    }

    private void m(int i) {
        this.bl = i;
    }

    public final int q() {
        return this.bj;
    }

    private void n(int i) {
        this.bj = i;
    }

    public final long s() {
        return this.bi;
    }

    private void d(long j) {
        this.bi = j;
    }

    public final ATAdRequest t() {
        return this.i;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.i = aTAdRequest;
    }

    private static l b(String str, JSONObject jSONObject) {
        long jOptLong;
        JSONArray jSONArrayOptJSONArray;
        int length;
        if (jSONObject == null) {
            return null;
        }
        try {
            l lVar = new l(str);
            lVar.bK = System.currentTimeMillis();
            lVar.b(jSONObject);
            lVar.c(jSONObject);
            lVar.d(jSONObject);
            if (jSONObject.isNull("ps_ct")) {
                lVar.k = 0L;
            } else {
                lVar.k = jSONObject.optLong("ps_ct");
            }
            if (jSONObject.isNull("ps_ct_out")) {
                lVar.l = 0L;
            } else {
                lVar.l = jSONObject.optLong("ps_ct_out");
            }
            if (jSONObject.isNull("pucs")) {
                lVar.m = 1;
            } else {
                lVar.m = jSONObject.optInt("pucs");
            }
            if (jSONObject.isNull("ad_delivery_sw")) {
                lVar.n = 1;
            } else {
                lVar.n = jSONObject.optInt("ad_delivery_sw");
            }
            if (!jSONObject.isNull("req_ug_num")) {
                int iOptInt = jSONObject.optInt("req_ug_num", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                lVar.o = iOptInt;
            } else {
                lVar.o = 1;
            }
            if (jSONObject.isNull("unit_caps_d")) {
                lVar.p = -1L;
            } else {
                lVar.p = jSONObject.optLong("unit_caps_d");
            }
            if (jSONObject.isNull("unit_caps_h")) {
                lVar.q = -1L;
            } else {
                lVar.q = jSONObject.optLong("unit_caps_h");
            }
            if (jSONObject.isNull("unit_pacing")) {
                lVar.r = -1L;
            } else {
                lVar.r = jSONObject.optLong("unit_pacing");
            }
            if (jSONObject.isNull("wifi_auto_sw")) {
                lVar.s = 0;
            } else {
                lVar.s = jSONObject.optInt("wifi_auto_sw");
            }
            if (jSONObject.isNull("show_type")) {
                lVar.t = 0;
            } else {
                lVar.t = jSONObject.optInt("show_type");
            }
            if (jSONObject.isNull("refresh")) {
                lVar.u = 0;
            } else {
                lVar.u = jSONObject.optInt("refresh");
            }
            if (jSONObject.isNull("gro_id")) {
                lVar.v = 0;
            } else {
                lVar.v = jSONObject.optInt("gro_id");
            }
            if (jSONObject.isNull(com.anythink.core.common.f.a.C0017a.d)) {
                lVar.y = 0;
            } else {
                lVar.y = jSONObject.optInt(com.anythink.core.common.f.a.C0017a.d);
            }
            if (jSONObject.isNull("auto_refresh")) {
                lVar.z = 0;
            } else {
                lVar.z = jSONObject.optInt("auto_refresh");
            }
            if (jSONObject.isNull("auto_refresh_time")) {
                lVar.A = 0L;
            } else {
                lVar.A = jSONObject.optLong("auto_refresh_time");
            }
            if (jSONObject.isNull("s_t")) {
                lVar.B = 900000L;
            } else {
                lVar.B = jSONObject.optLong("s_t");
            }
            if (jSONObject.isNull(com.anythink.core.common.k.O)) {
                lVar.C = com.anythink.core.common.g.c.a;
            } else {
                lVar.C = jSONObject.optLong(com.anythink.core.common.k.O);
            }
            if (jSONObject.isNull("ra")) {
                lVar.D = -1;
            } else {
                lVar.D = jSONObject.optInt("ra");
            }
            if (jSONObject.isNull("asid")) {
                lVar.E = "";
            } else {
                lVar.E = jSONObject.optString("asid");
            }
            if (!jSONObject.isNull("tp_ps")) {
                try {
                    bv bvVar = new bv();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tp_ps");
                    bvVar.a = jSONObjectOptJSONObject.optInt("pucs") == 1;
                    bvVar.b = jSONObjectOptJSONObject.optLong("apdt");
                    bvVar.c = jSONObjectOptJSONObject.optInt("aprn");
                    bvVar.d = jSONObjectOptJSONObject.optInt("puas") == 1;
                    bvVar.e = jSONObjectOptJSONObject.optLong("cdt");
                    bvVar.f = jSONObjectOptJSONObject.optInt("ski_swt") == 1;
                    bvVar.g = jSONObjectOptJSONObject.optInt("aut_swt") == 1;
                    lVar.F = bvVar;
                } catch (Exception unused) {
                }
            } else {
                lVar.F = null;
            }
            if (jSONObject.isNull("ug_list")) {
                lVar.aV = new JSONArray();
            } else {
                lVar.aV = jSONObject.optJSONArray("ug_list");
            }
            if (jSONObject.isNull("ol_list")) {
                lVar.aW = new JSONArray();
            } else {
                lVar.aW = jSONObject.optJSONArray("ol_list");
            }
            if (jSONObject.isNull("s2shb_list")) {
                lVar.aX = new JSONArray();
            } else {
                lVar.aX = jSONObject.optJSONArray("s2shb_list");
            }
            if (jSONObject.isNull(a.g)) {
                lVar.aY = new JSONArray();
            } else {
                lVar.aY = jSONObject.optJSONArray(a.g);
            }
            if (jSONObject.isNull(a.j)) {
                lVar.aZ = new JSONArray();
            } else {
                lVar.aZ = jSONObject.optJSONArray(a.j);
            }
            if (jSONObject.isNull(a.k)) {
                lVar.ba = new JSONArray();
            } else {
                lVar.ba = jSONObject.optJSONArray(a.k);
            }
            if (jSONObject.isNull(a.u)) {
                lVar.bb = new JSONArray();
            } else {
                lVar.bb = jSONObject.optJSONArray(a.u);
            }
            if (jSONObject.isNull(a.w)) {
                lVar.bc = new JSONArray();
            } else {
                lVar.bc = jSONObject.optJSONArray(a.w);
            }
            if (!jSONObject.isNull(a.ac)) {
                jOptLong = jSONObject.optLong(a.ac);
                lVar.bS = jOptLong;
            } else {
                lVar.bS = 0L;
                jOptLong = 0;
            }
            if (jSONObject.isNull("t_g_id")) {
                lVar.G = -1;
            } else {
                lVar.G = jSONObject.optInt("t_g_id");
            }
            if (jSONObject.isNull(a.aD)) {
                lVar.H = "";
            } else {
                lVar.H = jSONObject.optString(a.aD);
            }
            if (jSONObject.isNull("u_n_f_sw")) {
                lVar.I = 0;
            } else {
                lVar.I = jSONObject.optInt("u_n_f_sw");
            }
            if (!jSONObject.isNull("m_o_s")) {
                lVar.X = bc.u(jSONObject.optString("m_o_s"));
            }
            if (jSONObject.isNull("m_o")) {
                lVar.W = null;
            } else {
                lVar.W = a(jSONObject.optString("m_o"), jSONObject.optString("m_o_ks"), jOptLong, lVar.X);
            }
            if (jSONObject.isNull("p_m_o")) {
                lVar.J = 0;
            } else {
                lVar.J = jSONObject.optInt("p_m_o");
            }
            if (!jSONObject.isNull(com.anythink.core.common.l.u.b)) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(com.anythink.core.common.l.u.b));
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.opt(next));
                }
                lVar.L = map;
            } else {
                lVar.L = null;
            }
            if (!jSONObject.isNull("callback")) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString("callback"));
                if (!jSONObject3.isNull("sc_list")) {
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.optString("sc_list"));
                    HashMap map2 = new HashMap();
                    Iterator<String> itKeys2 = jSONObject4.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        JSONObject jSONObject5 = new JSONObject(jSONObject4.optString(next2));
                        ATRewardInfo aTRewardInfo = new ATRewardInfo();
                        aTRewardInfo.rewardName = jSONObject5.optString("rw_n");
                        aTRewardInfo.rewardNumber = jSONObject5.optInt("rw_num");
                        map2.put(next2, aTRewardInfo);
                    }
                    lVar.M = map2;
                }
                if (!jSONObject3.isNull("reward")) {
                    JSONObject jSONObject6 = new JSONObject(jSONObject3.optString("reward"));
                    ATRewardInfo aTRewardInfo2 = new ATRewardInfo();
                    if (!jSONObject6.isNull("rw_n")) {
                        aTRewardInfo2.rewardName = jSONObject6.optString("rw_n");
                    }
                    if (!jSONObject6.isNull("rw_num")) {
                        aTRewardInfo2.rewardNumber = jSONObject6.optInt("rw_num");
                    }
                    lVar.N = aTRewardInfo2;
                }
                if (!jSONObject3.isNull("currency")) {
                    lVar.O = jSONObject3.optString("currency");
                }
                if (!jSONObject3.isNull("cc")) {
                    lVar.P = jSONObject3.optString("cc");
                }
                if (!jSONObject3.isNull("exch_r")) {
                    lVar.Z = jSONObject3.optDouble("exch_r", 0.0d);
                }
                if (!jSONObject3.isNull("acct_cy")) {
                    lVar.aa = jSONObject3.optString("acct_cy");
                }
            }
            if (jSONObject.isNull(a.a)) {
                lVar.Q = 10000L;
            } else {
                lVar.Q = jSONObject.optLong(a.a);
            }
            if (jSONObject.isNull(a.b)) {
                lVar.R = "";
            } else {
                lVar.R = jSONObject.optString(a.b);
            }
            if (jSONObject.isNull(a.c)) {
                lVar.S = 10000L;
            } else {
                lVar.S = jSONObject.optLong(a.c);
            }
            if (jSONObject.isNull(a.d)) {
                lVar.T = -1;
            } else {
                lVar.T = jSONObject.optInt(a.d);
            }
            if (jSONObject.isNull(a.e)) {
                lVar.U = 900000L;
            } else {
                lVar.U = jSONObject.optLong(a.e);
            }
            if (!jSONObject.isNull(a.f)) {
                int iOptInt2 = jSONObject.optInt(a.f, 1);
                if (iOptInt2 <= 0) {
                    iOptInt2 = 1;
                }
                lVar.V = iOptInt2;
            } else {
                lVar.V = 2;
            }
            if (jSONObject.isNull(a.i)) {
                lVar.bQ = null;
            } else {
                lVar.bQ = jSONObject.optString(a.i);
            }
            if (jSONObject.isNull(a.h)) {
                lVar.bR = "";
            } else {
                lVar.bR = jSONObject.optString(a.h);
            }
            if (jSONObject.isNull(a.l)) {
                lVar.Y = 4000L;
            } else {
                lVar.Y = jSONObject.optLong(a.l);
            }
            if (!jSONObject.isNull(a.m)) {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(a.m);
                ArrayList arrayList = new ArrayList(3);
                for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray2.optString(i));
                }
                lVar.ab = arrayList;
            } else {
                lVar.ab = null;
            }
            if (jSONObject.isNull(a.n)) {
                lVar.ac = "";
            } else {
                lVar.ac = jSONObject.optString(a.n);
            }
            if (jSONObject.isNull(a.o)) {
                lVar.ad = "";
            } else {
                lVar.ad = jSONObject.optString(a.o);
            }
            if (jSONObject.isNull(a.p)) {
                lVar.ae = "";
            } else {
                lVar.ae = jSONObject.optString(a.p);
            }
            if (jSONObject.isNull(a.q)) {
                lVar.af = "";
            } else {
                lVar.af = jSONObject.optString(a.q);
            }
            if (jSONObject.isNull(a.r)) {
                lVar.ag = 500L;
            } else {
                lVar.ag = jSONObject.optLong(a.r);
            }
            if (jSONObject.isNull(a.s)) {
                lVar.ah = "";
            } else {
                lVar.ah = jSONObject.optString(a.s);
            }
            if (jSONObject.isNull(a.t)) {
                lVar.ai = "";
            } else {
                lVar.ai = jSONObject.optString(a.t);
            }
            if (jSONObject.isNull(a.v)) {
                lVar.aj = 0.1614d;
            } else {
                lVar.aj = jSONObject.optDouble(a.v);
            }
            if (jSONObject.isNull(a.x)) {
                lVar.be = new JSONArray();
            } else {
                lVar.be = jSONObject.optJSONArray(a.x);
            }
            if (jSONObject.isNull(a.y)) {
                lVar.ak = 1000L;
            } else {
                lVar.ak = jSONObject.optLong(a.y);
            }
            if (jSONObject.isNull(a.z)) {
                lVar.al = 0L;
            } else {
                lVar.al = jSONObject.optLong(a.z);
            }
            if (jSONObject.isNull(a.A)) {
                lVar.am = 2000L;
            } else {
                lVar.am = jSONObject.optLong(a.A);
            }
            if (jSONObject.isNull(a.B)) {
                lVar.an = -1L;
            } else {
                lVar.an = jSONObject.optLong(a.B);
            }
            if (!jSONObject.isNull(a.C)) {
                int iOptInt3 = jSONObject.optInt(a.C);
                if (iOptInt3 != 1 && iOptInt3 != 2) {
                    iOptInt3 = 1;
                }
                lVar.ao = iOptInt3;
            } else {
                lVar.ao = 1;
            }
            if (jSONObject.isNull(a.D)) {
                lVar.ap = 1;
            } else {
                lVar.ap = jSONObject.optInt(a.D);
            }
            if (jSONObject.isNull(a.E)) {
                lVar.aq = 2;
            } else {
                lVar.aq = jSONObject.optInt(a.E);
            }
            if (jSONObject.isNull(a.F)) {
                lVar.ar = 2000L;
            } else {
                lVar.ar = jSONObject.optLong(a.F);
            }
            if (jSONObject.isNull(a.G)) {
                lVar.bd = new JSONArray();
            } else {
                lVar.bd = jSONObject.optJSONArray(a.G);
            }
            if (jSONObject.isNull("bid_floor")) {
                lVar.bT = 0.0d;
            } else {
                lVar.bT = jSONObject.optDouble("bid_floor");
            }
            if (jSONObject.isNull(a.I)) {
                lVar.as = null;
            } else {
                lVar.as = jSONObject.optJSONObject(a.I);
            }
            if (jSONObject.isNull(a.K)) {
                lVar.bU = 0;
            } else {
                lVar.bU = jSONObject.optInt(a.K);
            }
            if (jSONObject.isNull(a.L)) {
                lVar.bV = 2;
            } else {
                lVar.bV = jSONObject.optInt(a.L);
            }
            if (jSONObject.isNull(a.M)) {
                lVar.bX = 0;
            } else {
                lVar.bX = jSONObject.optInt(a.M);
            }
            if (jSONObject.isNull(a.N)) {
                lVar.bW = 0;
            } else {
                lVar.bW = jSONObject.optInt(a.N);
            }
            if (jSONObject.isNull("is_test")) {
                lVar.bP = 2;
            } else {
                lVar.bP = jSONObject.optInt("is_test");
            }
            lVar.at = jSONObject.optJSONObject(a.R);
            if (jSONObject.isNull(a.S)) {
                lVar.au = "";
            } else {
                lVar.au = jSONObject.optString(a.S);
            }
            if (jSONObject.isNull(a.T)) {
                lVar.av = "";
            } else {
                lVar.av = jSONObject.optString(a.T);
            }
            if (!jSONObject.isNull(a.U)) {
                lVar.aw = jSONObject.optInt(a.U);
            } else {
                lVar.aw = 2;
            }
            if (!jSONObject.isNull(a.V)) {
                lVar.ax = jSONObject.optInt(a.V);
            } else {
                lVar.ax = 1;
            }
            if (!jSONObject.isNull(a.W)) {
                ArrayList arrayList2 = new ArrayList(3);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(a.W);
                if (jSONArrayOptJSONArray3 != null) {
                    int length2 = jSONArrayOptJSONArray3.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i2)));
                    }
                }
                lVar.ay = arrayList2;
            } else {
                lVar.ay = new ArrayList(1);
            }
            if (jSONObject.isNull(a.X)) {
                lVar.az = 2;
            } else {
                lVar.az = jSONObject.optInt(a.X);
            }
            if (!jSONObject.isNull(a.Y)) {
                lVar.aA = jSONObject.optInt(a.Y);
            } else {
                lVar.aA = 1;
            }
            if (jSONObject.isNull(a.Z)) {
                lVar.aB = 2;
            } else {
                lVar.aB = jSONObject.optInt(a.Z);
            }
            if (!jSONObject.isNull(a.aa)) {
                lVar.bY = jSONObject.optJSONObject(a.aa);
            }
            if (!jSONObject.isNull(a.ab)) {
                lVar.aD = jSONObject.optInt(a.ab);
            }
            if (!jSONObject.isNull(a.af)) {
                lVar.aE = jSONObject.optInt(a.af);
            }
            if (!jSONObject.isNull(a.ag)) {
                lVar.aF = jSONObject.optInt(a.ag);
            }
            if (!jSONObject.isNull(a.ad)) {
                lVar.aG = jSONObject.optInt(a.ad);
            }
            if (!jSONObject.isNull(a.ae)) {
                try {
                    JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray(a.ae);
                    if (jSONArrayOptJSONArray4 != null) {
                        double[][] dArr = new double[jSONArrayOptJSONArray4.length()][];
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray4.length(); i3++) {
                            Object obj = jSONArrayOptJSONArray4.get(i3);
                            if (obj instanceof JSONArray) {
                                JSONArray jSONArray = (JSONArray) obj;
                                dArr[i3] = new double[]{Double.parseDouble(String.valueOf(jSONArray.get(0))), Double.parseDouble(String.valueOf(jSONArray.get(1)))};
                            }
                        }
                        lVar.aH = dArr;
                    }
                } catch (Exception unused2) {
                }
            }
            if (!jSONObject.isNull(a.ah)) {
                lVar.aI = jSONObject.optInt(a.ah);
            }
            lVar.bi = jSONObject.optLong(a.ai, 2000L);
            lVar.bj = jSONObject.optInt(a.aj, 2);
            int iOptInt4 = jSONObject.optInt(a.ak, 1);
            if (iOptInt4 != 1 && iOptInt4 != 2) {
                iOptInt4 = 1;
            }
            lVar.bk = iOptInt4;
            int iOptInt5 = jSONObject.optInt(a.al, 1);
            if (iOptInt5 <= 0) {
                iOptInt5 = 1;
            }
            lVar.bl = iOptInt5;
            lVar.bo = jSONObject.optInt(a.am, 0);
            lVar.bp = jSONObject.optString(a.an, "");
            lVar.bq = jSONObject.optInt("s2s_sw", 2);
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray(a.ap);
            if (jSONArrayOptJSONArray5 != null && (length = jSONArrayOptJSONArray5.length()) > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < length; i4++) {
                    Object obj2 = jSONArrayOptJSONArray5.get(i4);
                    if (obj2 instanceof Integer) {
                        arrayList3.add((Integer) obj2);
                    }
                }
                lVar.bm = arrayList3;
            }
            lVar.br = jSONObject.optInt(a.aq, 1);
            int[] iArr = {1, 2, 3, 4, 5};
            if (!jSONObject.isNull(a.ar) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(a.ar)) != null && jSONArrayOptJSONArray.length() > 0) {
                try {
                    iArr = new int[jSONArrayOptJSONArray.length()];
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                        iArr[i5] = jSONArrayOptJSONArray.getInt(i5);
                    }
                } catch (Exception unused3) {
                    iArr = new int[]{1, 2, 3, 4, 5};
                }
            }
            lVar.bs = iArr;
            lVar.aJ = jSONObject.optInt(a.as, 1);
            int iOptInt6 = jSONObject.optInt(a.at, 2);
            if (iOptInt6 == 1) {
                lVar.aK = g.a(jSONObject.optString(a.au));
            } else {
                lVar.aK = null;
            }
            lVar.aC = jSONObject.optInt(a.av, 0);
            lVar.bt = jSONObject.optInt(a.aw, 2);
            lVar.bn = jSONObject.optInt(a.ax);
            lVar.bv = jSONObject.optInt(a.ay, BaseConstants.Time.WEEK);
            lVar.bw = jSONObject.optString(a.az);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(a.aB);
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                aq aqVar = new aq();
                aqVar.a(jSONObject.optString(a.aA));
                aqVar.c(jSONObjectOptJSONObject2.optString(a.aC));
                aqVar.a(jSONObjectOptJSONObject2.optInt(a.aD));
                aqVar.b(jSONObjectOptJSONObject2.optInt("c_id"));
                lVar.bx = aqVar;
            }
            com.anythink.core.common.u.s.a(lVar.aj);
            lVar.by = jSONObject.optInt(a.aF, -1);
            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray(a.aG);
            if (jSONArrayOptJSONArray6 == null) {
                jSONArrayOptJSONArray6 = new JSONArray();
            }
            lVar.bf = jSONArrayOptJSONArray6;
            JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray(a.aH);
            if (jSONArrayOptJSONArray7 == null) {
                jSONArrayOptJSONArray7 = new JSONArray();
            }
            lVar.bg = jSONArrayOptJSONArray7;
            lVar.bz = jSONObject.optInt(a.aI, -1);
            lVar.bA = jSONObject.optInt(a.aJ, -1);
            lVar.bB = jSONObject.optInt(a.aK, 2000);
            lVar.bC = aj.a(jSONObject);
            lVar.bD = com.anythink.core.common.u.p.b(jSONObject.optJSONArray(a.aL));
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(a.aM);
            if (jSONObjectOptJSONObject3 != null) {
                lVar.bE = jSONObjectOptJSONObject3;
            }
            lVar.bF = jSONObject.optInt(a.aN, 1);
            lVar.bG = jSONObject.optInt(a.aO, 10000);
            lVar.bH = jSONObject.optInt(a.aP, 3000);
            lVar.bM = jSONObject.optInt(a.aQ, 2);
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(a.aR);
            if (jSONObjectOptJSONObject4 != null) {
                lVar.bI = jSONObjectOptJSONObject4;
            }
            lVar.bJ = jSONObject.optInt(a.aS, 2);
            lVar.aN = jSONObject.optInt("req_ug_type_v2", -1);
            lVar.aO = jSONObject.optInt("device_perf_sw", 0);
            lVar.aP = jSONObject.optInt("max_cached_num", -1);
            lVar.aQ = jSONObject.optLong("wf_req_wait_t", 0L);
            lVar.aR = jSONObject.optLong("c2s_req_wait_t", 0L);
            lVar.aS = jSONObject.optLong("s2s_req_wait_t", 0L);
            lVar.aT = jSONObject.optInt("auto_req_type", -1);
            lVar.aU = jSONObject.optInt("auto_refresh_type_v2", -1);
            lVar.bN = jSONObject.optLong("pl_refresh_timeout", 5000L);
            lVar.f(jSONObject.optInt("strategy_domain_type_key", 0));
            lVar.bZ = jSONObject.optInt("wait_bid_load_sw", 2);
            lVar.ca = jSONObject.optLong("wait_bid_cb_t", 5000L);
            JSONArray jSONArrayOptJSONArray8 = jSONObject.optJSONArray("anr_dyna_st");
            if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() > 0) {
                ArrayList arrayList4 = new ArrayList();
                for (int i6 = 0; i6 < jSONArrayOptJSONArray8.length(); i6++) {
                    com.anythink.core.common.b.d dVarA = com.anythink.core.common.b.d.a(jSONArrayOptJSONArray8.optJSONObject(i6));
                    if (dVarA != null) {
                        arrayList4.add(dVarA);
                    }
                }
                lVar.bO = arrayList4;
            }
            if (iOptInt6 == 1) {
                lVar.bh = f.a(jSONObject.optJSONObject(a.aV));
            } else {
                lVar.bh = null;
            }
            return lVar;
        } catch (Exception unused4) {
            return null;
        }
    }

    public final int u() {
        return this.bo;
    }

    private void o(int i) {
        this.bo = i;
    }

    public final String v() {
        return this.bp;
    }

    private void c(String str) {
        this.bp = str;
    }

    public final int w() {
        return this.bq;
    }

    private void p(int i) {
        this.bq = i;
    }

    private void a(Map<String, by> map) {
        this.x = map;
    }

    public final Map<String, by> x() {
        return this.x;
    }

    public final by a(String str) {
        Map<String, by> map = this.x;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final List<by> y() {
        return this.w;
    }

    private void b(List<by> list) {
        this.w = list;
    }

    public final int z() {
        return this.az;
    }

    private void q(int i) {
        this.az = i;
    }

    public final List<Integer> A() {
        return this.ay;
    }

    private void c(List<Integer> list) {
        this.ay = list;
    }

    public final String B() {
        return this.av;
    }

    private void d(String str) {
        this.av = str;
    }

    public final String C() {
        return this.au;
    }

    private void e(String str) {
        this.au = str;
    }

    public final JSONObject D() {
        return this.at;
    }

    private void a(JSONObject jSONObject) {
        this.at = jSONObject;
    }

    private JSONObject bN() {
        return this.as;
    }

    private void e(JSONObject jSONObject) {
        this.as = jSONObject;
    }

    public final int E() {
        return this.bP;
    }

    private void r(int i) {
        this.bP = i;
    }

    public final long F() {
        return this.ar;
    }

    private void e(long j) {
        this.ar = j;
    }

    public final int G() {
        return this.aq;
    }

    private void s(int i) {
        this.aq = i;
    }

    private void t(int i) {
        this.ao = i;
    }

    private void u(int i) {
        this.ap = i;
    }

    public final int I() {
        int i = this.ao;
        if (i == 1) {
            return this.o;
        }
        if (i != 2) {
            return 1;
        }
        return this.ap;
    }

    public final long J() {
        return this.an;
    }

    private void f(long j) {
        this.an = j;
    }

    public final JSONArray K() {
        return this.be;
    }

    private void a(JSONArray jSONArray) {
        this.be = jSONArray;
    }

    public final long L() {
        return this.ak;
    }

    private void g(long j) {
        this.ak = j;
    }

    public final double M() {
        return this.aj;
    }

    private void a(double d) {
        this.aj = d;
    }

    public final String N() {
        return this.ah;
    }

    private void f(String str) {
        this.ah = str;
    }

    public final String O() {
        return this.ai;
    }

    private void g(String str) {
        this.ai = str;
    }

    public final JSONArray P() {
        return this.bb;
    }

    private void b(JSONArray jSONArray) {
        this.bb = jSONArray;
    }

    public final long Q() {
        return this.ag;
    }

    private void h(long j) {
        this.ag = j;
    }

    public final String R() {
        return this.ad;
    }

    private void h(String str) {
        this.ad = str;
    }

    public final String S() {
        return this.ac;
    }

    private void i(String str) {
        this.ac = str;
    }

    public final List<String> T() {
        return this.ab;
    }

    private void d(List<String> list) {
        this.ab = list;
    }

    public final double U() {
        return this.Z;
    }

    private void b(double d) {
        this.Z = d;
    }

    public final String V() {
        return this.aa;
    }

    private void j(String str) {
        this.aa = str;
    }

    public final long W() {
        return this.Y;
    }

    private void i(long j) {
        this.Y = j;
    }

    public final JSONArray X() {
        return this.ba;
    }

    private void c(JSONArray jSONArray) {
        this.ba = jSONArray;
    }

    public final String Y() {
        return this.bQ;
    }

    private void k(String str) {
        this.bQ = str;
    }

    private String bO() {
        return this.bR;
    }

    private void l(String str) {
        this.bR = str;
    }

    public final JSONArray Z() {
        return this.aY;
    }

    private void d(JSONArray jSONArray) {
        this.aY = jSONArray;
    }

    private void a(bc bcVar) {
        this.X = bcVar;
    }

    private bc bP() {
        return this.X;
    }

    private List<ba> bQ() {
        return this.W;
    }

    private void e(List<ba> list) {
        this.W = list;
    }

    private String bR() {
        return this.R;
    }

    private void m(String str) {
        this.R = str;
    }

    public final long aa() {
        return this.Q;
    }

    private void j(long j) {
        this.Q = j;
    }

    public final Map<String, ATRewardInfo> ab() {
        return this.M;
    }

    public final String ac() {
        return this.O;
    }

    private void n(String str) {
        this.O = str;
    }

    public final String ad() {
        return this.P;
    }

    private void o(String str) {
        this.P = str;
    }

    private void b(Map<String, ATRewardInfo> map) {
        this.M = map;
    }

    public final ATRewardInfo ae() {
        return this.N;
    }

    private void a(ATRewardInfo aTRewardInfo) {
        this.N = aTRewardInfo;
    }

    public final Map<String, Object> af() {
        return this.L;
    }

    private void c(Map<String, Object> map) {
        this.L = map;
    }

    public final int ag() {
        return this.J;
    }

    private void v(int i) {
        this.J = i;
    }

    public final int ah() {
        return this.G;
    }

    private void w(int i) {
        this.G = i;
    }

    public final String ai() {
        return this.H;
    }

    private void p(String str) {
        this.H = str;
    }

    public final int aj() {
        return this.I;
    }

    private void x(int i) {
        this.I = i;
    }

    public final long ak() {
        return this.B;
    }

    private void k(long j) {
        this.B = j;
    }

    public final long al() {
        return this.C;
    }

    private void l(long j) {
        this.C = j;
    }

    private int bS() {
        return this.D;
    }

    private void y(int i) {
        this.D = i;
    }

    public final String am() {
        return this.E;
    }

    private void q(String str) {
        this.E = str;
    }

    public final int an() {
        return this.z;
    }

    private void z(int i) {
        this.z = i;
    }

    public final long ao() {
        return this.A;
    }

    private void m(long j) {
        this.A = j;
    }

    public final int ap() {
        return this.y;
    }

    private void A(int i) {
        this.y = i;
    }

    public final long aq() {
        return this.k;
    }

    private void n(long j) {
        this.k = j;
    }

    public final long ar() {
        return this.l;
    }

    private void o(long j) {
        this.l = j;
    }

    public final int as() {
        return this.m;
    }

    private void B(int i) {
        this.m = i;
    }

    private int bT() {
        return this.n;
    }

    private void C(int i) {
        this.n = i;
    }

    public final int at() {
        return this.o;
    }

    private void D(int i) {
        this.o = i;
    }

    public final long au() {
        return this.p;
    }

    private void p(long j) {
        this.p = j;
    }

    public final long av() {
        return this.q;
    }

    private void q(long j) {
        this.q = j;
    }

    public final long aw() {
        return this.r;
    }

    private void r(long j) {
        this.r = j;
    }

    private int bU() {
        return this.s;
    }

    private void E(int i) {
        this.s = i;
    }

    private int bV() {
        return this.t;
    }

    private void F(int i) {
        this.t = i;
    }

    private int bW() {
        return this.u;
    }

    private void G(int i) {
        this.u = i;
    }

    public final int ax() {
        return this.v;
    }

    private void H(int i) {
        this.v = i;
    }

    private bv bX() {
        return this.F;
    }

    private void a(bv bvVar) {
        this.F = bvVar;
    }

    public final JSONArray ay() {
        return this.aV;
    }

    private void e(JSONArray jSONArray) {
        this.aV = jSONArray;
    }

    public final JSONArray az() {
        return this.aW;
    }

    private void f(JSONArray jSONArray) {
        this.aW = jSONArray;
    }

    public final JSONArray aA() {
        return this.aX;
    }

    private void g(JSONArray jSONArray) {
        this.aX = jSONArray;
    }

    public final JSONArray aB() {
        return this.aZ;
    }

    private void h(JSONArray jSONArray) {
        this.aZ = jSONArray;
    }

    private long bY() {
        return this.bS;
    }

    private void s(long j) {
        this.bS = j;
    }

    public final long aC() {
        return this.S;
    }

    private void t(long j) {
        this.S = j;
    }

    public final int aD() {
        return this.T;
    }

    private void I(int i) {
        this.T = i;
    }

    public final long aE() {
        return this.U;
    }

    private void u(long j) {
        this.U = j;
    }

    public final int aF() {
        return this.V;
    }

    private void J(int i) {
        this.V = i;
    }

    private String bZ() {
        return this.ae;
    }

    private void r(String str) {
        this.ae = str;
    }

    public final String aG() {
        return this.af;
    }

    private void s(String str) {
        this.af = str;
    }

    public final JSONArray aH() {
        return this.bc;
    }

    private void i(JSONArray jSONArray) {
        this.bc = jSONArray;
    }

    private long ca() {
        return this.al;
    }

    private void v(long j) {
        this.al = j;
    }

    private long cb() {
        return this.am;
    }

    private void w(long j) {
        this.am = j;
    }

    public final JSONArray aI() {
        return this.bd;
    }

    private void j(JSONArray jSONArray) {
        this.bd = jSONArray;
    }

    public final int aJ() {
        return this.bV;
    }

    private void K(int i) {
        this.bV = i;
    }

    public final int aK() {
        return this.bU;
    }

    private void L(int i) {
        this.bU = i;
    }

    public final double aL() {
        return this.bT;
    }

    private void c(double d) {
        this.bT = d;
    }

    private int cc() {
        return this.bW;
    }

    private void M(int i) {
        this.bW = i;
    }

    private int cd() {
        return this.bX;
    }

    private void N(int i) {
        this.bX = i;
    }

    public final int aM() {
        return this.aw;
    }

    private void O(int i) {
        this.aw = i;
    }

    private int ce() {
        return this.ax;
    }

    private void P(int i) {
        this.ax = i;
    }

    private int cf() {
        return this.aA;
    }

    private void Q(int i) {
        this.aA = i;
    }

    public final JSONObject aN() {
        return this.bY;
    }

    private void f(JSONObject jSONObject) {
        this.bY = jSONObject;
    }

    public final boolean aO() {
        return this.aC == 1;
    }

    public final boolean aP() {
        return this.aD == 1;
    }

    private void R(int i) {
        this.aD = i;
    }

    public final boolean aQ() {
        return this.aC == 2;
    }

    public final boolean aR() {
        return this.aC == 0;
    }

    public final int aS() {
        return this.aE;
    }

    private void S(int i) {
        this.aE = i;
    }

    public final int aT() {
        return this.aF;
    }

    private void T(int i) {
        this.aF = i;
    }

    public final int aU() {
        return this.aG;
    }

    private void U(int i) {
        this.aG = i;
    }

    private void a(double[][] dArr) {
        this.aH = dArr;
    }

    public final double[][] aV() {
        return this.aH;
    }

    public final int aW() {
        return this.aC;
    }

    public final void a(int i) {
        this.aC = i;
    }

    public final int aX() {
        return this.aI;
    }

    private void V(int i) {
        this.aI = i;
    }

    public final int aY() {
        return this.br;
    }

    private void W(int i) {
        this.br = i;
    }

    private int[] cg() {
        return this.bs;
    }

    private void a(int[] iArr) {
        this.bs = iArr;
    }

    private void X(int i) {
        this.bt = i;
    }

    public final boolean aZ() {
        return this.bt == 1;
    }

    public final com.anythink.core.common.h.q ba() {
        return this.aL;
    }

    public final boolean bb() {
        return this.bj == 1;
    }

    private int ch() {
        return this.bn;
    }

    private void Y(int i) {
        this.bn = i;
    }

    public final boolean bc() {
        return this.bn == 1;
    }

    public final List<com.anythink.core.common.b.d> bd() {
        return this.bO;
    }

    private void f(List<com.anythink.core.common.b.d> list) {
        this.bO = list;
    }

    public static l a(String str, JSONObject jSONObject) {
        l lVarB = b(str, jSONObject);
        if (lVarB != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ArrayList arrayList = new ArrayList();
            u.a(lVarB, concurrentHashMap, arrayList);
            lVarB.w = arrayList;
            lVarB.x = concurrentHashMap;
            com.anythink.core.common.u.t.a();
        }
        return lVarB;
    }

    public final aq be() {
        return this.bx;
    }

    public final boolean bk() {
        return this.n == 1;
    }

    private static List<ba> a(String str, String str2, long j, bc bcVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                ba baVar = new ba();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                baVar.b(jSONObjectOptJSONObject.optString("o_id"));
                baVar.c(jSONObjectOptJSONObject.optString("c_id"));
                baVar.d(jSONObjectOptJSONObject.optString("t"));
                baVar.o(jSONObjectOptJSONObject.optString("p_g"));
                baVar.e(jSONObjectOptJSONObject.optString(d.a));
                baVar.f(jSONObjectOptJSONObject.optString("ic_u"));
                baVar.g(jSONObjectOptJSONObject.optString("im_u"));
                baVar.h(jSONObjectOptJSONObject.optString("f_i_u"));
                baVar.i(jSONObjectOptJSONObject.optString("a_c_u"));
                baVar.j(jSONObjectOptJSONObject.optString("c_t"));
                baVar.k(jSONObjectOptJSONObject.optString("v_u"));
                baVar.b(jSONObjectOptJSONObject.optInt("l_t"));
                baVar.l(jSONObjectOptJSONObject.optString("p_u"));
                baVar.m(jSONObjectOptJSONObject.optString("dl"));
                baVar.n(jSONObjectOptJSONObject.optString("c_u"));
                baVar.B(jSONObjectOptJSONObject.optString("ip_u"));
                baVar.C(jSONObjectOptJSONObject.optString("t_u"));
                baVar.D(jSONObjectOptJSONObject.optString("t_u_25"));
                baVar.E(jSONObjectOptJSONObject.optString("t_u_50"));
                baVar.F(jSONObjectOptJSONObject.optString("t_u_75"));
                baVar.G(jSONObjectOptJSONObject.optString("t_u_100"));
                baVar.H(jSONObjectOptJSONObject.optString("s_e_c_t_u"));
                baVar.I(jSONObjectOptJSONObject.optString("c_t_u"));
                baVar.J(jSONObjectOptJSONObject.optString("ip_n_u"));
                baVar.K(jSONObjectOptJSONObject.optString("c_n_u"));
                baVar.c = jSONObjectOptJSONObject.optInt("o_a_d_c");
                baVar.d = jSONObjectOptJSONObject.optLong("o_a_p");
                baVar.a(j);
                baVar.a(jSONObjectOptJSONObject.optInt("unit_type"));
                baVar.d(jSONObjectOptJSONObject.optInt("c_m"));
                baVar.x(jSONObjectOptJSONObject.optString("ext_h_pic"));
                baVar.y(jSONObjectOptJSONObject.optString("ext_big_h_pic"));
                baVar.z(jSONObjectOptJSONObject.optString("ext_rect_h_pic"));
                baVar.A(jSONObjectOptJSONObject.optString("ext_home_h_pic"));
                baVar.w(str2);
                baVar.p(jSONObjectOptJSONObject.optString("pub"));
                baVar.q(jSONObjectOptJSONObject.optString("app_vc"));
                baVar.r(jSONObjectOptJSONObject.optString("pvc"));
                baVar.s(jSONObjectOptJSONObject.optString("pms"));
                baVar.a((y) bcVar);
                arrayList.add(baVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final ba b(String str) {
        List<ba> list = this.W;
        if (list == null) {
            return null;
        }
        for (ba baVar : list) {
            if (baVar.f() == null) {
                baVar.a((y) this.X);
            }
            if (TextUtils.equals(str, baVar.h()) && !baVar.a(this.X)) {
                return baVar;
            }
        }
        return null;
    }

    public final boolean bl() {
        return System.currentTimeMillis() - this.bS > this.k;
    }

    public final boolean bm() {
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.bS > ((long) this.bv);
    }

    public final Map<String, Object> a(String str, String str2, by byVar, ATAdRequest aTAdRequest) {
        com.anythink.core.common.h.q qVar;
        ad adVarY;
        int iA;
        Map<String, Object> mapS = byVar.s();
        boolean zB = com.anythink.core.common.u.o.b();
        b bVarB = d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        if (!TextUtils.isEmpty(byVar.L())) {
            mapS.put("payload", byVar.L());
            if (byVar.Y() != null && !TextUtils.isEmpty(byVar.Y().q())) {
                mapS.put("bidtoken", byVar.Y().q());
            }
        }
        if (!TextUtils.isEmpty(byVar.ad())) {
            mapS.put("custom_inhouse_bid_result", byVar.ad());
        }
        mapS.put("app_ccpa_switch", Boolean.valueOf(bVarB.s() == 3));
        mapS.put("app_coppa_switch", Boolean.valueOf(bVarB.t() == 2 && zB));
        mapS.put("gdpr_consent", Boolean.valueOf(com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b(byVar.n())));
        if (byVar.n() == 66 && byVar.Y() != null && (iA = byVar.Y().a(this.y)) >= 0) {
            mapS.put("ad_type", Integer.valueOf(iA));
        } else {
            mapS.put("ad_type", Integer.valueOf(byVar.ak()));
        }
        if (this.ax == 1) {
            mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID, str + "_" + this.G + "_" + this.v + "_" + str2);
        }
        mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.STACK_INFO, com.anythink.core.common.t.a().b(str));
        if (byVar.n() == 28 && (adVarY = byVar.Y()) != null) {
            mapS.put("anythink_gsp", Double.valueOf(com.anythink.core.common.u.o.a(byVar) * adVarY.l));
        }
        String strN = com.anythink.core.common.u.l.n();
        if (!TextUtils.isEmpty(strN)) {
            mapS.put(ATAdConst.KEY.WECHAT_APPID, strN);
        }
        if (byVar.n() == 35 || byVar.y() == 3 || byVar.y() == 4 || byVar.y() == 7) {
            x xVar = new x();
            xVar.i = byVar.L();
            xVar.j = byVar.n();
            xVar.e = byVar.G();
            xVar.f = str2;
            xVar.a = str;
            xVar.c = this.G;
            xVar.d = this.v;
            xVar.b = this.y;
            xVar.k = byVar.o();
            if (aTAdRequest != null) {
                xVar.m = aTAdRequest.getChannelSource();
            }
            xVar.o = byVar.r();
            ad adVarY2 = byVar.Y();
            if (adVarY2 != null) {
                xVar.n = adVarY2.a(this.y);
                xVar.h = adVarY2.w();
                xVar.g = adVarY2.getOriginRequestId();
            } else {
                xVar.n = -1;
            }
            xVar.l = adVarY2 != null ? adVarY2.g : "";
            xVar.q = adVarY2 != null ? adVarY2.h : "";
            if (byVar.n() == 35) {
                xVar.t = this.X;
            } else {
                xVar.t = bm.u(this.bR);
            }
            if (xVar.t != null) {
                xVar.t.r(this.y);
            }
            xVar.p = adVarY2 != null ? adVarY2.f : 0L;
            xVar.r = this.bW;
            xVar.s = this.bX;
            try {
                mapS.put(com.anythink.core.bridge.a.C0010a.d, bf());
                com.anythink.core.common.d.s sVarB = com.anythink.core.common.d.s.b();
                com.anythink.core.bridge.entity.e eVar = new com.anythink.core.bridge.entity.e();
                com.anythink.core.bridge.entity.g gVar = new com.anythink.core.bridge.entity.g(xVar);
                com.anythink.core.bridge.entity.f fVar = new com.anythink.core.bridge.entity.f();
                com.anythink.core.bridge.entity.c cVar = new com.anythink.core.bridge.entity.c();
                if (byVar != null && byVar.Y() != null) {
                    cVar = byVar.Y().z();
                }
                eVar.a(gVar);
                eVar.a(fVar);
                eVar.a(cVar);
                mapS.put(com.anythink.core.bridge.a.C0010a.c, com.anythink.core.bridge.c.a(eVar));
                com.anythink.core.bridge.entity.d dVar = new com.anythink.core.bridge.entity.d();
                dVar.e(com.anythink.core.common.u.l.i());
                dVar.b(com.anythink.core.common.u.l.H());
                mapS.put(com.anythink.core.bridge.a.C0010a.a, com.anythink.core.bridge.c.a(dVar));
                com.anythink.core.bridge.entity.a aVar = new com.anythink.core.bridge.entity.a();
                aVar.a();
                aVar.a(com.anythink.core.common.u.o.a());
                aVar.b(com.anythink.core.common.d.s.b().p());
                aVar.c(com.anythink.core.common.d.s.b().q());
                mapS.put(com.anythink.core.bridge.a.C0010a.b, com.anythink.core.bridge.c.a(aVar));
                ATUserDeviceInfo aTUserDeviceInfoQ = sVarB.Q();
                if (aTUserDeviceInfoQ != null) {
                    mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_USER_DEVICE_INFO, aTUserDeviceInfoQ);
                }
                String[] strArrF = sVarB.f();
                if (strArrF != null && strArrF.length > 0) {
                    mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO, strArrF);
                }
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_ID, sVarB.p());
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_KEY, sVarB.q());
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID, xVar.a);
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_SYSTEM_DEV_FRAMEWORK_TYPE, com.anythink.core.common.u.l.l());
                Location locationT = sVarB.t();
                if (locationT != null) {
                    mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_LOCATION, locationT);
                }
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_WX_INSTALL_STATUS, Boolean.valueOf(sVarB.s()));
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DELAY_INSPECT_TIME, Long.valueOf(ATSDKGlobalSetting.mDelayInspectTime));
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_INSPECT_INTERVAL, Long.valueOf(ATSDKGlobalSetting.mInspectInterval));
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_RUNNING_APP_PROCESSES, Boolean.valueOf(ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses() ? false : true));
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_DEVICE_INFO_IN_BG, Boolean.valueOf(ATSDKGlobalSetting.enableGetDeviceInfoInBg));
                mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_EXCLUDE_PKG_LIST, com.anythink.core.common.d.s.b().k());
            } catch (Throwable unused) {
            }
        }
        if (byVar.n() == 50 && this.aA == 1) {
            mapS.put("pangle_request_id", str2);
        }
        ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB;
        if (TextUtils.equals(byVar.aC(), com.anythink.core.common.d.i.k.a)) {
            currency = ATAdConst.CURRENCY.USD;
        }
        mapS.put("gm_currency", currency);
        if (byVar.n() == 2) {
            mapS.put("anythink_g_ra_label", byVar.aL());
            mapS.put("admob_init_mode", Integer.valueOf(bVarB.aq()));
            mapS.put("admob_adsource_id", byVar.G());
            if (byVar.aV() == 1 && (qVar = this.aL) != null) {
                mapS.put("admob_hybrid_status", Boolean.valueOf(qVar.a()));
                if (this.aL.a() || this.aL.b) {
                    mapS.put("mediation_request_id", str2);
                }
            }
        }
        if (byVar.ak() == 0) {
            mapS.put(a.aq, Integer.valueOf(this.br));
            if (byVar.aN() == null) {
                mapS.put(a.ar, this.bs);
            } else {
                mapS.put(a.ar, byVar.aN());
            }
            mapS.put("nw_firm_id", Integer.valueOf(byVar.n()));
        }
        JSONObject jSONObjectR = bVarB.R();
        if (jSONObjectR != null) {
            try {
                String string = jSONObjectR.getString(String.valueOf(byVar.n()));
                if (!TextUtils.isEmpty(string)) {
                    mapS.put("network_ext", string);
                }
            } catch (Exception unused2) {
            }
        }
        JSONArray jSONArrayAQ = byVar.aQ();
        if (jSONArrayAQ != null && jSONArrayAQ.length() > 0) {
            mapS.put("web_content_urls", jSONArrayAQ);
        }
        int iAR = byVar.aR();
        if (iAR > 0) {
            mapS.put(com.anythink.core.common.k.aA, Integer.valueOf(iAR));
        }
        mapS.put("ad_s_reqf_mode", Integer.valueOf(byVar.aS()));
        mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, Integer.valueOf(this.y));
        mapS.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GM_REFRESH_KEY, Boolean.valueOf(bVarB.ao()));
        if (byVar.n() == 8) {
            mapS.put("load_params_switch", Integer.valueOf(byVar.bb()));
        }
        if (byVar.n() == 39) {
            mapS.put("bid_max_time", Long.valueOf(byVar.bi()));
            mapS.put("splash_type", Integer.valueOf(byVar.bl()));
        }
        if (byVar.n() == 77) {
            mapS.put("mediation_request_id", str2);
        }
        if (byVar.n() == 22) {
            mapS.put("bd_imp_type", Integer.valueOf(byVar.ar()));
        }
        mapS.put("c_b_i_r", Integer.valueOf(byVar.e()));
        return mapS;
    }

    public final boolean bn() {
        return !TextUtils.isEmpty(this.bp);
    }

    public final Boolean bo() {
        return this.bu;
    }

    public final void a(Boolean bool) {
        this.bu = bool;
    }

    public final int bp() {
        return this.bv;
    }

    private void Z(int i) {
        this.bv = i;
    }

    private String cj() {
        return this.bw;
    }

    private void t(String str) {
        this.bw = str;
    }

    private void a(aq aqVar) {
        this.bx = aqVar;
    }

    public final int bq() {
        return this.by;
    }

    private void aa(int i) {
        this.by = i;
    }

    public final boolean br() {
        return this.aM;
    }

    public final void bs() {
        this.aM = true;
    }

    public final JSONArray bt() {
        return this.bf;
    }

    private void k(JSONArray jSONArray) {
        this.bf = jSONArray;
    }

    public final JSONArray bu() {
        return this.bg;
    }

    private void l(JSONArray jSONArray) {
        this.bg = jSONArray;
    }

    public final int bv() {
        return this.bz;
    }

    private void ab(int i) {
        this.bz = i;
    }

    public final int bw() {
        return this.bA;
    }

    private void ac(int i) {
        this.bA = i;
    }

    public final int bx() {
        return this.bB;
    }

    private void ad(int i) {
        this.bB = i;
    }

    public final aj by() {
        return this.bC;
    }

    private void a(aj ajVar) {
        this.bC = ajVar;
    }

    public final List<String> bz() {
        return this.bD;
    }

    private void g(List<String> list) {
        this.bD = list;
    }

    public final JSONObject bA() {
        return this.bE;
    }

    private void g(JSONObject jSONObject) {
        this.bE = jSONObject;
    }

    public final int bB() {
        return this.bF;
    }

    private void ae(int i) {
        this.bF = i;
    }

    public final int bC() {
        return this.bG;
    }

    private void af(int i) {
        this.bG = i;
    }

    public final int bD() {
        return this.bH;
    }

    private void ag(int i) {
        this.bH = i;
    }

    public final int bE() {
        return this.bM;
    }

    private void ah(int i) {
        this.bM = i;
    }

    public final JSONObject bF() {
        return this.bI;
    }

    private void h(JSONObject jSONObject) {
        this.bI = jSONObject;
    }

    public final int bG() {
        return this.bJ;
    }

    private void ai(int i) {
        this.bJ = i;
    }

    public final long bH() {
        return this.bK;
    }

    public final int bI() {
        return this.bL;
    }

    public final void b(int i) {
        this.bL = i;
    }

    public final boolean bJ() {
        int i = this.bL;
        return i == 2 || i == 5;
    }

    public final long bK() {
        return this.bN;
    }

    private void x(long j) {
        this.bN = j;
    }

    private void aj(int i) {
        this.bZ = i;
    }

    private void y(long j) {
        this.ca = j;
    }

    public final boolean bL() {
        return this.bZ == 1;
    }

    public final long bM() {
        return this.ca;
    }

    public final int r() {
        return this.bj == 1 ? 2 : 1;
    }

    public final int H() {
        int i = this.aN;
        if (i != -1 && this.aO == 1) {
            this.ao = i;
        }
        return this.ao;
    }

    private by ci() {
        List<by> listA = u.a(this, this.aY);
        if (listA.size() > 0) {
            return listA.get(0);
        }
        return null;
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return (TextUtils.equals(this.E, lVar.E) || bg()) ? false : true;
    }
}
