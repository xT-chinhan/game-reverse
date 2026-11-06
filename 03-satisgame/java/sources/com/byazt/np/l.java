package com.byazt.np;

import android.content.Context;
import com.byazt.vy.wm;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 18})
public class l extends qg implements com.byazt.qa.s {
    public List<com.byazt.ws.tj> cy;
    public final int n;
    public com.byazt.qa.q.s qg;

    public l(Context context, int i) {
        super(context);
        this.n = i;
    }

    @Override // com.byazt.qa.s
    public void n(com.byazt.qn.qg qgVar, com.byazt.sg.s sVar, com.byazt.qa.q.s sVar2) {
        this.qg = sVar2;
        n(qgVar);
        this.s.qg(true);
        this.s.l(true);
        this.s.wm().n(qgVar.n());
        this.x = n(this.x, sVar);
        this.s.n(this.x);
        this.w.l(1);
        com.byazt.ws.qg qgVarN = com.byazt.bw.s.n(this.w, this.x);
        if (qgVarN != null) {
            this.x = qgVarN;
            this.s.n(this.x);
        }
        if (this.x == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，mRitConfig为null");
            com.byazt.qa.q.s sVar3 = this.qg;
            if (sVar3 != null) {
                sVar3.n(this.l, false, 0, null);
                return;
            }
            return;
        }
        List<com.byazt.ws.tj> listY = this.x.y();
        if (listY == null || listY.size() <= 0) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            com.byazt.qa.q.s sVar4 = this.qg;
            if (sVar4 != null) {
                sVar4.n(this.l, false, 0, null);
                return;
            }
            return;
        }
        this.x.x((long) (this.x.dg() * this.x.w()));
        this.x.w((long) (this.x.oj() * this.x.l()));
        this.x.qg(false);
        this.x.n(false);
        List<com.byazt.ws.tj> listY2 = this.x.y();
        this.cy = listY2;
        wm.n(listY2, this.k);
        if (com.byazt.rb.qg.qg()) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.byazt.ws.tj tjVar : this.cy) {
                com.byazt.rb.qg.n(MediationConstant.TAG, com.byazt.rb.q.n(this.l) + "waterfall: " + tjVar.k() + "adnSlotId: " + tjVar.cd() + ", loadSort: " + tjVar.h() + ", showSort: " + tjVar.t() + ", eCpm: " + tjVar.m());
            }
        }
        rv();
    }

    @Override // com.byazt.np.qg
    public com.byazt.ie.x rv() {
        ArrayList arrayList = new ArrayList();
        int i = this.n;
        if (i == 3) {
            arrayList.add(new com.byazt.ie.rv());
        } else if (i == 4) {
            arrayList.add(new com.byazt.ie.tj(this.s, this.x, this.cy));
        } else {
            arrayList.add(new com.byazt.ie.qg());
        }
        com.byazt.ie.x xVar = new com.byazt.ie.x(arrayList);
        xVar.n(this.s);
        return xVar;
    }

    private com.byazt.ws.qg n(com.byazt.ws.qg qgVar, com.byazt.sg.s sVar) {
        if (qgVar == null || sVar == null) {
            return null;
        }
        double dTa = sVar.ta();
        com.byazt.rb.qg.qg("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(dTa)));
        com.byazt.ws.qg qgVarClone = qgVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.byazt.ws.tj tjVar : qgVarClone.y()) {
            if (tjVar != null && tjVar.fi() && tjVar.m() > dTa) {
                copyOnWriteArrayList.add(tjVar);
            }
        }
        if (qgVarClone.sz()) {
            qgVarClone.qg(copyOnWriteArrayList);
        } else {
            qgVarClone.n(copyOnWriteArrayList);
        }
        return qgVarClone;
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        super.x();
        com.byazt.qa.q.s sVar = this.qg;
        if (sVar != null) {
            sVar.n(this.x != null ? this.x.f() : "", true, 0, this.s.d());
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        super.qg(nVar);
        if (this.qg != null) {
            int i = 20005;
            if (nVar != null) {
                if (nVar.n == 10003) {
                    i = 10003;
                } else {
                    int i2 = nVar.n;
                }
            }
            this.qg.n(this.x != null ? this.x.f() : "", false, i, null);
        }
    }
}
