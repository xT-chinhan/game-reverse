package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.by;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    ConcurrentHashMap<String, Integer> b;
    private final com.anythink.core.common.f f;
    private final String e = getClass().getSimpleName();
    ConcurrentHashMap<String, ad> a = new ConcurrentHashMap<>();
    final List<Integer> c = new CopyOnWriteArrayList();
    ConcurrentHashMap<String, com.anythink.core.c.c.a> d = new ConcurrentHashMap<>();

    public f(com.anythink.core.common.f fVar) {
        this.f = fVar;
    }

    private void a(String str, by byVar, ad adVar) {
        this.a.put(str + adVar.k, adVar);
        if (byVar.at()) {
            com.anythink.core.common.a.a.a().a(str, adVar);
        }
    }

    public final void a(String str, ad adVar) {
        ad adVar2;
        if (adVar == null || (adVar2 = this.a.get(str + adVar.k)) == null || !TextUtils.equals(adVar.token, adVar2.token)) {
            return;
        }
        this.a.remove(str + adVar.k);
    }

    public final ad a(String str, by byVar) {
        ad adVarA = this.a.get(str + byVar.G());
        if (byVar.at() && adVarA == null && (adVarA = com.anythink.core.common.a.a.a().a(str, byVar.G())) != null) {
            this.a.put(str + byVar.G(), adVarA);
        }
        if (adVarA != null && adVarA.commonAdManager == null) {
            adVarA.setCommonAdManager(this.f);
        }
        return adVarA;
    }

    public final com.anythink.core.c.c.a b(String str, by byVar) {
        com.anythink.core.c.c.a aVar = this.d.get(str + byVar.G());
        if (aVar == null) {
            return null;
        }
        if (!aVar.d()) {
            return aVar;
        }
        a(str, byVar, aVar);
        return null;
    }

    private void b(String str, by byVar, com.anythink.core.c.c.a aVar) {
        long jA = byVar.A();
        if (jA <= 0) {
            jA = com.anythink.core.common.g.c.a;
        }
        aVar.a(System.currentTimeMillis() + jA);
        this.d.put(str + byVar.G(), aVar);
    }

    public final boolean a(String str, by byVar, com.anythink.core.c.c.a aVar) {
        com.anythink.core.c.c.a aVar2 = this.d.get(str + byVar.G());
        if (aVar2 == null || aVar2 != aVar) {
            return false;
        }
        this.d.remove(str + byVar.G());
        return true;
    }

    private void a(String str) {
        if (this.b == null) {
            this.b = new ConcurrentHashMap<>();
        }
        this.b.put(str + "_c2sfirstStatus", 1);
    }

    private boolean b(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.b;
        return concurrentHashMap == null || concurrentHashMap.get(new StringBuilder().append(str).append("_c2sfirstStatus").toString()) == null;
    }

    public final void a(int i) {
        synchronized (this.c) {
            if (!this.c.contains(Integer.valueOf(i))) {
                this.c.add(Integer.valueOf(i));
            }
        }
    }

    public final boolean b(int i) {
        boolean z;
        synchronized (this.c) {
            z = !this.c.contains(Integer.valueOf(i));
        }
        return z;
    }
}
