package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.u.e;
import com.anythink.core.common.v.af;
import com.anythink.core.d.l;
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
    private Map<String, LinkedList<C0076a>> d = new HashMap();

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

    /* JADX WARN: Code duplicated, block: B:30:0x0081  */
    public final void a(n nVar, bv bvVar) {
        l lVarB;
        double d;
        double d2;
        double d3;
        double dL;
        if (nVar == null || bvVar == null || (lVarB = com.anythink.core.d.n.a(t.b().g()).b(nVar.aI())) == null || bvVar.az() != 1) {
            return;
        }
        try {
            Map<String, Object> mapH = nVar.h();
            if (mapH != null) {
                mapH.toString();
            }
            if (mapH == null) {
                d = -1.0d;
            } else {
                if (bvVar.g() == 2 && mapH.containsKey("value_micros")) {
                    d2 = Double.parseDouble(mapH.get("value_micros").toString());
                    d3 = 1000.0d;
                } else if (mapH.containsKey(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_ECPM)) {
                    d2 = Double.parseDouble(mapH.get(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_ECPM).toString());
                    d3 = 100.0d;
                    if (j.C0079j.b.equalsIgnoreCase(bvVar.au())) {
                        dL = (d2 / 100.0d) * lVarB.L();
                    }
                    d = dL;
                } else {
                    d = -1.0d;
                }
                dL = d2 / d3;
                d = dL;
            }
            if (d == -1.0d) {
                try {
                    e.a(nVar, lVarB, new StringBuilder().append(bvVar.g()).toString(), bvVar.z(), new StringBuilder().append(bvVar.at()).toString(), a(bvVar.z(), lVarB.t()) > 0.0d ? 2 : 1);
                } catch (Throwable unused) {
                    return;
                }
            }
            nVar.d(d);
            if (d > 0.0d) {
                bvVar.f(d);
                a(bvVar.z(), nVar.aJ(), d, lVarB.t());
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(n nVar, List<bv> list, l lVar) {
        ListIterator<bv> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            bv next = listIterator.next();
            if (next.az() == 1) {
                int iT = lVar.t();
                double dA = a(next.z(), iT);
                next.z();
                if (dA > 0.0d) {
                    next.aB();
                    next.b(dA);
                    next.e(dA);
                    next.c(nVar.u() * dA);
                    next.i("estimated");
                    e.a(nVar, lVar, new StringBuilder().append(next.g()).toString(), next.z(), String.valueOf(dA), String.valueOf(iT), c(next.z()));
                }
            }
        }
    }

    private synchronized void a(String str, String str2, double d, int i) {
        LinkedList<C0076a> linkedListA = a(str);
        if (linkedListA != null) {
            linkedListA.toString();
        }
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
                linkedListA.addFirst(new C0076a(str2, d));
            }
        }
        linkedListA.toString();
        com.anythink.core.common.v.b.b.a().a(new AnonymousClass1(str, linkedListA));
    }

    private double a(String str, int i) {
        LinkedList<C0076a> linkedListA = a(str);
        if (linkedListA != null) {
            linkedListA.toString();
        }
        if (linkedListA == null || linkedListA.size() == 0 || i == 0) {
            return -1.0d;
        }
        List<C0076a> listSubList = linkedListA.subList(0, Math.min(i, linkedListA.size()));
        Iterator<C0076a> it = listSubList.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += it.next().b;
        }
        return d / ((double) listSubList.size());
    }

    private synchronized LinkedList<C0076a> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LinkedList<C0076a> linkedListB = this.d.get(str);
        if (linkedListB == null) {
            linkedListB = b(str);
            if (linkedListB == null) {
                linkedListB = new LinkedList<>();
            }
            this.d.put(str, linkedListB);
        }
        return linkedListB;
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a$1, reason: invalid class name */
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
                for (C0076a c0076a : this.b) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sv_request_id", c0076a.a);
                    jSONObject.put("sv_price", c0076a.b);
                    jSONArray.put(jSONObject);
                }
                string = jSONArray.toString();
            } catch (Throwable unused) {
                string = "";
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            af.b(t.b().g(), u.b.m, this.a, string);
        }
    }

    private void a(String str, LinkedList<C0076a> linkedList) {
        com.anythink.core.common.v.b.b.a().a(new AnonymousClass1(str, linkedList));
    }

    private LinkedList<C0076a> b(String str) {
        try {
            String strC = af.c(t.b().g(), u.b.m, str, "");
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            LinkedList<C0076a> linkedList = new LinkedList<>();
            try {
                JSONArray jSONArray = new JSONArray(strC);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        linkedList.add(new C0076a(jSONObjectOptJSONObject.optString("sv_request_id"), jSONObjectOptJSONObject.optDouble("sv_price", 0.0d)));
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
        LinkedList<C0076a> linkedListA = a(str);
        if (linkedListA.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (C0076a c0076a : linkedListA) {
                    jSONObject.put(c0076a.a, c0076a.b);
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: com.anythink.core.c.a$a, reason: collision with other inner class name */
    private class C0076a {
        public String a;
        public double b;

        public C0076a(String str, double d) {
            this.a = str;
            this.b = d;
        }

        public final String toString() {
            return "ProverbPriceBean{requestId='" + this.a + "', impPrice=" + this.b + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
