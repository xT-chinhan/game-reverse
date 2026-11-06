package com.byazt.ng;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.bf.sz;
import com.byazt.jp.cy;
import com.byazt.vf.k;
import com.byazt.vy.hd;
import com.byazt.vy.rv;
import com.byazt.ws.tj;
import com.byazt.zo.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 548, 18})
public class l implements s {
    public long a;
    public int b;
    public String cp;
    public String d;
    public String dg;
    public volatile Runnable dw;
    public String fs;
    public long l;
    public int lh;
    public int oa;
    public int oj;
    public int pk;
    public long q;
    public com.byazt.bw.qg ri;
    public String rv;
    public String s;
    public com.byazt.ti.qg su;
    public int tj;
    public int u;
    public long um;
    public boolean vb;
    public String w;
    public com.byazt.mv.qg wo;
    public String x;
    public volatile JSONObject z;
    public int n = 259200000;
    public final List<Object> qg = new CopyOnWriteArrayList();
    public String sz = null;
    public String k = null;
    public boolean cy = false;
    public int hd = 0;
    public String cd = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    public int py = Integer.MAX_VALUE;
    public final List<cy> ou = new CopyOnWriteArrayList();
    public Map<String, Boolean> wm = new HashMap();
    public final AtomicBoolean m = new AtomicBoolean(false);
    public final AtomicBoolean hu = new AtomicBoolean(false);
    public int h = 0;
    public Map<String, String> t = new ConcurrentHashMap();
    public Map<String, List<String>> ur = new ConcurrentHashMap();
    public double bb = 0.0d;
    public boolean ln = false;
    public Map<String, com.byazt.ws.s> v = new ConcurrentHashMap();
    public int j = 0;
    public final Map<String, List<com.byazt.ws.s>> an = new ConcurrentHashMap();
    public final Map<String, com.byazt.ws.q> ae = new ConcurrentHashMap();
    public final Map<String, Integer> f = new ConcurrentHashMap();
    public final Map<String, Integer> fi = new ConcurrentHashMap();
    public int df = 0;
    public int sh = 0;
    public int y = 0;
    public int rf = 0;
    public int dh = 0;
    public int nf = 0;
    public int pe = 0;
    public int e = 0;
    public boolean yw = false;
    public boolean cx = false;
    public boolean lq = false;
    public boolean ic = false;
    public long ci = Long.MIN_VALUE;
    public long hf = Long.MIN_VALUE;
    public long kc = Long.MIN_VALUE;
    public int dn = 0;
    public int he = 0;
    public final AtomicInteger el = new AtomicInteger(0);
    public int fl = -1;
    public int i = -1;

    public int qg() {
        return this.pe;
    }

    public boolean s() {
        com.byazt.gwu.l lVarN;
        if (this.fl == -1 && (lVarN = com.byazt.ri.n.n()) != null) {
            String string = lVarN.getString("app_abtest", null);
            if (!TextUtils.isEmpty(string)) {
                this.sz = string;
                try {
                    fs(new JSONObject(this.sz));
                } catch (JSONException unused) {
                }
            } else {
                this.fl = 0;
            }
        }
        return this.fl == 1;
    }

    public boolean q() {
        com.byazt.gwu.l lVarN;
        if (this.i == -1 && (lVarN = com.byazt.ri.n.n()) != null) {
            String string = lVarN.getString("app_abtest", null);
            if (!TextUtils.isEmpty(string)) {
                this.sz = string;
                try {
                    fs(new JSONObject(this.sz));
                } catch (JSONException unused) {
                }
            } else {
                this.i = 0;
            }
        }
        return this.i == 1;
    }

    public boolean l() {
        return this.yw;
    }

    public boolean w() {
        return this.cx;
    }

    public boolean x() {
        return this.lq;
    }

    public void n(boolean z) {
        this.lq = z;
    }

    public boolean fs() {
        return this.ic;
    }

    public boolean rv() {
        int i = this.dn;
        return i == 1 || i == 2;
    }

    public boolean tj() {
        return this.dn == 2;
    }

    public boolean cp() {
        return this.he == 1;
    }

    public boolean d() {
        return this.m.get();
    }

    public boolean oa() {
        return this.e == 1;
    }

    public com.byazt.ws.qg n(String str, int i, int i2) {
        return com.byazt.ir.q.n().n(str, i, i2);
    }

    public long n(int i, String str) {
        com.byazt.ws.qg qgVarN = n(str, i, 101);
        if (qgVarN != null) {
            return qgVarN.u();
        }
        return 3000L;
    }

    public com.byazt.ws.n n(String str) {
        return com.byazt.ir.s.n().n(str);
    }

    public com.byazt.ws.n qg(String str) {
        return com.byazt.ir.s.n().n(str);
    }

    public boolean s(String str) {
        return com.byazt.ir.s.n().qg(str);
    }

    public boolean n(String str, String str2, int i) {
        List<tj> listY;
        com.byazt.ws.qg qgVarN = com.byazt.ir.q.n().n(str, i, 101);
        if (qgVarN == null || (listY = qgVarN.y()) == null) {
            return false;
        }
        for (tj tjVar : listY) {
            if (tjVar != null && TextUtils.equals(tjVar.cd(), str2)) {
                return tjVar.oj();
            }
        }
        return false;
    }

    public int sz() {
        return com.byazt.ir.n.n(this.el.get());
    }

    public boolean n(String str, int i) {
        com.byazt.ws.qg qgVarN;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.byazt.ir.q.n().s() || (qgVarN = com.byazt.ir.q.n().n(str, i, 101)) == null || qgVarN.fi() == i;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x02ff  */
    @Override // com.byazt.ng.s
    public void n(JSONObject jSONObject, final boolean z, JSONObject jSONObject2) {
        boolean z2;
        JSONObject jSONObject3;
        l lVar;
        com.byazt.ti.qg qgVar;
        if (jSONObject == null) {
            return;
        }
        try {
            n(z ? 2 : 6);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_abtest");
            if (jSONObjectOptJSONObject != null) {
                fs(jSONObjectOptJSONObject);
                this.sz = jSONObjectOptJSONObject.toString();
            } else {
                this.sz = "";
            }
            this.pe = jSONObject.optInt("is_trusteeship_monetize");
            this.dn = jSONObject.optInt("share_cache_enable");
            this.s = jSONObject.optString("etag");
            this.q = jSONObject.optLong("max_age");
            this.l = System.currentTimeMillis() + this.q;
            this.w = jSONObject.optString("ab_version");
            this.x = jSONObject.optString("ab_params");
            this.fs = jSONObject.optString("country");
            this.rv = jSONObject.optString("transparent_params");
            this.lh = jSONObject.optInt("if_test");
            this.tj = jSONObject.optInt("if_get_detail_return");
            this.cp = jSONObject.optString("ecpm_precision_level");
            this.d = jSONObject.optString("fetch_primerit_level");
            final String strOptString = jSONObject.optString(ImagesContract.URL);
            this.hd = jSONObject.optInt("innerLog", 0);
            this.cd = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.um = jSONObject.optLong("break_request_times", 0L);
            this.a = jSONObject.optLong("break_request_hold_time", 10000L);
            this.oj = jSONObject.optInt("ex_info", 0);
            this.dg = jSONObject.optString("ex_");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("g_d_c");
            if (jSONArrayOptJSONArray != null) {
                n.n(jSONArrayOptJSONArray);
            } else {
                n.n();
            }
            qg.n(jSONObject.optJSONObject("g_d_c_i"));
            this.j = jSONObject.optInt("if_enable_label", 0);
            this.n = jSONObject.optInt("ecpm_ttl", 259200000);
            int iOptInt = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
            this.py = iOptInt;
            if (iOptInt != 0 && iOptInt != 1) {
                this.py = 1;
            }
            this.bb = jSONObject.optDouble("custom_adn_sample_ratio", 0.0d);
            int iOptInt2 = jSONObject.optInt("enable_label_return", 0);
            this.u = iOptInt2;
            if (iOptInt2 != 0 && iOptInt2 != 1) {
                this.u = 0;
            }
            this.pk = jSONObject.optInt("dynamic_policy_enable", 0);
            com.byazt.rb.qg.qg("DynamicPolicy", "mDynamicPolicyEnable=" + this.pk);
            int i = this.pk;
            if (i != 0 && i != 1) {
                this.pk = 0;
            }
            int i2 = this.sh;
            int i3 = this.y;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.anythink.core.e.l.a.aa);
            if (jSONObjectOptJSONObject2 != null) {
                this.sh = jSONObjectOptJSONObject2.optInt("l_p_a", 0);
                this.y = jSONObjectOptJSONObject2.optInt("l_p_r", 0);
            } else {
                this.sh = 0;
                this.y = 0;
            }
            if (i2 != this.sh || i3 != this.y) {
                com.byazt.jp.tj.n(new com.byazt.zq.n(com.byazt.qt.n.d().an().sparseArray()).cp());
            }
            com.byazt.sq.n.n().n(this.um, this.a);
            this.rf = jSONObject.optInt("enable_bid_result_return", 0);
            this.dh = jSONObject.optInt("enable_bid_result_return_for_baidu", 0);
            this.nf = jSONObject.optInt("enable_bid_result_return_for_ks", 0);
            final JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("supervisor_feature");
            if (jSONObjectOptJSONObject3 != null) {
                rv.n(true);
                rv.n(jSONObjectOptJSONObject3);
            } else {
                rv.n(false);
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_common_config");
            com.byazt.ir.qg.n().n(jSONObjectOptJSONObject4);
            com.byazt.ir.s.n().n(jSONObject.optJSONObject("adn_init_conf"));
            final String strQg = qg(jSONObject.optJSONArray("adn_control_conf"));
            final String strS = s(jSONObject.optJSONArray("rit_adn_control_conf"));
            final String strX = x(jSONObject.optJSONObject("poor_network_config"));
            com.byazt.ir.q.n().n(jSONObject.optJSONArray("rit_conf"), z, false);
            final String strCp = cp(jSONObject.optJSONObject("module_disable_control"));
            final JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("call_stack_conf");
            rv(jSONObjectOptJSONObject5);
            final JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("custom_adn_feature");
            tj(jSONObjectOptJSONObject6);
            final JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("timeout_req");
            d(jSONObjectOptJSONObject7);
            final JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("is_callback");
            oa(jSONObjectOptJSONObject8);
            final String strW = w(jSONObject.optJSONObject("label_outputs"));
            try {
                final String strL = l(jSONObject.optJSONObject("label_group_infos"));
                final String strN = n(jSONObject.optJSONArray("dynamic_rules"));
                final String strS2 = s(jSONObject.optJSONObject("dynamic_policy"));
                try {
                    try {
                        this.b = jSONObject.optInt("behavior_policy_enable", 0);
                        com.byazt.rb.qg.qg("BehaviorPolicy", "mBehaviorPolicyConfigEnable=" + this.b);
                        final String strQ = q(jSONObject.optJSONObject("behavior_policy"));
                        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("inter_full_refresh_cfg");
                        String string = jSONObjectOptJSONObject9 != null ? jSONObjectOptJSONObject9.toString() : null;
                        com.byazt.fh.n.n(string);
                        com.byazt.yc.q.n(jSONObject.optJSONObject("csj_code_mapping_conf"));
                        final JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("gm_req_sr");
                        com.byazt.yc.l.n(jSONArrayOptJSONArray2);
                        qg(jSONObjectOptJSONObject4);
                        try {
                            com.byazt.nc.n.n(false);
                            final String str = string;
                            try {
                                com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ng.l.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String strN2;
                                        String strN3;
                                        String strN4;
                                        String strN5;
                                        String strN6;
                                        String strN7;
                                        String strN8;
                                        String strN9;
                                        com.byazt.gwu.l lVarN = com.byazt.ri.n.n();
                                        lVarN.n("is_trusteeship_monetize", l.this.pe);
                                        lVarN.n("share_cache_enable", l.this.dn);
                                        lVarN.n("etag", l.this.s);
                                        lVarN.n("max_age", l.this.q);
                                        lVarN.n("max_expire_time", l.this.l);
                                        lVarN.n("ab_version", l.this.w);
                                        lVarN.n("ab_params", l.this.x);
                                        lVarN.n("country", l.this.fs);
                                        lVarN.n("transparent_params", l.this.rv);
                                        lVarN.n("if_test", l.this.lh);
                                        lVarN.n("network_permission", l.this.tj);
                                        lVarN.n("ecpm_precision_level", l.this.cp);
                                        lVarN.n("fetch_primerit_level", l.this.d);
                                        lVarN.n("cache_refresh_interval", l.this.ci);
                                        lVarN.n("splash_ad_timeout", l.this.hf);
                                        lVarN.n("non_splash_ad_timeout", l.this.kc);
                                        lVarN.n("app_abtest", l.this.sz);
                                        lVarN.n("module_control", strCp);
                                        lVarN.n("tt_app_log_url", l.this.cd);
                                        lVarN.n("break_request_times", l.this.um);
                                        lVarN.n("break_request_hold_time", l.this.a);
                                        lVarN.n("ex_info", l.this.oj);
                                        lVarN.n("g_d_c", n.qg());
                                        lVarN.n("g_d_c_i", qg.qg());
                                        lVarN.n("if_enable_label", l.this.j);
                                        lVarN.n("cpm_expire_time", l.this.n);
                                        JSONObject jSONObject4 = jSONObjectOptJSONObject3;
                                        lVarN.n("key_supervisor_feature", jSONObject4 != null ? jSONObject4.toString() : "");
                                        lVarN.n("custom_adn_sample_ratio", (float) l.this.bb);
                                        lVarN.n("enable_label_return", l.this.u);
                                        lVarN.n("dynamic_policy_enable", l.this.pk);
                                        lVarN.n("behavior_policy_enable", l.this.b);
                                        lVarN.n("limit_p_a", l.this.sh);
                                        lVarN.n("limit_p_r", l.this.y);
                                        lVarN.n("enable_bid_result_return", l.this.rf);
                                        lVarN.n("enable_bid_result_return_for_baidu", l.this.dh);
                                        lVarN.n("enable_bid_result_return_for_ks", l.this.nf);
                                        JSONObject jSONObject5 = jSONObjectOptJSONObject5;
                                        if (jSONObject5 != null) {
                                            lVarN.n("call_stack", jSONObject5.toString());
                                        } else {
                                            lVarN.n("call_stack", "");
                                        }
                                        JSONObject jSONObject6 = jSONObjectOptJSONObject6;
                                        if (jSONObject6 != null) {
                                            lVarN.n("custom_adn_feature", jSONObject6.toString());
                                        } else {
                                            lVarN.n("custom_adn_feature", "");
                                        }
                                        JSONObject jSONObject7 = jSONObjectOptJSONObject7;
                                        if (jSONObject7 != null) {
                                            lVarN.n("timeout_req", jSONObject7.toString());
                                        } else {
                                            lVarN.n("timeout_req", "");
                                        }
                                        JSONObject jSONObject8 = jSONObjectOptJSONObject8;
                                        if (jSONObject8 != null) {
                                            lVarN.n("is_callback", jSONObject8.toString());
                                        } else {
                                            lVarN.n("is_callback", "");
                                        }
                                        String str2 = strOptString;
                                        if (str2 != null && !TextUtils.isEmpty(str2)) {
                                            String strN10 = com.byazt.vy.n.n(strOptString, com.byazt.vy.qg.n());
                                            if (strN10 != null) {
                                                lVarN.n("server_dist_host", strN10);
                                            }
                                        } else {
                                            lVarN.n("server_dist_host");
                                        }
                                        String str3 = strQg;
                                        if (str3 != null && (strN9 = com.byazt.vy.n.n(str3, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("adn_control_conf", strN9);
                                        }
                                        if (!TextUtils.isEmpty(strS)) {
                                            lVarN.n("rit_adn_control_conf", strS);
                                        } else {
                                            lVarN.n("rit_adn_control_conf");
                                        }
                                        String str4 = strX;
                                        if (str4 != null) {
                                            lVarN.n("network_conf", str4);
                                        }
                                        if (!TextUtils.isEmpty(strW) && (strN8 = com.byazt.vy.n.n(strW, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("label_outputs", strN8);
                                        }
                                        if (!TextUtils.isEmpty(strL) && (strN7 = com.byazt.vy.n.n(strL, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("label_group_infos", strN7);
                                        }
                                        if (!TextUtils.isEmpty(strN) && (strN6 = com.byazt.vy.n.n(strN, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("dynamic_rules", strN6);
                                        }
                                        if (!TextUtils.isEmpty(l.this.dg) && (strN5 = com.byazt.vy.n.n(l.this.dg, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("ex_", strN5);
                                        }
                                        if (!TextUtils.isEmpty(strS2) && (strN4 = com.byazt.vy.n.n(strS2, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("dynamic_policy", strN4);
                                        }
                                        if (!TextUtils.isEmpty(strQ) && (strN3 = com.byazt.vy.n.n(strQ, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("behavior_policy", strN3);
                                        }
                                        if (!TextUtils.isEmpty(str) && (strN2 = com.byazt.vy.n.n(str, com.byazt.vy.qg.n())) != null) {
                                            lVarN.n("inter_full_refresh_cfg", strN2);
                                        }
                                        JSONArray jSONArray = jSONArrayOptJSONArray2;
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            String strN11 = com.byazt.vy.n.n(jSONArrayOptJSONArray2.toString(), com.byazt.vy.qg.n());
                                            if (strN11 != null) {
                                                lVarN.n("gm_req_sr", strN11);
                                            }
                                        } else {
                                            lVarN.n("gm_req_sr");
                                        }
                                        lVarN.n("is_config_from_assert", z);
                                        lVarN.n("has_config_in_sp", true);
                                    }
                                });
                                if (!z) {
                                    com.byazt.zo.n.n().s();
                                }
                                n(false, jSONObject2, (com.byazt.ti.qg) null);
                            } catch (Throwable unused) {
                                qgVar = null;
                                z2 = false;
                                lVar = this;
                                jSONObject3 = jSONObject2;
                                if (!z) {
                                    com.byazt.zo.n.n().s();
                                }
                                lVar.n(z2, jSONObject3, qgVar);
                            }
                        } catch (Throwable unused2) {
                            jSONObject3 = jSONObject2;
                            z2 = false;
                            lVar = this;
                            qgVar = null;
                            if (!z) {
                                com.byazt.zo.n.n().s();
                            }
                            lVar.n(z2, jSONObject3, qgVar);
                        }
                    } catch (Throwable unused3) {
                        jSONObject3 = jSONObject2;
                        lVar = this;
                        qgVar = null;
                        z2 = false;
                        if (!z) {
                            com.byazt.zo.n.n().s();
                        }
                        lVar.n(z2, jSONObject3, qgVar);
                    }
                } catch (Throwable unused4) {
                    jSONObject3 = jSONObject2;
                    z2 = false;
                }
            } catch (Throwable unused5) {
                jSONObject3 = jSONObject2;
            }
        } catch (Throwable unused6) {
            z2 = false;
            jSONObject3 = jSONObject2;
        }
    }

    private void qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ci = jSONObject.optLong("cache_refresh_interval", 12L);
        this.hf = jSONObject.optLong("splash_ad_timeout", 0L);
        this.kc = jSONObject.optLong("non_splash_ad_timeout", 0L);
    }

    @Override // com.byazt.ng.s
    public void n(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_abtest");
            if (jSONObjectOptJSONObject != null) {
                this.k = jSONObjectOptJSONObject.toString();
            } else {
                this.k = "";
            }
            if (!z) {
                com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ng.l.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.ri.n.n().n("app_simple_abtest", l.this.k);
                    }
                });
                if (z) {
                    if (com.byazt.it.s.s()) {
                        n(false, jSONObject2, (com.byazt.ti.qg) null);
                    }
                    com.byazt.zo.n.n().qg();
                    return;
                }
                return;
            }
            if (this.el.get() >= 3) {
                if (z) {
                    if (com.byazt.it.s.s()) {
                        n(false, jSONObject2, (com.byazt.ti.qg) null);
                    }
                    com.byazt.zo.n.n().qg();
                    return;
                }
                return;
            }
            this.z = jSONObject;
            n(3);
            com.byazt.ir.s.n().n(jSONObject.optJSONObject("adn_init_conf"));
            com.byazt.ir.q.n().n(jSONObject.optJSONArray("rit_conf"), false, true);
            qg(jSONObject.optJSONObject("app_common_config"));
            com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ng.l.3
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.gwu.l lVarN = com.byazt.ri.n.n();
                    lVarN.n("cache_refresh_interval", l.this.ci);
                    lVarN.n("splash_ad_timeout", l.this.hf);
                    lVarN.n("non_splash_ad_timeout", l.this.kc);
                    lVarN.n("app_simple_abtest", l.this.k);
                }
            });
            if (z) {
                if (com.byazt.it.s.s()) {
                    n(false, jSONObject2, (com.byazt.ti.qg) null);
                }
                com.byazt.zo.n.n().qg();
            }
        } catch (Throwable unused) {
            if (!z) {
            } else {
                if (com.byazt.it.s.s()) {
                }
            }
        }
    }

    private String s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.wo = new com.byazt.mv.qg(jSONObject);
        return jSONObject.toString();
    }

    private String q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.ri = new com.byazt.bw.qg(jSONObject);
        return jSONObject.toString();
    }

    private String n(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                com.byazt.ws.q.n(jSONArray.optJSONObject(i), this.ae);
            } catch (Exception unused) {
                com.byazt.rb.qg.s(MediationConstant.TAG, "maybe some rit parse dynamic rules fail .....");
            }
        }
        return jSONArray.toString();
    }

    private String l(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return "";
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(next);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(com.byazt.ws.s.n(next, jSONArray.optJSONObject(i)));
                    }
                    this.an.put(next, arrayList);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString();
    }

    private String w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.v.put(next, com.byazt.ws.s.n(next, jSONObject.optJSONObject(next)));
        }
        return jSONObject.toString();
    }

    public void n(com.byazt.ti.qg qgVar) {
        this.su = qgVar;
    }

    public void n(final boolean z, final JSONObject jSONObject, com.byazt.ti.qg qgVar) {
        if (qgVar != null) {
            this.su = qgVar;
        }
        final boolean zU = u();
        if (zU) {
            x.n(jSONObject, "s-config_done");
        }
        final int iSz = sz();
        com.byazt.ya.n.qg().n(com.byazt.qt.qg.getContext(), z, zU, jSONObject, new com.byazt.ti.qg() { // from class: com.byazt.ng.l.4
            @Override // com.byazt.ti.qg
            public void n() {
                com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + zU);
                if (zU) {
                    l.this.m.set(true);
                    x.n(jSONObject, "s-m_end");
                    final long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (l.this.q() && l.this.dw == null) {
                        l.this.dw = new Runnable() { // from class: com.byazt.ng.l.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                l.this.n(jSONObject, z, iSz, jElapsedRealtime);
                            }
                        };
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        Integer.valueOf(jSONObject2.optInt("s-m_end"));
                    }
                    l.this.sz(jSONObject);
                    com.byazt.ti.qg qgVar2 = l.this.su;
                    if (qgVar2 != null) {
                        qgVar2.n();
                    }
                    com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ng.l.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!l.this.q()) {
                                l.this.n(jSONObject, z, iSz, jElapsedRealtime);
                            }
                            q.n(com.byazt.qt.qg.n()).n(new com.byazt.jp.l() { // from class: com.byazt.ng.l.4.2.1
                                @Override // com.byazt.jp.l
                                public void n(List<String> list) {
                                    com.byazt.rb.qg.n("TMe", "初始化更新pangle配置成功");
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public Runnable k() {
        return this.dw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, boolean z, int i, long j) {
        if (this.hu.compareAndSet(false, true)) {
            int iN = com.byazt.ya.n.n();
            long jN = j - com.byazt.it.s.n();
            x.n(jSONObject, "s-event_end");
            x.n();
            HashMap map = new HashMap();
            map.put("config_use_type", Integer.valueOf(i));
            boolean z2 = this.vb;
            if (z2) {
                map.put("is_import_cfg", Boolean.valueOf(z2));
            }
            if (!com.byazt.it.q.n()) {
                com.byazt.rb.qg.n("TMe", "-----==---- 延时上报sdk_init_end");
                com.byazt.it.q.n(jN, iN, z ? 1 : 0, jSONObject, map);
            } else {
                com.byazt.rb.qg.n("TMe", "-----==---- 正常上报sdk_init_end");
                com.byazt.it.q.n(jN, iN, z ? 1 : 0, -1L, jSONObject, map);
            }
            com.byazt.mv.n.n();
            com.byazt.rb.qg.n(MediationConstant.TAG, "sdk init end, duration: " + jN + ", initAdnCount: " + iN + ", isFromLocalConfig: " + z);
        }
    }

    @Override // com.byazt.ng.s
    public void n(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        com.byazt.gwu.l lVarN = com.byazt.ri.n.n();
        this.q = jSONObject.optLong("max_age");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.q;
        this.l = jCurrentTimeMillis + j;
        lVarN.n("max_age", j);
        lVarN.n("max_expire_time", this.l);
    }

    public void n(int i) {
        if (i == 3) {
            if (this.el.get() == 1) {
                i = 5;
            } else if (this.el.get() == 2) {
                i = 4;
            }
        }
        if (i < this.el.get()) {
            return;
        }
        this.el.set(i);
    }

    public boolean qg(String str, int i) {
        return (com.byazt.ir.s.n().q() || com.byazt.ir.q.n().s() || com.byazt.ir.q.n().n(str, i, 101) == null) ? false : true;
    }

    public String cy() {
        return this.fs;
    }

    public String hd() {
        return this.rv;
    }

    @Override // com.byazt.ng.s
    public void n(boolean z, JSONObject jSONObject) {
        JSONObject jSONObjectUr;
        try {
            com.byazt.gwu.l lVarN = com.byazt.ri.n.n();
            boolean z2 = lVarN.getBoolean("has_config_in_sp", false);
            if (!z2 && (jSONObjectUr = com.byazt.qt.n.d().ur()) != null) {
                this.vb = true;
                if (jSONObjectUr.optInt("cypher", -1) == 4) {
                    String strOptString = jSONObjectUr.optString("message");
                    k kVarS = com.byazt.cl.s.s();
                    String strQg = kVarS != null ? kVarS.qg(strOptString) : null;
                    if (!TextUtils.isEmpty(strQg)) {
                        try {
                            jSONObjectUr = new JSONObject(strQg);
                        } catch (Throwable th) {
                            com.byazt.rb.qg.n(MediationConstant.TAG, ">>>>> setting data error: " + th.toString());
                        }
                    }
                }
                int iOptInt = jSONObjectUr.optInt("state_code");
                String strOptString2 = jSONObjectUr.optString("message");
                if (iOptInt == 20000 && jSONObjectUr != null && !TextUtils.isEmpty(jSONObjectUr.toString())) {
                    if (jSONObjectUr.optString("app_id").equals(com.byazt.qt.n.d().oa())) {
                        com.byazt.rb.qg.qg(MediationConstant.TAG, "本地配置解析成功");
                        n(jSONObjectUr, true, jSONObject);
                        if (this.z != null) {
                            n(this.z, jSONObject, true);
                        }
                        com.byazt.zs.n.n().q();
                        com.byazt.qt.n.d().n((JSONObject) null);
                        this.z = null;
                        if (!com.byazt.ir.s.n().q()) {
                            n(1);
                        }
                        if (!z) {
                            n(true, (JSONObject) null, (com.byazt.ti.qg) null);
                        }
                        if (!com.byazt.ir.q.n().s() || hd.n(com.byazt.qt.qg.getContext())) {
                            return;
                        }
                        com.byazt.zs.n.n().n(-2, "本地没有配置/当前网络不可用");
                        return;
                    }
                    com.byazt.rb.qg.qg(MediationConstant.TAG, "本地配置appid或appkey非法");
                } else {
                    com.byazt.rb.qg.qg(MediationConstant.TAG, " 解密错误或者解析错误：stateCode=" + iOptInt + "，msg=" + strOptString2);
                }
            }
            com.byazt.qt.n.d().n((JSONObject) null);
            this.z = null;
            if (z2) {
                n(lVarN);
            } else {
                su();
            }
            if (z) {
                com.byazt.nc.n.n(true);
            }
            if (!com.byazt.ir.s.n().q()) {
                n(1);
            }
            if (!z) {
                n(true, (JSONObject) null, (com.byazt.ti.qg) null);
            }
            if (!com.byazt.ir.q.n().s() || hd.n(com.byazt.qt.qg.getContext())) {
                return;
            }
            com.byazt.zs.n.n().n(-2, "本地没有配置/当前网络不可用");
        } catch (Throwable unused) {
            if (!com.byazt.ir.s.n().q()) {
                n(1);
            }
            if (!z) {
                n(true, (JSONObject) null, (com.byazt.ti.qg) null);
            }
            if (!com.byazt.ir.q.n().s() || hd.n(com.byazt.qt.qg.getContext())) {
                return;
            }
            com.byazt.zs.n.n().n(-2, "本地没有配置/当前网络不可用");
        }
    }

    private void su() {
        this.w = "";
        this.x = "";
        this.fs = "";
        this.rv = "";
        this.cp = "0";
        this.d = "0";
        this.a = 10000L;
        com.byazt.sq.n.n().n(this.um, this.a);
    }

    private void n(com.byazt.gwu.l lVar) throws JSONException {
        this.pe = lVar.getInt("is_trusteeship_monetize", 0);
        this.dn = lVar.getInt("share_cache_enable", 0);
        this.s = lVar.getString("etag", null);
        this.q = lVar.getLong("max_age", 0L);
        this.l = lVar.getLong("max_expire_time", 0L);
        this.w = lVar.getString("ab_version", "");
        this.x = lVar.getString("ab_params", "");
        this.fs = lVar.getString("country", "");
        this.rv = lVar.getString("transparent_params", "");
        this.lh = lVar.getInt("if_test", 0);
        this.tj = lVar.getInt("network_permission", 0);
        this.cp = lVar.getString("ecpm_precision_level", "0");
        this.d = lVar.getString("fetch_primerit_level", "0");
        this.cd = lVar.getString("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.um = lVar.getLong("break_request_times", 0L);
        this.a = lVar.getLong("break_request_hold_time", 10000L);
        this.oj = lVar.getInt("ex_info", 0);
        this.j = lVar.getInt("if_enable_label", 0);
        this.n = lVar.getInt("cpm_expire_time", 259200000);
        this.bb = lVar.getFloat("custom_adn_sample_ratio", 0.0f);
        this.u = lVar.getInt("enable_label_return", 0);
        this.pk = lVar.getInt("dynamic_policy_enable", 0);
        this.b = lVar.getInt("behavior_policy_enable", 0);
        this.sh = lVar.getInt("limit_p_a", 0);
        this.y = lVar.getInt("limit_p_r", 0);
        this.rf = lVar.getInt("enable_bid_result_return", 0);
        this.dh = lVar.getInt("enable_bid_result_return_for_baidu", 0);
        this.nf = lVar.getInt("enable_bid_result_return_for_ks", 0);
        com.byazt.sq.n.n().n(this.um, this.a);
        String string = lVar.getString("network_conf", null);
        if (!TextUtils.isEmpty(string)) {
            x(new JSONObject(string));
        }
        String string2 = lVar.getString("adn_control_conf", null);
        if (!TextUtils.isEmpty(string2)) {
            if (!string2.startsWith("[") && !string2.startsWith("{")) {
                string2 = com.byazt.vy.n.qg(string2, com.byazt.vy.qg.n());
            }
            qg(new JSONArray(string2));
        }
        String string3 = lVar.getString("rit_adn_control_conf", null);
        if (!TextUtils.isEmpty(string3)) {
            s(new JSONArray(string3));
        }
        String string4 = lVar.getString("module_control", null);
        if (!TextUtils.isEmpty(string4)) {
            cp(new JSONObject(string4));
        }
        boolean z = lVar.getBoolean("all_active_control", false);
        if (z) {
            this.wm.put("active_control", Boolean.valueOf(z));
        }
        String string5 = lVar.getString("call_stack", null);
        if (!TextUtils.isEmpty(string5)) {
            rv(new JSONObject(string5));
        }
        String string6 = lVar.getString("custom_adn_feature", null);
        if (!TextUtils.isEmpty(string6)) {
            tj(new JSONObject(string6));
        }
        String string7 = lVar.getString("timeout_req", null);
        if (!TextUtils.isEmpty(string7)) {
            d(new JSONObject(string7));
        }
        String string8 = lVar.getString("is_callback", null);
        if (!TextUtils.isEmpty(string8)) {
            oa(new JSONObject(string8));
        }
        String string9 = lVar.getString("key_supervisor_feature", null);
        if (!TextUtils.isEmpty(string9)) {
            rv.n(true);
            rv.n(new JSONObject(string9));
        } else {
            rv.n(false);
        }
        String string10 = lVar.getString("label_outputs", null);
        if (!TextUtils.isEmpty(string10)) {
            if (!string10.startsWith("[") && !string10.startsWith("{")) {
                string10 = com.byazt.vy.n.qg(string10, com.byazt.vy.qg.n());
            }
            if (!TextUtils.isEmpty(string10)) {
                w(new JSONObject(string10));
            }
        }
        String string11 = lVar.getString("label_group_infos", null);
        if (!TextUtils.isEmpty(string11)) {
            if (!string11.startsWith("[") && !string11.startsWith("{")) {
                string11 = com.byazt.vy.n.qg(string11, com.byazt.vy.qg.n());
            }
            if (!TextUtils.isEmpty(string11)) {
                l(new JSONObject(string11));
            }
        }
        String string12 = lVar.getString("dynamic_rules", null);
        if (!TextUtils.isEmpty(string12)) {
            if (!string12.startsWith("[") && !string12.startsWith("{")) {
                string12 = com.byazt.vy.n.qg(string12, com.byazt.vy.qg.n());
            }
            if (!TextUtils.isEmpty(string12)) {
                n(new JSONArray(string12));
            }
        }
        String string13 = lVar.getString("dynamic_policy", null);
        if (!TextUtils.isEmpty(string13)) {
            if (!string13.startsWith("[") && !string13.startsWith("{")) {
                string13 = com.byazt.vy.n.qg(string13, com.byazt.vy.qg.n());
            }
            if (!TextUtils.isEmpty(string13)) {
                s(new JSONObject(string13));
            }
        }
        String string14 = lVar.getString("behavior_policy", null);
        if (!TextUtils.isEmpty(string14)) {
            if (!string14.startsWith("[") && !string14.startsWith("{")) {
                string14 = com.byazt.vy.n.qg(string14, com.byazt.vy.qg.n());
            }
            if (!TextUtils.isEmpty(string14)) {
                q(new JSONObject(string14));
            }
        }
        String string15 = lVar.getString("inter_full_refresh_cfg", null);
        if (!TextUtils.isEmpty(string15)) {
            String strQg = com.byazt.vy.n.qg(string15, com.byazt.vy.qg.n());
            if (!TextUtils.isEmpty(strQg)) {
                com.byazt.fh.n.n(strQg);
            }
        }
        String string16 = lVar.getString("gm_req_sr", null);
        if (!TextUtils.isEmpty(string16)) {
            String strQg2 = com.byazt.vy.n.qg(string16, com.byazt.vy.qg.n());
            if (!TextUtils.isEmpty(strQg2)) {
                try {
                    com.byazt.yc.l.n(new JSONArray(strQg2));
                } catch (JSONException unused) {
                }
            }
        }
        String string17 = lVar.getString("ex_", null);
        if (!TextUtils.isEmpty(string17) && !string17.startsWith("[") && !string17.startsWith("{")) {
            this.dg = com.byazt.vy.n.qg(string17, com.byazt.vy.qg.n());
        }
        String string18 = lVar.getString("app_simple_abtest", null);
        if (!TextUtils.isEmpty(string18)) {
            this.k = string18;
        }
        if (TextUtils.isEmpty(this.sz)) {
            String string19 = lVar.getString("app_abtest", null);
            if (!TextUtils.isEmpty(string19)) {
                this.sz = string19;
                try {
                    fs(new JSONObject(this.sz));
                } catch (JSONException unused2) {
                }
            }
        }
        String string20 = lVar.getString("g_d_c", null);
        if (TextUtils.isEmpty(string20)) {
            n.n();
        } else {
            try {
                n.n(new JSONArray(string20));
            } catch (JSONException unused3) {
                n.n();
            }
        }
        qg.n(lVar.getString("g_d_c_i", null));
    }

    private String x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.oa = jSONObject.optInt("fetch_ad_type", 0);
        return jSONObject.toString();
    }

    private String qg(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, com.byazt.bf.qg> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(jSONArrayOptJSONArray.optString(i2));
                    }
                    com.byazt.bf.qg qgVar = new com.byazt.bf.qg();
                    qgVar.n(jSONObjectOptJSONObject.optLong("break_request_duration"));
                    qgVar.n(arrayList);
                    concurrentHashMap.put(jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME), qgVar);
                }
            }
            com.byazt.bf.s.n().n(concurrentHashMap);
            return jSONArray.toString();
        }
        com.byazt.bf.s.n().n(null);
        return null;
    }

    private String s(JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONArray != null) {
            ConcurrentHashMap<String, List<com.byazt.bf.qg>> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_ADN_NAME);
                    if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("break_request_error_code")) != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("rit_list")) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                        com.byazt.bf.qg qgVar = new com.byazt.bf.qg();
                        qgVar.n(jSONObjectOptJSONObject.optLong("break_request_duration"));
                        qgVar.n(arrayList);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                        }
                        qgVar.qg(arrayList2);
                        List<com.byazt.bf.qg> arrayList3 = concurrentHashMap.get(strOptString);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        arrayList3.add(qgVar);
                        concurrentHashMap.put(strOptString, arrayList3);
                    }
                }
            }
            sz.n().n(concurrentHashMap);
            return jSONArray.toString();
        }
        sz.n().n(null);
        return null;
    }

    private void fs(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("app_ab_version");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString.trim()) || TextUtils.equals(strOptString.trim(), AbstractJsonLexerKt.NULL)) {
                jSONObject.remove("app_ab_version");
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("app_ab_params"));
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("mediation_settings");
            if (jSONObjectOptJSONObject != null) {
                this.df = jSONObjectOptJSONObject.optInt("ad_request_optmize");
                boolean z = true;
                this.yw = jSONObjectOptJSONObject.optInt("applog_cypher") == 2;
                this.cx = jSONObjectOptJSONObject.optInt("reward_cypher") == 2;
                this.lq = jSONObjectOptJSONObject.optInt("config_cypher") == 2;
                if (jSONObjectOptJSONObject.optInt("exchange_cypher") != 2) {
                    z = false;
                }
                this.ic = z;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("init_opt");
            if (jSONObjectOptJSONObject2 != null) {
                if (this.fl == -1) {
                    this.fl = jSONObjectOptJSONObject2.optInt("init_7600");
                }
                if (this.i == -1) {
                    this.i = jSONObjectOptJSONObject2.optInt("init_7800");
                }
            } else {
                if (this.fl == -1) {
                    this.fl = 0;
                }
                if (this.i == -1) {
                    this.i = 0;
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("event_upload_settings");
            if (jSONObjectOptJSONObject3 != null) {
                this.e = jSONObjectOptJSONObject3.optInt("show_upload");
            }
            JSONObject jSONObjectOptJSONObject4 = jSONObject2.optJSONObject("sp_migrate_opt");
            if (jSONObjectOptJSONObject4 != null) {
                this.he = jSONObjectOptJSONObject4.optInt("enable", 0);
            } else {
                this.he = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private void rv(JSONObject jSONObject) {
        this.t.clear();
        this.h = 0;
        if (jSONObject == null) {
            return;
        }
        this.h = jSONObject.optInt("if_sample", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (jSONObjectOptJSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObjectOptJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                            this.t.put(next, strOptString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void tj(JSONObject jSONObject) {
        this.ur.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                if (jSONArrayOptJSONArray.get(i) != null) {
                                    arrayList.add(jSONArrayOptJSONArray.get(i).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.ur.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String cp(JSONObject jSONObject) {
        this.wm.clear();
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.optBoolean("ad_event_control")) {
                this.wm.put("ad_event_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_banner_control")) {
                this.wm.put("type_banner_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interaction_control")) {
                this.wm.put("type_interaction_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_interactionfull_control")) {
                this.wm.put("type_interactionfull_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_splash_control")) {
                this.wm.put("type_splash_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_feed_control")) {
                this.wm.put("type_feed_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_reward_control")) {
                this.wm.put("type_reward_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_full_control")) {
                this.wm.put("type_full_control", Boolean.TRUE);
            }
            if (jSONObject.optBoolean("type_native_control")) {
                this.wm.put("type_native_control", Boolean.TRUE);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    private void oa(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.fi.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.fi.put(next, Integer.valueOf(jSONObject.optInt(next)));
        }
    }

    public String cd() {
        if (this.s == null) {
            this.s = com.byazt.ri.n.n().getString("etag", null);
        }
        return this.s;
    }

    public String um() {
        return this.cd;
    }

    public boolean a() {
        return this.oa == 1;
    }

    public String py() {
        return this.sz;
    }

    public String ou() {
        return this.k;
    }

    public boolean wm() {
        return this.cy;
    }

    @Override // com.byazt.ng.s
    public void n() {
        this.cy = u();
    }

    public long m() {
        if (this.ci == Long.MIN_VALUE) {
            this.ci = com.byazt.ri.n.n().getLong("cache_refresh_interval", 12L);
        }
        return this.ci * 60 * 60 * 1000;
    }

    public long hu() {
        if (this.hf == Long.MIN_VALUE) {
            this.hf = com.byazt.ri.n.n().getLong("splash_ad_timeout", 0L);
        }
        return this.hf;
    }

    public long h() {
        if (this.kc == Long.MIN_VALUE) {
            this.kc = com.byazt.ri.n.n().getLong("non_splash_ad_timeout", 0L);
        }
        return this.kc;
    }

    public void q(String str) {
        try {
            com.byazt.gwu.l lVarN = com.byazt.ri.n.n();
            if ("2".equals(str)) {
                this.wm.put("active_control", Boolean.TRUE);
                lVarN.n("all_active_control", true);
            } else {
                this.wm.put("active_control", Boolean.FALSE);
                lVarN.n("all_active_control", false);
            }
        } catch (Exception unused) {
        }
    }

    private boolean ha() {
        Boolean bool = this.wm.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean t() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("ad_event_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean qg(int i) {
        if (!ha()) {
            return false;
        }
        if (i == 1) {
            return ur();
        }
        if (i == 2) {
            return bb();
        }
        if (i == 3) {
            return lh();
        }
        if (i == 5) {
            return v() && ae();
        }
        if (i == 10) {
            return ln();
        }
        if (i == 7) {
            return j();
        }
        if (i != 8) {
            return true;
        }
        return an();
    }

    public boolean ur() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_banner_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean bb() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_interaction_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean ln() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_interactionfull_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean lh() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_splash_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean v() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_feed_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean j() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_reward_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean an() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_full_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean ae() {
        if (!ha()) {
            return false;
        }
        Boolean bool = this.wm.get("type_native_control");
        return bool == null || !bool.booleanValue();
    }

    public boolean f() {
        return this.tj > 0;
    }

    public boolean fi() {
        try {
            return Integer.valueOf(this.cp).intValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean df() {
        try {
            return Integer.valueOf(this.cp).intValue() > 1;
        } catch (Exception unused) {
        }
    }

    public int oj() {
        return com.byazt.ir.qg.n().qg();
    }

    public long dg() {
        return com.byazt.ir.qg.n().s();
    }

    public boolean u() {
        return (com.byazt.ir.q.n().s() || com.byazt.ir.s.n().q()) ? false : true;
    }

    public boolean pk() {
        if (TextUtils.isEmpty(com.byazt.qt.n.d().oa())) {
            return false;
        }
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit: " + d());
        if (!com.byazt.ir.q.n().s() && d()) {
            com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 1");
            return true;
        }
        com.byazt.rb.qg.qg("TTMediationSDK_SDK_Init", "--==----- isConfigLoadAndAdnInit 2");
        return false;
    }

    public List<String> n(List<String> list) {
        if (list != null && list.size() > 0) {
            if (com.byazt.ir.q.n().s()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (com.byazt.ir.q.n().n(str, 0, 101) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void n(cy cyVar) {
        if (cyVar == null) {
            return;
        }
        if (pk()) {
            cyVar.n();
            return;
        }
        synchronized (this.ou) {
            if (!this.ou.contains(cyVar)) {
                this.ou.add(cyVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz(JSONObject jSONObject) {
        com.byazt.zs.n.n().n(jSONObject);
        if (pk()) {
            Iterator<cy> it = this.ou.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
            this.ou.clear();
        }
    }

    public boolean wo() {
        return this.h == 1;
    }

    public Map<String, String> sh() {
        return this.t;
    }

    public Map<String, List<String>> y() {
        return this.ur;
    }

    public double rf() {
        return this.bb;
    }

    public boolean dh() {
        return this.u == 1;
    }

    public boolean b() {
        return this.pk == 1;
    }

    public boolean ri() {
        return this.b == 1;
    }

    public com.byazt.mv.qg nf() {
        return this.wo;
    }

    public com.byazt.bw.qg pe() {
        if (ri()) {
            return this.ri;
        }
        return null;
    }

    public boolean e() {
        return this.lh == 1;
    }

    public int yw() {
        return this.lh;
    }

    public void s(int i) {
        this.lh = i;
    }

    public Map<String, com.byazt.ws.s> cx() {
        return this.v;
    }

    public boolean lq() {
        return this.oj == 1;
    }

    public String ic() {
        return this.dg;
    }

    public boolean ci() {
        return this.j == 1;
    }

    public boolean n(long j) {
        return j < ((long) this.n);
    }

    public int hf() {
        return this.n;
    }

    public com.byazt.ws.q l(String str) {
        return this.ae.get(str);
    }

    public List<com.byazt.ws.s> w(String str) {
        return this.an.get(str);
    }

    public int kc() {
        com.byazt.mv.qg qgVar = this.wo;
        if (qgVar != null) {
            return qgVar.n();
        }
        return 0;
    }

    public Map<String, Integer> z() {
        return this.f;
    }

    public Map<String, Integer> dn() {
        return this.fi;
    }

    public int he() {
        return this.sh;
    }

    public int el() {
        return this.y;
    }

    public boolean vb() {
        com.byazt.rb.qg.qg("TMe", "enable_bid_result_return = " + this.rf);
        com.byazt.rb.qg.qg("TMe", "enable_bid_result_return_for_baidu = " + this.dh);
        return fl() || i();
    }

    public boolean fl() {
        return this.rf == 1 && this.dh == 1;
    }

    public boolean i() {
        return this.rf == 1 && this.dh == 2;
    }

    public boolean dw() {
        com.byazt.rb.qg.qg("TMe", "enable_bid_result_return = " + this.rf);
        com.byazt.rb.qg.qg("TMe", "enable_bid_result_return_for_ks = " + this.nf);
        return this.rf == 1 && this.nf == 1;
    }
}
