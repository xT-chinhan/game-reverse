package com.byazt.yc;

import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.byazt.vy.wm;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 5})
public class q {
    public static Map<String, List<com.byazt.ws.l>> n = new ConcurrentHashMap();
    public static Map<String, String> qg = new ConcurrentHashMap();

    public static PluginValueSet n(String str, com.byazt.zq.qg.n nVar, int i) {
        long jCurrentTimeMillis;
        String strS;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return com.byazt.pch.n.n(nVar.n());
        }
        if (com.byazt.zs.n.n().n(str)) {
            return com.byazt.pch.n.n(nVar.n());
        }
        String strQg = qg(str);
        if (TextUtils.isEmpty(strQg)) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            strS = s(str);
            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
            i2 = !TextUtils.isEmpty(strS) ? 2 : 3;
        } else {
            jCurrentTimeMillis = 0;
            strS = strQg;
            i2 = 1;
        }
        com.byazt.gp.s.n(i, i2, jCurrentTimeMillis, str, strS);
        if (TextUtils.isEmpty(strS)) {
            return com.byazt.pch.n.n(nVar.n());
        }
        nVar.q(strS);
        return com.byazt.pch.n.n(nVar.n(), str, i2 == 2);
    }

    public static boolean n(String str) {
        return com.byazt.vyf.s.cy().j() && !TextUtils.isEmpty(qg(str));
    }

    public static void n(final JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        double dDoubleValue;
        if (jSONObject == null) {
            return;
        }
        n.clear();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(next)) != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString(e.a.h);
                        long jOptLong = jSONObject2.optLong("csj_code_id");
                        try {
                            dDoubleValue = Double.valueOf(strOptString).doubleValue();
                        } catch (Throwable unused) {
                            dDoubleValue = 0.0d;
                        }
                        copyOnWriteArrayList.add(new com.byazt.ws.l(String.valueOf(jOptLong), dDoubleValue, 0, 0));
                    }
                    n.put(next, copyOnWriteArrayList);
                }
            }
        } catch (Throwable unused2) {
        }
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.yc.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ri.n.s().n("mediation_csj_map", jSONObject.toString());
            }
        });
    }

    public static void n() {
        if (qg.size() == 0) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : qg.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.yc.q.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ri.n.s().n("mediation_adn_map", jSONObject.toString());
            }
        });
    }

    public static boolean n(String str, String str2) {
        List<com.byazt.ws.l> list;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (list = n.get(str)) == null || list.size() == 0) {
            return true;
        }
        wm.n(list);
        return str2.equals(list.get(0).n());
    }

    private static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (n.size() == 0) {
            qg();
        }
        for (String str2 : n.keySet()) {
            List<com.byazt.ws.l> list = n.get(str2);
            if (list != null) {
                Iterator<com.byazt.ws.l> it = list.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().n())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    private static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (qg.size() == 0) {
            s();
        }
        return qg.get(str);
    }

    private static void qg() {
        String string = com.byazt.ri.n.s().getString("mediation_csj_map", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    if (jSONArray.length() > 0) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            String strOptString = jSONObjectOptJSONObject.optString("csj_code_id");
                            if (TextUtils.isEmpty(strOptString)) {
                                strOptString = jSONObjectOptJSONObject.optString("csj_rit_id");
                            }
                            double dOptDouble = jSONObjectOptJSONObject.optDouble(e.a.h);
                            if (dOptDouble <= 0.0d) {
                                dOptDouble = jSONObjectOptJSONObject.optDouble("ecpm");
                            }
                            copyOnWriteArrayList.add(new com.byazt.ws.l(strOptString, dOptDouble, jSONObjectOptJSONObject.optInt("load_sort"), jSONObjectOptJSONObject.optInt("show_sort")));
                        }
                        n.put(next, copyOnWriteArrayList);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void s() {
        String string = com.byazt.ri.n.s().getString("mediation_adn_map", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string2 = jSONObject.getString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                        qg.put(next, string2);
                    }
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
