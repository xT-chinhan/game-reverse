package com.bytedance.sdk.component.ms;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
class ab implements b.ms {
    private final zb ab;
    private final com.bytedance.sdk.component.ms.ms ch;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final x f1246ms;
    private final boolean ny;
    private final boolean x;
    private final t xr;
    private final Map<String, xr> ah = new HashMap();
    private final Map<String, d.xr> d = new HashMap();
    private final List<ao> ka = new ArrayList();
    private final Set<d> c = new HashSet();

    ab(ch chVar, com.bytedance.sdk.component.ms.ms msVar, nw nwVar) {
        this.ch = msVar;
        this.f1246ms = chVar.d;
        t tVar = new t(nwVar, chVar.sl, chVar.zb);
        this.xr = tVar;
        tVar.ms(this);
        tVar.ms(chVar.ao);
        this.ab = chVar.ny;
        this.x = chVar.x;
        this.ny = chVar.ub;
    }

    ms ms(ao aoVar, c cVar) throws Exception {
        xr xrVar = this.ah.get(aoVar.d);
        if (xrVar != null) {
            try {
                re reVarXr = xr(cVar.xr, xrVar);
                cVar.d = reVarXr;
                if (reVarXr == null) {
                    ny.ms("Permission denied, call: ".concat(String.valueOf(aoVar)));
                    throw new qv(-1);
                }
                if (xrVar instanceof ka) {
                    ny.ms("Processing stateless call: ".concat(String.valueOf(aoVar)));
                    return ms(aoVar, (ka) xrVar, cVar);
                }
                if (xrVar instanceof ah) {
                    ny.ms("Processing raw call: ".concat(String.valueOf(aoVar)));
                    return ms(aoVar, (ah) xrVar, reVarXr);
                }
            } catch (nw.ms e) {
                ny.ms("No remote permission config fetched, call pending: ".concat(String.valueOf(aoVar)), e);
                this.ka.add(aoVar);
                return new ms(false, i.ms());
            }
        }
        d.xr xrVar2 = this.d.get(aoVar.d);
        if (xrVar2 != null) {
            d dVarMs = xrVar2.ms();
            dVarMs.ms(aoVar.d);
            re reVarXr2 = xr(cVar.xr, dVarMs);
            cVar.d = reVarXr2;
            if (reVarXr2 == null) {
                ny.ms("Permission denied, call: ".concat(String.valueOf(aoVar)));
                dVarMs.ka();
                throw new qv(-1);
            }
            ny.ms("Processing stateful call: ".concat(String.valueOf(aoVar)));
            return ms(aoVar, dVarMs, cVar);
        }
        ny.xr("Received call: " + aoVar + ", but not registered.");
        return null;
    }

    void ms(String str, ka<?, ?> kaVar) {
        kaVar.ms(str);
        this.ah.put(str, kaVar);
        ny.ms("JsBridge stateless method registered: ".concat(String.valueOf(str)));
    }

    void ms(String str, d.xr xrVar) {
        this.d.put(str, xrVar);
        ny.ms("JsBridge stateful method registered: ".concat(String.valueOf(str)));
    }

    void ms() {
        Iterator<d> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.c.clear();
        this.ah.clear();
        this.d.clear();
        this.xr.xr(this);
    }

    private ms ms(ao aoVar, ka kaVar, c cVar) throws Exception {
        return new ms(true, i.ms(this.f1246ms.ms(kaVar.ms(ms(aoVar.ka, (xr) kaVar), cVar))));
    }

    private ms ms(final ao aoVar, final d dVar, c cVar) throws Exception {
        this.c.add(dVar);
        dVar.ms(ms(aoVar.ka, dVar), cVar, new d.ms() { // from class: com.bytedance.sdk.component.ms.ab.1
            @Override // com.bytedance.sdk.component.ms.d.ms
            public void ms(Object obj) {
                if (ab.this.ch == null) {
                    return;
                }
                ab.this.ch.xr(i.ms(ab.this.f1246ms.ms(obj)), aoVar);
                ab.this.c.remove(dVar);
            }

            @Override // com.bytedance.sdk.component.ms.d.ms
            public void ms(Throwable th) {
                if (ab.this.ch == null) {
                    return;
                }
                ab.this.ch.xr(i.ms(th), aoVar);
                ab.this.c.remove(dVar);
            }
        });
        return new ms(false, i.ms());
    }

    private ms ms(final ao aoVar, ah ahVar, re reVar) throws Exception {
        new y(aoVar.d, reVar, new y.ms() { // from class: com.bytedance.sdk.component.ms.ab.2
        });
        return new ms(false, i.ms());
    }

    private Object ms(String str, xr xrVar) throws JSONException {
        return this.f1246ms.ms(str, ms(xrVar)[0]);
    }

    private re xr(String str, xr xrVar) {
        if (this.ny) {
            return re.PRIVATE;
        }
        return this.xr.ms(this.x, str, xrVar);
    }

    private static Type[] ms(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1249ms;
        String xr;

        private ms(boolean z, String str) {
            this.f1249ms = z;
            this.xr = str;
        }
    }
}
