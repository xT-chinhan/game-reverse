package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.bv;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static f e;
    ConcurrentHashMap<String, Integer> b;
    private MediationBidManager f;
    private final String d = getClass().getSimpleName();
    ConcurrentHashMap<String, ad> a = new ConcurrentHashMap<>();
    List<Integer> c = new CopyOnWriteArrayList();

    private f() {
    }

    public static f a() {
        if (e == null) {
            e = new f();
        }
        return e;
    }

    private void a(String str, bv bvVar, ad adVar) {
        this.a.put(str + adVar.k, adVar);
        if (bvVar.am()) {
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

    public final ad a(String str, bv bvVar) {
        ad adVarA = this.a.get(str + bvVar.z());
        if (bvVar.am() && adVarA == null) {
            adVarA = com.anythink.core.common.a.a.a().a(str, bvVar.z());
            if (adVarA != null) {
                bvVar.toString();
                this.a.put(str + bvVar.z(), adVarA);
            } else {
                bvVar.toString();
            }
        }
        return adVarA;
    }

    public final void a(MediationBidManager mediationBidManager) {
        this.f = mediationBidManager;
    }

    public final MediationBidManager b() {
        return this.f;
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
