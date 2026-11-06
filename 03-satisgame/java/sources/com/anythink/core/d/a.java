package com.anythink.core.d;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;
import com.anythink.core.e.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static volatile a e;
    final String a = getClass().getSimpleName();
    private final String b = "sv_request_id";
    private final String c = "sv_price";
    private Map<String, LinkedList<C0056a>> d = new HashMap();

    private a() {
    }

    public static a a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    public final void a(n nVar, by byVar) {
        l lVarB;
        double d;
        double d2;
        double d3;
        double dM;
        if (nVar == null || byVar == null || (lVarB = com.anythink.core.e.n.a(s.b().g()).b(nVar.aQ())) == null || byVar.aH() != 1) {
            return;
        }
        try {
            Map<String, Object> mapI = nVar.i();
            if (mapI == null) {
                d = -1.0d;
            } else {
                if (byVar.n() == 2 && mapI.containsKey("value_micros")) {
                    d2 = Double.parseDouble(mapI.get("value_micros").toString());
                    d3 = 1000.0d;
                } else if (mapI.containsKey("network_ecpm")) {
                    d2 = Double.parseDouble(mapI.get("network_ecpm").toString());
                    d3 = 100.0d;
                    if (i.k.b.equalsIgnoreCase(byVar.aC())) {
                        dM = (d2 / 100.0d) * lVarB.M();
                    }
                    d = dM;
                } else {
                    d = -1.0d;
                }
                dM = d2 / d3;
                d = dM;
            }
            if (d == -1.0d) {
                try {
                    f.a(nVar, lVarB, new StringBuilder().append(byVar.n()).toString(), byVar.G(), new StringBuilder().append(byVar.aB()).toString(), a(byVar.G(), lVarB.u()) > 0.0d ? 2 : 1);
                } catch (Throwable unused) {
                    return;
                }
            }
            nVar.d(d);
            if (d > 0.0d) {
                byVar.f(d);
                a(byVar.G(), nVar.aR(), d, lVarB.u());
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(n nVar, List<by> list, l lVar) {
        ListIterator<by> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            by next = listIterator.next();
            if (next.aH() == 1) {
                int iU = lVar.u();
                double dA = a(next.G(), iU);
                if (dA > 0.0d) {
                    next.aJ();
                    next.b(dA);
                    next.e(dA);
                    next.c(nVar.v() * dA);
                    next.j("estimated");
                    f.a(nVar, lVar, new StringBuilder().append(next.n()).toString(), next.G(), String.valueOf(dA), String.valueOf(iU), c(next.G()));
                }
            }
        }
    }

    private synchronized void a(String str, String str2, double d, int i) {
        LinkedList<C0056a> linkedListA = a(str);
        if (linkedListA == null) {
            return;
        }
        if (i == 0) {
            linkedListA.clear();
        } else {
            if (linkedListA.size() >= i - 1) {
                int size = (linkedListA.size() - i) + 1;
                for (int i2 = 0; i2 < size; i2++) {
                    linkedListA.removeLast();
                }
            }
            if (linkedListA.size() < i) {
                linkedListA.addFirst(new C0056a(str2, d));
            }
        }
        c.a().e(new d(e.cg, new AnonymousClass1(str, linkedListA)));
    }

    private double a(String str, int i) {
        LinkedList<C0056a> linkedListA = a(str);
        if (linkedListA == null || linkedListA.size() == 0 || i == 0) {
            return -1.0d;
        }
        List<C0056a> listSubList = linkedListA.subList(0, Math.min(i, linkedListA.size()));
        Iterator<C0056a> it = listSubList.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().b;
        }
        return d / ((double) listSubList.size());
    }

    private synchronized LinkedList<C0056a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList<C0056a> linkedListB = this.d.get(str);
        if (linkedListB == null) {
            linkedListB = b(str);
            if (linkedListB == null) {
                linkedListB = new LinkedList<>();
            }
            this.d.put(str, linkedListB);
        }
        return linkedListB;
    }

    /* JADX INFO: renamed from: com.anythink.core.d.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ LinkedList b;

        AnonymousClass1(String str, LinkedList linkedList) {
            this.a = str;
            this.b = linkedList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String string;
            if (TextUtils.isEmpty(this.a) || this.b == null) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                for (C0056a c0056a : this.b) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sv_request_id", c0056a.a);
                    jSONObject.put("sv_price", c0056a.b);
                    jSONArray.put(jSONObject);
                }
                string = jSONArray.toString();
            } catch (Throwable unused) {
                string = "";
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            ad.b(s.b().g(), t.b.j, this.a, string);
        }
    }

    private void a(String str, LinkedList<C0056a> linkedList) {
        c.a().e(new d(e.cg, new AnonymousClass1(str, linkedList)));
    }

    private LinkedList<C0056a> b(String str) {
        try {
            String strC = ad.c(s.b().g(), t.b.j, str, "");
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            LinkedList<C0056a> linkedList = new LinkedList<>();
            try {
                JSONArray jSONArray = new JSONArray(strC);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        linkedList.add(new C0056a(jSONObjectOptJSONObject.optString("sv_request_id"), jSONObjectOptJSONObject.optDouble("sv_price", 0.0d)));
                    }
                }
            } catch (Throwable unused) {
            }
            return linkedList;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private String c(String str) {
        LinkedList<C0056a> linkedListA = a(str);
        if (linkedListA.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (C0056a c0056a : linkedListA) {
                    jSONObject.put(c0056a.a, c0056a.b);
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: com.anythink.core.d.a$a, reason: collision with other inner class name */
    private class C0056a {
        public String a;
        public double b;

        public C0056a(String str, double d) {
            this.a = str;
            this.b = d;
        }

        public final String toString() {
            return "ProverbPriceBean{requestId='" + this.a + "', impPrice=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
