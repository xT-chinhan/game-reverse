package com.byazt.vh;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1778, 210})
public class k {
    public static final Set<String> n = new HashSet(Arrays.asList("RecyclerLayout", "RecycleView"));
    public boolean a;
    public com.byazt.vt.n cd;
    public com.byazt.xz.sz cp;
    public rv d;
    public a fs;
    public cp h;
    public float hu;
    public JSONObject k;
    public tj l;
    public float m;
    public String oa;
    public fs ou;
    public List<String> py;
    public com.byazt.ih.s<View> q;
    public Context qg;
    public um rv;
    public JSONObject s;
    public sz sz;
    public com.byazt.xz.k tj;
    public boolean um;
    public cd w;
    public w wm;
    public ou x;
    public boolean cy = true;
    public boolean hd = false;

    public k(Context context) {
        this.qg = context;
    }

    public void n(String str, sz szVar) {
        this.sz = szVar;
        this.oa = str;
        if (szVar != null) {
            this.s = s(szVar.n());
        }
    }

    public com.byazt.ih.s<View> n(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        n(jSONObject, jSONObject2);
        this.s = s(jSONObject2);
        ou ouVar = this.x;
        if (ouVar != null) {
            ouVar.n();
        }
        rv rvVar = new rv(jSONObject, jSONObject2, jSONObject3);
        this.d = rvVar;
        rvVar.n(this.m, this.hu);
        this.cd = new com.byazt.vt.n();
        cd cdVar = this.w;
        if (cdVar instanceof com.byazt.ey.qg) {
            ((com.byazt.ey.qg) cdVar).n(this.d.qg());
        }
        this.q = n(this.d.n(), (com.byazt.ih.s<View>) null);
        cp cpVar = this.h;
        if (cpVar != null) {
            cpVar.qg();
            if (this.h.s()) {
                this.h.n(this.rv);
            }
            this.h.n(this.x);
        }
        ou ouVar2 = this.x;
        if (ouVar2 != null) {
            ouVar2.qg();
            this.q.n(this.x);
            this.x.s();
        }
        qg(this.q);
        if (this.x != null) {
            py pyVar = new py();
            pyVar.n(0);
            pyVar.n(this.q);
            this.x.n(pyVar);
        }
        return this.q;
    }

    public com.byazt.ih.s<View> n(rv.n nVar, JSONObject jSONObject, JSONObject jSONObject2) {
        l();
        this.s = s(jSONObject);
        ou ouVar = this.x;
        if (ouVar != null) {
            ouVar.n();
        }
        this.cd = new com.byazt.vt.n();
        cd cdVar = this.w;
        if (cdVar instanceof com.byazt.ey.qg) {
            ((com.byazt.ey.qg) cdVar).n("3.0");
        }
        this.q = n(nVar, (com.byazt.ih.s<View>) null);
        ou ouVar2 = this.x;
        if (ouVar2 != null) {
            ouVar2.qg();
            this.q.n(this.x);
        }
        qg(this.q);
        return this.q;
    }

    public com.byazt.ih.s<View> n(rv.n nVar, com.byazt.ih.s<View> sVar) {
        List<rv.n> listS;
        com.byazt.ih.n.C0202n c0202n = null;
        if (!rv.q(nVar)) {
            return null;
        }
        fs fsVar = this.ou;
        if (fsVar != null) {
            fsVar.n(nVar);
        }
        String strL = nVar.l();
        qg qgVarN = q.n(strL);
        qg qgVar = qgVarN;
        if (qgVarN == null) {
            this.um = true;
            if (this.py == null) {
                this.py = new ArrayList();
            }
            this.py.add(strL);
            strL = "View";
            nVar.qg("View");
            qg qgVarN2 = q.n("View");
            qgVar = qgVarN2;
            if (qgVarN2 == null) {
                return null;
            }
        }
        com.byazt.ih.s sVarN = qgVar.n(this.qg);
        if (sVarN == null) {
            return null;
        }
        JSONObject jSONObjectW = nVar.w();
        sVarN.x(com.byazt.mcb.qg.n(nVar.n(), this.s));
        sVarN.fs(strL);
        sVarN.s(jSONObjectW);
        sVarN.n(nVar);
        sVarN.qg(this.s);
        rv rvVar = this.d;
        if (rvVar == null) {
            sVarN.s(true);
        } else {
            sVarN.s(rvVar.q());
        }
        sVarN.n(this.sz);
        sVarN.n(this.cd);
        Iterator<String> itKeys = jSONObjectW.keys();
        if (sVar instanceof com.byazt.ih.n) {
            com.byazt.ih.n nVar2 = (com.byazt.ih.n) sVar;
            com.byazt.ih.n.C0202n c0202nFs = nVar2.fs();
            sVarN.n(nVar2);
            c0202n = c0202nFs;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strN = com.byazt.mcb.qg.n(jSONObjectW.optString(next), this.s);
            sVarN.n(next, strN);
            cp cpVar = this.h;
            if (cpVar != null) {
                cpVar.n(next, strN);
            }
            if (c0202n != null) {
                c0202n.n(this.qg, next, strN);
            }
        }
        if (c0202n != null) {
            sVarN.n(c0202n.n());
        }
        if (sVar != null && TextUtils.equals("virtualNode", sVar.v()) && sVarN.ri()) {
            this.a = true;
        }
        if (sVarN instanceof com.byazt.ih.n) {
            List<rv.n> listX = nVar.x();
            if (listX == null || listX.size() <= 0) {
                if (n.contains(sVarN.j()) && (listS = this.d.s()) != null && listS.size() > 0) {
                    Iterator<rv.n> it = listS.iterator();
                    while (it.hasNext()) {
                        com.byazt.ih.s<View> sVarN2 = n(it.next(), (com.byazt.ih.s<View>) sVarN);
                        if (sVarN2 != null && sVarN2.fi()) {
                            ((com.byazt.ih.n) sVarN).n(sVarN2);
                        }
                    }
                }
                return sVarN;
            }
            if (TextUtils.equals(sVarN.j(), "Swiper") && listX.size() != 1) {
                com.byazt.tk.k.qg("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(listX, new Comparator<rv.n>() { // from class: com.byazt.vh.k.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                    public int compare(rv.n nVar3, rv.n nVar4) {
                        return nVar3.w().optInt("order", 0) - nVar4.w().optInt("order", 0);
                    }
                });
            } catch (Throwable unused) {
            }
            Iterator<rv.n> it2 = listX.iterator();
            while (it2.hasNext()) {
                com.byazt.ih.s<View> sVarN3 = n(it2.next(), (com.byazt.ih.s<View>) sVarN);
                if (sVarN3 != null && !sVarN3.ri()) {
                    ((com.byazt.ih.n) sVarN).n(sVarN3, sVarN3.t());
                }
            }
        }
        this.q = sVarN;
        return sVarN;
    }

    public com.byazt.ih.s<View> n(JSONObject jSONObject) {
        ou ouVar = this.x;
        if (ouVar != null) {
            ouVar.n();
        }
        JSONObject jSONObject2 = this.s;
        n(jSONObject, jSONObject2);
        this.s = s(jSONObject2);
        rv rvVar = new rv(jSONObject, this.s);
        this.d = rvVar;
        cd cdVar = this.w;
        if (cdVar instanceof com.byazt.ey.qg) {
            ((com.byazt.ey.qg) cdVar).n(rvVar.qg());
        }
        this.q = qg(this.d.n(), null);
        ou ouVar2 = this.x;
        if (ouVar2 != null) {
            ouVar2.qg();
            this.q.n(this.x);
        }
        return this.q;
    }

    public com.byazt.ih.s<View> n(rv.n nVar) {
        l();
        com.byazt.ih.s<View> sVarQg = qg(nVar, null);
        this.q = sVarQg;
        return sVarQg;
    }

    public com.byazt.ih.s<View> qg(rv.n nVar, com.byazt.ih.s<View> sVar) {
        List<rv.n> listS;
        com.byazt.ih.n.C0202n c0202nFs = null;
        if (!rv.q(nVar)) {
            return null;
        }
        fs fsVar = this.ou;
        if (fsVar != null) {
            fsVar.qg(nVar);
        }
        String strL = nVar.l();
        qg qgVarN = q.n(strL);
        if (qgVarN == null) {
            this.um = true;
            if (this.py == null) {
                this.py = new ArrayList();
            }
            this.py.add(strL);
            return null;
        }
        com.byazt.ih.s sVarN = qgVarN.n(this.qg);
        if (sVarN == null) {
            return null;
        }
        sVarN.x(com.byazt.mcb.qg.n(nVar.n(), this.s));
        sVarN.fs(strL);
        sVarN.s(nVar.w());
        sVarN.n(nVar);
        sVarN.n(this.sz);
        if (sVar instanceof com.byazt.ih.n) {
            com.byazt.ih.n nVar2 = (com.byazt.ih.n) sVar;
            sVarN.n(nVar2);
            c0202nFs = nVar2.fs();
        }
        Iterator<String> itKeys = nVar.w().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strN = com.byazt.mcb.qg.n(nVar.w().optString(next), this.s);
            sVarN.n(next, strN);
            if (c0202nFs != null) {
                c0202nFs.n(this.qg, next, strN);
            }
        }
        if (sVarN instanceof com.byazt.ih.n) {
            List<rv.n> listX = nVar.x();
            if (listX == null || listX.size() <= 0) {
                if (n.contains(sVarN.j()) && (listS = this.d.s()) != null && listS.size() > 0) {
                    Iterator<rv.n> it = listS.iterator();
                    while (it.hasNext()) {
                        com.byazt.ih.s<View> sVarQg = qg(it.next(), sVarN);
                        if (sVarQg != null && sVarQg.fi()) {
                            ((com.byazt.ih.n) sVarN).n(sVarQg);
                        }
                    }
                }
                return sVarN;
            }
            if (TextUtils.equals(sVarN.j(), "Swiper") && listX.size() != 1) {
                com.byazt.tk.k.qg("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<rv.n> it2 = listX.iterator();
            while (it2.hasNext()) {
                com.byazt.ih.s<View> sVarQg2 = qg(it2.next(), sVarN);
                if (sVarQg2 != null && sVarQg2.fi()) {
                    ((com.byazt.ih.n) sVarN).n(sVarQg2);
                }
            }
        }
        if (c0202nFs != null) {
            sVarN.n(c0202nFs.n());
        }
        this.q = sVarN;
        return sVarN;
    }

    public void n(com.byazt.ih.s sVar) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        com.byazt.ih.n nVarLh = sVar.lh();
        if (nVarLh != null) {
            com.byazt.ih.n.C0202n c0202nFs = nVarLh.fs();
            Iterator<String> itKeys = sVar.m().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strN = com.byazt.mcb.qg.n(sVar.m().optString(next), this.s);
                sVar.n(next, strN);
                c0202nFs.n(this.qg, next, strN);
            }
            sVar.n(c0202nFs.n());
        }
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.size() <= 0) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    public void qg(JSONObject jSONObject) {
        ou ouVar = this.x;
        if (ouVar != null) {
            ouVar.s();
        }
        l();
        this.sz.q(jSONObject);
        JSONObject jSONObjectS = s(jSONObject);
        this.s = jSONObjectS;
        n(this.q, jSONObjectS);
        qg(this.q);
        if (this.x != null) {
            py pyVar = new py();
            pyVar.n(0);
            pyVar.n(this.q);
            this.x.n(pyVar);
        }
    }

    private void n(JSONObject jSONObject, JSONObject jSONObject2) {
        l();
        if (jSONObject != null) {
            this.sz.s(jSONObject.optJSONObject("dataStore"));
        }
        this.sz.q(jSONObject2);
    }

    private JSONObject s(JSONObject jSONObject) {
        sz szVar;
        return (jSONObject == null || (szVar = this.sz) == null) ? jSONObject : szVar.l(jSONObject);
    }

    private void l() {
        if (this.sz != null) {
            return;
        }
        sz szVar = new sz();
        this.sz = szVar;
        szVar.n(this.qg);
    }

    public void n(com.byazt.ih.s sVar, JSONObject jSONObject) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof com.byazt.ih.n) {
            sVar.n(jSONObject);
            List<com.byazt.ih.s<View>> listX = ((com.byazt.ih.n) sVar).x();
            if (listX == null || listX.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ih.s<View>> it = listX.iterator();
            while (it.hasNext()) {
                n(it.next(), jSONObject);
            }
            return;
        }
        sVar.n(jSONObject);
    }

    private void qg(com.byazt.ih.s<View> sVar) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        JSONObject jSONObjectM = sVar.m();
        Iterator<String> itKeys = jSONObjectM.keys();
        com.byazt.ih.n nVarLh = sVar.lh();
        com.byazt.ih.n.C0202n c0202nFs = nVarLh != null ? nVarLh.fs() : null;
        s(sVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strN = com.byazt.mcb.qg.n(jSONObjectM.optString(next), this.s);
            sVar.n(next, strN);
            if (c0202nFs != null) {
                c0202nFs.n(this.qg, next, strN);
            }
        }
        sVar.n(this.l);
        sVar.n(this.w);
        sVar.n(this.fs);
        cp cpVar = this.h;
        if (cpVar != null) {
            sVar.n(cpVar);
        }
        w wVar = this.wm;
        if (wVar != null) {
            sVar.n(wVar);
        }
        com.byazt.xz.k kVar = this.tj;
        if (kVar != null) {
            sVar.n(kVar);
        }
        com.byazt.xz.sz szVar = this.cp;
        if (szVar != null) {
            sVar.n(szVar);
        }
        if ((sVar instanceof com.byazt.ih.n) && (listX = ((com.byazt.ih.n) sVar).x()) != null && listX.size() > 0) {
            Iterator<com.byazt.ih.s<View>> it = listX.iterator();
            while (it.hasNext()) {
                qg(it.next());
            }
        }
        if (c0202nFs != null) {
            sVar.n(c0202nFs.n());
        }
        sVar.qg();
    }

    private void s(com.byazt.ih.s sVar) {
        try {
            if (!sVar.ln() || sVar.ur() == null || sVar.ur().fs() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", sVar.ur().fs());
            this.s.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void n(tj tjVar) {
        this.l = tjVar;
    }

    public void n(cd cdVar) {
        com.byazt.ey.n nVarW = com.byazt.gu.w.n().w();
        if (nVarW == null) {
            this.w = cdVar;
            return;
        }
        com.byazt.ey.qg qgVarN = nVarW.n(cdVar);
        if (qgVarN == null) {
            this.w = cdVar;
            return;
        }
        qgVarN.n(this.k);
        qgVarN.n(this.cy);
        qgVarN.qg(this.hd);
        rv rvVar = this.d;
        if (rvVar != null) {
            qgVarN.n(rvVar.qg());
        }
        this.w = qgVarN;
    }

    public void n(a aVar) {
        this.fs = aVar;
    }

    public void n(com.byazt.ih.s sVar, String str, Object... objArr) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n(str, objArr);
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), str, objArr);
        }
    }

    public boolean n() {
        return this.um;
    }

    public List<String> qg() {
        return this.py;
    }

    public boolean s() {
        return this.a;
    }

    public void n(fs fsVar) {
        this.ou = fsVar;
    }

    public void n(w wVar) {
        this.wm = wVar;
    }

    public void n(com.byazt.xz.k kVar) {
        this.tj = kVar;
    }

    public void n(com.byazt.xz.sz szVar) {
        this.cp = szVar;
    }

    public boolean q() {
        sz szVar = this.sz;
        return (szVar == null || szVar.s() == null) ? false : true;
    }
}
