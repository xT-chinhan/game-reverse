package com.byazt.ie;

import android.content.Context;
import com.byazt.hh.uc;
import com.byazt.nn.fw;
import com.byazt.vkw.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 585, 121})
public class x implements com.byazt.hh.x {
    public uc aj;
    public com.byazt.fhc.x c;
    public com.byazt.fhc.pr fw;
    public List<com.byazt.fhc.hw> g = new ArrayList();
    public com.byazt.fhc.hn hn;
    public k hw;
    public uc k;
    public com.byazt.hh.hw m;
    public Context pr;
    public com.byazt.fhc.uc uc;
    public uc vk;
    public uc w;
    public com.byazt.fhc.c x;
    public uc zo;

    public x(Context context, com.byazt.hh.hw hwVar, com.byazt.vkw.pr prVar) {
        this.m = hwVar;
        this.pr = context;
        this.hw = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        uc ucVarHw = this.m.hw();
        this.zo = ucVarHw;
        if (ucVarHw == null) {
            this.zo = com.byazt.jwj.pr.x(prVar);
        }
        com.byazt.fhc.hn hnVar = new com.byazt.fhc.hn(context, this.zo, this.m, this.hw);
        this.hn = hnVar;
        this.g.add(hnVar);
        if (this.m.c() != null) {
            this.vk = this.m.c();
        } else {
            this.vk = this.m.hn();
        }
        if (this.vk == null) {
            this.vk = com.byazt.jwj.pr.pr(prVar);
        }
        com.byazt.fhc.x xVar = new com.byazt.fhc.x(context, this.vk, this.m, this.hw);
        this.c = xVar;
        this.g.add(xVar);
        uc ucVarHn = this.m.hn();
        this.aj = ucVarHn;
        if (ucVarHn == null) {
            this.aj = com.byazt.jwj.pr.hn(prVar);
        }
        com.byazt.fhc.c cVar = new com.byazt.fhc.c(context, this.aj, this.m, this.hw);
        this.x = cVar;
        this.g.add(cVar);
        uc ucVarHn2 = this.m.hn();
        this.w = ucVarHn2;
        if (ucVarHn2 == null) {
            this.w = com.byazt.jwj.pr.hn(prVar);
        }
        com.byazt.fhc.uc ucVar = new com.byazt.fhc.uc(context, this.w, this.m, this.hw);
        this.uc = ucVar;
        this.g.add(ucVar);
        uc ucVarX = this.m.x();
        this.k = ucVarX;
        if (ucVarX == null) {
            this.k = com.byazt.jwj.pr.hw(prVar);
        }
        com.byazt.fhc.pr prVar2 = new com.byazt.fhc.pr(context, this.k, this.m, this.hw);
        this.fw = prVar2;
        this.g.add(prVar2);
    }

    @Override // com.byazt.hh.x
    public void pr(com.byazt.hh.pr prVar, int i, boolean z) {
        if (prVar == null) {
            return;
        }
        try {
            prVar.pr(System.currentTimeMillis());
            Iterator<com.byazt.fhc.hw> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().hw(prVar);
            }
        } catch (Throwable th) {
            com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.pr(), 1, this.hw);
        }
    }

    @Override // com.byazt.hh.x
    public hw pr(int i, List<com.byazt.hh.pr> list, int i2) {
        fw.pr("dbCache handleResult start");
        Iterator<com.byazt.fhc.hw> it = this.g.iterator();
        hw hwVarPr = null;
        while (it.hasNext()) {
            hwVarPr = it.next().pr(i, list);
            if (hwVarPr.pr()) {
                break;
            }
        }
        fw.pr("dbCache handleResult end");
        return hwVarPr;
    }

    public List<com.byazt.hh.pr> pr(com.byazt.hh.pr prVar, int i, int i2, boolean z) {
        Iterator<com.byazt.fhc.hw> it = this.g.iterator();
        while (it.hasNext()) {
            List<com.byazt.hh.pr> listPr = it.next().pr(i2, i, prVar, z);
            if (listPr != null && listPr.size() != 0) {
                return listPr;
            }
        }
        return null;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, List<String> list) {
        Iterator<com.byazt.fhc.hw> it = this.g.iterator();
        while (it.hasNext()) {
            List<com.byazt.hh.pr> listPr = it.next().pr(i, prVar, z, list, "db");
            if (listPr != null && listPr.size() != 0) {
                return listPr;
            }
        }
        return null;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, String str) {
        return null;
    }

    @Override // com.byazt.hh.x
    public boolean pr(int i, String str, com.byazt.hh.pr prVar) {
        Iterator<com.byazt.fhc.hw> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().pr(i, str, prVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.hh.x
    public int pr() {
        return 0;
    }

    @Override // com.byazt.hh.x
    public int hw() {
        int size = this.g.size();
        int iHn = 0;
        for (int i = 0; i < size; i++) {
            iHn += this.g.get(i).hn();
        }
        return iHn;
    }

    @Override // com.byazt.hh.x
    public List<com.byazt.hh.pr> pr(int i) {
        return pr(i, null);
    }

    public List<com.byazt.hh.pr> pr(int i, List<String> list) {
        List<com.byazt.hh.pr> listHw;
        ArrayList arrayList = new ArrayList();
        if (this.hn == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            arrayList2.addAll(list);
        }
        while (arrayList.size() < 1000 && (listHw = this.hn.hw(i, null, false, arrayList2, "direct_connect")) != null && !listHw.isEmpty()) {
            for (com.byazt.hh.pr prVar : listHw) {
                if (prVar != null && prVar.uc() != null) {
                    arrayList.add(prVar);
                    arrayList2.add(prVar.uc());
                    if (arrayList.size() >= 1000) {
                        break;
                    }
                }
            }
            if (listHw.size() < 100) {
                break;
            }
        }
        fw.hn("DBCacheStrategy", "queryAllHighPriorityFromDb size=" + arrayList.size());
        return arrayList;
    }
}
