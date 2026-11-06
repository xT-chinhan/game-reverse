package com.anythink.core.d;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.common.d.v;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.ap;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.ba;
import com.anythink.core.common.h.bk;
import com.anythink.core.common.h.bt;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.tapsdk.tapad.constants.Constants;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
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
    private bt F;
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
    private List<ay> W;
    private ba X;
    private long Y;
    private double Z;
    private int aA;
    private int aB;
    private int aD;
    private double[][] aH;
    private int aJ;
    private f aK;
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
    private ai bB;
    private List<String> bC;
    private JSONObject bD;
    private JSONObject bH;
    private long bJ;
    private int bK;
    private int bM;
    private String bN;
    private String bO;
    private long bP;
    private double bQ;
    private int bR;
    private int bS;
    private int bT;
    private int bU;
    private JSONObject bV;
    private JSONArray ba;
    private JSONArray bb;
    private JSONArray bc;
    private JSONArray bd;
    private JSONArray be;
    private JSONArray bf;
    private JSONArray bg;
    private long bh;
    private int bi;
    private int bj;
    private int bk;
    private List<Integer> bl;
    private int bn;
    private String bo;
    private int bp;
    private int bq;
    private int[] br;
    private Boolean bt;
    private int bu;
    private String bv;
    private ap bw;
    private int bx;
    private int by;
    private int bz;
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
    private List<bv> w;
    private Map<String, bv> x;
    private int y;
    private int z;
    private int aC = 0;
    private int aE = 10;
    private int aF = 10;
    private int aG = 2;
    private int aI = 1;
    private com.anythink.core.common.h.q aL = new com.anythink.core.common.h.q();
    private int bm = 2;
    private int bs = 2;
    private int bE = 1;
    private int bF = 10000;
    private int bG = 3000;
    private int bI = 1;
    private int bL = 2;

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
        private static final String aT = "ps_id_timeout";
        private static final String aU = "ps_ct";
        private static final String aV = "ps_ct_out";
        private static final String aW = "pucs";
        private static final String aX = "ad_delivery_sw";
        private static final String aY = "req_ug_num";
        private static final String aZ = "unit_caps_d";
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
        private static final String bA = "sc_list";
        private static final String bB = "rw_n";
        private static final String bC = "rw_num";
        private static final String bD = "reward";
        private static final String bE = "currency";
        private static final String bF = "cc";
        private static final String bG = "exch_r";
        private static final String bH = "acct_cy";
        private static final String bI = "req_ug_type_v2";
        private static final String bJ = "device_perf_sw";
        private static final String bK = "max_cached_num";
        private static final String bL = "wf_req_wait_t";
        private static final String bM = "c2s_req_wait_t";
        private static final String bN = "s2s_req_wait_t";
        private static final String bO = "auto_req_type";
        private static final String bP = "auto_refresh_type_v2";
        private static final String ba = "unit_caps_h";
        private static final String bb = "unit_pacing";
        private static final String bc = "wifi_auto_sw";
        private static final String bd = "show_type";
        private static final String be = "refresh";
        private static final String bf = "ug_list";
        private static final String bg = "ol_list";
        private static final String bh = "gro_id";
        private static final String bi = "hb_list";
        private static final String bj = "s2shb_list";
        private static final String bk = "format";
        private static final String bl = "auto_refresh";
        private static final String bm = "auto_refresh_time";
        private static final String bn = "s_t";
        private static final String bo = "l_s_t";
        private static final String bp = "ra";
        private static final String bq = "asid";
        private static final String br = "tp_ps";
        private static final String bs = "t_g_id";
        private static final String bt = "s_id";
        private static final String bu = "u_n_f_sw";
        private static final String bv = "m_o";
        private static final String bw = "m_o_s";
        private static final String bx = "m_o_ks";
        private static final String by = "p_m_o";
        private static final String bz = "callback";
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

    private void e(int i) {
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

    private void f(int i) {
        this.aT = i;
    }

    public final int h() {
        return this.aU;
    }

    private void g(int i) {
        this.aU = i;
    }

    private l(String str) {
        this.j = str;
    }

    public final String i() {
        return this.j;
    }

    public final f j() {
        return this.aK;
    }

    private void a(f fVar) {
        this.aK = fVar;
    }

    public final int k() {
        return this.aJ;
    }

    private void h(int i) {
        this.aJ = i;
    }

    public final int l() {
        return this.aB;
    }

    private void i(int i) {
        this.aB = i;
    }

    public final List<Integer> m() {
        return this.bl;
    }

    private void a(List<Integer> list) {
        this.bl = list;
    }

    public final int n() {
        return this.bj;
    }

    private void j(int i) {
        this.bj = i;
    }

    public final int o() {
        return this.bk;
    }

    private void k(int i) {
        this.bk = i;
    }

    public final int p() {
        return this.bi;
    }

    private void l(int i) {
        this.bi = i;
    }

    public final long r() {
        return this.bh;
    }

    private void d(long j) {
        this.bh = j;
    }

    public final ATAdRequest s() {
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
            lVar.bJ = System.currentTimeMillis();
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
            if (jSONObject.isNull("format")) {
                lVar.y = 0;
            } else {
                lVar.y = jSONObject.optInt("format");
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
            if (jSONObject.isNull(com.anythink.core.common.k.N)) {
                lVar.C = 1800000L;
            } else {
                lVar.C = jSONObject.optLong(com.anythink.core.common.k.N);
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
                    bt btVar = new bt();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tp_ps");
                    btVar.a = jSONObjectOptJSONObject.optInt("pucs") == 1;
                    btVar.b = jSONObjectOptJSONObject.optLong("apdt");
                    btVar.c = jSONObjectOptJSONObject.optInt("aprn");
                    btVar.d = jSONObjectOptJSONObject.optInt("puas") == 1;
                    btVar.e = jSONObjectOptJSONObject.optLong("cdt");
                    btVar.f = jSONObjectOptJSONObject.optInt("ski_swt") == 1;
                    btVar.g = jSONObjectOptJSONObject.optInt("aut_swt") == 1;
                    lVar.F = btVar;
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
                lVar.bP = jOptLong;
            } else {
                lVar.bP = 0L;
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
                lVar.X = ba.u(jSONObject.optString("m_o_s"));
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
            if (!jSONObject.isNull(com.anythink.core.common.m.s.b)) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(com.anythink.core.common.m.s.b));
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
                if (!jSONObject3.isNull(Constants.AdTypeName.REWARD)) {
                    JSONObject jSONObject6 = new JSONObject(jSONObject3.optString(Constants.AdTypeName.REWARD));
                    ATRewardInfo aTRewardInfo2 = new ATRewardInfo();
                    if (!jSONObject6.isNull("rw_n")) {
                        aTRewardInfo2.rewardName = jSONObject6.optString("rw_n");
                    }
                    if (!jSONObject6.isNull("rw_num")) {
                        aTRewardInfo2.rewardNumber = jSONObject6.optInt("rw_num");
                    }
                    lVar.N = aTRewardInfo2;
                }
                if (!jSONObject3.isNull(DeepLinkPresetEvent.UMEventParamCurrency)) {
                    lVar.O = jSONObject3.optString(DeepLinkPresetEvent.UMEventParamCurrency);
                }
                if (!jSONObject3.isNull(com.umeng.ccg.a.a)) {
                    lVar.P = jSONObject3.optString(com.umeng.ccg.a.a);
                }
                if (!jSONObject3.isNull("exch_r")) {
                    lVar.Z = jSONObject3.optDouble("exch_r", 0.0d);
                }
                if (!jSONObject3.isNull("acct_cy")) {
                    lVar.aa = jSONObject3.optString("acct_cy");
                }
            }
            if (jSONObject.isNull(a.a)) {
                lVar.Q = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            } else {
                lVar.Q = jSONObject.optLong(a.a);
            }
            if (jSONObject.isNull(a.b)) {
                lVar.R = "";
            } else {
                lVar.R = jSONObject.optString(a.b);
            }
            if (jSONObject.isNull(a.c)) {
                lVar.S = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
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
                lVar.bN = null;
            } else {
                lVar.bN = jSONObject.optString(a.i);
            }
            if (jSONObject.isNull(a.h)) {
                lVar.bO = "";
            } else {
                lVar.bO = jSONObject.optString(a.h);
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
                lVar.am = com.anythink.basead.exoplayer.i.a.f;
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
                    new StringBuilder("requestUnitGroupType error: ").append(iOptInt3);
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
                lVar.ar = com.anythink.basead.exoplayer.i.a.f;
            } else {
                lVar.ar = jSONObject.optLong(a.F);
            }
            if (jSONObject.isNull(a.G)) {
                lVar.bd = new JSONArray();
            } else {
                lVar.bd = jSONObject.optJSONArray(a.G);
            }
            if (jSONObject.isNull("bid_floor")) {
                lVar.bQ = 0.0d;
            } else {
                lVar.bQ = jSONObject.optDouble("bid_floor");
            }
            if (jSONObject.isNull(a.I)) {
                lVar.as = null;
            } else {
                lVar.as = jSONObject.optJSONObject(a.I);
            }
            if (jSONObject.isNull(a.K)) {
                lVar.bR = 0;
            } else {
                lVar.bR = jSONObject.optInt(a.K);
            }
            if (jSONObject.isNull(a.L)) {
                lVar.bS = 2;
            } else {
                lVar.bS = jSONObject.optInt(a.L);
            }
            if (jSONObject.isNull(a.M)) {
                lVar.bU = 0;
            } else {
                lVar.bU = jSONObject.optInt(a.M);
            }
            if (jSONObject.isNull(a.N)) {
                lVar.bT = 0;
            } else {
                lVar.bT = jSONObject.optInt(a.N);
            }
            if (jSONObject.isNull("is_test")) {
                lVar.bM = 2;
            } else {
                lVar.bM = jSONObject.optInt("is_test");
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
                lVar.bV = jSONObject.optJSONObject(a.aa);
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
            lVar.bh = jSONObject.optLong(a.ai, com.anythink.basead.exoplayer.i.a.f);
            lVar.bi = jSONObject.optInt(a.aj, 2);
            int iOptInt4 = jSONObject.optInt(a.ak, 1);
            if (iOptInt4 != 1 && iOptInt4 != 2) {
                new StringBuilder("filledLoadRequestType error: ").append(iOptInt4);
                iOptInt4 = 1;
            }
            lVar.bj = iOptInt4;
            int iOptInt5 = jSONObject.optInt(a.al, 1);
            if (iOptInt5 <= 0) {
                iOptInt5 = 1;
            }
            lVar.bk = iOptInt5;
            lVar.bn = jSONObject.optInt(a.am, 0);
            lVar.bo = jSONObject.optString(a.an, "");
            lVar.bp = jSONObject.optInt("s2s_sw", 2);
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray(a.ap);
            if (jSONArrayOptJSONArray5 != null && (length = jSONArrayOptJSONArray5.length()) > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < length; i4++) {
                    Object obj2 = jSONArrayOptJSONArray5.get(i4);
                    if (obj2 instanceof Integer) {
                        arrayList3.add((Integer) obj2);
                    }
                }
                lVar.bl = arrayList3;
            }
            lVar.bq = jSONObject.optInt(a.aq, 1);
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
            lVar.br = iArr;
            lVar.aJ = jSONObject.optInt(a.as, 1);
            if (jSONObject.optInt(a.at, 2) == 1) {
                lVar.aK = f.a(jSONObject.optString(a.au));
            } else {
                lVar.aK = null;
            }
            lVar.aC = jSONObject.optInt(a.av, 0);
            lVar.bs = jSONObject.optInt(a.aw, 2);
            lVar.bm = jSONObject.optInt(a.ax);
            lVar.bu = jSONObject.optInt(a.ay, 604800000);
            lVar.bv = jSONObject.optString(a.az);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(a.aB);
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                ap apVar = new ap();
                apVar.a(jSONObject.optString("unique_id"));
                apVar.c(jSONObjectOptJSONObject2.optString(a.aC));
                apVar.a(jSONObjectOptJSONObject2.optInt(a.aD));
                apVar.b(jSONObjectOptJSONObject2.optInt("c_id"));
                lVar.bw = apVar;
            }
            com.anythink.core.common.v.t.a(lVar.aj);
            lVar.bx = jSONObject.optInt(a.aF, -1);
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
            lVar.by = jSONObject.optInt(a.aI, -1);
            lVar.bz = jSONObject.optInt(a.aJ, -1);
            lVar.bA = jSONObject.optInt(a.aK, 2000);
            lVar.bB = ai.a(jSONObject);
            lVar.bC = com.anythink.core.common.v.q.b(jSONObject.optJSONArray(a.aL));
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(a.aM);
            if (jSONObjectOptJSONObject3 != null) {
                lVar.bD = jSONObjectOptJSONObject3;
            }
            lVar.bE = jSONObject.optInt(a.aN, 1);
            lVar.bF = jSONObject.optInt(a.aO, 10000);
            lVar.bG = jSONObject.optInt(a.aP, 3000);
            lVar.bL = jSONObject.optInt(a.aQ, 2);
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(a.aR);
            if (jSONObjectOptJSONObject4 != null) {
                lVar.bH = jSONObjectOptJSONObject4;
            }
            lVar.bI = jSONObject.optInt(a.aS, 2);
            lVar.aN = jSONObject.optInt("req_ug_type_v2", -1);
            lVar.aO = jSONObject.optInt("device_perf_sw", 0);
            lVar.aP = jSONObject.optInt("max_cached_num", -1);
            lVar.aQ = jSONObject.optLong("wf_req_wait_t", 0L);
            lVar.aR = jSONObject.optLong("c2s_req_wait_t", 0L);
            lVar.aS = jSONObject.optLong("s2s_req_wait_t", 0L);
            lVar.aT = jSONObject.optInt("auto_req_type", -1);
            lVar.aU = jSONObject.optInt("auto_refresh_type_v2", -1);
            return lVar;
        } catch (Exception unused4) {
            return null;
        }
    }

    public final int t() {
        return this.bn;
    }

    private void m(int i) {
        this.bn = i;
    }

    public final String u() {
        return this.bo;
    }

    private void c(String str) {
        this.bo = str;
    }

    public final int v() {
        return this.bp;
    }

    private void n(int i) {
        this.bp = i;
    }

    private void a(Map<String, bv> map) {
        this.x = map;
    }

    public final Map<String, bv> w() {
        return this.x;
    }

    public final bv a(String str) {
        Map<String, bv> map = this.x;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final List<bv> x() {
        return this.w;
    }

    private void b(List<bv> list) {
        this.w = list;
    }

    public final int y() {
        return this.az;
    }

    private void o(int i) {
        this.az = i;
    }

    public final List<Integer> z() {
        return this.ay;
    }

    private void c(List<Integer> list) {
        this.ay = list;
    }

    public final String A() {
        return this.av;
    }

    private void d(String str) {
        this.av = str;
    }

    public final String B() {
        return this.au;
    }

    private void e(String str) {
        this.au = str;
    }

    public final JSONObject C() {
        return this.at;
    }

    private void a(JSONObject jSONObject) {
        this.at = jSONObject;
    }

    private JSONObject bK() {
        return this.as;
    }

    private void e(JSONObject jSONObject) {
        this.as = jSONObject;
    }

    public final int D() {
        return this.bM;
    }

    private void p(int i) {
        this.bM = i;
    }

    public final long E() {
        return this.ar;
    }

    private void e(long j) {
        this.ar = j;
    }

    public final int F() {
        return this.aq;
    }

    private void q(int i) {
        this.aq = i;
    }

    private void r(int i) {
        this.ao = i;
    }

    private void s(int i) {
        this.ap = i;
    }

    public final int H() {
        int i = this.ao;
        if (i == 1) {
            return this.o;
        }
        if (i != 2) {
            return 1;
        }
        return this.ap;
    }

    public final long I() {
        return this.an;
    }

    private void f(long j) {
        this.an = j;
    }

    public final JSONArray J() {
        return this.be;
    }

    private void a(JSONArray jSONArray) {
        this.be = jSONArray;
    }

    public final long K() {
        return this.ak;
    }

    private void g(long j) {
        this.ak = j;
    }

    public final double L() {
        return this.aj;
    }

    private void a(double d) {
        this.aj = d;
    }

    public final String M() {
        return this.ah;
    }

    private void f(String str) {
        this.ah = str;
    }

    public final String N() {
        return this.ai;
    }

    private void g(String str) {
        this.ai = str;
    }

    public final JSONArray O() {
        return this.bb;
    }

    private void b(JSONArray jSONArray) {
        this.bb = jSONArray;
    }

    public final long P() {
        return this.ag;
    }

    private void h(long j) {
        this.ag = j;
    }

    public final String Q() {
        return this.ad;
    }

    private void h(String str) {
        this.ad = str;
    }

    public final String R() {
        return this.ac;
    }

    private void i(String str) {
        this.ac = str;
    }

    public final List<String> S() {
        return this.ab;
    }

    private void d(List<String> list) {
        this.ab = list;
    }

    public final double T() {
        return this.Z;
    }

    private void b(double d) {
        this.Z = d;
    }

    public final String U() {
        return this.aa;
    }

    private void j(String str) {
        this.aa = str;
    }

    public final long V() {
        return this.Y;
    }

    private void i(long j) {
        this.Y = j;
    }

    public final JSONArray W() {
        return this.ba;
    }

    private void c(JSONArray jSONArray) {
        this.ba = jSONArray;
    }

    public final String X() {
        return this.bN;
    }

    private void k(String str) {
        this.bN = str;
    }

    private String bL() {
        return this.bO;
    }

    private void l(String str) {
        this.bO = str;
    }

    public final JSONArray Y() {
        return this.aY;
    }

    private void d(JSONArray jSONArray) {
        this.aY = jSONArray;
    }

    private void a(ba baVar) {
        this.X = baVar;
    }

    public final ba Z() {
        return this.X;
    }

    public final List<ay> aa() {
        return this.W;
    }

    private void e(List<ay> list) {
        this.W = list;
    }

    private String bM() {
        return this.R;
    }

    private void m(String str) {
        this.R = str;
    }

    public final long ab() {
        return this.Q;
    }

    private void j(long j) {
        this.Q = j;
    }

    public final Map<String, ATRewardInfo> ac() {
        return this.M;
    }

    public final String ad() {
        return this.O;
    }

    private void n(String str) {
        this.O = str;
    }

    public final String ae() {
        return this.P;
    }

    private void o(String str) {
        this.P = str;
    }

    private void b(Map<String, ATRewardInfo> map) {
        this.M = map;
    }

    public final ATRewardInfo af() {
        return this.N;
    }

    private void a(ATRewardInfo aTRewardInfo) {
        this.N = aTRewardInfo;
    }

    public final Map<String, Object> ag() {
        return this.L;
    }

    private void c(Map<String, Object> map) {
        this.L = map;
    }

    public final int ah() {
        return this.J;
    }

    private void t(int i) {
        this.J = i;
    }

    public final int ai() {
        return this.G;
    }

    private void u(int i) {
        this.G = i;
    }

    public final String aj() {
        return this.H;
    }

    private void p(String str) {
        this.H = str;
    }

    public final int ak() {
        return this.I;
    }

    private void v(int i) {
        this.I = i;
    }

    public final long al() {
        return this.B;
    }

    private void k(long j) {
        this.B = j;
    }

    public final long am() {
        return this.C;
    }

    private void l(long j) {
        this.C = j;
    }

    private int bN() {
        return this.D;
    }

    private void w(int i) {
        this.D = i;
    }

    public final String an() {
        return this.E;
    }

    private void q(String str) {
        this.E = str;
    }

    public final int ao() {
        return this.z;
    }

    private void x(int i) {
        this.z = i;
    }

    public final long ap() {
        return this.A;
    }

    private void m(long j) {
        this.A = j;
    }

    public final int aq() {
        return this.y;
    }

    private void y(int i) {
        this.y = i;
    }

    public final long ar() {
        return this.k;
    }

    private void n(long j) {
        this.k = j;
    }

    public final long as() {
        return this.l;
    }

    private void o(long j) {
        this.l = j;
    }

    public final int at() {
        return this.m;
    }

    private void z(int i) {
        this.m = i;
    }

    private int bO() {
        return this.n;
    }

    private void A(int i) {
        this.n = i;
    }

    public final int au() {
        return this.o;
    }

    private void B(int i) {
        this.o = i;
    }

    public final long av() {
        return this.p;
    }

    private void p(long j) {
        this.p = j;
    }

    public final long aw() {
        return this.q;
    }

    private void q(long j) {
        this.q = j;
    }

    public final long ax() {
        return this.r;
    }

    private void r(long j) {
        this.r = j;
    }

    private int bP() {
        return this.s;
    }

    private void C(int i) {
        this.s = i;
    }

    private int bQ() {
        return this.t;
    }

    private void D(int i) {
        this.t = i;
    }

    private int bR() {
        return this.u;
    }

    private void E(int i) {
        this.u = i;
    }

    public final int ay() {
        return this.v;
    }

    private void F(int i) {
        this.v = i;
    }

    private bt bS() {
        return this.F;
    }

    private void a(bt btVar) {
        this.F = btVar;
    }

    public final JSONArray az() {
        return this.aV;
    }

    private void e(JSONArray jSONArray) {
        this.aV = jSONArray;
    }

    public final JSONArray aA() {
        return this.aW;
    }

    private void f(JSONArray jSONArray) {
        this.aW = jSONArray;
    }

    public final JSONArray aB() {
        return this.aX;
    }

    private void g(JSONArray jSONArray) {
        this.aX = jSONArray;
    }

    public final JSONArray aC() {
        return this.aZ;
    }

    private void h(JSONArray jSONArray) {
        this.aZ = jSONArray;
    }

    private long bT() {
        return this.bP;
    }

    private void s(long j) {
        this.bP = j;
    }

    public final long aD() {
        return this.S;
    }

    private void t(long j) {
        this.S = j;
    }

    public final int aE() {
        return this.T;
    }

    private void G(int i) {
        this.T = i;
    }

    public final long aF() {
        return this.U;
    }

    private void u(long j) {
        this.U = j;
    }

    public final int aG() {
        return this.V;
    }

    private void H(int i) {
        this.V = i;
    }

    private String bU() {
        return this.ae;
    }

    private void r(String str) {
        this.ae = str;
    }

    public final String aH() {
        return this.af;
    }

    private void s(String str) {
        this.af = str;
    }

    public final JSONArray aI() {
        return this.bc;
    }

    private void i(JSONArray jSONArray) {
        this.bc = jSONArray;
    }

    private long bV() {
        return this.al;
    }

    private void v(long j) {
        this.al = j;
    }

    private long bW() {
        return this.am;
    }

    private void w(long j) {
        this.am = j;
    }

    public final JSONArray aJ() {
        return this.bd;
    }

    private void j(JSONArray jSONArray) {
        this.bd = jSONArray;
    }

    public final int aK() {
        return this.bS;
    }

    private void I(int i) {
        this.bS = i;
    }

    public final int aL() {
        return this.bR;
    }

    private void J(int i) {
        this.bR = i;
    }

    public final double aM() {
        return this.bQ;
    }

    private void c(double d) {
        this.bQ = d;
    }

    public final int aN() {
        return this.bT;
    }

    private void K(int i) {
        this.bT = i;
    }

    public final int aO() {
        return this.bU;
    }

    private void L(int i) {
        this.bU = i;
    }

    public final int aP() {
        return this.aw;
    }

    private void M(int i) {
        this.aw = i;
    }

    private int bX() {
        return this.ax;
    }

    private void N(int i) {
        this.ax = i;
    }

    private int bY() {
        return this.aA;
    }

    private void O(int i) {
        this.aA = i;
    }

    public final JSONObject aQ() {
        return this.bV;
    }

    private void f(JSONObject jSONObject) {
        this.bV = jSONObject;
    }

    public final boolean aR() {
        return this.aC == 1;
    }

    public final boolean aS() {
        return this.aD == 1;
    }

    private void P(int i) {
        this.aD = i;
    }

    public final boolean aT() {
        return this.aC == 2;
    }

    public final boolean aU() {
        return this.aC == 0;
    }

    public final int aV() {
        return this.aE;
    }

    private void Q(int i) {
        this.aE = i;
    }

    public final int aW() {
        return this.aF;
    }

    private void R(int i) {
        this.aF = i;
    }

    public final int aX() {
        return this.aG;
    }

    private void S(int i) {
        this.aG = i;
    }

    private void a(double[][] dArr) {
        this.aH = dArr;
    }

    public final double[][] aY() {
        return this.aH;
    }

    public final int bb() {
        return this.aC;
    }

    public final void a(int i) {
        this.aC = i;
    }

    public final int bc() {
        return this.aI;
    }

    private void T(int i) {
        this.aI = i;
    }

    public final int bd() {
        return this.bq;
    }

    private void U(int i) {
        this.bq = i;
    }

    private int[] bZ() {
        return this.br;
    }

    private void a(int[] iArr) {
        this.br = iArr;
    }

    private void V(int i) {
        this.bs = i;
    }

    public final boolean be() {
        return this.bs == 1;
    }

    public final com.anythink.core.common.h.q bf() {
        return this.aL;
    }

    public final boolean bg() {
        return this.bi == 1;
    }

    private int ca() {
        return this.bm;
    }

    private void W(int i) {
        this.bm = i;
    }

    public final boolean bh() {
        return this.bm == 1;
    }

    public static l a(String str, JSONObject jSONObject) {
        l lVarB = b(str, jSONObject);
        if (lVarB != null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            ArrayList arrayList = new ArrayList();
            u.a(lVarB, concurrentHashMap, arrayList);
            lVarB.w = arrayList;
            lVarB.x = concurrentHashMap;
        }
        return lVarB;
    }

    public final ap bi() {
        return this.bw;
    }

    public final boolean bj() {
        return this.n == 1;
    }

    private static List<ay> a(String str, String str2, long j, ba baVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                ay ayVar = new ay();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                ayVar.k(jSONObjectOptJSONObject.optString("o_id"));
                ayVar.l(jSONObjectOptJSONObject.optString("c_id"));
                ayVar.m(jSONObjectOptJSONObject.optString(com.umeng.analytics.pro.bv.aI));
                ayVar.x(jSONObjectOptJSONObject.optString("p_g"));
                ayVar.n(jSONObjectOptJSONObject.optString("d"));
                ayVar.o(jSONObjectOptJSONObject.optString("ic_u"));
                ayVar.p(jSONObjectOptJSONObject.optString("im_u"));
                ayVar.q(jSONObjectOptJSONObject.optString("f_i_u"));
                ayVar.r(jSONObjectOptJSONObject.optString("a_c_u"));
                ayVar.s(jSONObjectOptJSONObject.optString("c_t"));
                ayVar.t(jSONObjectOptJSONObject.optString("v_u"));
                ayVar.h(jSONObjectOptJSONObject.optInt("l_t"));
                ayVar.u(jSONObjectOptJSONObject.optString("p_u"));
                ayVar.v(jSONObjectOptJSONObject.optString("dl"));
                ayVar.w(jSONObjectOptJSONObject.optString("c_u"));
                ayVar.aa(jSONObjectOptJSONObject.optString("ip_u"));
                ayVar.ab(jSONObjectOptJSONObject.optString("t_u"));
                ayVar.ac(jSONObjectOptJSONObject.optString("t_u_25"));
                ayVar.ad(jSONObjectOptJSONObject.optString("t_u_50"));
                ayVar.ae(jSONObjectOptJSONObject.optString("t_u_75"));
                ayVar.af(jSONObjectOptJSONObject.optString("t_u_100"));
                ayVar.ag(jSONObjectOptJSONObject.optString("s_e_c_t_u"));
                ayVar.ah(jSONObjectOptJSONObject.optString("c_t_u"));
                ayVar.ai(jSONObjectOptJSONObject.optString("ip_n_u"));
                ayVar.aj(jSONObjectOptJSONObject.optString("c_n_u"));
                ayVar.c = jSONObjectOptJSONObject.optInt("o_a_d_c");
                ayVar.d = jSONObjectOptJSONObject.optLong("o_a_p");
                ayVar.b(j);
                ayVar.g(jSONObjectOptJSONObject.optInt("unit_type"));
                ayVar.a(jSONObjectOptJSONObject.optInt("c_m"));
                ayVar.b(jSONObjectOptJSONObject.optString("ext_h_pic"));
                ayVar.X(jSONObjectOptJSONObject.optString("ext_big_h_pic"));
                ayVar.Y(jSONObjectOptJSONObject.optString("ext_rect_h_pic"));
                ayVar.Z(jSONObjectOptJSONObject.optString("ext_home_h_pic"));
                ayVar.a(str2);
                ayVar.z(jSONObjectOptJSONObject.optString("pub"));
                ayVar.A(jSONObjectOptJSONObject.optString("app_vc"));
                ayVar.B(jSONObjectOptJSONObject.optString("pvc"));
                ayVar.C(jSONObjectOptJSONObject.optString("pms"));
                ayVar.c((y) baVar);
                arrayList.add(ayVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final ay b(String str) {
        List<ay> list = this.W;
        if (list == null) {
            return null;
        }
        for (ay ayVar : list) {
            if (ayVar.r() == null) {
                ayVar.c((y) this.X);
            }
            if (TextUtils.equals(str, ayVar.v()) && !ayVar.a(this.X)) {
                return ayVar;
            }
        }
        return null;
    }

    public final boolean bk() {
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.bP > this.k;
    }

    public final boolean bl() {
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.bP > ((long) this.bu);
    }

    public final Map<String, Object> a(String str, String str2, bv bvVar, ATAdRequest aTAdRequest) {
        com.anythink.core.common.h.q qVar;
        ad adVarR;
        int iA;
        Map<String, Object> mapL = bvVar.l();
        boolean zB = com.anythink.core.common.v.p.b();
        b bVarB = d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        if (!TextUtils.isEmpty(bvVar.E())) {
            mapL.put("payload", bvVar.E());
            if (bvVar.R() != null && !TextUtils.isEmpty(bvVar.R().r())) {
                mapL.put(com.anythink.core.common.d.j.w.c, bvVar.R().r());
            }
        }
        if (!TextUtils.isEmpty(bvVar.W())) {
            mapL.put("custom_inhouse_bid_result", bvVar.W());
        }
        boolean z = false;
        mapL.put(com.anythink.core.common.d.j.w.d, Boolean.valueOf(bVarB.A() == 3));
        if (bVarB.B() == 2 && zB) {
            z = true;
        }
        mapL.put(com.anythink.core.common.d.j.w.e, Boolean.valueOf(z));
        mapL.put(com.anythink.core.common.d.j.w.f, Boolean.valueOf(v.a(com.anythink.core.common.d.t.b().g()).b(bvVar.g())));
        if (bvVar.g() == 66 && bvVar.R() != null && (iA = bvVar.R().a(this.y)) >= 0) {
            mapL.put("ad_type", Integer.valueOf(iA));
        } else {
            mapL.put("ad_type", Integer.valueOf(bvVar.ae()));
        }
        if (this.ax == 1) {
            mapL.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.MEDIATION_WF_ID, str + "_" + this.G + "_" + this.v + "_" + str2);
        }
        mapL.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.STACK_INFO, com.anythink.core.common.u.a().f(str));
        if (bvVar.g() == 28 && (adVarR = bvVar.R()) != null) {
            mapL.put(com.anythink.core.common.d.j.w.m, Double.valueOf(com.anythink.core.common.v.p.a(bvVar) * adVarR.l));
        }
        String strN = com.anythink.core.common.v.m.n();
        if (!TextUtils.isEmpty(strN)) {
            mapL.put(ATAdConst.KEY.WECHAT_APPID, strN);
        }
        if (bvVar.g() == 35 || bvVar.q() == 3 || bvVar.q() == 4 || bvVar.q() == 7) {
            x xVar = new x();
            xVar.a = bvVar.E();
            xVar.f = bvVar.g();
            xVar.c = bvVar.z();
            xVar.d = str2;
            xVar.b = str;
            xVar.h = this.G;
            xVar.i = this.v;
            xVar.j = this.y;
            xVar.g = bvVar.h();
            if (aTAdRequest != null) {
                xVar.u = aTAdRequest.getChannelSource();
            }
            xVar.v = bvVar.k();
            ad adVarR2 = bvVar.R();
            if (adVarR2 != null) {
                xVar.k = adVarR2.a(this.y);
                xVar.s = adVarR2.x();
                xVar.t = adVarR2.getOriginRequestId();
            } else {
                xVar.k = -1;
            }
            xVar.l = adVarR2 != null ? adVarR2.g : "";
            xVar.m = adVarR2 != null ? adVarR2.h : "";
            if (bvVar.g() == 35) {
                xVar.o = this.X;
            } else {
                xVar.o = bk.u(this.bO);
            }
            if (xVar.o != null) {
                xVar.o.s(this.y);
            }
            xVar.n = adVarR2 != null ? adVarR2.f : 0L;
            if (TextUtils.equals(String.valueOf(this.y), "0")) {
                xVar.p = TextUtils.equals(ATInitMediation.getStringFromMap(mapL, "layout_type", ""), "1");
                xVar.q = bVarB.aV();
            }
            xVar.r = this.bv;
            mapL.put(com.anythink.core.common.d.j.w.a, xVar);
        }
        if (bvVar.g() == 50 && this.aA == 1) {
            mapL.put(com.anythink.core.common.d.j.w.o, str2);
        }
        ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB;
        if (TextUtils.equals(bvVar.au(), com.anythink.core.common.d.j.C0079j.a)) {
            currency = ATAdConst.CURRENCY.USD;
        }
        mapL.put(com.anythink.core.common.d.j.w.p, currency);
        if (bvVar.g() == 2) {
            mapL.put(com.anythink.core.common.d.j.w.r, bvVar.aD());
            mapL.put(com.anythink.core.common.d.j.w.G, Integer.valueOf(bVarB.aE()));
            mapL.put(com.anythink.core.common.d.j.w.H, bvVar.z());
            if (bvVar.aN() == 1 && (qVar = this.aL) != null) {
                mapL.put(com.anythink.core.common.d.j.w.t, Boolean.valueOf(qVar.a()));
                if (this.aL.a() || this.aL.b) {
                    mapL.put(com.anythink.core.common.d.j.w.s, str2);
                }
            }
        }
        if (bvVar.ae() == 0) {
            mapL.put(a.aq, Integer.valueOf(this.bq));
            if (bvVar.aF() == null) {
                mapL.put(a.ar, this.br);
            } else {
                mapL.put(a.ar, bvVar.aF());
            }
            mapL.put("nw_firm_id", Integer.valueOf(bvVar.g()));
        }
        JSONObject jSONObjectAb = bVarB.ab();
        if (jSONObjectAb != null) {
            try {
                String string = jSONObjectAb.getString(String.valueOf(bvVar.g()));
                if (!TextUtils.isEmpty(string)) {
                    mapL.put("network_ext", string);
                }
            } catch (Exception unused) {
            }
        }
        JSONArray jSONArrayAI = bvVar.aI();
        if (jSONArrayAI != null && jSONArrayAI.length() > 0) {
            mapL.put("web_content_urls", jSONArrayAI);
        }
        int iAJ = bvVar.aJ();
        if (iAJ > 0) {
            mapL.put(com.anythink.core.common.k.az, Integer.valueOf(iAJ));
        }
        mapL.put("ad_s_reqf_mode", Integer.valueOf(bvVar.aK()));
        mapL.put("ad_format", Integer.valueOf(this.y));
        mapL.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GM_REFRESH_KEY, Boolean.valueOf(bVarB.aB()));
        if (bvVar.g() == 8) {
            mapL.put(com.anythink.core.common.d.j.w.y, Integer.valueOf(bvVar.aT()));
        }
        if (bvVar.g() == 39) {
            mapL.put(com.anythink.core.common.d.j.w.I, Long.valueOf(bvVar.ba()));
            mapL.put(com.anythink.core.common.d.j.w.J, Integer.valueOf(bvVar.bd()));
        }
        if (bvVar.g() == 77) {
            mapL.put(com.anythink.core.common.d.j.w.s, str2);
        }
        if (bvVar.g() == 22) {
            mapL.put(com.anythink.core.common.d.j.w.K, Integer.valueOf(bvVar.al()));
        }
        return mapL;
    }

    public final boolean bm() {
        return !TextUtils.isEmpty(this.bo);
    }

    public final Boolean bn() {
        return this.bt;
    }

    public final void a(Boolean bool) {
        this.bt = bool;
    }

    public final int bo() {
        return this.bu;
    }

    private void X(int i) {
        this.bu = i;
    }

    public final String bp() {
        return this.bv;
    }

    private void t(String str) {
        this.bv = str;
    }

    private void a(ap apVar) {
        this.bw = apVar;
    }

    public final int bq() {
        return this.bx;
    }

    private void Y(int i) {
        this.bx = i;
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
        return this.by;
    }

    private void Z(int i) {
        this.by = i;
    }

    public final int bw() {
        return this.bz;
    }

    private void aa(int i) {
        this.bz = i;
    }

    public final int bx() {
        return this.bA;
    }

    private void ab(int i) {
        this.bA = i;
    }

    public final ai by() {
        return this.bB;
    }

    private void a(ai aiVar) {
        this.bB = aiVar;
    }

    public final List<String> bz() {
        return this.bC;
    }

    private void f(List<String> list) {
        this.bC = list;
    }

    public final JSONObject bA() {
        return this.bD;
    }

    private void g(JSONObject jSONObject) {
        this.bD = jSONObject;
    }

    public final int bB() {
        return this.bE;
    }

    private void ac(int i) {
        this.bE = i;
    }

    public final int bC() {
        return this.bF;
    }

    private void ad(int i) {
        this.bF = i;
    }

    public final int bD() {
        return this.bG;
    }

    private void ae(int i) {
        this.bG = i;
    }

    public final int bE() {
        return this.bL;
    }

    private void af(int i) {
        this.bL = i;
    }

    public final JSONObject bF() {
        return this.bH;
    }

    private void h(JSONObject jSONObject) {
        this.bH = jSONObject;
    }

    public final int bG() {
        return this.bI;
    }

    private void ag(int i) {
        this.bI = i;
    }

    public final long bH() {
        return this.bJ;
    }

    public final int bI() {
        return this.bK;
    }

    public final void b(int i) {
        this.bK = i;
    }

    public final boolean bJ() {
        int i = this.bK;
        return i == 2 || i == 5;
    }

    public final int q() {
        return this.bi == 1 ? 2 : 1;
    }

    public final int G() {
        int i = this.aN;
        if (i != -1 && this.aO == 1) {
            this.ao = i;
        }
        return this.ao;
    }

    private bv cb() {
        List<bv> listA = u.a(this, this.aY);
        if (listA.size() > 0) {
            return listA.get(0);
        }
        return null;
    }

    private boolean a(l lVar) {
        if (lVar == null) {
            return true;
        }
        return (TextUtils.equals(this.E, lVar.E) || aZ()) ? false : true;
    }
}
