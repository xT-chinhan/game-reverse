package com.byazt.hkc;

import android.text.TextUtils;
import com.byazt.udb.oa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 26})
public class qg {
    public String fs;
    public double l;
    public oa rv;
    public int w;
    public double x;
    public Map<String, s> n = new HashMap();
    public Map<String, s> qg = new HashMap();
    public Map<String, s> s = new HashMap();
    public double q = Math.random();

    public qg(double d, int i, double d2, String str, oa oaVar) {
        this.l = d;
        this.w = i;
        this.x = d2;
        this.fs = str;
        this.rv = oaVar;
    }

    public s n(com.byazt.lh.fs fsVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(fsVar.tj().qg()) && fsVar.tj().l().hf() == null) {
            return new s(0.0f, 0.0f);
        }
        if (TextUtils.equals(fsVar.tj().getType(), "creative-playable-bait")) {
            return new s(0.0f, 0.0f);
        }
        float fFs = fsVar.fs();
        float fRv = fsVar.rv();
        com.byazt.lh.w wVarL = fsVar.tj().l();
        String strUr = wVarL.ur();
        String strT = wVarL.t();
        float fOa = fsVar.oa();
        float fSz = fsVar.sz();
        float fK = fsVar.k();
        float fCy = fsVar.cy();
        if (TextUtils.equals(strUr, "fixed")) {
            f = Math.min(fFs, f);
            if (TextUtils.equals(strT, "auto")) {
                f3 = qg(fsVar, f - fK, f2 - fCy).qg;
                fRv = f3 + fCy;
            }
        } else if (TextUtils.equals(strUr, "auto")) {
            s sVarQg = qg(fsVar, f - fK, f2 - fCy);
            f = sVarQg.n + fK;
            if (TextUtils.equals(strT, "auto")) {
                f3 = sVarQg.qg;
                fRv = f3 + fCy;
            }
        } else if (!TextUtils.equals(strUr, "flex")) {
            f = fFs;
        } else if (TextUtils.equals(strT, "auto")) {
            f3 = qg(fsVar, f - fK, f2 - fCy).qg;
            fRv = f3 + fCy;
        }
        if (TextUtils.equals(strT, "scale")) {
            float fRound = Math.round((f - fOa) / fRv) + fSz;
            if (fRound > f2) {
                f = Math.round((f2 - fSz) * fRv) + fOa;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strT, "fixed")) {
            f2 = Math.min(fRv + fSz, f2);
        } else if (!TextUtils.equals(strT, "flex")) {
            f2 = fRv;
        }
        s sVar = new s();
        sVar.n = f;
        sVar.qg = f2;
        return sVar;
    }

    public s qg(com.byazt.lh.fs fsVar, float f, float f2) {
        s sVar = new s();
        if (fsVar.tj().l() == null) {
            return sVar;
        }
        s sVarL = l(fsVar, f, f2);
        float f3 = sVarL.n;
        float f4 = sVarL.qg;
        sVar.n = Math.min(f3, f);
        sVar.qg = Math.min(f4, f2);
        return sVar;
    }

    private s l(com.byazt.lh.fs fsVar, float f, float f2) {
        String str = fsVar.s() + "_" + f + "_" + f2;
        if (this.s.containsKey(str)) {
            return this.s.get(str);
        }
        s sVarW = w(fsVar, f, f2);
        this.s.put(str, sVarW);
        return sVarW;
    }

    private s w(com.byazt.lh.fs fsVar, float f, float f2) {
        com.byazt.lh.w wVarL = fsVar.tj().l();
        float fCd = wVarL.cd();
        int iB = wVarL.b();
        double dDh = wVarL.dh();
        int iNf = wVarL.nf();
        boolean zU = wVarL.u();
        boolean zPe = wVarL.pe();
        int iPk = wVarL.pk();
        C0191qg c0191qg = new C0191qg();
        c0191qg.n = fCd;
        c0191qg.qg = iB;
        c0191qg.s = iNf;
        c0191qg.q = dDh;
        c0191qg.l = f;
        return n(fsVar.tj().qg(), c0191qg, zU, zPe, iPk, fsVar);
    }

    private s n(String str, C0191qg c0191qg, boolean z, boolean z2, int i, com.byazt.lh.fs fsVar) {
        return cp.n(str, fsVar.tj().getType(), C0191qg.n(c0191qg).toString(), z, z2, i, fsVar, this.l, this.w, this.x, this.fs, this.rv);
    }

    public s s(com.byazt.lh.fs fsVar, float f, float f2) {
        if (fsVar == null) {
            return null;
        }
        s sVarN = n(fsVar);
        if (sVarN != null && (sVarN.n != 0.0f || sVarN.qg != 0.0f)) {
            return sVarN;
        }
        s sVarQ = q(fsVar, f, f2);
        n(fsVar, sVarQ);
        return sVarQ;
    }

    public s q(com.byazt.lh.fs fsVar, float f, float f2) {
        float fMin;
        s sVar = new s();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            sVar.n = 0.0f;
            sVar.qg = 0.0f;
            return sVar;
        }
        if (fsVar.cd()) {
            return n(fsVar, f, f2);
        }
        float fFs = fsVar.fs();
        float fRv = fsVar.rv();
        float fK = fsVar.k();
        float fCy = fsVar.cy();
        com.byazt.lh.w wVarL = fsVar.tj().l();
        String strUr = wVarL.ur();
        String strT = wVarL.t();
        float fMin2 = ((TextUtils.equals(strUr, "flex") || TextUtils.equals(strUr, "auto")) ? f : Math.min(fFs, f)) - fK;
        if (TextUtils.equals(strT, "scale")) {
            fMin = Math.round(fMin2 / fRv) + fCy;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fCy) * fRv);
            }
        } else {
            fMin = (TextUtils.equals(strT, "auto") || TextUtils.equals(strT, "flex")) ? f2 : Math.min(fRv, f2);
        }
        float f4 = fMin - fCy;
        List<List<com.byazt.lh.fs>> listHd = fsVar.hd();
        Iterator<List<com.byazt.lh.fs>> it = listHd.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.byazt.lh.fs>> it2 = it;
            List<com.byazt.lh.fs> next = it.next();
            s sVar2 = sVar;
            s sVarQg = qg(next, fMin2, f4);
            if (qg(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, sVarQg.n);
            }
            float f5 = f3;
            if (fsVar.tj().getType().equals("carousel")) {
                fMax2 = Math.max(fsVar.rv(), sVarQg.qg);
            } else {
                fMax2 += sVarQg.qg;
            }
            sVar = sVar2;
            it = it2;
            f3 = f5;
        }
        s sVar3 = sVar;
        if (TextUtils.equals(strUr, "auto")) {
            if (f3 == listHd.size()) {
                fMin2 = f;
            } else {
                for (List<com.byazt.lh.fs> list : listHd) {
                    s(list);
                    qg(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strT, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                n(listHd, fMin2, f4);
            }
        } else if ((TextUtils.equals(strT, "fixed") || TextUtils.equals(strT, "flex")) && f4 < fMax2) {
            n(listHd, fMin2, f4);
        }
        sVar3.n = Math.min(fMin2 + fK, f);
        sVar3.qg = Math.min(f4 + fCy, f2);
        return sVar3;
    }

    private void n(List<List<com.byazt.lh.fs>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.lh.fs>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (n(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.byazt.lh.fs> list2 : list) {
            n nVar = new n();
            boolean zN = n(list2, !z);
            nVar.n = zN ? 1.0f : qg(list2, f, f2).qg;
            nVar.qg = !zN;
            arrayList.add(nVar);
        }
        List<n> listN = tj.n(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((n) arrayList.get(i)).n != listN.get(i).n) {
                List<com.byazt.lh.fs> list3 = list.get(i);
                s(list3);
                qg(list3, f, listN.get(i).n);
            }
        }
    }

    private boolean qg(List<com.byazt.lh.fs> list) {
        boolean z;
        List<List<com.byazt.lh.fs>> listHd;
        Iterator<com.byazt.lh.fs> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().tj().l().ur(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.byazt.lh.fs fsVar : list) {
                if (TextUtils.equals(fsVar.tj().l().ur(), "auto") && (listHd = fsVar.hd()) != null) {
                    Iterator<List<com.byazt.lh.fs>> it2 = listHd.iterator();
                    int i = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<com.byazt.lh.fs> next = it2.next();
                            i++;
                            if (qg(next)) {
                                if (i == next.size()) {
                                    z2 = true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private s qg(List<com.byazt.lh.fs> list, float f, float f2) {
        s sVarN = n(list);
        if (sVarN != null && (sVarN.n != 0.0f || sVarN.qg != 0.0f)) {
            return sVarN;
        }
        s sVarS = s(list, f, f2);
        n(list, sVarS);
        return sVarS;
    }

    private s s(List<com.byazt.lh.fs> list, float f, float f2) {
        float fMax;
        q(list);
        s sVar = new s();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.byazt.lh.fs fsVar : list) {
            com.byazt.lh.w wVarL = fsVar.tj().l();
            if (wVarL.e() == 1 || wVarL.e() == 2) {
                arrayList.add(fsVar);
            }
            if (wVarL.e() != 1 && wVarL.e() != 2) {
                arrayList2.add(fsVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            s((com.byazt.lh.fs) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return sVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.byazt.lh.fs> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(s(it2.next(), f, f2).n));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            com.byazt.lh.fs fsVar2 = arrayList2.get(i);
            String strUr = fsVar2.tj().l().ur();
            float fFs = fsVar2.fs();
            boolean zEquals = TextUtils.equals(strUr, "flex");
            if (TextUtils.equals(strUr, "auto")) {
                List<List<com.byazt.lh.fs>> listHd = fsVar2.hd();
                if (listHd == null || listHd.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<com.byazt.lh.fs>> it3 = listHd.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (qg(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            n nVar = new n();
            if (!zEquals) {
                fFs = ((Float) arrayList3.get(i)).floatValue();
            }
            nVar.n = fFs;
            nVar.qg = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            nVar.s = fMax;
            arrayList4.add(nVar);
            i++;
        }
        n(arrayList4, f, arrayList2);
        List<n> listN = tj.n(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listN.get(i2).n;
            if (((Float) arrayList3.get(i2)).floatValue() != listN.get(i2).n) {
                q(arrayList2.get(i2));
            }
        }
        Iterator<com.byazt.lh.fs> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!qg(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.byazt.lh.fs fsVar3 = arrayList2.get(i4);
            s sVarS = s(fsVar3, listN.get(i4).n, f2);
            if (!qg(fsVar3)) {
                fMax = Math.max(fMax, sVarS.qg);
            }
            arrayList5.add(sVarS);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((s) it5.next()).qg));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.byazt.lh.fs fsVar4 = arrayList2.get(i5);
                if (qg(fsVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    q(fsVar4);
                    s(fsVar4, listN.get(i5).n, fMax);
                }
            }
        }
        sVar.n = f3;
        sVar.qg = fMax;
        return sVar;
    }

    private boolean qg(com.byazt.lh.fs fsVar) {
        if (fsVar == null) {
            return false;
        }
        if (TextUtils.equals(fsVar.tj().l().t(), "flex")) {
            return true;
        }
        return s(fsVar);
    }

    private boolean s(com.byazt.lh.fs fsVar) {
        List<List<com.byazt.lh.fs>> listHd;
        if (!fsVar.cd() && TextUtils.equals(fsVar.tj().l().t(), "auto") && (listHd = fsVar.hd()) != null && listHd.size() > 0) {
            if (listHd.size() == 1) {
                Iterator<com.byazt.lh.fs> it = listHd.get(0).iterator();
                while (it.hasNext()) {
                    if (!qg(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.byazt.lh.fs>> it2 = listHd.iterator();
            while (it2.hasNext()) {
                if (n(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(List<com.byazt.lh.fs> list, boolean z) {
        boolean z2;
        Iterator<com.byazt.lh.fs> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            com.byazt.lh.fs next = it.next();
            com.byazt.lh.w wVarL = next.tj().l();
            String strT = wVarL.t();
            if (TextUtils.equals(strT, "flex") || (z && ((TextUtils.equals(wVarL.ur(), "flex") && TextUtils.equals(wVarL.t(), "scale") && com.byazt.lh.l.n.get(next.tj().getType()).intValue() == 7) || TextUtils.equals(strT, "flex")))) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        Iterator<com.byazt.lh.fs> it2 = list.iterator();
        while (it2.hasNext()) {
            if (s(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private void n(List<n> list, float f, List<com.byazt.lh.fs> list2) {
        float f2 = 0.0f;
        for (n nVar : list) {
            if (nVar.qg) {
                f2 += nVar.n;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).qg && list2.get(i2).ou()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    n nVar2 = list.get(i3);
                    if (nVar2.qg && list2.get(i3).ou()) {
                        nVar2.n -= fCeil;
                    }
                }
            }
        }
    }

    public void n() {
        this.s.clear();
        this.n.clear();
        this.qg.clear();
    }

    public s n(com.byazt.lh.fs fsVar) {
        return this.n.get(l(fsVar));
    }

    public s n(List<com.byazt.lh.fs> list) {
        return this.qg.get(q(list));
    }

    private void q(com.byazt.lh.fs fsVar) {
        this.n.remove(l(fsVar));
        List<List<com.byazt.lh.fs>> listHd = fsVar.hd();
        if (listHd == null || listHd.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.lh.fs>> it = listHd.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    private void s(List<com.byazt.lh.fs> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.qg.remove(q(list));
        Iterator<com.byazt.lh.fs> it = list.iterator();
        while (it.hasNext()) {
            q(it.next());
        }
    }

    private String l(com.byazt.lh.fs fsVar) {
        return fsVar.s();
    }

    private String q(List<com.byazt.lh.fs> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strS = list.get(i).s();
            if (i < list.size() - 1) {
                sb.append(strS).append("-");
            } else {
                sb.append(strS);
            }
        }
        return sb.toString();
    }

    private void n(com.byazt.lh.fs fsVar, s sVar) {
        this.n.put(l(fsVar), sVar);
    }

    private void n(List<com.byazt.lh.fs> list, s sVar) {
        this.qg.put(q(list), sVar);
    }

    @com.byazt.cp.n(n = {0, 1, 46, 47})
    static class s {
        public float n;
        public float qg;

        public s() {
        }

        public s(float f, float f2) {
            this.n = f;
            this.qg = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.n + ", height=" + this.qg + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.byazt.hkc.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 46, 201})
    static class C0191qg {
        public float l;
        public float n;
        public double q;
        public int qg;
        public int s;

        public static JSONObject n(C0191qg c0191qg) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0191qg.n);
                jSONObject.put("letterSpacing", c0191qg.qg);
                jSONObject.put("lineHeight", c0191qg.q);
                jSONObject.put("maxWidth", c0191qg.l);
                jSONObject.put("fontWeight", c0191qg.s);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 46, 48})
    static class n implements Cloneable {
        public float n;
        public boolean qg;
        public float s;

        public Object clone() {
            try {
                return (n) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }
}
