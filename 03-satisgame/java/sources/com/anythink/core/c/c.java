package com.anythink.core.c;

import android.os.SystemClock;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.z;
import com.anythink.core.common.k;
import com.anythink.core.common.l.s;
import com.anythink.core.common.u;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.o;
import com.anythink.core.e.l;
import com.anythink.core.e.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    String a;
    List<by> b;
    List<by> c;
    boolean d;
    boolean e;

    public c(com.anythink.core.common.h.a aVar, List<by> list) {
        super(aVar);
        this.a = o.a(aVar.b, this.p, this.q, aVar.f, 0).toString();
        this.b = aVar.y != null ? aVar.y.a() : null;
        this.c = list != null ? new ArrayList(list) : null;
    }

    @Override // com.anythink.core.c.e
    protected final synchronized void a(List<JSONObject> list, Map<String, by> map, Map<String, JSONObject> map2) {
        super.a(list, map, map2);
        u.a(this.f.b).a(this.f.e);
        this.d = false;
        this.e = false;
        try {
            Iterator<Map.Entry<String, by>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    by value = it.next().getValue();
                    if (value.n() == 66) {
                        this.d = true;
                    } else if (value.n() == 6) {
                        this.e = true;
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.anythink.core.c.e
    protected final void a(List<JSONObject> list, s sVar) {
        long j;
        long j2;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        b(jSONArray2);
        a(jSONArray);
        com.anythink.core.c.a.b bVar = new com.anythink.core.c.a.b();
        bVar.a = this.a;
        bVar.b = jSONArray2.toString();
        bVar.f = this.f.n.a().aK();
        String string = jSONArray.length() > 0 ? jSONArray.toString() : "";
        if (this.f.v != null) {
            bVar.d = this.f.v.a().toString();
        }
        bVar.e = string;
        bVar.g = this.f.n.a().C();
        bVar.h = g();
        bVar.i = this.f.x != null ? this.f.x.i() : "";
        bVar.j = this.f.B != null ? this.f.B : "";
        bVar.k = this.f.s.aF();
        if (this.f == null || this.f.c == null) {
            j = 0;
            j2 = 0;
        } else {
            j = this.f.c.k;
            j2 = this.f.c.h;
        }
        if (j > 0) {
            bVar.l = this.t - this.f.c.k;
            bVar.m = SystemClock.elapsedRealtime() - this.f.c.k;
        }
        bVar.n = this.j;
        bVar.q = j2;
        bVar.p = this.f.n.i();
        l lVarA = this.f.n.a();
        if (lVarA != null) {
            bVar.o = lVarA.aa();
        }
        bVar.r = n.a(this.f.b).k(this.q);
        bVar.s = (System.currentTimeMillis() - com.anythink.core.common.d.s.b().Y()) - bVar.m;
        bVar.t = (this.f == null || this.f.c == null) ? null : this.f.c.b();
        com.anythink.core.c.a.c cVar = new com.anythink.core.c.a.c(this.r, this.q, this.p, list, 0, lVarA);
        cVar.a(bVar);
        cVar.a(sVar);
    }

    private String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh", this.f.s.V());
            com.anythink.core.common.i.a.a().a(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.c.e
    protected final String b() {
        return this.f.l;
    }

    @Override // com.anythink.core.c.e, com.anythink.core.c.d
    protected final void a(by byVar, z zVar, long j) {
        super.a(byVar, zVar, j);
    }

    private void a(JSONArray jSONArray) {
        List<by> list = this.c;
        if (list != null) {
            Iterator<by> it = list.iterator();
            while (it.hasNext()) {
                List<cc.a> listA = aj.a(this.q, it.next(), this.f);
                if (listA != null && listA.size() > 0) {
                    Iterator<cc.a> it2 = listA.iterator();
                    while (it2.hasNext()) {
                        jSONArray.put(it2.next().a());
                    }
                }
            }
        }
        List<by> list2 = this.b;
        if (list2 != null) {
            Iterator<by> it3 = list2.iterator();
            while (it3.hasNext()) {
                List<cc.a> listA2 = aj.a(this.q, it3.next(), this.f);
                if (listA2 != null && listA2.size() > 0) {
                    Iterator<cc.a> it4 = listA2.iterator();
                    while (it4.hasNext()) {
                        jSONArray.put(it4.next().a());
                    }
                }
            }
        }
    }

    private void b(JSONArray jSONArray) {
        List<by> listA = this.f.y != null ? this.f.y.a() : null;
        if (listA != null) {
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                by byVar = listA.get(i);
                if (!byVar.av()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ad_source_id", byVar.G());
                        jSONObject.put(com.anythink.core.d.b.e.a.h, byVar.K());
                        ad adVarY = byVar.Y();
                        if (adVarY != null) {
                            jSONObject.put("tp_bid_id", adVarY.g);
                        }
                        jSONObject.put(k.aq, byVar.aB());
                        jSONArray.put(jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }
}
