package com.byazt.fo;

import android.os.Bundle;
import com.byazt.km.cp;
import com.byazt.km.sz;
import com.byazt.ko.rv;
import com.byazt.yi.fs;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 13})
public class w extends qg {
    public static final long[] qg = {60000};
    public boolean q;
    public long s;

    @Override // com.byazt.fo.qg
    public String q() {
        return com.anythink.core.common.s.a;
    }

    public void n(boolean z) {
        this.q = z;
    }

    public w(q qVar) {
        super(qVar);
        this.q = true;
    }

    @Override // com.byazt.fo.qg
    public long n() {
        long jM = this.n.s().m();
        if (jM > 60000 || jM <= 0) {
            jM = 60000;
        }
        qg[0] = jM;
        return this.s + jM;
    }

    @Override // com.byazt.fo.qg
    public long[] qg() {
        return qg;
    }

    @Override // com.byazt.fo.qg
    public boolean s() {
        Bundle bundleN;
        long jCurrentTimeMillis = System.currentTimeMillis();
        x xVarW = this.n.w();
        if (xVarW != null && (bundleN = xVarW.n(jCurrentTimeMillis, 50000L)) != null) {
            com.byazt.wv.n.n("play_session", bundleN, 1);
            com.byazt.wv.n.qg();
        }
        com.byazt.yi.qg qgVarQg = this.n.qg();
        rv rvVarQ = this.n.q();
        if (rvVarQ.d() != 0) {
            JSONObject jSONObjectS = sz.s(rvVarQ.n());
            if (jSONObjectS != null) {
                n(qgVarQg.n(jSONObjectS));
                this.s = System.currentTimeMillis();
                return true;
            }
            cp.qg((Throwable) null);
        }
        return false;
    }

    private void n(ArrayList<fs> arrayList) {
        com.byazt.yi.qg qgVarQg = this.n.qg();
        ArrayList<fs> arrayList2 = new ArrayList<>();
        ArrayList<fs> arrayList3 = new ArrayList<>();
        com.byazt.ko.fs fsVarS = this.n.s();
        ArrayList<fs> arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<fs> arrayListN = qgVarQg.n();
        if (!arrayListN.isEmpty()) {
            arrayList4.addAll(arrayListN);
        }
        if (arrayList4.size() > 0) {
            for (fs fsVar : arrayList4) {
                if (fsVar.d == null || fsVar.d.length <= 0) {
                    arrayList2.add(fsVar);
                } else {
                    int iN = this.q ? com.byazt.jy.n.n(com.byazt.jy.qg.n(this.n, this.n.getContext(), this.n.q().n()), fsVar.d, fsVarS) : 200;
                    if (com.byazt.jy.n.n(iN)) {
                        if (!arrayList.contains(fsVar)) {
                            break;
                        }
                        fsVar.sz = iN;
                        arrayList3.add(fsVar);
                        break;
                    }
                    if (iN == 200) {
                        arrayList2.add(fsVar);
                    } else {
                        fsVar.sz = iN;
                        arrayList3.add(fsVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                qgVarQg.setResult(arrayList2, arrayList3, arrayList);
            }
            cp.q(q() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
