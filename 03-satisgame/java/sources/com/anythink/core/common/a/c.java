package com.anythink.core.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.bz;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.p;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.t;
import com.anythink.core.e.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final String a = getClass().getSimpleName();
    private final Map<String, a> b = new ConcurrentHashMap();
    private final com.anythink.core.common.f c;

    public c(com.anythink.core.common.f fVar) {
        this.c = fVar;
    }

    public final a a(Context context, String str, String str2, by byVar, l lVar, Map<String, Object> map, ATAdRequest aTAdRequest) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
        if (!(bVarB == null || bVarB.J() || bVarB.m() == 1) || byVar == null) {
            return null;
        }
        com.anythink.core.common.f fVar = this.c;
        bz bzVarA = (fVar == null || fVar.e() == null) ? null : this.c.e().a(str, byVar);
        if (bzVarA != null && bzVarA.a((ad) null).b() != null) {
            return null;
        }
        a aVar = this.b.get(str);
        if (aVar != null && aVar.c != null) {
            return aVar;
        }
        com.anythink.core.common.f fVar2 = this.c;
        ad adVarA = (fVar2 == null || fVar2.f() == null) ? null : this.c.f().a(str, byVar);
        if (adVarA != null && !adVarA.a()) {
            byVar.a(adVarA, 0, 2, 1);
            p pVarA = t.a(byVar);
            ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
            if (aTBaseAdAdapter != null && aTBaseAdAdapter.internalInitNetworkObjectByPlacementId(context, lVar.a(str, str2, byVar, aTAdRequest), map)) {
                a aVar2 = new a();
                aVar2.c = aTBaseAdAdapter;
                aVar2.b = byVar;
                this.b.put(str, aVar2);
                return aVar2;
            }
        }
        return null;
    }

    public final synchronized com.anythink.core.common.h.c a(String str) {
        a aVar;
        com.anythink.core.common.h.c cVarE;
        if (TextUtils.isEmpty(str) || (aVar = this.b.get(str)) == null || aVar.c == null || (cVarE = aVar.e()) == null || !cVarE.k()) {
            return null;
        }
        return cVarE;
    }

    public final synchronized void a(String str, String str2) {
        a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = this.b.get(str)) != null && aVar.b != null && aVar.b.G().equals(str2)) {
            aVar.c();
            this.b.remove(str);
        }
    }

    public class a {
        private by b;
        private ATBaseAdAdapter c;
        private BaseAd d;
        private com.anythink.core.common.h.c e;
        private String f;
        private n g;

        public a() {
        }

        public final synchronized void a(String str, n nVar) {
            this.f = str;
            this.g = nVar;
        }

        public final synchronized com.anythink.core.common.h.c a() {
            boolean zInternalIsAdReady;
            if (this.c == null) {
                return null;
            }
            n nVar = this.g;
            if (nVar == null) {
                return null;
            }
            com.anythink.core.common.h.c cVar = this.e;
            if (cVar != null) {
                if (cVar.k()) {
                    return this.e;
                }
                return null;
            }
            this.d = null;
            if (TextUtils.equals(nVar.aS(), "0")) {
                BaseAd baseAdObject = this.c.getBaseAdObject(s.b().g());
                this.d = baseAdObject;
                zInternalIsAdReady = baseAdObject != null;
            } else {
                zInternalIsAdReady = this.c.internalIsAdReady();
            }
            if (zInternalIsAdReady) {
                this.g.L(12);
                this.g.m(aj.a(this.b, this.c));
                ai.a(this.c, this.g, this.b);
                BaseAd baseAd = this.d;
                if (baseAd != null) {
                    baseAd.setTrackingInfo(this.c.getTrackingInfo().ah());
                }
                this.b.Y().b(this.f);
                com.anythink.core.c.d.c.a(this.c, this.b, this.g, this.d);
                com.anythink.core.common.h.c cVar2 = new com.anythink.core.common.h.c();
                this.e = cVar2;
                cVar2.a(this.c);
                this.e.c(System.currentTimeMillis());
                this.e.b(aj.c(this.b));
                this.e.a(this.b.N());
                this.e.a("3");
                BaseAd baseAd2 = this.d;
                if (baseAd2 != null) {
                    this.e.a(baseAd2);
                }
            }
            return this.e;
        }

        public final synchronized boolean b() {
            return a() != null;
        }

        public final synchronized void c() {
            this.c = null;
            this.d = null;
            this.e = null;
        }

        private n f() {
            return this.g;
        }

        public final by d() {
            return this.b;
        }

        public final synchronized com.anythink.core.common.h.c e() {
            return this.e;
        }
    }
}
