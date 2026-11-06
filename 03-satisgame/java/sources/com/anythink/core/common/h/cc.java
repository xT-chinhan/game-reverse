package com.anythink.core.common.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class cc {
    static final String e = "reqId";
    static final String f = "reqDatetime";
    static final String g = "fillOffers";
    static final String h = "bidResps";
    static final String i = "adSourceId";
    static final String j = "price";
    static final String k = "networkFirmId";
    static final String l = "demandType";
    static final String m = "tp_bid_id";
    static final String n = "deal_type";
    static final String o = "deal_id";
    static final String p = "deal_pri";
    String a;
    long b;
    List<a> c = new ArrayList(3);
    List<a> d = new ArrayList(3);

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(e, this.a);
            jSONObject.put(f, this.b);
            jSONObject.put(g, d());
            jSONObject.put(h, e());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private static cc b(String str) {
        cc ccVar = new cc();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ccVar.a(jSONObject.getString(e));
            ccVar.a(jSONObject.getLong(f));
            ccVar.a(ccVar.c(jSONObject.getString(g)));
            ccVar.b(ccVar.c(jSONObject.getString(h)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return ccVar;
    }

    public final synchronized void a(String str) {
        this.a = str;
    }

    public final synchronized void a(long j2) {
        this.b = j2;
    }

    private synchronized void a(List<a> list) {
        this.c = list;
    }

    private synchronized void b(List<a> list) {
        this.d = list;
    }

    public final synchronized String b() {
        return this.a;
    }

    private synchronized long c() {
        return this.b;
    }

    public final synchronized void a(a aVar) {
        a(this.c, aVar);
    }

    public final synchronized void b(a aVar) {
        a(this.d, aVar);
    }

    private synchronized void a(List<a> list, a aVar) {
        if (aVar != null) {
            if (list.size() == 0) {
                list.add(aVar);
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    i2 = -1;
                    break;
                } else if (com.anythink.core.common.u.k.a(aVar, list.get(i2)) < 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                list.add(i2, aVar);
                return;
            }
            list.add(aVar);
        }
    }

    private synchronized List<a> c(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    a aVar = new a();
                    JSONObject jSONObject = new JSONObject(jSONArray.optString(i2));
                    aVar.b = jSONObject.getString(i);
                    aVar.d = jSONObject.getDouble("price");
                    aVar.c = jSONObject.getInt(k);
                    aVar.a = jSONObject.getInt(l);
                    if (jSONObject.has(m)) {
                        aVar.e = jSONObject.getString(m);
                    }
                    aVar.g = jSONObject.optString(n);
                    aVar.h = jSONObject.optString(o);
                    aVar.i = jSONObject.optInt(p);
                    arrayList.add(aVar);
                }
                Collections.sort(arrayList, new Comparator<a>() { // from class: com.anythink.core.common.h.cc.1
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(a aVar2, a aVar3) {
                        return com.anythink.core.common.u.k.a(aVar2, aVar3);
                    }

                    private static int a(a aVar2, a aVar3) {
                        return com.anythink.core.common.u.k.a(aVar2, aVar3);
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private synchronized JSONArray d() {
        return c(this.c);
    }

    private synchronized JSONArray e() {
        return c(this.d);
    }

    private synchronized JSONArray c(List<a> list) {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        if (list != null) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(it.next().a());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return jSONArray;
    }

    public static class a {
        public int a;
        public String b;
        public int c;
        public double d;
        public String e;
        public int f;
        public String g;
        public String h;
        public int i;
        public ad j;

        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:21:0x003e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0041  */
        public a(by byVar, ad adVar) {
            this.b = byVar.G();
            if (adVar != null) {
                this.d = adVar.getPrice();
            } else {
                this.d = byVar.K();
            }
            this.c = byVar.n();
            int iY = byVar.y();
            if (iY == 0) {
                this.a = 1;
            } else if (iY == 1) {
                this.a = 2;
            } else if (iY == 2) {
                this.a = 3;
            } else if (iY == 3) {
                this.a = 4;
            } else if (iY == 4 || iY == 7) {
                this.a = 2;
            } else if (iY == 8) {
                this.a = 1;
            }
            if (35 == byVar.n()) {
                this.a = 2;
            }
            this.e = adVar != null ? adVar.g : "";
            this.j = adVar;
            this.g = adVar != null ? adVar.t() : "";
            this.f = adVar != null ? adVar.s() : 0;
            this.h = adVar != null ? adVar.u() : "";
            this.i = adVar != null ? adVar.v() : 0;
        }

        public final synchronized JSONObject a() {
            JSONObject jSONObject;
            jSONObject = new JSONObject();
            try {
                jSONObject.put(cc.i, this.b);
                jSONObject.put("price", this.d);
                jSONObject.put(cc.k, this.c);
                jSONObject.put(cc.l, this.a);
                jSONObject.put(cc.m, this.e);
                if (!TextUtils.isEmpty(this.g)) {
                    jSONObject.put(cc.n, this.g);
                    jSONObject.put(cc.p, this.i);
                }
                if (!TextUtils.isEmpty(this.h)) {
                    jSONObject.put(cc.o, this.h);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }
}
