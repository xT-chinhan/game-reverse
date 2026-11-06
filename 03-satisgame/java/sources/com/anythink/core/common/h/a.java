package com.anythink.core.common.h;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "a";
    public ATAdxBidFloorInfo A;
    public String B;
    public double C;
    public int D;
    public com.anythink.core.common.h F;
    public com.anythink.core.common.b.c I;
    public com.anythink.core.common.f J;
    public com.anythink.core.e.f K;
    public Context b;
    public as c;
    public String d;
    public String e;
    public int f;
    public long g;
    public long h;
    public long i;
    public List<by> j;
    public List<by> k;
    public String l;
    public boolean m;
    public ce n;
    public String o;
    public String p;
    public Map<String, Object> q;
    public com.anythink.core.c.c.a r;
    public n s;
    public Map<String, Double> u;
    public cc v;
    public bs w;
    public ac x;
    public com.anythink.core.common.v.i y;
    public int t = 2;
    public int z = 0;
    public int E = 2;
    public boolean G = false;
    public long H = -1;

    private com.anythink.core.common.f a() {
        return this.J;
    }

    private boolean b() {
        return this.G;
    }

    private long c() {
        return this.H;
    }

    private String d() {
        return this.e;
    }

    private a c(List<by> list) {
        a aVar = new a();
        aVar.b = this.b;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.h = this.h;
        aVar.n = this.n;
        long j = this.g;
        if (j < 0) {
            aVar.g = 10000L;
        } else {
            aVar.g = j;
        }
        aVar.m = this.m;
        aVar.o = this.o;
        aVar.p = this.p;
        aVar.j = list;
        aVar.q = this.q;
        aVar.i = this.i;
        aVar.c = this.c;
        aVar.s = this.s;
        aVar.t = this.t;
        aVar.u = this.u;
        aVar.z = this.z;
        aVar.y = this.y;
        aVar.x = this.x;
        aVar.A = this.A;
        aVar.B = this.B;
        aVar.C = this.C;
        aVar.D = this.D;
        aVar.E = this.E;
        aVar.I = this.I;
        aVar.H = this.H;
        aVar.J = this.J;
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d7  */
    public final a a(List<by> list, List<by> list2) {
        JSONObject innerBidToken;
        a aVarC = c(list);
        aVarC.l = this.l;
        if (list2 != null && list2.size() > 0) {
            Collections.sort(list2);
            List<by> listA = com.anythink.core.common.u.o.a(list2, (com.anythink.core.common.j.f) null);
            byte b = 0;
            by byVar = listA.get(0);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (by byVar2 : listA) {
                if (byVar2.y() == 7) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(byVar2.G())));
                    arrayList2.add(byVar2.G());
                    linkedHashMap.put(byVar2.G(), byVar2.e);
                }
            }
            p pVarA = com.anythink.core.common.u.t.a(byVar);
            ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
            if (aTBaseAdAdapter == null) {
                if (pVarA != null) {
                    pVarA.b(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE);
                }
                innerBidToken = null;
            } else {
                as asVar = this.c;
                innerBidToken = aTBaseAdAdapter.getInnerBidToken(com.anythink.core.common.d.s.b().g(), this.n.a().a(this.e, this.d, byVar, asVar != null ? asVar.b() : null), linkedHashMap);
            }
            if (innerBidToken != null) {
                String strValueOf = String.valueOf(aVarC.f);
                this.n.a();
                com.anythink.core.c.d.b.a(innerBidToken, strValueOf, byVar, aVarC);
                try {
                    String strValueOf2 = String.valueOf(aVarC.f);
                    int iHashCode = strValueOf2.hashCode();
                    if (iHashCode != 50) {
                        if (iHashCode == 52 && strValueOf2.equals("4")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (!strValueOf2.equals("2")) {
                        b = -1;
                    }
                    if (b == 0) {
                        as asVar2 = aVarC.c;
                        String string = aVarC.n.a().a(aVarC.e, aVarC.d, byVar, asVar2 != null ? asVar2.b() : null).get("size").toString();
                        if (!TextUtils.isEmpty(string)) {
                            innerBidToken.put("size", string);
                        }
                    } else if (b == 1) {
                        innerBidToken.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                    }
                    if (aVarC.z == listA.size()) {
                        innerBidToken.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
                    }
                    innerBidToken.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.DIRECTLY_AD_SOURCEIDS, new JSONArray(arrayList.toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aVarC.k = listA;
                aVarC.r = new com.anythink.core.c.c.a(byVar, innerBidToken);
            }
        }
        aVarC.v = this.v;
        aVarC.w = this.w;
        return aVarC;
    }

    public final a a(List<by> list) {
        return c(list);
    }

    private a d(List<by> list) {
        a aVarC = c(list);
        aVarC.o = this.o;
        aVarC.h = this.h;
        return aVarC;
    }

    public final a b(List<by> list) {
        a aVarC = c(list);
        aVarC.p = this.p;
        return aVarC;
    }
}
