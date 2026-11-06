package com.byazt.uko;

import android.text.TextUtils;
import com.byazt.mq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 13})
public class hw {
    public m aj;
    public double c;
    public double fw;
    public int uc;
    public String zo;
    public Map<String, hn> pr = new HashMap();
    public Map<String, hn> hw = new HashMap();
    public Map<String, hn> hn = new HashMap();
    public double x = Math.random();

    public hw(double d, int i, double d2, String str, m mVar) {
        this.c = d;
        this.uc = i;
        this.fw = d2;
        this.zo = str;
        this.aj = mVar;
    }

    public hn pr(com.byazt.rk.zo zoVar, float f, float f2) {
        if (TextUtils.isEmpty(zoVar.vk().hw()) && zoVar.vk().c().gu() == null) {
            return new hn(0.0f, 0.0f);
        }
        if (TextUtils.equals(zoVar.vk().getType(), "creative-playable-bait")) {
            return new hn(0.0f, 0.0f);
        }
        float fZo = zoVar.zo();
        float fAj = zoVar.aj();
        com.byazt.rk.uc ucVarC = zoVar.vk().c();
        String strVe = ucVarC.ve();
        String strIu = ucVarC.iu();
        float fM = zoVar.m();
        float fG = zoVar.g();
        float fHo = zoVar.ho();
        float fNt = zoVar.nt();
        if (TextUtils.equals(strVe, "fixed")) {
            f = Math.min(fZo, f);
            if (TextUtils.equals(strIu, "auto")) {
                fAj = hw(zoVar, f - fHo, f2 - fNt).hw + fNt;
            }
        } else if (TextUtils.equals(strVe, "auto")) {
            hn hnVarHw = hw(zoVar, f - fHo, f2 - fNt);
            f = hnVarHw.pr + fHo;
            if (TextUtils.equals(strIu, "auto")) {
                fAj = hnVarHw.hw + fNt;
            }
        } else if (!TextUtils.equals(strVe, "flex")) {
            f = fZo;
        } else if (TextUtils.equals(strIu, "auto")) {
            fAj = hw(zoVar, f - fHo, f2 - fNt).hw + fNt;
        }
        if (!TextUtils.equals(strIu, "scale")) {
            if (TextUtils.equals(strIu, "fixed")) {
                f2 = Math.min(fAj + fG, f2);
            } else if (!TextUtils.equals(strIu, "flex")) {
                f2 = fAj;
            }
        } else {
            float fRound = Math.round((f - fM) / fAj) + fG;
            if (fRound <= f2) {
                f2 = fRound;
            } else {
                f = Math.round((f2 - fG) * fAj) + fM;
            }
        }
        hn hnVar = new hn();
        hnVar.pr = f;
        hnVar.hw = f2;
        return hnVar;
    }

    public hn hw(com.byazt.rk.zo zoVar, float f, float f2) {
        hn hnVar = new hn();
        if (zoVar.vk().c() == null) {
            return hnVar;
        }
        hn hnVarC = c(zoVar, f, f2);
        float f3 = hnVarC.pr;
        float f4 = hnVarC.hw;
        hnVar.pr = Math.min(f3, f);
        hnVar.hw = Math.min(f4, f2);
        return hnVar;
    }

    private hn c(com.byazt.rk.zo zoVar, float f, float f2) {
        String str = zoVar.hn() + "_" + f + "_" + f2;
        if (this.hn.containsKey(str)) {
            return this.hn.get(str);
        }
        hn hnVarUc = uc(zoVar, f, f2);
        this.hn.put(str, hnVarUc);
        return hnVarUc;
    }

    private hn uc(com.byazt.rk.zo zoVar, float f, float f2) {
        com.byazt.rk.uc ucVarC = zoVar.vk().c();
        float fLb = ucVarC.lb();
        int iO = ucVarC.o();
        double dIe = ucVarC.ie();
        int iBm = ucVarC.bm();
        boolean zOf = ucVarC.of();
        boolean zJn = ucVarC.jn();
        int iIi = ucVarC.ii();
        C0209hw c0209hw = new C0209hw();
        c0209hw.pr = fLb;
        c0209hw.hw = iO;
        c0209hw.hn = iBm;
        c0209hw.x = dIe;
        c0209hw.c = f;
        return pr(zoVar.vk().hw(), c0209hw, zOf, zJn, iIi, zoVar);
    }

    private hn pr(String str, C0209hw c0209hw, boolean z, boolean z2, int i, com.byazt.rk.zo zoVar) {
        return w.pr(str, zoVar.vk().getType(), C0209hw.pr(c0209hw).toString(), z, z2, i, zoVar, this.c, this.uc, this.fw, this.zo, this.aj);
    }

    public hn hn(com.byazt.rk.zo zoVar, float f, float f2) {
        if (zoVar == null) {
            return null;
        }
        hn hnVarPr = pr(zoVar);
        if (hnVarPr == null || (hnVarPr.pr == 0.0f && hnVarPr.hw == 0.0f)) {
            hn hnVarX = x(zoVar, f, f2);
            pr(zoVar, hnVarX);
            return hnVarX;
        }
        return hnVarPr;
    }

    public hn x(com.byazt.rk.zo zoVar, float f, float f2) {
        float fMin;
        float fMin2;
        hn hnVar = new hn();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            hnVar.pr = 0.0f;
            hnVar.hw = 0.0f;
            return hnVar;
        }
        if (zoVar.lb()) {
            return pr(zoVar, f, f2);
        }
        float fZo = zoVar.zo();
        float fAj = zoVar.aj();
        float fHo = zoVar.ho();
        float fNt = zoVar.nt();
        com.byazt.rk.uc ucVarC = zoVar.vk().c();
        String strVe = ucVarC.ve();
        String strIu = ucVarC.iu();
        if (TextUtils.equals(strVe, "flex") || TextUtils.equals(strVe, "auto")) {
            fMin = f;
        } else {
            fMin = Math.min(fZo, f);
        }
        float fRound = fMin - fHo;
        if (TextUtils.equals(strIu, "scale")) {
            fMin2 = Math.round(fRound / fAj) + fNt;
            if (fMin2 > f2) {
                fRound = Math.round((f2 - fNt) * fAj);
                fMin2 = f2;
            }
        } else if (TextUtils.equals(strIu, "auto") || TextUtils.equals(strIu, "flex")) {
            fMin2 = f2;
        } else {
            fMin2 = Math.min(fAj, f2);
        }
        float f4 = fMin2 - fNt;
        List<List<com.byazt.rk.zo>> listYb = zoVar.yb();
        Iterator<List<com.byazt.rk.zo>> it = listYb.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            it = it;
            List<com.byazt.rk.zo> next = it.next();
            hnVar = hnVar;
            hn hnVarHw = hw(next, fRound, f4);
            if (hw(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, hnVarHw.pr);
            }
            f3 = f3;
            if (zoVar.vk().getType().equals("carousel")) {
                fMax2 = Math.max(zoVar.aj(), hnVarHw.hw);
            } else {
                fMax2 += hnVarHw.hw;
            }
        }
        hn hnVar2 = hnVar;
        if (TextUtils.equals(strVe, "auto")) {
            if (f3 == listYb.size()) {
                fRound = f;
            } else {
                for (List<com.byazt.rk.zo> list : listYb) {
                    hn(list);
                    hw(list, fMax, f4);
                }
                fRound = fMax;
            }
        }
        if (TextUtils.equals(strIu, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                pr(listYb, fRound, f4);
            }
        } else if ((TextUtils.equals(strIu, "fixed") || TextUtils.equals(strIu, "flex")) && f4 < fMax2) {
            pr(listYb, fRound, f4);
        }
        hnVar2.pr = Math.min(fRound + fHo, f);
        hnVar2.hw = Math.min(f4 + fNt, f2);
        return hnVar2;
    }

    private void pr(List<List<com.byazt.rk.zo>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.rk.zo>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (pr(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.byazt.rk.zo> list2 : list) {
            pr prVar = new pr();
            boolean zPr = pr(list2, !z);
            prVar.pr = zPr ? 1.0f : hw(list2, f, f2).hw;
            prVar.hw = !zPr;
            arrayList.add(prVar);
        }
        List<pr> listPr = vk.pr(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((pr) arrayList.get(i)).pr != listPr.get(i).pr) {
                List<com.byazt.rk.zo> list3 = list.get(i);
                hn(list3);
                hw(list3, f, listPr.get(i).pr);
            }
        }
    }

    private boolean hw(List<com.byazt.rk.zo> list) {
        boolean z;
        List<List<com.byazt.rk.zo>> listYb;
        Iterator<com.byazt.rk.zo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().vk().c().ve(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        boolean z2 = false;
        for (com.byazt.rk.zo zoVar : list) {
            if (TextUtils.equals(zoVar.vk().c().ve(), "auto") && (listYb = zoVar.yb()) != null) {
                int i = 0;
                for (List<com.byazt.rk.zo> list2 : listYb) {
                    i++;
                    if (!hw(list2)) {
                        z2 = false;
                        break;
                    }
                    if (i == list2.size()) {
                        z2 = true;
                    }
                }
            }
        }
        return z2;
    }

    private hn hw(List<com.byazt.rk.zo> list, float f, float f2) {
        hn hnVarPr = pr(list);
        if (hnVarPr == null || (hnVarPr.pr == 0.0f && hnVarPr.hw == 0.0f)) {
            hn hnVarHn = hn(list, f, f2);
            pr(list, hnVarHn);
            return hnVarHn;
        }
        return hnVarPr;
    }

    private hn hn(List<com.byazt.rk.zo> list, float f, float f2) {
        float fMax;
        x(list);
        hn hnVar = new hn();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.byazt.rk.zo zoVar : list) {
            com.byazt.rk.uc ucVarC = zoVar.vk().c();
            if (ucVarC.l() == 1 || ucVarC.l() == 2) {
                arrayList.add(zoVar);
            }
            if (ucVarC.l() != 1 && ucVarC.l() != 2) {
                arrayList2.add(zoVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hn((com.byazt.rk.zo) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return hnVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.byazt.rk.zo> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(hn(it2.next(), f, f2).pr));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            com.byazt.rk.zo zoVar2 = arrayList2.get(i);
            String strVe = zoVar2.vk().c().ve();
            float fZo = zoVar2.zo();
            boolean zEquals = TextUtils.equals(strVe, "flex");
            if (TextUtils.equals(strVe, "auto")) {
                List<List<com.byazt.rk.zo>> listYb = zoVar2.yb();
                if (listYb != null && listYb.size() > 0) {
                    Iterator<List<com.byazt.rk.zo>> it3 = listYb.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (hw(it3.next())) {
                                zEquals = true;
                                break;
                            }
                        } else {
                            zEquals = false;
                            break;
                        }
                    }
                } else {
                    zEquals = false;
                    break;
                }
            }
            pr prVar = new pr();
            if (!zEquals) {
                fZo = ((Float) arrayList3.get(i)).floatValue();
            }
            prVar.pr = fZo;
            prVar.hw = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            prVar.hn = fMax;
            arrayList4.add(prVar);
            i++;
        }
        pr(arrayList4, f, arrayList2);
        List<pr> listPr = vk.pr(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listPr.get(i2).pr;
            if (((Float) arrayList3.get(i2)).floatValue() != listPr.get(i2).pr) {
                x(arrayList2.get(i2));
            }
        }
        Iterator<com.byazt.rk.zo> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!hw(it4.next())) {
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
            com.byazt.rk.zo zoVar3 = arrayList2.get(i4);
            hn hnVarHn = hn(zoVar3, listPr.get(i4).pr, f2);
            if (!hw(zoVar3)) {
                fMax = Math.max(fMax, hnVarHn.hw);
            }
            arrayList5.add(hnVarHn);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((hn) it5.next()).hw));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.byazt.rk.zo zoVar4 = arrayList2.get(i5);
                if (hw(zoVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    x(zoVar4);
                    hn(zoVar4, listPr.get(i5).pr, fMax);
                }
            }
        }
        hnVar.pr = f3;
        hnVar.hw = fMax;
        return hnVar;
    }

    private boolean hw(com.byazt.rk.zo zoVar) {
        if (zoVar == null) {
            return false;
        }
        if (TextUtils.equals(zoVar.vk().c().iu(), "flex")) {
            return true;
        }
        return hn(zoVar);
    }

    private boolean hn(com.byazt.rk.zo zoVar) {
        List<List<com.byazt.rk.zo>> listYb;
        if (zoVar.lb() || !TextUtils.equals(zoVar.vk().c().iu(), "auto") || (listYb = zoVar.yb()) == null || listYb.size() <= 0) {
            return false;
        }
        if (listYb.size() == 1) {
            Iterator<com.byazt.rk.zo> it = listYb.get(0).iterator();
            while (it.hasNext()) {
                if (!hw(it.next())) {
                    return false;
                }
            }
            return true;
        }
        Iterator<List<com.byazt.rk.zo>> it2 = listYb.iterator();
        while (it2.hasNext()) {
            if (pr(it2.next(), true)) {
                return true;
            }
        }
        return false;
    }

    private boolean pr(List<com.byazt.rk.zo> list, boolean z) {
        boolean z2;
        Iterator<com.byazt.rk.zo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            com.byazt.rk.zo next = it.next();
            com.byazt.rk.uc ucVarC = next.vk().c();
            String strIu = ucVarC.iu();
            if (TextUtils.equals(strIu, "flex")) {
                z2 = true;
                break;
            }
            if (z) {
                if (TextUtils.equals(ucVarC.ve(), "flex") && TextUtils.equals(ucVarC.iu(), "scale") && com.byazt.rk.c.pr.get(next.vk().getType()).intValue() == 7) {
                    z2 = true;
                    break;
                }
                if (TextUtils.equals(strIu, "flex")) {
                    z2 = true;
                    break;
                }
            }
        }
        if (z2) {
            return true;
        }
        Iterator<com.byazt.rk.zo> it2 = list.iterator();
        while (it2.hasNext()) {
            if (hn(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private void pr(List<pr> list, float f, List<com.byazt.rk.zo> list2) {
        float f2 = 0.0f;
        for (pr prVar : list) {
            if (prVar.hw) {
                f2 += prVar.pr;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).hw && list2.get(i2).ny()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    pr prVar2 = list.get(i3);
                    if (prVar2.hw && list2.get(i3).ny()) {
                        prVar2.pr -= fCeil;
                    }
                }
            }
        }
    }

    public void pr() {
        this.hn.clear();
        this.pr.clear();
        this.hw.clear();
    }

    public hn pr(com.byazt.rk.zo zoVar) {
        return this.pr.get(c(zoVar));
    }

    public hn pr(List<com.byazt.rk.zo> list) {
        return this.hw.get(x(list));
    }

    private void x(com.byazt.rk.zo zoVar) {
        this.pr.remove(c(zoVar));
        List<List<com.byazt.rk.zo>> listYb = zoVar.yb();
        if (listYb == null || listYb.size() <= 0) {
            return;
        }
        Iterator<List<com.byazt.rk.zo>> it = listYb.iterator();
        while (it.hasNext()) {
            hn(it.next());
        }
    }

    private void hn(List<com.byazt.rk.zo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.hw.remove(x(list));
        Iterator<com.byazt.rk.zo> it = list.iterator();
        while (it.hasNext()) {
            x(it.next());
        }
    }

    private String c(com.byazt.rk.zo zoVar) {
        return zoVar.hn();
    }

    private String x(List<com.byazt.rk.zo> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strHn = list.get(i).hn();
            if (i < list.size() - 1) {
                sb.append(strHn).append("-");
            } else {
                sb.append(strHn);
            }
        }
        return sb.toString();
    }

    private void pr(com.byazt.rk.zo zoVar, hn hnVar) {
        this.pr.put(c(zoVar), hnVar);
    }

    private void pr(List<com.byazt.rk.zo> list, hn hnVar) {
        this.hw.put(x(list), hnVar);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 931, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME})
    static class hn {
        public float hw;
        public float pr;

        public hn() {
        }

        public hn(float f, float f2) {
            this.pr = f;
            this.hw = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.pr + ", height=" + this.hw + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.byazt.uko.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 931, 497})
    static class C0209hw {
        public float c;
        public int hn;
        public int hw;
        public float pr;
        public double x;

        public static JSONObject pr(C0209hw c0209hw) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0209hw.pr);
                jSONObject.put("letterSpacing", c0209hw.hw);
                jSONObject.put("lineHeight", c0209hw.x);
                jSONObject.put("maxWidth", c0209hw.c);
                jSONObject.put("fontWeight", c0209hw.hn);
            } catch (JSONException e) {
            }
            return jSONObject;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 931, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static class pr implements Cloneable {
        public float hn;
        public boolean hw;
        public float pr;

        public Object clone() {
            try {
                return (pr) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }
}
