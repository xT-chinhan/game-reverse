package com.byazt.zb;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.jp.cp;
import com.byazt.qa.q;
import com.byazt.rb.l;
import com.byazt.sg.s;
import com.byazt.vy.py;
import com.byazt.vy.x;
import com.byazt.ws.rv;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1166, 26})
public class qg {
    public com.byazt.qn.qg cp;
    public com.byazt.jg.n cy;
    public cp d;
    public String k;
    public long ln;
    public SoftReference<Context> n;
    public com.byazt.ws.qg oa;
    public Handler ou;
    public n sz;
    public q.s ur;
    public s w;
    public CopyOnWriteArrayList<s> qg = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<s> s = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<s> q = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<s> l = new CopyOnWriteArrayList<>();
    public final AtomicBoolean hd = new AtomicBoolean(false);
    public final AtomicBoolean cd = new AtomicBoolean(false);
    public final AtomicBoolean um = new AtomicBoolean(false);
    public final AtomicBoolean a = new AtomicBoolean(false);
    public volatile boolean py = false;
    public Map<String, com.byazt.nw.n> x = new ConcurrentHashMap();
    public long fs = 0;
    public long wm = 0;
    public AtomicBoolean m = new AtomicBoolean(false);
    public boolean hu = false;
    public boolean h = false;
    public boolean t = false;
    public final AtomicInteger bb = new AtomicInteger(0);
    public Map<String, Object> rv = new ConcurrentHashMap();
    public rv tj = new rv();
    public int lh = 0;
    public String v = null;
    public final AtomicBoolean j = new AtomicBoolean(false);
    public ConcurrentHashMap<String, com.byazt.mj.qg> an = new ConcurrentHashMap<>();
    public final JSONObject ae = new JSONObject();
    public final AtomicInteger f = new AtomicInteger(0);
    public final AtomicInteger fi = new AtomicInteger(0);
    public final AtomicInteger df = new AtomicInteger(0);
    public final AtomicInteger oj = new AtomicInteger(0);
    public final AtomicInteger dg = new AtomicInteger(0);
    public final AtomicInteger u = new AtomicInteger(0);
    public final AtomicInteger pk = new AtomicInteger(0);
    public final AtomicInteger wo = new AtomicInteger(0);
    public final AtomicInteger sh = new AtomicInteger(0);
    public final AtomicInteger y = new AtomicInteger(0);
    public final AtomicInteger rf = new AtomicInteger(0);
    public final AtomicInteger dh = new AtomicInteger(0);
    public final AtomicInteger b = new AtomicInteger(0);

    private qg() {
    }

    public static qg n(SoftReference<Context> softReference, com.byazt.qn.qg qgVar, com.byazt.jg.n nVar) {
        qg qgVar2 = new qg();
        com.byazt.ws.qg qgVarN = com.byazt.qt.qg.n().n(qgVar.a(), qgVar.um(), 100);
        qgVar.n(qgVarN);
        qgVar2.cp = qgVar;
        qgVar2.oa = qgVarN;
        if (qgVarN != null) {
            qgVar2.rv.put("render_control", Integer.valueOf(qgVarN.q()));
        }
        qgVar2.cp.q(com.byazt.qt.qg.n().yw());
        qgVar2.cp.qg(com.byazt.qt.qg.n().hd());
        qgVar2.cp.n(com.byazt.sq.s.w());
        qgVar2.cp.n(com.byazt.sq.s.l());
        qgVar2.cp.s(q.n().qg(qgVar2.cp.a(), com.byazt.qt.qg.n().yw()));
        qgVar2.tj.s = com.byazt.qt.qg.n().hd();
        qgVar2.n = softReference;
        qgVar2.cy = nVar;
        qgVar2.sz = new n();
        return qgVar2;
    }

    public String n(s sVar) {
        if (sVar == null) {
            return "r_" + this.oj.incrementAndGet();
        }
        if (sVar.ze()) {
            return "r_" + this.oj.incrementAndGet();
        }
        if (sVar.qn()) {
            return "p_r_" + this.f.incrementAndGet();
        }
        if (sVar.dm()) {
            return "sb_r_" + this.y.incrementAndGet();
        }
        if (sVar.o()) {
            return "cb_r_" + this.pk.incrementAndGet();
        }
        return "r_" + this.oj.incrementAndGet();
    }

    public String qg(s sVar) {
        if (sVar == null) {
            return "f_" + this.dg.incrementAndGet();
        }
        if (sVar.ze()) {
            return "f_" + this.dg.incrementAndGet();
        }
        if (sVar.qn()) {
            return "p_f_" + this.fi.incrementAndGet();
        }
        if (sVar.dm()) {
            return "sb_f_" + this.rf.incrementAndGet();
        }
        if (sVar.o()) {
            return "cb_f_" + this.wo.incrementAndGet();
        }
        return "f_" + this.dg.incrementAndGet();
    }

    public String s(s sVar) {
        if (sVar == null) {
            return "fa_" + this.u.incrementAndGet();
        }
        if (sVar.ze()) {
            return "fa_" + this.u.incrementAndGet();
        }
        if (sVar.qn()) {
            return "p_fa_" + this.df.incrementAndGet();
        }
        if (sVar.dm()) {
            return "sb_fa_" + this.dh.incrementAndGet();
        }
        if (sVar.o()) {
            return "cb_fa_" + this.sh.incrementAndGet();
        }
        return "fa_" + this.u.incrementAndGet();
    }

    public String n(tj tjVar) {
        if (tjVar == null) {
            return "r_" + this.oj.incrementAndGet();
        }
        if (tjVar.fi()) {
            return "r_" + this.oj.incrementAndGet();
        }
        if (tjVar.an()) {
            return "p_r_" + this.f.incrementAndGet();
        }
        if (tjVar.v()) {
            return "sb_r_" + this.y.incrementAndGet();
        }
        if (tjVar.j()) {
            return "cb_r_" + this.pk.incrementAndGet();
        }
        return "r_" + this.oj.incrementAndGet();
    }

    public String qg(tj tjVar) {
        if (tjVar == null) {
            return "f_" + this.dg.incrementAndGet();
        }
        if (tjVar.fi()) {
            return "f_" + this.dg.incrementAndGet();
        }
        if (tjVar.an()) {
            return "p_f_" + this.fi.incrementAndGet();
        }
        if (tjVar.v()) {
            return "sb_f_" + this.rf.incrementAndGet();
        }
        if (tjVar.j()) {
            return "cb_f_" + this.wo.incrementAndGet();
        }
        return "f_" + this.dg.incrementAndGet();
    }

    public String s(tj tjVar) {
        if (tjVar == null) {
            return "fa_" + this.u.incrementAndGet();
        }
        if (tjVar.fi()) {
            return "fa_" + this.u.incrementAndGet();
        }
        if (tjVar.an()) {
            return "p_fa_" + this.df.incrementAndGet();
        }
        if (tjVar.v()) {
            return "sb_fa_" + this.dh.incrementAndGet();
        }
        if (tjVar.j()) {
            return "cb_fa_" + this.sh.incrementAndGet();
        }
        return "fa_" + this.u.incrementAndGet();
    }

    public AtomicInteger n() {
        return this.b;
    }

    public void n(int i) {
        this.lh = i;
    }

    public String qg() {
        return this.v;
    }

    public JSONObject s() {
        return this.ae;
    }

    public boolean q() {
        return this.hd.get();
    }

    public boolean l() {
        return this.cd.get();
    }

    public boolean w() {
        return this.um.get();
    }

    public boolean x() {
        com.byazt.ws.qg qgVar = this.oa;
        return qgVar != null && qgVar.n() == 1;
    }

    public void n(final String str) {
        l.q(new Runnable() { // from class: com.byazt.zb.qg.1
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.cy != null) {
                    qg.this.cy.n(str);
                }
            }
        });
    }

    public void q(tj tjVar) {
        Map<String, Object> mapFs;
        if (this.a.get()) {
            return;
        }
        List<s> listN = n(true);
        if (listN.size() < this.cp.m()) {
            return;
        }
        this.a.set(true);
        if (tjVar != null) {
            this.v = tjVar.cd();
        }
        int iM = listN.size() > this.cp.m() ? this.cp.m() : listN.size();
        com.byazt.ws.qg qgVar = this.oa;
        if (qgVar != null) {
            mapFs = qgVar.fs();
            mapFs.put("has_serverBidding", Boolean.valueOf(this.oa.v()));
        } else {
            mapFs = null;
        }
        com.byazt.qn.qg qgVar2 = this.cp;
        s sVar = this.w;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fs;
        int iU = u();
        int iQg = qg(this.sz.cp());
        com.byazt.ws.qg qgVar3 = this.oa;
        com.byazt.gp.s.n(mapFs, qgVar2, sVar, jElapsedRealtime, iU, iQg, 0, qgVar3 != null ? qgVar3.rf() : null, iM, this.lh, this.oa, this.ae);
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "广告加载成功！给外部回调：invokeAdQuickLoadSuccessOnMainUI........P.size:" + cp().size() + "   bidding.size:" + sz().size() + "   normal.size:" + d().size());
        l.s(new Runnable() { // from class: com.byazt.zb.qg.2
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.cy != null) {
                    qg.this.cy.x();
                }
            }
        });
        pk();
    }

    public void fs() {
        Map<String, Object> map;
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + " v2 load done..........s:" + q() + "  f:" + l() + "     p.size" + cp().size() + "   bidding.size:" + sz().size() + "   normal.size:" + d().size() + "   underNormal.size:" + oa().size() + " is_p:" + h());
        if (q() || l()) {
            return;
        }
        this.hd.set(true);
        Handler handler = this.ou;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<s> listN = n(false);
        s(listN);
        if (!this.cp.nf() && !this.h) {
            com.byazt.cby.q.n(this.oa, !py.qg(listN) ? listN.get(0).ta() : 0.0d, this.cp.a(), this.cp.um());
        }
        if (h()) {
            w(true);
            return;
        }
        if (this.a.get()) {
            return;
        }
        int iM = listN.size() > this.cp.m() ? this.cp.m() : listN.size();
        com.byazt.ws.qg qgVar = this.oa;
        if (qgVar != null) {
            Map<String, Object> mapFs = qgVar.fs();
            mapFs.put("has_serverBidding", Boolean.valueOf(this.oa.v()));
            map = mapFs;
        } else {
            map = null;
        }
        if (!hu()) {
            com.byazt.qn.qg qgVar2 = this.cp;
            s sVar = this.w;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fs;
            int iU = u();
            int iQg = qg(this.sz.cp());
            com.byazt.ws.qg qgVar3 = this.oa;
            com.byazt.gp.s.n(map, qgVar2, sVar, jElapsedRealtime, iU, iQg, 0, qgVar3 != null ? qgVar3.rf() : null, iM, this.lh, this.oa, this.ae);
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + cp().size() + "   bidding.size:" + sz().size() + "   normal.size:" + d().size());
        l.s(new Runnable() { // from class: com.byazt.zb.qg.3
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.cy != null) {
                    qg.this.cy.x();
                }
            }
        });
        pk();
    }

    public void n(List<s> list) {
        if (x() && this.a.get()) {
            s(list);
        }
    }

    private void s(List<s> list) {
        ArrayList arrayList;
        if (this.j.get()) {
            return;
        }
        this.j.set(true);
        if ((!h() && (h() || this.h)) || this.oa == null || this.cp.nf()) {
            return;
        }
        if (this.oa.v() || this.oa.j()) {
            ArrayList arrayList2 = null;
            s sVar = list.size() > 0 ? list.get(0) : null;
            int iM = this.cp.m();
            if (iM > 1) {
                ArrayList arrayList3 = new ArrayList();
                for (int i = 1; i < iM; i++) {
                    if (i < list.size()) {
                        arrayList3.add(list.get(i));
                    }
                }
                if (list.size() > iM) {
                    arrayList2 = new ArrayList();
                    while (iM < list.size()) {
                        s sVar2 = list.get(iM);
                        if (sVar2 != null && sVar2.dm()) {
                            arrayList2.add(sVar2);
                        }
                        iM++;
                    }
                }
                arrayList = arrayList2;
                arrayList2 = arrayList3;
            } else {
                arrayList = null;
            }
            com.byazt.gp.s.n(sVar, this.cp, arrayList2, arrayList);
        }
    }

    public void n(com.byazt.mj.n nVar) {
        Handler handler;
        if (nVar == null) {
            nVar = new com.byazt.mj.n(20005, com.byazt.mj.n.n(20005));
        }
        if ((!com.byazt.we.n.n(this.oa) || nVar.n != 10003) && (handler = this.ou) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (q() || l() || this.a.get()) {
            return;
        }
        this.cd.set(true);
        fi().l = true;
        if (!hu()) {
            com.byazt.gp.s.n(this.cp, nVar, this.tj.n);
        }
        if (h()) {
            w(false);
            return;
        }
        if (com.byazt.rb.qg.qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + nVar.n + " error Message = " + nVar.qg);
        }
        final com.byazt.mj.n nVarN = x.n(this.cp, nVar, ur());
        l.s(new Runnable() { // from class: com.byazt.zb.qg.4
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.cy != null) {
                    qg.this.cy.qg(nVarN);
                }
            }
        });
    }

    public void rv() {
        if (h() || l() || w()) {
            return;
        }
        if (q() || this.a.get()) {
            com.byazt.qn.qg qgVar = this.cp;
            if (qgVar != null && (qgVar.um() == 7 || this.cp.um() == 8 || this.cp.um() == 10)) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
                com.byazt.gp.s.n(this.cp, k(), SystemClock.elapsedRealtime() - ae());
            }
            this.um.set(true);
            l.s(new Runnable() { // from class: com.byazt.zb.qg.5
                @Override // java.lang.Runnable
                public void run() {
                    if (qg.this.cy != null) {
                        qg.this.cy.fs();
                    }
                }
            });
        }
    }

    public void n(final List<s> list, final com.byazt.mj.n nVar) {
        com.byazt.ws.qg qgVar = this.oa;
        if (qgVar == null || !qgVar.k()) {
            return;
        }
        if (tj()) {
            nVar = new com.byazt.mj.n(41044, com.byazt.mj.n.n(41044));
            list = null;
        }
        if (h()) {
            return;
        }
        if (!py.n(list)) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (s sVar : list) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.cp.a(), "fill") + "AdNetWorkName[" + sVar.lq() + "] AdUnitId[" + sVar.el() + "]  请求成功 (loadSort=" + sVar.la() + ",showSort=" + sVar.il() + ")");
            }
        }
        if (nVar != null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.oa) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + nVar.n + "  errorMsg:" + nVar.qg);
        }
        l.s(new Runnable() { // from class: com.byazt.zb.qg.6
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.cy != null) {
                    qg.this.cy.n(list, nVar);
                }
            }
        });
    }

    public boolean tj() {
        return this.py;
    }

    public CopyOnWriteArrayList<s> cp() {
        return this.l;
    }

    public CopyOnWriteArrayList<s> d() {
        return this.qg;
    }

    public CopyOnWriteArrayList<s> oa() {
        return this.s;
    }

    public CopyOnWriteArrayList<s> sz() {
        return this.q;
    }

    public s k() {
        return this.w;
    }

    public void q(s sVar) {
        this.w = sVar;
    }

    public com.byazt.ws.qg cy() {
        return this.oa;
    }

    public void n(com.byazt.ws.qg qgVar) {
        this.oa = qgVar;
    }

    public n hd() {
        return this.sz;
    }

    public void qg(List<s> list) {
        s sVar;
        if (py.n(list) || (sVar = list.get(0)) == null) {
            return;
        }
        if (sVar.qn()) {
            this.l.addAll(list);
            return;
        }
        if (sVar.ze()) {
            this.qg.addAll(list);
        } else if (sVar.dm() || sVar.o() || sVar.nk()) {
            this.q.addAll(list);
        }
    }

    public boolean cd() {
        int size = this.l.size();
        com.byazt.qn.qg qgVar = this.cp;
        return size >= (qgVar != null ? qgVar.m() : 1);
    }

    public boolean um() {
        int size = this.l.size() + this.qg.size();
        com.byazt.qn.qg qgVar = this.cp;
        return size >= (qgVar != null ? qgVar.m() : 1);
    }

    public boolean a() {
        int size = this.l.size() + this.qg.size() + this.q.size();
        com.byazt.qn.qg qgVar = this.cp;
        return size >= (qgVar != null ? qgVar.m() : 1);
    }

    public boolean py() {
        return !this.oa.j() || this.sz.l(-100) || this.sz.w();
    }

    private boolean dg() {
        return !this.oa.v() || this.sz.l(0) || this.sz.x();
    }

    public boolean ou() {
        return py() && dg();
    }

    public com.byazt.qn.qg wm() {
        return this.cp;
    }

    public Context getContext() {
        return this.n.get();
    }

    public List<s> n(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (!py.n(this.qg)) {
            arrayList.addAll(this.qg);
        }
        if (!py.n(this.q)) {
            arrayList.addAll(this.q);
        }
        com.byazt.sq.s.n(arrayList, z ? com.byazt.sq.s.qg() : com.byazt.sq.s.n());
        if (!py.n(this.l)) {
            com.byazt.sq.s.n(this.l, (Comparator<s>) null);
            arrayList.addAll(0, this.l);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            s sVar = (s) arrayList.get(i);
            sVar.ta();
            sVar.xi();
        }
        return arrayList;
    }

    public Map<String, com.byazt.nw.n> m() {
        return this.x;
    }

    public boolean hu() {
        return this.t;
    }

    public void qg(boolean z) {
        this.t = z;
    }

    public boolean h() {
        return this.hu;
    }

    public void s(boolean z) {
        this.hu = z;
    }

    public void q(boolean z) {
        this.h = z;
    }

    public ConcurrentHashMap<String, com.byazt.mj.qg> t() {
        return this.an;
    }

    public void n(ConcurrentHashMap<String, com.byazt.mj.qg> concurrentHashMap) {
        this.an = concurrentHashMap;
    }

    public List<com.byazt.mj.qg> ur() {
        com.byazt.mj.qg value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.byazt.mj.qg> entry : t().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.w()) && !TextUtils.equals("广告请求中", value.w())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void n(q.s sVar) {
        this.ur = sVar;
    }

    public int bb() {
        return this.bb.get();
    }

    public void ln() {
        this.bb.incrementAndGet();
    }

    public void n(long j) {
        this.ln = j;
    }

    public long lh() {
        return this.ln;
    }

    public Map<String, Object> v() {
        return this.rv;
    }

    public cp j() {
        return this.d;
    }

    public void n(cp cpVar) {
        this.d = cpVar;
    }

    public void n(Handler handler) {
        this.ou = handler;
    }

    public long an() {
        return this.fs;
    }

    public void qg(long j) {
        this.fs = j;
    }

    public long ae() {
        return this.wm;
    }

    public void s(long j) {
        this.wm = j;
    }

    public boolean f() {
        return this.m.get();
    }

    public void l(boolean z) {
        this.m.set(z);
    }

    public rv fi() {
        return this.tj;
    }

    public void n(rv rvVar) {
        this.tj = rvVar;
    }

    public String df() {
        return this.k;
    }

    public void qg(String str) {
        this.k = str;
    }

    public void oj() {
        l.n(new Runnable() { // from class: com.byazt.zb.qg.7
            @Override // java.lang.Runnable
            public void run() {
                qg.this.py = true;
                if (qg.this.qg != null) {
                    qg.this.qg.clear();
                }
                if (qg.this.s != null) {
                    qg.this.s.clear();
                }
                if (qg.this.q != null) {
                    qg.this.q.clear();
                }
                if (qg.this.l != null) {
                    qg.this.l.clear();
                }
                if (qg.this.ou != null) {
                    qg.this.ou.removeCallbacksAndMessages(null);
                }
                qg.this.sz.d();
                qg.this.d = null;
                if (qg.this.cd.get() || qg.this.hd.get()) {
                    return;
                }
                qg.this.n(new com.byazt.pu.n(41044, com.byazt.mj.n.n(41044)));
            }
        });
    }

    private int u() {
        List<tj> list;
        com.byazt.ws.qg qgVar = this.oa;
        int size = 0;
        if (qgVar == null) {
            return 0;
        }
        Map<Integer, List<tj>> mapUr = qgVar.ur();
        if (mapUr != null && mapUr.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(mapUr.keySet());
            for (Integer num : arrayList) {
                if (this.sz.s(num.intValue()) && (list = mapUr.get(num)) != null) {
                    size += list.size();
                }
            }
        }
        return size;
    }

    public int qg(int i) {
        if (this.sz.n() == null) {
            return -1;
        }
        return this.sz.n().indexOf(Integer.valueOf(i)) + 1;
    }

    private void pk() {
        if (h() || l() || w()) {
            return;
        }
        if (q() || this.a.get()) {
            if (wo()) {
                rv();
            } else {
                final long jN = com.byazt.qt.qg.n().n(this.cp.um(), this.cp.a());
                l.n(new Runnable() { // from class: com.byazt.zb.qg.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.rb.qg.s(MediationConstant.TAG, com.byazt.rb.q.n(qg.this.oa) + "m-sdk----设置 cacheTimeout 已到时间【" + jN + "】，给外部invokeAdVideoCache ...");
                        qg.this.rv();
                    }
                }, jN);
            }
        }
    }

    private boolean wo() {
        if (cp() != null) {
            Iterator<s> it = cp().iterator();
            while (it.hasNext()) {
                if (it.next().jw()) {
                    return true;
                }
            }
        }
        if (sz() != null) {
            Iterator<s> it2 = sz().iterator();
            while (it2.hasNext()) {
                if (it2.next().jw()) {
                    return true;
                }
            }
        }
        if (d() == null) {
            return false;
        }
        Iterator<s> it3 = d().iterator();
        while (it3.hasNext()) {
            if (it3.next().jw()) {
                return true;
            }
        }
        return false;
    }

    private void w(final boolean z) {
        l.n(new Runnable() { // from class: com.byazt.zb.qg.9
            @Override // java.lang.Runnable
            public void run() {
                if (qg.this.ur != null) {
                    qg.this.ur.n(qg.this.cp.a(), z, 0, null);
                }
            }
        });
    }
}
