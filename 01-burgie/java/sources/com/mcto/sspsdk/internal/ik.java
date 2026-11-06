package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import android.util.Pair;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiSlot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ik {
    public static volatile ik e;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final byte[] c = new byte[0];
    public String d;

    public ik() {
        int iIndexOf;
        String strA = nh.a(jd.a).a("ladnc");
        if (strA == null || strA.length() < 3 || (iIndexOf = strA.indexOf("||")) < 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(gj.e(strA.substring(iIndexOf + 2)));
            this.d = strA.substring(0, iIndexOf);
            a(jSONObject);
        } catch (Exception e2) {
            r9.a("ssp_sdk", "UnionConfig(): ", e2);
        }
    }

    public static ik a() {
        if (e == null) {
            synchronized (ik.class) {
                if (e == null) {
                    e = new ik();
                }
            }
        }
        return e;
    }

    public static HashMap b(ArrayList arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            g0 g0Var = (g0) it.next();
            String token = QiClientFactory.getToken(jd.a, g0Var.c, new QiSlot.Builder().adType(g0Var.b).codeId(g0Var.d).count(1).build());
            if (TextUtils.isEmpty(token)) {
                r9.a("ssp_sdk", "getToken(): token is null.", null);
            } else {
                StringBuilder sb = (StringBuilder) map.get(Integer.valueOf(g0Var.c));
                if (sb == null) {
                    sb = new StringBuilder();
                } else {
                    sb.append(";");
                }
                sb.append(g0Var.d).append(":").append(gj.f(token));
                map.put(Integer.valueOf(g0Var.c), sb);
            }
        }
        return map;
    }

    public final int a(String str, String str2) {
        synchronized (this.c) {
            List list = (List) this.b.get(str);
            if (list == null) {
                return 2;
            }
            for (int i = 0; i < list.size(); i++) {
                g0 g0Var = (g0) list.get(i);
                if (TextUtils.equals(g0Var.d, str2)) {
                    return g0Var.b;
                }
            }
            return 2;
        }
    }

    public final Pair a(ArrayList arrayList) {
        if (this.a.get() && !arrayList.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                Iterator it = arrayList.iterator();
                boolean z = false;
                boolean z2 = true;
                while (it.hasNext()) {
                    e0 e0Var = (e0) it.next();
                    ArrayList arrayListA = a(e0Var);
                    if (!z) {
                        Iterator it2 = arrayListA.iterator();
                        while (it2.hasNext()) {
                            if (((g0) it2.next()).c == 8) {
                                z = true;
                                break;
                            }
                        }
                    }
                    HashMap mapB = b(arrayListA);
                    if (mapB != null && !mapB.isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Integer num : mapB.keySet()) {
                            jSONObject2.putOpt("" + num, mapB.get(num));
                            z2 = false;
                        }
                        jSONObject.put(e0Var.a, jSONObject2);
                    }
                }
                if (z) {
                    jSONObject.put("ylh", QiClientFactory.getGDTBuyerId());
                }
                return z2 ? new Pair("token_is_nil", null) : new Pair("has_token", jSONObject);
            } catch (Throwable th) {
                return new Pair("token_error", null);
            }
        }
        return new Pair("not_open", null);
    }

    public final void a(JSONObject jSONObject) {
        try {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String strValueOf = String.valueOf(itKeys.next());
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(strValueOf);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                    int length = jSONArrayOptJSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(new g0(jSONArrayOptJSONArray.optJSONObject(i)));
                    }
                    concurrentHashMap.put(strValueOf, arrayList);
                }
            }
            synchronized (this.c) {
                this.b.clear();
                this.b.putAll(concurrentHashMap);
            }
            this.a.set(true);
        } catch (Exception e2) {
            r9.a("ssp_sdk", "parseConfig(): ", e2);
        }
    }

    public final ArrayList a(e0 e0Var) {
        int i = e0Var.b;
        int i2 = i != 1 ? i == 2 ? 3 : 1 : 2;
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            List list = (List) this.b.get(e0Var.a);
            if (list != null && !list.isEmpty()) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    g0 g0Var = (g0) list.get(i3);
                    if ((g0Var.a & i2) != 0) {
                        HashMap map = e0Var.c;
                        if (map == null) {
                            arrayList.add(g0Var);
                        } else {
                            String str = (String) map.get("" + g0Var.c);
                            if (TextUtils.isEmpty(str) || TextUtils.equals(str, g0Var.e)) {
                                arrayList.add(g0Var);
                            }
                        }
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
    }
}
