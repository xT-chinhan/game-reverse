package com.anythink.core.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.bw;
import com.anythink.core.common.h.p;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.v.ak;
import com.anythink.core.common.v.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c b;
    private final String a = getClass().getSimpleName();
    private Map<String, a> c = new ConcurrentHashMap();

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
    }

    public final a a(Context context, String str, String str2, bv bvVar, com.anythink.core.d.l lVar, Map<String, Object> map, ATAdRequest aTAdRequest) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
        if (!(bVarB == null || bVarB.R() || bVarB.t() == 1) || bvVar == null) {
            return null;
        }
        bw bwVarA = com.anythink.core.common.a.a().a(str, bvVar);
        if (bwVarA != null && bwVarA.a((ad) null).b() != null) {
            return null;
        }
        a aVar = this.c.get(str);
        if (aVar != null && aVar.c != null) {
            return aVar;
        }
        ad adVarA = com.anythink.core.b.f.a().a(str, bvVar);
        if (adVarA != null) {
            adVarA.a();
        }
        if (adVarA != null && !adVarA.a()) {
            bvVar.a(adVarA, 0, 2, 1);
            p pVarA = u.a(bvVar);
            ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
            if (aTBaseAdAdapter != null && aTBaseAdAdapter.internalInitNetworkObjectByPlacementId(context, lVar.a(str, str2, bvVar, aTAdRequest), map)) {
                a aVar2 = new a();
                aVar2.c = aTBaseAdAdapter;
                aVar2.b = bvVar;
                this.c.put(str, aVar2);
                return aVar2;
            }
        }
        return null;
    }

    public final synchronized com.anythink.core.common.h.c a(String str) {
        a aVar;
        com.anythink.core.common.h.c cVarE;
        if (TextUtils.isEmpty(str) || (aVar = this.c.get(str)) == null || aVar.c == null || (cVarE = aVar.e()) == null || !cVarE.k()) {
            return null;
        }
        com.anythink.core.common.v.p.a(aVar.d());
        return cVarE;
    }

    public final synchronized void a(String str, String str2) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = this.c.get(str)) != null && aVar.b != null && aVar.b.z().equals(str2)) {
            aVar.c();
            this.c.remove(str);
        }
    }

    public class a {
        private bv b;
        private ATBaseAdAdapter c;
        private BaseAd d;
        private com.anythink.core.common.h.c e;
        private String f;
        private com.anythink.core.common.h.n g;

        public a() {
        }

        public final synchronized void a(String str, com.anythink.core.common.h.n nVar) {
            String unused = c.this.a;
            this.f = str;
            this.g = nVar;
        }

        public final synchronized com.anythink.core.common.h.c a() {
            boolean zInternalIsAdReady;
            String unused = c.this.a;
            ATBaseAdAdapter aTBaseAdAdapter = this.c;
            com.anythink.core.common.h.n nVar = this.g;
            if (aTBaseAdAdapter == null) {
                return null;
            }
            if (nVar == null) {
                return null;
            }
            com.anythink.core.common.h.c cVar = this.e;
            if (cVar != null) {
                if (!cVar.k()) {
                    String unused2 = c.this.a;
                    return null;
                }
                String unused3 = c.this.a;
                return this.e;
            }
            this.d = null;
            if (TextUtils.equals(nVar.aK(), "0")) {
                BaseAd baseAdObject = this.c.getBaseAdObject(t.b().g());
                this.d = baseAdObject;
                zInternalIsAdReady = baseAdObject != null;
            } else {
                zInternalIsAdReady = this.c.internalIsAdReady();
            }
            String unused4 = c.this.a;
            if (zInternalIsAdReady) {
                this.g.L(12);
                this.g.m(ak.a(this.b, this.c));
                aj.a(this.c, this.g, this.b);
                BaseAd baseAd = this.d;
                if (baseAd != null) {
                    baseAd.setTrackingInfo(this.c.getTrackingInfo().af());
                }
                this.b.R().b(this.f);
                com.anythink.core.b.d.c.a(this.c, this.b, this.g, this.d);
                com.anythink.core.common.h.c cVar2 = new com.anythink.core.common.h.c();
                this.e = cVar2;
                cVar2.a(this.c);
                this.e.c(System.currentTimeMillis());
                this.e.b(this.b.u());
                this.e.a(this.b.G());
                this.e.a("3");
                BaseAd baseAd2 = this.d;
                if (baseAd2 != null) {
                    this.e.a(baseAd2);
                }
            }
            return this.e;
        }

        public final synchronized boolean b() {
            String unused = c.this.a;
            ATBaseAdAdapter aTBaseAdAdapter = this.c;
            com.anythink.core.common.h.n nVar = this.g;
            return a() != null;
        }

        public final synchronized void c() {
            String unused = c.this.a;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        private com.anythink.core.common.h.n f() {
            return this.g;
        }

        public final bv d() {
            return this.b;
        }

        public final synchronized com.anythink.core.common.h.c e() {
            return this.e;
        }
    }
}
