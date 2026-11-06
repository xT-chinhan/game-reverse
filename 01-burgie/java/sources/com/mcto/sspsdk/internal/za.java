package com.mcto.sspsdk.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.runtime.plugin.ProviderInteractionViews;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public final class za {
    public static volatile za e;
    public int b = 1;
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();

    public static za d() {
        if (e != null) {
            return e;
        }
        synchronized (za.class) {
            if (e == null) {
                e = new za();
            }
        }
        return e;
    }

    public final void a(int i, p pVar) {
        String string;
        mh mhVarC = pVar.c();
        if (mhVarC == null) {
            return;
        }
        ya yaVar = new ya(mhVarC);
        yaVar.a = ab.b(i);
        yaVar.j = mhVarC.f;
        yaVar.u = pVar.w;
        yaVar.v = pVar.v;
        yaVar.p = pVar.m;
        String str = pVar.c.g + ":" + pVar.x.replaceAll(",", "") + ":";
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = pVar.c.b;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(((p) it.next()).x.replaceAll(",", ""));
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(str);
        AtomicInteger atomicInteger = gj.a;
        if (arrayList.isEmpty()) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append((String) arrayList.get(i2));
                if (i2 != size - 1) {
                    sb.append("|");
                }
            }
            string = sb.toString();
        }
        yaVar.w = sbAppend.append(string).toString();
        yaVar.x = pVar.b(i);
        yaVar.y = pVar.y;
        yaVar.t = pVar.b();
        int i3 = pVar.a;
        synchronized (this) {
            AtomicInteger atomicInteger2 = gj.a;
            int i4 = i3 & (-4096);
            Map map = (Map) this.a.get(Integer.valueOf(i4));
            if (map == null) {
                map = new HashMap();
                this.a.put(Integer.valueOf(i4), map);
            }
            List arrayList3 = (List) map.get(Integer.valueOf(i3));
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                map.put(Integer.valueOf(i3), arrayList3);
            }
            arrayList3.add(yaVar);
            int i5 = this.b + 1;
            this.b = i5;
            if (i5 >= 5) {
                a();
            }
            b();
            c();
        }
    }

    public final void b(int i, p pVar, HashMap map) {
        mh mhVarC;
        if (pVar == null || (mhVarC = pVar.c()) == null) {
            return;
        }
        ya yaVar = new ya(mhVarC);
        yaVar.a = ab.b(i);
        yaVar.q = ab.a(i);
        yaVar.s = pVar.a();
        yaVar.x = pVar.b(i);
        yaVar.t = pVar.b();
        yaVar.j = mhVarC.f;
        if (map != null) {
            yaVar.r = (String) map.get("errMsg");
            String str = (String) map.get("extCustom");
            if (!TextUtils.isEmpty(str)) {
                yaVar.x += str;
            }
        }
        int i2 = pVar.a & (-4096);
        synchronized (this) {
            List arrayList = (List) this.d.get(Integer.valueOf(i2));
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.d.put(Integer.valueOf(i2), arrayList);
            }
            arrayList.add(yaVar);
            if (this.d.size() >= 1) {
                c();
            }
        }
    }

    public final void c(int i, p pVar, HashMap map) {
        mh mhVarC;
        String strValueOf;
        JSONObject jSONObject;
        if (pVar == null || (mhVarC = pVar.c()) == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = null;
        map = null;
        HashMap map2 = null;
        if (j.a(i, 10) >= 0 && j.a(i, 13) <= 0) {
            strValueOf = "tracking";
        } else if (j.a(i, 14) >= 0 && j.a(i, 17) <= 0) {
            strValueOf = "adxtracking";
        } else {
            if (j.a(i, 18) < 0 || j.a(i, 21) > 0) {
                return;
            }
            String strValueOf2 = String.valueOf(map.get(v5.KEY_TRACKING_URL));
            if (lj.b(strValueOf2) || (jSONObject = mhVarC.m) == null) {
                map2 = new HashMap(0);
            } else {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String strValueOf3 = String.valueOf(itKeys.next());
                    if (strValueOf2.startsWith(strValueOf3)) {
                        jSONObjectOptJSONObject = mhVarC.m.optJSONObject(strValueOf3);
                        break;
                    }
                }
                map2 = gj.a(jSONObjectOptJSONObject);
            }
            if (map2.isEmpty() || map2.get(an.ax) == null) {
                map2.get(an.ax);
                return;
            }
            strValueOf = String.valueOf(map2.get(an.ax));
        }
        ya yaVar = new ya(mhVarC);
        yaVar.a = ab.b(i);
        yaVar.q = ab.a(i);
        if (map2 != null && !map2.isEmpty()) {
            HashMap map3 = new HashMap();
            yaVar.m = map3;
            map3.putAll(map2);
        }
        try {
            yaVar.o = gj.a(map.get(v5.KEY_REQUEST_DURATION), 0);
            yaVar.n = gj.a(map.get(v5.KEY_REQUEST_COUNT), 0);
            String str = (String) map.get(v5.KEY_TRACKING_URL);
            if (!lj.b(str)) {
                yaVar.x = "tt:" + Uri.parse(str).getQueryParameter(an.av) + ";";
                if (!TextUtils.isEmpty(ab.a(i))) {
                    yaVar.x += "tu:" + str + ";";
                }
            }
        } catch (Exception e2) {
            r9.a("ssp_sdk", "assembleTrackEvent():", e2);
        }
        yaVar.s = pVar.a();
        yaVar.t = pVar.b();
        yaVar.j = mhVarC.f;
        a(pVar.a & (-4096), strValueOf, yaVar);
    }

    public final synchronized void b() {
        if (this.c.isEmpty()) {
            return;
        }
        try {
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                a(a(((Integer) it.next()).intValue()));
            }
        } catch (Exception e2) {
            r9.a("ssp_pingback", "flushMonitorPingback(): ", e2);
        }
        this.c.clear();
    }

    public final synchronized void c() {
        if (this.d.isEmpty()) {
            return;
        }
        try {
            for (Integer num : this.d.keySet()) {
                num.getClass();
                a(a((List) this.d.get(num)));
            }
        } catch (Exception e2) {
            r9.a("ssp_pingback", "flushStatisticsPingback(): ", e2);
        }
        this.d.clear();
    }

    public final void a(int i, h7 h7Var, String str, String str2, mh mhVar) {
        if (mhVar == null) {
            return;
        }
        ya yaVar = new ya(mhVar);
        yaVar.a = ab.b(i);
        yaVar.q = ab.a(i);
        yaVar.j = mhVar.f;
        yaVar.r = str2;
        yaVar.n = h7Var.b;
        yaVar.o = h7Var.a;
        yaVar.x = "rsp:" + str + ";devm:" + (th.a().b ? "1;" : "0;");
        a(mhVar.d, "rsk", yaVar);
    }

    public static void a(mh mhVar) {
        String string;
        if (mhVar == null || mhVar.b.getAndSet(true) || mhVar.n.isEmpty() || j.b(3, mhVar.a)) {
            return;
        }
        ya yaVar = new ya(mhVar);
        yaVar.a = an.aB;
        yaVar.l = mhVar.n;
        yaVar.j = mhVar.f;
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            yaVar.a(jSONStringer);
            jSONStringer.key("inventory").array();
            jSONStringer.object();
            jSONStringer.key(an.aI).array();
            jSONStringer.value(yaVar.a);
            jSONStringer.endArray();
            HashMap map = yaVar.l;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        jSONStringer.key((String) entry.getKey()).value(entry.getValue());
                    }
                }
                gj.a(jSONStringer, "rid", yaVar.j);
                jSONStringer.endObject();
                jSONStringer.endArray();
                jSONStringer.endObject();
                string = jSONStringer.toString();
            } else {
                string = "";
            }
        } catch (JSONException e2) {
            r9.a("ssp_pingback", "buildInventoryEventsValue(): json error:", e2);
        }
        a(string);
    }

    public static void a(int i, p pVar, String str, String str2, String str3) {
        ya yaVar;
        if (pVar != null && pVar.c() != null) {
            yaVar = new ya(pVar.c());
            yaVar.x = pVar.b(i) + str3;
            yaVar.t = pVar.b();
            yaVar.s = pVar.a();
        } else {
            ya yaVar2 = new ya(null);
            if (TextUtils.isEmpty(str)) {
                str = gj.a("st" + j.a(i));
            }
            yaVar2.j = str;
            yaVar2.x = str3;
            yaVar = yaVar2;
        }
        yaVar.a = ab.b(i);
        yaVar.q = ab.a(i);
        yaVar.r = str2;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(yaVar);
        a(a(arrayList));
    }

    public static void a(p pVar, long j, String str, int i, boolean z) {
        if (pVar != null) {
            HashMap map = new HashMap();
            if (!z) {
                map.put("errMsg", "errCode:" + i + ";errMsg:" + gj.f(str));
            }
            map.put("extCustom", "adnType:" + pVar.g + ";adnCodeId:" + pVar.u0 + ";time:" + j + (z ? ";s:1" : ";s:0"));
            d().b(52, pVar, map);
        }
    }

    public final void a(int i, p pVar, HashMap map) {
        mh mhVarC;
        if (pVar == null || (mhVarC = pVar.c()) == null) {
            return;
        }
        ya yaVar = new ya(mhVarC);
        yaVar.a = ab.b(i);
        yaVar.q = ab.a(i);
        yaVar.s = pVar.a();
        yaVar.x = pVar.b(i);
        if (map != null) {
            yaVar.r = gj.a((Map) map, ";", ":", true);
        }
        yaVar.t = pVar.b();
        yaVar.j = mhVarC.f;
        a(pVar.a & (-4096), ProviderInteractionViews.ROLE_CREATIVE, yaVar);
    }

    public final synchronized void a(int i, String str, ya yaVar) {
        Map map = (Map) this.c.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap();
            this.c.put(Integer.valueOf(i), map);
        }
        List arrayList = (List) map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(str, arrayList);
        }
        arrayList.add(yaVar);
        if (this.b >= 5) {
            a();
        }
        b();
        c();
    }

    public final synchronized void a() {
        if (this.a.isEmpty()) {
            return;
        }
        for (Integer num : this.a.keySet()) {
            num.getClass();
            String string = "";
            try {
                Map map = (Map) this.a.get(num);
                if (map != null && !map.isEmpty()) {
                    JSONStringer jSONStringer = new JSONStringer();
                    jSONStringer.object().key(an.aw);
                    jSONStringer.array();
                    yaVar = null;
                    for (Integer num2 : map.keySet()) {
                        num2.getClass();
                        List<ya> list = (List) map.get(num2);
                        if (list != null && !list.isEmpty()) {
                            for (ya yaVar : list) {
                                jSONStringer.object();
                                jSONStringer.key(an.aI).array();
                                jSONStringer.value(yaVar.a);
                                jSONStringer.endArray();
                                jSONStringer.key("sq").value(0);
                                jSONStringer.key("od").value(yaVar.u);
                                jSONStringer.key("ct").value(yaVar.v);
                                jSONStringer.key("dp").value(yaVar.p);
                                gj.a(jSONStringer, "x", yaVar.x);
                                gj.a(jSONStringer, "as", yaVar.w);
                                gj.a(jSONStringer, "rid", yaVar.j);
                                gj.a(jSONStringer, "tt", yaVar.y);
                                gj.a(jSONStringer, "aci", yaVar.t);
                                jSONStringer.endObject();
                            }
                        }
                    }
                    jSONStringer.endArray();
                    if (yaVar != null) {
                        yaVar.a(jSONStringer);
                        string = jSONStringer.endObject().toString();
                    } else {
                        jSONStringer.endObject();
                    }
                } else {
                    string = "";
                }
            } catch (JSONException e2) {
                r9.a("ssp_pingback", "buildAdEventsValue(): json error:", e2);
            }
            a(string);
        }
        this.a.clear();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:5:0x0007, B:7:0x0014, B:14:0x0034, B:15:0x0036, B:8:0x0017, B:10:0x002b, B:12:0x002e), top: B:20:0x0007 }] */
    public static void a(String str) {
        String str2;
        if (lj.b(str)) {
            return;
        }
        try {
            bg bgVar = new bg();
            if (!lj.b(h4.e)) {
                str2 = h4.e;
            } else {
                String strA = nh.a(jd.a).a("dpbu");
                h4.e = strA;
                if (!lj.b(strA)) {
                    str2 = h4.e;
                } else {
                    str2 = "https://msga.cupid.iqiyi.com/scp2.gif";
                    h4.e = "https://msga.cupid.iqiyi.com/scp2.gif";
                }
                if (str2 != null) {
                    bgVar.b = str2;
                }
                bgVar.f = lj.a(gj.f(str));
                bgVar.c = TapHttp.METHOD_POST;
                cg cgVar = new cg(bgVar);
                c7 c7VarA = c7.a();
                c7VarA.getClass();
                zg.a.a(new a7(c7VarA, cgVar));
            }
            if (str2 != null) {
                bgVar.b = str2;
            }
            bgVar.f = lj.a(gj.f(str));
            bgVar.c = TapHttp.METHOD_POST;
            cg cgVar2 = new cg(bgVar);
            c7 c7VarA2 = c7.a();
            c7VarA2.getClass();
            zg.a.a(new a7(c7VarA2, cgVar2));
        } catch (Exception e2) {
            r9.a("ssp_pingback", "Exception. data: " + str, e2);
        }
    }

    public final String a(int i) {
        try {
            Map map = (Map) this.c.get(Integer.valueOf(i));
            if (map != null && !map.isEmpty()) {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                yaVar = null;
                for (String str : map.keySet()) {
                    List<ya> list = (List) map.get(str);
                    if (list != null && !list.isEmpty()) {
                        jSONStringer.key(str).array();
                        for (ya yaVar : list) {
                            jSONStringer.object();
                            jSONStringer.key(an.aI).array();
                            jSONStringer.value(yaVar.a);
                            jSONStringer.endArray();
                            jSONStringer.key("rd").value(yaVar.o);
                            jSONStringer.key("rc").value(yaVar.n);
                            gj.a(jSONStringer, "ec", yaVar.q);
                            gj.a(jSONStringer, "em", yaVar.r);
                            gj.a(jSONStringer, "ai", yaVar.s);
                            gj.a(jSONStringer, "rid", yaVar.j);
                            gj.a(jSONStringer, "x", yaVar.x);
                            gj.a(jSONStringer, "aci", yaVar.t);
                            gj.a(jSONStringer, "meti", yaVar.z);
                            gj.a(jSONStringer, "tads", yaVar.A);
                            HashMap map2 = yaVar.m;
                            if (map2 == null) {
                                jSONStringer.endObject();
                            } else {
                                for (Map.Entry entry : map2.entrySet()) {
                                    if (!"q".equals(entry.getKey()) && entry.getValue() != null) {
                                        jSONStringer.key((String) entry.getKey()).value(entry.getValue());
                                    }
                                }
                                jSONStringer.endObject();
                            }
                        }
                        jSONStringer.endArray();
                    }
                }
                if (yaVar != null) {
                    yaVar.a(jSONStringer);
                    return jSONStringer.endObject().toString();
                }
                jSONStringer.endObject();
                return "";
            }
        } catch (JSONException e2) {
        }
        return "";
    }

    public static void a(int i, String str, HashMap map) {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("pingback"));
            jSONObject.putOpt(an.aB, Long.valueOf(System.currentTimeMillis()));
            jSONObject.putOpt("rnw", ha.a());
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("statistics");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(ab.b(i));
                jSONObjectOptJSONObject.putOpt(an.aI, jSONArray);
                jSONObjectOptJSONObject.putOpt("ec", ab.a(i));
                v5 v5Var = v5.KEY_DOWNLOAD_MSG;
                if (map.containsKey(v5Var)) {
                    jSONObjectOptJSONObject.putOpt("em", map.get(v5Var));
                }
                v5 v5Var2 = v5.KEY_DOWNLOAD_CUSTOM_INFO;
                if (map.containsKey(v5Var2)) {
                    jSONObjectOptJSONObject.putOpt("x", map.get(v5Var2));
                }
                a(jSONObject.toString());
            }
        } catch (Exception e2) {
        }
    }

    public static String a(List list) {
        if (list != null && !list.isEmpty()) {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                jSONStringer.object();
                jSONStringer.key("statistics").array();
                Iterator it = list.iterator();
                ya yaVar = null;
                while (it.hasNext()) {
                    yaVar = (ya) it.next();
                    jSONStringer.object();
                    jSONStringer.key(an.aI).array();
                    jSONStringer.value(yaVar.a);
                    jSONStringer.endArray();
                    jSONStringer.key("rd").value(yaVar.o);
                    gj.a(jSONStringer, "ec", yaVar.q);
                    gj.a(jSONStringer, "ai", yaVar.s);
                    gj.a(jSONStringer, "x", yaVar.x);
                    gj.a(jSONStringer, "rid", yaVar.j);
                    gj.a(jSONStringer, "em", yaVar.r);
                    gj.a(jSONStringer, "aci", yaVar.t);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                if (yaVar != null) {
                    yaVar.a(jSONStringer);
                    return jSONStringer.endObject().toString();
                }
                jSONStringer.endObject();
                return null;
            } catch (JSONException e2) {
                r9.a("ssp_pingback", "buildStatisticsEventsValue(): json error:", e2);
            }
        }
        return null;
    }
}
