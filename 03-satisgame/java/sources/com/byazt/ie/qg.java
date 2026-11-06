package com.byazt.ie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.vy.py;
import com.byazt.vy.wm;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 26})
public class qg implements com.byazt.ow.n, n {
    public List<Integer> fs;
    public com.byazt.ws.qg l;
    public Map<Integer, List<com.byazt.ws.tj>> n;
    public com.byazt.zb.qg q;
    public com.byazt.zb.n qg;
    public Handler rv;
    public com.byazt.dw.n tj;
    public String w;
    public com.byazt.qn.qg x;
    public final List<com.byazt.ws.tj> s = new CopyOnWriteArrayList();
    public boolean cp = false;

    public qg() {
        Looper looperQg = com.byazt.rb.l.qg();
        if (looperQg != null) {
            this.rv = new Handler(looperQg) { // from class: com.byazt.ie.qg.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    qg.this.n(message);
                }
            };
        } else {
            com.byazt.rb.l.n();
            this.rv = new Handler(com.byazt.rb.l.qg()) { // from class: com.byazt.ie.qg.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    qg.this.n(message);
                }
            };
        }
    }

    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        this.q = qgVarN;
        qgVarN.n(this.rv);
        this.qg = this.q.hd();
        this.l = this.q.cy();
        com.byazt.qn.qg qgVarWm = this.q.wm();
        this.x = qgVarWm;
        this.w = qgVarWm.a();
        this.n = this.l.ur();
        ArrayList arrayList = new ArrayList();
        this.fs = arrayList;
        arrayList.addAll(this.n.keySet());
        com.byazt.sq.qg.n(this.fs);
        this.qg.n(this.fs);
        this.qg.x(this.l.hu());
        List<com.byazt.ws.tj> listN = com.byazt.yc.x.n(this.l.y());
        List<com.byazt.ws.tj> listQg = com.byazt.yc.x.qg(this.l.y());
        this.qg.fs(listN == null ? 0 : listN.size());
        this.qg.rv(listQg == null ? 0 : listQg.size());
        Handler handler = this.rv;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.l.dg());
        }
        if (!this.q.hu()) {
            com.byazt.gp.s.n(this.x, this.l.rf(), !this.q.h(), this.q.fi().n, 0, (Map<String, Object>) null);
        }
        if (this.l.k()) {
            interfaceC0201n.n(interfaceC0201n.n());
        } else {
            if (com.byazt.rb.qg.qg()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "开始加载广告 num:" + this.l.hu());
            }
            s(0);
        }
        com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(1);
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.vp.q qVarN = com.byazt.vp.l.n();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ((com.byazt.vp.w) qVarN).n(this.q.df(), jElapsedRealtime, this.x, this.l, new com.byazt.vp.q.n() { // from class: com.byazt.ie.qg.3
            @Override // com.byazt.vp.q.n
            public void n(com.byazt.vp.qg qgVar) {
                List<com.byazt.ws.tj> list = qg.this.n != null ? qg.this.n.get(0) : null;
                qg qgVar2 = qg.this;
                qgVar2.n(qgVar2.x, list, qgVar, jElapsedRealtime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        if (i < 0) {
            return;
        }
        if (com.byazt.yc.x.n(i, this.fs)) {
            int iB = this.l.b();
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "the " + i + " level is first level normal ad and ParallelNum:" + iB);
            for (int i2 = 0; i2 < iB; i2++) {
                q(i + i2);
            }
            return;
        }
        q(i);
    }

    private void q(int i) {
        if (this.q.q() || l()) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.q.tj()) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "已经触发过destroy操作...");
            return;
        }
        if (qg()) {
            return;
        }
        if (i >= this.fs.size()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "第 " + i + " 层没有广告可以请求...");
            return;
        }
        int iIntValue = this.fs.get(i).intValue();
        if (this.qg.s(iIntValue)) {
            s(i + 1);
            return;
        }
        if (com.byazt.yc.x.qg(iIntValue) && this.qg.qg() == -1) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "开启serverBidding exchange 请求....");
            n(this.n.get(Integer.valueOf(iIntValue)));
            n(i);
            return;
        }
        this.qg.qg(iIntValue);
        n(iIntValue, i);
        if (com.byazt.yc.x.s(iIntValue) || com.byazt.yc.x.qg(iIntValue)) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "第 " + i + "层 ClientBidding,ServerBidding 广告，levelSort：" + iIntValue + "，同时请求下一层广告...");
            s(i + 1);
        }
    }

    private void n(int i, int i2) {
        long jOj;
        Handler handler;
        Map<Integer, List<com.byazt.ws.tj>> map = this.n;
        if (map == null) {
            return;
        }
        final List<com.byazt.ws.tj> list = map.get(Integer.valueOf(i));
        com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "loadLevelWaterFall start...执行当前加载层级 ：" + i2 + " levelSort:" + i + "  waterFallConfig.size:" + (list == null ? 0 : list.size()));
        if (py.n(list)) {
            return;
        }
        this.qg.n(i, list.size());
        if (com.byazt.yc.x.s(i)) {
            jOj = this.l.wm();
        } else {
            jOj = this.l.oj();
        }
        Message messageObtain = Message.obtain();
        if (com.byazt.yc.x.n(i)) {
            messageObtain.what = 1;
        } else if (com.byazt.yc.x.s(i)) {
            messageObtain.what = 2;
        } else if (com.byazt.yc.x.qg(i)) {
            messageObtain.what = 3;
        } else {
            messageObtain.what = 4;
            messageObtain.obj = com.byazt.vy.oa.n(i);
        }
        messageObtain.arg1 = i;
        Handler handler2 = this.rv;
        if (handler2 != null) {
            handler2.sendMessageDelayed(messageObtain, jOj);
        }
        long jDf = this.l.df();
        if (jDf != 0 && (handler = this.rv) != null) {
            handler.removeMessages(5);
            this.rv.sendEmptyMessageDelayed(5, jDf);
        }
        for (final int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ie.qg.4
                    @Override // java.lang.Runnable
                    public void run() {
                        qg.this.n((com.byazt.ws.tj) list.get(i3), list.size());
                    }
                });
                if (this.q.h()) {
                    this.q.ln();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void n(com.byazt.ws.tj tjVar, int i) {
        if (tjVar != null && this.x != null) {
            n(tjVar.cd(), tjVar.k(), tjVar.cy(), com.byazt.sg.n.n(this.x.um(), tjVar.w()), 0, "广告请求中");
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + tjVar.toString());
        com.byazt.dd.qg qgVarN = com.byazt.dd.qg.n(tjVar, this);
        qgVarN.s(1);
        qgVarN.qg(1);
        qgVarN.n(i);
        qgVarN.n(!this.q.h());
        qgVarN.n(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.ob.qg());
        arrayList.add(new com.byazt.ob.x());
        arrayList.add(new com.byazt.ob.q());
        arrayList.add(new com.byazt.ob.w());
        arrayList.add(new com.byazt.ob.s());
        new com.byazt.ob.l(arrayList).n(this.q, qgVarN);
    }

    public void n(final List<com.byazt.ws.tj> list) {
        final Context context = this.q.getContext();
        if (context != null) {
            com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ie.qg.5
                @Override // java.lang.Runnable
                public void run() {
                    qg qgVar = qg.this;
                    qgVar.n(context, qgVar.x, list, !qg.this.q.h());
                }
            });
        }
    }

    public void n(final int i) {
        com.byazt.dw.n nVarN = com.byazt.dw.l.n(this.l);
        this.tj = nVarN;
        nVarN.n(this.rv, this.l, new com.byazt.dw.qg(this.l, new Runnable() { // from class: com.byazt.ie.qg.6
            @Override // java.lang.Runnable
            public void run() {
                qg.this.s(i + 1);
            }
        }));
    }

    public boolean qg() {
        return qg(null, 3);
    }

    public boolean qg(com.byazt.ws.tj tjVar, int i) {
        if (this.q.q() || l()) {
            return true;
        }
        if (this.qg.l()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.qg.l() + "  allWtfFinish:" + this.qg.fs());
            if (!py.n(this.q.cp()) || !py.n(this.q.d()) || !py.n(this.q.sz())) {
                s();
            } else {
                if (com.byazt.we.n.qg(this.l)) {
                    com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "总加载时间超时.......isCallback:true");
                    if (com.byazt.we.n.n(this.q, this.fs, this.n)) {
                        s();
                        return true;
                    }
                }
                this.cp = true;
                n(new com.byazt.mj.n(10003, com.byazt.mj.n.n(10003)));
            }
            return true;
        }
        if (this.qg.fs()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "全部广告完成响应...");
            if (!py.n(this.q.cp()) || !py.n(this.q.d()) || !py.n(this.q.sz())) {
                s();
            } else {
                n(new com.byazt.mj.n(20005, com.byazt.mj.n.n(20005)));
            }
            return true;
        }
        if (this.q.cd()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "p层广告已经满足返回条件...");
            s();
            return true;
        }
        if (!(this.l.v() && this.qg.s()) && this.l.v()) {
            return false;
        }
        if (tjVar == null) {
            if (this.q.um() && this.q.py()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "p层&普通层广告 已经满足返回条件 V1 .........");
                s();
                return true;
            }
            if (!this.q.a() || !this.qg.rv() || !this.qg.tj() || !this.q.ou()) {
                return false;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            s();
            return true;
        }
        if (this.q.um() && this.q.py()) {
            for (com.byazt.sg.s sVar : this.q.d()) {
                com.byazt.jf.n nVarN = com.byazt.jf.q.n(this.l);
                com.byazt.zb.qg qgVar = this.q;
                Map<Integer, List<com.byazt.ws.tj>> map = this.n;
                if (nVarN.n(qgVar, sVar, map == null ? null : map.get(Integer.valueOf(com.byazt.yc.x.n(this.l, sVar))))) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    s();
                    return true;
                }
            }
            return false;
        }
        if (!this.q.a() || !this.qg.rv() || !this.qg.tj() || !this.q.ou()) {
            return false;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        s();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Message message) {
        int i = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + (message.what == 1 ? "P层" : "普通层") + "广告触发层超时.........levelSort:" + i);
                com.byazt.zb.qg qgVar = this.q;
                if (qgVar != null) {
                    com.byazt.zo.x.n(qgVar.s(), "t_out_" + this.q.n().incrementAndGet(), this.q.an());
                }
                this.qg.q(i);
                if (qg()) {
                    return;
                }
                s(qg(i));
                return;
            case 2:
                com.byazt.zb.qg qgVar2 = this.q;
                if (qgVar2 != null) {
                    com.byazt.zo.x.n(qgVar2.s(), "cb_t_out" + this.q.n().incrementAndGet(), this.q.an());
                }
                break;
            case 3:
                break;
            case 5:
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "触发最小层超时.........levelSort:" + i);
                qg();
                return;
            case 6:
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "触发总超时.........");
                com.byazt.zb.qg qgVar3 = this.q;
                if (qgVar3 != null) {
                    com.byazt.zo.x.n(qgVar3.s(), "total_t_out" + this.q.n().incrementAndGet(), this.q.an());
                }
                this.qg.q();
                this.q.fi().w = true;
                qg();
                return;
            default:
                return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + (message.what == 2 ? "ClientBidding层" : "ServerBidding层层") + "广告触发层超时.........levelSort:" + i);
        this.qg.q(i);
        qg();
    }

    @Override // com.byazt.ow.n
    public void n(List<com.byazt.sg.s> list, com.byazt.ws.tj tjVar) {
        if (py.n(list) || tjVar == null) {
            return;
        }
        n(list, this.l);
        n(tjVar.cd(), tjVar.k(), tjVar.cy(), com.byazt.sg.n.n(tjVar.oa(), tjVar.w()), 0, "广告加载成功");
        com.byazt.sq.s.n(this.w, tjVar, !py.qg(list) ? list.get(0) : null);
        qg(list);
        int iN = com.byazt.yc.x.n(this.l, tjVar);
        if (tjVar.fi() && com.byazt.ic.n.n(this.qg, this.s, tjVar.cd())) {
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "返回的普通广告被server Bidding过滤了......slotId:" + tjVar.cd());
            this.q.oa().addAll(list);
            return;
        }
        com.byazt.yc.n.n(this.q, list, false);
        this.qg.n(iN, tjVar.cd());
        if (this.q.h()) {
            s(list);
        }
        if (this.qg.l()) {
            n((List<com.byazt.sg.s>) null, new com.byazt.mj.n(10012, "load ad timeout !!!"));
        } else {
            n(list, (com.byazt.mj.n) null);
        }
        this.q.qg(list);
        if (this.q.x() && !this.q.h() && !this.q.hu()) {
            this.q.q(tjVar);
        }
        if (qg(tjVar, 1) || this.qg.w(iN) != 0 || tjVar.f()) {
            return;
        }
        int iQg = qg(iN);
        s(tjVar, iN);
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "onAdLoaded levelSort: " + iN + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iQg);
        s(iQg);
    }

    @Override // com.byazt.ow.n
    public void n(com.byazt.mj.n nVar, com.byazt.ws.tj tjVar) {
        if (tjVar == null) {
            return;
        }
        n((List<com.byazt.sg.s>) null, nVar);
        if (nVar != null) {
            n(tjVar.cd(), tjVar.hd(), tjVar.cy(), com.byazt.sg.n.n(tjVar.oa(), tjVar.w()), nVar.s, nVar.q);
        }
        com.byazt.sq.s.n(nVar, tjVar);
        if (tjVar.fi() && com.byazt.ic.n.n(this.qg, this.s, tjVar.cd())) {
            return;
        }
        int iN = com.byazt.yc.x.n(this.l, tjVar);
        this.qg.n(iN, tjVar.cd());
        if (qg(tjVar, 2) || this.qg.l(iN) || this.qg.w(iN) != 0 || tjVar.f()) {
            return;
        }
        int iQg = qg(iN);
        s(tjVar, iN);
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "onAdFailed levelSort " + iN + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iQg);
        s(iQg);
    }

    private void s(com.byazt.ws.tj tjVar, int i) {
        int i2;
        if (tjVar == null || this.rv == null) {
            return;
        }
        if (tjVar.an()) {
            i2 = 1;
        } else if (tjVar.j() || tjVar.ae()) {
            i2 = 2;
        } else {
            i2 = tjVar.v() ? 3 : 4;
        }
        if (tjVar.fi()) {
            this.rv.removeMessages(i2, com.byazt.vy.oa.n(i));
        } else {
            this.rv.removeMessages(i2);
        }
    }

    @Override // com.byazt.ow.n
    public void n() {
        com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "onAdVideoCache.....");
        q();
    }

    public void s() {
        this.cp = false;
        this.q.fs();
    }

    public void n(com.byazt.mj.n nVar) {
        this.q.n(nVar);
    }

    public void q() {
        this.q.rv();
    }

    public void n(List<com.byazt.sg.s> list, com.byazt.mj.n nVar) {
        this.q.n(list, nVar);
    }

    public int qg(int i) {
        int iIndexOf;
        List<Integer> list = this.fs;
        if (list == null || (iIndexOf = list.indexOf(Integer.valueOf(i))) == -1) {
            return -1;
        }
        return iIndexOf + 1;
    }

    public void n(Context context, final com.byazt.qn.qg qgVar, final List<com.byazt.ws.tj> list, boolean z) {
        com.byazt.vp.q qVarN = com.byazt.vp.l.n();
        if (qVarN != null) {
            this.qg.n(0);
            this.q.fi().q = true;
            final com.byazt.vp.s sVar = new com.byazt.vp.s();
            sVar.n = qgVar;
            sVar.qg = list;
            sVar.q = this.l;
            sVar.w = z;
            sVar.x = SystemClock.elapsedRealtime();
            sVar.fs = this.q;
            sVar.l = qgVar != null ? qgVar.s() : 1;
            qVarN.n(this.q.m(), context, sVar, new com.byazt.vp.q.n() { // from class: com.byazt.ie.qg.7
                @Override // com.byazt.vp.q.n
                public void n(com.byazt.vp.qg qgVar2) {
                    qg.this.n(qgVar, (List<com.byazt.ws.tj>) list, qgVar2, sVar.x);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.qn.qg qgVar, List<com.byazt.ws.tj> list, com.byazt.vp.qg qgVar2, long j) {
        com.byazt.dw.n nVar;
        if (this.q != null && qgVar2 != null && !TextUtils.isEmpty(qgVar2.q)) {
            this.q.fi().n = qgVar2.q;
        }
        com.byazt.ws.qg qgVar3 = this.l;
        if (qgVar3 != null && qgVar2 != null) {
            qgVar3.fs().put("price_source", Integer.valueOf(qgVar2.oa));
        }
        if (qgVar2 != null) {
            com.byazt.gp.s.n(qgVar, qgVar2, this.qg.l() ? 1 : 0);
            com.byazt.zb.qg qgVar4 = this.q;
            if (qgVar4 != null) {
                com.byazt.zo.x.n(qgVar4.s(), "ret_sb", this.q.an());
            }
        }
        if (qgVar2 != null && !py.n(qgVar2.qg)) {
            this.qg.n(1);
            if (this.q.q() || this.q.l()) {
                return;
            }
            this.s.clear();
            this.s.addAll(qgVar2.qg);
            Handler handler = this.rv;
            if (handler != null) {
                handler.removeMessages(1);
                this.rv.removeMessages(4);
                this.rv.removeMessages(5);
            }
            wm.n(qgVar2.qg);
            this.n = com.byazt.yc.x.n(qgVar2.qg, this.l.sz());
            ArrayList arrayList = new ArrayList();
            this.fs = arrayList;
            arrayList.addAll(this.n.keySet());
            com.byazt.sq.qg.n(this.fs);
            this.qg.n(this.fs);
            this.qg.n(qgVar2.qg, com.byazt.yc.x.n(this.l.y()), com.byazt.yc.x.s(this.l.y()));
            com.byazt.ic.n.n(this.l, this.q, qgVar2.qg);
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + qgVar2.qg.size());
            s(0);
            qg();
        } else {
            this.qg.n(2);
            if (this.q.q() || this.q.l()) {
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "serverBidding响应失败了.......... ");
            this.qg.qg(0);
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.byazt.ws.tj tjVar = list.get(i);
                    this.qg.n(com.byazt.yc.x.n(this.l, tjVar), tjVar.cd());
                }
            }
            if (!qg() && (nVar = this.tj) != null) {
                nVar.n();
            }
        }
        if (qgVar2 != null) {
            com.byazt.zo.x.n(qgVar2.cp, "0-req", j);
        }
        if (this.l != null && qgVar2 != null) {
            com.byazt.cby.qg.q().n(qgVar2.d, qgVar2.sz, this.l.f(), this.l.an());
        }
        if (qgVar2 == null || !qgVar2.s) {
            return;
        }
        com.byazt.ng.q.n(com.byazt.qt.qg.n()).n().n(1);
    }

    public boolean l() {
        if (this.q.l()) {
            return (this.cp && com.byazt.we.n.n(this.l)) ? false : true;
        }
        return false;
    }

    public void n(List<com.byazt.sg.s> list, com.byazt.ws.qg qgVar) {
        com.byazt.cby.q.n(list, qgVar);
        com.byazt.mv.n.n(list, qgVar);
    }

    public void n(String str, String str2, String str3, String str4, int i, String str5) {
        com.byazt.mj.qg qgVar = this.q.t().get(str);
        if (qgVar == null) {
            qgVar = new com.byazt.mj.qg();
        }
        qgVar.qg(str).s(str2).q(str3).n(i).l(str5).n(str4);
        this.q.t().put(str, qgVar);
    }

    private void qg(List<com.byazt.sg.s> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String strEl = list.get(0).el();
        if (list.get(0).vo() && com.byazt.ra.n.n().l(this.w, strEl, this.x.l()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.byazt.sg.s sVar : list) {
                if (sVar != null) {
                    arrayList.add(new com.byazt.qa.x(sVar, 0L, this.x));
                }
            }
            if (arrayList.size() > 0) {
                com.byazt.sg.s sVar2 = ((com.byazt.qa.x) arrayList.get(0)).n;
                com.byazt.rb.qg.qg(MediationConstant.TAG, "--==-- 广告复用:广告缓存成功 -------" + sVar2.lq() + ", adType: " + com.byazt.sg.n.n(sVar2.ct(), sVar2.dg()) + ", adnSlotId: " + sVar2.el() + ", ad个数: " + arrayList.size());
                com.byazt.ra.n.n().n(strEl, (List<com.byazt.qa.x>) arrayList, false);
            }
        }
    }

    private void s(List<com.byazt.sg.s> list) {
        if (list == null) {
            return;
        }
        for (com.byazt.sg.s sVar : list) {
            if (sVar != null) {
                com.byazt.qa.q.n().n(this.w, new com.byazt.qa.x(sVar, this.q.lh(), this.x));
            }
        }
    }
}
