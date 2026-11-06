package com.byazt.ws;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.anythink.core.common.f.h;
import com.anythink.core.common.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, 26})
public class qg {
    public String a;
    public int ae;
    public int an;
    public int bb;
    public int cd;
    public int cy;
    public com.byazt.bf.x df;
    public JSONObject dg;
    public int f;
    public com.byazt.bf.rv fi;
    public String fs;
    public long h;
    public long hd;
    public int hu;
    public int j;
    public int k;
    public long l;
    public int lh;
    public double ln;
    public String m;
    public String n;
    public int oj;
    public int ou;
    public int py;
    public long q;
    public int qg;
    public int rf;
    public int s;
    public double sh;
    public boolean t;
    public int u;
    public String um;
    public boolean ur;
    public int v;
    public long w;
    public int wm;
    public double wo;
    public long x;
    public long y;
    public List<tj> rv = new CopyOnWriteArrayList();
    public Map<Integer, List<tj>> tj = new HashMap();
    public Map<Integer, List<tj>> cp = new HashMap();
    public List<Integer> d = new ArrayList();
    public double oa = -1.0d;
    public double sz = -1.0d;
    public int pk = 1000;
    public int dh = 0;
    public int b = 2;
    public int ri = 0;
    public int nf = 0;
    public long pe = 0;
    public int e = 0;
    public Map<String, Object> yw = new HashMap();

    public int n() {
        return this.e;
    }

    public void n(int i) {
        this.e = i;
    }

    public void n(long j) {
        this.pe = j;
    }

    public long qg() {
        return this.pe;
    }

    public void qg(int i) {
        this.nf = i;
    }

    public int s() {
        return this.nf;
    }

    public int q() {
        return this.rf;
    }

    public void s(int i) {
        this.rf = i;
    }

    public void n(double d) {
        if (d < 0.1d || d > 1.0d) {
            d = 0.1d;
        }
        this.sh = d;
    }

    public double l() {
        return this.sh;
    }

    public void qg(double d) {
        if (d < 0.01d || d > 1.0d) {
            d = 0.01d;
        }
        this.wo = d;
    }

    public double w() {
        return this.wo;
    }

    public void qg(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.y = j;
    }

    public long x() {
        return this.y;
    }

    public Map<String, Object> fs() {
        return this.yw;
    }

    public int rv() {
        return this.u;
    }

    public void q(int i) {
        this.u = i;
    }

    public int tj() {
        int iMin = Math.min(this.pk, 1000);
        if (iMin <= 0) {
            return 1000;
        }
        return iMin;
    }

    public void l(int i) {
        this.pk = i;
    }

    public void w(int i) {
        this.oj = i;
    }

    public com.byazt.bf.x cp() {
        return this.df;
    }

    public void n(com.byazt.bf.x xVar) {
        this.df = xVar;
    }

    public com.byazt.bf.rv d() {
        return this.fi;
    }

    public void n(com.byazt.bf.rv rvVar) {
        this.fi = rvVar;
    }

    public void x(int i) {
        this.f = i;
    }

    public boolean oa() {
        return this.f == 1;
    }

    public boolean sz() {
        return this.j == 3;
    }

    public boolean k() {
        return this.oj == 1;
    }

    public void fs(int i) {
        this.dh = i;
    }

    public int cy() {
        return this.dh;
    }

    public void rv(int i) {
        this.b = i;
    }

    public int hd() {
        int i = this.b;
        if (i < 2) {
            return 2;
        }
        return i;
    }

    public qg cd() {
        List<String> listN = com.byazt.vy.q.n();
        qg qgVar = new qg();
        qgVar.n = this.n;
        com.byazt.vy.q.n(listN, "mRitId");
        qgVar.qg = this.qg;
        com.byazt.vy.q.n(listN, "mRitType");
        qgVar.s = this.s;
        com.byazt.vy.q.n(listN, "mLookType");
        qgVar.q = this.q;
        com.byazt.vy.q.n(listN, "mMinWaitTime");
        qgVar.l = this.l;
        com.byazt.vy.q.n(listN, "mLayerTimeOut");
        qgVar.w = this.w;
        com.byazt.vy.q.n(listN, "mTotalTimeOut");
        qgVar.x = this.x;
        com.byazt.vy.q.n(listN, "mCacheTimeOut");
        qgVar.fs = this.fs;
        com.byazt.vy.q.n(listN, "mVersion");
        qgVar.hd = this.hd;
        com.byazt.vy.q.n(listN, "mWaterFallId");
        qgVar.wm = this.wm;
        com.byazt.vy.q.n(listN, "reqType");
        qgVar.a = this.a;
        com.byazt.vy.q.n(listN, "mWaterfallAbTestParam");
        qgVar.cd = this.cd;
        com.byazt.vy.q.n(listN, "segmentId");
        qgVar.um = this.um;
        com.byazt.vy.q.n(listN, "segmentVersion");
        qgVar.py = this.py;
        com.byazt.vy.q.n(listN, "preLoadSortControl");
        qgVar.ou = this.ou;
        com.byazt.vy.q.n(listN, "preShowSortControl");
        qgVar.m = this.m;
        com.byazt.vy.q.n(listN, "waterfallExtra");
        qgVar.hu = this.hu;
        com.byazt.vy.q.n(listN, "mMultilevelAfterP");
        qgVar.h = this.h;
        com.byazt.vy.q.n(listN, "mMultilevelTimeOut");
        qgVar.bb = this.bb;
        com.byazt.vy.q.n(listN, "mRefreshTime");
        qgVar.ln = this.ln;
        com.byazt.vy.q.n(listN, "mBidFloor");
        qgVar.j = this.j;
        com.byazt.vy.q.n(listN, "mParallelType");
        qgVar.an = this.an;
        com.byazt.vy.q.n(listN, "mReqParallelNum");
        qgVar.ae = this.ae;
        com.byazt.vy.q.n(listN, "mAdCount");
        qgVar.lh = this.lh;
        com.byazt.vy.q.n(listN, "serverSideVerifyPreRequestTime");
        qgVar.v = this.v;
        com.byazt.vy.q.n(listN, "serverSideRewardType");
        qgVar.oj = this.oj;
        com.byazt.vy.q.n(listN, "mAdPrime");
        qgVar.b = this.b;
        com.byazt.vy.q.n(listN, "mRefreshNum");
        qgVar.dh = this.dh;
        com.byazt.vy.q.n(listN, "mIsRefresh");
        qgVar.df = this.df;
        com.byazt.vy.q.n(listN, "mIntervalFreqctlBean");
        qgVar.fi = this.fi;
        com.byazt.vy.q.n(listN, "mIntervalPacingBean");
        qgVar.f = this.f;
        com.byazt.vy.q.n(listN, "mWaterFallTimingMode");
        qgVar.y = this.y;
        com.byazt.vy.q.n(listN, "mReqInterval");
        qgVar.wo = this.wo;
        com.byazt.vy.q.n(listN, "mTotalTimeoutRate");
        qgVar.sh = this.sh;
        com.byazt.vy.q.n(listN, "mLayerTimeoutRate");
        qgVar.yw = new HashMap(this.yw);
        qgVar.u = this.u;
        qgVar.pk = this.pk;
        qgVar.sz = this.sz;
        qgVar.cp = new HashMap(this.cp);
        com.byazt.vy.q.qg(listN, "AdsenseRitConfig");
        qgVar.ri = this.ri;
        com.byazt.vy.q.n(listN, "mBehaviorTTL");
        qgVar.nf = this.nf;
        com.byazt.vy.q.n(listN, "mIsSamste");
        qgVar.e = this.e;
        com.byazt.vy.q.n(listN, "fillStrategy");
        return qgVar;
    }

    /* JADX INFO: renamed from: um, reason: merged with bridge method [inline-methods] */
    public qg clone() {
        qg qgVar = new qg();
        qgVar.n = this.n;
        qgVar.qg = this.qg;
        qgVar.s = this.s;
        qgVar.q = this.q;
        qgVar.l = this.l;
        qgVar.w = this.w;
        qgVar.x = this.x;
        qgVar.fs = this.fs;
        qgVar.hd = this.hd;
        qgVar.wm = this.wm;
        qgVar.a = this.a;
        qgVar.cd = this.cd;
        qgVar.um = this.um;
        qgVar.py = this.py;
        qgVar.ou = this.ou;
        qgVar.m = this.m;
        qgVar.hu = this.hu;
        qgVar.h = this.h;
        qgVar.bb = this.bb;
        qgVar.ln = this.ln;
        qgVar.j = this.j;
        qgVar.an = this.an;
        qgVar.ae = this.ae;
        qgVar.lh = this.lh;
        qgVar.v = this.v;
        qgVar.oj = this.oj;
        qgVar.df = this.df;
        qgVar.fi = this.fi;
        qgVar.f = this.f;
        qgVar.t = this.t;
        qgVar.ur = this.ur;
        qgVar.dg = this.dg;
        qgVar.oa = this.oa;
        qgVar.cy = this.cy;
        qgVar.rv = new CopyOnWriteArrayList(this.rv);
        qgVar.tj = new HashMap(this.tj);
        qgVar.k = this.k;
        qgVar.d = new ArrayList(this.d);
        qgVar.yw = new HashMap(this.yw);
        qgVar.cp = new HashMap(this.cp);
        qgVar.u = this.u;
        qgVar.pk = this.pk;
        qgVar.sz = this.sz;
        qgVar.y = this.y;
        qgVar.wo = this.wo;
        qgVar.sh = this.sh;
        qgVar.dh = this.dh;
        qgVar.b = this.b;
        qgVar.ri = this.ri;
        qgVar.nf = this.nf;
        qgVar.e = this.e;
        qgVar.pe = this.pe;
        return qgVar;
    }

    public int a() {
        return this.ae;
    }

    public void tj(int i) {
        this.ae = i;
    }

    public double py() {
        return this.ln;
    }

    public void s(double d) {
        this.ln = d;
    }

    public int cp(int i) {
        if (rv() == 2) {
            int iN = com.byazt.cby.q.n(this.n, i, fs());
            if (this.bb != 0 && iN != 0) {
                return iN;
            }
        }
        return this.bb;
    }

    public void d(int i) {
        this.bb = i;
    }

    public String ou() {
        return this.m;
    }

    public void n(String str) {
        this.m = str;
    }

    public void oa(int i) {
        this.hu = i;
    }

    public long wm() {
        return this.h;
    }

    public void s(long j) {
        this.h = j;
    }

    public int m() {
        return this.wm;
    }

    public void sz(int i) {
        this.wm = i;
    }

    public int hu() {
        return this.cy;
    }

    public double h() {
        return this.oa;
    }

    public void q(double d) {
        this.oa = d;
    }

    public double t() {
        return this.sz;
    }

    public void l(double d) {
        this.sz = d;
    }

    public Map<Integer, List<tj>> ur() {
        HashMap map = new HashMap();
        Map<Integer, List<tj>> map2 = this.tj;
        if (map2 != null) {
            for (Map.Entry<Integer, List<tj>> entry : map2.entrySet()) {
                map.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return map;
    }

    public long bb() {
        return this.hd;
    }

    public void q(long j) {
        this.hd = j;
    }

    public void k(int i) {
        this.cd = i;
    }

    public int ln() {
        return this.cd;
    }

    public void qg(String str) {
        this.um = str;
    }

    public String lh() {
        return this.um;
    }

    public boolean v() {
        return this.t;
    }

    public void n(boolean z) {
        this.t = z;
    }

    public boolean j() {
        return this.ur;
    }

    public void qg(boolean z) {
        this.ur = z;
    }

    public String an() {
        return this.fs;
    }

    public void s(String str) {
        this.fs = str;
    }

    public List<Integer> ae() {
        return this.d;
    }

    public String f() {
        return this.n;
    }

    public void q(String str) {
        this.n = str;
    }

    public int fi() {
        return this.qg;
    }

    public void cy(int i) {
        this.qg = i;
    }

    public void hd(int i) {
        this.s = i;
    }

    public long df() {
        return this.q;
    }

    public void l(long j) {
        this.q = j;
    }

    public long oj() {
        return this.l;
    }

    public void w(long j) {
        this.l = j;
    }

    public long dg() {
        return this.w;
    }

    public void x(long j) {
        this.w = j;
    }

    public long u() {
        return this.x;
    }

    public void fs(long j) {
        this.x = j;
    }

    public void cd(int i) {
        this.lh = i;
    }

    public int pk() {
        return this.lh;
    }

    public void um(int i) {
        this.v = i;
    }

    public int wo() {
        return this.v;
    }

    public Map<Integer, List<tj>> sh() {
        return this.cp;
    }

    public List<tj> y() {
        return this.rv;
    }

    private void s(List<tj> list) {
        int iH;
        List<tj> arrayList;
        if (list == null) {
            return;
        }
        this.cp.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            tj tjVar = list.get(i2);
            if (tjVar != null) {
                if (tjVar.um() == 0) {
                    arrayList = new ArrayList<>();
                    iH = tjVar.t();
                } else if (tjVar.h() != i) {
                    arrayList = new ArrayList<>();
                    iH = tjVar.h();
                } else {
                    iH = i;
                    arrayList = this.cp.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tjVar);
                    this.cp.put(Integer.valueOf(iH), arrayList);
                }
                i = iH;
            }
        }
    }

    private void q(List<tj> list) {
        int iH;
        List<tj> arrayList;
        if (list == null) {
            return;
        }
        this.cp.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            tj tjVar = list.get(i2);
            if (tjVar != null) {
                if (tjVar.h() != i) {
                    arrayList = new ArrayList<>();
                    iH = tjVar.h();
                } else {
                    iH = i;
                    arrayList = this.cp.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tjVar);
                    this.cp.put(Integer.valueOf(iH), arrayList);
                }
                i = iH;
            }
        }
    }

    public void n(List<tj> list) {
        int iH;
        List<tj> arrayList;
        q(list);
        this.rv = list;
        if (list == null) {
            return;
        }
        this.k = 0;
        this.tj.clear();
        this.d.clear();
        this.cy = this.rv.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.rv.size(); i2++) {
            tj tjVar = list.get(i2);
            if (tjVar != null) {
                if (tjVar.h() != i) {
                    this.k++;
                    arrayList = new ArrayList<>();
                    iH = tjVar.h();
                } else {
                    iH = i;
                    arrayList = this.tj.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tjVar);
                    this.tj.put(Integer.valueOf(iH), arrayList);
                }
                i = iH;
            }
        }
        this.d.addAll(this.tj.keySet());
    }

    public void qg(List<tj> list) {
        int iH;
        List<tj> arrayList;
        s(list);
        this.rv = list;
        if (list == null) {
            return;
        }
        this.k = 0;
        this.tj.clear();
        this.d.clear();
        this.cy = this.rv.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.rv.size(); i2++) {
            tj tjVar = list.get(i2);
            if (tjVar != null) {
                if (tjVar.um() == 0) {
                    this.k++;
                    arrayList = new ArrayList<>();
                    iH = tjVar.t();
                } else if (tjVar.h() != i) {
                    this.k++;
                    arrayList = new ArrayList<>();
                    iH = tjVar.h();
                } else {
                    iH = i;
                    arrayList = this.tj.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(tjVar);
                    this.tj.put(Integer.valueOf(iH), arrayList);
                }
                i = iH;
            }
        }
        this.d.addAll(this.tj.keySet());
    }

    public String rf() {
        return this.a;
    }

    public void l(String str) {
        this.a = str;
    }

    public tj w(String str) {
        List<tj> list;
        if (!TextUtils.isEmpty(str) && (list = this.rv) != null && list.size() != 0) {
            for (tj tjVar : this.rv) {
                if (str.equals(tjVar.cd())) {
                    return tjVar;
                }
            }
        }
        return null;
    }

    public int dh() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public int b() {
        int i = this.an;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public void py(int i) {
        this.an = i;
    }

    public void n(JSONObject jSONObject) {
        this.dg = jSONObject;
    }

    public static qg x(String str) {
        if (TextUtils.isEmpty(str)) {
            com.byazt.rb.qg.n("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return n(new JSONObject(str), true);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static qg n(JSONObject jSONObject, boolean z) {
        String str = null;
        if (jSONObject == null) {
            return null;
        }
        qg qgVar = new qg();
        qgVar.n(jSONObject);
        qgVar.s(jSONObject.optDouble("bid_floor", 0.0d));
        qgVar.q(jSONObject.optString("rit_id"));
        qgVar.s(jSONObject.optString("version"));
        qgVar.q(jSONObject.optLong("waterfall_id", -1L));
        qgVar.cy(jSONObject.optInt("rit_type"));
        qgVar.hd(jSONObject.optInt("look_type", 1));
        qgVar.l(jSONObject.optLong("time_min", wm(qgVar.fi()).longValue()));
        qgVar.w(jSONObject.optLong("layer_time_out", 2000L));
        qgVar.x(jSONObject.optLong("total_time_out", m(qgVar.fi()).longValue()));
        qgVar.s(jSONObject.optLong("multilevel_time_out", 2000L));
        qgVar.fs(jSONObject.optLong("cache_time_out", 3000L));
        int i = 0;
        qgVar.sz(jSONObject.optInt(h.b.c, 0));
        com.byazt.qa.q.n().n(qgVar.f(), qgVar.m());
        qgVar.k(jSONObject.optInt("segment_id"));
        qgVar.qg(jSONObject.optString("segment_version"));
        qgVar.n(jSONObject.optString("waterfall_extra"));
        qgVar.oa(jSONObject.optInt("multilevel_after_p", 1));
        qgVar.d(jSONObject.optInt("refresh_time", 0));
        qgVar.fs(jSONObject.optInt("is_refresh", 0));
        qgVar.rv(jSONObject.optInt("refresh_num", 2));
        qgVar.a(jSONObject.optInt("parallel_type", 1));
        qgVar.w(jSONObject.optInt("is_adprime", 0));
        qgVar.py(jSONObject.optInt("req_parallel_num", 1));
        qgVar.cd(jSONObject.optInt("reward_start_time", 15000));
        qgVar.um(jSONObject.optInt("reward_callback_type"));
        qgVar.qg(jSONObject.optLong("req_interval", 1000L));
        qgVar.qg(jSONObject.optDouble("total_time_rate", 0.01d));
        qgVar.n(jSONObject.optDouble("layer_time_rate", 0.1d));
        qgVar.s(jSONObject.optInt("support_render_control", 0));
        qgVar.ou(jSONObject.optInt("behavior_ttl"));
        qgVar.n(jSONObject.optLong("save_time"));
        int iOptInt = jSONObject.optInt("ad_count", 0);
        if (iOptInt < 0) {
            iOptInt = 0;
        } else if (iOptInt > 3) {
            iOptInt = 3;
        }
        qgVar.tj(iOptInt);
        qgVar.q(jSONObject.optInt("group_type"));
        qgVar.l(jSONObject.optInt("bidding_time_out", 1000));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("waterfall_abtest");
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("waterfall_ab_version");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString.trim()) || TextUtils.equals(strOptString.trim(), AbstractJsonLexerKt.NULL)) {
                jSONObjectOptJSONObject.remove("waterfall_ab_version");
            }
            qgVar.l(jSONObjectOptJSONObject.toString());
        }
        int iOptInt2 = jSONObject.optInt("waterfall_timing_mode");
        qgVar.x(iOptInt2);
        if (qgVar.oa()) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (jSONObjectOptJSONObject2 != null) {
                qgVar.n(new com.byazt.bf.rv(qgVar.f(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONObjectOptJSONObject2.optString("waterfall_show_pacing"), jSONObjectOptJSONObject2.optString("waterfall_show_pacing_rule_id")));
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            qgVar.n(new com.byazt.bf.x(qgVar.f(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONArrayOptJSONArray == null ? "[]" : jSONArrayOptJSONArray.toString()));
        }
        qgVar.qg(jSONObject.optInt("is_smaste", 0));
        qgVar.n(jSONObject.optInt("fill_strategy", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            int i2 = 0;
            while (i2 < jSONArrayOptJSONArray2.length()) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    tj tjVar = new tj();
                    tjVar.s(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME));
                    if (com.byazt.qt.qg.n().s(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME))) {
                        tjVar.q(jSONObject2.optString("custom_adn_name"));
                    } else {
                        tjVar.q(str);
                    }
                    tjVar.fs(qgVar.rf());
                    String strOptString2 = jSONObject2.optString("adn_slot_id");
                    tjVar.l(strOptString2);
                    if (!z && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(qgVar.f())) {
                        com.byazt.yc.q.qg.put(strOptString2, qgVar.f());
                    }
                    tjVar.n(jSONObject2.optInt("is_refresh", i));
                    int iOptInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    tjVar.qg(iOptInt3);
                    if (tjVar.q()) {
                        JSONObject jSONObjectOptJSONObject3 = jSONObject2.optJSONObject("show_pacing_rule");
                        if (jSONObjectOptJSONObject3 != null) {
                            tjVar.n(new com.byazt.bf.rv(qgVar.f(), strOptString2, "", "", iOptInt3, jSONObjectOptJSONObject3.optString(k.G), jSONObjectOptJSONObject3.optString(a.C0017a.o)));
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                        try {
                            tjVar.n(new com.byazt.bf.x(qgVar.f(), strOptString2, "", jSONObject2.optString("show_freqctl_rules_version"), iOptInt3, jSONArrayOptJSONArray3 == null ? "[]" : jSONArrayOptJSONArray3.toString()));
                        } catch (JSONException unused) {
                            i = 0;
                            i2++;
                            str = null;
                        }
                    }
                    tjVar.tj(jSONObject2.optInt("req_bidding_type"));
                    tjVar.x(jSONObject2.optString("slot_cpm", "0"));
                    tjVar.w(jSONObject2.optString("discount"));
                    tjVar.qg(jSONObject2.optString("exchange_rate"));
                    tjVar.cp(jSONObject2.optInt("load_sort"));
                    tjVar.d(jSONObject2.optInt("show_sort"));
                    tjVar.q(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.byazt.qa.q.n().n(qgVar.f(), tjVar.cd(), tjVar.fs());
                    com.byazt.ra.n.n().n(qgVar.f(), tjVar.cd(), tjVar.fs());
                    try {
                        tjVar.fs(jSONObject2.optInt("if_is_ready", 1));
                        com.byazt.qa.q.n().qg(qgVar.f(), tjVar.cd(), tjVar.d());
                        com.byazt.ra.n.n().qg(qgVar.f(), tjVar.cd(), tjVar.d());
                        tjVar.l(jSONObject2.optInt("if_reuse_ads", 0));
                        com.byazt.ra.n.n().s(qgVar.f(), tjVar.cd(), tjVar.rv());
                        i = 0;
                        tjVar.x(jSONObject2.optInt("if_pre_request", 0));
                        com.byazt.ra.n.n().w(qgVar.f(), tjVar.cd(), tjVar.cp());
                        tjVar.rv(qgVar.fi());
                        tjVar.n("%1$s%2$sAdapter");
                        tjVar.w(jSONObject2.optInt("origin_type"));
                        tjVar.s(jSONObject2.optInt("sub_adtype"));
                        tjVar.n(qg(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                        try {
                            if (tjVar.um() == 1) {
                                try {
                                    qgVar.qg(true);
                                } catch (JSONException unused2) {
                                }
                            } else {
                                if (tjVar.um() == 2) {
                                    try {
                                        qgVar.n(true);
                                    } catch (JSONException unused3) {
                                    }
                                } else if (tjVar.um() == 3) {
                                    qgVar.qg(true);
                                } else if (tjVar.um() != 100) {
                                    if (qgVar.h() == -1.0d || qgVar.h() < tjVar.m()) {
                                        qgVar.q(tjVar.m());
                                    }
                                    if (qgVar.t() == -1.0d || qgVar.t() > tjVar.m()) {
                                        qgVar.l(tjVar.m());
                                    }
                                }
                                tjVar.tj(jSONObject2.optString("customer_adapter_json"));
                                arrayList.add(tjVar);
                                i2++;
                                str = null;
                            }
                            tjVar.tj(jSONObject2.optString("customer_adapter_json"));
                            arrayList.add(tjVar);
                        } catch (JSONException unused4) {
                        }
                    } catch (JSONException unused5) {
                        i = 0;
                    }
                } catch (JSONException unused6) {
                }
                i2++;
                str = null;
            }
        }
        Collections.sort(arrayList);
        if (qgVar.sz()) {
            qgVar.qg(arrayList);
        } else {
            qgVar.n(arrayList);
        }
        return qgVar;
    }

    private static Long wm(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private static Long m(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return 5000L;
            }
            if (i != 5) {
                if (i == 7 || i == 8) {
                    return 600000L;
                }
                return 10000L;
            }
        }
        return 10000L;
    }

    private static Map<String, String> qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys == null) {
                return null;
            }
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                    map.put(next, strOptString);
                }
            }
            if (map.size() == 0) {
                return null;
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public int ri() {
        return this.ri;
    }

    public void ou(int i) {
        this.ri = i;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.n + "', mIsSpeed=" + sz() + ", mHasServerbidding=" + this.t + ", mHasClientOrMultiLevel=" + this.ur + ", mRitType=" + this.qg + ", mLookType=" + this.s + ", mMinWaitTime=" + this.q + ", mLayerTimeOut=" + this.l + ", mTotalTimeOut=" + this.w + ", mWaterFallConfigList=" + this.rv + ", mWaterFallConfMap=" + this.tj + ", mLoadSortLevelList=" + this.d + ", mCurrentCommonAdMaxCpm=" + this.oa + ", mTotalLoadLevelCount=" + this.k + ", mTotalWaterFallCount=" + this.cy + ", mWaterfallAbTestParam=" + this.a + ", mServerSideVerifyPreRequestTime=" + this.lh + ", mServerSideVerifyRewardType=" + this.v + AbstractJsonLexerKt.END_OBJ;
    }
}
