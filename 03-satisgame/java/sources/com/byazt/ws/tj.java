package com.byazt.ws;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 890, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj implements Comparable<tj> {
    public Map<String, String> a;
    public int cd;
    public String cp;
    public int cy;
    public String d;
    public int fs;
    public int h;
    public int hd;
    public com.byazt.bf.x hu;
    public int k;
    public com.byazt.bf.rv m;
    public String n;
    public String oa;
    public String ou;
    public int py;
    public String qg;
    public int rv;
    public String s;
    public int sz;
    public int tj;
    public fs um;
    public String w;
    public int wm;
    public int x;
    public String q = "1";
    public String l = "0";

    public void n(int i) {
        this.h = i;
    }

    public int n() {
        return this.h;
    }

    public com.byazt.bf.x qg() {
        return this.hu;
    }

    public void n(com.byazt.bf.x xVar) {
        this.hu = xVar;
    }

    public com.byazt.bf.rv s() {
        return this.m;
    }

    public void n(com.byazt.bf.rv rvVar) {
        this.m = rvVar;
    }

    public void qg(int i) {
        this.wm = i;
    }

    public boolean q() {
        return this.wm == 1;
    }

    public tj l() {
        ConcurrentHashMap concurrentHashMap;
        List<String> listQg = com.byazt.vy.q.qg();
        tj tjVar = new tj();
        tjVar.n = this.n;
        com.byazt.vy.q.n(listQg, "mAdnetworkName");
        tjVar.s = this.s;
        com.byazt.vy.q.n(listQg, "mAdnetwokrSlotId");
        tjVar.q = this.q;
        com.byazt.vy.q.n(listQg, "mExchangeRate");
        tjVar.l = this.l;
        com.byazt.vy.q.n(listQg, "mEcpm");
        tjVar.w = this.w;
        com.byazt.vy.q.n(listQg, "mDiscount");
        tjVar.x = this.x;
        com.byazt.vy.q.n(listQg, "mAdnetworkSlotType");
        tjVar.fs = this.fs;
        com.byazt.vy.q.n(listQg, "mLoadSort");
        tjVar.rv = this.rv;
        com.byazt.vy.q.n(listQg, "mShowSort");
        tjVar.tj = this.tj;
        com.byazt.vy.q.n(listQg, "mRitType");
        tjVar.cy = this.cy;
        com.byazt.vy.q.n(listQg, "originType");
        tjVar.py = this.py;
        com.byazt.vy.q.n(listQg, "mSubAdType");
        tjVar.cp = this.cp;
        com.byazt.vy.q.n(listQg, "mLoaderAdapterName");
        tjVar.d = this.d;
        com.byazt.vy.q.n(listQg, "mWaterfallAbTestParam");
        tjVar.oa = this.oa;
        com.byazt.vy.q.n(listQg, "mServerBiddingExtra");
        tjVar.sz = this.sz;
        com.byazt.vy.q.n(listQg, "adExpiredTime");
        tjVar.k = this.k;
        com.byazt.vy.q.n(listQg, "ifReuseAds");
        tjVar.hd = this.hd;
        com.byazt.vy.q.n(listQg, "ifPreRequest");
        tjVar.cd = this.cd;
        com.byazt.vy.q.n(listQg, "ifIsReady");
        tjVar.h = this.h;
        com.byazt.vy.q.n(listQg, "isRefresh");
        tjVar.qg = this.qg;
        com.byazt.vy.q.n(listQg, "mCustomAdnetworkName");
        Map<String, String> map = this.a;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.a);
        }
        tjVar.a = concurrentHashMap;
        com.byazt.vy.q.n(listQg, "mMultilevelSlotCpm");
        tjVar.ou = this.ou;
        com.byazt.vy.q.n(listQg, "mCustomAdapterJson");
        tjVar.wm = this.wm;
        com.byazt.vy.q.n(listQg, "mAdnRitTimingMode");
        tjVar.hu = this.hu;
        com.byazt.vy.q.n(listQg, "mIntervalFreqctlBean");
        tjVar.m = this.m;
        com.byazt.vy.q.n(listQg, "mIntervalPacingBean");
        com.byazt.vy.q.qg(listQg, "WaterFallConfig");
        return tjVar;
    }

    public int w() {
        return this.py;
    }

    public void s(int i) {
        this.py = i;
    }

    public String x() {
        return this.cp;
    }

    public void n(String str) {
        this.cp = str;
    }

    public int fs() {
        return this.sz;
    }

    public void q(int i) {
        this.sz = i;
    }

    public int rv() {
        return this.k;
    }

    public void l(int i) {
        this.k = i;
    }

    public int tj() {
        return this.cy;
    }

    public void w(int i) {
        this.cy = i;
    }

    public int cp() {
        return this.hd;
    }

    public void x(int i) {
        this.hd = i;
    }

    public int d() {
        return this.cd;
    }

    public void fs(int i) {
        this.cd = i;
    }

    public int oa() {
        return this.tj;
    }

    public void rv(int i) {
        this.tj = i;
    }

    public String sz() {
        return this.q;
    }

    public void qg(String str) {
        this.q = str;
    }

    public String k() {
        return this.n;
    }

    public void s(String str) {
        this.n = str;
    }

    public String cy() {
        return this.qg;
    }

    public void q(String str) {
        this.qg = str;
    }

    public String hd() {
        return TextUtils.isEmpty(this.n) ? this.qg : this.n;
    }

    public String cd() {
        return this.s;
    }

    public void l(String str) {
        this.s = str;
    }

    public int um() {
        return this.x;
    }

    public void tj(int i) {
        this.x = i;
    }

    public boolean a() {
        int i = this.x;
        return i == 0 || i == 100;
    }

    public double py() {
        fs fsVar = this.um;
        if (fsVar != null && !TextUtils.isEmpty(fsVar.l())) {
            try {
                return Double.valueOf(this.um.l()).doubleValue();
            } catch (Exception e) {
                com.byazt.rb.qg.q("WaterFallConfig", "getServerBiddingShowEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public double ou() {
        fs fsVar = this.um;
        if (fsVar != null && !TextUtils.isEmpty(fsVar.w())) {
            try {
                return Double.valueOf(this.um.w()).doubleValue();
            } catch (Exception e) {
                com.byazt.rb.qg.q("WaterFallConfig", "getServerBiddingLoadEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public String wm() {
        return this.w;
    }

    public void w(String str) {
        this.w = str;
    }

    public double m() {
        try {
            return Double.valueOf(this.l).doubleValue() * Double.valueOf(this.q).doubleValue();
        } catch (Exception e) {
            com.byazt.rb.qg.q("WaterFallConfig", "getEcpm error " + e.toString());
            return 0.0d;
        }
    }

    public double hu() {
        if (TextUtils.isEmpty(this.w)) {
            return m();
        }
        try {
            double d = Double.parseDouble(this.w);
            if (d > 0.0d && d <= 100.0d) {
                return (m() * d) / 100.0d;
            }
            return m();
        } catch (Exception unused) {
            return m();
        }
    }

    public void x(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.l = str;
    }

    public int h() {
        return this.fs;
    }

    public void cp(int i) {
        this.fs = i;
    }

    public int t() {
        return this.rv;
    }

    public void d(int i) {
        this.rv = i;
    }

    public String ur() {
        return this.d;
    }

    public void fs(String str) {
        this.d = str;
    }

    public String bb() {
        return this.oa;
    }

    public void rv(String str) {
        this.oa = str;
    }

    public void n(fs fsVar) {
        this.um = fsVar;
    }

    public fs ln() {
        return this.um;
    }

    public Map<String, String> lh() {
        return this.a;
    }

    public void n(Map<String, String> map) {
        this.a = map;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.n + "', mCustomAdnetworkName='" + this.qg + "', mAdnetwokrSlotId='" + this.s + "', mExchangeRate=" + this.q + ", mSlotEcpm=" + this.l + ", mAdnetworkSlotType=" + this.x + ", mLoadSort=" + this.fs + ", mShowSort=" + this.rv + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean v() {
        return this.x == 2;
    }

    public boolean j() {
        return this.x == 1;
    }

    public boolean an() {
        return this.x == 100;
    }

    public boolean ae() {
        return this.x == 3;
    }

    public boolean f() {
        return v() || j() || ae();
    }

    public boolean fi() {
        return this.x == 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(tj tjVar) {
        if (tjVar == null || this.fs > tjVar.h()) {
            return 1;
        }
        if (this.fs < tjVar.h()) {
            return -1;
        }
        if (this.rv > tjVar.t()) {
            return 1;
        }
        return this.rv < tjVar.t() ? -1 : 0;
    }

    public void tj(String str) {
        this.ou = str;
    }

    public String df() {
        return this.ou;
    }

    public boolean oj() {
        return com.byazt.qt.qg.n().s(this.n);
    }
}
