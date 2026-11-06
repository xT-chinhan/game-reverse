package com.byazt.ob;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.bf.sz;
import com.byazt.q.AdBaseConstants;
import com.byazt.vy.d;
import com.byazt.vy.ou;
import com.byazt.vy.py;
import com.byazt.ws.rv;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 8})
public class s implements com.byazt.nw.qg, n {
    public long fs;
    public com.byazt.dd.qg n;
    public com.byazt.qn.qg q;
    public com.byazt.zb.qg qg;
    public rv s;
    public long x;
    public com.byazt.nw.n l = null;
    public volatile long w = -1;

    private List<com.byazt.sg.s> qg(List<com.byazt.sg.s> list) {
        String strQg;
        long jCurrentTimeMillis;
        ArrayList arrayList = new ArrayList();
        if (!py.n(list)) {
            arrayList.addAll(list);
        }
        if (this.n != null && !py.qg(list) && (this.n.n() || this.n.m())) {
            for (com.byazt.sg.s sVar : list) {
                ou.n(sVar, this.n.fs(), this.q, true);
                double dPk = this.q.pk();
                if (dPk > 0.0d && dPk > sVar.ta()) {
                    arrayList.remove(sVar);
                    String strValueOf = String.valueOf(sVar.ta());
                    String strRi = sVar.ri();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (d.n(this.n.fs())) {
                        strQg = d.qg();
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    } else {
                        strQg = null;
                        jCurrentTimeMillis = -1;
                    }
                    com.byazt.mj.n nVar = new com.byazt.mj.n(50100, com.byazt.mj.n.n(50100));
                    nVar.n("is_dex_adapter", Integer.valueOf(this.n.fi() ? 1 : 0));
                    com.byazt.gp.s.n(nVar, this.q, this.n.fs(), this.n.s(), this.n.x(), this.n.w(), n(this.n.oa()), this.x, strValueOf, strRi, strQg, jCurrentTimeMillis);
                    com.byazt.zb.qg qgVar = this.qg;
                    if (qgVar != null) {
                        com.byazt.zo.x.n(qgVar.s(), this.qg.s(sVar), this.qg.an());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.nw.qg
    public void n(List<com.byazt.sg.s> list) {
        long jCurrentTimeMillis;
        String strQg;
        if (list == null) {
            return;
        }
        if (this.w == -1) {
            this.w = SystemClock.elapsedRealtime();
        }
        this.x = System.currentTimeMillis() - this.fs;
        for (com.byazt.sg.s sVar : list) {
            com.byazt.qn.qg qgVar = this.q;
            com.byazt.dd.qg qgVar2 = this.n;
            com.byazt.yc.s.n(sVar, qgVar, qgVar2, this.s, qgVar2 != null ? n(qgVar2.oa()) : "");
        }
        List<com.byazt.sg.s> listQg = qg(list);
        if (listQg.size() != 0) {
            if (this.n != null) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (d.n(this.n.fs())) {
                    strQg = d.qg();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                } else {
                    jCurrentTimeMillis = -1;
                    strQg = null;
                }
                int i = (list == null || list.size() <= 0) ? 820001 : AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS;
                if (this.n.n() || this.n.m()) {
                    for (com.byazt.sg.s sVar2 : list) {
                        if (sVar2 != null) {
                            n(i, sVar2, 1, strQg, jCurrentTimeMillis);
                        }
                    }
                } else {
                    n(i, listQg.get(0), listQg.size(), strQg, jCurrentTimeMillis);
                }
                if (this.n.wm() && !py.qg(list)) {
                    com.byazt.gp.s.n(list.get(0), this.q, this.n.fs(), this.x);
                    com.byazt.zb.qg qgVar3 = this.qg;
                    if (qgVar3 != null) {
                        com.byazt.zo.x.n(qgVar3.s(), this.qg.qg(this.n.fs()), this.qg.an());
                    }
                }
            }
            this.qg = null;
            s(listQg);
            if (this.n.fs() != null) {
                if ((this.n.fs().oa() == 10 && this.n.fs().w() == 1) || (this.n.fs().oa() == 7 && this.n.fs().w() == 8)) {
                    n(listQg, (com.byazt.mj.n) null);
                    return;
                }
                return;
            }
            return;
        }
        n(new com.byazt.mj.n(50100, com.byazt.mj.n.n(50100)), false);
    }

    @Override // com.byazt.nw.qg
    public void n(com.byazt.mj.n nVar) {
        n(nVar, true);
    }

    private void n(com.byazt.mj.n nVar, boolean z) {
        long jCurrentTimeMillis;
        String strQg;
        this.x = System.currentTimeMillis() - this.fs;
        com.byazt.dd.qg qgVar = this.n;
        if (qgVar != null && qgVar.fs() != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (d.n(this.n.fs())) {
                strQg = d.qg();
                jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            } else {
                jCurrentTimeMillis = -1;
                strQg = null;
            }
            if (!this.n.wm() && z) {
                nVar.n("is_dex_adapter", Integer.valueOf(this.n.fi() ? 1 : 0));
                com.byazt.gp.s.n(nVar, this.q, this.n.fs(), this.n.s(), this.n.x(), this.n.w(), n(this.n.oa()), this.x, (String) null, (String) null, strQg, jCurrentTimeMillis);
            } else {
                com.byazt.gp.s.n(nVar, this.q, this.n.fs(), this.n.s(), this.n.x(), this.n.w(), n(this.n.oa()), this.x);
            }
            tj tjVarFs = this.n.fs();
            com.byazt.zb.qg qgVar2 = this.qg;
            if (qgVar2 != null) {
                com.byazt.zo.x.n(qgVar2.s(), this.qg.s(tjVarFs), this.qg.an());
            }
            this.qg = r13;
            if (nVar != null) {
                if (this.q != null) {
                    if (com.byazt.sg.qg.qg) {
                        StringBuilder sb = new StringBuilder();
                        com.byazt.qn.qg qgVar3 = this.q;
                        com.byazt.rb.qg.q(MediationConstant.TAG, sb.append(com.byazt.rb.q.n(qgVar3 != null ? qgVar3.a() : "", "fill_fail")).append("AdNetWorkName[").append(tjVarFs.k()).append("] AdUnitId[").append(tjVarFs.cd()).append("] AdType[").append(com.byazt.sg.n.n(this.q.um(), tjVarFs.w(), tjVarFs)).append("] 请求失败 (loadSort=").append(tjVarFs.h()).append(",showSort=").append(tjVarFs.t()).append("),error=").append(nVar.s).append(",msg=").append(nVar.q).toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        com.byazt.qn.qg qgVar4 = this.q;
                        com.byazt.rb.qg.q(MediationConstant.TAG, sb2.append(com.byazt.rb.q.n(qgVar4 != null ? qgVar4.a() : "", "fill_fail")).append("AdNetWorkName[").append(tjVarFs.k()).append("] AdType[").append(com.byazt.sg.n.n(this.q.um(), tjVarFs.w(), tjVarFs)).append("] 请求失败 error=").append(nVar.s).append(",msg=").append(nVar.q).toString());
                    }
                }
                String string = new StringBuilder().append(nVar.s).toString();
                String strN = com.byazt.xt.n.n(this.n.fs().k(), nVar.q);
                sz szVarN = sz.n();
                com.byazt.qn.qg qgVar5 = this.q;
                if (szVarN.n(qgVar5 == null ? null : qgVar5.a(), this.n.fs().hd())) {
                    sz szVarN2 = sz.n();
                    com.byazt.qn.qg qgVar6 = this.q;
                    szVarN2.n(qgVar6 == null ? null : qgVar6.a(), this.n.fs().k(), this.n.fs().cd(), com.byazt.xt.n.n(this.n.fs().k(), string, strN));
                } else {
                    com.byazt.bf.s.n().n(this.n.fs().k(), this.n.fs().cd(), com.byazt.xt.n.n(this.n.fs().k(), string, strN));
                }
            }
        }
        qg(nVar);
    }

    @Override // com.byazt.nw.qg
    public void n(final List<com.byazt.sg.s> list, com.byazt.mj.n nVar) {
        if (list != null) {
            for (com.byazt.sg.s sVar : list) {
                if (sVar != null) {
                    sVar.rv(true);
                    com.byazt.qn.qg qgVar = this.q;
                    com.byazt.dd.qg qgVar2 = this.n;
                    com.byazt.yc.s.n(sVar, qgVar, qgVar2, this.s, qgVar2 != null ? n(qgVar2.oa()) : "");
                    n(sVar);
                }
            }
        }
        if (nVar != null && nVar.n == 30010 && com.byazt.xt.n.n()) {
            com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ob.s.1
                @Override // java.lang.Runnable
                public void run() {
                    if (s.this.n != null && s.this.n.wm()) {
                        com.byazt.gp.s.n(!py.qg(list) ? (com.byazt.sg.s) list.get(0) : null, s.this.q, s.this.n.fs());
                    }
                    s.this.n();
                }
            }, 1000L);
            return;
        }
        com.byazt.dd.qg qgVar3 = this.n;
        if (qgVar3 != null && qgVar3.wm()) {
            com.byazt.gp.s.n(!py.qg(list) ? list.get(0) : null, this.q, this.n.fs());
        }
        n();
    }

    private void s(List<com.byazt.sg.s> list) {
        com.byazt.dd.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(list, qgVar.fs());
        }
        n(new Runnable() { // from class: com.byazt.ob.s.2
            @Override // java.lang.Runnable
            public void run() {
                if (s.this.n != null) {
                    com.byazt.bw.s.s(s.this.n.oa(), s.this.n.qg(), s.this.n.d());
                }
            }
        });
    }

    private void qg(com.byazt.mj.n nVar) {
        com.byazt.dd.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar, qgVar.fs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        com.byazt.dd.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.rv();
        }
    }

    private void n(Runnable runnable) {
        com.byazt.rb.l.n(runnable);
    }

    @Override // com.byazt.nw.qg
    public void n(com.byazt.sg.s sVar, String str) {
        if (sVar == null || sVar.ct() != 5) {
            return;
        }
        com.byazt.gp.s.n(sVar, this.q, str);
    }

    @Override // com.byazt.ob.n
    public void n(n.InterfaceC0279n interfaceC0279n) {
        if (interfaceC0279n == null) {
            return;
        }
        this.fs = System.currentTimeMillis();
        this.n = interfaceC0279n.n();
        com.byazt.zb.qg qgVarQg = interfaceC0279n.qg();
        this.q = qgVarQg.wm();
        this.s = qgVarQg.fi();
        this.qg = qgVarQg;
        if (qgVarQg.getContext() == null) {
            com.byazt.mj.n nVar = new com.byazt.mj.n("request adn context is null");
            n(this.n, qgVarQg, nVar, "");
            n(nVar);
        } else {
            if (this.n != null) {
                n(qgVarQg);
                return;
            }
            com.byazt.mj.n nVar2 = new com.byazt.mj.n("request adn waterfall request is null");
            n(this.n, qgVarQg, nVar2, "");
            n(nVar2);
        }
    }

    private void n(com.byazt.dd.qg qgVar, com.byazt.zb.qg qgVar2, com.byazt.mj.n nVar, String str) {
        if (qgVar == null || qgVar2 == null || qgVar.fs() == null) {
            return;
        }
        tj tjVarFs = qgVar.fs();
        String strN = TextUtils.isEmpty(str) ? com.byazt.ra.n.n().n(tjVarFs.cd()) : str;
        if (!tjVarFs.v()) {
            com.byazt.gp.s.n(tjVarFs, this.q, strN, qgVar.l(), qgVar.x() == 4 ? 3 : 0, qgVar.s(), qgVar.x(), qgVar.w(), nVar, qgVar.q(), qgVar2.fi().l, false, SystemClock.elapsedRealtime() - qgVar2.an());
            com.byazt.zo.x.n(qgVar2.s(), qgVar2.n(tjVarFs), qgVar2.an());
        } else if (tjVarFs.ln() != null) {
            com.byazt.gp.s.n(tjVarFs, this.q, strN);
            com.byazt.zo.x.n(qgVar2.s(), qgVar2.n(tjVarFs), qgVar2.an());
        }
    }

    private void n(com.byazt.sg.s sVar) {
        com.byazt.dd.qg qgVar;
        if (this.q == null || (qgVar = this.n) == null || qgVar.fs() == null) {
            return;
        }
        tj tjVarFs = this.n.fs();
        if (!this.n.wm() && sVar != null) {
            com.byazt.gp.s.n(this.q, sVar, this.n.fs());
        }
        if (com.byazt.sg.qg.qg) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.q.a(), "fill") + "AdNetWorkName[" + tjVarFs.k() + "] AdUnitId[" + tjVarFs.cd() + "] AdType[" + com.byazt.sg.n.n(this.q.um(), tjVarFs.w(), tjVarFs) + "] 视频缓存成功 (loadSort=" + tjVarFs.h() + ",showSort=" + tjVarFs.t() + ")");
        } else {
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.q.a(), "fill") + "AdNetWorkName[" + tjVarFs.k() + "] AdType[" + com.byazt.sg.n.n(this.q.um(), tjVarFs.w(), tjVarFs) + "] 视频缓存成功 ");
        }
    }

    private void n(int i, com.byazt.sg.s sVar, int i2, String str, long j) {
        com.byazt.dd.qg qgVar;
        tj tjVar;
        if (this.q == null || (qgVar = this.n) == null || qgVar.fs() == null) {
            return;
        }
        tj tjVarFs = this.n.fs();
        String str2 = i == 20000 ? "load success" : "请求成功，但无广告可用";
        rv rvVar = this.s;
        int i3 = (rvVar == null || !rvVar.w) ? 0 : 1;
        if (this.n.wm() || sVar == null) {
            tjVar = tjVarFs;
        } else {
            tjVar = tjVarFs;
            com.byazt.gp.s.n(sVar, i, str2, this.x, this.q, this.n.s(), i2, i3, str, j, this.w != -1 ? SystemClock.elapsedRealtime() - this.w : -1L);
            com.byazt.zb.qg qgVar2 = this.qg;
            if (qgVar2 != null) {
                com.byazt.zo.x.n(qgVar2.s(), this.qg.qg(sVar), this.qg.an());
            }
        }
        if (com.byazt.sg.qg.qg) {
            tj tjVar2 = tjVar;
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.q.a(), "fill") + "AdNetWorkName[" + tjVar.k() + "] AdUnitId[" + tjVar.cd() + "] AdType[" + com.byazt.sg.n.n(this.q.um(), tjVar.w(), tjVar2) + "] 请求成功 (loadSort=" + tjVar2.h() + ",showSort=" + tjVar2.t() + ")");
        } else {
            tj tjVar3 = tjVar;
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.q.a(), "fill") + "AdNetWorkName[" + tjVar3.k() + "] AdType[" + com.byazt.sg.n.n(this.q.um(), tjVar3.w(), tjVar3) + "] 请求成功");
        }
    }

    private void n(com.byazt.zb.qg qgVar) {
        com.byazt.dd.qg qgVar2;
        com.byazt.dd.qg qgVar3 = this.n;
        qgVar3.n(com.byazt.yc.s.n(this.q, qgVar3));
        this.n.qg(qgVar.cy().f());
        if (!this.n.tj()) {
            if (this.n.cp()) {
                this.l = com.byazt.ua.q.n(this.n, this);
            } else if (com.byazt.sq.s.n(this.n.fs())) {
                this.l = new com.byazt.ua.s(this);
            }
        } else {
            Context context = com.byazt.qt.qg.getContext();
            com.byazt.dd.qg qgVar4 = this.n;
            com.byazt.it.qg.n(context, qgVar4 != null ? qgVar4.oa() : "");
            if (com.byazt.ya.n.n(this.n.oa()) == null) {
                com.byazt.gp.s.n("", qgVar.k(), this.q, this.n.fs(), new com.byazt.mj.n(49014, "创建自定义广告对象 configuration is null"));
            } else {
                com.byazt.ws.n nVarN = com.byazt.ir.s.n().n(this.n.oa());
                if (nVarN == null) {
                    com.byazt.gp.s.n("", (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "创建自定义广告对象 adNetworkConfValue is null"));
                } else if (nVarN.q() == null) {
                    com.byazt.gp.s.n("", (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "创建自定义广告对象 getGMCustomConfig is null"));
                } else {
                    com.byazt.or.n nVarN2 = nVarN.q().n(this.n.h(), this.n.k());
                    if (nVarN2 == null) {
                        com.byazt.gp.s.n("", (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "创建自定义广告对象 adConfig is null"));
                    } else if (com.byazt.yc.s.n(nVarN2)) {
                        this.l = com.byazt.ua.q.n(nVarN2.n(), this.n, this);
                    } else {
                        com.byazt.gp.s.n("", (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "创建自定义广告对象 check className false className is " + nVarN2.n()));
                    }
                }
            }
        }
        com.byazt.nw.n nVar = this.l;
        if (nVar != null) {
            String strN = nVar.n(this.n.oa());
            if (!TextUtils.isEmpty(strN) && (qgVar2 = this.n) != null && !TextUtils.isEmpty(qgVar2.d()) && !this.n.tj()) {
                com.byazt.ra.n.n().q(this.n.d(), strN);
            }
            n(this.n, qgVar, null, strN);
            com.byazt.nw.n nVar2 = this.l;
            Context context2 = qgVar.getContext();
            com.byazt.dd.qg qgVar5 = this.n;
            com.byazt.qn.qg qgVar6 = this.q;
            nVar2.n(context2, qgVar5, qgVar6, com.byazt.yc.s.n(qgVar5, qgVar6, qgVar.v()));
            if (this.n.tj()) {
                return;
            }
            com.byazt.ra.n.n().n(this.n.qg(), this.n.d(), this.n.fs(), this.n.s());
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "**********【重要】" + this.n.oa() + "创建失败，请检查adapter是否接入 **********");
        com.byazt.gp.s.n(this.n.fs(), this.q, this.n.x(), this.n.w());
        n(this.n, qgVar, new com.byazt.mj.n("create adn loader fail"), "");
        n(new com.byazt.mj.n("create adn loader fail"));
    }

    private String n(String str) {
        com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str);
        if (qVarN != null) {
            return qVarN.qg();
        }
        return null;
    }
}
