package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.z;
import com.anythink.core.common.v.ae;
import com.anythink.core.common.v.p;
import com.anythink.core.d.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    protected com.anythink.core.common.h.a f;
    protected boolean g;
    protected long i;
    private final String a = getClass().getSimpleName() + ":";
    protected AtomicBoolean h = new AtomicBoolean(false);

    protected abstract void a();

    protected abstract void a(com.anythink.core.b.b.b bVar);

    protected abstract void a(bv bvVar, z zVar, long j);

    public d(com.anythink.core.common.h.a aVar) {
        this.f = aVar;
    }

    protected void a(boolean z) {
        this.g = z;
    }

    public final boolean c() {
        return this.h.get();
    }

    protected static JSONArray a(List<bv> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (bv bvVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("network_firm_id", bvVar.g());
                jSONObject.put("ad_source_id", bvVar.z());
                jSONObject.put("content", bvVar.k());
                if (!TextUtils.isEmpty(bvVar.F())) {
                    jSONObject.put("error", bvVar.F());
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected static JSONArray b(List<JSONObject> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (JSONObject jSONObject : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("network_firm_id", 67);
                if (jSONObject.has(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS)) {
                    jSONObject2.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS, jSONObject.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS));
                }
                jSONArray.put(jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected static void a(bv bvVar, String str, long j, int i) {
        bvVar.c(j);
        bvVar.b(0.0d);
        bvVar.e(0.0d);
        bvVar.g(i);
        bvVar.f();
        if (TextUtils.isEmpty(str)) {
            bvVar.h("bid error");
        } else {
            bvVar.h(str);
        }
    }

    protected static boolean a(boolean z, bv bvVar, z zVar) {
        double dAr = bvVar.ar();
        if (!z || dAr <= 0.0d) {
            return false;
        }
        Object[] objArr = new Object[2];
        Double.valueOf(dAr);
        Double.valueOf(zVar.getPrice());
        return zVar.getPrice() < dAr;
    }

    protected final void a(ad adVar, bv bvVar) {
        com.anythink.core.b.d.c.a(adVar, new aw(6, bvVar, this.f.s, bvVar.ar()), true, 23);
    }

    protected final void b(ad adVar, bv bvVar) {
        com.anythink.core.b.d.c.a(adVar, new aw(9, bvVar, this.f.s, adVar.getSortPrice()), true, 33);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0081  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    protected final void a(bv bvVar, ad adVar) {
        double sortPrice;
        boolean z;
        double d;
        String str;
        double sortPrice2;
        if (adVar == null) {
            return;
        }
        adVar.b(this.f.d);
        adVar.setOriginRequestId(this.f.d);
        ad adVarA = f.a().a(this.f.e, bvVar);
        if (adVarA != null) {
            boolean zA = adVarA.a();
            if (zA || adVar.getSortPrice() > adVarA.getSortPrice()) {
                sortPrice = adVar.getSortPrice();
                if (zA) {
                    com.anythink.core.b.d.c.a(adVarA, new aw(1, bvVar, this.f.s, sortPrice), true, 25);
                } else {
                    z = true;
                    sortPrice2 = sortPrice;
                }
            } else {
                sortPrice2 = adVarA.getSortPrice();
                z = false;
            }
            d = sortPrice2;
            if (z) {
                if (adVarA != null) {
                    try {
                        com.anythink.core.b.d.c.a(adVarA, new aw(2, bvVar, this.f.s, d), true, 26);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                bvVar.a(adVar, 2, 0, 1);
                if (bvVar.P() != 2) {
                    f fVarA = f.a();
                    str = this.f.e;
                    fVarA.a.put(str + adVar.k, adVar);
                    if (bvVar.am()) {
                        com.anythink.core.common.a.a.a().a(str, adVar);
                        return;
                    }
                    return;
                }
                return;
            }
            if (adVar != null) {
                try {
                    com.anythink.core.b.d.c.a(adVar, new aw(2, bvVar, this.f.s, d), false, 27);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            bvVar.a(adVarA, 1, 0, 1);
        }
        sortPrice = adVar.getSortPrice();
        z = true;
        d = sortPrice;
        if (z) {
            if (adVarA != null) {
                com.anythink.core.b.d.c.a(adVarA, new aw(2, bvVar, this.f.s, d), true, 26);
            }
            bvVar.a(adVar, 2, 0, 1);
            if (bvVar.P() != 2) {
                f fVarA2 = f.a();
                str = this.f.e;
                fVarA2.a.put(str + adVar.k, adVar);
                if (bvVar.am()) {
                    com.anythink.core.common.a.a.a().a(str, adVar);
                    return;
                }
                return;
            }
            return;
        }
        if (adVar != null) {
            com.anythink.core.b.d.c.a(adVar, new aw(2, bvVar, this.f.s, d), false, 27);
        }
        bvVar.a(adVarA, 1, 0, 1);
    }

    protected final boolean a(bv bvVar, String str, int i) {
        return a(bvVar, str, i, 0);
    }

    protected final boolean a(bv bvVar, String str, int i, int i2) {
        if (ae.a(0, this.f.s, bvVar, (z) null) != null) {
            return false;
        }
        ad adVarA = f.a().a(this.f.e, bvVar);
        if (adVarA != null && !adVarA.a()) {
            bvVar.a(adVarA, 0, i, i2);
            bvVar.h(str);
            return true;
        }
        if (adVarA != null) {
            try {
                n nVarAf = this.f.s.af();
                nVarAf.J(adVarA.c());
                nVarAf.D(adVarA.x());
                nVarAf.L(adVarA.getOriginRequestId());
                com.anythink.core.b.d.c.a(adVarA, new aw(1, bvVar, nVarAf), true, 25);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    protected final void a(int i, z zVar, double d, boolean z) {
        double dOptDouble;
        if (i != 28) {
            return;
        }
        JSONObject jSONObjectC = this.f.n.a().C();
        if (jSONObjectC != null) {
            dOptDouble = jSONObjectC.optDouble(String.valueOf(i));
            if (dOptDouble <= 0.0d || dOptDouble > 1.0d) {
                dOptDouble = 0.95d;
            }
        } else {
            dOptDouble = 0.95d;
        }
        double dMax = zVar.originPrice * dOptDouble;
        List<bv> listA = this.f.y != null ? this.f.y.a() : null;
        if (listA != null) {
            Iterator<bv> it = listA.iterator();
            while (it.hasNext()) {
                double dA = p.a(it.next());
                if (dA < zVar.originPrice) {
                    dMax = Math.max(dMax, dA);
                    break;
                }
            }
        }
        double dMax2 = Math.max(dMax, d);
        double dRandom = dMax2 + (Math.random() * (zVar.originPrice - dMax2));
        zVar.setPrice(dRandom);
        if (z) {
            zVar.setSortPrice(dRandom);
        }
    }

    protected final double a(bv bvVar) {
        if (bvVar.ap() == null) {
            return 1.0d;
        }
        double dA = a(this.f.n.a(), bvVar.ap());
        bvVar.h();
        return dA;
    }

    private double a(double d, ATAdConst.CURRENCY currency) {
        if (currency == null) {
            return d;
        }
        double dA = a(this.f.n.a(), currency);
        Object[] objArr = new Object[3];
        String.valueOf(d);
        String.valueOf(dA);
        double d2 = d * dA;
        String.valueOf(d2);
        return d2;
    }

    private static double a(l lVar, ATAdConst.CURRENCY currency) {
        if (lVar == null) {
            return 1.0d;
        }
        if (currency == ATAdConst.CURRENCY.RMB_CENT) {
            return (1.0d / lVar.L()) * 100.0d;
        }
        if (currency == ATAdConst.CURRENCY.RMB) {
            return 1.0d / lVar.L();
        }
        return 1.0d;
    }

    protected final double a(double d, bv bvVar) {
        double dL;
        if (bvVar.ap() == null) {
            return d;
        }
        l lVarA = this.f.n.a();
        if (bvVar.ap() == ATAdConst.CURRENCY.RMB) {
            dL = lVarA.L();
        } else {
            if (bvVar.ap() != ATAdConst.CURRENCY.RMB_CENT) {
                return d;
            }
            d /= 100.0d;
            dL = lVarA.L();
        }
        return d * dL;
    }

    public final void a(long j) {
        this.i = j;
    }
}
