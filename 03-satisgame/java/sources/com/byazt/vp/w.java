package com.byazt.vp;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.vy.py;
import com.byazt.ws.fs;
import com.byazt.ws.tj;
import com.byazt.zo.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1053, 13})
public class w implements q {
    @Override // com.byazt.vp.q
    public void n(Map<String, com.byazt.nw.n> map, Context context, final s sVar, final q.n nVar) {
        if (sVar == null || sVar.n == null || sVar.q == null || py.n(sVar.qg)) {
            nVar.n(null);
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(sVar.n.a()) + "开启server bidding网络请求......：");
        com.byazt.gp.s.n(sVar.n, (JSONObject) null);
        com.byazt.zb.qg qgVar = sVar.fs;
        if (qgVar != null) {
            x.n(qgVar.s(), "st_sb", qgVar.an());
        }
        final long j = sVar.x;
        final int[] iArr = {4};
        com.byazt.bp.n.n().n(map, context, sVar, new com.byazt.bp.n.InterfaceC0146n() { // from class: com.byazt.vp.w.1
            @Override // com.byazt.bp.n.InterfaceC0146n
            public void n(com.byazt.ws.x xVar) {
                w.this.n(j, sVar.n, sVar.q, iArr[0], xVar, nVar);
            }

            @Override // com.byazt.bp.n.InterfaceC0146n
            public void n(com.byazt.mj.n nVar2) {
                w.this.n(j, iArr[0], nVar2, sVar.n, nVar);
            }
        });
    }

    public void n(String str, final long j, final com.byazt.qn.qg qgVar, final com.byazt.ws.qg qgVar2, final q.n nVar) {
        com.byazt.bp.n.n().n(str, new com.byazt.bp.n.InterfaceC0146n() { // from class: com.byazt.vp.w.2
            @Override // com.byazt.bp.n.InterfaceC0146n
            public void n(com.byazt.ws.x xVar) {
                w.this.n(j, qgVar, qgVar2, 4, xVar, nVar);
            }

            @Override // com.byazt.bp.n.InterfaceC0146n
            public void n(com.byazt.mj.n nVar2) {
                w.this.n(j, 4, nVar2, qgVar, nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, com.byazt.qn.qg qgVar, com.byazt.ws.qg qgVar2, int i, com.byazt.ws.x xVar, q.n nVar) {
        int i2;
        qg qgVar3;
        int i3;
        tj tjVarW;
        if (xVar != null) {
            x.n(xVar.x(), "0-thread", j);
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响返回.............");
        if (qgVar2 != null && xVar != null && !py.n(xVar.q())) {
            List<fs> listQ = xVar.q();
            qgVar3 = new qg();
            qgVar3.d = xVar.n();
            qgVar3.oa = xVar.qg();
            qgVar3.sz = xVar.s();
            qgVar3.cp = xVar.x();
            qgVar3.rv = listQ.size();
            qgVar3.n = xVar.rv();
            qgVar3.tj = qgVar2.rv();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("winners : {");
            for (fs fsVar : listQ) {
                if (fsVar != null && (tjVarW = qgVar2.w(fsVar.x())) != null) {
                    tj tjVarL = tjVarW.l();
                    sb.append(" [ AdnName:" + tjVarL.k() + ",slotId:" + tjVarL.cd() + ",loadSort:" + tjVarL.h() + ",showSort:" + tjVarL.t() + "] ");
                    tjVarL.n(fsVar);
                    arrayList.add(tjVarL);
                }
            }
            sb.append("}");
            if (py.n(arrayList)) {
                i2 = py.n(xVar.rv()) ? i : 2;
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<tj> listN = n(xVar.rv(), qgVar2, qgVar3);
                if (listN != null && listN.size() > 0) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(listN);
                    i3 = 1;
                } else {
                    com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                }
                qgVar3.qg = copyOnWriteArrayList;
                i2 = i3;
            }
        } else {
            i2 = (xVar == null || py.n(xVar.rv())) ? i : 2;
            com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            qgVar3 = null;
        }
        if (xVar != null) {
            String strW = xVar.w();
            if (!TextUtils.isEmpty(strW)) {
                if (qgVar3 == null) {
                    qgVar3 = new qg();
                }
                qgVar3.q = strW;
            }
            if (xVar.fs()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (qgVar3 == null) {
                    qgVar3 = new qg();
                }
                qgVar3.s = true;
            }
            if (!py.n(xVar.l())) {
                if (qgVar3 == null) {
                    qgVar3 = new qg();
                }
                qgVar3.l = xVar.l();
            }
        }
        if (qgVar3 == null) {
            qgVar3 = new qg();
        }
        qgVar3.w = i2;
        qgVar3.x = SystemClock.elapsedRealtime() - j;
        x.n(qgVar3.cp, "0-handle_wtf", j);
        if (nVar != null) {
            nVar.n(qgVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, int i, com.byazt.mj.n nVar, com.byazt.qn.qg qgVar, q.n nVar2) {
        int i2 = (nVar == null || nVar.n != -1) ? 5 : 4;
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(qgVar.a()) + "server bidding网络请求响应失败......onFail  result:" + i2);
        qg qgVar2 = new qg();
        qgVar2.w = i2;
        qgVar2.x = SystemClock.elapsedRealtime() - j;
        qgVar2.fs = nVar;
        if (nVar2 != null) {
            nVar2.n(qgVar2);
        }
    }

    private List<tj> n(List<tj> list, com.byazt.ws.qg qgVar, qg qgVar2) {
        List<tj> listY;
        if (list == null || list.size() == 0 || qgVar == null) {
            return null;
        }
        boolean zBooleanValue = qgVar.fs().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) qgVar.fs().get("serverBidding_timeout")).booleanValue() : false;
        if (qgVar.rv() == 4 && !zBooleanValue) {
            com.byazt.ws.qg qgVarN = com.byazt.ir.q.n().n(qgVar.f(), qgVar.fi(), 102);
            if (qgVarN == null) {
                return null;
            }
            listY = com.byazt.cby.s.n(qgVarN, qgVarN.f(), qgVar2 == null ? 0.0d : qgVar2.d, qgVar2 != null ? qgVar2.sz : 0.0d);
            qgVar.fs().putAll(qgVarN.fs());
        } else {
            listY = qgVar.y();
        }
        if (listY != null && listY.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (tj tjVar : listY) {
                for (tj tjVar2 : list) {
                    if (tjVar != null && tjVar2 != null && tjVar.um() == 0 && !TextUtils.isEmpty(tjVar.cd()) && tjVar.cd().equals(tjVar2.cd())) {
                        arrayList.add(tjVar);
                        break;
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
