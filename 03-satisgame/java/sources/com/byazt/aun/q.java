package com.byazt.aun;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 898, 5})
public class q {
    public static volatile q n;
    public final JSONObject s = new JSONObject();
    public final Map<String, Map<String, n>> qg = new ConcurrentHashMap();

    private q() {
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public JSONObject qg() {
        return this.s;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> itKeys = this.s.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObjectOptJSONObject = this.s.optJSONObject(itKeys.next());
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("get_ads", false)) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next = itKeys2.next();
                        if (!"get_ads".equals(next) && !TextUtils.isEmpty(next)) {
                            jSONObject.putOpt(next, n(jSONObjectOptJSONObject.opt(next)));
                        }
                    }
                }
            }
            qg(jSONObject);
        } catch (Throwable th) {
            k.qg("Tmee_TTFeaCalCenter", "getAdsFeature error:" + th.toString());
        }
        return jSONObject;
    }

    private static String n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return String.valueOf(obj);
    }

    private void qg(JSONObject jSONObject) {
        List<com.byazt.gdj.qg> listS;
        String strN;
        if (jSONObject == null || (listS = l.n().s()) == null || listS.isEmpty()) {
            return;
        }
        for (com.byazt.gdj.qg qgVar : listS) {
            if (qgVar != null) {
                try {
                    if (!TextUtils.isEmpty(qgVar.qg()) && "join".equals(qgVar.n()) && (strN = n(qgVar)) != null && qgVar.w()) {
                        jSONObject.putOpt(qgVar.qg(), strN);
                    }
                } catch (Throwable th) {
                    k.qg("Tmee_TTFeaCalCenter", "applyMergeOutputs error:" + th.toString());
                }
            }
        }
    }

    private String n(com.byazt.gdj.qg qgVar) {
        List<String> listQ = qgVar.q();
        List<String> listS = qgVar.s();
        if (listQ == null || listQ.isEmpty() || listS == null || listS.isEmpty()) {
            return null;
        }
        String strL = qgVar.l() != null ? qgVar.l() : ",";
        ArrayList arrayList = new ArrayList();
        for (String str : listQ) {
            if (!TextUtils.isEmpty(str)) {
                Object objOpt = this.s.opt(str);
                if (objOpt instanceof JSONObject) {
                    n((JSONObject) objOpt, listS, arrayList);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(strL);
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }

    private void n(JSONObject jSONObject, List<String> list, List<String> list2) {
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && !"get_ads".equals(next)) {
                Object objOpt = jSONObject.opt(next);
                if (list.contains(next)) {
                    if (objOpt != null && !(objOpt instanceof JSONObject) && !(objOpt instanceof JSONArray)) {
                        String strValueOf = String.valueOf(objOpt);
                        if (!TextUtils.isEmpty(strValueOf)) {
                            list2.add(strValueOf);
                        }
                    }
                } else if (objOpt instanceof JSONObject) {
                    n((JSONObject) objOpt, list, list2);
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        Object objOpt2 = jSONArray.opt(i);
                        if (objOpt2 instanceof JSONObject) {
                            n((JSONObject) objOpt2, list, list2);
                        }
                    }
                }
            }
        }
    }

    public Object n(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object objOpt = this.s.opt(str);
        if ((objOpt instanceof JSONObject) && strArr != null) {
            for (String str2 : strArr) {
                if (TextUtils.isEmpty(str2) || !(objOpt instanceof JSONObject) || (objOpt = ((JSONObject) objOpt).opt(str2)) == null) {
                    return null;
                }
            }
        }
        return objOpt;
    }

    public void n(JSONObject jSONObject) {
        List<com.byazt.gdj.l> listQg = l.n().qg();
        if (listQg == null || listQg.isEmpty()) {
            return;
        }
        Iterator<com.byazt.gdj.l> it = listQg.iterator();
        while (it.hasNext()) {
            try {
                n(it.next(), jSONObject);
            } catch (Throwable th) {
                k.qg("Tmee_TTFeaCalCenter", "processEvent error:" + th.toString());
            }
        }
    }

    private void n(com.byazt.gdj.l lVar, JSONObject jSONObject) {
        if (lVar.n(jSONObject)) {
            n(lVar, qg(lVar, jSONObject), jSONObject);
            n(lVar);
        }
    }

    private void n(com.byazt.gdj.l lVar, String str, JSONObject jSONObject) {
        List<com.byazt.gdj.n> listL = lVar.l();
        if (listL != null) {
            Iterator<com.byazt.gdj.n> it = listL.iterator();
            while (it.hasNext()) {
                n(lVar, it.next(), str, jSONObject);
            }
        }
    }

    private String qg(com.byazt.gdj.l lVar, JSONObject jSONObject) {
        String strS = lVar.s();
        if (strS != null && !strS.isEmpty()) {
            try {
                Object objN = com.byazt.sz.n.n(com.byazt.rm.q.n(strS)).n(jSONObject);
                return objN != null ? objN.toString() : "default";
            } catch (Exception e) {
                k.qg("Tmee_TTFeaCalCenter", "calculateGroupKey error:" + e.toString());
            }
        }
        return "default";
    }

    private void n(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        String strN = nVar.n();
        if (TextUtils.isEmpty(strN)) {
        }
        strN.hashCode();
        switch (strN) {
            case "derive":
                x(lVar, nVar, str, jSONObject);
                break;
            case "quantile":
                com.byazt.gdj.w wVarQ = nVar.q();
                if ((wVarQ == null || n(wVarQ, jSONObject)) && nVar.n(jSONObject)) {
                    s(lVar, nVar, str, jSONObject);
                    break;
                }
                break;
            case "fourOps":
                l(lVar, nVar, str, jSONObject);
                break;
            case "avg":
            case "max":
            case "min":
            case "sum":
                com.byazt.gdj.w wVarQ2 = nVar.q();
                if ((wVarQ2 == null || n(wVarQ2, jSONObject)) && nVar.n(jSONObject)) {
                    n(lVar, nVar, str, jSONObject, strN);
                    break;
                }
                break;
            case "count":
                com.byazt.gdj.w wVarQ3 = nVar.q();
                if ((wVarQ3 == null || n(wVarQ3, jSONObject)) && nVar.n(jSONObject)) {
                    qg(lVar, nVar, str, jSONObject);
                    break;
                }
                break;
            case "regular":
                w(lVar, nVar, str, jSONObject);
                break;
            case "sequence":
                com.byazt.gdj.w wVarQ4 = nVar.q();
                if ((wVarQ4 == null || n(wVarQ4, jSONObject)) && nVar.n(jSONObject)) {
                    q(lVar, nVar, str, jSONObject);
                    break;
                }
                break;
        }
    }

    private void qg(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        if (lVar == null || nVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jOptLong = jSONObject.optLong("ts");
        n nVarN = n(lVar, nVar, str, "count");
        nVarN.l.add(Long.valueOf(jOptLong));
        nVarN.n(System.currentTimeMillis(), true);
        n(lVar, this.qg.get(lVar.n()));
    }

    private long n(n nVar) {
        if (nVar == null) {
            return 0L;
        }
        long size = nVar.l != null ? nVar.l.size() : 0L;
        List<s.n> list = nVar.cp;
        if (list != null && !list.isEmpty()) {
            for (s.n nVar2 : list) {
                if (nVar2 != null && nVar2.tj > 0) {
                    size += nVar2.tj;
                }
            }
        }
        return size;
    }

    private void n(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject, String str2) {
        Double dQg;
        if (lVar == null || nVar == null || TextUtils.isEmpty(str) || jSONObject == null || (dQg = qg(lVar, str, nVar.fs(), jSONObject)) == null) {
            return;
        }
        n nVarN = n(lVar, nVar, str, str2);
        long jOptLong = jSONObject.optLong("ts");
        if (jOptLong <= 0) {
            jOptLong = System.currentTimeMillis();
        }
        nVarN.cy.add(new n.C0130n(jOptLong, dQg.doubleValue()));
        nVarN.n(System.currentTimeMillis(), true);
        n(lVar, this.qg.get(lVar.n()));
    }

    private void s(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        Double dQg;
        if (lVar == null || nVar == null || TextUtils.isEmpty(str) || jSONObject == null || (dQg = qg(lVar, str, nVar.fs(), jSONObject)) == null) {
            return;
        }
        n nVarN = n(lVar, nVar, str, "quantile");
        nVarN.cd = nVar.tj();
        long jOptLong = jSONObject.optLong("ts");
        if (jOptLong <= 0) {
            jOptLong = System.currentTimeMillis();
        }
        nVarN.hd.add(new n.C0130n(jOptLong, dQg.doubleValue()));
        nVarN.n(System.currentTimeMillis(), true);
        n(lVar, this.qg.get(lVar.n()));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0073 A[PHI: r4
      0x0073: PHI (r4v3 double) = (r4v0 double), (r4v1 double) binds: [B:33:0x0071, B:36:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    private Double qg(n nVar) {
        List<Double> listN;
        if (nVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<n.C0130n> list = nVar.hd;
        if (list != null) {
            for (n.C0130n c0130n : list) {
                if (c0130n != null) {
                    arrayList.add(Double.valueOf(c0130n.qg));
                }
            }
        }
        List<s.n> list2 = nVar.cp;
        if (list2 != null && !list2.isEmpty()) {
            for (s.n nVar2 : list2) {
                if (nVar2 != null && "quantile".equals(nVar2.rv) && (listN = n.n(nVar2.cp)) != null && !listN.isEmpty()) {
                    arrayList.addAll(listN);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList);
        double d = nVar.cd;
        double d2 = 0.0d;
        if (d < 0.0d) {
            d = d2;
        } else {
            d2 = 1.0d;
            if (d > 1.0d) {
                d = d2;
            }
        }
        int size = arrayList.size();
        int iCeil = ((int) Math.ceil(d * ((double) size))) - 1;
        if (iCeil < 0) {
            iCeil = 0;
        } else if (iCeil >= size) {
            iCeil = size - 1;
        }
        return (Double) arrayList.get(iCeil);
    }

    private void q(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        if (lVar == null || nVar == null || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        long jOptLong = jSONObject.optLong("ts");
        if (jOptLong <= 0) {
            jOptLong = System.currentTimeMillis();
        }
        long j = jOptLong;
        Object objN = n(lVar, str, nVar.fs(), jSONObject);
        if (objN == null) {
            return;
        }
        Double dQg = qg(lVar, str, nVar.cp(), jSONObject);
        double dDoubleValue = dQg != null ? dQg.doubleValue() : j;
        n nVarN = n(lVar, nVar, str, "sequence");
        nVarN.a = nVar.d();
        nVarN.um.add(new n.qg(j, objN, dDoubleValue));
        nVarN.n(System.currentTimeMillis(), true);
        n(lVar, this.qg.get(lVar.n()));
    }

    private Object n(com.byazt.gdj.l lVar, String str, String str2, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2) && jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectN = n(lVar, str);
                if (jSONObjectN != null) {
                    Iterator<String> itKeys = jSONObjectN.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.putOpt(next, jSONObjectN.opt(next));
                    }
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys2 = jSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        jSONObject2.putOpt(next2, jSONObject.opt(next2));
                    }
                }
                return com.byazt.sz.n.n(com.byazt.rm.q.n(str2)).n(jSONObject2);
            } catch (Throwable th) {
                k.qg("Tmee_TTFeaCalCenter", "evalFieldObject error:" + th.toString());
            }
        }
        return null;
    }

    private JSONArray s(n nVar) {
        List<n.qg> listQg;
        if (nVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<n.qg> list = nVar.um;
        if (list != null) {
            for (n.qg qgVar : list) {
                if (qgVar != null) {
                    arrayList.add(qgVar);
                }
            }
        }
        List<s.n> list2 = nVar.cp;
        if (list2 != null && !list2.isEmpty()) {
            for (s.n nVar2 : list2) {
                if (nVar2 != null && "sequence".equals(nVar2.rv) && (listQg = n.qg(nVar2.cp)) != null && !listQg.isEmpty()) {
                    arrayList.addAll(listQg);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        final boolean z = nVar.a;
        Collections.sort(arrayList, new Comparator<n.qg>() { // from class: com.byazt.aun.q.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(n.qg qgVar2, n.qg qgVar3) {
                int iCompare = Double.compare(qgVar2.s, qgVar3.s);
                return z ? iCompare : -iCompare;
            }
        });
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(((n.qg) it.next()).qg);
        }
        return jSONArray;
    }

    private Double qg(com.byazt.gdj.l lVar, String str, String str2, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str2) && jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObjectN = n(lVar, str);
                if (jSONObjectN != null) {
                    Iterator<String> itKeys = jSONObjectN.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject2.putOpt(next, jSONObjectN.opt(next));
                    }
                }
                if (jSONObject != null) {
                    Iterator<String> itKeys2 = jSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        jSONObject2.putOpt(next2, jSONObject.opt(next2));
                    }
                }
                Object objN = com.byazt.sz.n.n(com.byazt.rm.q.n(str2)).n(jSONObject2);
                if (objN instanceof Number) {
                    return Double.valueOf(((Number) objN).doubleValue());
                }
                if (objN instanceof String) {
                    try {
                        return Double.valueOf(Double.parseDouble((String) objN));
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } catch (Throwable th) {
                k.qg("Tmee_TTFeaCalCenter", "evalNumericField error:" + th.toString());
            }
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Double n(String str, n nVar) {
        long j;
        if (nVar != null && !TextUtils.isEmpty(str)) {
            List<n.C0130n> list = nVar.cy;
            List<s.n> list2 = nVar.cp;
            boolean z = false;
            boolean z2 = list == null || list.isEmpty();
            boolean z3 = list2 == null || list2.isEmpty();
            if (z2 && z3) {
                return null;
            }
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case 96978:
                    if (str.equals("avg")) {
                        b = 0;
                    }
                    break;
                case 107876:
                    if (str.equals("max")) {
                        b = 1;
                    }
                    break;
                case 108114:
                    if (str.equals("min")) {
                        b = 2;
                    }
                    break;
                case 114251:
                    if (str.equals("sum")) {
                        b = 3;
                    }
                    break;
            }
            double d = 0.0d;
            switch (b) {
                case 0:
                    if (z2) {
                        j = 0;
                    } else {
                        j = 0;
                        for (n.C0130n c0130n : list) {
                            if (c0130n != null) {
                                d += c0130n.qg;
                                j++;
                            }
                        }
                    }
                    if (!z3) {
                        for (s.n nVar2 : list2) {
                            if (nVar2 != null && nVar2.tj > 0) {
                                d += nVar2.fs * nVar2.tj;
                                j += nVar2.tj;
                            }
                        }
                    }
                    if (j > 0) {
                        return Double.valueOf(d / j);
                    }
                    break;
                case 1:
                    double d2 = Double.NEGATIVE_INFINITY;
                    if (!z2) {
                        for (n.C0130n c0130n2 : list) {
                            if (c0130n2 != null && c0130n2.qg > d2) {
                                d2 = c0130n2.qg;
                                z = true;
                            }
                        }
                    }
                    if (!z3) {
                        for (s.n nVar3 : list2) {
                            if (nVar3 != null && nVar3.tj > 0 && nVar3.fs > d2) {
                                d2 = nVar3.fs;
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        return Double.valueOf(d2);
                    }
                    return null;
                case 2:
                    double d3 = Double.POSITIVE_INFINITY;
                    if (!z2) {
                        for (n.C0130n c0130n3 : list) {
                            if (c0130n3 != null && c0130n3.qg < d3) {
                                d3 = c0130n3.qg;
                                z = true;
                            }
                        }
                    }
                    if (!z3) {
                        for (s.n nVar4 : list2) {
                            if (nVar4 != null && nVar4.tj > 0 && nVar4.fs < d3) {
                                d3 = nVar4.fs;
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        return Double.valueOf(d3);
                    }
                    return null;
                case 3:
                    if (!z2) {
                        for (n.C0130n c0130n4 : list) {
                            if (c0130n4 != null) {
                                d += c0130n4.qg;
                            }
                        }
                    }
                    if (!z3) {
                        for (s.n nVar5 : list2) {
                            if (nVar5 != null) {
                                d += nVar5.fs;
                            }
                        }
                    }
                    return Double.valueOf(d);
                default:
                    return null;
            }
        }
        return null;
    }

    private static boolean s(String str) {
        return "sum".equals(str) || "min".equals(str) || "max".equals(str) || "avg".equals(str);
    }

    private void l(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        if (lVar == null || nVar == null || TextUtils.isEmpty(str) || jSONObject == null || !nVar.n(jSONObject)) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        com.byazt.gdj.w wVarQ = nVar.q();
        String strN = wVarQ != null ? wVarQ.n() : null;
        String strX = nVar.x();
        boolean z = !TextUtils.isEmpty(strN) && strN.equals(strOptString);
        boolean z2 = !TextUtils.isEmpty(strX) && strX.equals(strOptString);
        n nVarN = n(lVar, nVar, str, "fourOps");
        com.byazt.gdj.q qVarW = nVar.w();
        if (qVarW != null && !qVarW.s()) {
            if (n(qVarW.n(), jSONObject)) {
                nVarN.w.put("start", jSONObject);
            }
            if (n(qVarW.qg(), jSONObject)) {
                nVarN.w.put("end", jSONObject);
            }
        }
        if (z) {
            Object objN = n(nVar, nVarN.w);
            if (objN != null) {
                nVarN.x = objN;
                nVarN.n(System.currentTimeMillis());
            }
            n(lVar, this.qg.get(lVar.n()));
        }
        if (z2) {
            nVarN.w.clear();
        }
    }

    private void w(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        if (lVar == null || nVar == null || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        com.byazt.gdj.w wVarQ = nVar.q();
        String strN = wVarQ != null ? wVarQ.n() : null;
        String strX = nVar.x();
        boolean z = !TextUtils.isEmpty(strN) && strN.equals(strOptString);
        boolean z2 = !TextUtils.isEmpty(strX) && strX.equals(strOptString);
        n nVarN = n(lVar, nVar, str, "regular");
        String strOptString2 = jSONObject.optString("state_num");
        if (z2) {
            nVarN.rv.setLength(0);
            if (!TextUtils.isEmpty(strOptString2)) {
                nVarN.rv.append(strOptString2);
            }
        } else if (nVar.n(jSONObject) && !TextUtils.isEmpty(strOptString2)) {
            nVarN.rv.append(strOptString2);
        }
        if (z) {
            String strQg = qg(nVar);
            if (!TextUtils.isEmpty(strQg)) {
                try {
                    nVarN.tj = Boolean.valueOf(Pattern.compile(strQg).matcher(nVarN.rv.toString()).matches());
                } catch (Throwable th) {
                    k.qg("Tmee_TTFeaCalCenter", "functionRegular pattern error:" + th.toString());
                    nVarN.tj = Boolean.FALSE;
                }
            }
            nVarN.n(System.currentTimeMillis());
            n(lVar, this.qg.get(lVar.n()));
        }
    }

    private boolean n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.TRUE.equals(com.byazt.sz.n.n(com.byazt.rm.q.n(str)).n(jSONObject));
        } catch (Throwable th) {
            k.qg("Tmee_TTFeaCalCenter", "matchParamEvent error:" + th.toString());
            return false;
        }
    }

    private Object n(com.byazt.gdj.n nVar, Map<String, JSONObject> map) {
        com.byazt.gdj.q qVarW;
        String strQg = nVar.qg();
        if (!TextUtils.isEmpty(strQg) && (qVarW = nVar.w()) != null && qVarW.q() && map.get("start") != null && map.get("end") != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
                return com.byazt.sz.n.n(com.byazt.rm.q.n(strQg)).n(jSONObject);
            } catch (Throwable th) {
                k.qg("Tmee_TTFeaCalCenter", "calculateFourOps error:" + th.toString());
            }
        }
        return null;
    }

    private void x(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        if (lVar == null || nVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.gdj.w wVarQ = nVar.q();
        if ((wVarQ == null || n(wVarQ, jSONObject)) && nVar.n(jSONObject)) {
            n nVarN = n(lVar, nVar, str, "derive");
            Object objFs = fs(lVar, nVar, str, jSONObject);
            if (objFs != null) {
                nVarN.fs = objFs;
            }
        }
    }

    private Object fs(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, JSONObject jSONObject) {
        String strQg = nVar.qg();
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectN = n(lVar, str);
            if (jSONObjectN != null) {
                Iterator<String> itKeys = jSONObjectN.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObjectN.opt(next));
                }
            }
            if (jSONObject != null) {
                Iterator<String> itKeys2 = jSONObject.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject2.putOpt(next2, jSONObject.opt(next2));
                }
            }
            return com.byazt.sz.n.n(com.byazt.rm.q.n(strQg)).n(jSONObject2);
        } catch (Throwable th) {
            k.qg("Tmee_TTFeaCalCenter", "calculateDerive error:" + th.toString());
            return null;
        }
    }

    private JSONObject n(com.byazt.gdj.l lVar, String str) {
        JSONObject jSONObject = new JSONObject();
        Map<String, n> map = this.qg.get(lVar.n());
        if (map == null) {
            return jSONObject;
        }
        try {
            for (n nVar : map.values()) {
                if (nVar != null && str.equals(nVar.qg) && !TextUtils.isEmpty(nVar.s)) {
                    if ("count".equals(nVar.n)) {
                        jSONObject.put(nVar.s, n(nVar));
                    } else if ("fourOps".equals(nVar.n)) {
                        jSONObject.put(nVar.s, nVar.x != null ? nVar.x : 0);
                    } else if ("derive".equals(nVar.n)) {
                        jSONObject.put(nVar.s, nVar.fs != null ? nVar.fs : 0);
                    } else if (s(nVar.n)) {
                        Double dN = n(nVar.n, nVar);
                        jSONObject.put(nVar.s, dN != null ? dN.doubleValue() : 0.0d);
                    } else if ("quantile".equals(nVar.n)) {
                        Double dQg = qg(nVar);
                        jSONObject.put(nVar.s, dQg != null ? dQg.doubleValue() : 0.0d);
                    } else if ("sequence".equals(nVar.n)) {
                        JSONArray jSONArrayS = s(nVar);
                        String str2 = nVar.s;
                        if (jSONArrayS == null) {
                            jSONArrayS = new JSONArray();
                        }
                        jSONObject.put(str2, jSONArrayS);
                    } else if ("regular".equals(nVar.n)) {
                        jSONObject.put(nVar.s, nVar.tj != null ? nVar.tj.booleanValue() : false);
                    }
                }
            }
        } catch (Throwable th) {
            k.qg("Tmee_TTFeaCalCenter", "collectGroupResults error:" + th.toString());
        }
        return jSONObject;
    }

    private n n(com.byazt.gdj.l lVar, com.byazt.gdj.n nVar, String str, String str2) {
        String strN = lVar.n();
        Map<String, n> concurrentHashMap = this.qg.get(strN);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.qg.put(strN, concurrentHashMap);
        }
        String str3 = str + "_" + nVar.s();
        n nVar2 = concurrentHashMap.get(str3);
        if (nVar2 == null) {
            nVar2 = new n();
            com.byazt.gdj.x xVarQ = lVar.q();
            if (xVarQ != null && xVarQ.q()) {
                long jQg = xVarQ.qg();
                long jN = xVarQ.n();
                if (jQg > 0 && jN > 0) {
                    nVar2.d = true;
                    nVar2.oa = jQg;
                    nVar2.sz = jN;
                    nVar2.a = nVar.d();
                } else {
                    k.qg("Tmee_TTFeaCalCenter", "invalid cross_session window config, bucketSize=" + jQg + ", windowTime=" + jN);
                }
            }
            nVar2.n = str2;
            nVar2.qg = str;
            nVar2.s = nVar.s();
            nVar2.q = lVar.n();
            nVar2.n(System.currentTimeMillis());
            concurrentHashMap.put(str3, nVar2);
        }
        return nVar2;
    }

    private void n(com.byazt.gdj.l lVar, Map<String, n> map) {
        com.byazt.gdj.x xVarQ;
        if (map == null || map.isEmpty() || (xVarQ = lVar.q()) == null) {
            return;
        }
        String type = xVarQ.getType();
        if ("time".equals(type) || "cross_session".equals(type)) {
            long jN = xVarQ.n() * 1000;
            for (n nVar : map.values()) {
                if (nVar.n() < System.currentTimeMillis() - jN) {
                    map.remove(nVar.qg + "_" + nVar.s);
                } else {
                    Iterator<Long> it = nVar.l.iterator();
                    while (it.hasNext()) {
                        long jLongValue = it.next().longValue();
                        if (jLongValue < System.currentTimeMillis() - jN) {
                            nVar.l.remove(Long.valueOf(jLongValue));
                        }
                    }
                    if (nVar.cy != null && !nVar.cy.isEmpty()) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - jN;
                        for (n.C0130n c0130n : nVar.cy) {
                            if (c0130n != null && c0130n.n < jCurrentTimeMillis) {
                                nVar.cy.remove(c0130n);
                            }
                        }
                    }
                    if (nVar.hd != null && !nVar.hd.isEmpty()) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jN;
                        for (n.C0130n c0130n2 : nVar.hd) {
                            if (c0130n2 != null && c0130n2.n < jCurrentTimeMillis2) {
                                nVar.hd.remove(c0130n2);
                            }
                        }
                    }
                    if (nVar.um != null && !nVar.um.isEmpty()) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jN;
                        for (n.qg qgVar : nVar.um) {
                            if (qgVar != null && qgVar.n < jCurrentTimeMillis3) {
                                nVar.um.remove(qgVar);
                            }
                        }
                    }
                    if (xVarQ.q()) {
                        nVar.s();
                    }
                }
            }
        }
    }

    public void n(com.byazt.gdj.l lVar, List<s.n> list) {
        if (lVar == null || list == null || list.isEmpty()) {
            return;
        }
        String strN = lVar.n();
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        Map<String, n> concurrentHashMap = this.qg.get(strN);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.qg.put(strN, concurrentHashMap);
        }
        com.byazt.gdj.x xVarQ = lVar.q();
        boolean z = xVarQ != null && xVarQ.q();
        long jQg = xVarQ != null ? xVarQ.qg() : 0L;
        long jN = xVarQ != null ? xVarQ.n() : 0L;
        for (s.n nVar : list) {
            if (nVar != null && !TextUtils.isEmpty(nVar.x)) {
                String str = nVar.q + "_" + nVar.x;
                n nVar2 = concurrentHashMap.get(str);
                if (nVar2 == null) {
                    nVar2 = new n();
                    nVar2.n = nVar.rv;
                    nVar2.qg = nVar.q;
                    nVar2.s = nVar.x;
                    nVar2.q = nVar.qg;
                    nVar2.d = z;
                    nVar2.oa = jQg;
                    nVar2.sz = jN;
                    if ("sequence".equals(nVar.rv)) {
                        nVar2.a = n(lVar, nVar.rv, nVar.x);
                    }
                    nVar2.n(nVar.d);
                    concurrentHashMap.put(str, nVar2);
                } else if (nVar.d > nVar2.n()) {
                    nVar2.n(nVar.d);
                }
                nVar2.cp.add(nVar);
            }
        }
        n(lVar);
        list.size();
    }

    public boolean n(com.byazt.gdj.l lVar, String str, String str2) {
        if (lVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || lVar.l() == null || lVar.l().isEmpty() || TextUtils.isEmpty(lVar.n())) {
            return true;
        }
        for (com.byazt.gdj.n nVar : lVar.l()) {
            if (nVar != null && str.equals(nVar.n()) && str2.equals(nVar.s())) {
                return nVar.d();
            }
        }
        return true;
    }

    public void n(String str) {
        Map<String, n> map;
        com.byazt.gdj.l lVarN;
        com.byazt.gdj.x xVarQ;
        if (TextUtils.isEmpty(str) || (map = this.qg.get(str)) == null || map.isEmpty() || (lVarN = l.n().n(str)) == null || (xVarQ = lVarN.q()) == null) {
            return;
        }
        if ("time".equals(xVarQ.getType()) || "cross_session".equals(xVarQ.getType())) {
            long jN = xVarQ.n() * 1000;
            for (n nVar : map.values()) {
                if (nVar.n() < System.currentTimeMillis() - jN) {
                    map.remove(nVar.qg + "_" + nVar.s);
                } else {
                    Iterator<Long> it = nVar.l.iterator();
                    while (it.hasNext()) {
                        long jLongValue = it.next().longValue();
                        if (jLongValue < System.currentTimeMillis() - jN) {
                            nVar.l.remove(Long.valueOf(jLongValue));
                        }
                    }
                    if (nVar.cy != null && !nVar.cy.isEmpty()) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - jN;
                        for (n.C0130n c0130n : nVar.cy) {
                            if (c0130n != null && c0130n.n < jCurrentTimeMillis) {
                                nVar.cy.remove(c0130n);
                            }
                        }
                    }
                    if (nVar.hd != null && !nVar.hd.isEmpty()) {
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jN;
                        for (n.C0130n c0130n2 : nVar.hd) {
                            if (c0130n2 != null && c0130n2.n < jCurrentTimeMillis2) {
                                nVar.hd.remove(c0130n2);
                            }
                        }
                    }
                    if (nVar.um != null && !nVar.um.isEmpty()) {
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jN;
                        for (n.qg qgVar : nVar.um) {
                            if (qgVar != null && qgVar.n < jCurrentTimeMillis3) {
                                nVar.um.remove(qgVar);
                            }
                        }
                    }
                    if (xVarQ.q()) {
                        nVar.s();
                    }
                }
            }
        }
        n(lVarN);
    }

    public void qg(String str) {
        Map<String, n> map;
        com.byazt.gdj.l lVarN;
        if (TextUtils.isEmpty(str) || (map = this.qg.get(str)) == null || map.isEmpty() || (lVarN = l.n().n(str)) == null || lVarN.q() == null) {
            return;
        }
        Iterator<n> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    private boolean n(com.byazt.gdj.w wVar, JSONObject jSONObject) {
        String type = wVar.getType();
        String strN = wVar.n();
        if (NotificationCompat.CATEGORY_EVENT.equals(type)) {
            Object objOpt = jSONObject.opt("type");
            if (strN != null && objOpt != null && strN.equals(objOpt.toString())) {
                return true;
            }
        }
        return false;
    }

    private void n(com.byazt.gdj.l lVar) {
        try {
            Map<String, n> map = this.qg.get(lVar.n());
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (n nVar : map.values()) {
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(nVar.qg);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    if ("fourOps".equals(nVar.n)) {
                        if (nVar.x != null) {
                            jSONObjectOptJSONObject.putOpt(nVar.s, nVar.x);
                        }
                    } else if ("count".equals(nVar.n)) {
                        jSONObjectOptJSONObject.putOpt(nVar.s, Long.valueOf(n(nVar)));
                    } else if ("derive".equals(nVar.n)) {
                        if (nVar.fs != null) {
                            jSONObjectOptJSONObject.putOpt(nVar.s, nVar.fs);
                        }
                    } else if (s(nVar.n)) {
                        Iterator<s.n> it = nVar.cp.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                        Double dN = n(nVar.n, nVar);
                        if (dN != null) {
                            jSONObjectOptJSONObject.putOpt(nVar.s, dN);
                        }
                    } else if ("quantile".equals(nVar.n)) {
                        Double dQg = qg(nVar);
                        if (dQg != null) {
                            jSONObjectOptJSONObject.putOpt(nVar.s, dQg);
                        }
                    } else if ("sequence".equals(nVar.n)) {
                        JSONArray jSONArrayS = s(nVar);
                        if (jSONArrayS != null) {
                            jSONObjectOptJSONObject.putOpt(nVar.s, jSONArrayS);
                        }
                    } else if ("regular".equals(nVar.n) && nVar.tj != null) {
                        jSONObjectOptJSONObject.putOpt(nVar.s, nVar.tj);
                    }
                    jSONObject2.putOpt(nVar.qg, jSONObjectOptJSONObject);
                }
                jSONObject.putOpt("results", jSONObject2);
                JSONObject jSONObjectS = s(lVar, jSONObject2);
                if (jSONObjectS != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("results", jSONObject2);
                    jSONObject3.putOpt("postAggregate", jSONObjectS);
                    jSONObject2.putOpt("postAggregate", jSONObjectS);
                    jSONObject.putOpt("results", jSONObject2);
                }
                List<com.byazt.gdj.s> listX = lVar.x();
                if (listX == null || listX.isEmpty()) {
                    return;
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("get_ads", lVar.fs());
                for (com.byazt.gdj.s sVar : listX) {
                    Object objN = n(sVar, jSONObject);
                    if (objN != null) {
                        jSONObject4.put(sVar.qg(), objN);
                    }
                }
                this.s.put(lVar.n(), jSONObject4);
            }
        } catch (Throwable th) {
            k.qg("Tmee_TTFeaCalCenter", "generateOutputs error:" + th.toString());
        }
    }

    private JSONObject s(com.byazt.gdj.l lVar, JSONObject jSONObject) {
        List<com.byazt.gdj.n> listW = lVar.w();
        if (listW == null || listW.isEmpty() || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (com.byazt.gdj.n nVar : listW) {
            if (nVar != null && !TextUtils.isEmpty(nVar.s()) && !TextUtils.isEmpty(nVar.n())) {
                String strN = n(nVar);
                if (!TextUtils.isEmpty(strN)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
                        if (jSONObjectOptJSONObject != null) {
                            Object objOpt = jSONObjectOptJSONObject.opt(strN);
                            if (objOpt instanceof Number) {
                                copyOnWriteArrayList.add(Double.valueOf(((Number) objOpt).doubleValue()));
                            }
                        }
                    }
                    Double dN = n(nVar.n(), copyOnWriteArrayList);
                    if (dN != null) {
                        try {
                            jSONObject2.put(nVar.s(), dN);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return jSONObject2;
    }

    private String n(com.byazt.gdj.n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.fs();
    }

    private String qg(com.byazt.gdj.n nVar) {
        if (nVar == null) {
            return null;
        }
        return nVar.rv();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Double n(String str, List<Double> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            str.hashCode();
            int i = 0;
            byte b = -1;
            switch (str.hashCode()) {
                case 96978:
                    if (str.equals("avg")) {
                        b = 0;
                    }
                    break;
                case 107876:
                    if (str.equals("max")) {
                        b = 1;
                    }
                    break;
                case 108114:
                    if (str.equals("min")) {
                        b = 2;
                    }
                    break;
                case 114251:
                    if (str.equals("sum")) {
                        b = 3;
                    }
                    break;
            }
            double dDoubleValue = 0.0d;
            switch (b) {
                case 0:
                    for (Double d : list) {
                        if (d != null) {
                            dDoubleValue += d.doubleValue();
                            i++;
                        }
                    }
                    if (i > 0) {
                        return Double.valueOf(dDoubleValue / ((double) i));
                    }
                    break;
                case 1:
                    double dDoubleValue2 = Double.NEGATIVE_INFINITY;
                    for (Double d2 : list) {
                        if (d2 != null && d2.doubleValue() > dDoubleValue2) {
                            dDoubleValue2 = d2.doubleValue();
                        }
                    }
                    return Double.valueOf(dDoubleValue2);
                case 2:
                    double dDoubleValue3 = Double.POSITIVE_INFINITY;
                    for (Double d3 : list) {
                        if (d3 != null && d3.doubleValue() < dDoubleValue3) {
                            dDoubleValue3 = d3.doubleValue();
                        }
                    }
                    return Double.valueOf(dDoubleValue3);
                case 3:
                    for (Double d4 : list) {
                        if (d4 != null) {
                            dDoubleValue += d4.doubleValue();
                        }
                    }
                    return Double.valueOf(dDoubleValue);
                default:
                    return null;
            }
        }
        return null;
    }

    private Object n(com.byazt.gdj.s sVar, JSONObject jSONObject) {
        String strN = sVar.n();
        if (strN != null && !strN.isEmpty()) {
            try {
                return com.byazt.sz.n.n(com.byazt.rm.q.n(strN)).n(jSONObject);
            } catch (Throwable th) {
                k.qg("Tmee_TTFeaCalCenter", "calculateOutput error:" + th.toString());
            }
        }
        return null;
    }
}
