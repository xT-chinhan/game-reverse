package com.anythink.core.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.u;
import com.anythink.core.common.h.z;
import com.anythink.core.common.k;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.p;
import com.anythink.core.d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    String a;
    List<bv> b;
    List<bv> c;
    boolean d;
    boolean e;

    public c(com.anythink.core.common.h.a aVar, List<bv> list) {
        super(aVar);
        this.a = p.a(aVar.b, this.o, this.p, aVar.f, 0).toString();
        this.b = aVar.y != null ? aVar.y.a() : null;
        this.c = list != null ? new ArrayList(list) : null;
    }

    @Override // com.anythink.core.b.e
    protected final synchronized void a(List<JSONObject> list, Map<String, bv> map, Map<String, JSONObject> map2) {
        super.a(list, map, map2);
        v.a(this.f.b).a(this.f.e);
        this.d = false;
        this.e = false;
        try {
            Iterator<Map.Entry<String, bv>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    bv value = it.next().getValue();
                    if (value.g() == 66) {
                        this.d = true;
                    } else if (value.g() == 6) {
                        this.e = true;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, q qVar) {
        String string;
        boolean zB;
        String strA;
        Boolean boolC;
        String str;
        long j;
        long j2;
        com.anythink.core.b.a.b bVar;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        b(jSONArray2);
        a(jSONArray);
        com.anythink.core.b.a.b bVar2 = new com.anythink.core.b.a.b();
        bVar2.a = this.a;
        bVar2.b = jSONArray2.toString();
        bVar2.f = this.f.n.a().aL();
        String string2 = jSONArray.length() > 0 ? jSONArray.toString() : "";
        if (this.f.v != null) {
            string = this.f.v.a().toString();
            bVar2.d = string;
        } else {
            string = "";
        }
        bVar2.e = string2;
        bVar2.g = this.f.n.a().B();
        bVar2.h = f();
        bVar2.i = this.f.x != null ? this.f.x.h() : "";
        bVar2.j = this.f.B != null ? this.f.B : "";
        bVar2.k = this.f.s.ax();
        int iB = v.a(this.f.b).b(this.f.e);
        ATAdRequest aTAdRequestB = null;
        if (this.f.w != null) {
            boolC = this.f.w.c();
            strA = this.f.w.a();
            zB = this.f.w.b();
        } else {
            zB = true;
            strA = "";
            boolC = null;
        }
        n nVar = this.f.s;
        int i = this.f.c.c;
        int i2 = this.f.t;
        boolean z = this.d;
        boolean z2 = this.e;
        boolean zA = com.anythink.core.common.v.q.a(this.f.b);
        u uVar = new u(nVar.aK(), null);
        uVar.c = "1004684";
        uVar.a(nVar);
        uVar.d = nVar.aJ();
        uVar.e = nVar.aI();
        uVar.l = String.valueOf(i);
        uVar.p = String.valueOf(iB);
        uVar.q = String.valueOf(nVar.aK());
        uVar.r = zB ? "1" : "2";
        uVar.s = String.valueOf(i2);
        if (!TextUtils.isEmpty(string2)) {
            uVar.t = string2;
        }
        if (!TextUtils.isEmpty(string)) {
            uVar.u = string;
        }
        if (boolC == null) {
            str = "0";
        } else {
            str = boolC.booleanValue() ? "1" : "2";
        }
        uVar.v = str;
        uVar.w = strA;
        uVar.x = z ? "1" : "2";
        uVar.y = z2 ? "1" : "2";
        uVar.z = String.valueOf(i);
        uVar.A = zA ? "1" : "2";
        com.anythink.core.common.u.e.b(uVar);
        if (this.f == null || this.f.c == null) {
            j = 0;
            j2 = 0;
        } else {
            j = this.f.c.k;
            j2 = this.f.c.h;
        }
        if (j > 0) {
            bVar = bVar2;
            bVar.l = this.s - this.f.c.k;
            bVar.m = SystemClock.elapsedRealtime() - this.f.c.k;
        } else {
            bVar = bVar2;
        }
        bVar.n = this.i;
        bVar.q = j2;
        bVar.p = this.f.n.i();
        l lVarA = this.f.n.a();
        if (lVarA != null) {
            bVar.o = lVarA.ab();
        }
        bVar.r = com.anythink.core.d.n.a(this.f.b).j(this.p);
        bVar.s = (System.currentTimeMillis() - t.b().Y()) - bVar.m;
        if (this.f != null && this.f.c != null) {
            aTAdRequestB = this.f.c.b();
        }
        bVar.t = aTAdRequestB;
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.q, this.p, this.o, list, 0, lVarA);
        aVar.a(bVar);
        aVar.a(0, qVar);
    }

    private void a(String str, String str2) {
        String strA;
        boolean zB;
        Boolean boolC;
        String str3;
        int iB = v.a(this.f.b).b(this.f.e);
        if (this.f.w != null) {
            boolC = this.f.w.c();
            strA = this.f.w.a();
            zB = this.f.w.b();
        } else {
            strA = "";
            zB = true;
            boolC = null;
        }
        n nVar = this.f.s;
        int i = this.f.c.c;
        int i2 = this.f.t;
        boolean z = this.d;
        boolean z2 = this.e;
        boolean zA = com.anythink.core.common.v.q.a(this.f.b);
        u uVar = new u(nVar.aK(), null);
        uVar.c = "1004684";
        uVar.a(nVar);
        uVar.d = nVar.aJ();
        uVar.e = nVar.aI();
        uVar.l = String.valueOf(i);
        uVar.p = String.valueOf(iB);
        uVar.q = String.valueOf(nVar.aK());
        uVar.r = zB ? "1" : "2";
        uVar.s = String.valueOf(i2);
        if (!TextUtils.isEmpty(str2)) {
            uVar.t = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            uVar.u = str;
        }
        if (boolC == null) {
            str3 = "0";
        } else {
            str3 = boolC.booleanValue() ? "1" : "2";
        }
        uVar.v = str3;
        uVar.w = strA;
        uVar.x = z ? "1" : "2";
        uVar.y = z2 ? "1" : "2";
        uVar.z = String.valueOf(i);
        uVar.A = zA ? "1" : "2";
        com.anythink.core.common.u.e.b(uVar);
    }

    private String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh", this.f.s.U());
            com.anythink.core.common.j.a.a().a(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.f.l;
    }

    @Override // com.anythink.core.b.e, com.anythink.core.b.d
    protected final void a(bv bvVar, z zVar, long j) {
        super.a(bvVar, zVar, j);
    }

    private void a(JSONArray jSONArray) {
        List<bv> list = this.c;
        if (list != null) {
            Iterator<bv> it = list.iterator();
            while (it.hasNext()) {
                List<bz.a> listA = ak.a(this.p, it.next());
                if (listA != null && listA.size() > 0) {
                    Iterator<bz.a> it2 = listA.iterator();
                    while (it2.hasNext()) {
                        jSONArray.put(it2.next().a());
                    }
                }
            }
        }
        List<bv> list2 = this.b;
        if (list2 != null) {
            Iterator<bv> it3 = list2.iterator();
            while (it3.hasNext()) {
                List<bz.a> listA2 = ak.a(this.p, it3.next());
                if (listA2 != null && listA2.size() > 0) {
                    Iterator<bz.a> it4 = listA2.iterator();
                    while (it4.hasNext()) {
                        jSONArray.put(it4.next().a());
                    }
                }
            }
        }
    }

    private void b(JSONArray jSONArray) {
        List<bv> listA = this.f.y != null ? this.f.y.a() : null;
        if (listA != null) {
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                bv bvVar = listA.get(i);
                if (!bvVar.an()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ad_source_id", bvVar.z());
                        jSONObject.put("price", bvVar.D());
                        ad adVarR = bvVar.R();
                        if (adVarR != null) {
                            jSONObject.put("tp_bid_id", adVarR.g);
                        }
                        jSONObject.put(k.ap, bvVar.at());
                        jSONArray.put(jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }
}
