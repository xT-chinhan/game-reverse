package com.byazt.np;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.vy.py;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 21})
public class x extends qg {
    public com.byazt.ie.n.InterfaceC0201n cy;
    public com.byazt.us.qg n;
    public com.byazt.kv.s qg;

    public x(Context context) {
        super(context);
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.us.qg qgVar2) {
        n(qgVar);
        this.n = qgVar2;
        rv();
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void qg(com.byazt.mj.n nVar) {
        com.byazt.us.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(nVar);
            if (this.cp != 0 || this.qg == null) {
                return;
            }
            this.cp = 2;
            this.qg.n(nVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void x() {
        List<com.byazt.sg.s> listN;
        if (this.n == null || (listN = n(this.s.n(true), this.w.m())) == null || listN.size() <= 0) {
            return;
        }
        if (com.byazt.rb.qg.qg()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "返回给外部开发者的广告数量：sumList.size=" + listN.size());
        }
        CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.s.n(true));
        for (com.byazt.sg.s sVar : listN) {
            if (sVar != null) {
                sVar.l(true);
                if (sVar.vo() && com.byazt.ra.n.n().q(this.l, sVar.el(), this.w.l())) {
                    com.byazt.yc.w.n(sVar, this.l, sVar.el());
                    n(copyOnWriteArrayList, sVar);
                }
                n(this.s.cp(), sVar);
                n(this.s.d(), sVar);
                n(this.s.oa(), sVar);
                n(this.s.sz(), sVar);
            }
        }
        com.byazt.ra.n.n().n(copyOnWriteArrayList, this.l, this.w, this.w.l(), null);
        this.n.n(listN);
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void n(List<com.byazt.sg.s> list, com.byazt.mj.n nVar) {
        super.n(list, nVar);
        if (!(this.n instanceof com.byazt.us.l) || py.n(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.byazt.sg.s sVar : list) {
            sVar.n(new com.byazt.sg.s.n() { // from class: com.byazt.np.x.1
                @Override // com.byazt.sg.s.n
                public void n() {
                    x.this.d = true;
                }

                @Override // com.byazt.sg.s.n
                public void n(com.byazt.sg.s sVar2) {
                    x.this.n(sVar2, -1);
                }
            });
            arrayList.add(sVar);
        }
    }

    @Override // com.byazt.np.qg, com.byazt.jg.n
    public void n(String str) {
        if (this.cp != 0 || this.qg == null) {
            return;
        }
        this.cp = 1;
        this.qg.n(str);
    }

    public void n(String str, com.byazt.us.qg qgVar) {
        if (this.cp != 1) {
            if (qgVar != null) {
                qgVar.n(new com.byazt.mj.n(10015, com.byazt.mj.n.n(10015)));
            }
        } else if (this.tj) {
            if (qgVar != null) {
                qgVar.n(new com.byazt.mj.n(40047, com.byazt.mj.n.n(40047)));
            }
        } else {
            this.tj = true;
            this.n = qgVar;
            com.byazt.ie.n.InterfaceC0201n interfaceC0201n = this.cy;
            if (interfaceC0201n != null) {
                interfaceC0201n.n(str);
            }
        }
    }

    public void n(com.byazt.qn.qg qgVar, com.byazt.kv.s sVar) {
        n(qgVar);
        this.qg = sVar;
        if (this.s.cy() != null && this.s.cy().k()) {
            this.cy = rv();
        } else if (sVar != null) {
            sVar.n(new com.byazt.mj.n(10014, com.byazt.mj.n.n(10014)));
        }
    }

    @Override // com.byazt.np.qg
    public void s() {
        super.s();
        this.n = null;
    }

    private List<com.byazt.sg.s> n(List<com.byazt.sg.s> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        s(list);
        q();
        final ArrayList arrayList = new ArrayList(list);
        final ArrayList arrayList2 = new ArrayList();
        Iterator<com.byazt.sg.s> it = list.iterator();
        while (it.hasNext() && arrayList2.size() < i) {
            com.byazt.sg.s next = it.next();
            next.n(new com.byazt.sg.s.n() { // from class: com.byazt.np.x.2
                @Override // com.byazt.sg.s.n
                public void n() {
                    x.this.d = true;
                    if (x.this.s != null) {
                        x.this.s.n(arrayList);
                    }
                }

                @Override // com.byazt.sg.s.n
                public void n(com.byazt.sg.s sVar) {
                    int i2 = 0;
                    while (i2 < arrayList2.size() && sVar != arrayList2.get(i2)) {
                        i2++;
                    }
                    x.this.n(sVar, i2);
                }
            });
            arrayList2.add(next);
            if (com.byazt.rb.qg.qg()) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "");
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(this.l, "show") + "返回给开发者最终广告：slotId=" + next.el() + ",slotType:" + next.bz() + ",cpm=" + next.ta() + ",广告类型：" + com.byazt.sg.n.n(next.he()) + ",ImageMode=" + next.dn() + ",showSort=" + next.il() + ",isExpressAd=" + next.kc());
            }
            it.remove();
        }
        n(arrayList2);
        return arrayList2;
    }

    public void n(com.byazt.sg.s sVar, int i) {
        if (sVar != null && sVar.vo() && com.byazt.ra.n.n().q(this.l, sVar.el(), this.w.l())) {
            com.byazt.ra.n.n().n(sVar.el(), this.w, this.s.v(), i == 0, this.s.j(), this.s.fi(), this.fs.get());
        }
    }

    private void n(CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayList, com.byazt.sg.s sVar) {
        for (com.byazt.sg.s sVar2 : copyOnWriteArrayList) {
            if (sVar2 == sVar && sVar2 != null) {
                copyOnWriteArrayList.remove(sVar2);
            }
        }
    }

    private void s(List<com.byazt.sg.s> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<com.byazt.sg.s> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        list.clear();
        for (com.byazt.sg.s sVar : arrayList) {
            if (sVar != null && !sVar.nf() && sVar.ae(this.l)) {
                list.add(sVar);
            }
        }
    }

    private void q() {
        try {
            List<com.byazt.ws.tj> listQg = qg();
            if (listQg == null || listQg.size() <= 0) {
                return;
            }
            for (com.byazt.ws.tj tjVar : listQg) {
                if (tjVar != null) {
                    String strCd = tjVar.cd();
                    if (com.byazt.ra.n.n().q(this.l, strCd, this.w.l())) {
                        if (tjVar.um() == 100) {
                            n(strCd, this.s.cp());
                        } else if (tjVar.um() == 0) {
                            n(strCd, this.s.d());
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void n(String str, List<com.byazt.sg.s> list) {
        List<com.byazt.qa.x> listN;
        if (qg(str, list) || com.byazt.ra.n.n().n(str, this.w, false) != 3 || (listN = com.byazt.ra.n.n().n(str, this.w, this.w.l())) == null || listN.size() <= 0) {
            return;
        }
        for (com.byazt.qa.x xVar : listN) {
            if (xVar != null && xVar.n != null && !xVar.n.nf() && xVar.n.ae(this.l)) {
                list.add(xVar.n);
                qg(xVar.n);
            }
        }
    }

    private boolean qg(String str, List<com.byazt.sg.s> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (com.byazt.sg.s sVar : list) {
            if (sVar != null && TextUtils.equals(str, sVar.el())) {
                return true;
            }
        }
        return false;
    }
}
