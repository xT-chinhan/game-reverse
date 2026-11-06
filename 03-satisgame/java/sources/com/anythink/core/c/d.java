package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.z;
import com.anythink.core.common.k;
import com.anythink.core.common.u.ac;
import com.anythink.core.common.u.o;
import com.anythink.core.e.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    protected com.anythink.core.common.h.a f;
    protected boolean g;
    protected long j;
    private final String a = getClass().getSimpleName() + ":";
    protected AtomicBoolean h = new AtomicBoolean(false);
    protected AtomicBoolean i = new AtomicBoolean(false);

    protected abstract void a();

    protected abstract void a(com.anythink.core.c.b.b bVar);

    protected abstract void a(by byVar, z zVar, long j);

    public d(com.anythink.core.common.h.a aVar) {
        this.f = aVar;
    }

    public final f c() {
        com.anythink.core.common.h.a aVar = this.f;
        if (aVar == null || aVar.J == null) {
            return null;
        }
        return this.f.J.f();
    }

    protected void a(boolean z) {
        this.g = z;
    }

    public final boolean d() {
        return this.h.get();
    }

    protected final JSONArray a(List<by> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.anythink.core.common.h.a aVar = this.f;
            int iAa = (aVar == null || aVar.s == null) ? -1 : this.f.s.aa();
            for (by byVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("network_firm_id", byVar.n());
                if (iAa != -1) {
                    jSONObject.put("segment_id", iAa);
                }
                jSONObject.put("ad_source_id", byVar.G());
                jSONObject.put(k.D, byVar.r());
                if (!TextUtils.isEmpty(byVar.M())) {
                    jSONObject.put("error", byVar.M());
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected static JSONArray b(List<com.anythink.core.c.c.a> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<com.anythink.core.c.c.a> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA = it.next().a();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("network_firm_id", 67);
                if (jSONObjectA.has(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS)) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS, jSONObjectA.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS));
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected static void a(by byVar, String str, long j, int i) {
        byVar.e(j);
        byVar.b(0.0d);
        byVar.e(0.0d);
        byVar.k(i);
        byVar.m();
        if (TextUtils.isEmpty(str)) {
            byVar.i("bid error");
        } else {
            byVar.i(str);
        }
    }

    protected static boolean a(boolean z, by byVar, z zVar) {
        double dAz = byVar.az();
        boolean z2 = false;
        if (z && dAz > 0.0d && zVar.getPrice() < dAz) {
            z2 = true;
        }
        if (z2) {
            byVar.ag(1);
        }
        return z2;
    }

    private void a(ad adVar, by byVar) {
        ay ayVar = new ay(6, byVar, this.f.s, adVar.getSortPrice());
        a(ayVar, byVar);
        com.anythink.core.c.d.c.a(adVar, ayVar, true, 23);
    }

    private static void a(ay ayVar, by byVar) {
        if (byVar != null) {
            int iBE = byVar.bE();
            if (iBE == 1) {
                ayVar.d(byVar.az());
            } else if (iBE == 2) {
                ayVar.b(byVar.bG());
                ayVar.d(byVar.bF());
            }
        }
    }

    private void b(ad adVar, by byVar) {
        ay ayVar = new ay(9, byVar, this.f.s, adVar.getSortPrice());
        a(ayVar, byVar);
        com.anythink.core.c.d.c.a(adVar, ayVar, true, 33);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    protected final void a(by byVar, ad adVar) {
        double sortPrice;
        boolean z;
        double d;
        f fVarC;
        double sortPrice2;
        if (adVar == null) {
            return;
        }
        adVar.b(this.f.d);
        adVar.setOriginRequestId(this.f.d);
        ad adVarA = c() != null ? c().a(this.f.e, byVar) : null;
        if (adVarA != null) {
            boolean zA = adVarA.a();
            if (zA || adVar.getSortPrice() > adVarA.getSortPrice()) {
                sortPrice = adVar.getSortPrice();
                if (zA) {
                    com.anythink.core.c.d.c.a(adVarA, new ay(1, byVar, this.f.s, sortPrice), true, 25);
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
                        com.anythink.core.c.d.c.a(adVarA, new ay(2, byVar, this.f.s, d), true, 26);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                byVar.a(adVar, 2, 0, 1);
                if (byVar.W() != 2 || (fVarC = c()) == null) {
                    return;
                }
                String str = this.f.e;
                fVarC.a.put(str + adVar.k, adVar);
                if (byVar.at()) {
                    com.anythink.core.common.a.a.a().a(str, adVar);
                    return;
                }
                return;
            }
            if (adVar != null) {
                try {
                    com.anythink.core.c.d.c.a(adVar, new ay(2, byVar, this.f.s, d), false, 27);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            byVar.a(adVarA, 1, 0, 1);
        }
        sortPrice = adVar.getSortPrice();
        z = true;
        d = sortPrice;
        if (z) {
            if (adVarA != null) {
                com.anythink.core.c.d.c.a(adVarA, new ay(2, byVar, this.f.s, d), true, 26);
            }
            byVar.a(adVar, 2, 0, 1);
            if (byVar.W() != 2) {
                return;
            } else {
                return;
            }
        }
        if (adVar != null) {
            com.anythink.core.c.d.c.a(adVar, new ay(2, byVar, this.f.s, d), false, 27);
        }
        byVar.a(adVarA, 1, 0, 1);
    }

    protected final boolean a(by byVar, String str, int i) {
        return a(byVar, str, i, 0);
    }

    protected final boolean a(by byVar, String str, int i, int i2) {
        ad adVarA = c() != null ? c().a(this.f.e, byVar) : null;
        if (adVarA != null && !adVarA.a()) {
            if (ac.a(0, this.f.s, byVar, adVarA) != null) {
                return false;
            }
            byVar.a(adVarA, 0, i, i2);
            byVar.i(str);
            return true;
        }
        if (adVarA != null) {
            try {
                n nVarAh = this.f.s.ah();
                nVarAh.J(adVarA.c());
                nVarAh.D(adVarA.w());
                nVarAh.L(adVarA.getOriginRequestId());
                com.anythink.core.c.d.c.a(adVarA, new ay(1, byVar, nVarAh), true, 25);
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
        JSONObject jSONObjectD = this.f.n.a().D();
        if (jSONObjectD != null) {
            dOptDouble = jSONObjectD.optDouble(String.valueOf(i));
            if (dOptDouble <= 0.0d || dOptDouble > 1.0d) {
                dOptDouble = 0.95d;
            }
        } else {
            dOptDouble = 0.95d;
        }
        double dMax = zVar.originPrice * dOptDouble;
        List<by> listA = this.f.y != null ? this.f.y.a() : null;
        if (listA != null) {
            Iterator<by> it = listA.iterator();
            while (it.hasNext()) {
                double dA = o.a(it.next());
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

    protected final double a(by byVar) {
        if (byVar.ax() == null) {
            return 1.0d;
        }
        return a(this.f.n.a(), byVar.ax());
    }

    private double a(double d, ATAdConst.CURRENCY currency) {
        return currency == null ? d : d * a(this.f.n.a(), currency);
    }

    private static double a(l lVar, ATAdConst.CURRENCY currency) {
        if (lVar == null) {
            return 1.0d;
        }
        if (currency == ATAdConst.CURRENCY.RMB_CENT) {
            return (1.0d / lVar.M()) * 100.0d;
        }
        if (currency == ATAdConst.CURRENCY.RMB) {
            return 1.0d / lVar.M();
        }
        return 1.0d;
    }

    protected final double a(double d, by byVar) {
        double dM;
        if (byVar.ax() == null) {
            return d;
        }
        l lVarA = this.f.n.a();
        if (byVar.ax() == ATAdConst.CURRENCY.RMB) {
            dM = lVarA.M();
        } else {
            if (byVar.ax() != ATAdConst.CURRENCY.RMB_CENT) {
                return d;
            }
            d /= 100.0d;
            dM = lVarA.M();
        }
        return d * dM;
    }

    public final void a(long j) {
        this.j = j;
    }
}
