package com.byazt.gf;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.jy.c;
import com.byazt.jy.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 37})
public class pr {
    public static volatile pr pr;
    public final JSONObject hn = new JSONObject();
    public final Map<String, Map<String, C0077pr>> hw = new ConcurrentHashMap();

    private pr() {
    }

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public JSONObject hw() {
        return this.hn;
    }

    public JSONObject hn() {
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> itKeys = this.hn.keys();
            while (itKeys.hasNext()) {
                JSONObject jSONObjectOptJSONObject = this.hn.optJSONObject(itKeys.next());
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean("get_ads", false)) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next = itKeys2.next();
                        if (!"get_ads".equals(next) && !TextUtils.isEmpty(next)) {
                            jSONObject.putOpt(next, jSONObjectOptJSONObject.opt(next));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "getAdsFeature error:" + th.toString());
        }
        return jSONObject;
    }

    public Object pr(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object objOpt = this.hn.opt(str);
        if (!(objOpt instanceof JSONObject) || strArr == null) {
            return objOpt;
        }
        for (String str2 : strArr) {
            if (TextUtils.isEmpty(str2) || !(objOpt instanceof JSONObject) || (objOpt = ((JSONObject) objOpt).opt(str2)) == null) {
                return null;
            }
        }
        return objOpt;
    }

    public void pr(JSONObject jSONObject) {
        List<com.byazt.jy.x> listHw = hw.pr().hw();
        if (listHw == null || listHw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.jy.x> it = listHw.iterator();
        while (it.hasNext()) {
            try {
                pr(it.next(), jSONObject);
            } catch (Throwable th) {
                ho.hw("Tme_TTFeaCalCenter", "processEvent error:" + th.toString());
            }
        }
    }

    private void pr(com.byazt.jy.x xVar, JSONObject jSONObject) {
        if (!xVar.pr(jSONObject)) {
            return;
        }
        pr(xVar, hw(xVar, jSONObject), jSONObject);
        pr(xVar);
    }

    private void pr(com.byazt.jy.x xVar, String str, JSONObject jSONObject) {
        List<com.byazt.jy.pr> listC = xVar.c();
        if (listC != null) {
            Iterator<com.byazt.jy.pr> it = listC.iterator();
            while (it.hasNext()) {
                pr(xVar, it.next(), str, jSONObject);
            }
        }
    }

    private String hw(com.byazt.jy.x xVar, JSONObject jSONObject) {
        String strHn = xVar.hn();
        if (strHn == null || strHn.isEmpty()) {
            return "default";
        }
        try {
            Object objPr = com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strHn)).pr(jSONObject);
            return objPr != null ? objPr.toString() : "default";
        } catch (Exception e) {
            ho.hw("Tme_TTFeaCalCenter", "calculateGroupKey error:" + e.toString());
            return "default";
        }
    }

    private void pr(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, JSONObject jSONObject) {
        String strPr = prVar.pr();
        if (TextUtils.isEmpty(strPr)) {
        }
        switch (strPr) {
            case "count":
                c cVarX = prVar.x();
                if ((cVarX == null || pr(cVarX, jSONObject)) && prVar.pr(jSONObject)) {
                    hw(xVar, prVar, str, jSONObject);
                    break;
                }
                break;
            case "fourOps":
                hn(xVar, prVar, str, jSONObject);
                break;
            case "derive":
                x(xVar, prVar, str, jSONObject);
                break;
        }
    }

    private void hw(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, JSONObject jSONObject) {
        if (xVar == null || prVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jOptLong = jSONObject.optLong("ts");
        C0077pr c0077prPr = pr(xVar, prVar, str, "count");
        c0077prPr.c.add(Long.valueOf(jOptLong));
        c0077prPr.x = System.currentTimeMillis();
        pr(xVar, this.hw.get(xVar.pr()));
    }

    private void hn(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, JSONObject jSONObject) {
        List<com.byazt.jy.hn> listUc;
        if (xVar == null || prVar == null || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        c cVarX = prVar.x();
        String strPr = cVarX != null ? cVarX.pr() : null;
        String strFw = prVar.fw();
        boolean z = !TextUtils.isEmpty(strPr) && strPr.equals(strOptString);
        boolean z2 = !TextUtils.isEmpty(strFw) && strFw.equals(strOptString);
        C0077pr c0077prPr = pr(xVar, prVar, str, "fourOps");
        if (!z && !z2 && prVar.pr(jSONObject) && (listUc = prVar.uc()) != null) {
            for (com.byazt.jy.hn hnVar : listUc) {
                if (hnVar != null && !TextUtils.isEmpty(hnVar.hw()) && pr(hnVar.pr(), jSONObject)) {
                    c0077prPr.uc.put(hnVar.hw(), jSONObject);
                }
            }
        }
        if (z) {
            Object objPr = pr(prVar, c0077prPr.uc);
            if (objPr != null) {
                c0077prPr.fw = objPr;
                c0077prPr.x = System.currentTimeMillis();
            }
            pr(xVar, this.hw.get(xVar.pr()));
        }
        if (z2) {
            c0077prPr.uc.clear();
        }
    }

    private boolean pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.TRUE.equals(com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(str)).pr(jSONObject));
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "matchParamEvent error:" + th.toString());
            return false;
        }
    }

    private Object pr(com.byazt.jy.pr prVar, Map<String, JSONObject> map) {
        List<com.byazt.jy.hn> listUc;
        String strHw = prVar.hw();
        if (TextUtils.isEmpty(strHw) || (listUc = prVar.uc()) == null || listUc.isEmpty()) {
            return null;
        }
        for (com.byazt.jy.hn hnVar : listUc) {
            if (hnVar == null || TextUtils.isEmpty(hnVar.hw()) || map.get(hnVar.hw()) == null) {
                return null;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
            return com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strHw)).pr(jSONObject);
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "calculateFourOps error:" + th.toString());
            return null;
        }
    }

    private void x(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, JSONObject jSONObject) {
        if (xVar == null || prVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        c cVarX = prVar.x();
        if ((cVarX != null && !pr(cVarX, jSONObject)) || !prVar.pr(jSONObject)) {
            return;
        }
        C0077pr c0077prPr = pr(xVar, prVar, str, "derive");
        Object objC = c(xVar, prVar, str, jSONObject);
        if (objC != null) {
            c0077prPr.zo = objC;
        }
    }

    private Object c(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, JSONObject jSONObject) {
        String strHw = prVar.hw();
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectPr = pr(xVar, str);
            if (jSONObjectPr != null) {
                Iterator<String> itKeys = jSONObjectPr.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObjectPr.opt(next));
                }
            }
            if (jSONObject != null) {
                Iterator<String> itKeys2 = jSONObject.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    jSONObject2.putOpt(next2, jSONObject.opt(next2));
                }
            }
            return com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strHw)).pr(jSONObject2);
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "calculateDerive error:" + th.toString());
            return null;
        }
    }

    private JSONObject pr(com.byazt.jy.x xVar, String str) {
        JSONObject jSONObject = new JSONObject();
        Map<String, C0077pr> map = this.hw.get(xVar.pr());
        if (map == null) {
            return jSONObject;
        }
        try {
            for (C0077pr c0077pr : map.values()) {
                if (c0077pr != null && str.equals(c0077pr.hw) && !TextUtils.isEmpty(c0077pr.hn)) {
                    if ("count".equals(c0077pr.pr)) {
                        jSONObject.put(c0077pr.hn, c0077pr.c.size());
                    } else if ("fourOps".equals(c0077pr.pr)) {
                        jSONObject.put(c0077pr.hn, c0077pr.fw != null ? c0077pr.fw : 0);
                    } else if ("derive".equals(c0077pr.pr)) {
                        jSONObject.put(c0077pr.hn, c0077pr.zo != null ? c0077pr.zo : 0);
                    }
                }
            }
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "collectGroupResults error:" + th.toString());
        }
        return jSONObject;
    }

    private C0077pr pr(com.byazt.jy.x xVar, com.byazt.jy.pr prVar, String str, String str2) {
        String strPr = xVar.pr();
        Map<String, C0077pr> concurrentHashMap = this.hw.get(strPr);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.hw.put(strPr, concurrentHashMap);
        }
        String str3 = str + "_" + prVar.hn();
        C0077pr c0077pr = concurrentHashMap.get(str3);
        if (c0077pr == null) {
            C0077pr c0077pr2 = new C0077pr();
            c0077pr2.pr = str2;
            c0077pr2.hw = str;
            c0077pr2.hn = prVar.hn();
            c0077pr2.x = System.currentTimeMillis();
            concurrentHashMap.put(str3, c0077pr2);
            return c0077pr2;
        }
        return c0077pr;
    }

    private void pr(com.byazt.jy.x xVar, Map<String, C0077pr> map) {
        uc ucVarX;
        if (map != null && !map.isEmpty() && (ucVarX = xVar.x()) != null && "time".equals(ucVarX.getType())) {
            long jPr = ucVarX.pr() * 1000;
            for (C0077pr c0077pr : map.values()) {
                if (c0077pr.x < System.currentTimeMillis() - jPr) {
                    map.remove(c0077pr.hw + "_" + c0077pr.hn);
                } else {
                    Iterator<Long> it = c0077pr.c.iterator();
                    while (it.hasNext()) {
                        long jLongValue = it.next().longValue();
                        if (jLongValue < System.currentTimeMillis() - jPr) {
                            c0077pr.c.remove(Long.valueOf(jLongValue));
                        }
                    }
                }
            }
        }
    }

    public void pr(String str) {
        Map<String, C0077pr> map;
        com.byazt.jy.x xVarPr;
        uc ucVarX;
        if (TextUtils.isEmpty(str) || (map = this.hw.get(str)) == null || map.isEmpty() || (xVarPr = hw.pr().pr(str)) == null || (ucVarX = xVarPr.x()) == null) {
            return;
        }
        long jPr = ucVarX.pr() * 1000;
        for (C0077pr c0077pr : map.values()) {
            if (c0077pr.x < System.currentTimeMillis() - jPr) {
                map.remove(c0077pr.hw + "_" + c0077pr.hn);
            } else {
                Iterator<Long> it = c0077pr.c.iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (jLongValue < System.currentTimeMillis() - jPr) {
                        c0077pr.c.remove(Long.valueOf(jLongValue));
                    }
                }
            }
        }
        pr(xVarPr);
    }

    private boolean pr(c cVar, JSONObject jSONObject) {
        String type = cVar.getType();
        String strPr = cVar.pr();
        if (!NotificationCompat.CATEGORY_EVENT.equals(type)) {
            return false;
        }
        Object objOpt = jSONObject.opt("type");
        return (strPr == null || objOpt == null || !strPr.equals(objOpt.toString())) ? false : true;
    }

    private void pr(com.byazt.jy.x xVar) {
        try {
            Map<String, C0077pr> map = this.hw.get(xVar.pr());
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (C0077pr c0077pr : map.values()) {
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(c0077pr.hw);
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                    }
                    if ("fourOps".equals(c0077pr.pr)) {
                        if (c0077pr.fw != null) {
                            jSONObjectOptJSONObject.putOpt(c0077pr.hn, c0077pr.fw);
                        }
                    } else if ("count".equals(c0077pr.pr)) {
                        jSONObjectOptJSONObject.putOpt(c0077pr.hn, Integer.valueOf(c0077pr.c.size()));
                    } else if ("derive".equals(c0077pr.pr) && c0077pr.zo != null) {
                        jSONObjectOptJSONObject.putOpt(c0077pr.hn, c0077pr.zo);
                    }
                    jSONObject2.putOpt(c0077pr.hw, jSONObjectOptJSONObject);
                }
                jSONObject.putOpt("results", jSONObject2);
                JSONObject jSONObjectHn = hn(xVar, jSONObject2);
                if (jSONObjectHn != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.putOpt("results", jSONObject2);
                    jSONObject3.putOpt("postAggregate", jSONObjectHn);
                    jSONObject2.putOpt("postAggregate", jSONObjectHn);
                    jSONObject.putOpt("results", jSONObject2);
                }
                List<com.byazt.jy.hw> listFw = xVar.fw();
                if (listFw != null && !listFw.isEmpty()) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("get_ads", xVar.zo());
                    for (com.byazt.jy.hw hwVar : listFw) {
                        Object objPr = pr(hwVar, jSONObject);
                        if (objPr != null) {
                            jSONObject4.put(hwVar.hw(), objPr);
                        }
                    }
                    this.hn.put(xVar.pr(), jSONObject4);
                }
            }
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "generateOutputs error:" + th.toString());
        }
    }

    private JSONObject hn(com.byazt.jy.x xVar, JSONObject jSONObject) {
        List<com.byazt.jy.pr> listUc = xVar.uc();
        if (listUc == null || listUc.isEmpty() || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (com.byazt.jy.pr prVar : listUc) {
            if (prVar != null && !TextUtils.isEmpty(prVar.hn()) && !TextUtils.isEmpty(prVar.pr())) {
                String strPr = pr(prVar);
                if (!TextUtils.isEmpty(strPr)) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
                        if (jSONObjectOptJSONObject != null) {
                            Object objOpt = jSONObjectOptJSONObject.opt(strPr);
                            if (objOpt instanceof Number) {
                                copyOnWriteArrayList.add(Double.valueOf(((Number) objOpt).doubleValue()));
                            }
                        }
                    }
                    Double dPr = pr(prVar.pr(), copyOnWriteArrayList);
                    if (dPr != null) {
                        jSONObject2.put(prVar.hn(), dPr);
                    }
                }
            }
        }
        return jSONObject2;
    }

    private String pr(com.byazt.jy.pr prVar) {
        List<com.byazt.jy.hn> listUc = prVar.uc();
        if (listUc != null && !listUc.isEmpty()) {
            for (com.byazt.jy.hn hnVar : listUc) {
                if (hnVar != null && !TextUtils.isEmpty(hnVar.hn())) {
                    return hnVar.hn();
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private Double pr(String str, List<Double> list) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        byte b = -1;
        int i = 0;
        switch (str.hashCode()) {
            case 96978:
                if (str.equals("avg")) {
                    b = 3;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    b = 0;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    b = 1;
                }
                break;
            case 114251:
                if (str.equals("sum")) {
                    b = 2;
                }
                break;
        }
        double dDoubleValue = 0.0d;
        switch (b) {
            case 0:
                double dDoubleValue2 = Double.NEGATIVE_INFINITY;
                for (Double d : list) {
                    if (d != null && d.doubleValue() > dDoubleValue2) {
                        dDoubleValue2 = d.doubleValue();
                    }
                }
                return Double.valueOf(dDoubleValue2);
            case 1:
                double dDoubleValue3 = Double.POSITIVE_INFINITY;
                for (Double d2 : list) {
                    if (d2 != null && d2.doubleValue() < dDoubleValue3) {
                        dDoubleValue3 = d2.doubleValue();
                    }
                }
                return Double.valueOf(dDoubleValue3);
            case 2:
                for (Double d3 : list) {
                    if (d3 != null) {
                        dDoubleValue += d3.doubleValue();
                    }
                }
                return Double.valueOf(dDoubleValue);
            case 3:
                for (Double d4 : list) {
                    if (d4 != null) {
                        dDoubleValue += d4.doubleValue();
                        i++;
                    }
                }
                if (i > 0) {
                    return Double.valueOf(dDoubleValue / ((double) i));
                }
                return null;
            default:
                return null;
        }
    }

    private Object pr(com.byazt.jy.hw hwVar, JSONObject jSONObject) {
        String strPr = hwVar.pr();
        if (strPr == null || strPr.isEmpty()) {
            return null;
        }
        try {
            return com.byazt.oze.pr.pr(com.byazt.uw.hn.pr(strPr)).pr(jSONObject);
        } catch (Throwable th) {
            ho.hw("Tme_TTFeaCalCenter", "calculateOutput error:" + th.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.gf.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0077pr {
        public List<Long> c;
        public Object fw;
        public String hn;
        public String hw;
        public String pr;
        public Map<String, JSONObject> uc;
        public long x;
        public Object zo;

        private C0077pr() {
            this.c = new CopyOnWriteArrayList();
            this.uc = new HashMap();
        }
    }
}
