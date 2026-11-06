package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.xr.zb;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private double ab;
    private int c;
    private double ka;
    private zb ny;
    private String x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public Map<String, ah> f790ms = new HashMap();
    public Map<String, ah> xr = new HashMap();
    public Map<String, ah> ah = new HashMap();
    private double d = Math.random();

    public xr(double d, int i, double d2, String str, zb zbVar) {
        this.ka = d;
        this.c = i;
        this.ab = d2;
        this.x = str;
        this.ny = zbVar;
    }

    public ah ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(xVar.ch().xr()) && xVar.ch().ka().vy() == null) {
            return new ah(0.0f, 0.0f);
        }
        if (TextUtils.equals(xVar.ch().getType(), "creative-playable-bait")) {
            return new ah(0.0f, 0.0f);
        }
        float fX = xVar.x();
        float fNy = xVar.ny();
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = xVar.ch().ka();
        String strLe = cVarKa.le();
        String strOp = cVarKa.op();
        float fZb = xVar.zb();
        float fU = xVar.u();
        float fUb = xVar.ub();
        float fAo = xVar.ao();
        if (TextUtils.equals(strLe, "fixed")) {
            f = Math.min(fX, f);
            if (TextUtils.equals(strOp, "auto")) {
                f3 = xr(xVar, f - fUb, f2 - fAo).xr;
                fNy = f3 + fAo;
            }
        } else if (TextUtils.equals(strLe, "auto")) {
            ah ahVarXr = xr(xVar, f - fUb, f2 - fAo);
            f = ahVarXr.f791ms + fUb;
            if (TextUtils.equals(strOp, "auto")) {
                f3 = ahVarXr.xr;
                fNy = f3 + fAo;
            }
        } else if (!TextUtils.equals(strLe, "flex")) {
            f = fX;
        } else if (TextUtils.equals(strOp, "auto")) {
            f3 = xr(xVar, f - fUb, f2 - fAo).xr;
            fNy = f3 + fAo;
        }
        if (TextUtils.equals(strOp, "scale")) {
            float fRound = Math.round((f - fZb) / fNy) + fU;
            if (fRound > f2) {
                f = Math.round((f2 - fU) * fNy) + fZb;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strOp, "fixed")) {
            f2 = Math.min(fNy + fU, f2);
        } else if (!TextUtils.equals(strOp, "flex")) {
            f2 = fNy;
        }
        ah ahVar = new ah();
        ahVar.f791ms = f;
        ahVar.xr = f2;
        return ahVar;
    }

    public ah xr(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        ah ahVar = new ah();
        if (xVar.ch().ka() == null) {
            return ahVar;
        }
        ah ahVarKa = ka(xVar, f, f2);
        float f3 = ahVarKa.f791ms;
        float f4 = ahVarKa.xr;
        ahVar.f791ms = Math.min(f3, f);
        ahVar.xr = Math.min(f4, f2);
        return ahVar;
    }

    private ah ka(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        String str = xVar.ah() + "_" + f + "_" + f2;
        if (this.ah.containsKey(str)) {
            return this.ah.get(str);
        }
        ah ahVarC = c(xVar, f, f2);
        this.ah.put(str, ahVarC);
        return ahVarC;
    }

    private ah c(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = xVar.ch().ka();
        float fQv = cVarKa.qv();
        int iAm = cVarKa.am();
        double dL = cVarKa.l();
        int iTz = cVarKa.tz();
        boolean zK = cVarKa.k();
        boolean zTi = cVarKa.ti();
        int iEg = cVarKa.eg();
        C0229xr c0229xr = new C0229xr();
        c0229xr.f793ms = fQv;
        c0229xr.xr = iAm;
        c0229xr.ah = iTz;
        c0229xr.d = dL;
        c0229xr.ka = f;
        return ms(xVar.ch().xr(), c0229xr, zK, zTi, iEg, xVar);
    }

    private ah ms(String str, C0229xr c0229xr, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        return hi.ms(str, xVar.ch().getType(), C0229xr.ms(c0229xr).toString(), z, z2, i, xVar, this.ka, this.c, this.ab, this.x, this.ny);
    }

    public ah ah(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        if (xVar == null) {
            return null;
        }
        ah ahVarMs = ms(xVar);
        if (ahVarMs != null && (ahVarMs.f791ms != 0.0f || ahVarMs.xr != 0.0f)) {
            return ahVarMs;
        }
        ah ahVarD = d(xVar, f, f2);
        ms(xVar, ahVarD);
        return ahVarD;
    }

    public ah d(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        float fMin;
        ah ahVar = new ah();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            ahVar.f791ms = 0.0f;
            ahVar.xr = 0.0f;
            return ahVar;
        }
        if (xVar.qv()) {
            return ms(xVar, f, f2);
        }
        float fX = xVar.x();
        float fNy = xVar.ny();
        float fUb = xVar.ub();
        float fAo = xVar.ao();
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = xVar.ch().ka();
        String strLe = cVarKa.le();
        String strOp = cVarKa.op();
        float fMin2 = ((TextUtils.equals(strLe, "flex") || TextUtils.equals(strLe, "auto")) ? f : Math.min(fX, f)) - fUb;
        if (TextUtils.equals(strOp, "scale")) {
            fMin = Math.round(fMin2 / fNy) + fAo;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fAo) * fNy);
            }
        } else {
            fMin = (TextUtils.equals(strOp, "auto") || TextUtils.equals(strOp, "flex")) ? f2 : Math.min(fNy, f2);
        }
        float f4 = fMin - fAo;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH = xVar.h();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it = listH.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> next = it.next();
            ah ahVar2 = ahVar;
            ah ahVarXr = xr(next, fMin2, f4);
            if (xr(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, ahVarXr.f791ms);
            }
            float f5 = f3;
            if (xVar.ch().getType().equals("carousel")) {
                fMax2 = Math.max(xVar.ny(), ahVarXr.xr);
            } else {
                fMax2 += ahVarXr.xr;
            }
            ahVar = ahVar2;
            it = it2;
            f3 = f5;
        }
        ah ahVar3 = ahVar;
        if (TextUtils.equals(strLe, "auto")) {
            if (f3 == listH.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list : listH) {
                    ah(list);
                    xr(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strOp, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                ms(listH, fMin2, f4);
            }
        } else if ((TextUtils.equals(strOp, "fixed") || TextUtils.equals(strOp, "flex")) && f4 < fMax2) {
            ms(listH, fMin2, f4);
        }
        ahVar3.f791ms = Math.min(fMin2 + fUb, f);
        ahVar3.xr = Math.min(f4 + fAo, f2);
        return ahVar3;
    }

    private void ms(List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (ms(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list2 : list) {
            ms msVar = new ms();
            boolean zMs = ms(list2, !z);
            msVar.f792ms = zMs ? 1.0f : xr(list2, f, f2).xr;
            msVar.xr = !zMs;
            arrayList.add(msVar);
        }
        List<ms> listMs = ch.ms(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((ms) arrayList.get(i)).f792ms != listMs.get(i).f792ms) {
                List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list3 = list.get(i);
                ah(list3);
                xr(list3, f, listMs.get(i).f792ms);
            }
        }
    }

    private boolean xr(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list) {
        boolean z;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().ch().ka().le(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar : list) {
                if (TextUtils.equals(xVar.ch().ka().le(), "auto") && (listH = xVar.h()) != null) {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it2 = listH.iterator();
                    int i = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> next = it2.next();
                            i++;
                            if (xr(next)) {
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

    private ah xr(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list, float f, float f2) {
        ah ahVarMs = ms(list);
        if (ahVarMs != null && (ahVarMs.f791ms != 0.0f || ahVarMs.xr != 0.0f)) {
            return ahVarMs;
        }
        ah ahVarAh = ah(list, f, f2);
        ms(list, ahVarAh);
        return ahVarAh;
    }

    private ah ah(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list, float f, float f2) {
        float fMax;
        d(list);
        ah ahVar = new ah();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = xVar.ch().ka();
            if (cVarKa.s() == 1 || cVarKa.s() == 2) {
                arrayList.add(xVar);
            }
            if (cVarKa.s() != 1 && cVarKa.s() != 2) {
                arrayList2.add(xVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ah((com.bytedance.sdk.component.adexpress.dynamic.ah.x) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return ahVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(ah(it2.next(), f, f2).f791ms));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2 = arrayList2.get(i);
            String strLe = xVar2.ch().ka().le();
            float fX = xVar2.x();
            boolean zEquals = TextUtils.equals(strLe, "flex");
            if (TextUtils.equals(strLe, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH = xVar2.h();
                if (listH == null || listH.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it3 = listH.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (xr(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            ms msVar = new ms();
            if (!zEquals) {
                fX = ((Float) arrayList3.get(i)).floatValue();
            }
            msVar.f792ms = fX;
            msVar.xr = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            msVar.ah = fMax;
            arrayList4.add(msVar);
            i++;
        }
        ms(arrayList4, f, arrayList2);
        List<ms> listMs = ch.ms(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listMs.get(i2).f792ms;
            if (((Float) arrayList3.get(i2)).floatValue() != listMs.get(i2).f792ms) {
                d(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!xr(it4.next())) {
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
            com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar3 = arrayList2.get(i4);
            ah ahVarAh = ah(xVar3, listMs.get(i4).f792ms, f2);
            if (!xr(xVar3)) {
                fMax = Math.max(fMax, ahVarAh.xr);
            }
            arrayList5.add(ahVarAh);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((ah) it5.next()).xr));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar4 = arrayList2.get(i5);
                if (xr(xVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    d(xVar4);
                    ah(xVar4, listMs.get(i5).f792ms, fMax);
                }
            }
        }
        ahVar.f791ms = f3;
        ahVar.xr = fMax;
        return ahVar;
    }

    private boolean xr(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        if (xVar == null) {
            return false;
        }
        if (TextUtils.equals(xVar.ch().ka().op(), "flex")) {
            return true;
        }
        return ah(xVar);
    }

    private boolean ah(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH;
        if (!xVar.qv() && TextUtils.equals(xVar.ch().ka().op(), "auto") && (listH = xVar.h()) != null && listH.size() > 0) {
            if (listH.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it = listH.get(0).iterator();
                while (it.hasNext()) {
                    if (!xr(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it2 = listH.iterator();
            while (it2.hasNext()) {
                if (ms(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ms(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list, boolean z) {
        boolean z2;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ah.x next = it.next();
            com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = next.ch().ka();
            String strOp = cVarKa.op();
            if (TextUtils.equals(strOp, "flex") || (z && ((TextUtils.equals(cVarKa.le(), "flex") && TextUtils.equals(cVarKa.op(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.ah.ka.f764ms.get(next.ch().getType()).intValue() == 7) || TextUtils.equals(strOp, "flex")))) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it2 = list.iterator();
        while (it2.hasNext()) {
            if (ah(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private void ms(List<ms> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list2) {
        float f2 = 0.0f;
        for (ms msVar : list) {
            if (msVar.xr) {
                f2 += msVar.f792ms;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).xr && list2.get(i2).b()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    ms msVar2 = list.get(i3);
                    if (msVar2.xr && list2.get(i3).b()) {
                        msVar2.f792ms -= fCeil;
                    }
                }
            }
        }
    }

    public void ms() {
        this.ah.clear();
        this.f790ms.clear();
        this.xr.clear();
    }

    public ah ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        return this.f790ms.get(ka(xVar));
    }

    public ah ms(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list) {
        return this.xr.get(d(list));
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        this.f790ms.remove(ka(xVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH = xVar.h();
        if (listH == null || listH.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it = listH.iterator();
        while (it.hasNext()) {
            ah(it.next());
        }
    }

    private void ah(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.xr.remove(d(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it = list.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    private String ka(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar) {
        return xVar.ah();
    }

    private String d(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strAh = list.get(i).ah();
            if (i < list.size() - 1) {
                sb.append(strAh).append("-");
            } else {
                sb.append(strAh);
            }
        }
        return sb.toString();
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, ah ahVar) {
        this.f790ms.put(ka(xVar), ahVar);
    }

    private void ms(List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list, ah ahVar) {
        this.xr.put(d(list), ahVar);
    }

    static class ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f791ms;
        float xr;

        public ah() {
        }

        public ah(float f, float f2) {
            this.f791ms = f;
            this.xr = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.f791ms + ", height=" + this.xr + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.d.xr$xr, reason: collision with other inner class name */
    static class C0229xr {
        int ah;
        double d;
        float ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f793ms;
        int xr;

        C0229xr() {
        }

        static JSONObject ms(C0229xr c0229xr) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0229xr.f793ms);
                jSONObject.put("letterSpacing", c0229xr.xr);
                jSONObject.put("lineHeight", c0229xr.d);
                jSONObject.put("maxWidth", c0229xr.ka);
                jSONObject.put("fontWeight", c0229xr.ah);
            } catch (JSONException e) {
                sl.ms(e);
            }
            return jSONObject;
        }
    }

    static class ms implements Cloneable {
        float ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f792ms;
        boolean xr;

        ms() {
        }

        public Object clone() {
            try {
                return (ms) super.clone();
            } catch (CloneNotSupportedException e) {
                sl.ms(e);
                return null;
            }
        }
    }
}
